package com.Relacional.Cliente.service;

import com.Relacional.Cliente.exception.BusinessExeption;
import com.Relacional.Cliente.model.dtos.ClienteRequest;
import com.Relacional.Cliente.model.dtos.ClienteResponse;
import com.Relacional.Cliente.model.entity.Cliente;
import com.Relacional.Cliente.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public ClienteResponse save(ClienteRequest clienteRequest) {
        if (repository.existsByDocument(clienteRequest.getDocument())) {
            throw new BusinessExeption("O CPF utilizado, já esta cadastrado!!");
        }
        return ClienteResponse.from(repository.save(clienteRequest.toModel()));
    }

    public ClienteResponse findByDocument(String document) {
        Cliente cliente = repository.findByDocument(document).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Não foi possivel encontrar este cliente"));
        return ClienteResponse.from((cliente));
    }


    public List<ClienteResponse> listCliente() {
        return repository.findAll()
                .stream().map(ClienteResponse::from)
                .collect(Collectors.toList());
    }

    public void findByRemove(UUID id) {
        Optional<Cliente> byId = repository.findById(id);
        if (byId.isPresent()) {
            Cliente cliente = byId.get();
            removeId(cliente.getId());
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado");
        }
    }

    public void removeId(UUID id) {
        repository.deleteById(id);
    }


}



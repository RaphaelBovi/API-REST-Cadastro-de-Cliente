package com.Relacional.Cliente.Controller;

import com.Relacional.Cliente.model.dtos.ClienteRequest;
import com.Relacional.Cliente.model.dtos.ClienteResponse;
import com.Relacional.Cliente.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RestController
@RequestMapping(value = "/api/cliente")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClienteResponse save(@RequestBody ClienteRequest cliente) {
        return this.service.save(cliente);
    }

    @GetMapping("/{document}")
    @ResponseStatus(HttpStatus.OK)
    public ClienteResponse findByDocument(@PathVariable String document) {
        return this.service.findByDocument(document);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ClienteResponse> findAll() {
        return this.service.listCliente();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeCliente(@PathVariable("id") UUID id) {
        service.findByRemove(id);
    }

}

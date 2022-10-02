package com.Relacional.Cliente.model.dtos;

import com.Relacional.Cliente.model.entity.Cliente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ClienteResponse {

    private UUID id;

    private String name;

    private String document;

    public static ClienteResponse from(Cliente cliente) {
        return new ClienteResponse(
                cliente.getId(),
                cliente.getName(),
                cliente.getDocument()
        );
    }
}

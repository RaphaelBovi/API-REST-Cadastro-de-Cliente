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
public class ClienteRequest {

    private UUID id;

    private String name;

    private String document;

    public Cliente toModel() {
        return new Cliente(this.name, this.document);
    }

}

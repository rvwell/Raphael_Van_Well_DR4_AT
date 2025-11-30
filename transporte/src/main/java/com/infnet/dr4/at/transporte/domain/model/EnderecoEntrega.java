package com.infnet.dr4.at.transporte.domain.model;


import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoEntrega {
    private String logradouro;
    private String cep;
    private String cidade;
    private String estado;
}

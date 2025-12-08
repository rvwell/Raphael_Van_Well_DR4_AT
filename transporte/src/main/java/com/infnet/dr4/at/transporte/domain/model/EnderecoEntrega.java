package com.infnet.dr4.at.transporte.domain.model;


import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@EqualsAndHashCode
@NoArgsConstructor
public class EnderecoEntrega {

    private String logradouro;
    private String numero;
    private String cep;
    private String cidade;
    private String estado;

    public EnderecoEntrega(String logradouro, String numero, String cep, String cidade, String estado) {
        if (cep == null || !cep.matches("\\d{8}")) {
            throw new IllegalArgumentException("CEP inválido");
        }
        this.logradouro = logradouro;
        this.numero = numero;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
    }
}

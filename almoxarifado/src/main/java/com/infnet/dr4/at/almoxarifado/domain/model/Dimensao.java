package com.infnet.dr4.at.almoxarifado.domain.model;

import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Embeddable
@Getter
@EqualsAndHashCode
@NoArgsConstructor
public class Dimensao {

    private BigDecimal altura;
    private BigDecimal largura;
    private BigDecimal profundidade;
    private BigDecimal peso;

    public Dimensao(BigDecimal altura, BigDecimal largura, BigDecimal profundidade, BigDecimal peso) {
        if (altura.compareTo(BigDecimal.ZERO) <= 0 || peso.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Dimensões e peso devem ser maiores que zero");
        }
        this.altura = altura;
        this.largura = largura;
        this.profundidade = profundidade;
        this.peso = peso;
    }
}

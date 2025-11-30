package com.infnet.dr4.at.almoxarifado.domain.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Embeddable
public class LocalizacaoEstoque {

    private String corredor;
    private String prateleira;
    private Integer nivel;
}

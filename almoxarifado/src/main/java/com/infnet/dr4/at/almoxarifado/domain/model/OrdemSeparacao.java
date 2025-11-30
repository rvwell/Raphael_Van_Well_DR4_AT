package com.infnet.dr4.at.almoxarifado.domain.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

public class OrdemSeparacao {

    @Id
    private UUID id;

    private UUID pedidoId;

    @Enumerated(EnumType.STRING)
    private StatusSeparacao status;

    @Embedded
    private LocalizacaoEstoque localizacaoDestino;

    @ElementCollection
    private List<String> itensSku;

    public OrdemSeparacao(UUID pedidoOriginalId, List<String> itensSku) {
        this.id = UUID.randomUUID();
        this.pedidoId = pedidoOriginalId;
        this.itensSku = itensSku;
        this.status = StatusSeparacao.PENDENTE;
    }

    public enum StatusSeparacao { PENDENTE, EM_EXECUCAO, CONCLUIDO }
}

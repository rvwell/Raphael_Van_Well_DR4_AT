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

    @ElementCollection
    @CollectionTable(
            name = "itens_separacao",
            joinColumns = @JoinColumn(name = "ordem_separacao_id")
    )
    private List<ItemSeparacao> itens;

    public OrdemSeparacao(UUID pedidoOriginalId, List<ItemSeparacao> itens) {
        this.id = UUID.randomUUID();
        this.pedidoId = pedidoOriginalId;
        this.itens = itens;
        this.status = StatusSeparacao.PENDENTE;
    }

    public enum StatusSeparacao { PENDENTE, EM_EXECUCAO, CONCLUIDO }
}

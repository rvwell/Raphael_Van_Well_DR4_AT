package com.infnet.dr4.at.transporte.domain.model;

import jakarta.persistence.Embedded;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;

import java.util.UUID;

public class Entrega {

    @Id
    private UUID id;

    private UUID pedidoId;

    @Embedded
    private EnderecoEntrega enderecoDestino;

    @Enumerated(EnumType.STRING)
    private StatusEntrega status;

    public Entrega(UUID pedidoId, EnderecoEntrega enderecoDestino) {
        this.id = UUID.randomUUID();
        this.pedidoId = pedidoId;
        this.enderecoDestino = enderecoDestino;
        this.status = StatusEntrega.AGUARDANDO_COLETA;
    }

    public enum StatusEntrega { AGUARDANDO_COLETA, EM_TRANSITO, ENTREGUE }
}

package com.infnet.dr4.at.transporte.domain.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

public class Entrega {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private UUID pedidoId;

    @Enumerated(EnumType.STRING)
    private StatusEntrega status;

    @Embedded
    private EnderecoEntrega enderecoDestino;

    private LocalDateTime dataDespacho;
    private LocalDateTime dataAtualizacao;

    public Entrega(UUID pedidoId, EnderecoEntrega endereco) {
        this.pedidoId = pedidoId;
        this.enderecoDestino = endereco;
        this.status = StatusEntrega.AGUARDANDO_COLETA;
        this.dataDespacho = LocalDateTime.now();
    }

    public void registrarRecebimento() {
        this.status = StatusEntrega.ENTREGUE;
        atualizarData();
    }

    public void envio() {
        this.status = StatusEntrega.EM_TRANSITO;
        atualizarData();
    }


    private void atualizarData() {
        this.dataAtualizacao = LocalDateTime.now();
    }
}

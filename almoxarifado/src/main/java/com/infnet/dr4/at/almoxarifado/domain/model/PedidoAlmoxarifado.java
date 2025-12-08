package com.infnet.dr4.at.almoxarifado.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "pedido_almoxarifado")
@Getter
@ToString
@NoArgsConstructor
public class PedidoAlmoxarifado {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private UUID pedidoOriginalId;

    @Enumerated(EnumType.STRING)
    private StatusAlmoxarifado status;

    @Embedded
    private Dimensao dimensaoDoPacote;

    private LocalDateTime dataPreparacao;

    public PedidoAlmoxarifado(UUID pedidoOriginalId) {
        this.pedidoOriginalId = pedidoOriginalId;
        this.status = StatusAlmoxarifado.EM_PREPARACAO;
        this.dataPreparacao = LocalDateTime.now();
    }

    public void finalizarPreparacao(Dimensao dimensao) {
        if (this.status != StatusAlmoxarifado.EM_PREPARACAO) {
            throw new IllegalStateException("Apenas pedidos em preparação podem ser finalizados.");
        }
        this.dimensaoDoPacote = dimensao;
    }

    public void cancelarPedido() {
        if (this.status == StatusAlmoxarifado.DESPACHADO) {
            throw new IllegalStateException("Não é possível cancelar um pedido já despachado.");
        }
        this.status = StatusAlmoxarifado.CANCELADO;
    }
}

package com.infnet.dr4.at.almoxarifado.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoFechadoEvent {
    private UUID pedidoId;
    private Long clienteId;
}

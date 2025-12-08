package com.infnet.dr4.at.almoxarifado.events;

import com.infnet.dr4.at.almoxarifado.domain.dto.ItemDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoFechadoEvent {
    private UUID pedidoId;
    private Long clienteId;
}

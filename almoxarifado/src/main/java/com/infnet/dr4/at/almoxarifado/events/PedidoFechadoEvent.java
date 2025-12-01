package com.infnet.dr4.at.almoxarifado.events;

import com.infnet.dr4.at.almoxarifado.domain.dto.ItemDTO;
import lombok.Data;

import java.util.List;

@Data
public class PedidoFechadoEvent {
    private String pedidoId;
    private List<ItemDTO> itens;
}

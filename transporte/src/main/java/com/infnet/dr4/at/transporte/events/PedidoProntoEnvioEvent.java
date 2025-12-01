package com.infnet.dr4.at.transporte.events;

import com.infnet.dr4.at.transporte.domain.dto.EnderecoDTO;
import lombok.Data;

@Data
public class PedidoProntoEnvioEvent {

    private String pedidoId;
    private EnderecoDTO endereco;
}

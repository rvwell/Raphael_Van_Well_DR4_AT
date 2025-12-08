package com.infnet.dr4.at.transporte.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoProntoEnvioEvent {

    private UUID pedidoId;

    private String logradouro;
    private String numero;
    private String cep;
    private String cidade;
    private String estado;

}

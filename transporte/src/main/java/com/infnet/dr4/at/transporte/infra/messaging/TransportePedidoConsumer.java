package com.infnet.dr4.at.transporte.infra.messaging;

import com.infnet.dr4.at.almoxarifado.events.PedidoFechadoEvent;
import com.infnet.dr4.at.transporte.domain.model.EnderecoEntrega;
import com.infnet.dr4.at.transporte.domain.model.Entrega;
import com.infnet.dr4.at.transporte.events.PedidoProntoEnvioEvent;
import com.infnet.dr4.at.transporte.infra.EntregaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class TransportePedidoConsumer {

    private final EntregaRepository repository;

    @Bean
    public Consumer<PedidoProntoEnvioEvent> prepararLogisticaEntrega() {
        return event -> {
            log.info("Iniciando logística para o pedido: {}", event.getPedidoId());

            try {
                EnderecoEntrega enderecoDestino = new EnderecoEntrega(
                        event.getLogradouro(),
                        event.getNumero(),
                        event.getCep(),
                        event.getCidade(),
                        event.getEstado()
                );

                Entrega novaEntrega = new Entrega(event.getPedidoId(), enderecoDestino);

                repository.save(novaEntrega);

                log.info("Entrega criada com sucesso para o pedido {}", event.getPedidoId());

            } catch (IllegalArgumentException e) {
                log.error("Erro ao processar dados de entrega para pedido {}: {}", event.getPedidoId(), e.getMessage());
            }
        };
    }
}

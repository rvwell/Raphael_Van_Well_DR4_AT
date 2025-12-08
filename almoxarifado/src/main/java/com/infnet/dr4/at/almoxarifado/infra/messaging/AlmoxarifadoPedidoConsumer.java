package com.infnet.dr4.at.almoxarifado.infra.messaging;

import com.infnet.dr4.at.almoxarifado.domain.model.PedidoAlmoxarifado;
import com.infnet.dr4.at.almoxarifado.events.PedidoFechadoEvent;
import com.infnet.dr4.at.almoxarifado.infra.PedidoAlmoxarifadoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class AlmoxarifadoPedidoConsumer {

    private final PedidoAlmoxarifadoRepository repository;

    @Bean
    public Consumer<PedidoFechadoEvent> processarPedidoFechado() {
        return event -> {
            log.info("Recebido evento de pedido fechado ID: {}", event.getPedidoId());

            PedidoAlmoxarifado novoPedido = new PedidoAlmoxarifado(event.getPedidoId());

            repository.save(novoPedido);

            log.info("Pedido {} registrado no Almoxarifado com sucesso.", event.getPedidoId());
        };
    }

}

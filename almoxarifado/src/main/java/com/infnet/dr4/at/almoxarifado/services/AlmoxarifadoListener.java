package com.infnet.dr4.at.almoxarifado.services;

import com.infnet.dr4.at.almoxarifado.domain.model.ItemSeparacao;
import com.infnet.dr4.at.almoxarifado.domain.model.LocalizacaoEstoque;
import com.infnet.dr4.at.almoxarifado.domain.model.OrdemSeparacao;
import com.infnet.dr4.at.almoxarifado.events.PedidoFechadoEvent;
import com.infnet.dr4.at.almoxarifado.infra.OrdemSeparacaoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.function.Consumer;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class AlmoxarifadoListener {

    private final OrdemSeparacaoRepository repository;

    @Bean
    public Consumer<PedidoFechadoEvent> processarPedidoFechado() {
        return event -> {
            log.info("Novo pedido recebido para separação: {}", event.getPedidoId());

            List<ItemSeparacao> itensComLocalizacao = event.getItens().stream()
                    .map(itemDto -> {
                        LocalizacaoEstoque loc = buscarLocalizacao(itemDto.sku());
                        return new ItemSeparacao();
                    })
                    .collect(Collectors.toList());

            OrdemSeparacao novaOrdem = new OrdemSeparacao(
                    UUID.fromString(event.getPedidoId()),
                    itensComLocalizacao
            );

            repository.save(novaOrdem);
        };
    }

    private LocalizacaoEstoque buscarLocalizacao(String sku) {
        int hash = Math.abs(sku.hashCode());
        String corredor = "C" + (hash % 10);
        String prateleira = "P" + (hash % 50);
        Integer nivel = (hash % 5) + 1;

        return new LocalizacaoEstoque(corredor, prateleira, nivel);
    }

}

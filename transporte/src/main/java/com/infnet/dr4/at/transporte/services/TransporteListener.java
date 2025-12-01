package com.infnet.dr4.at.transporte.services;

import com.infnet.dr4.at.transporte.domain.dto.EnderecoDTO;
import com.infnet.dr4.at.transporte.domain.model.EnderecoEntrega;
import com.infnet.dr4.at.transporte.domain.model.Entrega;
import com.infnet.dr4.at.transporte.events.PedidoProntoEnvioEvent;
import com.infnet.dr4.at.transporte.infra.EntregaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.function.Consumer;

@Slf4j
@Service
@RequiredArgsConstructor
public class TransporteListener {

    private final EntregaRepository repository;

    @Bean
    public Consumer<PedidoProntoEnvioEvent> processarSolicitacaoEntrega() {
        return event -> {
            log.info("Solicitação de entrega recebida: {}", event.getPedidoId());

            var endDTO = event.getEndereco();
            EnderecoEntrega endereco = new EnderecoEntrega(
                    endDTO.logradouro(),
                    endDTO.cep(),
                    endDTO.cidade(),
                    endDTO.estado()
            );

            Entrega entrega = new Entrega(UUID.fromString(event.getPedidoId()), endereco);
            repository.save(entrega);
        };
    }

}

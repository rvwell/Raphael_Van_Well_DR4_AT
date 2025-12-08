package com.infnet.dr4.at.transporte.infra;

import com.infnet.dr4.at.transporte.domain.model.Entrega;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EntregaRepository extends JpaRepository<Entrega, UUID> {
    Entrega findByPedidoId(UUID pedidoId);
}

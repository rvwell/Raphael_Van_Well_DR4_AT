package com.infnet.dr4.at.almoxarifado.infra;

import com.infnet.dr4.at.almoxarifado.domain.model.PedidoAlmoxarifado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PedidoAlmoxarifadoRepository extends JpaRepository<PedidoAlmoxarifado, UUID> {
}

package com.infnet.dr4.at.almoxarifado.infra;

import com.infnet.dr4.at.almoxarifado.domain.model.OrdemSeparacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OrdemSeparacaoRepository extends JpaRepository<OrdemSeparacao, UUID> {
}

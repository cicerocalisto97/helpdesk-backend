package com.calisto.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.calisto.helpdesk.domain.Chamado;

public interface ChamadoRepository extends JpaRepository<Chamado, Integer> {

}

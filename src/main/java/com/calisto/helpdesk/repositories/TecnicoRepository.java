package com.calisto.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.calisto.helpdesk.domain.Tecnico;

public interface TecnicoRepository extends JpaRepository<Tecnico, Integer> {

}

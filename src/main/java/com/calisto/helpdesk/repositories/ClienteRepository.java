package com.calisto.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.calisto.helpdesk.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}

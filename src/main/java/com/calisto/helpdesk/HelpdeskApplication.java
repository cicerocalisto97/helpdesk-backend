package com.calisto.helpdesk;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.calisto.helpdesk.domain.Chamado;
import com.calisto.helpdesk.domain.Cliente;
import com.calisto.helpdesk.domain.Tecnico;
import com.calisto.helpdesk.domain.enums.Perfil;
import com.calisto.helpdesk.domain.enums.Prioridade;
import com.calisto.helpdesk.domain.enums.Status;
import com.calisto.helpdesk.repositories.ChamadoRepository;
import com.calisto.helpdesk.repositories.ClienteRepository;
import com.calisto.helpdesk.repositories.TecnicoRepository;

@SpringBootApplication
public class HelpdeskApplication implements CommandLineRunner {
	
	@Autowired
	private TecnicoRepository tecnicoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ChamadoRepository chamadoRepository;

	public static void main(String[] args) {
		SpringApplication.run(HelpdeskApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Tecnico tec1 = new Tecnico(null, "Cicero Calisto", "42480376885", "cicero.calisto97@gmail.com", "1234");
		tec1.addPerfil(Perfil.ADMIN);
		
		Cliente cli1 = new Cliente(null, "Antonio Carlos Rosa", "20494262087", "antonio.carlos@gmail.com", "4321");
		
		Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 01", "Primeiro Chamado", tec1, cli1);
		
		tecnicoRepository.saveAll(Arrays.asList(tec1));
		clienteRepository.saveAll(Arrays.asList(cli1));
		chamadoRepository.saveAll(Arrays.asList(c1));
		
	}

}

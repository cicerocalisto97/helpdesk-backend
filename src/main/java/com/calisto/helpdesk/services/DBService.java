package com.calisto.helpdesk.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.calisto.helpdesk.domain.Chamado;
import com.calisto.helpdesk.domain.Cliente;
import com.calisto.helpdesk.domain.Tecnico;
import com.calisto.helpdesk.domain.enums.Perfil;
import com.calisto.helpdesk.domain.enums.Prioridade;
import com.calisto.helpdesk.domain.enums.Status;
import com.calisto.helpdesk.repositories.ChamadoRepository;
import com.calisto.helpdesk.repositories.PessoaRepository;

@Service
public class DBService {
	
	@Autowired
	private ChamadoRepository chamadoRepository;
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;

	public void instanciaDB() {
		Tecnico tec1 = new Tecnico(null, "Cicero Calisto", "550.482.150-95", "cicero@mail.com", encoder.encode("1234"));
		tec1.addPerfil(Perfil.ADMIN);
		Tecnico tec2 = new Tecnico(null, "José Augusto Barbosa", "903.347.070-56", "jose@mail.com", encoder.encode("1234"));
		Tecnico tec3 = new Tecnico(null, "Sergio Paulo Boaventura", "271.068.470-54", "sergio@mail.com", encoder.encode("1234"));
		Tecnico tec4 = new Tecnico(null, "Marcelo Silva Junior", "162.720.120-39", "marcelo@mail.com", encoder.encode("1234"));
		Tecnico tec5 = new Tecnico(null, "Kaique Santana", "778.556.170-27", "kaike@mail.com", encoder.encode("1234"));
		Tecnico tec6 = new Tecnico(null, "Maria de Lourdes Aguiar", "515.652.300-51", "maria@mail.com", encoder.encode("1234"));

		Cliente cli1 = new Cliente(null, "Silvana Ferreira", "111.661.890-74", "silvana@mail.com", encoder.encode("1234"));
		Cliente cli2 = new Cliente(null, "Joao Calisto", "322.429.140-06", "joao@mail.com", encoder.encode("1234"));
		Cliente cli3 = new Cliente(null, "Daniel Rosa", "792.043.830-62", "daniel@mail.com", encoder.encode("1234"));
		Cliente cli4 = new Cliente(null, "Maria Clara Nascimento", "177.409.680-30", "clara@mail.com", encoder.encode("1234"));
		Cliente cli5 = new Cliente(null, "Lurdes Dias", "081.399.300-83", "lurdes@mail.com", encoder.encode("1234"));
 
		Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Troca de Fonte de notebook", "Trocar fonte de notebook", tec1, cli1);
		Chamado c2 = new Chamado(null, Prioridade.ALTA, Status.ABERTO, "Instalar Windows 10 em desktop", "Formatar com Windows 10", tec1, cli2);
		Chamado c3 = new Chamado(null, Prioridade.BAIXA, Status.ENCERRADO, "Instalar Antivírus Avast", "Instalar Avast no PC", tec2, cli3);
		Chamado c4 = new Chamado(null, Prioridade.ALTA, Status.ABERTO, "Troca de HD", "Trocar HD queimando por um novo", tec3, cli3);
		Chamado c5 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Montar PC", "Montar micro com tecnologia AMD", tec2, cli1);
		Chamado c6 = new Chamado(null, Prioridade.BAIXA, Status.ENCERRADO, "Vender PC", "Colocar PC para venda", tec1, cli5);

		pessoaRepository.saveAll(Arrays.asList(tec1, tec2, tec3, tec4, tec5, cli1, cli2, cli3, cli4, cli5));
		chamadoRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c5, c6));
	}
	
}

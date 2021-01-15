package com.prjlojaunitandrebarros.mvc.controller;

import java.util.Date;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.prjlojaunitandrebarros.mvc.repository.*;
import com.prjlojaunitandrebarros.mvc.controller.*;
import com.prjlojaunitandrebarros.mvc.model.*;
import com.prjlojaunitandrebarros.*;

@Controller
@RequestMapping(path="/clientes")
public class ClientesController {
	@Autowired
	private ClientesRepository clientesRepo;

	@PostMapping(path="/criar")
	public @ResponseBody String criarClientes (

			@RequestParam String nome,
			@RequestParam String cpf,
			@RequestParam String email,
			@RequestParam Date dataNascimento,
			@RequestParam String sexo,
			@RequestParam String nomeSocial,
			@RequestParam String apelido,
			@RequestParam String telefone
			) {


		Clientes clientes = new Clientes();
		clientes.setNome(nome);
		clientes.setCpf(cpf);
		clientes.setEmail(email);
		clientes.setDataNascimento(dataNascimento);
		clientes.setSexo(sexo);
		clientes.setNomeSocial(nomeSocial);
		clientes.setApelido(apelido);
		clientes.setTelefone(telefone);

		clientesRepo.save(clientes);
		return "Clientes: Registro Criado\n";

	}

	@GetMapping(path="/listar")
	public @ResponseBody Iterable<Clientes> getAllClientes() {

		return clientesRepo.findAll();
	}

	@GetMapping(path="/apagar/{id}")
	public @ResponseBody String  apagarClientes(@PathVariable Integer id) {


		if (clientesRepo.findById(id) == null) {
			return "Não encontrado";
		}

		clientesRepo.deleteById(id);

		return "Clientes: Registro "+id+" Apagado\n";
	}

	@PutMapping(path="/alterar/{id}")
	public @ResponseBody String alterarClientes(
			
			@PathVariable Integer id,
			@RequestParam String nome,
			@RequestParam String cpf,
			@RequestParam String email,
			@RequestParam Date dataNascimento,
			@RequestParam String sexo,
			@RequestParam String nomeSocial,
			@RequestParam String apelido,
			@RequestParam String telefone
			
			) {


		if (clientesRepo.findById(id) == null) {
			return "Não encontrado";
		}

		Clientes clientes = new Clientes();
		clientes.setId(id);
		clientes.setNome(nome);
		clientes.setCpf(cpf);
		clientes.setEmail(email);
		clientes.setDataNascimento(dataNascimento);
		clientes.setSexo(sexo);
		clientes.setNomeSocial(nomeSocial);
		clientes.setApelido(apelido);
		clientes.setTelefone(telefone);

		clientesRepo.save(clientes);
		return "Clientes: Registro " +id+ " Alterado\n";
	}


}

package com.prjlojaunitandrebarros.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.prjlojaunitandrebarros.mvc.repository.*;
import com.prjlojaunitandrebarros.mvc.model.*;

@Controller
@RequestMapping(path="/fornecedor")
public class FornecedorController {
	@Autowired
	private FornecedorRepository fornecedorRepo;

	@PostMapping(path="/criar")
	public @ResponseBody String criarFornecedor (

			@RequestParam	String nome,
							String endereco,
							String telefone,
							String cnpj,
							String email

			) {


		Fornecedor fornecedor = new Fornecedor();
		fornecedor.setNome(nome);
		fornecedor.setEndereco(endereco);
		fornecedor.setTelefone(telefone);
		fornecedor.setCnpj(cnpj);
		fornecedor.setEmail(email);

		fornecedorRepo.save(fornecedor);
		return "Fornecedor: Registro Criado\n";

	}

	@GetMapping(path="/listar")
	public @ResponseBody Iterable<Fornecedor> getAllFornecedor() {

		return fornecedorRepo.findAll();
	}

	@DeleteMapping(path="/apagar/{id}")
	public @ResponseBody String  apagarFornecedor(@PathVariable Integer id) {


		if (fornecedorRepo.findById(id) == null) {
			return "ID " + id +" Não encontrado";
		}

		fornecedorRepo.deleteById(id);
		return "Fornecedor: Registro "+id+" Apagado\n";
	}

	@PutMapping(path="/alterar/{id}")
	public @ResponseBody String alterarFornecedor(

			@PathVariable Integer id,
			@RequestParam	String nome,
							String endereco,
							String telefone,
							String cnpj,
							String email

			) {


		if (fornecedorRepo.findById(id) == null) {
			return "ID " + id +" Não encontrado";
		}

		Fornecedor fornecedor = new Fornecedor();
		fornecedor.setId(id);
		fornecedor.setNome(nome);
		fornecedor.setEndereco(endereco);
		fornecedor.setTelefone(telefone);
		fornecedor.setCnpj(cnpj);
		fornecedor.setEmail(email);

		fornecedorRepo.save(fornecedor);
		
		return "Fornecedor: Registro " +id+ " Alterado\n";
	}

	@GetMapping(path="/buscar/{id}")
	public @ResponseBody ResponseEntity<Fornecedor> getById(
			
		@PathVariable Integer id) {
			
		if (fornecedorRepo.findById(id) == null) {
			return (ResponseEntity<Fornecedor>) ResponseEntity.notFound();
					
					//.body("ID " + id +" Não encontrado");
		}
		
		Fornecedor fornecedor = new Fornecedor();
		return ResponseEntity.ok().body(fornecedor);
	}


}

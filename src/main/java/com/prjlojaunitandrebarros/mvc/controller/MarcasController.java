package com.prjlojaunitandrebarros.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping(path="/marcas")
public class MarcasController {
	@Autowired
	private MarcasRepository marcasRepo;

	@PostMapping(path="/criar")
	public @ResponseBody String criarMarcas (

			@RequestParam	String nome,
							String descricao){

		Marcas marcas = new Marcas();
		marcas.setNome(nome);
		marcas.setDescricao(descricao);
		
		marcasRepo.save(marcas);
		
		return "Marcas: Registro Criado\n";

	}

	@GetMapping(path="/listar")
	public @ResponseBody Iterable<Marcas> getAllMarcas() {

		return marcasRepo.findAll();
	}

	@DeleteMapping(path="/apagar/{id}")
	public @ResponseBody String  apagarMarcas(@PathVariable Integer id) {

		if (marcasRepo.findById(id) == null) {
			return "ID " + id +" Não encontrado";
		}

		marcasRepo.deleteById(id);
		
		return "Marcas: Registro "+id+" Apagado\n";
	}

	@PutMapping(path="/alterar/{id}")
	public @ResponseBody String alterarMarcas(

			@PathVariable Integer id,
			@RequestParam	String nome,
							String descricao){

		if (marcasRepo.findById(id) == null) {
			return "ID " + id +" Não encontrado";
		}

		Marcas marcas = new Marcas();
		marcas.setNome(nome);
		marcas.setDescricao(descricao);
		
		marcasRepo.save(marcas);
		
		return "Marcas: Registro " +id+ " Alterado\n";
	}


}

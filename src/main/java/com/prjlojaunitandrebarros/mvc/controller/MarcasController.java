package com.prjlojaunitandrebarros.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.prjlojaunitandrebarros.mvc.repository.*;
import com.prjlojaunitandrebarros.mvc.model.*;

@Controller
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path="/marcas")
public class MarcasController {
	@Autowired
	private MarcasRepository marcasRepo;

	@PostMapping(path="/criar")
	public @ResponseBody String criarMarcas(
			@RequestBody Marcas marcas)
	{
		marcasRepo.save(marcas);
		
		return "Marcas: Registro Criado\n";
	}

	@GetMapping(path="/listar")
	public @ResponseBody Iterable<Marcas> listaMarcas() {
		return marcasRepo.findAll();
	}

	@DeleteMapping(path="/apagar/{id}")
	@ResponseStatus(code=HttpStatus.ACCEPTED)
	public @ResponseBody String  apagarMarcas(@PathVariable Integer id) {

		if (marcasRepo.findById(id) == null) {
			return "ID " + id +" Não encontrado";
		}
		marcasRepo.deleteById(id);
		return "Marcas: Registro "+id+" Apagado\n";
	}

	@PutMapping(path="/atualizar/{id}")
	public @ResponseBody String alterarMarcas(
			@PathVariable Integer id,
			@RequestBody Marcas marcasDetalhes)
	{

		Marcas marcas = marcasRepo.findById(id).get();
		
		marcas.setNome(marcasDetalhes.getNome());
		marcas.setDescricao(marcasDetalhes.getDescricao());
		
		marcasRepo.save(marcas);
		
		return "Marcas: Registro " +id+ " Alterado\n";
	}

	@GetMapping(path="/buscar/{id}")
	public @ResponseBody Marcas getMarcasById(			
		@PathVariable Integer id)
	{

		return marcasRepo.findById(id).get();
	}

	
}

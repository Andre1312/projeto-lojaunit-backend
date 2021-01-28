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

import com.prjlojaunitandrebarros.mvc.model.Categoria;
import com.prjlojaunitandrebarros.mvc.repository.CategoriaRepository;

@Controller
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path="/categoria")
public class CategoriaController {
	@Autowired
	private CategoriaRepository categoriaRepo;

	@PostMapping(path="/criar")
	public @ResponseBody String criarCategoria (
			@RequestBody Categoria categoria)
	{
		categoriaRepo.save(categoria);
		return "Categoria: Registro Criado\n";
	}

	@GetMapping(path="/listar")
	public @ResponseBody Iterable<Categoria> listaCategoria() {
		return categoriaRepo.findAll();
	}

	@DeleteMapping(path="/apagar/{id}")
	@ResponseStatus(code=HttpStatus.ACCEPTED)
	public @ResponseBody String  apagarCategoria(@PathVariable Integer id)
	{

		if (categoriaRepo.findById(id) == null) {
			return "ID " + id +" Não encontrado";
		}

		categoriaRepo.deleteById(id);
		return "Categoria: Registro "+id+" Apagado";
	}

	@PutMapping(path="/atualizar/{id}")
	public @ResponseBody String alterarCategoria(
			@PathVariable Integer id,
			@RequestBody Categoria categoriaDetalhes)
	{
		if (categoriaRepo.findById(id) == null) {
			return "ID " + id +" Não encontrado";
		}

		Categoria categoria = categoriaRepo.findById(id).get();
		
		categoria.setNome(categoriaDetalhes.getNome());
		categoria.setAtivo(categoriaDetalhes.getAtivo());

		categoriaRepo.save(categoria);
		return "Categoria: Registro " +id+ " Alterado";
	}
	
	@GetMapping(path="/buscar/{id}")
	public @ResponseBody Categoria getById(
			@PathVariable Integer id)
	{

		return categoriaRepo.findById(id).get();
	}


}

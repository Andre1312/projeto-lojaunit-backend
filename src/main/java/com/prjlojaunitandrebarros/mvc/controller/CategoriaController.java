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
import com.prjlojaunitandrebarros.mvc.model.Categoria;
import com.prjlojaunitandrebarros.mvc.repository.CategoriaRepository;

@Controller
@RequestMapping(path="/categoria")
public class CategoriaController {
	@Autowired
	private CategoriaRepository categoriaRepo;

	@PostMapping(path="/criar")
	public @ResponseBody String criarCategoria (

			@RequestParam 	String nome,
							Boolean ativo
			
			) {


		Categoria categoria = new Categoria();
		categoria.setNome(nome);
		categoria.setAtivo(ativo);

		categoriaRepo.save(categoria);
		
		
		return "Categoria: Registro Criado\n";

	}

	@GetMapping(path="/listar")
	public @ResponseBody Iterable<Categoria> getAllCategoria() {

		return categoriaRepo.findAll();
	}

	@DeleteMapping(path="/apagar/{id}")
	public @ResponseBody String  apagarCategoria(@PathVariable Integer id) {


		if (categoriaRepo.findById(id) == null) {
			return "ID " + id +" Não encontrado";
		}

		categoriaRepo.deleteById(id);

		return "Categoria: Registro "+id+" Apagado";
	}

	@PutMapping(path="/alterar/{id}")
	public @ResponseBody String alterarCategoria(
			
			@PathVariable Integer id,
			
			@RequestParam 	String nome,
							boolean ativo
			
			) {


		if (categoriaRepo.findById(id) == null) {
			return "ID " + id +" Não encontrado";
		}

		Categoria categoria = new Categoria();
		
		categoria.setNome(nome);
		categoria.setAtivo(ativo);

		categoriaRepo.save(categoria);
		return "Categoria: Registro " +id+ " Alterado";
	}


}

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
@RequestMapping(path="/produto")
public class ProdutoController {
	@Autowired
	private ProdutoRepository produtoRepo;

	@PostMapping(path="/criar")
	public @ResponseBody String criarProduto (

			@RequestParam	String nome,
							String descricao,
							Double precoUnitario,
							String unidade,
							Integer idCategoria,
							Integer idFornecedor,
							Integer idMarca) {

		Produto produto = new Produto();
		produto.setNome(nome);
		produto.setDescricao(descricao);
		produto.setPrecoUnitario(precoUnitario);
		produto.setUnidade(unidade);
		produto.getCategoria().setId(idCategoria);
		produto.getFornecedor().setId(idFornecedor);
		produto.getMarcas().setId(idMarca);

		produtoRepo.save(produto);
		
		return "Produto: Registro Criado\n";

	}

	@GetMapping(path="/listar")
	public @ResponseBody Iterable<Produto> getAllProduto() {

		return produtoRepo.findAll();
	}

	@DeleteMapping(path="/apagar/{id}")
	public @ResponseBody String  apagarProduto(@PathVariable Integer id) {


		if (produtoRepo.findById(id) == null) {
			return "ID " + id +" Não encontrado";
		}

		produtoRepo.deleteById(id);
		return "Produto: Registro "+id+" Apagado\n";
	}

	@PutMapping(path="/alterar/{id}")
	public @ResponseBody String alterarProduto(

			@PathVariable Integer id,
			@RequestParam	String nome,
							String descricao,
							Double precoUnitario,
							String unidade,
							Integer idCategoria,
							Integer idFornecedor,
							Integer idMarca){

		if (produtoRepo.findById(id) == null) {
			return "ID " + id +" Não encontrado";
		}

		Produto produto = new Produto();
		
		produto.setNome(nome);
		produto.setDescricao(descricao);
		produto.setPrecoUnitario(precoUnitario);
		produto.setUnidade(unidade);
		produto.getCategoria().setId(idCategoria);
		produto.getFornecedor().setId(idFornecedor);
		produto.getMarcas().setId(idMarca);

		produtoRepo.save(produto);
		
		return "Produto: Registro " +id+ " Alterado\n";
	}


}

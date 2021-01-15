package com.prjlojaunitandrebarros.mvc.controller;

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
import com.prjlojaunitandrebarros.mvc.model.*;

@Controller
@RequestMapping(path="/formapagamento")
public class FormaPagamentoController {
	@Autowired
	private FormaPagamentoRepository formaPagRepo;

	@PostMapping(path="/criar")
	public @ResponseBody String criarFormaPag (

			@RequestParam String forma,
			@RequestParam String descricao,
			@RequestParam Boolean ativo

			) {

		FormaPagamento formaPag = new FormaPagamento();
		formaPag.setForma(forma);
		formaPag.setDescricao(descricao);
		formaPag.setAtivo(ativo);

		formaPagRepo.save(formaPag);
		return "Forma Pagamento: Registro Criado\n";

	}

	@GetMapping(path="/listar")
	public @ResponseBody Iterable<FormaPagamento> getAllFormaPagamento() {

		return formaPagRepo.findAll();
	}

	@GetMapping(path="/apagar/{id}")
	public @ResponseBody String  apagarFormaPag(@PathVariable Integer id) {


		if (formaPagRepo.findById(id) == null) {
			return "Não encontrado";
		}

		formaPagRepo.deleteById(id);
		return "Forma Pagamento: Registro "+id+" Apagado\n";
	}

	@PutMapping(path="/alterar/{id}")
	public @ResponseBody String alterarFormaPag(

			@PathVariable Integer id,
			@RequestParam String forma,
			@RequestParam String descricao,
			@RequestParam Boolean ativo

			) {


		FormaPagamento formaPag = new FormaPagamento();
		formaPag.setId(id);
		formaPag.setForma(forma);
		formaPag.setDescricao(descricao);
		formaPag.setAtivo(ativo);

		formaPagRepo.save(formaPag);
		return "Forma Pagamento: Registro " +id+ " Alterado\n";
	}


}

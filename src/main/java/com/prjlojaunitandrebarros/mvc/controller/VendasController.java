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
@RequestMapping(path="/vendas")
public class VendasController {
	@Autowired
	private VendasRepository vendasRepo;

	@PostMapping(path="/criar")
	public @ResponseBody String criarVendas (

			@RequestParam Date datahora,
			@RequestParam Integer idCliente,
			@RequestParam Integer idFormaPagamento,
			@RequestParam Double valorTotal

			) {


		Vendas vendas = new Vendas();
		vendas.setDatahora(datahora);
		vendas.setIdCliente(idCliente);
		vendas.setIdFormaPagamento(idFormaPagamento);
		vendas.setValorTotal(valorTotal);

		vendasRepo.save(vendas);
		return "Vendas: Registro Criado\n";

	}

	@GetMapping(path="/listar")
	public @ResponseBody Iterable<Vendas> getAllVendas() {

		return vendasRepo.findAll();
	}

	@GetMapping(path="/apagar/{id}")
	public @ResponseBody String  apagarVendas(@PathVariable Integer id) {


		if (vendasRepo.findById(id) == null) {
			return "Não encontrado";
		}

		vendasRepo.deleteById(id);
		return "Vendas: Registro "+id+" Apagado\n";
	}

	@PutMapping(path="/alterar/{id}")
	public @ResponseBody String alterarVendas(

			@PathVariable Integer id,
			@RequestParam Date datahora,
			@RequestParam Integer idCliente,
			@RequestParam Integer idFormaPagamento,
			@RequestParam Double valorTotal

			) {


		if (vendasRepo.findById(id) == null) {
			return "Não encontrado";
		}

		Vendas vendas = new Vendas();
		vendas.setDatahora(datahora);
		vendas.setIdCliente(idCliente);
		vendas.setIdFormaPagamento(idFormaPagamento);
		vendas.setValorTotal(valorTotal);

		vendasRepo.save(vendas);
		return "Vendas: Registro " +id+ " Alterado\n";
	}


}

package com.prjlojaunitandrebarros.mvc.controller;

import java.util.Date;


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
@RequestMapping(path="/vendas")
public class VendasController {
	@Autowired
	private VendasRepository vendasRepo;

	@PostMapping(path="/criar")
	public @ResponseBody String criarVendas (

			@RequestParam	Date datahora,
							Integer idCliente,
							Integer idFormaPagamento,
							Double valorTotal){

		Vendas vendas = new Vendas();
		vendas.setDatahora(datahora);
		vendas.getClientes().setId(idCliente);
		vendas.getFormaPagamento().setId(idFormaPagamento);
		vendas.setValorTotal(valorTotal);

		vendasRepo.save(vendas);
		
		return "Vendas: Registro Criado\n";

	}

	@GetMapping(path="/listar")
	public @ResponseBody Iterable<Vendas> getAllVendas() {

		return vendasRepo.findAll();
	}

	@DeleteMapping(path="/apagar/{id}")
	public @ResponseBody String  apagarVendas(@PathVariable Integer id) {


		if (vendasRepo.findById(id) == null) {
			return "ID " + id +" Não encontrado";
		}

		vendasRepo.deleteById(id);
		return "Vendas: Registro "+id+" Apagado\n";
	}

	@PutMapping(path="/alterar/{id}")
	public @ResponseBody String alterarVendas(

			@PathVariable Integer id,
			@RequestParam	Date datahora,
							Integer idCliente,
							Integer idFormaPagamento,
							Double valorTotal

			) {


		if (vendasRepo.findById(id) == null) {
			return "ID " + id +" Não encontrado";
		}

		Vendas vendas = new Vendas();
		vendas.setDatahora(datahora);
		vendas.getClientes().setId(idCliente);
		vendas.getFormaPagamento().setId(idFormaPagamento);
		vendas.setValorTotal(valorTotal);

		vendasRepo.save(vendas);
		return "Vendas: Registro " +id+ " Alterado\n";
	}

	@GetMapping(path="/buscar/{id}")
	public @ResponseBody ResponseEntity<Vendas> getById(
			
		@PathVariable Integer id) {
			
		if (vendasRepo.findById(id) == null) {
			return (ResponseEntity<Vendas>) ResponseEntity.notFound();
					
					//.body("ID " + id +" Não encontrado");
		}
		
		Vendas vendas = new Vendas();
		return ResponseEntity.ok().body(vendas);
	}

}

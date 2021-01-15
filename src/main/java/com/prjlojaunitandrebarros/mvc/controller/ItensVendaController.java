package com.prjlojaunitandrebarros.mvc.controller;

import java.util.Date;

import javax.websocket.server.PathParam;

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
@RequestMapping(path="/itensvenda")
public class ItensVendaController {
	@Autowired
	private ItensVendaRepository itensVendaRepo;

	@PostMapping(path="/criar")
	public @ResponseBody String criarItensVenda (

			@RequestParam Integer idVenda,
			@RequestParam Integer idProduto,
			@RequestParam Integer quantidade,
			@RequestParam Double valorUnitario

			) {


		ItensVenda itensVenda = new ItensVenda();
		itensVenda.setIdVenda(idVenda);
		itensVenda.setIdProduto(idProduto);
		itensVenda.setQuantidade(quantidade);
		itensVenda.setValorUnitario(valorUnitario);
		

		itensVendaRepo.save(itensVenda);
		return "Itens Venda: Registro Criado\n";

	}

	@GetMapping(path="/listar")
	public @ResponseBody Iterable<ItensVenda> getAllItensVenda() {

		return itensVendaRepo.findAll();
	}

	@GetMapping(path="/apagar/{idVenda}")
	public @ResponseBody String  apagarItensVenda(
			
			@PathVariable Integer idVenda
			
			) {


		if (itensVendaRepo.findById(idVenda) == null) {
			
				return "Não encontrado";
		}

		itensVendaRepo.deleteById(idVenda);
		return "Itens Venda: Registro "+idVenda+" Apagado\n";
	}

	@PutMapping(path="/alterar/{idVenda}")
	public @ResponseBody String alterarItensVenda(

			@PathVariable Integer idVenda,
			@RequestParam Integer idProduto,
			@RequestParam Integer quantidade,
			@RequestParam Double valorUnitario

			) {


		if (itensVendaRepo.findById(idVenda) == null) {
			return "Não encontrado";
		}

		ItensVenda itensVenda = new ItensVenda();
		
		itensVenda.setIdVenda(idVenda);
		itensVenda.setIdProduto(idProduto);
		itensVenda.setQuantidade(quantidade);
		itensVenda.setValorUnitario(valorUnitario);

		itensVendaRepo.save(itensVenda);
		return "Itens Venda: Registro " +idVenda+ " Alterado\n";
	}


}

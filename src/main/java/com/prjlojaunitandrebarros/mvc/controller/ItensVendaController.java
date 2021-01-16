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
@RequestMapping(path="/itensvenda")
public class ItensVendaController {
	@Autowired
	private ItensVendaRepository itensVendaRepo;

	@PostMapping(path="/criar")
	public @ResponseBody String criarItensVenda (

			@RequestParam Integer id,
			@RequestParam	Integer idVenda,
							Integer idProduto,
							Integer quantidade,
							Double valorUnitario){


		ItensVenda itensVenda = new ItensVenda();
		
		itensVenda.setId(id);
		//  ??? itensVenda.getVendas().getId();
		//  ??? itensVenda.getProduto().getId();
		itensVenda.setQuantidade(quantidade);
		itensVenda.setValorUnitario(valorUnitario);
		

		itensVendaRepo.save(itensVenda);
		return "Itens Venda: Registro Criado\n";

	}

	@GetMapping(path="/listar")
	public @ResponseBody Iterable<ItensVenda> getAllItensVenda() {

		return itensVendaRepo.findAll();
	}

	@DeleteMapping(path="/apagar/{id}")
	public @ResponseBody String  apagarItensVenda(
			
			@PathVariable Integer id
			
			) {


		if (itensVendaRepo.findById(id) == null) {
			return "ID " + id +" Não encontrado";
		}

		itensVendaRepo.deleteById(id);
		return "Itens Venda: Registro "+id+" Apagado\n";
	}

	@PutMapping(path="/alterar/{id}")
	public @ResponseBody String alterarItensVenda(

			@PathVariable Integer id,
			@RequestParam	Integer idVenda,
							Integer idProduto,
							Integer quantidade,
							Double valorUnitario
			

			) {


		if (itensVendaRepo.findById(id) == null) {
			return "ID " + id +" Não encontrado";
		}

		ItensVenda itensVenda = new ItensVenda();
		
		itensVenda.setId(id);
		// ??? itensVenda.getVendas().getId();
		// ??? itensVenda.getProduto().getId();
		itensVenda.setQuantidade(quantidade);
		itensVenda.setValorUnitario(valorUnitario);

		itensVendaRepo.save(itensVenda);
		
		return "Itens Venda: Registro " +idVenda+ " Alterado\n";
	}


}

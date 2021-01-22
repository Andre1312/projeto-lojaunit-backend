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

import com.prjlojaunitandrebarros.mvc.model.FormaPagamento;
import com.prjlojaunitandrebarros.mvc.repository.FormaPagamentoRepository;


@Controller
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path="/formapagamento")
public class FormaPagamentoController {
	@Autowired
	private FormaPagamentoRepository formaPagRepo;

	@PostMapping(path="/criar")
	public @ResponseBody String criarFormaPag (
			@RequestBody FormaPagamento formapagamento
			){
		
		formaPagRepo.save(formapagamento);
		return "Forma Pagamento: Registro Criado\n";
	}

	@GetMapping(path="/listar")
	public @ResponseBody Iterable<FormaPagamento> getAllFormaPagamento() {
		return formaPagRepo.findAll();
	}

	@DeleteMapping(path="/apagar/{id}")
	@ResponseStatus(code=HttpStatus.ACCEPTED)
	public @ResponseBody String  apagarFormaPag(@PathVariable Integer id) {

		if (formaPagRepo.findById(id) == null) {
			return "ID " + id +" Não encontrado";
		}

		formaPagRepo.deleteById(id);
		return "Forma Pagamento: Registro "+id+" Apagado\n";
	}

	@PutMapping(path="/atualizar/{id}")
	public @ResponseBody String alterarFormaPag(
			@PathVariable Integer id,
			@RequestBody	FormaPagamento formapagamento
			){

		FormaPagamento formaPag = formaPagRepo.findById(id).get();
		
		formaPag.setForma(formapagamento.getForma());
		formaPag.setDescricao(formapagamento.getDescricao());
		formaPag.setAtivo(formapagamento.getAtivo());

		formaPagRepo.save(formaPag);
		
		return "Forma Pagamento: Registro " +id+ " Alterado\n";
	}

	@GetMapping(path="/buscar/{id}")
	public @ResponseBody FormaPagamento findById(
			@PathVariable Integer id) {
			
		return formaPagRepo.findById(id).get();
	
	}

	
}

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

import com.prjlojaunitandrebarros.mvc.model.Faq;
import com.prjlojaunitandrebarros.mvc.repository.FaqRepository;

@Controller
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path="/faq")
public class FaqController {
	@Autowired
	private FaqRepository faqRepo;

	@PostMapping(path="/criar")
	public @ResponseBody String criarFaq (
			@RequestBody Faq faq)
		{
		faqRepo.save(faq);
		return "FAQ: Registro Criado\n";
	}

	@GetMapping(path="/listar")
	public @ResponseBody Iterable<Faq> getAllFaq() {
		return faqRepo.findAll();
	}

	@DeleteMapping(path="/apagar/{id}")
	@ResponseStatus(code=HttpStatus.ACCEPTED)
	public @ResponseBody String  apagarFaq(@PathVariable Integer id) {

		if (faqRepo.findById(id) == null) {
			return "ID " + id +" Não encontrado";
		}

		faqRepo.deleteById(id);
		return "FAQ: Registro "+id+" Apagado\n";
	}

	@PutMapping(path="/atualizar/{id}")
	public @ResponseBody String alterarFaq(
			@PathVariable Integer id,
			@RequestBody Faq faqDetalhes)
		{
		if (faqRepo.findById(id) == null) {
			return "ID " + id +" Não encontrado";
		}

		Faq faq = faqRepo.findById(id).get();
		
		faq.setDatahora(faqDetalhes.getDatahora());
		faq.setTexto(faqDetalhes.getTexto());

		faqRepo.save(faq);
		
		return "FAQ: Registro " +id+ " Alterado\n";
	}
	
	@GetMapping(path="/buscar/{id}")
	public @ResponseBody Faq getFaqById(
			@PathVariable Integer id)
		{
		return faqRepo.findById(id).get();
	}


}

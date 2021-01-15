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
@RequestMapping(path="/faq")
public class FaqController {
	@Autowired
	private FaqRepository faqRepo;

	@PostMapping(path="/criar")
	public @ResponseBody String criarFaq (

			@RequestParam Date datahora,
			@RequestParam String texto

			) {


		Faq faq = new Faq();
		faq.setDatahora(datahora);
		faq.setTexto(texto);

		faqRepo.save(faq);
		return "FAQ: Registro Criado\n";

	}

	@GetMapping(path="/listar")
	public @ResponseBody Iterable<Faq> getAllFaq() {

		return faqRepo.findAll();
	}

	@GetMapping(path="/apagar/{id}")
	public @ResponseBody String  apagarFaq(@PathVariable Integer id) {


		if (faqRepo.findById(id) == null) {
			return "Não encontrado";
		}

		faqRepo.deleteById(id);
		return "FAQ: Registro "+id+" Apagado\n";
	}

	@PutMapping(path="/alterar/{id}")
	public @ResponseBody String alterarFaq(

			@PathVariable Integer id,
			@RequestParam Date datahora,
			@RequestParam String texto

			) {


		if (faqRepo.findById(id) == null) {
			return "Não encontrado";
		}

		Faq faq = new Faq();
		faq.setDatahora(datahora);
		faq.setTexto(texto);

		faqRepo.save(faq);
		return "FAQ: Registro " +id+ " Alterado\n";
	}


}

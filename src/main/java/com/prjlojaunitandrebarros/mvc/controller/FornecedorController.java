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

import com.prjlojaunitandrebarros.mvc.model.Fornecedor;
import com.prjlojaunitandrebarros.mvc.repository.FornecedorRepository;

@Controller
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path="/fornecedor")
public class FornecedorController {
	
	@Autowired
	private FornecedorRepository fornecedorRepo;

	@PostMapping(path="/criar")
	public @ResponseBody String criarFornecedor (
			@RequestBody Fornecedor fornecedor)
	{
		fornecedorRepo.save(fornecedor);
		return "Fornecedor: Registro Criado ID: "+fornecedor.getId()+"\n";
	}

	@GetMapping(path="/listar")
	public @ResponseBody Iterable<Fornecedor> getAllFornecedor() {
		return fornecedorRepo.findAll();
	}

	@DeleteMapping(path="/apagar/{id}")
	@ResponseStatus(code=HttpStatus.ACCEPTED)
	public @ResponseBody String  apagarFornecedor(@PathVariable Integer id) {
		if (fornecedorRepo.findById(id) == null) {
			return "ID " + id +" Não encontrado";
		}
		fornecedorRepo.deleteById(id);
		return "Fornecedor: Registro "+id+" Apagado\n";
	}

	@PutMapping(path="/atualizar/{id}")
	public @ResponseBody String alterarFornecedor(
				@PathVariable Integer id,
				@RequestBody	Fornecedor fornecedorDetalhes)
		{
		if (fornecedorRepo.findById(id) == null) {
			return "ID " + id +" Não encontrado";
		}

		Fornecedor fornecedor = fornecedorRepo.findById(id).get();
		
		fornecedor.setNome(fornecedorDetalhes.getNome());
		fornecedor.setEndereco(fornecedorDetalhes.getEndereco());
		fornecedor.setTelefone(fornecedorDetalhes.getTelefone());
		fornecedor.setCnpj(fornecedorDetalhes.getCnpj());
		fornecedor.setEmail(fornecedorDetalhes.getEmail());

		fornecedorRepo.save(fornecedor);
		
		return "Fornecedor: Registro " +id+ " Alterado\n";
	}

	@GetMapping(path="/buscar/{id}")
	public @ResponseBody Fornecedor getFornecedorById(
			@PathVariable Integer id)
		{
		return fornecedorRepo.findById(id).get();
	}


}
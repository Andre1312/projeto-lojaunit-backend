package com.prjlojaunitandrebarros.mvc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.prjlojaunitandrebarros.mvc.model.Vendas;

@Repository
public interface VendasRepository extends CrudRepository<Vendas, Integer> {}

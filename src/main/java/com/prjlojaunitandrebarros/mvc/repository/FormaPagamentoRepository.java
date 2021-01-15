package com.prjlojaunitandrebarros.mvc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.prjlojaunitandrebarros.mvc.model.*;

@Repository
public interface FormaPagamentoRepository extends CrudRepository<FormaPagamento, Integer> {

}

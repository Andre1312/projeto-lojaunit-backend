package com.prjlojaunitandrebarros;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.prjlojaunitandrebarros.mvc.repository.*;
import com.prjlojaunitandrebarros.mvc.controller.*;
import com.prjlojaunitandrebarros.mvc.model.*;
import com.prjlojaunitandrebarros.*;

@SpringBootApplication
public class PrjLojaUnitAndrebarrosApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrjLojaUnitAndrebarrosApplication.class, args);
	}

}

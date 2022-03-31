package com.fooddelivery.domain.jpa.estado.cidade;


import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.fooddelivery.FoodDeliveryApplication;
import com.fooddelivery.domain.model.Estado;
import com.fooddelivery.infrastructure.repository.CadastroEstadoImpl;

public class IncluirEstadoMain {

	public static void main(String[] args) {
		
		ApplicationContext applicationContext = (ApplicationContext) new SpringApplicationBuilder(FoodDeliveryApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		CadastroEstadoImpl cadastroEstado = applicationContext.getBean(CadastroEstadoImpl.class);
		
		Estado e1 = new Estado();
		e1.setNome("bahia");
		
		Estado e2 = new Estado();
		e2.setNome("pernambuco");
		
	    e1 = cadastroEstado.salvar(e1);
	    e2 = cadastroEstado.salvar(e2);
		
		System.out.println(e1.getId() + " \n" + e2.getId() );
	}
}

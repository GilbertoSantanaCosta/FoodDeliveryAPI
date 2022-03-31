package com.fooddelivery.domain.jpa.estado.cidade;


import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.fooddelivery.FoodDeliveryApplication;
import com.fooddelivery.domain.model.Estado;
import com.fooddelivery.infrastructure.repository.CadastroEstadoImpl;

public class AtualizarEstadoMain {

	public static void main(String[] args) {
		
		ApplicationContext applicationContext = (ApplicationContext) new SpringApplicationBuilder(FoodDeliveryApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		CadastroEstadoImpl cadastroEstado = applicationContext.getBean(CadastroEstadoImpl.class);
		
		Estado estado = new Estado();
		estado.setNome("rio de janeiro");
		estado.setId(1l);
	    estado = cadastroEstado.salvar(estado);
	    
		
		System.out.println(estado.getId() + " \n" + estado.getNome());
	}
}

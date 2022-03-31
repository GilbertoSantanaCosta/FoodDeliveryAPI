package com.fooddelivery.domain.jpa.estado.cidade;


import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.fooddelivery.FoodDeliveryApplication;
import com.fooddelivery.domain.model.Estado;
import com.fooddelivery.infrastructure.repository.CadastroEstadoImpl;

public class CadastroConsultaEstadoMain {

	public static void main(String[] args) {
		
		ApplicationContext applicationContext = (ApplicationContext) new SpringApplicationBuilder(FoodDeliveryApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		CadastroEstadoImpl cadastroEstado = applicationContext.getBean(CadastroEstadoImpl.class);
		
		Estado x = cadastroEstado.buscar(1l);
		
		 System.out.println(x.getNome());
	}
}

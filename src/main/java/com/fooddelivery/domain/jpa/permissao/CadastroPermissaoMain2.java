package com.fooddelivery.domain.jpa.permissao;


import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.fooddelivery.FoodDeliveryApplication;
import com.fooddelivery.domain.model.Permissao;
import com.fooddelivery.infrastructure.repository.CadastroPermissaoImpl;

public class CadastroPermissaoMain2 {

	public static void main(String[] args) {
		
		ApplicationContext applicationContext = (ApplicationContext) new SpringApplicationBuilder(FoodDeliveryApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		CadastroPermissaoImpl cadastroPermissao = applicationContext.getBean(CadastroPermissaoImpl.class);
		
		Permissao x = cadastroPermissao.buscar(1l);
		
		 System.out.println(x.getNome());
	}
}

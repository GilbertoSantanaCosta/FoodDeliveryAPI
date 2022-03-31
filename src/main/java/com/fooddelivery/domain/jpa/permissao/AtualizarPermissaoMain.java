package com.fooddelivery.domain.jpa.permissao;


import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.fooddelivery.FoodDeliveryApplication;
import com.fooddelivery.domain.model.Permissao;
import com.fooddelivery.infrastructure.repository.CadastroPermissaoImpl;

public class AtualizarPermissaoMain {

	public static void main(String[] args) {
		
		ApplicationContext applicationContext = (ApplicationContext) new SpringApplicationBuilder(FoodDeliveryApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		CadastroPermissaoImpl cadastroPermissao = applicationContext.getBean(CadastroPermissaoImpl.class);
		
		Permissao permissao = new Permissao();
		permissao.setNome("compra não liberada");
		permissao.setId(1l);
	    permissao = cadastroPermissao.salvar(permissao);
	    
		
		System.out.println(permissao.getId() + " \n" + permissao.getNome());
	}
}

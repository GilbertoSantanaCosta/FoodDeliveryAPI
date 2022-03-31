package com.fooddelivery.domain.jpa.permissao;




import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.fooddelivery.FoodDeliveryApplication;
import com.fooddelivery.infrastructure.repository.CadastroPermissaoImpl;


public class DeletePermissaoMain {

	public static void main(String[] args) {
		
		ApplicationContext applicationContext = (ApplicationContext) new SpringApplicationBuilder(FoodDeliveryApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		CadastroPermissaoImpl cadastroPermissao = applicationContext.getBean(CadastroPermissaoImpl.class);
		
		
	    cadastroPermissao.remover(1l);
	    
		
		
	}
}

package com.fooddelivery.domain.jpa;


import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.fooddelivery.FoodDeliveryApplication;
import com.fooddelivery.domain.model.Cozinha;
import com.fooddelivery.domain.model.Restaurante;
import com.fooddelivery.infrastructure.repository.RestauranteImpl;

public class CadastroConsultaRestauranteMain {

	public static void main(String[] args) {
		
		ApplicationContext applicationContext = (ApplicationContext) new SpringApplicationBuilder(FoodDeliveryApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		RestauranteImpl restaurante = applicationContext.getBean(RestauranteImpl.class);
		
		Restaurante x = restaurante.buscar(1l);
		
		 System.out.printf("%s - %f - %s", x.getNome(), x.getTaxaFrete(), x.getCozinha().getNome());
	}
}

package com.fooddelivery.domain.jpa;


import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.fooddelivery.FoodDeliveryApplication;
import com.fooddelivery.domain.model.Restaurante;
import com.fooddelivery.infrastructure.repository.RestauranteImpl;

public class IncluirRestauranteMain {

	public static void main(String[] args) {
		
		ApplicationContext applicationContext = (ApplicationContext) new SpringApplicationBuilder(FoodDeliveryApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		RestauranteImpl restaurante = applicationContext.getBean(RestauranteImpl.class);
		
		Restaurante restaurante1 = new Restaurante();
		restaurante1.setNome("Brasileira");
		
		Restaurante restaurante2 = new Restaurante();
		restaurante2.setNome("russa");
		
	    restaurante1 = restaurante.salvar(restaurante1);
	    restaurante2 = restaurante.salvar(restaurante2);
		
		System.out.println(restaurante1.getId() + " \n" + restaurante2.getId() );
	}
}

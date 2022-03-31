package com.fooddelivery.domain.jpa.restaurante;




import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.fooddelivery.FoodDeliveryApplication;
import com.fooddelivery.infrastructure.repository.RestauranteImpl;



public class DeleteRestauranteMain {

	public static void main(String[] args) {
		
		ApplicationContext applicationContext = (ApplicationContext) new SpringApplicationBuilder(FoodDeliveryApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		RestauranteImpl restaurante = applicationContext.getBean(RestauranteImpl.class);
		
		
	    restaurante.remover(1l);
	    
		
		
	}
}

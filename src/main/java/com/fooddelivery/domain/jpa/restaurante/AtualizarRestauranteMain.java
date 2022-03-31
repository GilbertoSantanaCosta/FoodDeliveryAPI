package com.fooddelivery.domain.jpa.restaurante;




import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.fooddelivery.FoodDeliveryApplication;
import com.fooddelivery.domain.model.Cozinha;
import com.fooddelivery.domain.model.Restaurante;
import com.fooddelivery.infrastructure.repository.CadastroCozinhaImpl;
import com.fooddelivery.infrastructure.repository.RestauranteImpl;

public class AtualizarRestauranteMain {

	public static void main(String[] args) {
		
		ApplicationContext applicationContext = (ApplicationContext) new SpringApplicationBuilder(FoodDeliveryApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		RestauranteImpl impl = applicationContext.getBean(RestauranteImpl.class);
		
		Restaurante restaurante = new Restaurante();
		restaurante.setNome("Brasileira");
		restaurante.setId(1l);
		restaurante = impl.salvar(restaurante);
	    
		
		System.out.println(restaurante.getId() + " \n" + restaurante.getNome());
	}
}

package com.fooddelivery.domain.jpa.cozinha;




import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import com.fooddelivery.FoodDeliveryApplication;
import com.fooddelivery.domain.model.Cozinha;
import com.fooddelivery.domain.model.Estado;
import com.fooddelivery.infrastructure.repository.CadastroCozinhaImpl;
import com.fooddelivery.infrastructure.repository.CadastroEstadoImpl;

public class AtualizarCozinhaMain {

	public static void main(String[] args) {
		
		ApplicationContext applicationContext = (ApplicationContext) new SpringApplicationBuilder(FoodDeliveryApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		CadastroCozinhaImpl cadastroCozinha = applicationContext.getBean(CadastroCozinhaImpl.class);
		
		Cozinha cozinha  = new Cozinha();
		cozinha.setNome("Brasileira");
		cozinha.setId(1l);
	    cozinha = cadastroCozinha.salvar(cozinha);
	    
		
		System.out.println(cozinha.getId() + " \n" + cozinha.getNome());
	}
}
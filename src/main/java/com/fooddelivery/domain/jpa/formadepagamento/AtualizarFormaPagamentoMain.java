package com.fooddelivery.domain.jpa.formadepagamento;


import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.fooddelivery.FoodDeliveryApplication;
import com.fooddelivery.domain.model.Cozinha;
import com.fooddelivery.domain.model.FormaDePagamento;
import com.fooddelivery.infrastructure.repository.CadastroCozinhaImpl;
import com.fooddelivery.infrastructure.repository.FormaDePagamentoImpl;

public class AtualizarFormaPagamentoMain {

	public static void main(String[] args) {
		
		ApplicationContext applicationContext = (ApplicationContext) new SpringApplicationBuilder(FoodDeliveryApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		FormaDePagamentoImpl formaPagemento = applicationContext.getBean(FormaDePagamentoImpl.class);
		
		FormaDePagamento pagamento = new FormaDePagamento();
		pagamento.setDescricao("cartao");
		pagamento.setId(1l);
		pagamento = formaPagemento.salvar(pagamento);
	    
		
		System.out.println(pagamento.getId() + " \n" + pagamento.getDescricao());
	}
}

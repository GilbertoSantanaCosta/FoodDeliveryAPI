package com.fooddelivery.api.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.fooddelivery.domain.model.Cozinha;

import lombok.Data;
import lombok.NonNull;

@JacksonXmlRootElement(localName = "cozinhas")
@Data
public class CozinhaXmlWrapper {

	@JsonProperty(value = "cozinha")
	@JacksonXmlElementWrapper(useWrapping = false)
	/**
	 * Para gerar o construtor desse atributo ele deve ser indispensavel 
	 * por essa razão a notamos com nonnull do lombok*/
	@NonNull 
	public List<Cozinha> cozinhas;
}

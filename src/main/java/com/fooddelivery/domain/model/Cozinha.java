package com.fooddelivery.domain.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

// @JsonRootName("gastronomia") // renomeia o nome da classe no corpo do json 
//@Getter
//@Setter
//@EqualsAndHashCode
@Data // substitui as 3 anotações acima 
@EqualsAndHashCode(onlyExplicitlyIncluded = true)// Tem que deixar o ID explicito 
@Entity  
public class Cozinha implements Serializable {

	private static final long serialVersionUID = 1L;

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//@JsonIgnore  // Ignora o atributo no corpo do json 
	//@JsonProperty("Outro nome")   // renomeia o atributo no compo do json
	private String nome;
	
	@JsonIgnore
	@OneToMany(mappedBy = "cozinha")
	private List<Restaurante> restaurantes = new ArrayList<>();
}

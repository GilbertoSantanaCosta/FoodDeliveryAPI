package com.fooddelivery.domain.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

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
	private String nome;
	
}

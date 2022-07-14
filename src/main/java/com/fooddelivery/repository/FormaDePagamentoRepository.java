package com.fooddelivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fooddelivery.model.FormaDePagamento;

@Repository
public interface FormaDePagamentoRepository extends JpaRepository<FormaDePagamento, Long> {

}

package com.alves.logistica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alves.logistica.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{

		List<Cliente> findByNome(String nome);
}

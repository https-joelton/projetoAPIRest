package com.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apirest.model.AlunoModel;

@Repository
public interface AlunoRepository extends JpaRepository<AlunoModel, Long>{

    
}
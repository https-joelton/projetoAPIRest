package com.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apirest.model.AlunoModel;

import java.util.List;

@Repository
public interface AlunoRepository extends JpaRepository<AlunoModel, Long>{

    List<AlunoModel> findByCursoIgnoreCase(String curso);

    List<AlunoModel> findBySituacaoIgnoreCase(String situacao);
}

package com.apirest.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirest.model.AlunoModel;
import com.apirest.repository.AlunoRepository;

@Service
public class AlunoService {
    @Autowired
    private AlunoRepository alunoRepository;

    public String salvar (AlunoModel aluno){
        try{
            alunoRepository.saveAndFlush(aluno);
            return "Salvo com sucesso!";
        }catch (Exception e){
            return e.getMessage();
        }
    }

    public List<AlunoModel> buscarTodos() {
        return alunoRepository.findAll();
    }
    
}

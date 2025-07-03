package com.apirest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirest.model.PessoaModel;
import com.apirest.repository.PessoaRepository;

@Service
public class PessoaService {
    @Autowired
    private PessoaRepository pessoaRepository;

    public List<PessoaModel> buscarPorSexo(String sexo) {
        return pessoaRepository.findBySexoContainingIgnoreCase(sexo);
    }

}

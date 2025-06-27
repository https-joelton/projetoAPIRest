package com.apirest.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.apirest.model.AlunoModel;
import com.apirest.service.AlunoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/aluno")
public class AlunoController {
    @Autowired
    private AlunoService alunoService;

    @GetMapping
    public ResponseEntity<?> buscarTodos() {
        try {
            return new ResponseEntity<>(alunoService.buscarTodos(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Erro ao buscar dados dos alunos", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public AlunoController(AlunoService alunoService){
        this.alunoService = alunoService;
    }


    @PostMapping
    public ResponseEntity<String> salvar(@Valid @RequestBody AlunoModel aluno, BindingResult result) {
        if (result.hasErrors()) {
            StringBuilder errors = new StringBuilder("Erros de validação: ");
            result.getFieldErrors().forEach(error -> {
                errors.append(error.getField())
                    .append(": ")
                    .append(error.getDefaultMessage())
                    .append(", ");
            });
            return new ResponseEntity<>(errors.toString(), HttpStatus.BAD_REQUEST);
        }

        try {
            String retorno = alunoService.salvar(aluno);
            return new ResponseEntity<>(retorno, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Erro ao salvar aluno: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}

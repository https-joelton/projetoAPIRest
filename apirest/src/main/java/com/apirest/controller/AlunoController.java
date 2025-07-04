package com.apirest.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.apirest.model.AlunoModel;
import com.apirest.model.PessoaModel;
import com.apirest.service.AlunoService;
import com.apirest.service.PessoaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/aluno")
public class AlunoController {
    @Autowired
    private AlunoService alunoService;
    @Autowired
    private PessoaService pessoaService;

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
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar(@PathVariable Long id) {
        boolean excluido = alunoService.deletar(id);

        if (excluido) {
            return new ResponseEntity<>("Aluno removido com sucesso.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Aluno não encontrado.", HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> atualizar(@PathVariable Long id, @Valid @RequestBody AlunoModel dadosAtualizados) {
        boolean atualizado = alunoService.atualizar(id, dadosAtualizados);

        if (atualizado) {
            return new ResponseEntity<>("Aluno atualizado com sucesso.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Aluno não encontrado.", HttpStatus.NOT_FOUND);
        }
    }
    
    @GetMapping("/buscar/sexo/{sexo}")
    public ResponseEntity<List<PessoaModel>> buscarPorSexo(@PathVariable String sexo) {
        List<PessoaModel> pessoa = pessoaService.buscarPorSexo(sexo);
        return new ResponseEntity<>(pessoa, HttpStatus.OK);
    }

    @GetMapping("/buscar/curso/{curso}")
    public ResponseEntity<List<AlunoModel>> buscarPorCurso(@PathVariable String curso) {
        List<AlunoModel> alunos = alunoService.buscarPorCurso(curso);
        return new ResponseEntity<>(alunos, HttpStatus.OK);
    }

    @GetMapping("/buscar/situacao/{situacao}")
    public ResponseEntity<List<AlunoModel>> buscarPorSituacao(@PathVariable String situacao) {
        List<AlunoModel> alunos = alunoService.buscarPorSituacao(situacao);
        return new ResponseEntity<>(alunos, HttpStatus.OK);
    }


}

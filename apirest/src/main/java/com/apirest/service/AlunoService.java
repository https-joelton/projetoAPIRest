package com.apirest.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirest.model.AlunoModel;
import com.apirest.repository.AlunoRepository;
import java.util.Optional;


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

    public boolean deletar(Long id) {
        Optional<AlunoModel> aluno = alunoRepository.findById(id);
        if (aluno.isPresent()) {
            alunoRepository.deleteById(id);
            return true;
        }
        return false;
    }
    public boolean atualizar(Long id, AlunoModel dadosAtualizados) {
        Optional<AlunoModel> alunoOptional = alunoRepository.findById(id);

        if (alunoOptional.isPresent()) {
            AlunoModel aluno = alunoOptional.get();

            aluno.setNome_estudante(dadosAtualizados.getNome_estudante());
            aluno.setIdade(dadosAtualizados.getIdade());
            aluno.setSexo(dadosAtualizados.getSexo());
            aluno.setCampus(dadosAtualizados.getCampus());
            aluno.setCurso(dadosAtualizados.getCurso());
            aluno.setEmail_institucional(dadosAtualizados.getEmail_institucional());
            aluno.setPeriodo_entrada(dadosAtualizados.getPeriodo_entrada());
            aluno.setSituacao(dadosAtualizados.getSituacao());
            aluno.setPolo(dadosAtualizados.getPolo());
            aluno.setCoordenacao(dadosAtualizados.getCoordenacao());

            alunoRepository.save(aluno);
            return true;
        }

        return false;
    }
    
    public List<AlunoModel> buscarPorCurso(String curso) {
        return alunoRepository.findByCursoIgnoreCase(curso);
    }

    public List<AlunoModel> buscarPorSituacao(String situacao) {
        return alunoRepository.findBySituacaoIgnoreCase(situacao);
    }

    
}

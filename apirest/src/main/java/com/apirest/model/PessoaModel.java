package com.apirest.model;

import java.io.Serializable;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "pessoa")
public class PessoaModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idpessoa")
    private Long idPessoa;

    @NotBlank(message = "O nome do estudante é obrigatório.")
    private String nome_estudante;

    @NotNull(message = "A idade é obrigatória.")
    @Min(value = 1, message = "A idade deve ser maior que zero.")
    private Integer idade;

    private String sexo;

    public PessoaModel() {}

    public PessoaModel(Integer idade, String sexo, String nome_estudante) {
        this.nome_estudante = nome_estudante;
        this.idade = idade;
        this.sexo = sexo;
    }

    public Long getIdpessoa() {
        return idPessoa;
    }

    public void setIdpessoa(Long idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getNome_estudante() {
        return nome_estudante;
    }

    public void setNome_estudante(String nome_estudante) {
        this.nome_estudante = nome_estudante;
    }

    public Integer getIdade() {  
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
}

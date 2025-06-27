package com.apirest.model;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table (name = "aluno")
@PrimaryKeyJoinColumn(name = "idpessoa")
public class AlunoModel extends PessoaModel{
    private static final long serialVersionUID = 1L;
    @NotBlank(message = "Este campo é obrigatório!")
	private String campus;
	private String polo;
    @NotBlank(message = "Este campo é obrigatório!")
	private String email_institucional;
	private String coordenacao;
    @NotBlank(message = "Este campo é obrigatório!")
	private String curso;
	private String situacao;
    @NotBlank(message = "Este campo é obrigatório!")
	private String periodo_entrada;

    public AlunoModel() {}
	
	public AlunoModel(String coordenacao, String curso, String situacao,
			String periodo_entrada, String campus, String polo, String email_institucional) {
		super();
		this.campus = campus;
		this.polo = polo;
		this.email_institucional = email_institucional;
		this.coordenacao = coordenacao;
		this.curso = curso;
		this.situacao = situacao;
		this.periodo_entrada = periodo_entrada;
	}

    public String getCampus() {
        return campus;
    }
    public void setCampus(String campus) {
        this.campus = campus;
    }
    public String getPolo() {
        return polo;
    }
    public void setPolo(String polo) {
        this.polo = polo;
    }
    public String getEmail_institucional() {
        return email_institucional;
    }
    public void setEmail_institucional(String email_institucional) {
        this.email_institucional = email_institucional;
    }
    public String getCoordenacao() {
        return coordenacao;
    }
    public void setCoordenacao(String coordenacao) {
        this.coordenacao = coordenacao;
    }
    public String getCurso() {
        return curso;
    }
    public void setCurso(String curso) {
        this.curso = curso;
    }
    public String getSituacao() {
        return situacao;
    }
    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
    public String getPeriodo_entrada() {
        return periodo_entrada;
    }
    public void setPeriodo_entrada(String periodo_entrada) {
        this.periodo_entrada = periodo_entrada;
    }

    
}

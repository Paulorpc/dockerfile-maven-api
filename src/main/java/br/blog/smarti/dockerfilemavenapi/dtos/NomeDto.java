package br.blog.smarti.dockerfilemavenapi.dtos;

import javax.validation.constraints.NotEmpty;

public class NomeDto {

	@NotEmpty(message = "Campo 'nome' não pode ser vazio.")
	private String nome;

	public NomeDto() {
		super();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}

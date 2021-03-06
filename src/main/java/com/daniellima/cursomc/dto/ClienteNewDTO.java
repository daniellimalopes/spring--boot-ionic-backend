package com.daniellima.cursomc.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.daniellima.cursomc.services.validation.ClienteInsert;

@ClienteInsert
public class ClienteNewDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotEmpty(message="Preenchimento Obrigatório")
	@Length(min=5, max=80, message="O peenchimento tem que contr no minimo 5 e maximo 80 caracteris")
	private String nome;
	@NotEmpty(message="Preenchimento Obrigatório")
	@Email(message="Email inválido")
	private String email;
	@NotEmpty(message="Preenchimento Obrigatório")
	private String cpfOucnpj;
	
	private Integer tipo;

	private String lagradou;
	
	private String complemento;
	
	private String numero;
	
	private String bairro;
	@NotEmpty(message="Preenchimento Obrigatório")
	private String cep;
	@NotEmpty(message="Preenchimento Obrigatório")
	private String telefone1;
	
	private String telefone2;
	
	private String telefone3;
	
	private Integer cidade;

	public ClienteNewDTO() {
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpfOucnpj() {
		return cpfOucnpj;
	}

	public void setCpfOucnpj(String cpfOucnpj) {
		this.cpfOucnpj = cpfOucnpj;
	}

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	public String getLagradou() {
		return lagradou;
	}

	public void setLagradou(String lagradou) {
		this.lagradou = lagradou;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getTelefone1() {
		return telefone1;
	}

	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}

	public String getTelefone2() {
		return telefone2;
	}

	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}

	public String getTelefone3() {
		return telefone3;
	}

	public void setTelefone3(String telefone3) {
		this.telefone3 = telefone3;
	}

	public Integer getCidade() {
		return cidade;
	}

	public void setCidade(Integer cidade) {
		this.cidade = cidade;
	}

}

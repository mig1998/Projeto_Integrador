package org.unidas.model;

import io.swagger.v3.oas.annotations.media.Schema;

public class UsuarioLogin {

	private long id;

	private String nome_completo;
	
	@Schema(example = "email@email.com")
	private String usuario;

	private String senha;

	private String token;

	
	
	public UsuarioLogin(long id, String nome_completo, String usuario, String senha, String token) {
		this.id = id;
		this.nome_completo = nome_completo;
		this.usuario = usuario;
		this.senha = senha;
		this.token = token;
	}

	public UsuarioLogin() {}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome_completo() {
		return nome_completo;
	}

	public void setNome_completo(String nome_completo) {
		this.nome_completo = nome_completo;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	
	
	
}

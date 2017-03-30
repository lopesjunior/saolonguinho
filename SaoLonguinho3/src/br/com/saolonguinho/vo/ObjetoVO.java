package br.com.saolonguinho.vo;

import java.sql.Date;

public class ObjetoVO {
	
	public String nomeObjeto;
	public String localObjeto;
	public String data;
	public int idUsuario;

	public int getIdDoUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNomeObjeto() {
		return nomeObjeto;
	}
	public void setNomeObjeto(String nomeObjeto) {
		this.nomeObjeto = nomeObjeto;
	}
	public String getLocalObjeto() {
		return localObjeto;
	}
	public void setLocalObjeto(String localObjeto) {
		this.localObjeto = localObjeto;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	
}

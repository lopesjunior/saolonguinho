package br.com.saolonguinho.dao;

import java.sql.Connection;
import java.sql.SQLException;

public interface IConexao {

	Connection getConexao(String tipoBanco, String endereco) throws SQLException, ClassNotFoundException;
	/*Connection getConexao(String tipoBanco, String endereco, String nomeBanco, 
			String nomeUsuario, String senha) throws SQLException;*/
	
	Connection desconectar();
}

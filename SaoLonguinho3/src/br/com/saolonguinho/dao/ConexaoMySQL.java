package br.com.saolonguinho.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoMySQL implements IConexao {
	
	static Connection conexao;
	public String nomeBanco = "sao_longuinho";
	public String nomeUsuario = "root";
	public String senha = "";

	
	@Override
	public synchronized Connection getConexao(String tipoBanco, String endereco) throws SQLException, ClassNotFoundException {
		try {
			if(conexao == null){ 
				Class.forName("com.mysql.jdbc.Driver"); 
				conexao = DriverManager.getConnection(tipoBanco+"://"+endereco+"/"+ nomeBanco, nomeUsuario, senha);
				System.out.println("Conectado!!!");
			}
				return conexao;
		} catch(SQLException e) {
			throw new SQLException("Erro ao conectar com o banco de dados: "+e.getMessage());
    	}
	}


    public static void fecharConexao() throws SQLException{
        if(conexao!=null){
        	conexao.close();
        	//System.out.println("Conxeao Fechada Com Sucesso!!!");
        }
    }
	
	@Override
	public Connection desconectar() {
		conexao = null;
		return conexao;
	}	
	
}	

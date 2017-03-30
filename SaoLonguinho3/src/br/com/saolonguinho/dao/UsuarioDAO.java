package br.com.saolonguinho.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

//import br.com.saolonguinho.vo.UsuarioVO;

public class UsuarioDAO {
	
	Connection conexao;

	UsuarioDAO(Connection conexao) {
		this.conexao = conexao;
	}

	public ArrayList<String> validarLogin(String usuario, String senha) throws SQLException {
		ResultSet rs = null;
		ArrayList<String> usuarioSenha = new ArrayList<String>();
		
		try {
			PreparedStatement pstm = (PreparedStatement) this.conexao.prepareStatement("select usuario, senha from usuario where usuario ='"+usuario+"'");
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				usuarioSenha.add(rs.getString("usuario"));
				usuarioSenha.add(rs.getString("senha"));
			}
			
			return usuarioSenha;
			
		}catch(SQLException e) {
			throw new SQLException("Erro ao validar login "+e.getMessage());
		}
	}
	
	/*
	public UsuarioVO buscaPorEmailESenha(String email, String senha) {		
		//Deveria consultar o banco de dados...
		UsuarioVO alunoEncontrado = new UsuarioVO();
		
		alunoEncontrado.setEmail(email);
		alunoEncontrado.setSenha(senha);
		alunoEncontrado.setTipoUsuario("admin");
		
		return alunoEncontrado;
	}

	public ArrayList<UsuarioVO> setLista(UsuarioVO usuario){
				
		ArrayList<UsuarioVO> listaUsuarios = new ArrayList<UsuarioVO>();
		//UsuarioVO usuario = new UsuarioVO();
		        listaUsuarios.add(usuario);
				return listaUsuarios;
	}
	
	public ArrayList<UsuarioVO> getLista(){
		
		ArrayList<UsuarioVO> listaUsuarios = new ArrayList<UsuarioVO>();
				return listaUsuarios;
	}*/
	
}

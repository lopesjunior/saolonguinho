package br.com.saolonguinho.dao;

//import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

import br.com.saolonguinho.vo.UsuarioVO;

public class InsereUsuarioDAO extends ConexaoMySQL {

	UsuarioVO usuarioVO = null;

	InsereUsuarioDAO() throws SQLException {

	}

	public static boolean insereNovoUsuario(UsuarioVO usuario) throws SQLException {

		String sql = "";
		sql = "INSERT INTO USUARIO(USUARIO,EMAIL,SENHA,IDUSUARIO) VALUES('" + usuario.getNome() + "','" + usuario.getEmail() + "','"
				+ usuario.getSenha() + "','" + usuario.getIdUsuario() + "')";
		return executaQuery(sql);
		//return true;
	}

	public static boolean executaQuery(String sql) {

		Statement stmt = null;

		try {
			stmt = (Statement) conexao.createStatement();
			stmt.executeUpdate(sql);
		} catch (Exception e) {
			System.out.println("Erro........ =====> " + e.getMessage());
			return false;
		}
		return true;
	}

}

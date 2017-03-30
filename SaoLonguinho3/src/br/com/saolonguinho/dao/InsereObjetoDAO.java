package br.com.saolonguinho.dao;

import java.sql.SQLException;

import com.mysql.jdbc.Statement;

import br.com.saolonguinho.vo.ObjetoVO;

public class InsereObjetoDAO extends ConexaoMySQL {

	ObjetoVO objetoVO = null;

	InsereObjetoDAO() throws SQLException {

	}

	public static boolean insereNovoObjeto(ObjetoVO objeto) throws SQLException {

		String sql = "";
		sql = "INSERT INTO OBJETO(NOMEOBJETO,LOCAL,DATA) VALUES('" + objeto.getNomeObjeto() + "','" + objeto.getLocalObjeto() + "','"
				+ objeto.getData() + "')";
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

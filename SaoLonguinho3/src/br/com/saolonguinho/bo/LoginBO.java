package br.com.saolonguinho.bo;

import java.sql.SQLException;

import br.com.saolonguinho.dao.LoginDAO;

public class LoginBO {
    public boolean checaSeUsuarioESenhaEstaoNoBanco(String usuario, String senha) throws SQLException, ClassNotFoundException {
        LoginDAO loginDAO = new LoginDAO();
        return loginDAO.ChecaUsuarioESenhaDoUsuarioNoBanco(usuario, senha);
    }

}

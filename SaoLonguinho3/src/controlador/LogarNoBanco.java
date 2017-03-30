package controlador;

import java.sql.SQLException;

import br.com.saolonguinho.bo.LoginBO;

public class LogarNoBanco {
	
	public boolean efetuarLogin() throws SQLException, ClassNotFoundException{
		LoginBO loginBO = new LoginBO();
		boolean result = loginBO.checaSeUsuarioESenhaEstaoNoBanco("root", "");
	    return result;
	}
}

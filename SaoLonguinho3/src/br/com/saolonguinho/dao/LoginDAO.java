package br.com.saolonguinho.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.saolonguinho.vo.UsuarioVO;
import controlador.SaoLonguinhoMySQL;


public class LoginDAO extends SaoLonguinhoMySQL{
	    
	    UsuarioVO usuarioVO = null;
	    
	    public LoginDAO() throws SQLException, ClassNotFoundException{
	    }
	   
	    
	    /*Excluir
	    public void getDadosDosUsuarios() throws SQLException {
	        String sql = "";
	        UsuarioVO usuarioVO = null;
	        
	        sql = "SELECT * FROM USUARIO";
	        
	        ResultSet rs = executaQueryConsulta(sql);
	        
	        while (rs.next()) {
	            usuarioVO = new UsuarioVO();
	            usuarioVO.setEmail(rs.getString("EMAIL"));
	           System.out.println("Email:::::: "+usuarioVO.getEmail());
	        }
	    }
	    */
	    
	    
	    public UsuarioVO getDadosDoUsuarioByEmailESenha(String email,String senha) throws SQLException {
	        String sql = "";
	        UsuarioVO usuarioVO = null;
	        
	        sql = "SELECT * FROM USUARIO WHERE EMAIL = '"+email+"' AND SENHA = '"+senha+"'";
	        
	        ResultSet rs = executaQueryConsulta(sql);
	        
	        while (rs.next()) {
	            usuarioVO = new UsuarioVO();
	            usuarioVO.setEmail(rs.getString("EMAIL"));
	            usuarioVO.setNome(rs.getString("USUARIO"));
	            usuarioVO.setSenha(rs.getString("SENHA"));	
	            usuarioVO.setIdUsuario(rs.getInt("IDUSUARIO"));	            

	        }
	        return usuarioVO;
	    }
	    
	    public boolean addMaisUmNoContador() throws SQLException{
	    	
	    	String sql = "";
	    	sql = "UPDATE ID SET CONTADOR = (CONTADOR+1) WHERE CONTADOR";
	    	return executaQuery(sql);
	    }
	    
	    
	    public int getContador() throws SQLException{
	    	
	    	int contador = 0;
	    	String sql = "";
	    	sql = "SELECT * FROM id WHERE contador";
	    	ResultSet rs = executaQueryConsulta(sql);
	    	while(rs.next()){
	    		contador = rs.getInt("CONTADOR");
	    	}	
	    	return contador;
	    }
	    
	    public UsuarioVO getDadosDoUsuarioByNomeDoUsuario(String nomeUsuario) throws SQLException {
	        String sql = "";
	        UsuarioVO usuarioVO = null;
	        
	        sql = "SELECT * FROM USUARIO WHERE USUARIO = '" +nomeUsuario+ "' LIMIT 20";
	        
	        ResultSet rs = executaQueryConsulta(sql);
	        
	        if (rs.next()) {
	            usuarioVO = new UsuarioVO();
	            usuarioVO.setNome(rs.getString("NOME"));
	            return usuarioVO;
	        }else    
	            return usuarioVO;
	    }
	    

        public boolean ChecaUsuarioESenhaDoUsuarioNoBanco(String usuario, String senha) throws SQLException{
	        
	        String sql = "";
	        //sql = "SELECT * FROM usuario WHERE usuario = '"+usuario+"' and SENHA = md8 ("+senha+") LIMIT 1";
	        sql = "SELECT * FROM usuario WHERE usuario ='"+usuario+"' and SENHA ='"+senha+"'";
	        
	        ResultSet rs = executaQueryConsulta(sql);
	        
	        if (rs.next()) {
    	            return false;
	        }else
	            return true;
        }
	
}

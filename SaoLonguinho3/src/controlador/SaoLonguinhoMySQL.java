package controlador;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.saolonguinho.dao.ConexaoMySQL;
import br.com.saolonguinho.dao.IConexao;

 
public class SaoLonguinhoMySQL {	
		
	IConexao saoLonguinho = new ConexaoMySQL();
	//Connection conexao = null;
		//conexao = biblioteca.getConexao("jdbc:mysql","localhost","bibliotecass","usuario","senha");
	
	
	static Connection conexao; 
	    
	public SaoLonguinhoMySQL() throws SQLException, ClassNotFoundException {
		conexao = saoLonguinho.getConexao("jdbc:mysql","localhost");
		//conexao = ConexaoMySQL.getConexao("jdbc:mysql","localhost","sao_longuinho","usuario","senha");
	}
	    
	
	public static boolean executaQuery(String sql){
	         
	    Statement stmt = null;

	    try{
	        stmt = conexao.createStatement();
	        stmt.executeUpdate(sql);        }
	    catch(Exception e){
	        System.out.println("Erro = "+e.getMessage());
	        return false;
	    }
	    return true;
	    }
	    
	public String removerEspacos(String str) {
	    str = str.trim();
	    str = str.replaceAll("/\\s(?=\\s)/","");
	    str = str.replaceAll("/[\n\r\t]/","");

	        return str;
	    }
	    
	    public static String FormataDataParaCadastroNoBanco(Date data) {
	        if (data == null) {
	            data = new Date(System.currentTimeMillis());
	        }
	        SimpleDateFormat formatoData = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	        return formatoData.format(data);
	    }
	    
	    public String FormataDataParaExibir(Date data) {
	        SimpleDateFormat formatoDataComHora = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	        if (data == null) {
	            return "--/--/-- --:--";
	        }
	 
	        return formatoDataComHora.format(data);
	    }
	    
	    public void insert(String tabela, String[] camposComValores) {
	        
	        String sql = "INSERT INTO "+tabela+" (";
	        String valores 	= "VALUES (";
	        int num = camposComValores.length;
	        String[] aux;

	        for(int i=0; i< num; i++){
	                aux = camposComValores[i].split("==");

	                if(i == 0) {
	                        sql += aux[0];
	                        valores += "'" +removerEspacos(aux[1])+"'";
	                }
	                else {
	                        sql += ", "+ aux[0];
	                        valores += ", '" +removerEspacos(aux[1]) +"'";
	                }
	            }
	        sql += ") " +valores+")";
	        
	        executaQuery(sql);
	        System.out.println("INSERT EXECUTADO COM SUCESSO");
	    }

	    public void delete(String tabela,String condicao, String codigos) {
	        
	        executaQuery("DELETE FROM "+ tabela +" WHERE "+ condicao +" in ("+ codigos +")");
	        System.out.println("DELETE EXECUTADO COM SUCESSO");
	            
	    }

	    public void update(String tabela, String[] camposComValores, String condicao, String codigo) {
	        
	        String sql = "UPDATE " +tabela+ " SET ";
	        int num = camposComValores.length;
	        String ValorDoCampo = null;
	        String[] aux;

	        for(int i=0; i < num; i++) {
	                aux = camposComValores[i].split("==");
	                ValorDoCampo = (removerEspacos(aux[1]).equals("NULL")) ? removerEspacos(aux[1]) : "'" +removerEspacos(aux[1])+ "'";

	                if(i == 0)
	                        sql += aux[0]+ " = " +ValorDoCampo;
	                else
	                        sql += ", " +aux[0]+ " = " +ValorDoCampo;
	        }

	        sql += " WHERE " +condicao+ " = '" +codigo+ "'";
	        
	        executaQuery(sql);
	        System.out.println("UPDATE EXECUTADO COM SUCESSO");
	    }
	      
	    public static ResultSet executaQueryConsulta(String consulta) throws SQLException {
	            
	        PreparedStatement stmt = conexao.prepareStatement(consulta);
	        ResultSet rs = stmt.executeQuery();
	        
	        return rs;
	    }
	    
	    public static String[] uniOsCamposComOsRespectivosValores(String[] campos, String[] valores){
	        String[] CamposComOsValores = new String[campos.length];
	        
	        for (int i = 0; i < campos.length; i++) {
	            CamposComOsValores[i] = campos[i]+ "==" +valores [i];
	        }
	    
	        return CamposComOsValores;
	    
	    }
}

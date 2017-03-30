package controlador;

/*
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.saolonguinho.dao.InsereObjetoDAO;
import br.com.saolonguinho.vo.ObjetoVO;
import br.com.saolonguinho.vo.UsuarioVO;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;


@WebServlet("/cadastraObjeto")
public class CadastraObjeto extends HttpServlet {
	
	//private LogarNoBanco login;

	
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
         
   	
    	// pegando os parâmetros do request
    	String nome = request.getParameter("nome");
    	String local = request.getParameter("local");
    	String data = request.getParameter("data");
        
    	PrintWriter out = response.getWriter();
                
     // monta um objeto do tipo Objeto
        ObjetoVO objetoVO = new ObjetoVO();
        objetoVO.setNomeObjeto(nome);
        objetoVO.setLocalObjeto(local);
        objetoVO.setData(data);
        
        /*UsuarioVO usuarioVO = new UsuarioVO();                         não funciona. recuperar informações do usuario
        objetoVO.setNomeDoUsuario(usuarioVO.getNome());
        System.out.println("--------------->"+objetoVO.getNomeDoUsuario());*/

        //objetoVO.setData(data); 
       /* 
        try{  
        	InsereObjetoDAO.insereNovoObjeto(objetoVO);      	                	      
	       //if(InsereObjetoDAO.insereNovoObjeto(objetoVO)){
	       		Cookie cookieObjeto;
	       		cookieObjeto = new Cookie("objeto",objetoVO.getNomeObjeto());
	       		cookieObjeto = new Cookie("local",objetoVO.getLocalObjeto());
	       		cookieObjeto = new Cookie("data",objetoVO.getData());

	       		response.addCookie(cookieObjeto);
	    		response.sendRedirect("adicionarObjeto.html");
	        
	      // }
	       // else{
	    		//response.sendRedirect("adicionarObjeto.html");

	        	//System.out.println("Objeto NAO CADASTRADO!!!!");  //IMPRIMIR ALERTA NA TELA DE CADASTRO
	        //}
        //}catch(NumberFormatException e) {
			//out.println("Algum erro ocorreu");
		} catch (SQLException e) {

    		response.sendRedirect("adicionarObjeto.html");
			out.println("erro ocorreu-------->"+e);
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//destroy();
       		
		//response.sendRedirect("adicionarObjeto.html");

        }
}
*/
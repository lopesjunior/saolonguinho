package controlador;
/*
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.saolonguinho.dao.InsereUsuarioDAO;
import br.com.saolonguinho.dao.LoginDAO;
import br.com.saolonguinho.dao.UsuarioDAO;
import br.com.saolonguinho.vo.UsuarioVO;


@WebServlet(name = "login", urlPatterns = "/login")
public class Login extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String email = req.getParameter("email");
		String senha = req.getParameter("senha");
				
		try{
	        LogarNoBanco login = new LogarNoBanco();
	        boolean resultado = login.efetuarLogin();
	        //resultado = true;

        	LoginDAO usuario = new LoginDAO();       
           	//usuario.getDadosDosUsuarios();      EXCLUIR
        	
	        if(resultado == true){
	        	UsuarioVO usuarioVO = new UsuarioVO();
	        	usuarioVO = usuario.getDadosDoUsuarioByEmailESenha(email,senha);
	        	
        		//PrintWriter writer = resp.getWriter();
                
        	   	if(usuarioVO!=null){
	        		
	        		Cookie cookieUsuario;
	        		//System.out.println("nome do usuario: "+usuarioVO.getNome()+"\nEmail: "+usuarioVO.getEmail());
	        		cookieUsuario= new Cookie("usuario.logado",usuarioVO.getNome());
	        		//cookieUsuario = new Cookie("email",usuarioVO.getEmail());
	        		
	        		resp.addCookie(cookieUsuario);
	        		resp.sendRedirect("home.jsp");
	        		
	        		//writer.println("<html><body><h3>Usuário LOGADO:</h3></body></html>"+usuarioVO.getNome());
	        	}else{
	        		
	        		//              *********IMPLEMETAR UM ALERTA NA login.html QUE USUARIO OU SENHA SÃO INVALIDOS*****
	        		
	        		//writer.println("<html><body><h3>Usuario NAO ENCONTRADO!!!!</h3></body></html>");
	        		//Cookie cookieUsuario2 = new Cookie("ivalido","ususario ou senha");
	        		//resp.addCookie(cookieUsuario2);                     
	        		resp.sendRedirect("index.html");
	        		
	        	}

	        }
	        else
	        	System.out.println("Sem acesso ao banco de dados!!!!"+email+"||"+senha);
	        /*UsuarioDAO dao = new UsuarioDAO();
	        dao.setLista(usuario);*/
	        
	        // imprime o nome do contato que foi adicionado
	        /*out.println("<html>");
	        out.println("<body>");
	        out.println("<h3>Usuario " + usuario.getNome() + " cadastrado com sucesso!!!</h3>");    
	        out.println("</body>");
	        out.println("");
	        out.println("</html>");*/
	        
        //}catch(NumberFormatException e) {
	/*		//out.println("Algum erro ocorreu");
		} catch (SQLException e) {
			System.out.println("erro ocorreu-------->"+e);
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("erro:::::::::::::");
			e.printStackTrace();
		}
		
		destroy();
        
        //RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.html");
        //requestDispatcher.forward(request, response);
        
		

		
		
		//PrintWriter writer = resp.getWriter();
		//writer.println("<html><body>Usuário oooook</body></html>");

		//System.out.println("Usuario: "+email);
		
		//UsuarioVO usuario = new UsuarioDAO().buscaPorEmailESenha(email, senha);

		//PrintWriter writer = resp.getWriter();
/*
		if (usuario.getEmail().equals(email)) {
			Cookie cookieUsuario = new Cookie("usuario.logado", email);
			resp.addCookie(cookieUsuario);
			resp.sendRedirect("admin/administracao.jsp");
		} else {
			writer.println("<html><body>Usuário ou senha inválida</body></html>");
		}*/
//	}
//}

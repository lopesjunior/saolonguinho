package controlador;

import java.io.IOException;
import java.io.PrintWriter;
/*
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
*/
public class Deslogar{
	
	protected void blablabla(){
		
	}
	
}
/*
@WebServlet(name = "logout", urlPatterns = "/logout")
public class Deslogar extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		Cookie[] cookies = req.getCookies();
		String usuario = "deslogado";

		for (Cookie cookie : cookies) {
			//System.out.println("Cheguei no Cookie");
			Cookie cookieLogado;
			if (cookie.getName().equals("usuario.logado")) {
				cookieLogado = cookie;
				usuario = cookie.getValue();

				if (usuario == null) {
					writer.println("<html><body><h1>Não estava logado</h1></body>/html>");
				} else {
					cookieLogado.setMaxAge(0);
					resp.addCookie(cookieLogado);
					writer.println("<html><body><h1>Deslogado com sucesso!</h1></body></html>");
	 			}
			}
		}resp.sendRedirect("index.html");

	}
}
*/

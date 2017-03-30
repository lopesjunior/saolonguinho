package br.com.saolonguinho.bean;

import java.sql.SQLException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.com.saolonguinho.dao.InsereUsuarioDAO;
import br.com.saolonguinho.dao.LoginDAO;
import br.com.saolonguinho.vo.UsuarioVO;
//import controlador.Cookie;
import controlador.LogarNoBanco;


@ManagedBean(name = "usuarioBean")
@RequestScoped

public class UsuarioBean {
	private String nome;
	private String sobreNome;
	private String email;
	private int id;
	private String senha;
	private String confirmaSenha;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobreNome() {
		return sobreNome;
	}
	public void setSobreNome(String sobreNome) {
		this.sobreNome = sobreNome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getConfirmaSenha() {
		return confirmaSenha;
	}
	public void setConfirmaSenha(String confirmaSenha) {
		this.confirmaSenha = confirmaSenha;
	}
	
	public String novo(){
		
		
		return "cadastraUsuario";
	}
	
	public String logar(){
		
		try{
	        LogarNoBanco login = new LogarNoBanco();
	        boolean resultado = login.efetuarLogin();
	        //resultado = true;

        	LoginDAO usuario = new LoginDAO();       
           	//usuario.getDadosDosUsuarios();      EXCLUIR
        	
	        if(resultado == true){
	        	UsuarioVO usuarioVO = new UsuarioVO();
	        	usuarioVO = usuario.getDadosDoUsuarioByEmailESenha(email,senha);
	        	                
        	   	if(usuarioVO!=null){

        	   		FacesContext.getCurrentInstance().getExternalContext().getFlash().put("nome", usuarioVO.getNome());
        			FacesContext.getCurrentInstance().getExternalContext().getFlash().put("email", usuarioVO.getEmail());
        			FacesContext.getCurrentInstance().getExternalContext().getFlash().put("id", usuarioVO.getIdUsuario());

        	   		return "mostraUsuario?faces-redirect=true";
        	   	}
        	   	else{
        			FacesContext context = FacesContext.getCurrentInstance();
        			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Email ou senha inválido(s).",""));
                    return "login";
        	   	}
	        }
		}catch(NumberFormatException e) {
					//out.println("Algum erro ocorreu");
			} catch (SQLException e) {
				System.out.println("erro ocorreu-------->"+e);
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println("erro:::::::::::::");
				e.printStackTrace();
			}
		return "login";
	}
	
	public String salvar(){
		//Regra do BO
		
		FacesContext.getCurrentInstance().getExternalContext().getFlash().put("nome", this.getNome());
		//FacesContext.getCurrentInstance().getExternalContext().getFlash().put("sobrenome", this.getSobreNome());
		FacesContext.getCurrentInstance().getExternalContext().getFlash().put("email", this.getEmail());
		FacesContext.getCurrentInstance().getExternalContext().getFlash().put("senha", this.getEmail());
		FacesContext.getCurrentInstance().getExternalContext().getFlash().put("confirmaSenha", this.getConfirmaSenha());

		FacesContext context = FacesContext.getCurrentInstance();
		if(!this.senha.equalsIgnoreCase(confirmaSenha)){
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Senha confirmada incorretamente",""));
			return "cadastraUsuario";
		}
		
		UsuarioVO usuarioVO = new UsuarioVO();
    	usuarioVO.setNome(nome);
        usuarioVO.setEmail(email);
        usuarioVO.setSenha(senha); 
        
        try {
			LoginDAO usuario = new LoginDAO();
			if(usuario.addMaisUmNoContador()){
				usuarioVO.setIdUsuario(usuario.getContador());
				System.out.println("ID: "+usuarioVO.getIdUsuario());
			}
		} catch (ClassNotFoundException | SQLException e1) {
			
			e1.printStackTrace();
		}       
        
        try{
        	                	       
	        LogarNoBanco login = new LogarNoBanco();
	        boolean resultado = login.efetuarLogin();
	        //resultado = true;
	        if(resultado == true){
	        	if(InsereUsuarioDAO.insereNovoUsuario(usuarioVO)){
	        		return "mostraUsuario?faces-redirect=true";
	        		//System.out.println("Usuario cadastrado!"); 
	    			/*Cookie cookieUsuario;
	    			cookieUsuario= new Cookie("usuario.logado",usuarioVO.getNome());
	    			cookieUsuario = new Cookie("email",usuarioVO.getEmail());
	    		
	    			response.addCookie(cookieUsuario);
	    			response.sendRedirect("home.jsp");*/
	        	}
	        }
	        else
	        	System.out.println("Usuario NAO CADASTRADO!!!!");  //IMPRIMIR ALERTA NA TELA DE CADASTRO: USUARIO JA EXISTNTE
	        	        
        //}catch(NumberFormatException e) {
			//out.println("Algum erro ocorreu");
		} catch (SQLException e) {
			/*response.sendRedirect("cadastro.html");
			out.println("erro ocorreu-------->"+e);*/
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			/*System.out.println("erro:::::::::::::");
			response.sendRedirect("cadastro.html");*/
			e.printStackTrace();
		}
		
		/*System.out.println("Nome: " +this.getNome());
		System.out.println("Sobrenome: " +this.getSobreNome());
		System.out.println("Email: " +this.getEmail());*/
        

    	return "";
		
	}

	
}

package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Usuario;
import util.Erro;

@WebServlet(urlPatterns = "/usuario/*")

public class UsuarioController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioLogado");
    	Erro erros = new Erro();
    	
    	if (usuario == null) {
    		response.sendRedirect(request.getContextPath());
    	} else if (usuario.getPapel().equals("CLIENTE")) {
    		String action = request.getPathInfo();
            if (action == null) {
                action = "";
            }

            try {
                RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/usuario/index.jsp");
                dispatcher.forward(request, response);    	
            } catch (RuntimeException | IOException | ServletException e) {
                throw new ServletException(e);
            }
    	} else {
    		erros.add("Acesso não autorizado!");
    		erros.add("Apenas [USER] tem acesso a essa página");
    		request.setAttribute("mensagens", erros);
    		RequestDispatcher rd = request.getRequestDispatcher("/noAuth.jsp");
    		rd.forward(request, response);
    	}    	
    }

}

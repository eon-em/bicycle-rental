package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BicicletaDAO;
import domain.Bicicleta;
import dao.LocadoraDAO;
import dao.UsuarioDAO;
import domain.Locadora;
import domain.Usuario;
import util.Erro;

@WebServlet(urlPatterns = "/locadora/*")

public class LocadoraController extends HttpServlet {
private static final long serialVersionUID = 1L;
    
    private LocadoraDAO dao;
    private BicicletaDAO daoBicicleta;
    private UsuarioDAO daoUsuario;

    @Override
    public void init() {
        dao = new LocadoraDAO();
        daoUsuario = new UsuarioDAO();
        daoBicicleta = new BicicletaDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioLogado");
    	Erro erros = new Erro();
    	
    	if (usuario == null) {
    		response.sendRedirect(request.getContextPath());
    	} else if (usuario.getPapel().equals("LOCADORA")) {
    		String action = request.getPathInfo();
            if (action == null) {
                action = "";
            }
	        try {
	            switch (action) {
	                case "/cadastro":
	                    apresentaFormCadastro(request, response);
	                    break;
	                case "/insercao":
	                    insere(request, response);
	                    break;
	                case "/remocao":
	                    remove(request, response);
	                    break;
	                case "/edicao":
	                    apresentaFormEdicao(request, response);
	                    break;
	                case "/atualizacao":
	                    atualize(request, response);
	                    break;
	                case "/lista":
	                    lista(request, response);
	                    break;
	                default:
	                	RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/locadora/index.jsp");
	                    dispatcher.forward(request, response);
	                    break;
	            }
	        } catch (RuntimeException | IOException | ServletException e) {
	            throw new ServletException(e);
	        }
		} else {
			erros.add("Acesso não autorizado!");
			erros.add("Apenas [LOCADORA] tem acesso a essa página");
			request.setAttribute("mensagens", erros);
			RequestDispatcher rd = request.getRequestDispatcher("/noAuth.jsp");
			rd.forward(request, response);
		}
    }

    private void lista(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioLogado");
        List<Bicicleta> listaBicicletas = daoBicicleta.getAll(usuario.getId());
        request.setAttribute("listaBicicletas", listaBicicletas);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/locadora/listaBicicletaLocadora.jsp");
        dispatcher.forward(request, response);
    }

    private Map<Long, String> getLocadoras() {
        Map <Long,String> locadoras = new HashMap<>();
        for (Locadora locadora: new LocadoraDAO().getAll()) {
            locadoras.put(locadora.getId_usuario(), locadora.getNome());
        }
        return locadoras;
    }
    
    private void apresentaFormCadastro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("locadoras", getLocadoras());
        RequestDispatcher dispatcher = request.getRequestDispatcher("/locadoras/formulario.jsp");
        dispatcher.forward(request, response);
    }

    private void apresentaFormEdicao(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long id = (long) Integer.parseInt(request.getParameter("id"));
        Locadora locadora = dao.get(id);
        Usuario usuario = daoUsuario.getbyID(id);
        request.setAttribute("Locadora", locadora);
        request.setAttribute("Usuario", usuario);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/locadoras/formulario.jsp");
        dispatcher.forward(request, response);
    }

    private void insere(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        
        Long id = Long.parseLong(request.getParameter("id"));
        String nome = request.getParameter("nome");
        String descricao = request.getParameter("descricao");
        String cnpj = request.getParameter("cnpj");
        
        Locadora locadora = new Locadora(id, nome, descricao, cnpj);
        dao.insert(locadora);
        response.sendRedirect("lista");
    }

    private void atualize(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	
    	
    	Long id = Long.parseLong(request.getParameter("id"));
    	String nome = request.getParameter("nome");
        String descricao = request.getParameter("descricao");
        String cnpj = request.getParameter("cnpj");
       
        
        Locadora locadora = new Locadora(id, nome, descricao, cnpj);
        dao.update(locadora);
        response.sendRedirect("lista");
    }

    private void remove(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        Long id_usuario = Long.parseLong(request.getParameter("id"));

        Locadora locadora = new Locadora(id_usuario);
        dao.delete(locadora);
        response.sendRedirect("lista");
    }
}

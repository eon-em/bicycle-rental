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
import dao.LocadoraDAO;
import domain.Bicicleta;
import domain.Locadora;
import domain.Usuario;

@WebServlet(urlPatterns = "/bicicleta/*")

public class BicicletaController extends HttpServlet {
private static final long serialVersionUID = 1L;
    
    private BicicletaDAO dao;
    private LocadoraDAO locadoraDao;

    @Override
    public void init() {
        dao = new BicicletaDAO();
        locadoraDao = new LocadoraDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException {
                
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
                case "/listaLocadoras":
                    listaLocadoras(request, response);
                    break;
            }
        } catch (RuntimeException | IOException | ServletException e) {
            throw new ServletException(e);
        }
    }

    private void lista(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Bicicleta> listaBicicletas = dao.getAll();
        request.setAttribute("listaBicicletas", listaBicicletas);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/bicicletas/lista.jsp");
        dispatcher.forward(request, response);
    }

    private void listaLocadoras(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Locadora> listaLocadoras = locadoraDao.getAll();
        request.setAttribute("listaLocadoras", listaLocadoras);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/locadoras/lista.jsp");
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
        Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioLogado");
        request.setAttribute("Usuario", usuario);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/bicicletas/formulario.jsp");
        dispatcher.forward(request, response);
    }

    private void apresentaFormEdicao(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        Bicicleta bicicleta = dao.get(id);
        request.setAttribute("bicicleta", bicicleta);
        request.setAttribute("locadoras", getLocadoras());
        RequestDispatcher dispatcher = request.getRequestDispatcher("/locadoras/formulario.jsp");
        dispatcher.forward(request, response);
    }

    private void insere(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        
        String placa = request.getParameter("placa");
        String modelo = request.getParameter("modelo");
        String chassi = request.getParameter("chassi");
        Integer ano = Integer.parseInt(request.getParameter("ano"));
        Integer quilometragem = Integer.parseInt(request.getParameter("quilometragem"));
        String descricao = request.getParameter("descricao");
        Float valor = Float.parseFloat(request.getParameter("valor"));
        String fotos = request.getParameter("fotos");
        
        Long id_locadora = Long.parseLong(request.getParameter("locadora"));
        Locadora locadora = new LocadoraDAO().get(id_locadora);
        
        Bicicleta bicicleta = new Bicicleta(locadora, placa, modelo, chassi, ano, quilometragem, descricao, valor, fotos);
        dao.insert(bicicleta);
    	RequestDispatcher dispatcher = request.getRequestDispatcher("/locadora/lista");
        dispatcher.forward(request, response);

    }

    private void atualize(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	
    	Long id_bicicleta = Long.parseLong(request.getParameter("id"));
    	String placa = request.getParameter("placa");
        String modelo = request.getParameter("modelo");
        String chassi = request.getParameter("chassi");
        Integer ano = Integer.parseInt(request.getParameter("ano"));
        Integer quilometragem = Integer.parseInt(request.getParameter("quilometragem"));
        String descricao = request.getParameter("descricao");
        Float valor = Float.parseFloat(request.getParameter("valor"));
        String fotos = request.getParameter("fotos");
        
        Long id_locadora = Long.parseLong(request.getParameter("locadora"));
        Locadora locadora = new LocadoraDAO().get(id_locadora);
        
        Bicicleta bicicleta = new Bicicleta(id_bicicleta, locadora, placa, modelo, chassi, ano, quilometragem, descricao, valor, fotos);
        dao.update(bicicleta);
    	RequestDispatcher dispatcher = request.getRequestDispatcher("/locadora/lista");
        dispatcher.forward(request, response);
    }

    private void remove(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long id_bicicleta = Long.parseLong(request.getParameter("id"));

        Bicicleta bicicleta = new Bicicleta(id_bicicleta);
        dao.delete(bicicleta);
    	RequestDispatcher dispatcher = request.getRequestDispatcher("/locadora/lista");
        dispatcher.forward(request, response);
    }
}

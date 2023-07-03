package controller;

import java.io.IOException;
import java.time.LocalDate;
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
import dao.ClienteDAO;
import dao.LocadoraDAO;
import domain.Bicicleta;
import domain.Cliente;
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
                case "/listaLocacoesCliente":
                    listaLocacoesCliente(request, response);
                    break;
                case "/listaLocacoesLocadora":
                    listaLocacoesLocadora(request, response);
                    break;
                case "/listaLocadoras":
                    listaLocadoras(request, response);
                    break;
            }
        } catch (RuntimeException | IOException | ServletException e) {
            throw new ServletException(e);
        }
    }

    private void listaLocacoesLocadora(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioLogado");
        List<Bicicleta> listaBicicletas = dao.getAllByLocadora(usuario.getId());
        request.setAttribute("listaBicicletas", listaBicicletas);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/locadora/lista.jsp");
        dispatcher.forward(request, response);
    }

    private void listaLocacoesCliente(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioLogado");
        List<Bicicleta> listaBicicletas = dao.getAllByCliente(usuario.getId());
        request.setAttribute("listaBicicletas", listaBicicletas);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/usuario/lista.jsp");
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

    private Long getLocadoraIdByName(String name) {
        Map <String,Long> locadoras = new HashMap<>();
        for (Locadora locadora: new LocadoraDAO().getAll()) {
            locadoras.put(locadora.getNome(), locadora.getId_usuario());
        }
        return locadoras.get(name);
    }
    
    private void apresentaFormCadastro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Locadora> locadoras = locadoraDao.getAll();
        request.setAttribute("locadoras", locadoras);
        Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioLogado");
        request.setAttribute("usuario", usuario);
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

        Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioLogado");
        String locadoraName = request.getParameter("locadora");
        LocalDate dataLocacao = LocalDate.parse(request.getParameter("dataLocacao"));

        Long locadoraId = getLocadoraIdByName(locadoraName);

        Cliente cliente = new ClienteDAO().get(usuario.getId());
        Locadora locadora = new LocadoraDAO().get(locadoraId);
        
        Bicicleta bicicleta = new Bicicleta(cliente, locadora, dataLocacao);
        dao.insert(bicicleta);
    	RequestDispatcher dispatcher = request.getRequestDispatcher("/usuario/lista");
        dispatcher.forward(request, response);

    }

    private void atualize(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	
        Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioLogado");
        String locadoraName = request.getParameter("locadora");
        LocalDate dataLocacao = LocalDate.parse(request.getParameter("dataLocacao"));

        Long locadoraId = getLocadoraIdByName(locadoraName);

        Cliente cliente = new ClienteDAO().get(usuario.getId());
        Locadora locadora = new LocadoraDAO().get(locadoraId);
        
        Bicicleta bicicleta = new Bicicleta(cliente, locadora, dataLocacao);
        dao.update(bicicleta);
    	RequestDispatcher dispatcher = request.getRequestDispatcher("/usuario/lista");
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

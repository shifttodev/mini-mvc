package io.minimvc.servlet;

import io.minimvc.domain.ListarLivros;
import io.minimvc.model.Livro;
import io.minimvc.service.LivroService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/listar")
public class ListarServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LivroService service = new LivroService();

        List<Livro> livros = service.listarTodos();

        RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/view/listar.jsp");

        req.setAttribute("livros", livros);
        rd.forward(req, resp);
    }
}

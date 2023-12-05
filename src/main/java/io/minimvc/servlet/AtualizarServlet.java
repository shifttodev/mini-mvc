package io.minimvc.servlet;

import io.minimvc.model.Livro;
import io.minimvc.service.LivroService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/atualizar")
public class AtualizarServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String isbn = req.getParameter("isbn");
        LivroService service = new LivroService();

        Livro livro = service.buscarPorISBN(isbn);
        req.setAttribute("livro", livro);
        RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/view/form.jsp");
        rd.forward(req, resp);
    }
}

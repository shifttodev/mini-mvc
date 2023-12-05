package io.minimvc.servlet;

import io.minimvc.model.Livro;
import io.minimvc.service.LivroService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/salvar")
public class SalvarServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String acao = req.getParameter("acao");

        if (acao.equalsIgnoreCase("inserir")){
            String isbn = req.getParameter("isbn");
            String titulo = req.getParameter("titulo");
            String autor = req.getParameter("autor");
            Integer ano = Integer.valueOf(req.getParameter("ano"));
            Livro livro = new Livro(isbn, titulo, autor, ano);
            LivroService service = new LivroService();
            service.inserir(livro);
        }

        if (acao.equalsIgnoreCase("atualizar")){
            String id = req.getParameter("id");
            String isbn = req.getParameter("isbn");
            String titulo = req.getParameter("titulo");
            String autor = req.getParameter("autor");
            Integer ano = Integer.valueOf(req.getParameter("ano"));
            LivroService service = new LivroService();
            Livro livro = service.buscarPorISBN(isbn);
            livro.setTitulo(titulo);
            livro.setAutor(autor);
            livro.setAno(ano);
            service.atualizar(livro);
        }

        resp.sendRedirect("/listar");
    }
}

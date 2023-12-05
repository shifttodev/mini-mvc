package io.minimvc.servlet;

import com.github.javafaker.Faker;
import io.minimvc.model.Livro;
import io.minimvc.service.LivroService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/gerar")
public class GerarServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Faker faker = new Faker();

        LivroService service = new LivroService();

        for (int i = 0; i < 5; i++){
            Livro livro = new Livro();
            livro.setIsbn(faker.code().isbn13());
            livro.setTitulo(faker.book().title());
            livro.setAutor(faker.book().author());
            livro.setAno(faker.number().numberBetween(2000, 2023));

            service.inserir(livro);
        }

        resp.sendRedirect("/listar");

    }

}

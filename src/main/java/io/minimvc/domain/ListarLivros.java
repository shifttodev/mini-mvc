package io.minimvc.domain;

import io.minimvc.service.LivroService;
import io.minimvc.model.Livro;

import java.util.List;

public class ListarLivros implements Acao {
    @Override
    public void executar() {
        LivroService service = new LivroService();

        List<Livro> livros = service.listarTodos();

        if (livros.size() == 0){
            System.out.println("Nenhum registro encontrado.");
        } else {
            livros.forEach(System.out::println);
        }
    }
}

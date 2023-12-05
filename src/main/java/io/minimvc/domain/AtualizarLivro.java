package io.minimvc.domain;

import io.minimvc.service.LivroService;
import io.minimvc.model.Livro;

import java.util.Scanner;

public class AtualizarLivro implements Acao {


    @Override
    public void executar() {
        Scanner entrada = new Scanner(System.in);
        LivroService service = new LivroService();

        System.out.print("Entre com o isbn do livro: ");
        String isbn = entrada.nextLine();

        Livro livro = service.buscarPorISBN(isbn);

        if (livro != null){
            System.out.println(livro);

            System.out.printf("Entre com o título do livro [%s]: ", livro.getTitulo());
            String titulo = entrada.nextLine();

            System.out.printf("Entre com o autor do livro [%s]: ", livro.getAutor());
            String autor = entrada.nextLine();

            System.out.printf("Entre com o ano do livro [%d]: ", livro.getAno());
            String ano = entrada.nextLine();

            titulo = !titulo.isEmpty() ? titulo : livro.getTitulo();
            autor = !autor.isEmpty() ? autor : livro.getAutor();
            ano = !ano.isEmpty() ? ano : livro.getAno().toString();

            livro.setTitulo(titulo);
            livro.setAutor(autor);
            livro.setAno(Integer.valueOf(ano));

            if (service.atualizar(livro)){
                System.out.println("Registro atualizado com sucesso.");
            } else {
                System.out.println("Nenhum registro atualizado.");
            }
        }
    }
}

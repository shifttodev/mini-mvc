package io.minimvc.domain;

import io.minimvc.service.LivroService;
import io.minimvc.model.Livro;

import java.util.Scanner;

public class ListarLivroPorISBN implements Acao {
    @Override
    public void executar() {
        LivroService service = new LivroService();

        Scanner entrada = new Scanner(System.in);
        System.out.print("Entre com o isbn do livro: ");
        String isbn = entrada.nextLine();
        Livro livro = service.buscarPorISBN(isbn);

        if (livro != null)
            System.out.println(livro);
    }
}

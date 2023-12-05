package io.minimvc.domain;

import io.minimvc.service.LivroService;

import java.util.Scanner;

public class DeletarLivro implements Acao {
    @Override
    public void executar() {
        Scanner entrada = new Scanner(System.in);
        LivroService service = new LivroService();

        System.out.print("Entre com o isbn do livro: ");
        String isbn = entrada.nextLine();

        if (service.deletar(isbn)){
            System.out.println("Registro removido com sucesso.");
        } else {
            System.out.println("Nenhum registro removido.");
        }
    }
}

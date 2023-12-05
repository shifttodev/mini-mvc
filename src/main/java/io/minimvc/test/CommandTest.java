package io.minimvc.test;

import io.minimvc.domain.*;
import java.util.Scanner;

public class CommandTest {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        ExecutorDeAcao eda = new ExecutorDeAcao();

        while (true) {
            System.out.println("Entre com o opção desejada: ");
            System.out.print(
                    "0 - Sair\n" +
                    "1 - Listar Todos\n" +
                    "2 - Listar por ISBN\n" +
                    "3 - Inserir\n" +
                    "4 - Deletar\n" +
                    "5 - Atualizar\n" +
                    "> ");

            int opcao = Integer.parseInt(entrada.nextLine());

            switch (opcao) {
                case 0:
                    entrada.close();
                    System.exit(0);
                    break;
                case 1:
                    eda.executarAcao(new ListarLivros());
                    break;
                case 2:
                    eda.executarAcao(new ListarLivroPorISBN());
                    break;
                case 3:
                    eda.executarAcao(new InserirLivro());
                    break;
                case 4:
                    eda.executarAcao(new DeletarLivro());
                    break;
                case 5:
                    eda.executarAcao(new AtualizarLivro());
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }
    }
}
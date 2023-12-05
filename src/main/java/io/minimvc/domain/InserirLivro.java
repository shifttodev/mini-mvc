package io.minimvc.domain;

import com.github.javafaker.Faker;
import io.minimvc.service.LivroService;
import io.minimvc.model.Livro;

public class InserirLivro implements Acao {
    @Override
    public void executar() {
        Faker faker = new Faker();
        LivroService service = new LivroService();

        for (int i = 0; i < 5; i++){
            Livro livro = new Livro();
            livro.setIsbn(faker.code().isbn13());
            livro.setTitulo(faker.book().title());
            livro.setAutor(faker.book().author());
            livro.setAno(faker.number().numberBetween(2000, 2023));

            if (service.inserir(livro)){
                System.out.printf("Livro %s inserido com sucesso.\n", livro.getTitulo());
            } else {
                System.out.println("Nenhum registro inserido.");
            }
        }
    }
}

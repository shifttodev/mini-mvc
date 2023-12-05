package io.minimvc.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Livro {
    private Integer id;
    @NonNull
    private String isbn;
    @NonNull
    private String titulo;
    @NonNull
    private String autor;
    @NonNull
    private Integer ano;

    @Override
    public String toString(){
        return String.format(
                "%03d %13s %-30s %-30s %d",
                this.id, this.isbn, this.titulo, this.autor, this.ano
        );
    }
}

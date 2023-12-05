package io.minimvc.dao;

import io.minimvc.model.Livro;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public interface ILivroDAO {

    public boolean inserir(Livro livro);
    public boolean deletar(String isbn);

    public List<Livro> listar();

    public Livro buscarPorISBN(String isbn);

    public boolean atualizar(Livro livro);
}

package io.minimvc.service;

import io.minimvc.dao.ConnectionFactory;
import io.minimvc.dao.ILivroDAO;
import io.minimvc.dao.LivroDAO;
import io.minimvc.model.Livro;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class LivroService {
    ConnectionFactory cf = null;
    ILivroDAO dao = null;

    public LivroService(){
        this.cf = new ConnectionFactory();
    }

    public boolean inserir(Livro livro){
        try(Connection conn = this.cf.getConnection()){
            dao = new LivroDAO(conn);
            return dao.inserir(livro);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Livro> listarTodos(){
        List<Livro> livros;

        try(Connection conn = this.cf.getConnection()){
            dao = new LivroDAO(conn);
            livros = dao.listar();

        } catch (SQLException e){
            throw new RuntimeException(e);
        }

        return livros;
    }

    public boolean deletar(String isbn) {
        try(Connection conn = this.cf.getConnection()){
            dao = new LivroDAO(conn);
            return dao.deletar(isbn);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public Livro buscarPorISBN(String isbn){
        Livro livro = null;
        try(Connection conn = this.cf.getConnection()){
            dao = new LivroDAO(conn);
            livro = dao.buscarPorISBN(isbn);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }

        return livro;
    }

    public boolean atualizar(Livro livro){
        try(Connection conn = this.cf.getConnection()){
            dao = new LivroDAO(conn);
            return dao.atualizar(livro);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}

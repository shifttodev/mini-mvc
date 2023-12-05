package io.minimvc.dao;

import io.minimvc.model.Livro;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LivroDAO implements ILivroDAO{
    private final Connection conn;

    public LivroDAO(Connection conn){
        this.conn = conn;
    }

    public boolean inserir(Livro livro){

        String sql = "INSERT INTO livro (isbn, titulo, autor, ano) " +
                "VALUES (?,?,?,?)";
        int row = 0;
        try(
            PreparedStatement ps = conn.prepareStatement(sql);
        ){
            ps.setString(1, livro.getIsbn());
            ps.setString(2, livro.getTitulo());
            ps.setString(3, livro.getAutor());
            ps.setInt(4, livro.getAno());
            row = ps.executeUpdate();
            ps.clearParameters();

            if (row < 1){
                System.out.println("Nenhum registro inserido.");
            }

        } catch (SQLException e){
            throw new RuntimeException(e);
        }

        return (row > 0);
    }

    public boolean deletar(String isbn){

        String sql = "DELETE FROM livro WHERE isbn = ?";
        int row = 0;

        try (
            PreparedStatement ps = conn.prepareStatement(sql);
        ){
            ps.setString(1, isbn);
            row = ps.executeUpdate();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }

        return row > 0;
    }

    public List<Livro> listar(){
        List<Livro> livros = new ArrayList<>();

        try(
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM livro");
        ){
            while (rs.next()){
                Livro livro = new Livro();
                livro.setId(rs.getInt("id"));
                livro.setIsbn(rs.getString("isbn"));
                livro.setTitulo(rs.getString("titulo"));
                livro.setAutor(rs.getString("autor"));
                livro.setAno(rs.getInt("ano"));

                livros.add(livro);
            }
        } catch (SQLException e){
            throw new RuntimeException(e);
        }

        return livros;
    }

    public Livro buscarPorISBN(String isbn){
        Livro livro = null;

        try (PreparedStatement ps = conn.prepareStatement("SELECT * FROM livro WHERE isbn = ?")) {
            ps.setString(1, isbn);
            try(ResultSet rs = ps.executeQuery()){
                if (rs.next()){
                    livro = new Livro();
                    livro.setId(rs.getInt("id"));
                    livro.setIsbn(rs.getString("isbn"));
                    livro.setTitulo(rs.getString("titulo"));
                    livro.setAutor(rs.getString("autor"));
                    livro.setAno(rs.getInt("ano"));
                } else {
                    System.out.println("Registro não encontrado.");
                }
            }

        } catch (SQLException e){
            throw new RuntimeException(e);
        }

        return livro;

    }

    public boolean atualizar(Livro livro){
        int row = 0;
        String sql = "UPDATE livro SET " +
                "titulo = ?," +
                "autor = ?," +
                "ano = ? " +
                "WHERE isbn = ?";

        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, livro.getTitulo());
            ps.setString(2, livro.getAutor());
            ps.setInt(3, livro.getAno());
            ps.setString(4, livro.getIsbn());
            row = ps.executeUpdate();
            ps.clearParameters();

            if (row < 1){
                System.out.println("Nenhum registro alterado.");
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }

        return row > 0;
    }
}

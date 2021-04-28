package com.marianaa.prova2704.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.marianaa.prova2704.model.Categoria;
import com.marianaa.prova2704.model.Filme;


public class FilmeDao {

    public Connection connection;

    public void createFilmeTableNotExists(){
        String sql = "create table if not exists filme(id int primary key auto_increment, CategoriaId int not null, nome varchar(100) not null, CONSTRAINT fk_idFilmeCategoria foreign key (categoriaId) references categoria(id);";

        try {
            PreparedStatement statement= connection.prepareStatement(sql);
            statement.execute();
            statement.close();
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }

    //nova entidade
    public void addFilme(Filme filme){
        String sql = "insert into filme (CategoriaID, nome) values (?,?);";

        try {
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, filme.getCategoria().getId());
            statement.setString(2, filme.getNome());
            statement.execute();
            ResultSet resultSet = statement.getGeneratedKeys();
            while(resultSet.next()){
                filme.setId(resultSet.getInt(1));
            }
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }

    //lista
    public List<Filme> listFilme() {
        String sql = "select  * from filme;";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            List<Filme> filmes = new ArrayList<>();
            Filme filme;

            while(resultSet.next ()){
                filme = new Filme();
                filme.setNome(resultSet.getString("nome"));
                CategoriaDAO categoriaDAO = new CategoriaDAO();
                Categoria categoria = categoriaDAO.findById(resultSet.getInt("categoriaId"));
                filme.setCategoria(categoria);
                filmes.add(filme);
            }

            return filmes;

        } catch (SQLException exception) {
            System.out.println("List Filmes DAO ERROR");
            throw new RuntimeException(exception);
        }
    }
    
}

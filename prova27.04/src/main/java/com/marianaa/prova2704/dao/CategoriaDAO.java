package com.marianaa.prova2704.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.marianaa.prova2704.model.Categoria;

public class CategoriaDAO {

    public Connection connection;

    public void createFilmeTableNotExists(){
        String sql = "create table if not exists categoria(id int primary key auto_increment, nome varchar(100) not null;";

        try {
            PreparedStatement statement= connection.prepareStatement(sql);
            statement.execute();
            statement.close();
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }

    //nova entidade
    public void addCategoria(Categoria categoria){
        String sql = "insert into categoria (nome) values (?);";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, categoria.getNome());
            statement.execute();
            statement.close();
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }

    //lista
    public List<Categoria> listCategoria() {
        String sql = "select  * from categoria;";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            List<Categoria> categorias = new ArrayList<>();
            Categoria categoria;

            while(resultSet.next ()){
                categoria = new Categoria();
                categoria.setNome(resultSet.getString("nome"));

                categorias.add(categoria);
            }

            return categorias;

        } catch (SQLException exception) {
            System.out.println("List Categoria DAO ERROR");
            throw new RuntimeException(exception);
        }
    }

    public Categoria findById(int id) {
        String sql = "select * from categoria where id = ?;";
        try {
          PreparedStatement statement = connection.prepareStatement(sql);
          statement.setInt(1, id);
          ResultSet resultSet = statement.executeQuery();
    
          Categoria categoria = new Categoria();
          while (resultSet.next()) {
            categoria.setId(resultSet.getInt("id"));
            categoria.setNome(resultSet.getString("nome"));
        
          }
          return categoria;
        } catch (SQLException e) {
          throw new RuntimeException(e);
        }
      }
    
}

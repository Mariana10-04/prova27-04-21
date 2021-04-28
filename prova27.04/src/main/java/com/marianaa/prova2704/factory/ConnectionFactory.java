package com.marianaa.prova2704.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public Connection getConnection(){
        try{
            return DriverManager.getConnection("jdbc:mysql://localhost/filmes", "root","");
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}

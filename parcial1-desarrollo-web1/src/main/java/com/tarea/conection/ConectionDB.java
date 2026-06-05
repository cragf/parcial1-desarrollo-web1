package com.tarea.conection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectionDB {
    private static final ConectionDB instancia = new ConectionDB();
    private static final String url = "jdbc:mariadb://localhost:3306/p1dw1";
    private static final String user = "root";
    private static final String pass = "1234";

    private ConectionDB(){}
    
    public static ConectionDB Getconexion(){
        return instancia;
    }
    
    public Connection Conectar() throws SQLException {
        return DriverManager.getConnection(url,user,pass);
    }
}

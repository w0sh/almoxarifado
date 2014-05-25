package br.ufg.inf.almoxarifado.data.util;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author wos
 */
public class ConnectionFactory {
    private static ConnectionFactory instance = null;
    private Connection conexao;
    
    private final String JDBC_DRIVER="jdbc:oracle:thin:@localhost:1521:xe";
    private final String USER_NAME="wos";
    private final String PASSWD="abc123";
    
    private ConnectionFactory() throws SQLException {
        conexao = DriverManager.getConnection(JDBC_DRIVER, USER_NAME, PASSWD);
    }

    public Connection getConnection() {
        return conexao;
    }

    public static ConnectionFactory getInstance() throws SQLException {
        if (instance == null) {
            instance = new ConnectionFactory();
        }
        System.out.println("Conectado...");
        return instance;
    }
}

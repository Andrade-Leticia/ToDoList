package com.Alana.projeto.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoMySQL {
    private static ConexaoMySQL instance;

    private final String URL = "jdbc:mysql://127.0.0.1:3306/tdePOO?useSSL=false&serverTimezone=UTC";
    private final String USER = "root";
    private final String PASS = "Aq1570508";

    private ConexaoMySQL() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // opcional para JDBC 4+
            System.out.println("Driver MySQL carregado!");
        } catch (ClassNotFoundException e) {
            System.err.println("Driver MySQL não encontrado!");
            e.printStackTrace();
        }
    }

    public static ConexaoMySQL getInstance() {
        if (instance == null) {
            instance = new ConexaoMySQL();
        }
        return instance;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}



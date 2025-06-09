package com.Alana.projeto.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoMySQL {
    private static ConexaoMySQL instance;
    private Connection conexao;

    private final String URL = "jdbc:mysql://127.0.0.1:3306/tdePOO?useSSL=false&serverTimezone=UTC";
    private final String USER = "root";
    private final String PASS = "Aq1570508";

    private ConexaoMySQL() {
        try {
            // Carregar driver explicitamente (opcional para JDBC 4+)
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Conexão com MySQL estabelecida!");
        } catch (ClassNotFoundException e) {
            System.err.println("Driver MySQL não encontrado!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Erro ao conectar no banco de dados");
            e.printStackTrace();
        }
    }

    public static ConexaoMySQL getInstance() {
        if (instance == null) {
            instance = new ConexaoMySQL();
        }
        return instance;
    }

    public Connection getConnection() {
        return conexao;
    }
}



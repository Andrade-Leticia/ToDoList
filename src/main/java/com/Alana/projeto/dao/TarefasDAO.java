package com.Alana.projeto.dao;

import com.Alana.projeto.model.Tarefas;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TarefasDAO {

    public List<Tarefas> listarTarefas() throws SQLException {
        List<Tarefas> tarefas = new ArrayList<>();
        String sql = "SELECT * FROM tarefas";

        try (Connection conn = ConexaoMySQL.getInstance().getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Tarefas tarefa = new Tarefas(
                        rs.getInt("id_tarefas"),
                        rs.getString("titulo"),
                        rs.getString("descricao"),
                        rs.getBoolean("status")
                );
                tarefas.add(tarefa);
            }
        }

        return tarefas;
    }

    public void adicionarTarefa(Tarefas tarefa) throws SQLException {
        String sql = "INSERT INTO tarefas (titulo, descricao, status) VALUES (?, ?, ?)";

        try (Connection conn = ConexaoMySQL.getInstance().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, tarefa.getTitulo());
            pstmt.setString(2, tarefa.getDescricao());
            pstmt.setBoolean(3, tarefa.isStatus());

            pstmt.executeUpdate();
        }
    }

    public void atualizarTarefa(Tarefas tarefa) throws SQLException {
        String sql = "UPDATE tarefas SET titulo=?, descricao=?, status=? WHERE id_tarefas=?";

        try (Connection conn = ConexaoMySQL.getInstance().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, tarefa.getTitulo());
            pstmt.setString(2, tarefa.getDescricao());
            pstmt.setBoolean(3, tarefa.isStatus());
            pstmt.setInt(4, tarefa.getId());

            pstmt.executeUpdate();
        }
    }

    public void remover(int id) throws SQLException {
        String sql = "DELETE FROM tarefas WHERE id_tarefas=?";

        try (Connection conn = ConexaoMySQL.getInstance().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
    }

    public void marcarComoConcluida(int id) throws SQLException {
        String sql = "UPDATE tarefas SET status=true WHERE id_tarefas=?";

        try (Connection conn = ConexaoMySQL.getInstance().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
    }

    public Tarefas buscarTarefaPorId(int id) throws SQLException {
        String sql = "SELECT * FROM tarefas WHERE id_tarefas = ?";
        Tarefas tarefa = null;

        try (Connection conn = ConexaoMySQL.getInstance().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    tarefa = new Tarefas(
                            rs.getInt("id_tarefas"),
                            rs.getString("titulo"),
                            rs.getString("descricao"),
                            rs.getBoolean("status")
                    );
                }
            }
        }

        return tarefa;
    }
}

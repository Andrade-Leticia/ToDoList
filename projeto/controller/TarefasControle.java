package com.Alana.projeto.controller;

import com.Alana.projeto.dao.TarefasDAO;
import com.Alana.projeto.model.Tarefas;


import java.sql.SQLException;
import java.util.List;

public class TarefasControle {

    private TarefasDAO tarefasDAO = new TarefasDAO();

    public List<Tarefas> listar() throws SQLException {
        return tarefasDAO.listarTarefas();
    }

    public void adicionar(String titulo, String descricao) throws SQLException {
        Tarefas tarefa = new Tarefas(0, titulo, descricao, false);
        tarefasDAO.adicionarTarefa(tarefa);
    }

    public void editar(int id, String titulo, String descricao, boolean status) throws SQLException {
        Tarefas tarefas = new Tarefas(id, titulo, descricao, status);
        tarefasDAO.atualizarTarefa(tarefas);
    }

    public void excluir(int id) throws SQLException {
        tarefasDAO.excluirTarefa(id);
    }

    public void concluir(int id) throws SQLException {
        tarefasDAO.marcarComoConcluida(id);
    }
}

package com.Alana.projeto;


import com.Alana.projeto.dao.TarefasDAO;
import com.Alana.projeto.model.Tarefas;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            TarefasDAO dao = new TarefasDAO();
            List<Tarefas> tarefas = dao.listarTarefas();

            for (Tarefas t : tarefas) {
                System.out.println("ID: " + t.getId());
                System.out.println("Título: " + t.getTitulo());
                System.out.println("Descrição: " + t.getDescricao());
                System.out.println("Concluída: " + (t.isStatus() ? "Sim" : "Não"));
                System.out.println("----------");
            }
        } catch (Exception e) {
            System.err.println("Erro: " + e.getMessage());
            e.printStackTrace();
        }
    }
}



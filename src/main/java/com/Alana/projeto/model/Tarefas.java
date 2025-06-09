package com.Alana.projeto.model;


public class Tarefas {
    private int id_tarefas;
    private String titulo;
    private String descricao;
    private boolean status;

    // Construtores
    public Tarefas() {}

    public Tarefas(int id_tarefas, String titulo, String descricao, boolean status) {
        this.id_tarefas = id_tarefas;
        this.titulo = titulo;
        this.descricao = descricao;
        this.status = status;
    }

    public int getId() { return id_tarefas; }
    public void setId(int id_tarefas) { this.id_tarefas = id_tarefas; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public boolean isStatus() { return status; }
    public void setStatus(boolean status) { this.status = status; }
}

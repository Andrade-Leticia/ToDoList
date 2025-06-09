package com.Alana.projeto.servelet;

import com.Alana.projeto.dao.TarefasDAO;
import com.Alana.projeto.model.Tarefas;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/adicionar")
public class AdicionarTarefaServlet extends HttpServlet {

    private TarefasDAO tarefasDAO = new TarefasDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Exibe o formulário JSP para adicionar tarefa
        request.getRequestDispatcher("/adicionar.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Recebe os dados do formulário
        String titulo = request.getParameter("titulo");
        String descricao = request.getParameter("descricao");

        if (titulo == null || titulo.trim().isEmpty()) {
            // Erro simples: título obrigatório
            request.setAttribute("erro", "Título é obrigatório");
            request.getRequestDispatcher("/adicionar.jsp").forward(request, response);
            return;
        }

        try {
            // Cria nova tarefa e salva no banco
            Tarefas tarefa = new Tarefas(0, titulo, descricao, false);
            tarefasDAO.adicionarTarefa(tarefa);

            // Redireciona para lista com sucesso
            response.sendRedirect("listarTarefas?sucesso=adicionado");
        } catch (SQLException e) {
            throw new ServletException("Erro ao adicionar tarefa", e);
        }
    }
}

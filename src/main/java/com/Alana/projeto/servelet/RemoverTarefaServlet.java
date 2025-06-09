package com.Alana.projeto.servelet;

import com.Alana.projeto.dao.TarefasDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/remover")
public class RemoverTarefaServlet extends HttpServlet {
    private TarefasDAO tarefasDAO = new TarefasDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idStr = request.getParameter("id");
        if (idStr != null) {
            try {
                int id = Integer.parseInt(idStr);
                tarefasDAO.remover(id);  // Você vai implementar isso no DAO
                response.sendRedirect("listarTarefas"); // Redireciona para a lista atualizada
            } catch (SQLException e) {
                throw new ServletException("Erro ao remover tarefa", e);
            }
        } else {
            response.sendRedirect("listarTarefas");
        }
    }
}

package com.Alana.projeto.servelet;

import com.Alana.projeto.dao.TarefasDAO;
import com.Alana.projeto.model.Tarefas;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/listarTarefas")
public class ListarTarefasServlet extends HttpServlet {

    private TarefasDAO tarefasDAO = new TarefasDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Tarefas> tarefas = tarefasDAO.listarTarefas();
            request.setAttribute("tarefas", tarefas); // Coloca lista no request para JSP
            request.getRequestDispatcher("/listaTarefas.jsp").forward(request, response); // Encaminha para a JSP
        } catch (SQLException e) {
            throw new ServletException("Erro ao listar tarefas", e);
        }
    }
}

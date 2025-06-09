package com.Alana.projeto.servelet;

import com.Alana.projeto.dao.TarefasDAO;
import com.Alana.projeto.model.Tarefas;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/editar")
public class EditarTarefaServlet extends HttpServlet {

    private TarefasDAO tarefasDAO = new TarefasDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idParam = request.getParameter("id");
        try {
            int id = Integer.parseInt(idParam);
            Tarefas tarefa = tarefasDAO.buscarTarefaPorId(id);
            if (tarefa != null) {
                request.setAttribute("tarefa", tarefa);
                request.getRequestDispatcher("editarTarefa.jsp").forward(request, response);
            } else {
                response.sendRedirect("listarTarefas?erro=tarefa_nao_encontrada");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("listarTarefas?erro=dados_invalidos");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id_tarefas"));
            String titulo = request.getParameter("titulo");
            String descricao = request.getParameter("descricao");

            Tarefas tarefa = new Tarefas(id, titulo, descricao, false); // ou true se já estiver concluída
            tarefasDAO.atualizarTarefa(tarefa);
            response.sendRedirect("listarTarefas?sucesso=editada");
        } catch (SQLException | NumberFormatException e) {
            e.printStackTrace();
            response.sendRedirect("listarTarefas?erro=erro_edicao");
        }
    }
}

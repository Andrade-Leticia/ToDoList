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

@WebServlet("/marcarConcluida")
public class MarcarConcluidaServlet extends HttpServlet {

    private TarefasDAO tarefasDAO = new TarefasDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idStr = request.getParameter("id");

        if (idStr == null || idStr.isEmpty()) {
            response.sendRedirect("listarTarefas?erro=id_nao_fornecido");
            return;
        }

        try {
            int id = Integer.parseInt(idStr);
            Tarefas tarefa = tarefasDAO.buscarTarefaPorId(id);

            if (tarefa == null) {
                response.sendRedirect("listarTarefas?erro=tarefa_nao_encontrada");
                return;
            }

            // Alterna o status da tarefa (true <-> false)
            boolean novoStatus = !tarefa.isStatus();
            tarefa.setStatus(novoStatus);
            tarefasDAO.atualizarTarefa(tarefa);

            response.sendRedirect("listarTarefas?sucesso=status_atualizado");
        } catch (NumberFormatException e) {
            response.sendRedirect("listarTarefas?erro=id_invalido");
        } catch (SQLException e) {
            response.sendRedirect("listarTarefas?erro=falha_status&msg=" + e.getMessage());
        }
    }
}


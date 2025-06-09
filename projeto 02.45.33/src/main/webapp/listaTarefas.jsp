<%--
  Created by IntelliJ IDEA.
  User: alanaqueiroz
  Date: 08/06/25
  Time: 23:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
  <meta charset="UTF-8">
  <title>Lista de Tarefas</title>
  <link rel="stylesheet" href="css/listaTarefas.css">
</head>
<body>
<h1>Lista de Tarefas</h1>
<a href="adicionar" class="btn-adicionar">Adicionar nova tarefa</a>
<p style="color: green;">
  <c:if test="${param.sucesso ne null}">
    <c:choose>
      <c:when test="${param.sucesso eq 'remocao'}">Tarefa removida com sucesso!</c:when>
      <c:when test="${param.sucesso eq 'status_atualizado'}">Status da tarefa atualizado com sucesso!</c:when>
      <c:otherwise>Operação realizada com sucesso!</c:otherwise>
    </c:choose>
  </c:if>
</p>
<p style="color: red;">
  <c:if test="${param.erro ne null}">
    <c:choose>
      <c:when test="${param.erro eq 'id_nao_fornecido'}">Erro: ID da tarefa não fornecido.</c:when>
      <c:when test="${param.erro eq 'id_invalido'}">Erro: ID da tarefa inválido.</c:when>
      <c:when test="${param.erro eq 'falha_remocao'}">Erro ao remover tarefa: <c:out value="${param.msg}"/></c:when>
      <c:when test="${param.erro eq 'falha_status'}">Erro ao atualizar status: <c:out value="${param.msg}"/></c:when>
      <c:when test="${param.erro eq 'tarefa_nao_encontrada'}">Erro: Tarefa não encontrada.</c:when>
      <c:when test="${param.erro eq 'dados_invalidos'}">Erro: Dados inválidos para edição.</c:when>
      <c:otherwise>Ocorreu um erro.</c:otherwise>
    </c:choose>
  </c:if>
</p>

<table border="1">
  <thead>
  <tr>
    <th>ID</th>
    <th>Título</th>
    <th>Descrição</th>
    <th>Status</th>
    <th>Ações</th>
  </tr>
  </thead>
  <tbody>
  <c:choose>
    <c:when test="${empty requestScope.tarefas}">
      <tr>
        <td colspan="5">Nenhuma tarefa cadastrada.</td>
      </tr>
    </c:when>
    <c:otherwise>
      <%-- Itera sobre a lista de tarefas que o Servlet colocou no request --%>
      <c:forEach var="tarefa" items="${requestScope.tarefas}">
        <tr class="${tarefa.status ? 'concluida' : ''}">
          <td><c:out value="${tarefa.id}"/></td> <td><c:out value="${tarefa.titulo}"/></td>
          <td><c:out value="${tarefa.descricao}"/></td>
          <td>
            <a href="marcarConcluida?id=<c:out value='${tarefa.id}'/>&status=<c:out value='${!tarefa.status}'/>">
              <c:choose>
                <c:when test="${tarefa.status}">Concluída</c:when>
                <c:otherwise>Pendente</c:otherwise>
              </c:choose>
            </a>
          </td>
          <td>
            <a href="editar?id=${tarefa.id}">Editar</a>
            <a href="remover?id=<c:out value='${tarefa.id}'/>" onclick="return confirm('Tem certeza que deseja remover esta tarefa?');">Remover</a>
          </td>
        </tr>
      </c:forEach>
    </c:otherwise>
  </c:choose>
  </tbody>
</table>

<style>
  .concluida {
    text-decoration: line-through;
    color: gray;
  }
</style>

</body>
</html>
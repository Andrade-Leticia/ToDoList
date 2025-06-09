<%--
  Created by IntelliJ IDEA.
  User: alanaqueiroz
  Date: 09/06/25
  Time: 01:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
  <meta charset="UTF-8" />
  <title>Editar Tarefa</title>
  <link rel="stylesheet" href="css/adicionarTarefa.css" />
  <script src="js/validacao.js"></script>
</head>
<body>
<div class="container">
  <h1>Editar Tarefa</h1>

  <c:if test="${not empty erro}">
    <p class="erro">${erro}</p>
  </c:if>

  <c:choose>
    <c:when test="${not empty tarefa}">
      <form action="editar" method="post" class="form-nova-tarefa" onsubmit="return validarFormulario()">
        <input type="hidden" name="id_tarefas" value="${tarefa.id}" />

        <label for="titulo">Título:</label>
        <input type="text" id="titulo" name="titulo" value="${tarefa.titulo}" required />

        <label for="descricao">Descrição:</label>
        <textarea id="descricao" name="descricao">${tarefa.descricao}</textarea>

        <button type="submit">Salvar Alterações</button>
        <a href="listarTarefas" class="btn-voltar">Voltar para a lista</a>
      </form>
    </c:when>
    <c:otherwise>
      <p style="color:red;">Ocorreu um erro ao carregar a tarefa para edição.</p>
      <a href="listarTarefas" class="btn-voltar">Voltar</a>
    </c:otherwise>
  </c:choose>

</div>
</body>
</html>


<%--
  Created by IntelliJ IDEA.
  User: alanaqueiroz
  Date: 09/06/25
  Time: 01:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
  <meta charset="UTF-8" />
  <title>Adicionar Tarefa</title>
  <link rel="stylesheet" href="css/adicionarTarefa.css" />
  <script src="js/validacao.js"></script> <!-- Seu JS de validação -->
</head>
<body>

<div class="container">
  <h1>Adicionar Nova Tarefa</h1>

  <c:if test="${not empty erro}">
    <p style="color: red;">${erro}</p>
  </c:if>

  <form action="adicionar" method="post" onsubmit="return validarFormulario()">
    <label for="titulo">Título:</label>
    <input type="text" id="titulo" name="titulo" required />

    <label for="descricao">Descrição:</label>
    <textarea id="descricao" name="descricao"></textarea>

    <button type="submit">Adicionar</button>
    <a href="listarTarefas" class="btn-voltar">Voltar para a lista</a>
  </form>
</div>

</body>
</html>


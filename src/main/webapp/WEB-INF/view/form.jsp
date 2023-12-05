<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp" />
  <c:choose>
    <c:when test="${empty livro}">
      <form action="/salvar" method="post" class="mt-3">
        <input type="hidden" name="acao" value="inserir">
        <div class="form-group">
          <label for="isbn">ISBN:</label>
          <input type="text" class="form-control" id="isbn" name="isbn" value="${livro.isbn}" required>
        </div>
        <div class="form-group">
          <label for="titulo">Título:</label>
          <input type="text" class="form-control" id="titulo" name="titulo" value="${livro.titulo}" required>
        </div>
        <div class="form-group">
          <label for="autor">Autor:</label>
          <input type="text" class="form-control" id="autor" name="autor" value="${livro.autor}" required>
        </div>
        <div class="form-group">
          <label for="ano">Ano:</label>
          <input type="number" class="form-control" id="ano" name="ano" min="2000" max="2023" value="${livro.ano}" required>
        </div>
        <button type="submit" class="btn btn-primary">Atualizar</button>
      </form>
    </c:when>
    <c:otherwise>
    <form action="/salvar" method="post" class="mt-3">
        <input type="hidden" name="acao" value="atualizar">
        <input type="hidden" name="id" value="${livro.id}">
        <div class="form-group">
          <label for="isbn">ISBN:</label>
          <input type="text" class="form-control" id="isbn" name="isbn" value="${livro.isbn}" required>
        </div>
        <div class="form-group">
          <label for="titulo">Título:</label>
          <input type="text" class="form-control" id="titulo" name="titulo" value="${livro.titulo}" required>
        </div>
        <div class="form-group">
          <label for="autor">Autor:</label>
          <input type="text" class="form-control" id="autor" name="autor" value="${livro.autor}" required>
        </div>
        <div class="form-group">
          <label for="ano">Ano:</label>
          <input type="number" class="form-control" id="ano" name="ano" value="${livro.ano}" required>
        </div>
        <button type="submit" class="btn btn-primary">Atualizar</button>
      </form>
    </c:otherwise>
  </c:choose>
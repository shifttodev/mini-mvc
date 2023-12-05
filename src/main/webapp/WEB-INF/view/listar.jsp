<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    language="java" %>
<jsp:include page="header.jsp"/>
      <c:choose>
        <c:when test="${empty livros}">
          <div class="alert alert-warning mt-3" role="alert">
            Nenhum registro encontrado
          </div>
        </c:when>
        <c:otherwise>
        <table class="table table-striped table-bordered mt-3">
          <thead>
          <tr>
            <th>ISBN</th>
            <th>TÍTULO</th>
            <th>AUTOR</th>
            <th style="text-align: center">ANO</th>
            <th style="text-align: center">AÇÃO</th>
          </tr>
          </thead>
          <tbody>
          <c:forEach items="${livros}" var="livro">
            <tr>
              <td>${livro.isbn}</td>
              <td>${livro.titulo}</td>
              <td>${livro.autor}</td>
              <td style="text-align: center">${livro.ano}</td>
              <td style="text-align: center">
                <a class="mr-3" href="/atualizar?isbn=${livro.isbn}">
                  <i data-toggle="tooltip" data-placement="top" title="Atualizar" class="bi bi-pencil"></i>
                </a>|
                <a class="ml-3" href="/deletar?isbn=${livro.isbn}">
                  <i data-toggle="tooltip" data-placement="top" title="Deletar" class="bi bi-trash"></i>
                </a>
              </td>
            </tr>
          </c:forEach>
        </tbody>
      </table>
        </c:otherwise>
      </c:choose>
      </div>
    </div>
  </div>
</body>
</html>
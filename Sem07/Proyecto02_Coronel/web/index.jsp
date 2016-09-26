<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
  </head>
  <body>
    <h1>NAVEGANDO ANDO</h1>

    <!-- Mostrar mensaje de error -->
    <c:if test="${requestScope.error != null}">
      <p style="color: red;">${requestScope.error}</p>
    </c:if>

    <!-- Formulario -->
    <form method="post" action="NavegandoController">
      Consumo:
      <input type="text" name="consumo" />
      <input type="submit" value="Procesar"/>
    </form>

    <!-- Resultado -->
    <c:if test="${requestScope.repo != null}">
      <h2>RESULTADO DEL CONSUMO</h2>
      <table border="1">
        <tr>
          <th>DESCRIPCION</th>
          <th>PRECIO POR GB</th>
          <th>GB</th>
          <th>IMPORTE</th>
        </tr>

        <c:forEach items="${requestScope.repo}" var="r">
          <tr>
            <td>${r.descripcion}</td>
            <td>${r.precio}</td>
            <td>${r.consumo}</td>
            <td>${r.importe}</td>
          </tr>
        </c:forEach>

        <tr>
          <th colspan="2">${requestScope.total.descripcion}</th>
          <th>${requestScope.total.consumo}</th>
          <th>${requestScope.total.importe}</th>
        </tr> 

      </table>
    </c:if>
  </body>
</html>

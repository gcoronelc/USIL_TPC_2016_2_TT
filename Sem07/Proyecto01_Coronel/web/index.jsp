<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>PROYECTO 01</title>
  </head>
  <body>
    <h1>PROYECTO 01</h1>

    <c:if test="${requestScope.error != null}">
      <p style="color: red;font-size: 20px;">
        ${requestScope.error}
      </p>
    </c:if>

    <form method="post" action="ProcesaDinero">
      Cantidad de Soles:
      <input type="text" name="valor" />
      <input type="submit" value="Procesar"/>
    </form>

    <!-- RESPUESTA -->
    <c:if test="${requestScope.arreglo != null}">
      <h2>RESULTADO</h2>

      <p>Total: ${requestScope.total}</p>
      <table border="1">
        <tr>
          <th>DENOMINACION</th>
          <th>CANT</th>
          <th>IMPORTE</th>
        </tr>

        <c:forEach items="${requestScope.arreglo}" var="r">
          <tr>
            <td>${r.denominacion}</td>
            <td>${r.cant}</td>
            <td>${r.importe}</td>
          </tr>
        </c:forEach>
      </table>
    </c:if>

  </body>
</html>

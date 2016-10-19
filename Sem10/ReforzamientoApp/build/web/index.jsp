<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="css/estilos.css" rel="stylesheet" type="text/css"/>
    <title>JSP Page</title>
  </head>
  <body>
    <div class="egcc_content">
      <h1>MANTENIMIENTO CLIENTES</h1>
      
      <c:if test="${requestScope.mensaje != null}">
        <p class="egcc_par">${requestScope.mensaje}</p>
      </c:if>
      
      <form method="post" action="Consulta">
        <table>
          <tr>
            <td>NOMBRE</td>
            <td>PATERNO</td>
            <td>MATERNO</td>
            <td></td>
          </tr>
          <tr>
            <td><input type="text" name="nombre" /></td>
            <td><input type="text" name="paterno" /></td>
            <td><input type="text" name="materno" /></td>
            <td>
              <input type="submit" value="Consulta" name="btnConsulta" />
              <input type="submit" value="Nuevo" name="btnNuevo"/>
            </td>
          </tr>
        </table>
      </form>

      <!-- Resultado -->
      <c:if test="${requestScope.lista != null}">
        <table class="egcc_table">
          <thead>
          <th>CODIGO</th>
          <th>PATERNO</th>
          <th>MATERNO</th>
          <th>NOMBRE</th>
          <th>EMAIL</th>
          <th>ACCION</th>
          </thead>
          <tbody>
            <c:forEach items="${requestScope.lista}" var="r">
              <tr>
                <td>${r.codigo}</td>
                <td>${r.paterno}</td>
                <td>${r.materno}</td>
                <td>${r.nombre}</td>
                <td>${r.email}</td>
                <td>
                  <a href="Editar?codigo=${r.codigo}">Editar</a>
                </td>
              </tr>
            </c:forEach>
          </tbody>
        </table>
      </c:if>
    </div>
  </body>
</html>

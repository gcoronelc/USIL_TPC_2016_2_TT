<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>LISTA DE PROMOCIONES</title>
  </head>
  <body>
    <h2>LISTADO</h2>
    <table class="tftable">
      <thead>
        <tr>
          <th>IDPROM</th>
          <th>F.INICIO</th>
          <th>F.FIN</th>
          <th>NOMBRE</th>
          <th>P.OFERTA</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach items="${requestScope.listado}" var="r">
        <tr>
          <td>${r.idprom}</td>
          <td>${r.fecinicio}</td>
          <td>${r.fecfin}</td>
          <td>${r.nombre}</td>
          <td>${r.oferta}</td>
        </tr>
        </c:forEach>
      </tbody>
      

    </table>
  </body>
</html>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
  </head>
  <body>
    <h1>COCINA PERUANA</h1>
    <h2>RESULTADO</h2>
    <table>
      <tr>
        <td>Curso:</td>
        <td>${requestScope.model.curso}</td>
      </tr>
      <tr>
        <td>Categoría:</td>
        <td>${requestScope.model.categoria}</td>
      </tr>
      <tr>
        <td>Ingresos:</td>
        <td>${requestScope.model.ingresos}</td>
      </tr>
      <tr>
        <td>Logistica:</td>
        <td>${requestScope.model.logistica}</td>
      </tr>
      <tr>
        <td>Publicidad:</td>
        <td>${requestScope.model.publicidad}</td>
      </tr>
      <tr>
        <td>Materiales:</td>
        <td>${requestScope.model.materiales}</td>
      </tr>
      <tr>
        <td>Instructor:</td>
        <td>${requestScope.model.instructor}</td>
      </tr>
      <tr>
        <td>Rentabilidad:</td>
        <td>${requestScope.model.rentabilidad}</td>
      </tr>      
    </table>
      <a href="index.html">Home</a>
      <a href="CocinaFormulario">Retornar</a>
  </body>
</html>

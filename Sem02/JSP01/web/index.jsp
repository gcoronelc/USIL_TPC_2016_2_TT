<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
  // Variables
  int n1 = 0, n2 = 0, suma = 0;
  // Control
  if (request.getParameter("btnProcesar") != null) {
    // Datos
    n1 = Integer.parseInt(request.getParameter("num1"));
    n2 = Integer.parseInt(request.getParameter("num2"));
    // Proceso
    suma = n1 + n2;
  }

%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>SUMAR</title>
  </head>
  <body>
    <h1>SUMAR</h1>
    <form method="post" action="index.jsp">
      <table>
        <tr>
          <td>Número 1:</td>
          <td><input type="text" name="num1"/></td>
        </tr>
        <tr>
          <td>Número 2:</td>
          <td><input type="text" name="num2"/></td>
        </tr>
      </table>
      <input type="submit" name="btnProcesar" value="Procesar" />
    </form>

    <% if (request.getParameter("btnProcesar") != null) {%>
    <h2>REPORTE</h2>
    <table>
      <tr>
        <td>Número 1:</td>
        <td><%= n1%></td>
      </tr>
      <tr>
        <td>Número 2:</td>
        <td><%= n2%></td>
      </tr>
      <tr>
        <td>Suma:</td>
        <td><%= suma%></td>
      </tr>
    </table>
    <% }%>
  </body>
</html>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="css/egcc.css" rel="stylesheet" type="text/css"/>
    <title>CALCULADORA</title>
  </head>
  <body>
    <div class="egcc_pagina">
      <img src="img/logo.png" alt=""/>
      <h1>CALCULADORA</h1>
      <table>
        <tr>
          <td>Operación:</td>
          <td><%= request.getAttribute("opera").toString() %></td>
        </tr>
        <tr>
          <td>Número 1:</td>
          <td><%= request.getAttribute("n1").toString() %></td>
        </tr>
        <tr>
          <td>Número 2:</td>
          <td><%= request.getAttribute("n2").toString() %></td>
        </tr>
        <tr>
          <td>Respuesta:</td>
          <td><%= request.getAttribute("rpta").toString() %></td>
        </tr>
      </table>
      <a href="index.html">Volver</a>
    </div>
  </body>
</html>

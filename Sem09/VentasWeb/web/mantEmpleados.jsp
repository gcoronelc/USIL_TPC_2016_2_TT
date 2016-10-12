<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="menu/menu.css" rel="stylesheet" type="text/css"/>
    <link href="css/estilos.css" rel="stylesheet" type="text/css"/>
    <link href="css/tabla.css" rel="stylesheet" type="text/css"/>
    <title>.:: VENTAS APP ::.</title>
  </head>
  <body>
    <div class="egcc_page">
      <header class="egcc_header">
        <jsp:include page="header.jsp" />
      </header>
      <section class="egcc_menu">
        <jsp:include page="menu/menu.jsp" />
      </section>
      <section class="egcc_content">

        <h1>MANTENIMIENTO DE EMPLEADOS</h1>

        <form method="post" action="EmpleadoConsultar">
          <fieldset>
            <legend>Datos</legend>
            <table>
              <tr>
                <td>Nombre</td>
                <td>Apellido</td>
                <td></td>
              </tr>
              <tr>
                <td><input type="text" name="nombre" /></td>
                <td><input type="text" name="apellido" /></td>
                <td>
                  <input type="submit" value="Consultar" name="btnConsultar"/>
                  <input type="submit" value="Nuevo" name="btnNuevo" />
                </td>
              </tr>
            </table>
          </fieldset>
        </form>
        <h2>LISTADO</h2>
        <table class="tftable">
          <thead>
            <tr>
              <th>ID</th>
              <th>NOMBRE</th>
              <th>APELLIDO</th>
              <th>EMAIL</th>
              <th>TELEFONO</th>
              <th>ACCION</th>
            </tr>
          </thead>
          <tbody>
            <c:forEach items="${requestScope.lista}" var="r">
              <tr>
                <td>${r.idemp}</td>
                <td>${r.nombre}</td>
                <td>${r.apellido}</td>
                <td>${r.email}</td>
                <td>${r.telefono}</td>
                <td style="text-align: center;">
                  <a href="EmpleadoEditar?id=${r.idemp}" title="Editar"><img src="img/editar.png" /></a>
                  <a href="EmpleadoEliminar?id=${r.idemp}" title="Eliminar"><img src="img/tacho.png" /></a>
                </td>
              </tr>
            </c:forEach>
          </tbody>
        </table>
      </section>
      <footer class="egcc_pie">
        <jsp:include page="pie.jsp" />
      </footer>
    </div>
  </body>
</html>

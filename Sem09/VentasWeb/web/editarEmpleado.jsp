<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="menu/menu.css" rel="stylesheet" type="text/css"/>
    <link href="css/estilos.css" rel="stylesheet" type="text/css"/>
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
        <h1>${requestScope.accion} EMPLEADO</h1>
        
        <table>
          <tr>
            <td>ID</td>
            <td>${requestScope.bean.idemp}</td>
          </tr>
          <tr>
            <td>NOMBRE</td>
            <td><input type="text" name="nombre"
                       value="${requestScope.bean.nombre}"/></td>
          </tr>
          <tr>
            <td>APELLIDO</td>
            <td><input type="text" name="apellido"
                       value="${requestScope.bean.apellido}"/></td>
          </tr>
          <tr>
            <td>TELEFONO</td>
            <td><input type="text" name="telefono"
                       value="${requestScope.bean.telefono}"/></td>
          </tr>
          <tr>
            <td>EMAIL</td>
            <td><input type="text" name="email"
                       value="${requestScope.bean.email}"/></td>
          </tr>
        </table>
        
      </section>
      <footer class="egcc_pie">
        <jsp:include page="pie.jsp" />
      </footer>
    </div>
  </body>
</html>

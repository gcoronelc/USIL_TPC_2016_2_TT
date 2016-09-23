<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="css/estilos.css" rel="stylesheet" type="text/css"/>
    <title>DEMO CARRITO</title>
  </head>
  <body>
    <div class="egcc_page">
      <header class="egcc_header">
        <jsp:include page="header.jsp" />
      </header>
      <section class="egcc_menu">
        <jsp:include page="menu.jsp" />
      </section>
      <section class="egcc_content">

        <h1>CARRITO</h1>

        <c:if test="${sessionScope.carrito == null}" >
          <p class="egcc_error">Carrito no existe</p>
        </c:if>

        <c:if test="${sessionScope.carrito != null}">

          <h2>Datos Generales</h2>

          <table>
            <tr>
              <td style="width: 100px;">Importe:</td>
              <td style="width: 150px;">${sessionScope.carrito.importe}</td>
            </tr>
            <tr>
              <td>Impuesto:</td>
              <td>${sessionScope.carrito.impuesto}</td>
            </tr>
            <tr>
              <td>Total:</td>
              <td>${sessionScope.carrito.total}</td>
            </tr>
          </table>

          <h2>Items</h2>
          <table border="1">
            <tr>
              <th>Nombre</th>
              <th>Precio</th>
              <th>Cant</th>
              <th>Subtotal</th>
            </tr>

            <c:forEach items="${sessionScope.carrito.lista}" var="r">
              <tr>
                <td>${r.nombre}</td>
                <td>${r.precio}</td>
                <td>${r.cant}</td>
                <td>${r.importe}</td>
              </tr>
            </c:forEach>

          </table>
        </c:if>

      </section>
      <footer class="egcc_pie">
        <jsp:include page="pie.jsp" />
      </footer>
    </div>
  </body>
</html>

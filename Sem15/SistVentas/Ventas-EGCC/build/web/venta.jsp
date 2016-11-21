<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="menu/menu.css" rel="stylesheet" type="text/css"/>
    <link href="css/estilos.css" rel="stylesheet" type="text/css"/>
    <link href="css/tabla.css" rel="stylesheet" type="text/css"/>
    <title>.:: WilsonStore ::.</title>
  </head>
  <body>
    <div class="egcc_page">
      <header class="egcc_header">
        <jsp:include page="header.jsp" />
      </header>
      <section class="egcc_menu">
        <jsp:include page="menu/menu.jsp"/>
      </section>
      <section class="egcc_content">
        <h1>REGISTRAR VENTA</h1>

        <c:if test="${requestScope.mensaje != null}">
          <p class="egcc_mensaje">${requestScope.mensaje}</p>
        </c:if>

        <c:if test="${requestScope.error != null}">
          <p class="egcc_error">${requestScope.error}</p>
        </c:if>

        <form method="post" action="VentaPostForm">

          <!-- Venta -->
          <fieldset>
            <legend>Datos de la Venta</legend>
            <table>
              <tr>
                <td colspan="2">Cliente</td>
              </tr>
              <tr>
                <td><input type="text" name="cliente" value="${sessionScope.venta.cliente}"/></td>
                <td><input type="submit" name="btnGrabarVenta" value="Grabar Venta" /></td>
              </tr>
            </table>
          </fieldset>
          <!-- Registrar Item -->
          <fieldset>
            <legend>Registrar nuevo item</legend>
            <table>
              <tr>
                <td>Producto</td>
                <td>Cantidad</td>
                <td>&nbsp;</td>
              </tr>
              <tr>
                <td>
                  <select name="idprod">
                    <option value="0">Seleccione producto</option>
                    <c:if test="${productos != null}">
                      <c:forEach items="${requestScope.productos}" var="r">
                        <option value="${r.idprod}">${r.nombre} (${r.precio})</option>
                      </c:forEach>
                    </c:if>
                  </select>
                </td>
                <td><input type="text" name="cant" /></td>
                <td><input type="submit" name="btnAddItem" value="Agregar item" /></td>
              </tr>
            </table>
          </fieldset>
        </form>

        <!-- Items -->
        <table class="tftable">
          <thead>
            <tr>
              <th>COD</th>
              <th>NOMBRE</th>
              <th>CATALOGO</th>
              <th>PRECIO</th>
              <th>CANT</th>
              <th>SUBTOTAL</th>
            </tr>
          </thead>
          <tbody>
            <c:forEach items="${sessionScope.venta.items}" var="r">
              <tr>
                <td>${r.idprod}</td>
                <td>${r.nombre}</td>
                <td>${r.precatalogo}</td>
                <td>${r.preventa}</td>
                <td>${r.cant}</td>
                <td>${r.subtotal}</td>
              </tr>
            </c:forEach>
          </tbody>
        </table>

        <!-- Totales -->
        <br/>
        <table class="tftable">
          <tbody>
            <tr>
              <td>Importe:</td>
              <td>${sessionScope.venta.importe}</td>
            </tr>
            <tr>
              <td>Impuesto:</td>
              <td>${sessionScope.venta.impuesto}</td>
            </tr>
            <tr>
              <td>Total:</td>
              <td>${sessionScope.venta.total}</td>
            </tr>
          </tbody>
        </table>

      </section>
      <footer class="egcc_pie">
        <jsp:include page="pie.jsp" />
      </footer>
    </div>
  </body>
</html>

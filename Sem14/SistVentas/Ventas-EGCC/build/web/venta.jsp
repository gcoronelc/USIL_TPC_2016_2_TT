
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
        <!-- Venta -->
        <form>
          <fieldset>
            <legend>Datos de la Venta</legend>
            <table>
              <tr>
                <td colspan="2">Cliente</td>
              </tr>
              <tr>
                <td><input type="text" name="cliente"/></td>
                <td><input type="submit" value="Grabar Venta" /></td>
              </tr>
            </table>
          </fieldset>
        </form>
        <!-- Registrar Item -->
        <form>
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
                  <select name="codprod">
                    <option>Seleccione producto</option>
                  </select>
                </td>
                <td><input type="text" name="cant" /></td>
                <td><input type="submit" value="Agregar item" /></td>
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
              <th>PRECIO</th>
              <th>CANT</th>
              <th>SUBTOTAL</th>
            </tr>
          </thead>
        </table>
      </section>
      <footer class="egcc_pie">
        <jsp:include page="pie.jsp" />
      </footer>
    </div>
  </body>
</html>

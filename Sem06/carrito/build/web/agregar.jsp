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

        <h1>AGREGAR ITEM</h1>
        <form>
          <fieldset style="width: 40%;">
            <legend>Datos del item</legend>
            <table>
              <tr>
                <td style="width: 100px;">Artículo:</td>
                <td style="width: 150px;">
                  <input type="text" name="articulo"/>
                </td>
              </tr>
              <tr>
                <td>Precio:</td>
                <td><input type="text" name="precio"/></td>
              </tr>
              <tr>
                <td>Cantidad:</td>
                <td><input type="text" name="cant"/></td>
              </tr>
              <tr>
                <td colspan="2">
                  <input type="submit" value="Procesar"/>
                </td>
              </tr>
            </table>
          </fieldset>
        </form>

      </section>
      <footer class="egcc_pie">
        <jsp:include page="pie.jsp" />
      </footer>
    </div>
  </body>
</html>

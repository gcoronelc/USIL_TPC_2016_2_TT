
<%@page import="pe.usil.promapp.model.PromModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="css/estilos.css" rel="stylesheet" type="text/css"/>
    <title>.:: PROMEDIO ::.</title>
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
        <h1>CALCULO DE PROMEDIO</h1>
        <form method="post" action="PromedioServlet">
          <table>
            <tr>
              <td>Prom. Practicas:</td>
              <td><input type="text" name="pp"/></td>
            </tr>
            <tr>
              <td>Examen Parcial:</td>
              <td><input type="text" name="ep"/></td>
            </tr>
            <tr>
              <td>Examen Final:</td>
              <td><input type="text" name="ef"/></td>
            </tr>
            <tr>
              <td colspan="2">
                <input type="submit" value="Procesar"/>
              </td>
            </tr>            
          </table>
        </form>
        
        <% if( request.getAttribute("model") != null){ %>
          <h1>RESULTADO</h1>
          <% PromModel model = (PromModel) request.getAttribute("model"); %>
          <table>
              <tr>
                <td>Prom. Practicas:</td>
                <td><%= model.getPromPract() %></td>
              </tr>
              <tr>
                <td>Examen Parcial:</td>
                <td><%= model.getExaParcial() %></td>
              </tr>
              <tr>
                <td>Examen Final:</td>
                <td><%= model.getExaFinal() %></td>
              </tr>
              <tr>
                <td>Promedio Final:</td>
                <td><%= model.getPromFinal()%></td>
              </tr>
              <tr>
                <td>Condición:</td>
                <td><%= model.getCondicion()%></td>
              </tr>
          </table>
        <% } %>
      </section>
      <footer class="egcc_pie">
        <jsp:include page="pie.jsp" />
      </footer>
    </div>
  </body>
</html>

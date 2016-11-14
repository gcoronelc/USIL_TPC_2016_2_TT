<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>.:: PROMOCIONES ::.</title>
  </head>
  <body>
    <!-- Formulario -->
    <div>
      <h1>PROMOCIONES</h1>
      <form id="form1">
        <fieldset>
          <legend>Filtro</legend>
          <label>Código de producto:</label>
          <input type="text" name="idprod" />
          <input type="button" id="btnConsultar" value="Consultar" />
        </fieldset>
      </form>
    </div>
    <!-- Resultado -->
    <c:if test="${requestScope.lista != null}">
      <div>
        <table class="tftable">
          <thead>
            <tr>
              <th>ID.PROM.</th>
              <th>F.INICIO</th>
              <th>F.FIN</th>
              <th>ID.PROD.</th>
              <th>NOMBRE</th>
              <th>P.ACTUAL</th>
              <th>P.VENTA</th>
              <th>P.OFERTA</th>
              <th>ESTADO</th>
              <th>ANULADO</th>
            </tr>
          </thead>
          <tbody>
            <c:forEach items="${requestScope.lista}" var="r">
            <tr>
              <td>${r.idprom}</td>
              <td>${r.fecinicio}</td>
              <td>${r.fecfin}</td>
              <td>${r.idprod}</td>
              <td>${r.nombre}</td>
              <td>${r.pactual}</td>
              <td>${r.precio}</td>
              <td>${r.oferta}</td>
              <td>${r.estado}</td>
              <td>${r.anulado}</td>
            </tr>
            </c:forEach>
          </tbody>
        </table>
      </div>
    </c:if>
  
    <script>
      
      $("#btnConsultar").click(function(){
        // Los datos
        var data = $("#form1").serialize();
        // LLama AJAX
        $.post("PromocionConsultar",data,function(htmlPage){
          $("#_content").html(htmlPage);
        });
      });

      
    </script>
      
  </body>
</html>

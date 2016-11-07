<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>.:: PROMOCIONES ::.</title>
  </head>
  <body>
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
    <div id="divListado"></div>
    <script>
      $("#btnConsultar").click(function(){
        var data = $("#form1").serialize();
        $.post("PromocionConsultar",data,function(htmlPage){
          $("#divListado").html(htmlPage);
        });
      });
    </script>
  </body>
</html>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>CONSULTA DE PRODUCTOS</title>
  </head>
  <body>
    <h1>CONSULTA DE PRODUCTOS</h1>
    <div>
      <form id="form1">
        <label>Código de producto:</label>
        <input type="text" name="id" />
        <input type="button" id="btnConsultar" value="Consultar" title="Consultar producto."/>
      </form>
    </div>
    <div>
      <h2>RESULTADO</h2>
      <table>
        <tr>
          <td width="80px">ID</td>
          <td><span id="id"></span></td>
        </tr>
        <tr>
          <td>CATEGORIA</td>
          <td><span id="idcat"></span></td>
        </tr>
        <tr>
          <td>NOMBRE</td>
          <td><span id="nombre"></span></td>
        </tr>
        <tr>
          <td>PRECIO</td>
          <td><span id="precio"></span></td>
        </tr>
        <tr>
          <td>STOCK</td>
          <td><span id="stock"></span></td>
        </tr>
      </table>
    </div>
    <script>
      
      $("#btnConsultar").click(function(){
        var data = $("#form1").serialize();
        $.post("ProductoTraerUno",data,function(obj){
          if(obj.code == 1){
            var objProd = $.parseJSON(obj.text);
            $("#id").text(objProd.idprod);
            $("#idcat").text(objProd.idcat);
            $("#nombre").text(objProd.nombre);
            $("#precio").text(objProd.precio);
            $("#stock").text(objProd.stock);
          } else {
            alert(obj.text);
          }
        });
      });
      
    </script>
  </body>
</html>

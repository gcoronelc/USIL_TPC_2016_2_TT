<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="css/estilos.css" rel="stylesheet" type="text/css"/>
    <title>JSP Page</title>
  </head>
  <body>
    <div class="egcc_content">
      <h1>NUEVO CLIENTE</h1>
      
      <c:if test="${requestScope.error != null}">
        <p style="color:red;">${requestScope.error}</p>
      </c:if>
      
      <form method="post" action="GrabarNuevo">

        <table>
          <tr>
            <td>Código</td>
            <td>NONE</td>
          </tr>
          <tr>
            <td>Paterno</td>
            <td><input type="text" name="paterno"  /></td>
          </tr>
          <tr>
            <td>Materno</td>
            <td><input type="text" name="materno" /></td>
          </tr>
          <tr>
            <td>Nombre</td>
            <td><input type="text" name="nombre" /></td>
          </tr>
          <tr>
            <td>DNI</td>
            <td><input type="text" name="dni" /></td>
          </tr>
          <tr>
            <td>Ciudad</td>
            <td><input type="text" name="ciudad" /></td>
          </tr>
          <tr>
            <td>Dirección</td>
            <td><input type="text" name="direccion" /></td>
          </tr>
          <tr>
            <td>Teléfono</td>
            <td><input type="text" name="telefono" /></td>
          </tr>
          <tr>
            <td>Email</td>
            <td><input type="text" name="email" /></td>
          </tr>
        </table>
        <input type="submit" value="Procesar" />
      </form>
    </div>
  </body>
</html>

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
      <h1>EDITAR CLIENTE</h1>
      
      <c:if test="${requestScope.error != null}">
        <p style="color:red;">${requestScope.error}</p>
      </c:if>
      
      <form method="post" action="GrabarModificar">

        <input type="hidden" name="codigo" 
               value="${requestScope.bean.codigo}" />
        <table>
          <tr>
            <td>Código</td>
            <td>${requestScope.bean.codigo}</td>
          </tr>
          <tr>
            <td>Paterno</td>
            <td><input type="text" name="paterno" 
                       value="${requestScope.bean.paterno}" /></td>
          </tr>
          <tr>
            <td>Materno</td>
            <td><input type="text" name="materno" 
                       value="${requestScope.bean.materno}" /></td>
          </tr>
          <tr>
            <td>Nombre</td>
            <td><input type="text" name="nombre" 
                       value="${requestScope.bean.nombre}" /></td>
          </tr>
          <tr>
            <td>DNI</td>
            <td><input type="text" name="dni" 
                       value="${requestScope.bean.dni}" /></td>
          </tr>
          <tr>
            <td>Ciudad</td>
            <td><input type="text" name="ciudad" 
                       value="${requestScope.bean.ciudad}" /></td>
          </tr>
          <tr>
            <td>Dirección</td>
            <td><input type="text" name="direccion" 
                       value="${requestScope.bean.direccion}" /></td>
          </tr>
          <tr>
            <td>Teléfono</td>
            <td><input type="text" name="telefono" 
                       value="${requestScope.bean.telefono}" /></td>
          </tr>
          <tr>
            <td>Email</td>
            <td><input type="text" name="email" 
                       value="${requestScope.bean.email}" /></td>
          </tr>
        </table>
        <input type="submit" value="Procesar" />
      </form>
    </div>
  </body>
</html>

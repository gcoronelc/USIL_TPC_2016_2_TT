<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<table style="width: 100%;">
  <tr>
    <td>
        <img src="imagen/descarga.jpg" alt=""/>
    </td>
    <td>
      Usuario: ${sessionScope.usuario.usuario}<br/>
      <a href="LoginSalir">Cerrar Sesión</a>
    </td>
  </tr>
</table>

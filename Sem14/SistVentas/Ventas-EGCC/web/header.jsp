<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<table style="width: 100%;">
  <tr>
    <td>
      <img alt="" src="img/logo.jpg" />
    </td>
    <td>
      Usuario: ${sessionScope.usuario.usuario}<br/>
      <a href="LogonSalir">Cerrar Sesión</a>
    </td>
  </tr>
</table>
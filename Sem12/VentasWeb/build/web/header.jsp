<%@page contentType="text/html" pageEncoding="UTF-8"%>
<table style="width: 100%;">
  <tr>
    <td>
      <img alt="" src="img/logo.jpg" />
    </td>
    <td>
      Usuario: ${sessionScope.usuario.usuario}<br/>
      <a href="LogonSalir">CerrarSesión</a>
    </td>
  </tr>
</table>
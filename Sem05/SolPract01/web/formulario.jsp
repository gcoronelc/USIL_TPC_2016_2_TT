<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
  </head>
  <body>
    <h1>COCINA PERUAN EN EL MUNDO TIENE FAMA</h1>
    <p style="color: red;">${requestScope.error}</p>
    <form method="post" action="CocinaProcesar">
      <table>
        <tr>
          <td>Curso:</td>
          <td>
            <select name="curso">
              <option value="none">Selecciona curso ...</option>
              <c:forEach items="${requestScope.cursos}" var="elem">
              <option value="${elem}">${elem}</option>
              </c:forEach>
            </select>
          </td>
        </tr>
        <tr>
          <td>Categoría:</td>
          <td>
            <select name="categoria">
              <option value="none">Selecciona categoría ...</option>
              <c:forEach items="${requestScope.categorias}" var="elem">
              <option value="${elem}">${elem}</option>
              </c:forEach>
            </select>
          </td>
        </tr>
        <tr>
          <td>Vacantes:</td>
          <td><input type="text" name="vacantes" /></td>
        </tr>
        <tr>
          <td colspan="2"><input type="submit" value="Procesar" /></td>
        </tr>
      </table>
    </form>
  </body>
</html>

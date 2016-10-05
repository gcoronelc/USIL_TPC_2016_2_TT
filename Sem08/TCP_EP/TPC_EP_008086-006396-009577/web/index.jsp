<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Examen Parcial</title>
    </head>
    <body>
        <h1></h1>

        <!-- Mostrar mensaje de error -->
        <c:if test="${requestScope.error != null}">
            <p style="color: red;">${requestScope.error}</p>
        </c:if>

        <!-- Formulario -->
        <form method="post" action="EProcesar">
            Lectura del mes anterior:
            <input type="text" name="mesAnt" />
            Lectura del mes actual:
            <input type="text" name="mesAct" />
            <input type="submit" value="Procesar"/>
        </form>

        <!-- Resultado -->
        <c:if test="${requestScope.repo != null}" var="r">
            <h2>RESULTADO</h2>
            <table border="1">
            <tr>
                <th>DESCRIPCION</th>
                <th>COSTO</th>
                <th>CONSUMO EN M3</th>
                <th>IMPORTE</th>
            </tr>

            <c:forEach items="${requestScope.repo}" var="r">
                <tr>
                    <td>${r.descripcion}</td>
                    <td>${r.precio}</td>
                    <td>${r.consumo}</td>
                    <td>${r.importe}</td>
                </tr>
            </c:forEach>

            <tr>
                <th colspan="2">${requestScope.total.descripcion}</th>
                <th>${requestScope.total.consumo}</th>
                <th>${requestScope.total.importe}</th>
            </tr> 

        </table>
    </c:if>
</body>
</html>

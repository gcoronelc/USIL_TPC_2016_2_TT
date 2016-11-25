<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/menu.css" rel="stylesheet" type="text/css"/>
        <link href="css/estilo.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="page">
            <div class="header">
                <jsp:include page="header.jsp"/>
            </div>
            <div>
                <jsp:include page="menu.jsp"/>
            </div>
            <div class="contenido">
                <h1> REPORTE DE VENTAS</h1>
                <c:if test="${requestScope.mensaje != null}">
                    <p>${requestScope.mensaje}</p>
                </c:if>
                <form method="post" action="ReporteVenta">
                    <table>
                        <tr>
                            <td>Codigo:</td>
                            <td></td>
                        </tr>
                        <tr>
                            <td><input type="text" name="codventa"/></td>
                            <td>
                                <input type="submit" value="Reporte"/>
                            </td>
                        </tr>
                    </table>
                </form>
                <!-- Resultado -->
                <c:if test="${requestScope.lista != null}">
                    <table class="table">
                        <thead>
                        <th>CODIGO</th>
                        <th>EMPLEADO</th>
                        <th>CLIENTE</th>
                        <th>FECHA</th>
                        <th>IMPORTE</th>
                        <th>IMPUESTO</th>
                        <th>TOTAL</th>
                        <th>DETALLE</th>
                        </thead>
                        <tbody>
                        <c:forEach items="${requestScope.lista}" var="r">
                            <tr>
                                <td>${r.idventa}</td>
                                <td>${r.idemp}</td>
                                <td>${r.cliente}</td>
                                <td>${r.fecha}</td>
                                <td>${r.importe}</td>
                                <td>${r.impuesto}</td>
                                <td>${r.total}</td>
                                <td> <a href="VerVenta?codventa=${r.idventa}">Ver</a></td>                                
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </c:if>
            </div>
            <div class="pie">
                <jsp:include page="pie.jsp"/>
            </div>
        </div>
    </body>
</html>

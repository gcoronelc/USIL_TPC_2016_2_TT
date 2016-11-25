<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/estilo.css" rel="stylesheet" type="text/css"/>
        <link href="css/menu.css" rel="stylesheet" type="text/css"/>
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
                <h1> DETALLE DE VENTAS</h1>
                <c:if test="${requestScope.mensaje != null}">
                    <p>${requestScope.mensaje}</p>
                </c:if>
                <form method="post" action="Detalleventa">
                    <input type="hidden" name="codventa" 
                           value="${requestScope.bean.idventa}" />
                    <table>
                        <tr>
                            <td>Código:</td>
                            <td>${requestScope.bean.idventa} </td>
                        </tr> 
                    </table>
                    <input type="submit" value="Ver" />
                </form>
                <c:if test="${requestScope.lista != null}">
                    <table class="table">
                        <thead>
                        <th>CODIGO DETALLE</th>
                        <th>VENTA</th>
                        <th>PRODUCTO</th>
                        <th>CANTIDAD</th>
                        <th>PRECIO CATALOGO</th>
                        <th>PRECIO VENTA</th>
                        <th>SUBTOTAL</th>
                        </thead>
                        <tbody>
                            <c:forEach items="${requestScope.lista}" var="r">
                                <tr>
                                    <td>${r.iddetalle}</td>
                                    <td>${r.idventa}</td>
                                    <td>${r.idprod}</td>
                                    <td>${r.cant}</td>
                                    <td>${r.precatalogo}</td>
                                    <td>${r.preventa}</td>
                                    <td>${r.subtotal}</td>                              
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

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
                <h4>Consultar campaña</h4>
                <c:if test="${requestScope.mensaje != null}">
                    <p>${requestScope.mensaje}</p>
                </c:if>
                    
                <c:if test="${requestScope.error != null}">
                    <p>${requestScope.error}</p>
                </c:if>
                    
                <form method="post" action="EliminarCamp">
                        <h1>ELIMINAR CAMPAÑA</h1><a href="mantCampania.jsp">VOLVER</a>
                        <table>
                            <tr>
                                <td>ID Campaña :</td>
                                <td><input type="text" name="codigo" value="${requestScope.bean.codigo}" readonly=""/></td>
                            </tr>
                            <tr>
                                <td>Nombre :</td>
                                <td><input type="text" name="nombre" value="${requestScope.bean.nombre}" readonly=""/></td>
                            </tr>
                            <tr>
                                <td>Descripcion :</td>
                                <td><input type="text" name="descripcion" value="${requestScope.bean.descripcion}" readonly=""/></td>
                            </tr>
                            <tr>
                                <td>Fecha Inicio :</td>
                                <td><input type="date" name="fecInicio" value="${requestScope.bean.fecInicio}" readonly=""/></td>
                            </tr>
                            <tr>
                                <td>Fecha Fin :</td>
                                <td><input type="date" name="fecFin" value="${requestScope.bean.fecFin}" readonly=""/></td>
                            </tr>
                            <tr>
                                <td>Estado :</td>
                                <td><input type="text" name="estado" value="${requestScope.bean.estado}" readonly=""/></td>
                            </tr>
                            <tr>
                                <td>Anulado :</td>
                                <td><input type="text" name="anulado" value="${requestScope.bean.anulado}" readonly=""/></td>
                            </tr>
                        </table>
                        
                        <input type="submit" value="ELIMINAR"/>
                    </form>                
            </div>
            <div class="pie">
                <jsp:include page="pie.jsp"/>
            </div>
    </body>
</html>

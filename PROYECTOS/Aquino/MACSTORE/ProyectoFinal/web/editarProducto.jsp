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
                <h4>Consultar producto</h4>
                <c:if test="${requestScope.mensaje != null}">
                    <p>${requestScope.mensaje}</p>
                </c:if>
                    
                <c:if test="${requestScope.error != null}">
                    <p>${requestScope.error}</p>
                </c:if>
                    
                <form method="post" action="ModificarProd">
                        <h1>EDITAR PRODUCTO</h1><a href="mantProducto.jsp">VOLVER</a>
                        <table>
                            <tr>
                                <td>Producto :</td>
                                <td><input type="text" name="codigo" value="${requestScope.bean.codigo}" readonly=""/></td>
                            </tr>
                            <tr>
                                <td>ID Categoria :</td>
                                <td><input type="text" name="categoria" value="${requestScope.bean.categoria}" readonly=""/></td>
                            </tr>
                            <tr>
                                <td>Nombre :</td>
                                <td><input type="text" name="nombre" value="${requestScope.bean.nombre}"/></td>
                            </tr>
                            <tr>
                                <td>Descripcion :</td>
                                <td><input type="text" name="descripcion" value="${requestScope.bean.descripcion}"/></td>
                            </tr>
                            <tr>
                                <td>Precio :</td>
                                <td><input type="text" name="precio" value="${requestScope.bean.precio}"/></td>
                            </tr>
                            <tr>
                                <td>Stock :</td>
                                <td><input type="text" name="stock" value="${requestScope.bean.stock}"/></td>
                            </tr>
                            <tr>
                                <td>Estado :</td>
                                <td><input type="text" name="estado" value="${requestScope.bean.estado}"/></td>
                            </tr>
                        </table>
                        
                        <input type="submit" value="EDITAR"/>
                    </form>                
            </div>
            <div class="pie">
                <jsp:include page="pie.jsp"/>
            </div>
    </body>
</html>

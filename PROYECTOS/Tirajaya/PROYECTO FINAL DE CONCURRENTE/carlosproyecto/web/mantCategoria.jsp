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
                <h4>Consultar categoria</h4>
                <c:if test="${requestScope.mensaje != null}">
                    <p>${requestScope.mensaje}</p>
                </c:if>
                    
                <c:if test="${requestScope.error != null}">
                    <p>${requestScope.error}</p>
                </c:if>
                    
                <form method="post" action="ConsultaCat">
                    <table>
                        <tr>
                            <td>Codigo:</td>
                            <td></td>
                        </tr>
                        <tr>
                            <td><input type="text" name="codigo" placeholder="Inserte codigo..."/></td>
                            <td>
                                <input type="submit" value="Consultar" name="btnConsulta"/>
                                <input type="submit" value="Crear categoria" name="btnNuevo"/>
                            </td>
                        </tr>
                    </table>
                </form>

                <!-- Resultado -->
                <c:if test="${requestScope.lista != null}">
                    <table class="table">
                        <thead>
                        <th>CODIGO</th>
                        <th>NOMBRE</th>
                        <th>DESCRIPCION</th>
                        <th>ACCION</th>
                        </thead>
                        <tbody>
                            <c:forEach items="${requestScope.lista}" var="r">
                                <tr>
                                    <td>${r.codigo}</td>
                                    <td>${r.nombre}</td>
                                    <td>${r.descripcion}</td>
                                    <td>
                                        <a href="CatEditar?codigo=${r.codigo}" title="Editar ${r.codigo}">Editar</a>
                                        <a href="CatEliminar?codigo=${r.codigo}" title="Eliminar ${r.codigo}" >Eliminar</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </c:if>

                <!-- Formulario Nuevo -->
                <c:if test="${requestScope.nuevo != null}">
                    <form method="post" action="NuevoCat">
                        <h1>CREAR PROMOCION</h1>
                        <table>
                            <tr>
                                <td>ID Categoria :</td>
                                <td><input type="text" name="codigo" placeholder="Ej: 1"/></td>
                            </tr>
                            <tr>
                                <td>Nombre :</td>
                                <td><input type="text" name="nombre"/></td>
                            </tr>
                            <tr>
                                <td>Descripcion :</td>
                                <td><input type="text" name="descripcion"/></td>
                            </tr>
                        </table>
                        <input type="submit" value="CREAR"/>
                    </form>
                </c:if>
            </div>
            <div class="pie">
                <jsp:include page="pie.jsp"/>
            </div>
    </body>
</html>

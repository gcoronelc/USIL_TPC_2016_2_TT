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
                <h4>Consultar promocion</h4>
                <c:if test="${requestScope.mensaje != null}">
                    <p>${requestScope.mensaje}</p>
                </c:if>
                    
                <c:if test="${requestScope.error != null}">
                    <p>${requestScope.error}</p>
                </c:if>
                    
                <form method="post" action="ConsultaPromo">
                    <table>
                        <tr>
                            <td>Codigo:</td>
                            <td></td>
                        </tr>
                        <tr>
                            <td><input type="text" name="codigo" /></td>
                            <td>
                                <input type="submit" value="Consultar" name="btnConsulta"/>
                                <input type="submit" value="Crear promocion" name="btnNuevo"/>
                            </td>
                        </tr>
                    </table>
                </form>

                <!-- Resultado -->
                <c:if test="${requestScope.lista != null}">
                    <table class="table">
                        <thead>
                        <th>CODIGO</th>
                        <th>PRODUCTO</th>
                        <th>F. INICIO</th>
                        <th>F. FIN</th>
                        <th>PRECIO</th>
                        <th>OFERTA</th>
                        <th>ESTADO</th>
                        <th>ANULADO</th>
                        <th>ACCION</th>
                        </thead>
                        <tbody>
                            <c:forEach items="${requestScope.lista}" var="r">
                                <tr>
                                    <td>${r.codigo}</td>
                                    <td>${r.idprod}</td>
                                    <td>${r.fecInicio}</td>
                                    <td>${r.fecFin}</td>
                                    <td>${r.precio}</td>
                                    <td>${r.oferta}</td>
                                    <td>${r.estado}</td>
                                    <td>${r.anulado}</td>
                                    <td>
                                        <a href="PromoEditar?codigo=${r.codigo}" title="Editar ${r.codigo}">Editar</a>
                                        <a href="PromoEliminar?codigo=${r.codigo}" title="Eliminar ${r.codigo}" >Eliminar</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </c:if>

                <!-- Formulario Nuevo -->
                <c:if test="${requestScope.nuevo != null}">
                    <form method="post" action="NuevoPromo">
                        <h1>CREAR PROMOCION</h1>
                        <table>
                            <tr>
                                <td>ID Promocion :</td>
                                <td><input type="text" name="codigo" placeholder="Ej: 1"/></td>
                            </tr>
                            <tr>
                                <td>ID Producto :</td>
                                <td><input type="text" name="idprod" placeholder="Ej: 1"/></td>
                            </tr>
                            <tr>
                                <td>Fecha Inicio :</td>
                                <td><input type="date" name="fecInicio"/></td>
                            </tr>
                            <tr>
                                <td>Fecha Fin :</td>
                                <td><input type="date" name="fecFin"/></td>
                            </tr>
                            <tr>
                                <td>Precio :</td>
                                <td><input type="text" name="precio"/></td>
                            </tr>
                            <tr>
                                <td>Oferta :</td>
                                <td><input type="text" name="oferta"/></td>
                            </tr>
                            <tr>
                                <td>Estado :</td>
                                <td><input type="text" name="estado"/></td>
                            </tr>
                            <tr>
                                <td>Anulado :</td>
                                <td><input type="text" name="anulado"/></td>
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

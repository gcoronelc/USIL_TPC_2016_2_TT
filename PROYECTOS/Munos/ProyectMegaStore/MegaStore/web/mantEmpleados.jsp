<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="css/estilos.css" rel="stylesheet" type="text/css"/>
    <link href="menu/menu.css" rel="stylesheet" type="text/css"/>
    <link href="css/tabla.css" rel="stylesheet" type="text/css"/>
    <script src="jquery/jquery.js" type="text/javascript"></script>
    <script src="js/egcc.js" type="text/javascript"></script>
    <title>.:: VENTAS ::.</title>
  </head>
  <body>
    <div class="egcc_page">
      <header class="egcc_header">
        <jsp:include page="header.jsp" />
      </header>
      <section class="egcc_menu">
        <jsp:include page="menu/menu.jsp" />
      </section>
      <section id="_content" class="egcc_content">
        <h1>MANTENIMIENTO DE EMPLEADOS</h1>

        <c:if test="${requestScope.error != null}">
          <p class="egcc_error">${requestScope.error}</p>
        </c:if>

        <c:if test="${requestScope.mensaje != null}">
          <p class="egcc_mensaje">${requestScope.mensaje}</p>
        </c:if>

        <form name="formConsulta" method="post" action="EmpleadoConsulta">
          <table>
            <tr>
              <td>Nombre</td>
              <td>Apellido</td>
              <td></td>
            </tr>
            <tr>
              <td><input type="text" name="nombre" value="${requestScope.criterio.nombre}"/></td>
              <td><input type="text" name="apellido" value="${requestScope.criterio.apellido}"/></td>
              <td>
                <input type="submit" value="Consultar" name="btnConsultar"/>
                <input type="submit" value="Nuevo" name="btnNuevo"/>
              </td>
            </tr>
          </table>
        </form>

        <!-- Resultado de la consulta -->
        <c:if test="${requestScope.lista != null}">
          <h2>RESULTADO</h2>
          <table class="tftable">
            <thead>
              <tr>
                <th>ID</th>               
                <th>NOMBRE</th>
                <th>APELLIDO</th> 
                <th>EMAIL</th>
                <th>TELEFONO</th>
                    
                <th>ACCION</th>
              </tr>
            </thead>
            <tbody>
              <c:forEach items="${requestScope.lista}" var="r">
                <tr>
                  <td>${r.idemp}</td>
                  <td>${r.nombre}</td>
                  <td>${r.apellido}</td>
                  <td>${r.email}</td>
                  <td>${r.telefono}</td>
                  <td style="text-align: center;">
                    <a href="EmpleadoEditar?id=${r.idemp}" title="Editar ${r.idemp}"><img src="img/editar.png"/></a>
                    <a href="EmpleadoEliminar?id=${r.idemp}" title="Eliminar ${r.idemp}"><img src="img/tacho.png"/></a>
                  </td>
                </tr>
              </c:forEach>
            </tbody>
          </table>
        </c:if>

        <!-- Formulario de Edición -->
        <c:if test="${requestScope.accion != null}">
          <h2>${requestScope.accion} EMPLEADO</h2>
          <form name="formEditar" method="get" action="EmpleadoGrabar">
            <input type="hidden" name="accion" value="${requestScope.accion}" />
            <input type="hidden" name="idemp" value="${requestScope.bean.idemp}" />
            <table>
              <tr>
                <td width="100px">ID</td>
                <td>${requestScope.bean.idemp}</td>
              </tr>
              <tr>
                <td>NOMBRE</td>
                <td>
                  <c:if test="${requestScope.accion ne 'ELIMINAR'}">
                    <input type="text" name="nombre" value="${requestScope.bean.nombre}" />
                  </c:if>
                  <c:if test="${requestScope.accion eq 'ELIMINAR'}">
                    ${requestScope.bean.nombre}
                  </c:if>
                </td>
              </tr>
              <tr>
                <td>APELLIDO</td>
                <td>
                  <c:if test="${requestScope.accion ne 'ELIMINAR'}">
                    <input type="text" name="apellido" value="${requestScope.bean.apellido}" />
                  </c:if>
                  <c:if test="${requestScope.accion eq 'ELIMINAR'}">
                    ${requestScope.bean.apellido}
                  </c:if>
                </td>
              </tr>
              <tr>
                <td>EMAIL</td>
                <td>
                  <c:if test="${requestScope.accion ne 'ELIMINAR'}">
                    <input type="text" name="email" value="${requestScope.bean.email}" />
                  </c:if>
                  <c:if test="${requestScope.accion eq 'ELIMINAR'}">
                    ${requestScope.bean.email}
                  </c:if>
                </td>
              </tr>
              <tr>
                <td>TELEFONO</td>
                <td>
                  <c:if test="${requestScope.accion ne 'ELIMINAR'}">
                    <input type="text" name="telefono" value="${requestScope.bean.telefono}" />
                  </c:if>
                  <c:if test="${requestScope.accion eq 'ELIMINAR'}">
                    ${requestScope.bean.telefono}
                  </c:if>
                </td>
              </tr>
              
              <tr>
                <td>DNI</td>
                <td>
                  <c:if test="${requestScope.accion ne 'ELIMINAR'}">
                    <input type="text" name="dni" value="${requestScope.bean.dni}" />
                  </c:if>
                  <c:if test="${requestScope.accion eq 'ELIMINAR'}">
                    ${requestScope.bean.dni}
                  </c:if>
                </td>
              </tr>
              <tr>
                <td>DIRECCION</td>
                <td>
                  <c:if test="${requestScope.accion ne 'ELIMINAR'}">
                    <input type="text" name="direccion" value="${requestScope.bean.direccion}" />
                  </c:if>
                  <c:if test="${requestScope.accion eq 'ELIMINAR'}">
                    ${requestScope.bean.direccion}
                  </c:if>
                </td>
              </tr>
                <tr>
                <td>ESTADO</td>
                <td>
                  <c:if test="${requestScope.accion ne 'ELIMINAR'}">
                    <input type="text" name="email" value="${requestScope.bean.estado}" />
                  </c:if>
                  <c:if test="${requestScope.accion eq 'ELIMINAR'}">
                    ${requestScope.bean.estado}
                  </c:if>
                </td>
              </tr>
            </table>
            <input type="submit" value="Procesar" />
          </form>

        </c:if>

      </section>
      <footer class="egcc_pie">
        <jsp:include page="pie.jsp" />
      </footer>
    </div>
  </body>
</html>

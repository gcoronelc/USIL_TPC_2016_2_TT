<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="menu">
  <ul>
    
    <li><a href="main.jsp" >Home</a></li>
    
    
    <c:if test="${sessionScope.rolVentas == 1}">
    <li><a href="#">Ventas</a>
      <ul>
        <li><a href="VentaGetForm">Registrar Ventas</a></li>
        <li><a href="#">Horizontal CSS Menus</a></li>
        <li><a href="#">Vertical CSS Menus</a></li>
        <li><a href="#">Dreamweaver Menus</a></li>
      </ul>
    </li>
    </c:if>
    
    <c:if test="${sessionScope.rolMant == 1}">
  <li><a href="#">Mantenimiento</a>
            <ul>
                <li><a href="mantEmpleados.jsp">Empleados</a></li>
                <li><a href="#">Usuarios</a></li>
                <li><a href="javascript: loadPage('mantPromociones.jsp');">Promociones</a></li>
                <li><a href="#">Campañas</a></li>
            </ul>
        </li>
        </c:if>
        
    
    <c:if test="${sessionScope.rolConsultas == 1}">
   <li><a href="#">Consultas</a>
      <ul>
        <li><a href="javascript: loadPage( 'conProducto.jsp' );">Producto</a></li>
        <li><a href="javascript: loadPage( 'conProductos.jsp' );">Productos</a></li>
        <li><a href="javascript: loadPage( 'conVentasPorCliente.jsp' );">Ventas por cliente</a></li>
        <li><a href="#">Dreamweaver Menus</a></li>
      </ul>
    </li>
    </c:if>
    
    <c:if test="${sessionScope.rolReportes == 1}">
    <li><a href="#">Reportes</a>
            <ul>
                <li><a href="#">Empleados</a></li>
                <li><a href="#">Usuarios</a></li>
                <li><a href="#">Promociones</a></li>
                <li><a href="#">Campañas</a></li>
            </ul>
        </li>
    </c:if>
    
    <c:if test="${sessionScope.rolReportes == 1}">
    <li><a href="#">Seguridad</a>
            <ul>
                <li><a href="#">Empleados</a></li>
                <li><a href="#">Usuarios</a></li>
                <li><a href="#">Promociones</a></li>
                <li><a href="#">Campañas</a></li>
            </ul>
        </li>
    </c:if>
    
    <li><a href="#">Ayuda</a>
      <ul>
        
        <li><a href="#">Horizontal CSS Menus</a></li>
        <li><a href="#">Vertical CSS Menus</a></li>
        <li><a href="#">Dreamweaver Menus</a></li>
      </ul>
    </li>
    
    
  </ul>
  
</div>

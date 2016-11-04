<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="menu">
  <ul>
    
    <li><a href="#" >Home</a></li>
    
    <c:if test="${sessionScope.rolVentas == 1}">
    <li><a href="#">Ventas</a>
      <ul>
        <li><a href="#">Drop Down CSS Menus</a></li>
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
        <li><a href="#">Horizontal CSS Menus</a></li>
        <li><a href="#">Vertical CSS Menus</a></li>
        <li><a href="#">Dreamweaver Menus</a></li>
      </ul>
    </li>
    </c:if>
    
    <c:if test="${sessionScope.rolConsultas == 1}">
    <li><a href="#">Consultas</a>
      <ul>
        <li><a href="mantEmpleados.jsp">Empleados</a></li>
        <li><a href="#">Horizontal CSS Menus</a></li>
        <li><a href="#">Vertical CSS Menus</a></li>
        <li><a href="#">Dreamweaver Menus</a></li>
      </ul>
    </li>
    </c:if>
    
    <c:if test="${sessionScope.rolReportes == 1}">
    <li><a href="#">Reportes</a>
      <ul>
        <li><a href="mantEmpleados.jsp">Empleados</a></li>
        <li><a href="#">Horizontal CSS Menus</a></li>
        <li><a href="#">Vertical CSS Menus</a></li>
        <li><a href="#">Dreamweaver Menus</a></li>
      </ul>
    </li>
    </c:if>
    
    <c:if test="${sessionScope.rolReportes == 1}">
    <li><a href="#">Seguridad</a>
      <ul>
        <li><a href="mantEmpleados.jsp">Empleados</a></li>
        <li><a href="#">Horizontal CSS Menus</a></li>
        <li><a href="#">Vertical CSS Menus</a></li>
        <li><a href="#">Dreamweaver Menus</a></li>
      </ul>
    </li>
    </c:if>
    
    <li><a href="#">Ayuda</a>
      <ul>
        <li><a href="mantEmpleados.jsp">Empleados</a></li>
        <li><a href="#">Horizontal CSS Menus</a></li>
        <li><a href="#">Vertical CSS Menus</a></li>
        <li><a href="#">Dreamweaver Menus</a></li>
      </ul>
    </li>
    
    
  </ul>
  
</div>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/menu.css" rel="stylesheet" type="text/css"/>
        <link href="css/estilo.css" rel="stylesheet" type="text/css"/>
        <title>::Ventas::</title>
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
            <h1>DATOS DEL CURSO</h1>
        Nombre: TALLER DE PROGRAMACION CONCURRENTE<br/>
        Profesor: CORONEL CASTILLO ERIC GUSTAVO <br/>
        Cilco: 4TO<br/>
        Periodo: 2016
        <h1>INTEGRANTES</h1>
        - AQUINO CHERO FLOR DE MARIA<br/>
        - CAPUENA RAMIREZ ROYSELITH<br/>
            </div>
            <div class="pie">
                <jsp:include page="pie.jsp"/>
            </div>
        </div>
    </body>
</html>

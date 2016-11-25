<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>INICIA TU SESION</title>
        <link href="css/estilos.css" rel="stylesheet" type="text/css"/>
        <style>
            #LOGON{
                background-color: white;
                color: green;
                margin: 100px auto;
                width: 400px;
                padding: 10px;
                color: black;
            }
        </style>
    </head>
    <body>
        <div id="LOGON">
            <div style="text-align: left;">
                <img src="img/logo.png" alt=""/>
            </div>
            <h1>INICIA TU SESION</h1>
            <c:if test="${requestScope.error != null}">
                <p class="egcc_error">${requestScope.error}</p>
            </c:if>
            <form method="post" action="LogonIngresar">
                <table>
                    <tr>
                        <td rowspan="2"><img src="img/login_2.png" /></td>
                        <td>Usuario:</td>
                        <td><input type="text" name="usuario"/></td>
                    </tr>
                    <tr>
                        <td>Clave:</td>
                        <td><input type="password" name="clave"/></td>
                    </tr>    
                    <tr>
                        <td colspan="3" style="text-align: center;">
                            <input type="submit" value="Ingresar" />
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </body>
</html>

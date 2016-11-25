<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/login.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <div>
            <p>${requestScope.error}</p>
            <form id="loginform" method="post" action="LoginInicio">
                <table class="inicio">
                    <tr>
                        <td><h1>INICIA SESION</h1></td>               
                    </tr>
                    <tr>
                        <td>Usuario:</td>
                        <td><input type="text" name="usuario" /></td>
                    </tr>
                    <tr>
                        <td>Clave:</td>
                        <td><input type="password" name="clave" /></td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <input  class="loginbutton" type="submit" value="Ingresar"/>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </body>
</html>

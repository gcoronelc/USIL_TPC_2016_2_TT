<%-- 
    Document   : calcular
    Created on : 29/08/2016, 09:49:18 AM
    Author     : Ocule
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>RESPUESTA</title>
        <link href="css/usil.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
    <center>
        <dim classe="usil_pagina">
            <h1>RESPUESTA</h1>
            <img src="img/CALCULADORA.png" alt=""/><tr>

            <table>
                <tr>
                   <td>OPERACION</td>
                   <td><%= request.getAttribute("operacion").toString() %></td>
                </tr>
                <tr>
                   <td>NUMERO 1:</td>
                   <td><%= request.getAttribute("num1").toString() %></td>
                </tr>
                <tr>
                    <td>NUMERO 2:</td>
                    <td><%= request.getAttribute("num2").toString() %></td>
                </tr>
                <tr>
                   <td>RESPUESTA</td>
                   <td><%= request.getAttribute("rpta").toString()%></td>
                </tr>
            </table>
            <a href="index.html">volver</a>
        <dim>
   </center>
</body
</html>

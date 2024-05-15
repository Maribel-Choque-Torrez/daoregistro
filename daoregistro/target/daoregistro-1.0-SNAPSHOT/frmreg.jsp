<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            h1 {
            text-align: center;
            font-size: 50px;
            }
            .centrado{
                width:400px;
                height: 100px;
                margin: 0 auto;
                display: flex;
                justify-content: center;
                align-items: center;
                border: 2px solid black;
            }
            body{
                background-color: #FFCDD2;
            }  
        </style>
    </head>
    <body>
        <div class="centrado">SEGUNDO PARCIAL TEM-742 <br>
            Nombre: Maribel Carola Choque Torrez <br>
            Carnet: 10930634
        </div> 
        <h1>
            <c:if test="${registro.id == 0}">Nuevo Registro</c:if>
            <c:if test="${registro.id != 0}">Editar Registro</c:if>
            
        </h1>
            <form action="Inicio" method="post">
                <input type="hidden" name="id" value="${registro.id}" />
            <table>
                <tr>
                    <td>Nombres: </td>
                    <td><input type="text" name="nombres" value="${registro.nombres}"/></td>
                </tr>
                <tr>
                    <td>Apellidos: </td>
                    <td><input type="text" name="apellidos" value="${registro.apellidos}"/></td>
                </tr>
                <tr>
                    <td>Seminario:</td>
                    <td><input type="text" name="seminario" value="${registro.seminario}"/></td>
                </tr>
                <tr>
                    <td>Confirmado:</td>
                    <td>
                        <c:if test="${registro.confirmado == 1}">
                        <input type="checkbox" name="confirmado" value="1" checked>
                        </c:if>
                        <c:if test="${registro.confirmado == 0}">
                        <input type="checkbox" name="confirmado" value="1">
                        </c:if>
                    </td>
                </tr>
                <tr>
                    <td>Fecha:</td>
                    <td><input type="date" name="fecha" value="${registro.fecha}"/></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" /></td>
                </tr>
            </table>
            </form>
    </body>
</html>

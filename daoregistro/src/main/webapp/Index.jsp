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
        <h1 >Registro Dia del Internet</h1>
        <p> <a href="Inicio?action=add"><input style="box_shadow: 1px 1px 2px;" type="submit" value="Nuevo" ></a></p>
        
        <table border="1">
            <tr>
                <th>Id</th>
                <th>Nombres</th>
                <th>Apellidos</th>
                <th>Seminarios</th>
                <th>Confirmado</th>
                <th>Fecha de Inscripcion</th>
                <th></th>
                <th></th>
            </tr>
            <c:forEach var="item" items="${registro}">
                <tr>
                    <td>${item.id}</td>
                    <td>${item.nombres}</td>
                    <td>${item.apellidos}</td>
                    <td>${item.seminario}</td>
                    <td>
                        <c:if test="${item.confirmado ==1}">
                            <input type="checkbox" checked>
                        </c:if>
                        <c:if test="${item.confirmado !=1}">
                            <input type="checkbox">
                        </c:if>
                            
                    </td>
                    <td>${item.fecha}</td>
                    <td><a href="Inicio?action=edit&id=${item.id}"><input style="box_shadow: 1px 1px 2px;"  type="submit" value="Insertar" ></a> </td>
                    <td><a href="Inicio?action=delete&id=${item.id}" onclick="return (confirm('Esta seguro'))"><input style="box_shadow: 1px 1px 2px;" type="submit" value="Eliminar" ></a></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>

<%-- 
    Document   : ProductoVTA
    Created on : 4/02/2022, 09:41:36 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
        <title>Prueba de consulta</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <h1>Productos</h1>
            </div>
            <div class="row">
            <div class="card-body">
        <table class="table table-hover table-dark">
            <thead>
                <tr>
                    <th>N id</th>
                    <th>Nombre</th>
                    <th>Descripcion</th>
                    <th>Unidades</th>
                    <th>Valor</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="objP" items="${lista_prod}">
                <tr>
                    <td>${objP.getId_prod()}</td>
                    <td>${objP.getNombre_prod()}</td>
                    <td>${objP.getDescripcion_prod()}</td>
                    <td>${objP.getUnd()}</td>
                    <td>${objP.getValor()}</td>
                    <td>
                        <a type="button" class="btn btn-primary">ver</a>
                        <a href="ProductoCTO?accion=eliminar&id=${objP.getId_prod()}" type="button" class="btn btn-danger">Eliminar</a>
                        <a type="button" class="btn btn-warning">Modificar</a>
                    </td>
                </tr>
                </c:forEach>
            </tbody>
        </table>
        </div>
        </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.min.js" integrity="sha384-VHvPCCyXqtD5DqJeNxl2dtTyhF78xXNXdkwX1CZeRusQfRKp+tA7hAShOK/B/fQ2" crossorigin="anonymous"></script>
    </body>
</html>

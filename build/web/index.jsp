<%-- 
    Document   : index
    Created on : 4/02/2022, 05:44:55 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>wenassss</h1>
        <a href="ProductoCTO?accion=listar_datos">lista de productos</a>
        <div class="modal-dialog text-center">
            <div class="col-lg-8">
                <div class="modal-content col-12">
                    <div class="col-12">
                        <img src="img/inicio.jpg" alt="" height="120" width="120"/>
                    </div>
                    <form action="MiSesionCTO?accion=validar" method="POST">
                        <div class="form-group text-center">
                            <p>
                                Bienvenido al sistema de acceso
                            </p>                           
                        </div>
                        <div class="form-group text-center">
                            <label>Usuario</label>
                            <br>
                            <input type="text" name="txtusuario" placeholder="ejemplo@correo.com" class="form-group" required/>
                        </div>
                        <div class="form-group text-center">
                            <label>Clave de acceso</label>
                            <input type="password" name="txtpss" placeholder="clave" class="form-group" required/>
                        </div>
                        <input type="submit" name="btnIngresar" value="Ingresar" class="btn btn-primary"/>
                    </form>
                </div>
            </div>
            
        </div>
        
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.min.js" integrity="sha384-VHvPCCyXqtD5DqJeNxl2dtTyhF78xXNXdkwX1CZeRusQfRKp+tA7hAShOK/B/fQ2" crossorigin="anonymous"></script>
    </body>
</html>

<%@page import="model.Bean.Consignado"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html SYSTEM "about:legacy-compat">

<html>
    <head>
        <title>Consignado Individual</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/bootstrap.css">
        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
        <!-- Latest compiled JavaScript -->
        <script src="js/bootstrap.min.js"></script>
        <link href="assets/css/custom.css" rel="stylesheet" />
        <style>
            /* Remove the navbar's default margin-bottom and rounded borders */ 
            .navbar {
                margin-bottom: 0;
                border-radius: 0;

            }
        </style>
        <!-- script que define a máscara para o campo CPF -->
        <script> 
        function formatar(mascara, documento){   var i = documento.value.length;  
        var saida = mascara.substring(0,1);  
        var texto = mascara.substring(i)   
        if (texto.substring(0,1) != saida){    documento.value += texto.substring(0,1); } }
        </script>
        
        <title>Empregado</title>
    </head>
    <body>
        <nav class="navbar navbar-inverse" style="min-height: 135px">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#"><img  src="Consignado/WebContent/Imagens/KordsaLogo.png" alt=""> </a>
                </div>
                <div class="container" id="divMenuConsultarConsignado" style="padding-top: 1cm">
                    <ul class="nav navbar-nav">
                        <li> <a href="Inicio.jsp" style="color:#FFFFFF; font-size: x-large">Sobre</a></li>
                    </ul>
                </div>
                <ul class="nav navbar-nav navbar-right" style="padding-top: 0.5cm">
                    <li><a href="#" class="dropdown-toggle" data-toggle="dropdown" style="color:#FFFFFF; font-size: x-large">Colaborador</a></li>
                    <ul class="dropdown-menu">
                        <li><a href="Inicio.jsp"><span class="glyphicon glyphicon-log-out"></span>Sair</a></li>
                    </ul>   
                </ul>
            </div>
        </nav>
        <div class="jumbotron">
            <div class="container text-center">
                <p>Consultar Margem Para Empréstimo Consignado</p>
            </div>
            <div class="container">
                <form action="ConsultarConsignadoEmpregado" method="post"> <!-- o action deve conter o controller -->
                    <% Consignado consigResp = (Consignado) request.getAttribute("consigResp");%>
                    <div class="form-group row">
                        <label for="txtCPF" class="col-sm-2 form-control-label">CPF do Funcionário</label>
                        <div class="col-sm-3">
                            <input type="text" class="form-control" name="txtCPF" maxlength="14" onkeypress="formatar('###.###.###-##', this);">
                        </div>
                    </div>                                        
                    <div class="form-group row">
                        <label for="txtSaldoConsignado" class="col-sm-2 form-control-label">Valor Consignado</label>
                        <div class="col-sm-3">
                        <%if (consigResp != null) {%>   
                            <input type="text" class="form-control" readonly="true" value="<%=consigResp.getMargem()%>" name="txtSaldoConsignado">
                        <% } %>
                        </div>                         
                    </div>                    
                    <button type="submit" class="btn btn-warning">Consultar</button>
                </form>
            </div>
        </div>
        <footer class="container-fluid text-center">
            <p>SCMC- Sistema Consulta Margem Consignado, Copyright © 2018 </p>
        </footer>
    </body>
</html>

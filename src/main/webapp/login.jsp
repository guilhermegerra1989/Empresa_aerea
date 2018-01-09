<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <base href="<%=request.getContextPath() %>">
    <title>Projeto Empresa Aérea</title>
    <link rel="shortcut icon" href="<%=request.getContextPath() %>/static/img/favicon.ico">
    <link href="<%=request.getContextPath() %>/static/css/bootstrap.css" type="text/css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/static/css/base.css" type="text/css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/static/css/animate.css" type="text/css" rel="stylesheet">
    <script type="text/javascript" src="<%=request.getContextPath() %>/static/js/lib/jquery-2.0.2.min.js"></script>
</head>
<body style="background-image:url('<%= request.getContextPath() %>/static/img/back_ground.jpg');background-repeat:no-repeat;">
<div class="container">
    <div class="row">
        <div class="col-md-4 col-md-offset-4" >

            <div class="panel">
                <div class="panel-heading" style="border-color: #e5e5e5">
                    <i class="glyphicon glyphicon-warning-sign"></i>
                      Por favor insira suas credenciais.
                </div>

                <div class="panel-body">
                    <c:if test="${param.error != null && param.error eq true}">
                        <div class="alert alert-danger">
                            Usuário ou senha inválidos
                        </div>
                    </c:if>

                    <form id="login-form" method="post" action="<%= request.getContextPath() %>/login-check">
                        <div class="form-group">
                            <label class="control-label" for="username">Usuário:</label>

                            <div class="input-group">
                                    <span class="input-group-addon">
                                        <i class="glyphicon glyphicon-user"></i>
                                    </span>

                                <input type="text" class="form-control" id="username" name="username" placeholder="Insira o usuário...">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label" for="password">Senha:</label>

                            <div class="input-group">
                                    <span class="input-group-addon">
                                        <i class="glyphicon glyphicon-lock"></i>
                                    </span>

                                <input type="Password" id="password" class="form-control" name="password" placeholder="Insira sua senha...">
                            </div>
                        </div>

                        <button id="login-button" type="submit" class="btn btn-primary btn-lg btn-block">
                            <i class="glyphicon glyphicon-log-in"></i>
                            Entrar
                        </button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

 <script type="text/javascript">
    $('.container').addClass('animated bounceIn');

    $('#login-button').on('click', function (e) {
        e.preventDefault();

        $(document.body).addClass('animated bounceOut');

        setTimeout(function () {
            $('#login-form').submit();
        }, 1000);
    });
</script> 
</body>
</html>
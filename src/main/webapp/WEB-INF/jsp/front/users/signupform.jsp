<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="/resources/images/favicon.ico">

    <title>PENSION</title>

    <!-- Bootstrap core CSS -->
    <link type="text/css" href="/resources/components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link type="text/css" href="/resources/css/dashboard.css" rel="stylesheet">

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script type="application/javascript" src="/resources/js/ie10-viewport-bug-workaround.js"></script>

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script type="application/javascript" src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script type="application/javascript" src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

<jsp:include page="/WEB-INF/jsp/common/topmenu.jsp"/>

<div class="container-fluid"/>
    <div class="row">
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <h1 class="page-header">Sign Up</h1>

            <form:form acceptCharset="UTF-8" action="/users/signup" method="post" modelAttribute="user" cssClass="form-horizontal" role="form">
                <div class="form-group">
                    <label for="loginId" class="col-sm-2 control-label">Username</label>
                    <div class="col-sm-4">
                        <form:input path="loginId" id="loginId" type="text" cssClass="form-control" placeholder="username" />
                        <form:errors path="loginId" cssClass="form-inline" />
                    </div>
                </div>
                <div class="form-group">
                    <label for="email" class="col-sm-2 control-label">Email</label>
                    <div class="col-sm-4">
                        <form:input path="email" id="email" type="email" cssClass="form-control" placeholder="email" />
                        <form:errors path="email" cssClass="form-inline" />
                    </div>
                </div>
                <div class="form-group">
                    <label for="name" class="col-sm-2 control-label">Name</label>
                    <div class="col-sm-4">
                        <form:input path="name" id="name" type="text" cssClass="form-control" />
                        <form:errors path="name" cssClass="form-inline" />
                    </div>
                </div>
                <div class="form-group">
                    <label for="password" class="col-sm-2 control-label">Password</label>
                    <div class="col-sm-4">
                        <form:input path="password" id="password" type="password" cssClass="form-control" />
                        <form:errors path="password" cssClass="form-inline" />
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <input class="btn btn-success" type="submit" value="Submit">
                    </div>
                </div>
            </form:form>
        </div>
    </div>
</div>

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
</body>
</html>

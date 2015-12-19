<%--
  Created by IntelliJ IDEA.
  User: george
  Date: 12/8/15
  Time: 3:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <jsp:include page="/WEB-INF/jsp/common/adminHeader.jsp">
    <jsp:param name="title" value="PENSION"/>
  </jsp:include>
</head>
<jsp:include page="/WEB-INF/jsp/common/adminHead.jsp"/>

<!-- Carousel
================================================== -->
<%--body--%>
<div class="box">
  <div class="box-header with-border">
    <h3 class="box-title">PENSION ADMIN</h3>
    <div class="box-tools">
      <%--<div class="input-group">--%>
      <%--<input type="text" name="table_search" class="form-control input-sm pull-right" style="width: 150px;" placeholder="Search"/>--%>
      <%--<div class="input-group-btn">--%>
      <%--<button class="btn btn-sm btn-default"><i class="fa fa-search"></i></button>--%>
      <%--</div>--%>
      <%--</div>--%>
    </div>
  </div><!-- /.box-header -->
  <div class="box-body table-responsive no-padding">
    <h3>Welcome To Admin Panel</h3>
  </div>

  <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
    <h1 class="page-header">Add Employee</h1>

    <form:form acceptCharset="UTF-8" action="/admin/pension/newemployee/${action}" method="post" modelAttribute="employee" cssClass="form-horizontal" role="form">
      <div class="form-group">
        <label for="idNumber" class="col-sm-2 control-label">ID Number</label>
        <div class="col-sm-4">
          <form:input path="idNumber" id="idNumber" type="Long" cssClass="form-control" placeholder="idNumber" />
          <form:errors path="idNumber" cssClass="form-inline" />
          <form:input path="id" type="hidden"/>
        </div>
      </div>
      <div class="form-group">
        <label for="firstName" class="col-sm-2 control-label">First Name</label>
        <div class="col-sm-4">
          <form:input path="firstName" id="firstName" type="text" cssClass="form-control" placeholder="firstName" />
          <form:errors path="firstName" cssClass="form-inline" />
        </div>
      </div>
      <div class="form-group">
        <label for="secondName" class="col-sm-2 control-label"> Second Name</label>
        <div class="col-sm-4">
          <form:input path="secondName" id="secondName" type="text" cssClass="form-control" />
          <form:errors path="secondName" cssClass="form-inline" />
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
        <div class="col-sm-offset-2 col-sm-10">
          <input class="btn btn-success" type="submit" value="Submit">
        </div>
      </div>
    </form:form>
  </div>

</div>
<%--end body--%>
<!-- start of footer section -->

<jsp:include page="/WEB-INF/jsp/common/adminFooter.jsp"/>
</html>

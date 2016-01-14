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

<script type="text/javascript">
  $('#dp3').datepicker();
</script>

<!-- Carousel
================================================== -->
<%--body--%>
<div class="box">
  <div class="box-header with-border">
    <h3 class="box-title">PENSION ADMIN : ${employer.name}</h3>
    <div class="box-tools">
      <a href="/admin/pension/employer/${employer.id}"><< Back</a>
      <%--<div class="input-group">--%>
      <%--<input type="text" name="table_search" class="form-control input-sm pull-right" style="width: 150px;" placeholder="Search"/>--%>
      <%--<div class="input-group-btn">--%>
      <%--<button class="btn btn-sm btn-default"><i class="fa fa-search"></i></button>--%>
      <%--</div>--%>
      <%--</div>--%>
    </div>
  </div><!-- /.box-header -->
  <div class="box-body table-responsive no-padding">
    <div class="col-sm-9 col-sm-offset-1 col-md-10 col-md-offset-1 main">
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
            <form:input path="employerId" type="hidden" value="${employer.id}" />
          </div>
        </div>
        <div class="form-group">
          <label for="secondName" class="col-sm-2 control-label"> Second Name</label>
          <div class="col-sm-4">
            <form:input path="secondName" id="secondName" type="text" cssClass="form-control" placeholder="firstName" />
            <form:errors path="secondName" cssClass="form-inline" />
          </div>
        </div>
        <div class="form-group">
          <label for="sirName" class="col-sm-2 control-label"> Sir Name</label>
          <div class="col-sm-4">
            <form:input path="sirName" id="secondName" type="text" cssClass="form-control" placeholder="Sir name" />
            <form:errors path="sirName" cssClass="form-inline" />
          </div>
        </div>
        <div class="form-group">
          <label for="dateOfBirth" class="col-sm-2 control-label"> Date of Birth</label>
          <div class="col-sm-4">
            <div class="input-append date" id="dp3" data-date="12-02-2012" data-date-format="dd-mm-yyyy">
              <input class="span2" size="16" type="text" name="dateOfBirth" id="dateOfBirth" >
              <span class="add-on"><i class="icon-th"></i></span>
            </div>
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
          <label for="idNumber" class="col-sm-2 control-label"> KRA PIN</label>
          <div class="col-sm-4">
            <form:input path="kraPin" id="kraPin" type="text" cssClass="form-control" placeholder="KRA PIN" />
            <form:errors path="kraPin" cssClass="form-inline" />
          </div>
        </div>

        <h1 class="page-header">Bank details</h1>

        <div class="form-group">
          <label for="bankName" class="col-sm-2 control-label"> Bank name</label>
          <div class="col-sm-4">
            <form:input path="bankName" id="bankName" type="text" cssClass="form-control" placeholder="Bank name" />
            <form:errors path="bankName" cssClass="form-inline" />
          </div>
        </div>

        <div class="form-group">
          <label for="bankBranch" class="col-sm-2 control-label"> Bank branch</label>
          <div class="col-sm-4">
            <form:input path="bankBranch" id="bankBranch" type="text" cssClass="form-control" placeholder="Bank branch" />
            <form:errors path="bankBranch" cssClass="form-inline" />
          </div>
        </div>

        <div class="form-group">
          <label for="accountNumber" class="col-sm-2 control-label"> Account number</label>
          <div class="col-sm-4">
            <form:input path="accountNumber" id="bankBranch" type="text" cssClass="form-control" placeholder="Account number" />
            <form:errors path="accountNumber" cssClass="form-inline" />
          </div>
        </div>

        <div class="form-group">
          <label for="monthlySalary" class="col-sm-2 control-label"> Monthly salary</label>
          <div class="col-sm-4">
            <form:input path="monthlySalary" id="monthlySalary" type="text" cssClass="form-control" placeholder="Monthly salary" />
            <form:errors path="monthlySalary" cssClass="form-inline" />
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
<%--end body--%>
<!-- start of footer section -->

<jsp:include page="/WEB-INF/jsp/common/adminFooter.jsp"/>
</html>

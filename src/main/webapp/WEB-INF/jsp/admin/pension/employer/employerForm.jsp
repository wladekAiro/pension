<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <jsp:include page="/WEB-INF/jsp/common/adminHeader.jsp">
    <jsp:param name="title" value="PENSION"/>
  </jsp:include>
</head>
<jsp:include page="/WEB-INF/jsp/common/adminHead.jsp"/>
<body>

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
    <h1 class="page-header">Add Employer</h1>
   <form:form acceptCharset="UTF-8" action="/admin/pension/newEmployer/${action}" method="post" modelAttribute="employer" cssClass="form-horizontal" role="form">
     <div class="form-group">
       <label for="name" class="col-sm-2 control-label">Employer Name</label>
       <div class="col-sm-4">
         <form:input path="name" id="name" type="text" cssClass="form-control" placeholder="employerName" />
         <form:input path="id" id="id" type="hidden"/>
         <form:errors path="name" cssClass="form-inline" />
       </div>
     </div>
     <div class="form-group">
       <label for="employer_id" class="col-sm-2 control-label">Employer ID</label>
       <div class="col-sm-4">
         <form:input path="employer_id" id="employer_id" type="text" cssClass="form-control" placeholder="Employer id" />
         <form:errors path="employer_id" cssClass="form-inline" />
       </div>
     </div>
     <div class="form-group">
       <label for="employer_id" class="col-sm-2 control-label">Employer Number</label>
       <div class="col-sm-4">
         <form:input path="employerNumber" id="employer_id" type="text" cssClass="form-control" placeholder="Employer number" />
         <form:errors path="employerNumber" cssClass="form-inline" />
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
</body>
</html>

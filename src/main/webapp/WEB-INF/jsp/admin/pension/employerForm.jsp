<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employer Registration</title>
</head>
<body>
 <div>
   <form:form acceptCharset="UTF-8" action="#" method="post" modelAttribute="" cssClass="form-horizontal" role="form">
     <div class="form-group">
       <label for="name" class="col-sm-2 control-label">Employer Name</label>
       <div class="col-sm-4">
         <form:input path="name" id="name" type="text" cssClass="form-control" placeholder="employerName" />
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
       <div class="col-sm-offset-2 col-sm-10">
         <input class="btn btn-success" type="submit" value="Submit">
       </div>
     </div>
   </form:form>
 </div>
</body>
</html>

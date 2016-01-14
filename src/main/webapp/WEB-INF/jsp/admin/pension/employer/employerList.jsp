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
        <h3 class="box-title">MANAGE EMPLOYERS</h3>
        <div class="box-tools">
            <%--<div class="input-group">--%>
                <%--<input type="text" name="table_search" class="form-control input-sm pull-right" style="width: 150px;" placeholder="Search"/>--%>
                <%--<div class="input-group-btn">--%>
                    <%--<button class="btn btn-sm btn-default"><i class="fa fa-search"></i></button>--%>
                <%--</div>--%>
            <%--</div>--%>
        </div>
    </div>
    <div class="box-body no-padding">
        <div class="col-sm-3 col-sm-offset-2">
            <a class="btn btn-default" href="/admin/pension/employerForm">Register new Employer</a>
        </div>
    </div>
    <div class="box-body table-responsive no-padding">
        <div class="table-responsive">
                <c:if test="${message}">
                    <div class="alert alert-success">
                        Deleted ....
                    </div>
                    </c:if>
            <c:choose>
                <c:when test="${empty employers}">
                    <h5>No Employers available</h5>
                </c:when>
                <c:otherwise>
                    <table class="table table-striped table-bordered table-hover">
                        <thead>
                        <tr>
                            <th>NAME</th>
                            <th>ID</th>
                            <th>NUMBER</th>
                            <th>EMPLOYEES</th>
                            <th></th>
			                <th></th>
                            <th></th>
                        </tr>
                        </thead>
                        <c:forEach items="${employers}" var="employer">
                            <tbody>
                            <td>${employer.name}</td>
                            <td>${employer.employer_id}</td>
                            <td>${employer.employerNumber}</td>
                            <td>${employer.employee.size()}</td>
                            <td>
                                <a href="/admin/pension/employer/${employer.id}">Show</a>
                            </td>
                            <td>
				                <a href="/admin/pension/employer/${employer.id}/edit">Edit</a>
			                </td>
                            <th>
                                <a href="/admin/pension/employer/${employer.id}/delete">Delete</a>
                            </th>
                            </tbody>
                        </c:forEach>
                    </table>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</div>
<%--end body--%>
<!-- start of footer section -->

<jsp:include page="/WEB-INF/jsp/common/adminFooter.jsp"/>
</html>

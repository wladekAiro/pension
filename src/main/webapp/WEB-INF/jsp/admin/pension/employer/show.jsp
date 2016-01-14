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
        <h3 class="box-title">MANAGE EMPLOYER :  ${employer.name}</h3>
        <div class="box-tools">
            <a href="/admin/pension/employers"><< Back</a>
            <div class="input-group">
                <input type="text" name="table_search" class="form-control input-sm pull-right" style="width: 150px;" placeholder="Search"/>
                <div class="input-group-btn">
                    <button class="btn btn-sm btn-default"><i class="fa fa-search"></i></button>
                </div>
            </div>
        </div>
    </div><!-- /.box-header -->
    <div class="box-body no-padding">
            <div class="row">
                <div class="col-sm-3 col-sm-offset-0">
                    <h4>
                        Employees
                    </h4>
                </div>
                <div class="col-sm-3 col-sm-offset-2">
                    <a class="btn btn-default" href="/admin/pension/employee/${employer.id}/add">Register New Employee</a>
                </div>
            </div>
        </div>
    <div class="box-body table-responsive no-padding">
            <div class="col-md-12 col-md-offset-0 table-responsive no-padding">
                <div class="table-responsive">
                    <c:if test="${message}">
                        <div class="alert alert-success">
                            Deleted ....
                        </div>
                    </c:if>
                    <c:choose>
                        <c:when test="${empty employees.content}">
                            <h5>No Employees available</h5>
                        </c:when>
                        <c:otherwise>
                            <table class="table table-striped table-bordered table-hover">
                                <thead>
                                <tr>
                                    <th>NAME</th>
                                    <th>ID NUMBER</th>
                                    <th>SALLARY</th>
                                    <th>DATE OF BIRTH</th>
                                    <th></th>
                                    <th></th>
                                    <th></th>
                                </tr>
                                </thead>
                                <c:forEach items="${employees.content}" var="employee">
                                    <tbody>
                                    <td>${employee.getFullName()}</td>
                                    <td>${employee.idNumber}</td>
                                    <td>${employee.monthlySalary}</td>
                                    <td>${employee.dateOfBirth}</td>
                                    <td>
                                        <a href="#">Show</a>
                                    </td>
                                    <td>
                                        <a href="#">Edit</a>
                                    </td>
                                    <th>
                                        <a href="#">Delete</a>
                                    </th>
                                    </tbody>
                                </c:forEach>
                            </table>
                            <div class="row">
                                <div class="col-sm-3 col-sm-offset-0">
                                    <jsp:include page="/WEB-INF/jsp/common/pagination.jsp">
                                        <jsp:param name="paginatedRecord" value="employees"/>
                                        <jsp:param name="url" value="${pagenatedUrl}"/>
                                    </jsp:include>
                                </div>
                            </div>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </div>
</div>
<%--end body--%>
<!-- start of footer section -->

<jsp:include page="/WEB-INF/jsp/common/adminFooter.jsp"/>
</html>

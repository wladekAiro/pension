<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%--

    Does the pagination of all records,

    on the include tag pass the name of the spring Page type containing all the paginated data

    pass also the desired url to use to fetch paginated records

--%>



<%--
  get the name of paginated record
--%>
<c:set var="paginatedObjectName" value="${param.paginatedRecord}"/>

<%--
  the actual object containing the paginated records
--%>
<c:set var="paginatedObject" value="${requestScope.get(paginatedObjectName)}"/>


  <%-- the pagination --%>
  <div class="col m12">
      <ul class="pagination">

        <%-- check if number of pages is more than one--%>
        <c:if test="${paginatedObject.totalPages > 1}">

          <%-- check if the are pages before this page--%>
          <c:if test="${paginatedObject.hasPrevious()}">
            <li>
              <a href="${param.url}?page=${paginatedObject.number+1-1}">
                <span aria-hidden="true">&laquo;</span><span class="sr-only">Previous</span>
              </a>
            </li>
          </c:if>

          <c:forEach begin="1" end="${paginatedObject.totalPages}"  var="localI">
            <c:choose>

              <%--
                  Spring Data uses 0-indexed pages, add one to make it start at 1
              --%>
              <c:when test="${localI==(paginatedObject.number+1)}">
                <li class="active">
                  <a href="${param.url}?page=${localI}">${localI}</a>
                </li>
              </c:when>
              <c:when test="${localI!=(paginatedObject.number+1)}">
                <li>
                  <a href="${param.url}?page=${localI}">${localI}</a>
                </li>
              </c:when>
            </c:choose>

          </c:forEach>


          <c:if test="${paginatedObject.hasNext()}">
            <li>
              <a href="${param.url}?page=${paginatedObject.number+1+1}">
                <span aria-hidden="true">&raquo;</span><span class="sr-only">Next</span>
              </a>
            </li>
          </c:if>
        </c:if>
      </ul>
  </div>

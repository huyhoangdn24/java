<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<body>
<div class="container" style="margin-top: 60px;">
	<div class="row">
		<div class="col-xs-12 col-sm-8 col-md-6">
			<form:form action="search" method="get">
				<div class="input-group">
					<input name = "searchInput" type="text" class="form-control" placeholder="Search by name or author..."/>
					<span class="input-group-btn">
                                    <button class="btn btn-primary" type ="submit"> Search</button>
                                </span>
				</div>
			</form:form>
		</div>

		<div class="col-xs-12 col-sm-12 col-md-10">
			<c:if test="${not empty ordersList}">
				<table class="table table-condensed table-hover">
					<thead>
					<tr>
						<th>OrderID</th>
						<th>OrderDate</th>
						<th>Customer Name</th>
						<th>View Details</th>
					</tr>
					</thead>
					<tbody>
					<c:forEach var="orders" items="${ordersList}" varStatus="index">
						<tr>
							<td>${orders.id}</td>
							<td>${orders.orderDate}</td>
							<td>${orders.customerName}</td>

							<td>

								<button class="btn btn-sm btn-danger" onclick="location.href='viewdetails/${orders.id}'">view details</button>
							</td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
			</c:if>
			<c:if test="${ordersList.size() == 0}">
				<br>
				<div clas="alert alert-warning">
					There is no data
				</div>
			</c:if>
		</div>
	</div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="${pageContext.request.getContextPath()}/webjars/bootstrap/3.3.7/js/bootstrap.min.js"><script>
</script>
</body>
</html>
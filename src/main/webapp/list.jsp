<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Travel Thru Air</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<div class="navbar-brand" style="width: auto; margin-left: auto; margin-right: auto">
				TRAVEL THRU AIR
			</div>
		</nav>
	</header>
	<br>

	<div class="container">
			<h3 class="text-center">Current Special Deals</h3>
			<hr>
			<div class="container text-right">
			    <c:if test="${filtered != null}">
					<a href="<%=request.getContextPath()%>/clearFilter" class="btn btn-success">Clear Filter</a>
				</c:if>
				<a href="<%=request.getContextPath()%>/filter" class="btn btn-success">Filter</a>
			</div>
			<br>
			<c:set var = "found" scope = "request" value = "${found}"/>
			<c:choose>
			    <c:when test="${found == 'yes'}">
			    		<table class="table table-bordered">
						<thead>
							<tr>
								<th>Flight Number</th>
								<th>From</th>
								<th>To</th>
								<th>Departs at</th>
								<th>Arrives at</th>
								<th>Discount</th>
								<th>Fare (in Rs.)</th>
								<th>Deal expires at</th>
							</tr>
						</thead>
		
						<tbody>
							<c:forEach var="flight" items="${listFlight}">
		
								<tr>
									<td><c:out value="${flight.id}" /></td>
									<td><c:out value="${flight.departure_city}" /></td>
									<td><c:out value="${flight.arrival_city}" /></td>
									<td><c:out value="${flight.departure_time}" /></td>
									<td><c:out value="${flight.arrival_time}" /></td>
									<td><c:out value="${flight.discount}%" /></td>
									<td><p style="text-decoration: line-through;"><c:out value="${flight.cost}" /></p><c:out value="${flight.lessCost}" /></td>
									<td><c:out value="${flight.end_time}" /></td>
								</tr>
							</c:forEach>
							<!-- } -->
						</tbody>
		
						</table>  
			    </c:when>    
			    <c:otherwise>
			        <h2 style="text-align:center">No flights found</h2>
			    </c:otherwise>
			</c:choose>
	</div>
</body>
</html>

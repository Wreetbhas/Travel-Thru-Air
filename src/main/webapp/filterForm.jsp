<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Travel Thru Air</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<form action="showFilteredFlights" method="post">

				<fieldset class="form-group">
					<label for="From">From:</label>
                        <select name="From" class="form-control">
                          <option value="" >None</option>
                          <c:forEach var="city" items="${depCities}">
                              <option value="${city}" >${city}</option>
                          </c:forEach>
                        </select>
				</fieldset>
				
				<fieldset class="form-group">
					<label for="To">To:</label>
                        <select name="To" class="form-control">
                          <option value="" >None</option>
                          <c:forEach var="city" items="${arrCities}">
                              <option value="${city}" >${city}</option>
                          </c:forEach>
                        </select>
				</fieldset>

				<fieldset class="form-group">
					<label>From Time</label> <input type="time" class="form-control" name="from_time">
				</fieldset>
				
				<fieldset class="form-group">
					<label>To Time</label> <input type="time" class="form-control" name="to_time">
				</fieldset>
				<button type="submit" class="btn btn-success">Filter</button>
				</form>
			</div>
		</div>
	</div>

</div>
</body>
</html>

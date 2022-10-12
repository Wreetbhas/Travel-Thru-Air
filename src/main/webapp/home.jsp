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
<style>
</style>
</head>

<body>
	 <div class="landing-page" style="background: white url('https://images.all-free-download.com/images/graphiclarge/flying_airplane_background_colorful_decoration_6827698.jpg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940') no-repeat scroll center; background-size: 100% 100%; height: 100vh; color: #c8cfcf;">
                <div class="wrapper" style="background-color: rgba(0,0,0,0.1); height: 100%">
		<div class="d-flex flex-column justify-content-center align-items-center text-center h-100" >
                        <h5 class="display-4 animated zoomIn"><strong>Travel Thru Air</strong></h5>
                        <p class="animated zoomIn"><a href="<%=request.getContextPath()%>/list"
					    class="nav-link" style="color:red;font-size: 20px">See flights with special deals</a></p>
                    </div>
		</div>
		</div>
		</div>
	</div>
</body>
</html>

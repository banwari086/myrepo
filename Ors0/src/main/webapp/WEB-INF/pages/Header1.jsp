<%@page import="com.sunilos.proj0.dto.RoleDTO"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.sunilos.proj0.dto.UserDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<html lang="en">
<head>
<title>Project0</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<link rel="stylesheet" href="../../css/style.css">
<link rel="stylesheet" href="css/pickmeup.min.css">

<link rel="stylesheet" href="css/datepicker.css">




<!-- jQuery library -->

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script src="http://code.jquery.com/ui/1.11.0/jquery-ui.js"></script>
<!-- <link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script> -->
</head>


<body>
	
	

	<div class="container">
		<nav class="navbar navbar-inverse">
			<div class="container-fluid">
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="/bs-example-navbar-collapse-1"
						aria-expanded="false">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand"><img alt="Brand" src="http://localhost:8080/Ors0/img/logo.png"
						width="140" height="30"></a>
				</div>

				<!-- Collect the nav links, forms, and other content for toggling -->


				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<li class="active"><a href="<c:url value="/Welcome" />"> <span
								class="glyphicon glyphicon-home"></span> &nbsp;Home
						</a></li>

						<c:if test="${not empty sessionScope.user}">

                         <c:if test="${sessionScope.user.roleId == 1}">

						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown" role="button" aria-haspopup="true"
							aria-expanded="false">User<span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="<c:url value="/ctl/User" />">Add User </a></li>
								<li><a href="<c:url value="/ctl/User/search" />">User List</a></li>
							</ul></li>
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown" role="button" aria-haspopup="true"
							aria-expanded="false">Role<span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="<c:url value="/ctl/Role" />">Add Role</a></li>
								<li><a href="<c:url value="/ctl/Role/search" />"> Role List </a></li>
							</ul></li>
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown" role="button" aria-haspopup="true"
							aria-expanded="false">Student<span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="<c:url value="/ctl/Student" />">Add Student</a></li>
								<li><a href="<c:url value="/ctl/Student/search" />">Student
										List</a></li>
							</ul></li>

						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown" role="button" aria-haspopup="true"
							aria-expanded="false">College<span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="<c:url value="/ctl/College" />">Add College </a></li>
								<li><a href="<c:url value="/ctl/College/search" />">College
										List</a></li>
							</ul></li>
							
							
							<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown" role="button" aria-haspopup="true"
							aria-expanded="false">Marksheet<span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="<c:url value="/ctl/Marksheet" />">Add Marksheet </a></li>
								<li><a href="<c:url value="/ctl/Marksheet/search" />">MarksheetList
										List</a></li>
							</ul></li>
						  </c:if>
						
						
					</ul>
					</li>
					
					

					
					</ul>

					  </c:if>

					<%-- <li class="active <%=!userLoggedIn ? "hidden" : " "%>"><a href="<%=ORSView.JAVA_DOC_VIEW%>"> JavaDoc
					</a></li> --%>

					 <ul class="nav navbar-nav navbar-right">
						<li class="dropdown"><a href="/" class="dropdown-toggle"
							data-toggle="dropdown" role="button" aria-haspopup="true"
							aria-expanded="false"><span class="glyphicon glyphicon-user"></span>&nbsp;Welcome :
                <c:out value="${sessionScope.user.firstName}" />
                <c:out value="${sessionScope.user.lastName}" />
                (
                <c:out value="${sessionScope.user.roleId}" />
                )
								<span class="caret"></span></a>

							<ul class="dropdown-menu">
								<c:if test="${not empty sessionScope.user}">
								<li><a href="#"><span
										class="glyphicon glyphicon-user"></span> &nbsp;My Profile </a></li>
								<li
									class=""><a
									href="#"><span
										class="glyphicon glyphicon-book"></span> &nbsp;Javadoc </a></li>
								<li><a href="#"><span
										class="glyphicon glyphicon-cog"></span> &nbsp;Change Password</a></li>
								<li class=""><a
									href="#"><span
										class="glyphicon glyphicon-send"></span> &nbsp;Forget Password</a>
								<li><a
									href="<c:url value="/Login" />"><span
										class="glyphicon glyphicon-log-out"></span> &nbsp;Logout</a></li>
								  </c:if>


								<li class=""><a
									href="<c:url value="/UserRegistration" />"><span
										class="glyphicon glyphicon-save"></span> &nbsp;User
										Registration</a></li>

								<li class=""><a
									href="<c:url value="/Login" />"><span
										class="glyphicon glyphicon-save"></span> &nbsp;Login</a></li>


							</ul>
					</ul> 

				</div>
				<!-- /.navbar-collapse -->
			</div>
			<!-- /.container-fluid -->
		</nav>

	</div>
</body>
</html>

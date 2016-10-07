<%@page import="com.sunilos.proj0.dto.RoleDTO"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page isELIgnored="false"%>
<head>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
	<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script src="http://code.jquery.com/ui/1.11.0/jquery-ui.js"></script>
</head>
<table width="100%">
    <tr>
        <td><H1 align="center">Online Result System</H1></td>
        <td align="right"><img height="50px"
            src="Ors0/img/logo.png"></td>
    </tr>
    <tr>
        <td>
            <H2>
                Welcome :
                <c:out value="${sessionScope.user.firstName}" />
                <c:out value="${sessionScope.user.lastName}" />
                (
                <c:out value="${sessionScope.user.roleId}" />
                )
            </H2>
        </td>
        <td align="right"><a href="<c:url value="/Welcome" />"> Home
        </a> | <c:choose>
                <c:when test="${empty sessionScope.user}">
                    <a href="<c:url value="/Login" />">Login</a>
                </c:when>
                <c:otherwise>
                    <a href="<c:url value="/Login" />">Logout</a>
                </c:otherwise>
            </c:choose></td>
    </tr>
    <tr>
        <td colspan="2">
            <HR> <a href="?lang=en">English</a> | <a href="?lang=hi">Hindi</a>
            <HR>
        </td>
    </tr>
</table>

<c:if test="${not empty sessionScope.user}">

    <c:if test="${sessionScope.user.roleId == 1}">
        <a href="<c:url value="/ctl/College" />">Add College</a>
|
<a href="<c:url value="/ctl/College/search" />"> College List </a>
|
<a href="<c:url value="/ctl/Student" />">Add Student</a>
|
<a href="<c:url value="/ctl/Student/search" />">Student List </a>
|
<a href="<c:url value="/ctl/Marksheet" />">Add Marksheet</a>
|
<a href="<c:url value="/ctl/Marksheet/search" />">Marksheet List </a>
|
<a href="<c:url value="/ctl/Marksheet/meritlist" />">GetMerit List </a>
|
<a href="<c:url value="/ctl/Marksheet/get" />">Get Marksheet </a>

    </c:if>

    <c:if test="${sessionScope.user.roleId == 2}">
        <a href="<c:url value="/ctl/Marksheet/get" />">Get Marksheet </a>
    </c:if>

    <c:if test="${sessionScope.user.roleId == 3}">

|
<a href="<c:url value="/ctl/Student" />">Add Student</a>
|
<a href="<c:url value="/ctl/Student/search" />">Student List </a>
|
<a href="<c:url value="/ctl/Marskheet/meritlist" />">GetMerit List </a>
|
<a href="<c:url value="/ctl/Marksheet/search" />">Marksheet List </a>

    </c:if>

</c:if>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>

<%@ page isELIgnored="false"%>

<h1>User List</h1>

<c:url var="editUrl" value="/ctl/User?id=" />

<sf:form action="search" commandName="form" method="post">

    <sf:hidden path="pageNo" />
    <sf:hidden path="pageSize" />

    <s:message code="label.firstName" />
    <sf:input path="firstName" />
    <input type="submit" value="Search" name="operation">

    <table border="1">
        <c:if test="${!empty list}">
            <tr>
                <th><input type="checkbox" /></th>
                <th>ID</th>
                <th><s:message code="label.firstName" /></th>
                <th><s:message code="label.lastName" /></th>
                <th><s:message code="label.login" /></th>
                <th><s:message code="label.dob" /></th>
                <th><s:message code="label.mobileNo" /></th>
                <th><s:message code="label.role" /></th>
                <th><s:message code="label.gender" /></th>
                <th>Edit</th>
            </tr>

            <c:forEach items="${list}" var="user" varStatus="ct">
                <tr>
                    <td><input type="checkbox" name="ids" value="${user.id}"></td>
                    <%-- <td><c:out
                            value="${(form.pageSize * (form.pageNo-1))+ct.index+1}" /></td> --%>
                    <td><c:out value="${user.id}" /></td>
                    <td><c:out value="${user.firstName}" /></td>
                    <td><c:out value="${user.lastName}" /></td>
                    <td><c:out value="${user.login}"></c:out></td>
                    <td><c:out value="${user.dob}" /></td>
                    <td><c:out value="${user.mobileNo}" /></td>
                    <td><c:out value="${user.roleId}" /></td>
                    <td><c:out value="${user.gender}"></c:out></td>
                    <td><a href="${editUrl}${user.id}">Edit</a></td>
                </tr>
            </c:forEach>

            <tr>
                <td align="left"><input type="submit" value="Previous"
                    name="operation"></td>

                <td align="center" colspan="8"><a
                    href="<c:url value="/ctl/User" />">New</a> <input type="submit"
                    value="Delete" name="operation">&nbsp;</td>

                <td align="right"><input type="submit" value="Next"
                    name="operation"></td>
            </tr>
        </c:if>

    </table>

</sf:form>

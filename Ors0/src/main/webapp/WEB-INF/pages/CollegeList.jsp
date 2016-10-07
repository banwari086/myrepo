<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>

<%@ page isELIgnored="false"%>





    

    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>

<%@ page isELIgnored="false"%>

<h1>College List</h1>

<h2 style="color: green">${success}</h2>

<sf:form action="search" commandName="form" method="post">

    <sf:hidden path="pageNo" />
    <sf:hidden path="pageSize" />

    Name: <sf:input path="name" />
    <input type="submit" value="Search" name="operation">

    <c:url var="editUrl" value="/ctl/College?id=" />

    <table border="1" width="100%">
        <c:if test="${!empty list}">
            <tr>
                <th><input type="checkbox" /></th>
                <th>ID</th>
                <th><s:message code="label.name" /></th>
                <th><s:message code="label.address" /></th>
                <th><s:message code="label.state" /></th>
                <th><s:message code="label.city" /></th>
                <th><s:message code="label.phoneNo" /></th>
                <th>Edit</th>
            </tr>

            <c:forEach items="${list}" var="college" varStatus="ct">
                <tr>
                    <td><input type="checkbox" name="ids" value="${college.id}"></td>
                    <td><c:out
                            value="${(form.pageSize * (form.pageNo-1))+ct.index+1}" /></td>
                    <td><c:out value="${college.name}" /></td>
                    <td><c:out value="${college.address}" /></td>
                    <td><c:out value="${college.state}" /></td>
                    <td><c:out value="${college.city}" /></td>
                    <td><c:out value="${college.phoneNo}"></c:out></td>
                    <td><a href="${editUrl}${college.id}">Edit</a></td>
                </tr>
            </c:forEach>
        </c:if>
        <tr>
            <td align="left"><input type="submit" value="Previous"
                name="operation"></td>

            <td align="center" colspan="6"><a
                href="<c:url value="/ctl/College" />">New</a> <input type="submit"
                value="Delete" name="operation">&nbsp;</td>

            <td align="right"><input type="submit" value="Next"
                name="operation"></td>
        </tr>
    </table>

</sf:form>



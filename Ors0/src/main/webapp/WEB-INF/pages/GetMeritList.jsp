<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>

<%@ page isELIgnored="false"%>

<h1>Merit List</h1>

<sf:form action="search" commandName="form" method="post">

    <table border="1" width="100%">

        <c:if test="${!empty list}">
            <tr>
                <th>No</th>
                <th><s:message code="label.student" /></th>
                <th><s:message code="label.rollNo" /></th>
                <th><s:message code="label.chemistry" /></th>
                <th><s:message code="label.physics" /></th>
                <th><s:message code="label.maths" /></th>
                <th><s:message code="label.total" /></th>
            </tr>

            <c:url var="editUrl" value="/Marksheet?id=" />

            <c:forEach items="${list}" var="marksheet" varStatus="ct">
                <tr>
                    <td><c:out
                            value="${(form.pageSize * (form.pageNo-1))+ct.index+1}" /></td>
                    <td><c:out value="${marksheet.name}" /> (
                        ${marksheet.studentId} )</td>
                    <td><c:out value="${marksheet.rollNo}" /></td>
                    <td><c:out value="${marksheet.chemistry}" /></td>
                    <td><c:out value="${marksheet.physics}" /></td>
                    <td><c:out value="${marksheet.maths}" /></td>
                    <td><c:out
                            value="${marksheet.maths  +marksheet.physics + marksheet.chemistry}" /></td>

                </tr>

            </c:forEach>

        </c:if>

    </table>

</sf:form>

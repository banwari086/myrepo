<%@page import="com.sunilos.proj0.dto.UserDTO"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>

<%@ page isELIgnored="false"%>

<h1>Marksheet List</h1>
<h2 class="success">${success}</h2>
<h2 class="error">${error}</h2>


<sf:form action="search" commandName="form" method="post">

    <sf:hidden path="pageNo" />
    <sf:hidden path="pageSize" />

    <s:message code="label.rollNo" />
    <sf:input path="rollNo" />&nbsp;
    <s:message code="label.student" />
    <sf:select path="studentId" STYLE="width: 160px">
        <sf:option value="" label="Select" />
        <sf:options items="${studentList}" itemValue="id" itemLabel="value" />
    </sf:select>

    <input type="submit" value="Search" name="operation">

    <table border="1" width="100%">

        <c:if test="${!empty list}">
            <tr>
                <th><input type="checkbox" /></th>
                <th>ID</th>
                <th><s:message code="label.student" /></th>
                <th><s:message code="label.rollNo" /></th>
                <th><s:message code="label.chemistry" /></th>
                <th><s:message code="label.physics" /></th>
                <th><s:message code="label.maths" /></th>
                <th>Edit</th>
            </tr>

            <c:url var="editUrl" value="/ctl/Marksheet?id=" />


            <c:forEach items="${list}" var="marksheet" varStatus="ct">
                <tr>
                    <td><input type="checkbox" name="ids" value="${marksheet.id}"></td>
                    <td><c:out
                            value="${(form.pageSize * (form.pageNo-1))+ct.index+1}" /></td>
                    <td><c:out value="${marksheet.name}" /> (
                        ${marksheet.studentId} )</td>
                    <td><c:out value="${marksheet.rollNo}" /></td>
                    <td><c:out value="${marksheet.chemistry}" /></td>
                    <td><c:out value="${marksheet.physics}" /></td>
                    <td><c:out value="${marksheet.maths}" /></td>
                    <td><c:out value="${marksheet.studentId}" /></td>
                    <td><a href="${editUrl}${marksheet.id}">Edit</a></td>
                </tr>

            </c:forEach>

            <tr>
                <td align="left"><input type="submit" value="Previous"
                    name="operation"></td>

                <td align="center" colspan="7"><a
                    href="<c:url value="/ctl/Marksheet" />">New</a> &nbsp; <input
                    type="submit" value="Delete" name="operation">&nbsp;</td>

                <td align="right"><input type="submit" value="Next"
                    name="operation"></td>
            </tr>
        </c:if>

    </table>

</sf:form>

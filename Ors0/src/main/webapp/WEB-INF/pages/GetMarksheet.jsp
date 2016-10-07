<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>

<%@ page isELIgnored="false"%>

<h1>Marksheet</h1>

<h2 class="success">${success}</h2>
<h2 class="error">${error}</h2>

<sf:form method="Get" commandName="form">

    <s:message code="label.rollNo" /> : 
    <sf:input path="rollNo" />
    <input type="submit" value="Go" name="operation" />
</sf:form>
<HR>

<c:if test="${ error == null }">
    <h1><c:out value="${form.name}" /></h1>

    <table border=1 >
        <tr>
            <td><s:message code="label.student" /></td>
            <td><c:out value="${form.name}" /> ( ${form.studentId} )</td>
        </tr>
        <tr>
            <td><s:message code="label.rollNo" /></td>
            <td><c:out value="${form.rollNo}" /></td>
        </tr>
        <tr>
            <td><s:message code="label.chemistry" /></td>
            <td><c:out value="${form.chemistry}" /></td>
        </tr>
        <tr>
        <tr>
            <td><s:message code="label.physics" /></td>
            <td><c:out value="${form.physics}" /></td>
        </tr>
        <tr>
        <tr>
            <td><s:message code="label.maths" /></td>
            <td><c:out value="${form.maths}" /></td>
        </tr>
        <tr>
        <tr>
            <td><s:message code="label.total" /></td>
            <td><c:out value="${form.maths  +form.physics + form.chemistry}" /></td>
        </tr>

    </table>
</c:if>
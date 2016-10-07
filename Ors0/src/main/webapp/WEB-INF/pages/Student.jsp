<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>

<%@ page isELIgnored="false"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<h1>Student Form</h1>
<h2 class="success">${success}</h2>
<h2 class="error">${error}</h2>

<sf:form method="POST" commandName="form">

    <table>
        <sf:hidden path="id" />
        <sf:hidden path="createdBy" />
        <sf:hidden path="modifiedBy" />
        <sf:hidden path="createdDatetime" />
        <sf:hidden path="modifiedDatetime" />


        <tr>
            <td><sf:label path="firstName">
                    <s:message code="label.firstName" />
                </sf:label></td>
            <td><sf:input path="firstName" /></td>
            <td><sf:errors path="firstName" cssClass="error" /></td>
        </tr>
        <tr>
            <td><sf:label path="lastName">
                    <s:message code="label.lastName" />
                </sf:label></td>
            <td><sf:input path="lastName" /></td>
            <td><sf:errors path="lastName" cssClass="error" /></td>
        </tr>
        <tr>
            <td><sf:label path="dob">
                    <s:message code="label.dob" />
                </sf:label></td>
            <td><sf:input path="dob" id="dob" /></td>
            <td><sf:errors path="dob" cssClass="error" /></td>
        </tr>
        <tr>
            <td><sf:label path="mobileNo">
                    <s:message code="label.mobileNo" />
                </sf:label></td>
            <td><sf:input path="mobileNo" /></td>
            <td><sf:errors path="mobileNo" cssClass="error" /></td>
        </tr>
        <tr>
            <td><sf:label path="email">
                    <s:message code="label.email" />
                </sf:label></td>
            <td><sf:input path="email" /></td>
            <td><sf:errors path="email" cssClass="error" /></td>
        </tr>
        <tr>
            <td><s:message code="label.collegeName" /></td>

            <td><sf:select STYLE="width: 150px" size="0" path="collegeId">
                    <sf:option value="" label="Select" />
                    <sf:options items="${collegeList}" itemValue="id" itemLabel="name" />

                </sf:select></td>

            <td><sf:errors path="collegeId" cssClass="error" /></td>
        </tr>

        <tr>
            <td colspan="3"><input type="submit" value="Save"
                name="operation">&nbsp; <c:if test="${form.id > 0}">
                    <input type="submit" value="Delete" name="operation" />&nbsp; 
                </c:if> <a href="<c:url value="/ctl/Student/search" />">List</a></td>
        </tr>
    </table>

</sf:form>

<script>
    $(function() {
        $("#dob").datepicker();
    });

    
</script>
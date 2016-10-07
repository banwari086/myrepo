<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>

<%@ page isELIgnored="false"%>

<h1>College</h1>

<h2 class="success">${success}</h2>
<h2 class="error">${error}</h2>

<sf:form action="College" method="POST" commandName="form">

    <sf:hidden path="id" />
    <sf:hidden path="createdBy" />
    <sf:hidden path="modifiedBy" />
    <sf:hidden path="createdDatetime" />
    <sf:hidden path="modifiedDatetime" />

    <table>

        <tr>
            <td><sf:label path="name">
                    <s:message code="label.name" />
                </sf:label></td>
            <td><sf:input path="name" /></td>
            <td><sf:errors path="name" cssClass="error" /></td>
        </tr>
        <tr>
            <td><sf:label path="address">
                    <s:message code="label.address" />
                </sf:label></td>
            <td><sf:input path="address" /></td>
            <td><sf:errors path="address" cssClass="error" /></td>
        </tr>
        <tr>
            <td><sf:label path="state">
                    <s:message code="label.state" />
                </sf:label></td>
            <td><sf:input path="state" /></td>
            <td><sf:errors path="state" cssClass="error" /></td>
        </tr>
        <tr>
            <td><sf:label path="city">
                    <s:message code="label.city" />
                </sf:label></td>
            <td><sf:input path="city" /></td>
            <td><sf:errors path="city" cssClass="error" /></td>
        </tr>
        <tr>
            <td><sf:label path="phoneNo">
                    <s:message code="label.phoneNo" />
                </sf:label></td>
            <td><sf:input path="phoneNo" /></td>
            <td><sf:errors path="phoneNo" cssClass="error" /></td>
        </tr>

        <tr>
            <td colspan="3"><input type="submit" value="Save"
                name="operation">&nbsp; <c:if test="${form.id > 0}">
                    <input type="submit" value="Delete" name="operation" />&nbsp; 
                </c:if>
                
                
                
            </td>
        </tr>
    </table>
</sf:form>

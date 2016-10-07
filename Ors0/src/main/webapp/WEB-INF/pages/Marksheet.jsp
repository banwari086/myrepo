<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>


<%@ page isELIgnored="false"%>

<h1>Marksheet</h1>

<h2 class="success">${success}</h2>
<h2 class="error">${error}</h2>

<sf:form  method="POST" commandName="form">

    <sf:hidden path="id" />
    <sf:hidden path="createdBy" />
    <sf:hidden path="modifiedBy" />
    <sf:hidden path="createdDatetime" />
    <sf:hidden path="modifiedDatetime" />

    <table>

        <tr>

            <td><s:message code="label.student" /></td>

            <td><sf:select path="studentId" STYLE="width: 160px">
                    <sf:option value="" label="Select" />
                    <sf:options items="${studentList}" itemValue="id" itemLabel="value" />
                </sf:select></td>
            <td><sf:errors path="studentId" cssClass="error" /></td>

        </tr>

        <tr>
            <td><s:message code="label.rollNo" /></td>
            <td><sf:input path="rollNo" /></td>
            <td><sf:errors path="rollNo" cssClass="error" /></td>
        </tr>
        <tr>
            <td><sf:label path="chemistry">
                    <s:message code="label.chemistry" />
                </sf:label></td>
            <td><sf:input path="chemistry" /></td>
            <td><sf:errors path="chemistry" cssClass="error" /></td>
        </tr>
        <tr>
            <td><sf:label path="physics">
                    <s:message code="label.physics" />
                </sf:label></td>
            <td><sf:input path="physics" /></td>
            <td><sf:errors path="physics" cssClass="error" /></td>
        </tr>
        <tr>
            <td><sf:label path="maths">
                    <s:message code="label.maths" />
                </sf:label></td>
            <td><sf:input path="maths" /></td>
            <td><sf:errors path="maths" cssClass="error" /></td>
        </tr>
        
            <tr>
            <td colspan="3"><input type="submit" value="Save"
                name="operation">&nbsp; <c:if test="${form.id > 0}">
                    <input type="submit" value="Delete" name="operation" />&nbsp; 
                </c:if>
                
                <a href="<c:url value="/ctl/Marksheet/search" />">List</a>
                
            </td>
        </tr>

    </table>
</sf:form>
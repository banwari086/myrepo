<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>

<%@ page isELIgnored="false"%>

<h1>My Profile</h1>
<h2 class="error">${error}</h2>
<h2 class="success">${success}</h2>

<sf:form method="POST" commandName="form">
    <table>
        <sf:hidden path="id" />
        <tr>
            <td><sf:label path="login">
                    <s:message code="label.login" />
                </sf:label></td>
            <td><sf:input path="login" disabled="true" /></td>
            <td><sf:errors path="login" cssClass="error" /></td>
        </tr>
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
            <td><sf:label path="gender">
                    <s:message code="label.gender" />
                </sf:label></td>
            <td><sf:radiobutton path="gender" value="Male" />Male <sf:radiobutton
                    path="gender" value="Female" />Female</td>
            <td><sf:errors path="gender" cssClass="error" /></td>
        </tr>
        <tr>
            <td colspan="3"><input type="submit" value="Save"
                name="operation"></td>
        </tr>
    </table>

</sf:form>

<script>
    $(function() {
        $("#dob").datepicker();
    });
</script>


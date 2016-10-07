<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>

<%@ page isELIgnored="false"%>

<h1>Change Password</h1>
<h2 class="error">${error}</h2>
<h2 class="success">${success}</h2>

<sf:form method="POST" commandName="form">
    <table>
        <tr>
            <td><sf:label path="oldPassword">
                    <s:message code="label.oldPassword" />
                </sf:label></td>
            <td><sf:password path="oldPassword" /></td>
            <td><sf:errors path="oldPassword" cssClass="error" /></td>
        </tr>
        <tr>
            <td><sf:label path="newPassword">
                    <s:message code="label.newPassword" />
                </sf:label></td>
            <td><sf:password path="newPassword" /></td>
            <td><sf:errors path="newPassword" cssClass="error" /></td>
        </tr>
        <tr>
            <td><sf:label path="confirmPassword">
                    <s:message code="label.confirmPassword" />
                </sf:label></td>
            <td><sf:password path="confirmPassword" /></td>
            <td><sf:errors path="confirmPassword" cssClass="error" /></td>
        </tr>
        <tr>
            <td colspan="3"><input type="submit" value="Go" name="operation"></td>
        </tr>

    </table>

</sf:form>

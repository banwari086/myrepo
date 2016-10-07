<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>

<%@ page isELIgnored="false"%>

<h1>Forget Password</h1>
<h2 class="error">${error}</h2>
<h2 class="success">${success}</h2>

<sf:form method="POST" commandName="form">
    <table>
        <tr>
            <td><sf:label path="login">
                    <s:message code="label.login" />
                </sf:label> <sf:input path="login" /> <input type="submit" value="Go"
                name="operation"> <sf:errors path="login" cssClass="error" /></td>
        </tr>
    </table>

</sf:form>

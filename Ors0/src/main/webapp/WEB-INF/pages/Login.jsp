<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>

<%@ page isELIgnored="false"%>


<h2 class="error">${error}</h2>
<div class=" col-sm-offset-4 col-sm-7">
	<h1 class="col-sm-offset-2 text-primary">Login</h1>
	<div class="col-sm-offset-2">
		<img  src="../../resources/img/log.png" alt="Brand" width="100"
			height="100">
	</div>
	<sf:form class="form-horizontal col-sm-6" action="Login" method="post"
		commandName="form">

		<div class="form-group ">

			<div>
				<s:message code="label.emailId" />
			</div>
			<div class="input-group">
				<span class="input-group-addon"><span
					class="glyphicon glyphicon-user"></span></span>
				<%-- <s:message code="label.emailId"  /> --%>

				<sf:input path="emailId" class="form-control" id="inputEmail3"
					placeholder="Login Id" />
			</div>
			<sf:errors path="emailId" cssClass="error"
				class="control-label text-danger" for="inputError1" />

		</div>


		<div class="form-group">
			<div>
				<s:message code="label.password" />
			</div>
			<div class="input-group">
				<span class="input-group-addon"><span
					class="glyphicon glyphicon-lock"></span></span>
				<%-- <s:message code="label.password" /> --%>

				<sf:password path="password" class="form-control"
					id="inputPassword3" placeholder="Password" />

			</div>
			<sf:errors path="password" cssClass="error"
				class="control-label text-danger" for="inputError1" />

		</div>

		<div class="form-group">
			<button type="submit" class="btn btn-primary btn-block"
				name="operation" value="SignIn">
				SignIn<span class="glyphicon glyphicon-log-in"></span>
			</button>

			<div class="checkbox">


				<span class="pull-right"><a class="text-danger"
					href='<c:url value="/ForgetPassword" />'>Forgot password?&nbsp;<span
						class="glyphicon glyphicon-forward"></span></a></span>
			</div>

			<span class="pull-right"><a class="primary"
				href='<c:url value="/SignUp"/>'> Create an account?&nbsp;<span
					class="glyphicon glyphicon-forward"></span></a></span>


		</div>

	</sf:form>
</div>

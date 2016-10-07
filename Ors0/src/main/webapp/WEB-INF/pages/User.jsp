<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page isELIgnored="false"%>
<div class="col-sm-offset-3">
<div class="col-sm-offset-2">
		<h1 class="text-primary">Add User</h1>
	</div>
	<br>
<div class="text-center pull-center">
<c:if test="${success!= null }">
	<div class="alert alert-success" role="alert">${success}</div>
	</c:if>
	<c:if test="${error!= null }">
	<div class="alert alert-danger" role="alert">${error}</div>
    </c:if>
</div>

<sf:form action="User" method="POST" commandName="form" class="form-horizontal">
   
        
      
            <div class="form-group">
              <sf:hidden path="id" />
        <sf:hidden path="lastLogin"></sf:hidden>
        <sf:hidden path="registeredIP"></sf:hidden>
        <sf:hidden path="createdBy"></sf:hidden>
        <sf:hidden path="modifiedBy"></sf:hidden>
        <sf:hidden path="createdDatetime"></sf:hidden>
        <sf:hidden path="modifiedDatetime"></sf:hidden>
            <sf:label path="firstName" class="col-sm-2 control-label" for="inputPassword3">
                    <s:message code="label.firstName"></s:message>
                </sf:label>
                <div class="col-sm-5">
            <sf:input  path="firstName" class="form-control" id="inputEmail3" />
           
        </div>
         <sf:errors path="firstName"  cssClass="error" class="control-label text-danger" for="inputError1"  />
        </div>
       
        <div class="form-group">
            <sf:label path="lastName" class="col-sm-2 control-label">
                    <s:message code="label.lastName"></s:message>
                </sf:label>
                <div class="col-sm-5">
            <sf:input  path="lastName" class="form-control" id="inputEmail3" />
           
        </div>
         <sf:errors path="lastName"  cssClass="error" class="control-label text-danger" for="inputError1"  />
        </div>
        
        <div class="form-group">
            <sf:label path="login" class="col-sm-2 control-label">
                    <s:message code="label.login"></s:message>
                </sf:label>
                <div class="col-sm-5">
            <sf:input  path="login" class="form-control" id="inputEmail3" />
           
        </div>
         <sf:errors path="login"  cssClass="error" class="control-label text-danger" for="inputError1"  />
        </div>

        <div class="form-group">
            <sf:label path="password" class="col-sm-2 control-label">
                    <s:message code="label.password"></s:message>
                </sf:label>
                <div class="col-sm-5">
            <sf:password  path="password" class="form-control" id="inputEmail3" />
           
        </div>
         <sf:errors path="password"  cssClass="error" class="control-label text-danger" for="inputError1"  />
        </div>

        <div class="form-group">
            <sf:label path="dob" class="col-sm-2 control-label">
                    <s:message code="label.dob"></s:message>
                </sf:label>
                <div class="col-sm-5">
            <sf:input  path="dob" class="form-control" id="dob" />
           
        </div>
         <sf:errors path="dob"  cssClass="error" class="control-label text-danger" for="inputError1"  />
        </div>

        <div class="form-group">
            <sf:label path="mobileNo" class="col-sm-2 control-label">
                    <s:message code="label.mobileNo"></s:message>
                </sf:label>
                <div class="col-sm-5">
            <sf:input  path="mobileNo" class="form-control" id="inputEmail3" />
           
        </div>
         <sf:errors path="mobileNo"  cssClass="error" class="control-label text-danger" for="inputError1"  />
        </div>

        <div class="form-group">
        <sf:label path="roleId" class="col-sm-2 control-label">
           <s:message code="label.role" />
           </sf:label>
             <div class="col-sm-5">
            <sf:select  path="roleId" class="form-control" id="inputEmail3">
                    <sf:option value="" label="Select" />
                    <sf:options items="${roleList}" itemValue="id" itemLabel="name" />
                </sf:select>
               </div>
            <sf:errors path="roleId" cssClass="error" class="control-label text-danger" for="inputError1" />
        </div>
        
        <div class="form-group">
            <sf:label path="gender" class="col-sm-2 control-label">
                    <s:message code="label.gender" />
                </sf:label>
                <div class="col-sm-5">
            <sf:radiobutton path="gender"  value="Male" />Male <sf:radiobutton
                    path="gender" value="Female" />Female
                    </div>
            <sf:errors path="gender" cssClass="error" class="control-label text-danger" for="inputError1" />
        </div>
        
        <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-primary" name="operation"
				value="Save">Save</button>
				
				<button type="submit" class="btn btn-primary" name="operation"
				value="Cancel">Cancel</button>
       </div>

   
   

</sf:form>
</div>

<script>
    $(function() {
        $("#dob").datepicker();
    });
</script>

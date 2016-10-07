<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>

<%@page isELIgnored="false"%>

<div class="text-center ">
		<h1 class="text-primary">
		   
		   <c:choose>
                <c:when test="${form.id > 0}">Edit Role
                    
                </c:when>
                <c:otherwise>
                   Add Role
                </c:otherwise>
            </c:choose>
            
		</h1>
	</div>
	
<div class="text-center pull-center">
<c:if test="${success!= null }">
	<div class="alert alert-success" role="alert">${success}</div>
	</c:if>
	<c:if test="${error!= null }">
	<div class="alert alert-danger" role="alert">${error}</div>
    </c:if>
</div>


  <div class="col-sm-offset-4">
<sf:form  action="Role" method="post" class="form-horizontal" commandName="form">

    
        <sf:hidden path="id" />
        <sf:hidden path="createdBy"></sf:hidden>
        <sf:hidden path="modifiedBy"></sf:hidden>
        <sf:hidden path="createdDatetime"></sf:hidden>
        <sf:hidden path="modifiedDatetime"></sf:hidden>
         
         
         
             <div class="form-group">
            <sf:label path="roleName" class="col-sm-2 control-label">
                    <s:message code="label.name"></s:message>
                </sf:label>
                <div class="col-sm-4">
            <sf:input  path="roleName" class="form-control" id="inputEmail3" />
           
        </div>
         <sf:errors path="roleName"  cssClass="error" class="control-label text-danger" for="inputError1"  />
        </div>
        
        
         <div class="form-group">
            <sf:label path="roleDescription"  for="inputPassword3" class="col-sm-2 control-label">
                    <s:message code="label.description"></s:message>
                </sf:label>
                <div class="col-sm-4">
            <sf:input path="roleDescription" class="form-control" id="inputEmail3" />
            
        </div>
        <sf:errors path="roleDescription" cssClass="error" class="control-label text-danger" for="inputError1" />
        </div>
            
            <div class="col-sm-offset-2 col-sm-10">
			<button type="submit" class="btn btn-primary" name="operation"
				value="Save">Save</button>
			<button type="submit" class="btn btn-primary" name="operation"
				value="Cancel">Cancel</button>

              <c:if test="${form.id > 0}">
			<button type="submit" class="btn btn-primary" name="operation"
				value="Delete">Delete</button>
			</c:if>

		</div>
        
            </sf:form>
            </div>
            
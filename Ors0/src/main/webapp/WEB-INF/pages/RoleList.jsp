<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>

<%@ page isELIgnored="false"%>
<script type="text/javascript">
	function checkAll(master) {
		var checked = master.checked;
		var col = document.getElementsByTagName("INPUT");
		for ( var i = 0; i < col.length; i++) {
			col[i].checked = checked;
		}
	}
</script>
<h2 class="container text-center text-primary">Role List</h2>

<div class="container  text-center">
    <c:if test="${success!= null }">
	<div class="alert alert-success" role="alert">${success}</div>
	</c:if>
	<c:if test="${error!= null }">
	<div class="alert alert-danger" role="alert">${error}</div>
	</c:if>
</div>



<c:url var="editUrl" value="/ctl/Role?id=" />

<sf:form class="form-inline container  text-center" action="search" commandName="form" method="post">

    <sf:hidden path="pageNo" />
    <sf:hidden path="pageSize" />
    
    <div class="form-group ">
    
   
   <sf:label path="roleName" for="inputPassword3" class="col-sm-2 control-label">
                    <s:message code="label.name"></s:message>
                </sf:label>
<sf:input path="roleName" class="form-control" id="inputEmail3" placeholder="Name"  />
		
	</div>
	

	<button type="submit" class="btn btn-primary" name="operation"
		value="Search">Search</button>
	<br>
	<br>	
    <%-- <s:message code="label.name" />
    <sf:input path="roleName" />

    <input type="submit" value="Search" name="operation"> --%>

    <table class="table table-striped table-bordered">

        <c:if test="${!empty list}">
            <tr>
                <th class="col-md-1"><input type="checkbox" onclick="checkAll(this)" /></th>
                <th class="col-md-1">ID</th>
                <th class="col-md-2"><s:message code="label.name" /></th>
                <th class="col-md-2"><s:message code="label.description" /></th>
                <th class="col-md-1">Edit</th>
            </tr>

            <c:forEach items="${list}" var="role" varStatus="ct">
                <tr>

                    <td><input type="checkbox" name="ids" value="${role.id}"></td>
                    <td><c:out
                            value="${(form.pageSize * (form.pageNo-1))+ct.index+1}" /></td>
                    <td><c:out value="${role.name}" /></td>
                    <td><c:out value="${role.description}" /></td>
                    <td><a href="${editUrl}${role.id}"><span
					class="glyphicon glyphicon-pencil"></span></a></td>
                </tr>
            </c:forEach>

           <!--  <tr>
                 <td align="left">
                <button type="submit" class="btn btn-primary pull-left"
		name="operation" value="Previous">Previous</button>
                </td> 
                 
		
                <td align="center" colspan="3">
                <button type="submit" class="btn btn-primary text-center "
		name="operation" value="/ctl/Role">New</button>
               
                    
                    
         <button type="submit" class="btn btn-primary text-center "
name="operation" value="Delete">Delete</button>
          </td>
          
          

                 <td align="right">
                <button type="submit"class="btn btn-primary pull-right"name="operation" value="Next">Next</button>
                </td> 
            </tr> -->
            
        </c:if>

    </table>
    <div class="btn-group" role="group">
  <c:forEach var="i" begin="1" end="${size}">
   <button type="submit" class="btn" name="pageNO" value="${i}">
    <span
     class="<c:out default="None" escapeXml="true" value="${form.pageNo==i?'text-danger':'text-primary'}"/>">${i}</span>
   </button>
  </c:forEach>
 </div>
    <%--  <nav>
  <ul class="pagination">
  
    <li class="disable">
      <a href="<c:url value="Previous" />" aria-label="Previous">
        <span aria-hidden="true">&laquo;</span>
      </a>
    </li>
   <li class="active"><a href="#">1 <span class="sr-only">(current)</span></a></li>
    <li><a href="#">2</a></li>
    <li><a href="#">3</a></li>
    <li><a href="#">4</a></li>
    <li><a href="#">5</a></li>
    <li>
      <a href="#" name="operation" aria-label="Next">
        <span aria-hidden="true">&raquo;</span>
      </a>
    </li>
  </ul>
</nav> --%>
</sf:form>

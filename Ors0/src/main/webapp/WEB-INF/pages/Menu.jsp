<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page isELIgnored="false"%>

<div class="span2 main-menu-span">
				<div class="well nav-collapse sidebar-nav">
					<ul class="nav nav-tabs nav-stacked main-menu">
					<li><a href="<c:url value="/Welcome" />"> Home </a></li>
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown" role="button" aria-haspopup="true"
							aria-expanded="false">Language<span class="caret"></span></a>
							<ul class="dropdown-menu">
								
						<li><a href="?lang=en">English</a>  <a href="?lang=hi">Hindi</a></li>
							</ul></li>
						
						
					</ul>
					
				</div><!--/.well -->
			</div>
<%-- <UL>
    <LI><a href="<c:url value="/Welcome" />"> Home </a></LI>
   <li> <a href="?lang=en">English</a> | <a href="?lang=hi">Hindi</a></li>
</UL> --%>


<c:if test="${sessionScope.user != null }">

   <div class="span2 main-menu-span">
				<div class="well nav-collapse sidebar-nav">
					<ul class="nav nav-tabs nav-stacked main-menu">
						
						<li><a href="<c:url value="/ctl/User/profile" />">My Profile</a></li>
						<li><a href="<c:url value="/ctl/User/changepassword" />">Change
                Password</a></li>
						
					</ul>
					
				</div><!--/.well -->
			</div>
   
   
</c:if>

<%-- <c:if test="${sessionScope.user.roleId == 1}">
<div class="span2 main-menu-span">
				<div class="well nav-collapse sidebar-nav">
					<ul class="nav nav-tabs nav-stacked main-menu">
						<li><a  href="<c:url value="/ctl/User/search" />">User List </a></li>
						<li><a href="<c:url value="/ctl/Role" />">Role</a></li>
        <li><a href="<c:url value="/ctl/Role/search" />">Role List</a></li>
						
						
					</ul>
					
				</div><!--/.well -->
			</div>
    

</c:if> --%>
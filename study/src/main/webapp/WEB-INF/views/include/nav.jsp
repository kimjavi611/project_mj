<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
<head>

</head>
<body>
	<nav class="navbar navbar-expand-md bg-dark navbar-dark">
  <!-- Brand -->
  <a class="navbar-brand" href="#">Navbar</a>

  <!-- Toggler/collapsibe Button -->
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
    <span class="navbar-toggler-icon"></span>
  </button>

	<c:if test="${user == null}">
		  <!-- Navbar links -->
		<div class="collapse navbar-collapse" id="collapsibleNavbar">
		 	<ul class="navbar-nav">
				<li class="nav-item">
				 	<a class="nav-link" href="<%=request.getContextPath()%>/member/signup">회원가입</a>
				</li>
				<li class="nav-item">
				 	<a class="nav-link" href="<%=request.getContextPath()%>/member/signin">로그인</a>
				</li>
			</ul>
			    
		</div>
	</c:if>
</nav>

</body>
</html>

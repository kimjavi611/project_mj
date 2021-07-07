<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>����������</title>
	
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>

<form class="container" method="post" action="<%=request.getContextPath()%>/signup">
	<h1>����������</h1>
	<div class="form-group">
	  <label for="usr">���̵�:</label>
	  <input type="text" class="form-control" name="id" value="${user.id}" readonly>
	</div>
	<div class="form-group">
	  <label for="pwd">��й�ȣ:</label>
	  <input type="password" class="form-control" name="pw">
	</div>
	<div class="form-group">
	  <label for="pwd">��й�ȣ Ȯ��:</label>
	  <input type="password" class="form-control" name="pw2">
	</div>
	<div class="form-group">
	  <label for="gender">����:</label>
	  <select class="form-control" name="gender">
	  <option value="M" <c:if test="${user.gender=='M'}">selected</c:if> >����</option>
	  <option value="W" <c:if test="${user.gender=='W'}">selected</c:if> >����</option>
	  </select>
	 </div>
	<div class="form-group">
		<label for="email">�̸���:</label>
	 	<input type="text" class="form-control" name="email"value="${user.email}">
	</div>	
	<div class="form-group">
	  <label for="usr">�̸�:</label>
	  <input type="text" class="form-control" name="name"value="${user.name}" readonly>
	</div>
	<div class="form-group">
		<button class = "btn btn-outline-success col-12">����</button>
	</div>
</form>
</body>
</html>
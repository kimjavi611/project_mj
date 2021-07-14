<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>회원 가입</title>
	

</head>

<form class="container" method="post" action="<%=request.getContextPath()%>/signup">
	<div class="form-group">
	  <label for="usr">아이디:</label>
	  <input type="text" class="form-control" name="id">
	</div>
	<div class="form-group">
	  <label for="pwd">비밀번호:</label>
	  <input type="password" class="form-control" name="pw">
	</div>
	<div class="form-group">
	  <label for="pwd">비밀번호 확인:</label>
	  <input type="password" class="form-control" name="pw2">
	</div>
	<div class="form-group">
	  <label for="gneder">성별:</label>
	  <select class="form-control" name="gender" >
	  <option value="M">남성</option>
	  <option value="W">여성</option>
	  </select>
	 </div>
	<div class="form-group">
		<label for="email">이메일:</label>
	 	<input type="text" class="form-control" name="email">
	</div>	
	<div class="form-group">
	  <label for="usr">이름:</label>
	  <input type="text" class="form-control" name="name">
	</div>
	<div class="form-group">
		<button class = "btn btn outline-success col-12">회원가입</button>
	</div>
</form>
</body>
</html>
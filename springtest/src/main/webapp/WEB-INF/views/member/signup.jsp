<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>ȸ�� ����</title>
	

</head>

<form class="container" method="post" action="<%=request.getContextPath()%>/signup">
	<div class="form-group">
	  <label for="usr">���̵�:</label>
	  <input type="text" class="form-control" name="id">
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
	  <label for="gneder">����:</label>
	  <select class="form-control" name="gender" >
	  <option value="M">����</option>
	  <option value="W">����</option>
	  </select>
	 </div>
	<div class="form-group">
		<label for="email">�̸���:</label>
	 	<input type="text" class="form-control" name="email">
	</div>	
	<div class="form-group">
	  <label for="usr">�̸�:</label>
	  <input type="text" class="form-control" name="name">
	</div>
	<div class="form-group">
		<button class = "btn btn outline-success col-12">ȸ������</button>
	</div>
</form>
</body>
</html>
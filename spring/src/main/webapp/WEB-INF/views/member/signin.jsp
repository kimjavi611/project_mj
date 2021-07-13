<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>회원 가입</title>
	
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>

<form class="container" method="post" action="<%=request.getContextPath()%>/signin">
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
		<button class = "btn btn outline-success col-12">로그인</button>
	</div>
</form>
<script type="text/javascript">
	$(function(){
		$('form').submit(function(){
			var id = $('[name=id]').val();
			var pw = $('[name=pw]').val();
			var pw2 = $('[name=pw2]').val();
			var name = $('[name=name]').val();
			var email = $('[name=email]').val();
			if(id.trim() == ''){
				//trim() 문자열 앞뒤의 모든 공백을 지워줌 
				alert('아이디를 입력하세요.');
				return false;
			}
			if(pw.trim()==''){
				alert('비밀번호를 입력하세요.');
				return false;
			}
			if(pw != pw2){
				alret('비밀번호가 일치하지 않습니다.');
				return false;
			}
			if(name.trim() == ''){
				alret('이름을 입력하세요.');
				return false;
			}
			if(email.trim() == ''){
				alret('이메일을 입력하세요.');
				return false;
			}
		})
	})
</script>
</body>
</html>
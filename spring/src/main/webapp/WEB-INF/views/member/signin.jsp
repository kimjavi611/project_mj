<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>ȸ�� ����</title>
	
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>

<form class="container" method="post" action="<%=request.getContextPath()%>/signin">
	<div class="form-group">
	  <label for="usr">���̵�:</label>
	  <input type="text" class="form-control" name="id">
	</div>
	<div class="form-group">
	  <label for="pwd">��й�ȣ:</label>
	  <input type="password" class="form-control" name="pw">
	</div>
	<div class="form-group">
		<button class = "btn btn-outline-success col-12">�α���</button>
	</div>
	<label class="form-group">
		<input type="checkbox" name="useCookie" value="true">�ڵ� �α���
	</label>
	<div>
		<a href="<%=request.getContextPath()%>/find/pw">��й�ȣ ã��</a>
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
				//trim() ���ڿ� �յ��� ��� ������ ������ 
				alert('���̵� �Է��ϼ���.');
				return false;
			}
			if(pw.trim()==''){
				alert('��й�ȣ�� �Է��ϼ���.');
				return false;
			}
			if(pw != pw2){
				alret('��й�ȣ�� ��ġ���� �ʽ��ϴ�.');
				return false;
			}
			if(name.trim() == ''){
				alret('�̸��� �Է��ϼ���.');
				return false;
			}
			if(email.trim() == ''){
				alret('�̸����� �Է��ϼ���.');
				return false;
			}
		})
	})
</script>
</body>
</html>
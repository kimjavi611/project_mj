<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">

	
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>


	<div class="form-group">
	  <label for="usr">���̵�:</label>
	  <input type="text" class="form-control" name="id" placeholder="���̵� �Է��ϼ���">
	</div>

		<button class = "findPw-btn btn btn-outline-success col-12">��й�ȣ ã��</button>
		<div class="wait-box"></div>
	
<script type="text/javascript">
	$(function(){
		$('.findPw-btn').click(function(){
			var id = $('[name=id]').val();
			$('.wait-box').text('�������Դϴ�. �˸�â�� ��Ÿ�������� ��ٷ��ּ���.')
			$.ajax({
				type : "get",
				url : '<%=request.getContextPath()%>/find/pw/' + id,
				success : function(res){
					$('.wait-box').text('');
					if(res == 'SUCCESS'){
						alert('�� ��й�ȣ�� ���Ϸ� ���۵ƽ��ϴ�.')
					}else{
						alert('���Ե��� ���� ���̵��Դϴ�.')
					}
				}
			})	
		})	
	})
		
		
</script>
</body>
</html>
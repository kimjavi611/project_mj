<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>ȸ�� ����</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery.validate.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/additional-methods.js"></script>

<style>
	.error{color: red}
</style>
</head>

<form class="container" method="post" action="<%=request.getContextPath()%>/signup" id="signup">
	<div class="form-group">
	  <label for="usr">���̵�:</label>	
		  <input type="text" class="form-control" name="id">
	</div>
	<button type="button" id="dupCheck" class="col-12 btn btn-outline-success">���̵� �ߺ� Ȯ��</button>

	<div class="form-group">
	  <label for="pwd">��й�ȣ:</label>
	  <input type="password" class="form-control" name="pw" id="pw">
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
		<button class = "btn btn-outline-success col-12">ȸ������</button>
	</div>
</form>
<script type="text/javascript">
	$(function(){
		$('#dupCheck').click(function(){
			var id = $('[name=id]').val();
			$.ajax({
				type: 'get', 
				url : '<%=request.getContextPath()%>/member/idcheck/' + id, 
				success : function(result, status, xhr){  //��Ʈ�ѷ����� ������ ������ �� ����� ���� //url�� ���� ���ϴ� ������ ����
					if(result == 'posible')
						alert('��� ������ ���̵��Դϴ�.')
					else
						alert('��� �Ұ����� ���̵��Դϴ�.')
				},
				error : function(xhr, status, e){
					
				}
			})
		})
		
	    $("#signup").validate({
	        rules: { //��Ģ
	        	//input�� name�� ��ġ 
	            id: {
	                required : true, //�ʼ� �׸�
	                regex: /^[0-9a-z_-]{5,20}$/
	            },
	            pw: {
	                required : true,
	                minlength : 8,
	                regex: /^[0-9a-zA-Z@#$]{8,16}$/
	            },
	            pw2: {
	                required : true,
	                equalTo : pw //id��
	            },
	            name: {
	                required : true,
	                minlength : 2
	            },
	            
	            email: {
	                required : true,
	                email : true //email���Ŀ� �´��� Ȯ�� 
	            },
	            gneder: {
	                required : true
	            }
	        },
	        //��Ģüũ ���н� ��µ� �޽���
	        messages : {
	            id: {
	                required : "�ʼ������Դϴ�.",
	                minlength : "5~20���� ���� �ҹ���, ���ڿ� Ư����ȣ(_),(-)�� ��� �����մϴ�."
	               
	            },
	            pw: {
	                required : "�ʼ������Դϴ�.",
	                regex : "8~16�� ���� �� �ҹ���, ����, Ư�����ڸ� ����ϼ���."
	            },
	            pw2: {
	                required : "�ʼ������Դϴ�.",
	                equalTo : "��й�ȣ�� ��ġ���� �ʽ��ϴ�."
	            },
	            name: {
	                required : "�ʼ������Դϴ�.",
	                minlength : "�ּ� {0}�����̻��̾�� �մϴ�"
	            },
	            email: {
	                required : "�ʼ����Է��ϼ���",
	                email : "���ϱ�Ģ�� ��߳��ϴ�"
	            },
	            gender: {
	                required : "�ʼ������Դϴ�."
	            }
	        }
	    });
	})
	$.validator.addMethod(
	    "regex",
	    function(value, element, regexp) {
	        var re = new RegExp(regexp);
	        return this.optional(element) || re.test(value);
	    },
	    "Please check your input."
	);
</script>
</body>
</html>
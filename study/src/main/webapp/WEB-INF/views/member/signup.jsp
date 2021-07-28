<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>ȸ�� ����</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery.validate.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/additional-methods.min.js"></script>
<style type="text/css">
	.error{
		color : red
	}
</style>
<style>
	
</style>
</head>

<form class="container" method="post" action="<%=request.getContextPath()%>/member/signup">
	<div class="form-group">
	  <label for="usr">���̵�:</label>	
		  <input type="text" class="form-control" name="id">
	</div>
	<button type="button"  class="id-dup-btn col-12 btn btn-outline-success">���̵� �ߺ� Ȯ��</button>

	<div class="form-group">
	  <label for="pwd">��й�ȣ:</label>
	  <input type="password" class="form-control" name="pw" id="pw">
	</div>
	<div class="form-group">
	  <label for="pwd">��й�ȣ Ȯ��:</label>
	  <input type="password" class="form-control" name="pw2" id="pw">
	</div>
	
	<div class="form-group">
	  <label for="usr">�̸�:</label>
	  <input type="text" class="form-control" name="name">
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
		<button class = "btn btn-outline-success col-12">ȸ������</button>
	</div>
</form>
<script type="text/javascript">
$(function(){
    $("form").validate({
        rules: {
            //name�̶� ��ġ ���Ѿ���
            id: {
                required : true,
                regex : /^[a-z0-9_-]{5,20}$/
            },
            pw: {
                required : true,
                regex: /^[a-z0-9!@#]{8,16}$/i
            },
            pw2: {
                required : true,
                //equalTo : id�� ��ġ
                equalTo : pw
            },
            name: {
                required : true
            },
            gender: {
                required : true
            },
            email: {
                required : true,
                email : true
            }
        },
        //��Ģüũ ���н� ��µ� �޽���
        messages : {
            id: {
                required : "�ʼ� �����Դϴ�",
                regex : "5~20���� ���� �ҹ���, ���ڿ� Ư����ȣ(_),(-)�� ��� �����մϴ�."
            },
            pw: {
                required : "�ʼ� �����Դϴ�.",
                regex : "8~16�� ���� �� �ҹ���, ����, Ư�����ڸ� ����ϼ���."
            },
            pw2: {
                required : "�ʼ� �����Դϴ�.",
                equalTo : "��й�ȣ�� ��ġ���� �ʽ��ϴ�."
            },
            name: {
                required : "�ʼ� �����Դϴ�.",
            },
            gender: {
            	required : "�ʼ� �����Դϴ�."
            },
            email: {
                required : "�ʼ� �����Դϴ�.",
                email : "���ϱ�Ģ�� ��߳��ϴ�"
            }
        }
    });
    $('.id-dup-btn').click(function(){
		var id = $('[name=id]').val();
		var res = memberService.idCheck(contextPath, id);
		if(res)
			alert('��밡���� ���̵��Դϴ�.')
		else
			alert('�̹� ���Ե� ���̵��Դϴ�.')	
    })
})
$.validator.addMethod(
    "regex",
    function(value, element, regexp) {
        var re = new RegExp(regexp);
        return this.optional(element) || re.test(value);
    },
    "Please check your input."
);
var contextPath = '<%=request.getContextPath()%>';
var memberService = (function(){
	function idCheck(contextPath, id){
		var flag = false;
		$.ajax({
			async : false,
			type : 'post',
			url : contextPath + '/id/check',
			data : {id : id},
			success : function(res){
				if(res == 'OK'){
					flag = true;
				}else{
					flag = false;
				}
			}
		})
		return flag;
	}
	return {
		name : 'memberService',
		idCheck : idCheck
	} 
})();
</script>
</body>
</html>
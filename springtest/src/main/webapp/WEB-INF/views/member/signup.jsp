<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>회원 가입</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery.validate.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/additional-methods.js"></script>

<style>
	.error{color: red}
</style>
</head>

<form class="container" method="post" action="<%=request.getContextPath()%>/signup" id="signup">
	<div class="form-group">
	  <label for="usr">아이디:</label>	
		  <input type="text" class="form-control" name="id">
	</div>
	<button type="button" id="dupCheck" class="col-12 btn btn-outline-success">아이디 중복 확인</button>

	<div class="form-group">
	  <label for="pwd">비밀번호:</label>
	  <input type="password" class="form-control" name="pw" id="pw">
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
		<button class = "btn btn-outline-success col-12">회원가입</button>
	</div>
</form>
<script type="text/javascript">
	$(function(){
		$('#dupCheck').click(function(){
			var id = $('[name=id]').val();
			$.ajax({
				type: 'get', 
				url : '<%=request.getContextPath()%>/member/idcheck/' + id, 
				success : function(result, status, xhr){  //컨트롤러에서 실행이 끝나면 이 기능을 수행 //url에 내가 원하는 정보를 넣음
					if(result == 'posible')
						alert('사용 가능한 아이디입니다.')
					else
						alert('사용 불가능한 아이디입니다.')
				},
				error : function(xhr, status, e){
					
				}
			})
		})
		
	    $("#signup").validate({
	        rules: { //규칙
	        	//input의 name과 일치 
	            id: {
	                required : true, //필수 항목
	                regex: /^[0-9a-z_-]{5,20}$/
	            },
	            pw: {
	                required : true,
	                minlength : 8,
	                regex: /^[0-9a-zA-Z@#$]{8,16}$/
	            },
	            pw2: {
	                required : true,
	                equalTo : pw //id값
	            },
	            name: {
	                required : true,
	                minlength : 2
	            },
	            
	            email: {
	                required : true,
	                email : true //email형식에 맞는지 확인 
	            },
	            gneder: {
	                required : true
	            }
	        },
	        //규칙체크 실패시 출력될 메시지
	        messages : {
	            id: {
	                required : "필수정보입니다.",
	                minlength : "5~20자의 영문 소문자, 숫자와 특수기호(_),(-)만 사용 가능합니다."
	               
	            },
	            pw: {
	                required : "필수정보입니다.",
	                regex : "8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요."
	            },
	            pw2: {
	                required : "필수정보입니다.",
	                equalTo : "비밀번호가 일치하지 않습니다."
	            },
	            name: {
	                required : "필수정보입니다.",
	                minlength : "최소 {0}글자이상이어야 합니다"
	            },
	            email: {
	                required : "필수로입력하세요",
	                email : "메일규칙에 어긋납니다"
	            },
	            gender: {
	                required : "필수정보입니다."
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
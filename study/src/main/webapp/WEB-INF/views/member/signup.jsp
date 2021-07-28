<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>회원 가입</title>
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
	  <label for="usr">아이디:</label>	
		  <input type="text" class="form-control" name="id">
	</div>
	<button type="button"  class="id-dup-btn col-12 btn btn-outline-success">아이디 중복 확인</button>

	<div class="form-group">
	  <label for="pwd">비밀번호:</label>
	  <input type="password" class="form-control" name="pw" id="pw">
	</div>
	<div class="form-group">
	  <label for="pwd">비밀번호 확인:</label>
	  <input type="password" class="form-control" name="pw2" id="pw">
	</div>
	
	<div class="form-group">
	  <label for="usr">이름:</label>
	  <input type="text" class="form-control" name="name">
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
		<button class = "btn btn-outline-success col-12">회원가입</button>
	</div>
</form>
<script type="text/javascript">
$(function(){
    $("form").validate({
        rules: {
            //name이랑 일치 시켜야함
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
                //equalTo : id랑 일치
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
        //규칙체크 실패시 출력될 메시지
        messages : {
            id: {
                required : "필수 정보입니다",
                regex : "5~20자의 영문 소문자, 숫자와 특수기호(_),(-)만 사용 가능합니다."
            },
            pw: {
                required : "필수 정보입니다.",
                regex : "8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요."
            },
            pw2: {
                required : "필수 정보입니다.",
                equalTo : "비밀번호가 일치하지 않습니다."
            },
            name: {
                required : "필수 정보입니다.",
            },
            gender: {
            	required : "필수 정보입니다."
            },
            email: {
                required : "필수 정보입니다.",
                email : "메일규칙에 어긋납니다"
            }
        }
    });
    $('.id-dup-btn').click(function(){
		var id = $('[name=id]').val();
		var res = memberService.idCheck(contextPath, id);
		if(res)
			alert('사용가능한 아이디입니다.')
		else
			alert('이미 가입된 아이디입니다.')	
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
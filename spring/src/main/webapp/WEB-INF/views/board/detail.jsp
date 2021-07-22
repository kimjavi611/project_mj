<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>게시판 목록</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="https://kit.fontawesome.com/660af269cf.js" crossorigin="anonymous"></script>

<style type="text/css">
	.recommend-btn{font-size: 30px}
	.fa-thumbs-down{transform : rotateY(180deg)}
</style>

</head>
<body>
<div class="container">
  <h1>게시판</h1>
  <div class="form-group">
  	<label>제목</label>
  	<input type="text" class="form-control" name="title" value="<c:out value="${board.title}"/>"readonly>
  </div>
  <div class="form-group">
  	<label>작성자</label>
  	<input type="text" class="form-control" name="title" value="${board.writer}">
  </div>
  <div class="form-group">
  	<label>작성일</label>
  	<input type="text" class="form-control" name="title" value="${board.dateTime}">
  </div>
  <div class="form-group">
  	<label>조회수</label>
  	<input type="text" class="form-control" name="title" value="${board.views}">
  </div>
  <div class="form-group">
  	<label>내용</label>
  	<div class="form-control" style="min-height: 300px">${board.contents}</div>
  </div>
  
  <div class="form=group mb-3">
  	<a href="#" class="recommend-btn up">
  		<c:choose> 
		  	<c:when test="${recommend != null && recommend.state == 1 }">
		  		<i class="fas fa-thumbs-up"></i>
		  	</c:when> 
		  	<c:otherwise>
		  		<i class="far fa-thumbs-up"></i>
		  	</c:otherwise>
	  	</c:choose>
  	</a>
  	<a href="#" class="recommend-btn down">
  		<c:choose> 
		  	<c:when test="${recommend != null && recommend.state == -1 }">
		  		<i class="fas fa-thumbs-down"></i>
		  	</c:when> 
		  	<c:otherwise>
		  		<i class="far fa-thumbs-down"></i>
		  	</c:otherwise>
	  </c:choose>
  	</a>
  </div>
  
  <div class="form-group">
	<label for="comment">작성자</label>
	<textarea class="form-control" rows="2" id="comment"></textarea>
	<button type="button" class="btn btn-info mt-1">등록</button>
  </div>
	
	
  <div class="form-group">
		<label>첨부파일</label>
		<c:forEach items="${fileList}" var="file">
			<a class="form-control" href="<%=request.getContextPath()%>/board/download?fileName=${file.name}">${file.ori_name}</a>
		</c:forEach>
		<input type="file" class="form-control" name="files"/>
	</div>
	
 	

  <div class="input-group"> <!-- 부트스트랩에서 제공하는 클래스 -->
	<a href="<%=request.getContextPath()%>/board/list"><button class="btn btn-primary mr-2">목록</button></a>
 	 <c:if test="${board != null && user.id eq board.writer}"> <!-- eq == -->
 	 <a href="<%=request.getContextPath() %>/board/modify?num=${board.num}"><button class="btn btn-success mr-2">수정</button></a>
	 	<form action="<%=request.getContextPath()%>/board/delete" method="Post" class="mr-2">
	 		<input type="hidden" value="${board.num}" name="num"> <!-- 게시글 번호를 인풋하고 숨겨놓음 -->
	 		<button class="btn btn-success">삭제</button> <!-- POST로 할거기 때문에 form태그안에 넣어줘야함 -->
		</form>
	</c:if>
  </div>
  <script type="text/javascript">
  	$(function(){
  		var msg = '${msg}';
  		printMsg(msg);
  		history.replaceState({},null,null); //삭제 후 목록에서 뒤로가기 버튼을 누르면 삭제 될때 뜬 알림창이 뜨게된다
  		//뒤로가기는 그 전 실행주소를 불러오기 때문 =>history.replaceState로 실행된걸 비워주면 뒤로가기 버튼을 눌러도 알림이 안뜬다
  		$('.recommend-btn').click(function(e){
  			 e.preventDefault();
  			 var board = ${board.num};
  			 var state = $(this).hasClass('up') ? 1 : -1;
  			$.ajax({
		        type:'get',
		        url:'<%=request.getContextPath()%>/board/recommend/'+ board + '/'+state,
		        
		        success : function(result, status, xhr){
		        	$('.recommend-btn i').removeClass('fas').addClass('far');
		            if(result == 'UP'){
		            	alert('해당 게시글을 추천했습니다.')
		            	$('.recommend-btn.up i').addClass('fas');
		            }else if(result == 'DOWN'){
		            	alert('해당 게시글을 비추천했습니다.')
		            	$('.recommend-btn.down i').addClass('fas');
		            }else if(result == 'GUEST'){
		            	alert('추천/비추천 하려면 로그인 하세요.')
		            }else if(result == 'CANCEL'){
		            	if(state == 1){
							alert('추천을 취소했습니다.')
						}else{
							alert('비추천을 취소했습니다.');
						}
		            }
		        },
		        error : function(xhr, status, e){
		        	console.log('에러 발생')
		        }
		    });
  			 
  		})
  	})
  	function printMsg(msg){
  		if(msg == ''|history.State){
  			return ;
  		}
  		alert(msg);
  	}
  </script>	
</div>

</body>
</html>
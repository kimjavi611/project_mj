<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>게시판 목록</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
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
  	<textarea class="form-control" name="contents" rows="10">"${board.contents}"</textarea>
  </div>
  <div class="form-group">
		<label>첨부파일</label>
		<c:forEach items="${fileList}" var="file">
			<a class="form-control" href="#">${file.ori_name}</a>
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
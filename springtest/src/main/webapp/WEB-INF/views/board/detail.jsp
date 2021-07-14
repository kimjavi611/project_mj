<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!doctype html>
<html>
<head>
	<title>로그인</title>

</head>
<body>
<c:if test="${board != null}"> 
	<div class="container">
	  <h2>게시판</h2>           
	 	<div class="form-group">
		  <label for="usr">제목</label>
		  <input type="text" class="form-control" value="${board.title }" readonly>
		</div>
		<div class="form-group">
		  <label for="usr">작성자</label>
		  <input type="text" class="form-control"value="${board.writer}"readonly>
		</div>
		<div class="form-group">
		  <label for="usr">작성일</label>
		  <input type="text" class="form-control"value="${board.registeredDate}"readonly>
		  
		</div>
		<div class="form-group">
		  <label for="usr">조회수</label>
		  <input type="text" class="form-control"value="${board.views}"readonly>
		</div>
		<div class="form-group">
		  <label for="usr">내용</label>
		  <textarea class="form-control readonly"> ${board.contents} </textarea>
		</div>
		<a href="<%=request.getContextPath() %>/board/modify?num=${board.num}"><button class="btn btn-outline-success">수정</button></a>
		<a href="<%=request.getContextPath() %>/board/delete?num=${board.num}"><button class="btn btn-outline-success">삭제</button></a>
		<a href="<%=request.getContextPath() %>/board/list"><button class="btn btn-outline-success">목록</button></a>
	</div>
</c:if>
<c:if test="${board == null}">
	<div class="container">
		<h1>삭제되거나 존재하지 않는 게시물입니다</h1>
		<a href="<%=request.getContextPath() %>/board/list"><button class="btn btn-outline-success">목록</button></a>
	</div>	
</c:if>
</body>
</html>
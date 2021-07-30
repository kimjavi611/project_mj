<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!doctype html>
<html>
<head>
	<title>로그인</title>
	
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/reply.js"></script>
</head>
<body>
<c:if test="${board != null}"> 
	<div class="container">
	  <h2>게시판</h2>           
	 	<div class="form-group">
		  <label for="usr">제목</label>
		  <input type="text" class="form-control" name="title" value="${board.title}" readonly>
		</div>
		<div class="form-group">
		  <label for="usr">작성자</label>
		  <input type="text" class="form-control" name="writer" value="${board.writer}"readonly>
		</div>
		<div class="form-group">
		  <label for="usr">작성일</label>
		  <input type="text" class="form-control" name="registered" value="${board.dateTime}"readonly>
		  
		</div>
		<div class="form-group">
		  <label for="usr">조회수</label>
		  <input type="text" class="form-control" name="views" value="${board.views}"readonly>
		</div>
		
		<div class="form-group">
		  <label for="usr">내용</label>
		  <div class="form-control readonly" style="height : auto"> ${board.contents} </div>
		</div>
		<div class="reply form-group">
			<label>댓글</label>
			<div class="contents">
				<div class="reply-list form-group"></div>
				<ul class="pagination"></ul>
				<div class="reply-box form-group">
				<textarea class="reply-input form-control"></textarea>
				<button type="button" class="reply-btn btn btn-outline-success">등록</button>
				</div>
			</div>
		</div>
		<c:if test="${board.groupOrd == 0 && (user != null && user.authority != 'USER')}">
			<a href="<%=request.getContextPath()%>/board/reply/register?oriNo=${board.num}">
				<button class="btn btn-outline-info">답변</button>
			</a>
		</c:if>
</div>
</c:if>
</body>
</html>
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
  	<input type="text" class="form-control" name="title" value="${board.title}">
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
	<a href="<%=request.getContextPath()%>/board/list"><button class="btn btn-ouline-primary">목록</button></a>
</div>

</body>
</html>
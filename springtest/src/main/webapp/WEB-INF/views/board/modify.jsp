<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!doctype html>
<html>
<head>
	<title>게시글 등록</title>
	<style>
		.del-btn{float: right; width: 20px; height: 20px; text-aline:center; line-height: 20px}
	</style>
	
</head>
<body>




<form class="container" method="post" action="<%=request.getContextPath()%>/board/modify" enctype="multipart/form-data">
  <h2>게시글 수정</h2>           
 	<div class="form-group">
	  <label for="usr">제목</label>
	  <input type="text" class="form-control" name="title" value="${board.title}">
	</div>
	<div class="form-group">
	  <label for="usr">작성자</label>
	  <input type="text" class="form-control" name="writer"value="${board.writer}"readonly>
	</div>
	<div class="form-group">
	  <label for="usr">내용</label>
	  <textarea class="form-control" rows="10" name="contents"> ${board.contents} </textarea>
	</div>
	
	<c:if test ="${file != null}">
		<div class="form-groups file-box">
		  <label for="usr">첨부파일</label>
		  <div class="form-control">${file.ori_name}<button type="button" class="del-btn">X</button></div>
	 </div>
	</c:if>
	
	<c:if test ="${file == null}">
		<div class="form-group ">
		  <label for="usr">첨부파일</label>
		  <input type="file" class="form-control" name="file">
	 </div>
	</c:if>
	<input type="hidden" value="${board.num}" name="num">
	<input type="hidden" value="${board.views}" name="views">
	<button type="submit" class="btn btn-outline-success mt-2">등록</button>
</form>
<script type="text/javascript">
	$(function(){
		$('.del-btn').click(function(){
			var str = '<input type="file" class="form-control" name="file">';
			$(this).parent().remove();
			$('.file-box').append(str)
		})
		
	})
</script>
</body>
</html>
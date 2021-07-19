<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!doctype html>
<html>
<head>
<!-- summernote -->
    <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.js"></script>
    
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
	  <textarea id="summernote" name="contents">${board.contents}</textarea>
	</div>
	
		<div class="form-groups files">
		  <label for="usr">첨부파일</label>
		  <c:forEach items="${fileList}" var="file">
		  	<div class="form-control attach">
		  		<span>${file.ori_name}</span><button type="button" class="del-btn">X</button>
		  		<input type="hidden" name="fileNum" value="${file.num}">
		  	</div>
		  </c:forEach>
		  <c:if test="${fileList == null || fileList.size() < 3}">
		  	<input type="file" class="form-control" name="file" data=""/>
		  </c:if>
	 	</div>
	
	<input type="hidden" value="${board.num}" name="num">
	<input type="hidden" value="${board.views}" name="views">
	<button type="submit" class="btn btn-outline-success mt-2">등록</button>
</form>
<script type="text/javascript">
	$(function(){
		$('.del-btn').click(function(){
			var str = '<input type="file" class="form-control" name="file" data="">';
			$(this).parent().remove();
			if($('.attach').length == 3)
				$('.files').append(str)
		})
		$(document).on('change','input[name=file]',function(){
			var val = $(this).val();
			var str = '<input type="file" class="form-control" name="file" data=""/>';
			//기존에 추가된것 + 현재 선택된거 
			var length = $('input[name=file]').length + $('.attach').length;
			var data = $(this).attr('data'); //바뀌기 전 값
			//파일을 선택했다가 취소하는 경우 
			if(val ==''){
				$(this).remove();
				if(length == 3 && $('input[name=file]').last().val() != ''){
					$('.files').append(str);
				}
			}
			//input태그를 추가해야하는 경우
			else{
				if(length < 3 && data == ''){
					$('.files').append(str);
				}
				$(this).attr('data',val);
			}
		})
		 $('#summernote').summernote({
		        placeholder: '내용을 작성하세요',
		        tabsize: 2,
		        height: 100
		 });
		
	})
</script>
</body>
</html>
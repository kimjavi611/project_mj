<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.js"></script>
</head>
<body>
	<form class="container" method="post" enctype="multipart/form-data">
		<h1>게시물 등록</h1>
		<div class="form-group">
			<label>제목</label>
			<input type="text" class="form-control" name="title">
		</div>
		<div class="form-group">
			<label>내용</label>
			<textarea class="form-control" id="summernote" name="contents">${board.contents}</textarea>
		</div>
		<div class="form-group">
			<input type="file" name="fileList" class="form-control">
			<input type="file" name="fileList" class="form-control">
			<input type="file" name="fileList" class="form-control">
		</div>
		
		<button class="btn btn-primary">등록</button>
		<a href="<%=request.getContextPath()%>/board${type}/list"><button type=button class="btn btn-success">목록</button></a>
	</form>
	
	<script type="text/javascript">
		$(function(){
			$('form').submit(function(){
				return true;
			})
				
		})
		$('#summernote').summernote({
	        placeholder: 'Hello Bootstrap 4',
	        tabsize: 2,
        height: 100
      });
	</script>

</body>
</html>
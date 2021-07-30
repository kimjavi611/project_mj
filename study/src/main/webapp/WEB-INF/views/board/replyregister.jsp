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

</head>
<body>
	<form class="container" method="post" action="<%=request.getContextPath()%>/board/reply/register">
		<h1>게시판</h1>
		<div class="form-group">
			<label>내용</label>
			<textarea class="form-control" id="summernote" name="contents">${board.contents}</textarea>
		</div>
		<input type="hidden" name="oriNo" value="${oriNo}">
		<button class="btn btn-primary">등록</button>
		<a href="<%=request.getContextPath()%>/board/list"><button type=button class="btn btn-success">목록</button></a>
	</form>
	<script type="text/javascript">
		$(function(){
			$('form').submit(function(){
				return true;
			})
				
		})
	</script>
</body>
</html>
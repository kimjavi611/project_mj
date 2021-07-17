<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�Խ��� ���</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
  <h1>�Խ���</h1>
  <div class="form-group">
  	<label>����</label>
  	<input type="text" class="form-control" name="title" value="<c:out value="${board.title}"/>"readonly>
  </div>
  <div class="form-group">
  	<label>�ۼ���</label>
  	<input type="text" class="form-control" name="title" value="${board.writer}">
  </div>
  <div class="form-group">
  	<label>�ۼ���</label>
  	<input type="text" class="form-control" name="title" value="${board.dateTime}">
  </div>
  <div class="form-group">
  	<label>��ȸ��</label>
  	<input type="text" class="form-control" name="title" value="${board.views}">
  </div>
  <div class="form-group">
  	<label>����</label>
  	<textarea class="form-control" name="contents" rows="10">"${board.contents}"</textarea>
  </div>
  <div class="form-group">
		<label>÷������</label>
		<c:forEach items="${fileList}" var="file">
			<a class="form-control" href="#">${file.ori_name}</a>
		</c:forEach>
		<input type="file" class="form-control" name="files"/>
	</div>
  <div class="input-group"> <!-- ��Ʈ��Ʈ������ �����ϴ� Ŭ���� -->
	<a href="<%=request.getContextPath()%>/board/list"><button class="btn btn-primary mr-2">���</button></a>
 	 <c:if test="${board != null && user.id eq board.writer}"> <!-- eq == -->
 	 <a href="<%=request.getContextPath() %>/board/modify?num=${board.num}"><button class="btn btn-success mr-2">����</button></a>
	 	<form action="<%=request.getContextPath()%>/board/delete" method="Post" class="mr-2">
	 		<input type="hidden" value="${board.num}" name="num"> <!-- �Խñ� ��ȣ�� ��ǲ�ϰ� ���ܳ��� -->
	 		<button class="btn btn-success">����</button> <!-- POST�� �Ұű� ������ form�±׾ȿ� �־������ -->
		</form>
	</c:if>
  </div>
  <script type="text/javascript">
  	$(function(){
  		var msg = '${msg}';
  		printMsg(msg);
  		history.replaceState({},null,null); //���� �� ��Ͽ��� �ڷΰ��� ��ư�� ������ ���� �ɶ� �� �˸�â�� �߰Եȴ�
  		//�ڷΰ���� �� �� �����ּҸ� �ҷ����� ���� =>history.replaceState�� ����Ȱ� ����ָ� �ڷΰ��� ��ư�� ������ �˸��� �ȶ�� 
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
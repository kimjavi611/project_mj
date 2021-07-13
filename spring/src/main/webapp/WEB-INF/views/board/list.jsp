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
  <h2>게시판 목록</h2>
  <form methhod="get" action="<%=request.getContextPath() %>>">
	  <div class="input-group mb-3">
	    <select class="form-control" name="type">
	    	<option value="0" <c:if test="${pm.criteria.type == 0 }">selected</c:if>>전체</option>
	    	<option value="1" <c:if test="${pm.criteria.type == 1 }">selected</c:if>>전체+내용</option>
	    	<option value="2" <c:if test="${pm.criteria.type == 2 }">selected</c:if>>작성자</option>
	    </select>
	    
	    
	  </div>
	</form>
  <table class="table table-hover">

    <thead>
      <tr>
        <th>번호</th>
        <th>제목</th>
        <th>작성자</th>
        <th>작성일</th>
        <th>조회수</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach items="${list}" var="board">
      <tr>
        <td>${board.num}</td>
        <td><a href="<%=request.getContextPath() %>/board/detail?num=${board.num}">${board.title}</a></td>
        <td>${board.writer}</td>
        <td>${board.date}</td>
        <td>${board.views}</td>
      </tr>
      </c:forEach>
    </tbody>
  </table>
  <a href="<%=request.getContextPath()%>/board/register"><button class="btn btn-primary">글쓰기</button></a>
   <ul class="pagination justify-content-center">
    <c:if test="${pm.prev}">
    	<li class="page-item"><a class="page-link" href="<%=request.getContextPath()%>/board/list">Previous</a></li>
    </c:if>
    <c:forEach begin="${pm.startPage }" end="${pm.endPage }" var="index">
    	
   		<li class="page-item" <c:if test="${pm.criteria.page ==index }">active</c:if>><a class="page-link" href="<%=request.getContextPath()%>/board/list">${index}</a></li>
    </c:forEach>
    <c:if test="${pm.next}">
    	<li class="page-item"><a class="page-link" href="<%=request.getContextPath()%>/board/list">Next</a></li>
  	</c:if>
  </ul>
  <script>
  	$(function(){
  		var msg = '${msg}';
  		printMsg(msg);
  		history.replaceState({},null,.null); //삭제 후 목록에서 뒤로가기 버튼을 누르면 삭제 될때 뜬 알림창이 뜨게된다
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
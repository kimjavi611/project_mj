<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<div class="container">
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
	    <!-- mv.addObject("a", b) a랑 items랑 일치해야함 -->
	    <c:forEach items="${list}" var="board">
		      <tr>
		        <td>${board.num }</td>
		        <td>
			        <a href="<%=request.getContextPath()%>/board/detail?num=${board.num}">
			        <c:if test="${board.groupOrd != 0}"> <b>ㄴRE : </b></c:if>
			        	${board.title}
			        </a>
		        </td>
		        <td>${board.writer}</td>
		        <td>${board.dateTime}</td>
		        <td>${board.views}</td>
		      </tr>
	      </c:forEach>
	    </tbody>
	  </table>	
	  <a href="<%=request.getContextPath() %>/board/register">
	   <button class="btn btn-outline-success">글쓰기</button>
	  </a>
	</div>
</body>
</html>
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
  <h2>�Խ��� ���</h2>
  
  <table class="table table-hover">

    <thead>
      <tr>
        <th>��ȣ</th>
        <th>����</th>
        <th>�ۼ���</th>
        <th>�ۼ���</th>
        <th>��ȸ��</th>
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
  <a href="<%=request.getContextPath()%>/board/register"><button class="btn btn-primary">�۾���</button></a>
  <script>
  	$(function(){
  		var msg = '${msg}';
  		printMsg(msg);
  		history.replaceState({},null,.null); //���� �� ��Ͽ��� �ڷΰ��� ��ư�� ������ ���� �ɶ� �� �˸�â�� �߰Եȴ�
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
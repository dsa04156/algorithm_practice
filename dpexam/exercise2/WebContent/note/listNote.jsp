<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="/include/head.jsp" %>
</head>
<body>
	<%@ include file="/include/nav.jsp" %>

	<%-- 페이지만의 내용 --%>
	<div class="container p-4">
	  <h2>노트북 목록</h2>
	  <table class="table table-hover">
	    <thead>
	 
	      <tr>
	        <th>고유번호</th>
	        <th>모델명</th>
	        <th>가격</th>
	        <th>제조사</th>
	      </tr>
	    
	    </thead>
	    <tbody>
	       <c:forEach var="dto" items="${list }">
			<%-- 노트북 정보 개수만큼 반복 출력 --%>
			<tr >
				<td>${dto.noteCode }</td>
				<td><a href="${root }/note?action=view&model=${dto.model}">${dto.model }</a></td>
				<td>${dto.price }</td>
				<td>${dto.company }</td>
			</tr>
		  </c:forEach>
	    </tbody>
	  </table>
	</div>

<%@ include file="/include/footer.jsp" %>
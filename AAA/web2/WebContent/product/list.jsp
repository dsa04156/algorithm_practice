<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="/include/head.jsp" %>
</head>
<body>
	<%@ include file="/include/nav.jsp" %>

	<%-- 페이지만의 내용 --%>
	<div class="container p-4">
	
	리스트 페이지입니다.<br>
	<table>
		<tr>
			<th>code</th>
			<th>model</th>
			<th>비고</th>
		</tr>
<c:forEach var="dto" items="${list}">		
		<tr>
			<td><a href ="${root }/product?action=view&code=${dto.code }">${dto.code }</a></td>
			<td>${dto.model }</td>
			<td><a href ="${root }/product?action=delete&code=${dto.code }">삭제</a></td>
		</tr>
</c:forEach>
	</table>
	
	
	</div>
	<%-- --%>
<%@ include file="/include/footer.jsp" %>
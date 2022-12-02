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
	
	  <h2>상품 정보 상세 페이지</h2>
	    <div class="form-group">
	      <label for="productCode">고유번호</label>
	      	${dto.code }
	    </div>
	    <div class="form-group">
	      <label for="model">모델명</label>
	      ${dto.model }
	    </div>
	    <div class="form-group">
	      <label for="price">가격</label>
	      ${dto.price }
	    </div>

	<a href ="${root }/product?action=delete&code=${dto.code }">삭제</a>
	<a href ="${root }/product?action=mvUpdate&code=${dto.code }">수정</a>
	
	</div>
	<%-- --%>
<%@ include file="/include/footer.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="/include/head.jsp" %>
</head>
<body>
	<%@ include file="/include/nav.jsp" %>
	<%@ include file="/include/confirm.jsp" %>
	<%-- 페이지만의 내용 --%>
	<div class="container p-4">
	
	  <h2>상품 정보 수정 페이지</h2>
	  <form id="registForm" method = "post" action="${root }/product">
	  	<input type="hidden" name="action" value="update">
	  	<input type="hidden" name="productCode" value="${dto.code }">
	    <div class="form-group">
	      <label for="productCode">고유번호</label>
	      ${dto.code }
	      <%-- <input type="text" readonly="readonly" value = "${dto.code }" class="form-control" id="productCode" name="productCode"  placeholder="고유번호 입력"> --%>
	    </div>
	    <div class="form-group">
	      <label for="model">모델명</label>
	      <input type="text" class="form-control" value = "${dto.model }" id="model" name="model" placeholder="모델명 입력">
	    </div>
	    <div class="form-group">
	      <label for="price">가격</label>
	      <input type="number" class="form-control" value = "${dto.price }" id="price" name="price"  placeholder="가격 입력" >
	    </div>

	    <button type="submit" class="btn btn-primary" id="regist">수정</button>
	    <a class="btn btn-secondary" href="#" >취소</a>
	  </form>
	
	
	</div>
	<%-- --%>
<%@ include file="/include/footer.jsp" %>
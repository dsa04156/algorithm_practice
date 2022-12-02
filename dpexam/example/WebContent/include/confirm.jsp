<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${ userInfo eq null }">
<div>
	<form method="post" action = "${root }/member">
		<input type="hidden" name="act" value="login">
		id <input type="text" id="mid" name = "mid">
		pw <input type="password" id="mpw" name = "mpw">
		<input type="submit" value = "login">
	</form>
</div>
</c:if>
<c:if test="${ userInfo ne null }">
<div>
	${userInfo.userId }(${userInfo.userName })<a href = "${root }/member?act=logout">로그아웃</a>
</div>
</c:if>

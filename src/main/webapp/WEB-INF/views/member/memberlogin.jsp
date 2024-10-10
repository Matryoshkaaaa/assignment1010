<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- JSTL을 위한 Directive 선언 -->
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/css/common.css" />
</head>

<body>
	<h1>로그인</h1>
	<form:form modelAttribute="loginMemberVO" method="post">
		<div>
			<form:errors path="email" element="div" cssClass="errors" />
			<form:errors path="password" element="div" cssClass="errors" />
			<c:if test="${not empty message}">
				<div class="error">${message}</div>
			</c:if>

		</div>
		<div class="grid">
			<label for="email">이메일</label> <input id="email" type="email"
				name="email" value="${loginMemberVO.email}" /> <label
				for="password">비밀번호</label> <input id="password" type="password"
				name="password" value="${loginMemberVO.password}" />
			<div class="btn-group">
				<div class="right-align">
					<input id="btn-regist" type="submit" value="로그인" />
				</div>
			</div>
		</div>
		<div style="display:flex; gap:1rem" >
		<a href="/board/list">메인으로</a>
		<a href="/member/regist">회원가입</a>
		</div>
	</form:form>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="form"
uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
    <link rel="stylesheet" type="text/css" href="/css/common.css" />
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script type="text/javascript" src="/js/member/memberregist.js"></script>
  </head>
  <body>
    <h1>회원가입</h1>
    <form:form modelAttribute="registMemberVO" method="post" var="member">
    <div>
    	<form:errors path="email" element="div" cssClass="errors" />
		<form:errors path="name" element="div" cssClass="errors" />
		<form:errors path="password" element="div" cssClass="errors" />
		<form:errors path="passwordConfirm" element="div" cssClass="errors" />
    </div>
    
      <div class="grid">
        <label for="email">이메일</label>
        <input id="email" type="email" name="email" value="${memberVO.email}"/>
       

        <label for="name">이름</label>
        <input id="text" type="text" name="name" value="${memberVO.name}" />
      

        <label for="password">비밀번호</label>
        <input id="password" type="password" name="password" value="${memberVO.password}"  />
       

        <label for="passwordConfirm">비밀번호 확인</label>
        <input id="passwordConfirm" type="password" name="passwordConfirm" value="${memberVO.confirmPassword}"  />

        <div class="btn-group">
          <div class="right-align">
            <input type="submit" value="등록" />
          </div>
        </div>
      </div>
    </form:form>
    <a href="/board/list">메인으로</a>
  </body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@taglib prefix="form"
uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
    <link rel="stylesheet" type="text/css" href="/css/common.css" />
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script>
      $().ready(function () {
        $("#modify").on("click", function () {
          console.log(">>");
        });
      });
    </script>
  </head>
  <body>
    <div class="membermenu"></div>
      <jsp:include page="../member/membermenu.jsp"></jsp:include>
    </div>
    <h1>게시글 수정</h1>
    <form:form
      modelAttribute="modifyBoardVO"
      method="post"
      enctype="multipart/form-data"
      action="/board/modify/${boardVO.id}"
    >
      <div class="grid">
        <label for="subject">제목</label>
        <div>
          <form:errors path="subject" element="div" cssClass="error" />
          <input
            id="subject"
            type="text"
            name="subject"
            value="${boardVO.subject}"
          />
        </div>
       

        <label for="originFileName">첨부파일</label>
        <div>
          <input type="file" id="file" name="file" />
          현재 업로드된 파일: ${boardVO.originFileName}
        </div>

        <label for="content">내용</label>
        <form:errors path="content" element="div" cssClass="error" />
        <textarea id="content" name="content">${boardVO.content}</textarea>
        <div class="btn-group">
          <div class="right-align">
            <input type="submit" value="수정" id="modify" />
          </div>
        </div>
      </div>
    </form:form>
    <a href="/board/list">메인으로</a>
  </body>
</html>

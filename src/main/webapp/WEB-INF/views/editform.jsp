<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Edit Form</title>
  <%--	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">--%>
  <%--	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">--%>
  <%--	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>--%>
</head>
<body>

<%--<%--%>
<%--  BoardDAO boardDAO = new BoardDAO();--%>
<%--  String id=request.getParameter("id");--%>
<%--  BoardVO u=boardVO.getMember(Integer.parseInt(id));--%>
<%--  request.setAttribute("u",u);--%>
<%--%>--%>

<h1>Edit Form</h1>

<form:form modelAttribute="boardVO" method="POST" action="../editok">
  <form:hidden path="seq"/>
  <table id="edit">
    <tr><td>제목:</td><td><form:input path="title"/></td></tr>
    <tr><td>글쓴이:</td><td><form:input path="writer"/></td></tr>
    <tr><td>내용</td><td><form:textarea cols="50" rows="5" path="content"/></td></tr>
    <tr><td>카테고리:</td><td><form:input path="category"/></td></tr>
    <tr><td>주제:</td><td><form:input path="topic"/></td></tr>

    <%--<tr><td>Content:</td><td><textarea cols="50" rows="5" name="content"><%= u.getContent()%></textarea></td></tr>--%>
    <tr><td colspan="2">
      <input type="submit" value="Edit Post"/>
      <input type="button" value="Cancel" onclick="history.back()"/></td></tr>
  </table>
</form:form>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

%>

<jsp:useBean id="dto" class="data.dto.SawonDto"/>
<jsp:useBean id="dao" class="data.dao.SawonDao"/>

<jsp:setProperty property="*" name="dto"/>
<%
//insert메서드 호출
dao.updateSawon(dto);
//사원목록으로 이동
response.sendRedirect("sawondetail.jsp?num="+dto.getNum());
%>
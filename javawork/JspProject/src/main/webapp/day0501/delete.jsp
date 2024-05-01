<%@page import="data.dto.StudentDto"%>
<%@page import="data.dao.StudentDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
int num=Integer.parseInt(request.getParameter("num"));
StudentDao dao=new StudentDao();
dao.deleteStudent(num);

response.sendRedirect("list.jsp");


%>
<%@page import="data.dao.SawonDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
	int num=Integer.parseInt(request.getParameter("num")) ;
	SawonDao dao=new SawonDao();
	dao.deleteSawon(num);
	response.sendRedirect("sawonlist.jsp");
	
%>
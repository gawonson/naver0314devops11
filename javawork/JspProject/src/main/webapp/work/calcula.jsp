<%@page import="data.dto.moneyDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
int deposit = Integer.parseInt(request.getParameter("deposit"));
String withdraw=request.getParameter("withdraw");



%>
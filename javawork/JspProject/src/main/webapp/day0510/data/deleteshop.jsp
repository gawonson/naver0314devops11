<%@page import="data.dao.ShopDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
//shopidx 읽기
	int shopidx=Integer.parseInt(request.getParameter("shopidx"));

	//dao선언
	ShopDao dao=new ShopDao();	
	//삭제
	dao.deleteShop(shopidx);
%>
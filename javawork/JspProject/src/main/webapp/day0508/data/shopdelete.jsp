<%@page import="data.dao.ShopDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
//shop idx를 int로 읽기
int shopidx=Integer.parseInt(request.getParameter("shopidx"));
//dao선언
ShopDao dao=new ShopDao();

//delete 메서드 호출
dao.deleteShop(shopidx);
%>
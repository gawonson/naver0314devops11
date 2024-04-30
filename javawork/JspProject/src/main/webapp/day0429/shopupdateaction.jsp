<%@page import="data.dao.ShopDao"%>
<%@page import="data.dto.ShopDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	//인코딩
	request.setCharacterEncoding("utf-8");
	String sname=request.getParameter("sname");
	String scolor=request.getParameter("scolor");
	String sphoto=request.getParameter("sphoto");
	int sprice=Integer.parseInt(request.getParameter("sprice"));
	int scount=Integer.parseInt(request.getParameter("scount")) ;
	String shopidx=request.getParameter("shopidx") ;
	//3.dto에 넣기(setter로 넣기)
	ShopDto dto=new ShopDto();
	dto.setSname(sname);
	dto.setScolor(scolor);
	dto.setSphoto(sphoto);
	dto.setSprice(sprice);
	dto.setScount(scount);
	dto.setShopidx(shopidx);
	//4.dao 선언
	ShopDao dao=new ShopDao();
	//update 메서드 호츨
	dao.updateShop(dto);
	//6. shoplist.jsp로 이동
	//response.sendRedirect("shoplist.jsp");//url 주소 바뀜
	//detail 페이지로 이동하려면??
	response.sendRedirect("shopdetail.jsp?shopidx="+shopidx);
%>
<%@page import="data.dao.TalentDao"%>
<%@page import="data.dto.TalentDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

	<%
		request.setCharacterEncoding("utf-8");
		String tname=request.getParameter("tname");
		int tage=Integer.parseInt(request.getParameter("tage"));
		String tphoto = request.getParameter("tphoto");
		int theight =Integer.parseInt(request.getParameter("theight"));
		String thome=request.getParameter("thome");
		String tfan=request.getParameter("tfan");
		
		TalentDto dto=new TalentDto(tname,tage,tphoto,theight,thome,tfan);
		
		TalentDao dao=new TalentDao();
		
		dao.inserttalent(dto);
		
		response.sendRedirect("talentlist.jsp");
		
		
	%>
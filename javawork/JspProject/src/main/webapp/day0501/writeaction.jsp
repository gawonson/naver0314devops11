<%@page import="data.dao.StudentDao"%>
<%@page import="data.dto.StudentDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
String name = request.getParameter("name");
String blood = request.getParameter("blood");
String lic = request.getParameter("license");
int java = Integer.parseInt(request.getParameter("java"));
int spring = Integer.parseInt(request.getParameter("spring"));
int html = Integer.parseInt(request.getParameter("html"));
char license;

if (lic ==null) {
	license = 'n';
} else {
	license = 'y';
}

StudentDto dto = new StudentDto();

dto.setName(name);
dto.setBlood(blood);
dto.setJava(java);
dto.setSpring(spring);
dto.setHtml(html);
dto.setLicense(license);
StudentDao dao = new StudentDao();

dao.insertStuent(dto);

response.sendRedirect("list.jsp");
%>
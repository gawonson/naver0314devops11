package data.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/study1")
public class HelloServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//request 에 값 저장
		request.setAttribute("message", "안녕하세요. 비트캠프입니다.");
		request.setAttribute("today", new Date());
		request.setAttribute("num1", 8);
		request.setAttribute("num2", 5);
		
		
		//test1.jsp 로 이동 forward(url주소 안바뀜 , respones, request 그대로 저장//redirect는 반대)로 이동	
		RequestDispatcher rd=request.getRequestDispatcher("./day0513/test1.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}

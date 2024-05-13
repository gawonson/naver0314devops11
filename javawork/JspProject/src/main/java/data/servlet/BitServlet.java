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
 * Servlet implementation class BitServlet
 */
@WebServlet("/study2")
public class BitServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setAttribute("today", new Date());
		request.setAttribute("money", 5678960);
		request.setAttribute("score", 89.34567);
		//test1.jsp 로 이동 forward(url주소 안바뀜 , respones,request 그대로 저장//redirect는 반대)로 이동	
		RequestDispatcher rd=request.getRequestDispatcher("./day0513/test2.jsp");
		rd.forward(request, response);	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

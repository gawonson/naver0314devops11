package board.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.dao.SimpleBoardDao;


@WebServlet("/board/updatechu")
public class UpdateChuServlet extends HttpServlet {
	SimpleBoardDao dao=new SimpleBoardDao();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//read num
		int num=Integer.parseInt(request.getParameter("num"));
		
		
		dao.updateChu(num);
		
		int chu=dao.getData(num).getChu();
		
		//json 형식으로 문자열 만들기
		String s="{\"chu\":"+chu+"}";
		
		request.setAttribute("s", s);
		
		RequestDispatcher rd=request.getRequestDispatcher("../day0514/jsonchu.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

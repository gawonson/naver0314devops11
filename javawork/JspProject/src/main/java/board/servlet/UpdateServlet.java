package board.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.dao.SimpleBoardDao;
import data.dto.SimpleBoardDto;
	
@WebServlet("/board/update")
public class UpdateServlet extends HttpServlet {
	SimpleBoardDao dao=new SimpleBoardDao();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		int num=Integer.parseInt(request.getParameter("num"));
		int currentPage=Integer.parseInt(request.getParameter("currentPage"));
		String writer=request.getParameter("writer");
		String avata=request.getParameter("avata");
		String subject=request.getParameter("subject");
		String content=request.getParameter("content");
		
		
		SimpleBoardDto dto=new SimpleBoardDto();
		dto.setAvata(avata);
		dto.setContent(content);
		dto.setWriter(writer);
		dto.setNum(num);
		dto.setSubject(subject);
		
		dao.updateBoard(dto);
		
		
		response.sendRedirect("./list?currentPage="+currentPage+"&num="+num);
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
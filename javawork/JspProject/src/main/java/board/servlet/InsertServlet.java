package board.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.dao.SimpleBoardDao;
import data.dto.SimpleBoardDto;


@WebServlet("/board/insert")
public class InsertServlet extends HttpServlet {
	SimpleBoardDao dao=new SimpleBoardDao();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//dopost 로부터 호출이 되었으므로 encoding을 해줘야한다
		request.setCharacterEncoding("utf-8");
		//데이터 읽어서 dto에 담기
		SimpleBoardDto dto=new SimpleBoardDto();
		dto.setWriter(request.getParameter("writer"));
		dto.setSubject(request.getParameter("subject"));
		dto.setAvata(request.getParameter("avata"));
		dto.setContent(request.getParameter("content"));
		
		//insert 메서드 호출
		dao.insertBoard(dto);
		
		
		//목록으로 리다이렉트
		response.sendRedirect("./list");//ListServlet 으로 이ㅗㄷㅇ
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
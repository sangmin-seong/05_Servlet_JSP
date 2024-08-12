package edu.kh.todoList.controller;

import java.io.IOException;

import edu.kh.todoList.service.TodoListService;
import edu.kh.todoList.service.TodoListServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/todo/complete")
public class CompleteServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int index = Integer.parseInt(req.getParameter("index"));
		
		try {
			
			// 할 일 완료 여부를 변경하는 서비스 호출 후 결과 반환 받기
			TodoListService service = new TodoListServiceImpl();
			boolean result = service.todoComplete(index);
			
			// session scope 객체 얻어오기
			HttpSession session = req.getSession();
			
		
			
			// 변경 성공 시 
			// -> 원래 보고 있던 상세 페이지로 redirect
			if(result) {
				
				// 변경 여부 알림
				session.setAttribute("message",
						"완료 여부가 변경되었습니다.");
				// 상세페이지 주소를 기입
				resp.sendRedirect("/todo/detail?index=" + index);
				return;
			}
			
			// 변경 실패시
			session.setAttribute("message", 
					"해당 index번째 todo가 존재하지 않습니다.");
			
			// 메인페이지로 redirect
			resp.sendRedirect("/");
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}

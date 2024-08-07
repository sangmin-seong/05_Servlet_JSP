package edu.kh.JSP.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/test")
public class TestServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 전달받은 값을 h1태그에 각각 다른 색상으로 출력되도록
		// HTML 코드를 작성하여 응답하기
		
		// ----------------------------------------------------------
		
		/* 응답 처리 */
		// -> Servlet이 직접 HTML 코드를 작성하지 않고
		//    JSP한테 대신 화면을 만들어 클라이언트에게 응답(출력)하라고 요청을 떠넘기자!!!
		//	  -> 요청 위임 
		
		// 요청 위임 방법 1) 
		// 떠넘길*위임할 JSP 경로 작성하기
		// webapp 폴더를 기준으로 경로 작성!!!
		// 제일 앞 "/" == webapp 폴더
		String path = "/WEB-INF/views/test_result.jsp"; // 택배 주소
		
		// 요청 위임 방법 2)
		// 요청을 전달할 객체(RequestDisPatcher) 얻어오기
		// -> 객체 얻어올 때 어떤 JSP로 전달할지 매개변수로 기입
		RequestDispatcher dispatcher 		  //-> 택배 기사 생성
			= req.getRequestDispatcher(path); //-> 택배 수령장소 
		
		// 요청 위임 방법 3)
		// RequestDispatcher객체에게 
		// HttpServletRequest	(요청 데이터)
		// HttpServletResponse	(응답 방법)를
		// 주고 JSP로 떠넘기는(위임하는) 메서드 호출
		
		dispatcher.forward(req, resp);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
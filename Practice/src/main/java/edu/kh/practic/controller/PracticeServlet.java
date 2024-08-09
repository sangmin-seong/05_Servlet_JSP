package edu.kh.practic.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/search")
public class PracticeServlet extends HttpServlet{

	private List<String> nameList = null;
	
	public PracticeServlet() {
		nameList = new ArrayList<String>();
		
		nameList.add("짱구");
		nameList.add("훈이");
		nameList.add("철수");
		nameList.add("유리");
		nameList.add("맹구");
	
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		// 제출된 파라미터 얻어오기
		String inputName = req.getParameter("inputName");
				
		// 입력된 이름이 nameList에 있는지 없는 확인
		
		// int List.indexof("값") : 값과 일치하는 요소의 index 반환
		//							없으면 -1 반환
		int index = nameList.indexOf(inputName);
		
		// 존재하는 경우 - forword
		if(index > -1) {
			String message 
			= String.format("%s님은 %d번째 인덱스에 존재합니다",
							inputName, index);
		
			req.setAttribute("message", message);
			
			
			// JSP 파일 경로를 webapp 폴더 기준으로 작성
			String path = "/WEB-INF/views/result.jsp"; 
			// - WEB-INF 폴더는 클라이언트 직접 접근 불가
			//  하지만 서버는 가능
			
			req.getRequestDispatcher(path).forward(req, resp);
			// -> 지정된 경로의 JSP에게 응답을 대신하라고 위임
			//    이 때, 기존 req/resp가 유지가 된다
			// 	  		 응답화면의 주소 : /search
			//			 (현재 Servlet 매핑 주소)
			
		// 존재하지 않는 경우
		}else {
			
			HttpSession session = req.getSession();
			
			session.setAttribute("message", inputName + "님은 존재하지 않습니다");
			
			// 왜 message를 session scope에 세팅했을까?
			// -> redirect 시
			//    기존 req/resp 객체가 사라지고
			//    새 req/resp 객체가 생성되기 때문에
			
			// 기존 req에 값을 세팅해봐야 없어 지기때문에 의미 없음.
			
			// 메인페이지(/) 재요청
			// -> webapp 폴더를 기준으로 파일 경로 작성
			//  || 원하는 Servlet의 매핑 되는 주소 작성
			resp.sendRedirect("/");
		}
		
		
		
		
		
	}
}

package edu.kh.jsp2.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/el/test1")
public class ELTestServlet1 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		/* 요청 처리 */
		
		
		
		//--------------------------------------------------------------------------------
		
		/* 응답처리 */
		
		//1) JSP 경로(webapp 폴더 기준)
		 String path = "/WEB-INF/views/el/test1.jsp";
	
		 //2) 요청발송자 얻어오기
		 RequestDispatcher dispatcher = req.getRequestDispatcher(path);
		 
		 //	3) 요청 위임(forward)
		 dispatcher.forward(req, resp);
	}
	
}

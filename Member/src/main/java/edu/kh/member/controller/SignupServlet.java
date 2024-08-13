package edu.kh.member.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edu.kh.member.dto.Member;
import edu.kh.member.service.MemberService;
import edu.kh.member.service.MemberServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/signUp")
public class SignupServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			String path = "/WEB-INF/views/signup.jsp";
			req.getRequestDispatcher(path).forward(req, resp);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("name");
		String phone = req.getParameter("phone");

		String url = null;
		String message = null;
		
		try {
			
			MemberService service = new MemberServiceImpl();
			boolean result = service.addMember(name, phone);
			
			if(result) {			
				url = "/";
				message = name + "님이 가입되었습니다.";
			}else {
				url = "/signUp";
				message = "중복된 휴대폰 번호가 존재합니다.";
			}

			HttpSession session = req.getSession();
			session.setAttribute("message", message);
			
			resp.sendRedirect(url);
									
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}

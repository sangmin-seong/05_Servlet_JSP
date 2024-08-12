package edu.kh.member.controller;

import java.io.IOException;

import edu.kh.member.Service.MemberService;
import edu.kh.member.Service.MemberServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/member/add")
public class MemberAddServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			MemberService service = new MemberServiceImpl();
			
			String name = req.getParameter("name");
			String phone = req.getParameter("phone");
			
			int index = service.memberAdd(name, phone);
			
			String message = null;
			
			if(index > -1) message = "추가 성공";
			else		   message = "추가 실패....";
			
			HttpSession session = req.getSession();
			session.setAttribute("message", session);
			
			resp.sendRedirect("/");
		
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}

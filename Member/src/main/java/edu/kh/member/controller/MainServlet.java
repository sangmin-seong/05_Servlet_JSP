package edu.kh.member.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import edu.kh.member.Service.MemberService;
import edu.kh.member.Service.MemberServiceImpl;
import edu.kh.member.dto.Member;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/main")
public class MainServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	
		try {
			MemberService service = new MemberServiceImpl();
			
			Map<String, Object> map = service.memberListFullView();
			
			List<Member> memberList = (List<Member>)map.get("memberList");
			
			req.setAttribute("memberList", memberList);
			
			String path = "/WEB-INF/views/main.jsp";
			req.getRequestDispatcher(path).forward(req, resp);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}

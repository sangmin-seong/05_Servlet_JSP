package edu.kh.network1.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edu.kh.network1.dto.Member;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/join")
public class JoinServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		List<Member> memberList = new ArrayList<Member>();
	
		memberList.add(new Member("test01", "1234", "김테스트"));

	
		memberList.add(new Member("test02", "5678", "최테스트"));

	
		memberList.add(new Member("test03", "qwer", "박테스트"));

	//-----------------------------------------------------------

		String memberId = req.getParameter("memberId");
		// index.jsp 의 input 태그에서 name 속성값이 들어가야하는 자리임.
		// 현재 "id"로 작성 되어있으나, "memberId"로 수정필요

		String memberPw = req.getParameter("memberPw");
		// index.jsp 의 input 태그에서 name 속성값이 들어가야하는 자리임.
		// 현재 "pw"로 작성 되어있으나, "memberPw"로 수정필요

		String memberName = req.getParameter("memberName");
		// index.jsp 의 input 태그에서 name 속성값이 들어가야하는 자리임.
		// 현재 "name"로 작성 되어있으나, "memberName"로 수정필요

		
		
		// MemberList 내 동일한 아이디가 존재 한다면
		for(Member member : memberList) {

			if(member.getMemberId().equals(memberId)) {

				HttpSession session = req.getSession();

				session.setAttribute("message", memberId + "은/는 이미 존재하는 아이디 입니다.");

				resp.sendRedirect("/");

				return;

			}	

		}
		// 중복된 아이디가 없을 때
		Member member = new Member(memberId, memberPw, memberName);

		memberList.add(member);

		String message = String.format("%s/%s 님이 가입 되었습니다 (비밀번호 : %s)" , memberId, memberName, memberPw);

		req.setAttribute("message", message);

		String path = "/WEB-INF/views/success.jsp";
		// 경로에서 기준은 webapp 폴더가 기준임. 현재 success.jsp의 경로는 webapp 폴더 하위 WEB-INF 하위 views 폴더 내에 있으므로
		// 

		req.getRequestDispatcher(path).forward(req, resp);

	}

}


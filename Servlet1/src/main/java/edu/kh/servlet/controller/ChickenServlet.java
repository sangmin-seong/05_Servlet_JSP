package edu.kh.servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/chicken")
public class ChickenServlet  extends HttpServlet{

	// HttpServletRequest : 요청자 정보, 전달받은 데이터가 담긴 객체
	
	// HttpServletResponse : 응답방법을 제공하는 객체
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		// 요청 시 제출된 값(파라미터) 모두 얻어오기
		
		// 1) 값이 하나인 경우 : String req.getParameter("name")
		String chicken = req.getParameter("chicken"); // 치킨 종류
		String type = req.getParameter("type"); // 뼈/순살
		
		String orderName = req.getParameter("ordererName"); // 주문자명
		String orderAddress = req.getParameter("ordererAddress"); // 주문자 주소
		
		// 2) 값이 2개 이상인 경우 : String[] req.getParameterValues("name")
		//    -> 제출된 값 중 name 속성값이 일치하는 것을
		//       모두 모아 하나의 String[]로 반환
		//       단, name 속성 값이 일치하는 것이 없을 경우 "null" 반환
		String[] options = req.getParameterValues("opt");
		
		//-----------------------------------------------
		// 선택한 치킨 종류, 뼈/순살, 옵션에 따라 가격 책정하기
		
		int price = 0;
		
		switch(chicken) {
			case "후라이드"     : price += 10000; break; 
			case "양념"         : price += 11000; break; 
			case "간장", "마늘" : price += 12000; break; 
		}
		
		// 순살인 경우 +2000
		if(type.equals("boneless")) price += 2000;
		
		// 추가된 옵션이 있을 경우
		if(options != null) {
			
			for(String opt: options) {
				switch(opt) {
					case "치킨무" : price += 500; break;
					case "콜라" : price += 2000; break;
					case "치즈볼" : price += 3000; break;
				}
			}
		}
//		System.out.println("중간 확인 : " + price);
		
		
		// 1. 응답하는 문서의 형식과 문자 인코딩 지정
		resp.setContentType("text/html; charset=UTF-8");
		
		// 2. 출력용 스트림 얻어오기
		PrintWriter out = resp.getWriter();
		
		// 3. HTML 코드를 작성해서 출력하기
		StringBuilder sb = new StringBuilder();
				
		sb.append("""
		<!DOCTYPE>
		<html>
		<head>
			<title>""");
		
		sb.append(orderName + "님의 주문 영수증");
		
		sb.append("</title>");
		sb.append("</head>");		
		sb.append("</html>");		
				
		sb.append("<body>");
		
		sb.append("<h3> 주문자명 : " + orderName + "</h3>");
		sb.append("<h3> 주소 : " + orderAddress + "</h3>");
		
		sb.append("<ul>");
		
			sb.append("<li> 치킨 : " + chicken + "</li>");
			
			sb.append("<li> 뼈 / 순살 : " + (type.equals("bone") ? "뼈" : "순살")+ "</li>");
			
			// 옵션 선택이 있을 경우
			if(options != null) {
				sb.append("<li> 선택한 옵션 : ");
				
				//String.join : String[] -> String 한 줄로 변환
				sb.append(String.join(" / ", options));
				// 치킨무 / 콜라 / 치즈볼
				
				sb.append("</li>");
			}
			
		sb.append("</ul>");
		
		sb.append("<h3> 금액 : " + price + "</h3>");
		sb.append("""
		</body>
		</html>""");
		
		// 4. 출력 스트림을 이용 HTML 코드 출력
		out.write(sb.toString());
		
	}
}

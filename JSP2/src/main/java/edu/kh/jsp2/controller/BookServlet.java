package edu.kh.jsp2.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edu.kh.jsp2.dto.Book;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/book/list")
public class BookServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//book으로 타입이 제한된 List 생성
		
		List<Book> bookList = new ArrayList<Book>();
		
		// bookList에 샘플 데이터 추가 
		bookList.add(new Book("자바 공부", "백동현", 10_000));
		bookList.add(new Book("HTML 공부", "고현우", 20_000));
		bookList.add(new Book("JS 공부", "성상민", 15_000));
		bookList.add(new Book("CSS 공부", "짱구", 50_000));
		bookList.add(new Book("Servlet이란", "훈이", 40_000));
		bookList.add(new Book("JSP란", "철수", 80_000));
		bookList.add(new Book("Spring이란", "유리", 200_000));
		
		req.setAttribute("bookList", bookList);
		
		
		
		String path = "/WEB-INF/views/book/bookList.jsp";
		
		req.getRequestDispatcher(path).forward(req, resp);
	}
}

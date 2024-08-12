<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>memberList</title>

  <link rel="stylesheet" href="/resources/css/main.css">
</head>
<body>

  <h1>memberList</h1>

  <h3>전체 회원 수 : ${fn:length(memberList)}</h3>

  <h4>회원 추가</h4>
  <form action="/member/add" method = "post">
    <div>
      회원 이름 : <input type="text" name = "name">
    </div>
    <div>
      전화번호 : <input type="text" name = "phone">
    </div>
    <button>추가</button>
  </form>

<%-- 회원 목록 출력 --%>
  <table id= "memberList" border="1">
    <thead>
      <tr>
        <th>회원번호</th>
        <th>회원이름</th>
        <th>전화번호</th>
        <th>등    급</th>
      </tr>
    </thead>

    <tbody>
      <c:forEach items="${memberList}" var="member" varStatus = "vs">
        <tr>
          <th>${vs.count}</th>
          <td>
          <a href= "#">${member.name}</a">
          </td>
          <th>${member.phone}</th>
          <td>
          <c:if test="${member.amount} > 10000" >
            "일반"
          </c:if>

          <c:if test="${member.amount} >= 100000" >
            "골드"
          </c:if>

          <c:if test="${member.amount} >= 1000000" >
            "다이아"
          </c:if>
          </td>
        </tr>
      </c:forEach>
      
    </tbody>
  </table>
  
  <script src = "/resources/js/main.js"></script>
  </body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>회원 전체 조회</title>
  <link rel="stylesheet" href="/resources/css/main.css">
      <style>
        table {
            width: 100%;
            margin-top: 20px;
            margin-bottom: 20px;
        }
        th, td {
            padding: 10px;
        }
        td:nth-child(2), td:nth-child(4) { text-decoration : underline;}

        .search-form {
            display: flex;
            justify-content: flex-end;
            margin-bottom: 20px;
        }
        .search-form input[type="text"] {
            width: 200px;
            margin: 0;
            margin-right: 10px;
        }
        .search-form button {
            margin-top : 0;
            padding: 10px 15px;
        }
    </style>
</head>
<body>
  <div class="container">
    <h1>회원 조회</h1>
    <form class="search-form" action="/search" method="GET">
        <input type="text" name="searchName" placeholder="이름으로 검색" required>
        <button type="submit" class="button">검색</button>
    </form>

    <table>
      <thead>
        <tr>
          <th>번 호</th>
          <th>이 름</th>
          <th>휴대폰 번호</th>
          <th>누적금액</th>
          <th>등급</th>
          <th>탈퇴</th>
        </tr>
      </thead>

      <tbody>
        <tr>
          <c:if test="${empty memberList}" >
            <tr>
              <td colspan = "6">조회 결과가 없습니다</td>
            </tr>
          </c:if>

          <c:if test="${not empty memberList}" >
            <c:forEach items="${memberList}" var="member" varStatus = "vs">
              <tr>
                <td>${vs.count}</td>
                <td><a href="/update/member?index=${vs.index}">${member.name}</a></td>
                <td>${member.phone}</td>
                <td><a href="/update/amount?index=${vs.index}">${member.amount}원</a></td>
                <td>
                  <c:choose>
                     <c:when test="${member.grade} == 2>">"다이아"</c:when>
                     <c:when test="${member.grade} == 1>">"골드"</c:when>
                     <c:otherwise>"일반"</c:otherwise>
                  </c:choose>
                </td>
                <td>
                  <button data-index="${vs.index}" class="delete-btn">탈퇴</button>
                </td>
              </tr>
            </c:forEach>
          </c:if>
        </tr>
      </tbody>
    </table>

  <c:if test="${not empty sessionScope.message}" >
    <script>
      alert( "${message}" );    
    </script>
    <c:remove var="message" scope="session" />
  </c:if>
</body>
</html>
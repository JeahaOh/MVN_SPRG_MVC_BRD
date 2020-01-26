<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>게시판 목록</title>
  <script>
  // 게시물 tr 클릭 시 게시물 번호를 받아서 게시물 상세 페이지를 요청한다.
  const goBoardDetail = function(boardSeq) {
    location.href = "/board/boardDetail?board_seq=" + boardSeq;
  }
  </script>
</head>
<body>
  <table border="1" width="350">
    <thead>
      <tr>
        <td>글번호</td>
        <td>제목</td>
        <td>조회수</td>
        <td>작성자</td>
      </tr>
    </thead>
    <tbody id="tbody">
      <c:choose>
        <c:when test="${fn:length(boardList) <= 0}">
          <tr colspan='4'>
            <td>등록된 글이 존재하지 않습니다.</td>
            <td>${fn:length(boardList)}</td>
          </tr>
        </c:when>
        <c:otherwise>
          <c:forEach var="brd" items="${boardList}">
            <tr onclick="goBoardDetail(${brd.board_seq})" style='cursor:Pointer'>
              <td>${brd.board_seq}</td>
              <td>${brd.board_subject}</td>
              <td>${brd.board_hits}</td>
              <td>${brd.board_writer}</td>
            </tr>
          </c:forEach>
        </c:otherwise>
      </c:choose>
    </tbody>
  </table>
</body>
</html>
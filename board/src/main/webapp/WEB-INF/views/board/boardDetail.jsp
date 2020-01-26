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
<title>게시물 상세</title>
  <script>
  // 게시물 tr 클릭 시 게시물 번호를 받아서 게시물 상세 페이지를 요청한다.
  const goBoardDetail = function(boardSeq) {
    location.href = "/board/boardDetail?boardSeq=" + boardSeq;
  }
  </script>
</head>
<body>
  <h2>게시물 상세</h2>
  <table border="1" width="350">
    <tbody id="tbody">
      <tr>
        <th>제목</th>
        <td>${board.board_subject}</td>
        <th>조회수</th>
        <td>${board.board_hits}</td>
      </tr>
      <tr>
        <th>작성자</th>
        <td>${board.board_writer}</td>
        <th>작성 일시</th>
        <td>${board.ins_date}</td>
      </tr>
      <tr>
        <th>내용</th>
        <td colspan="3">${board.board_content}</td>
      </tr>
    </tbody>
  </table>
</body>
</html>
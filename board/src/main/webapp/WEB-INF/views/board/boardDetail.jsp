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
  <script src="/resources/js/jquery-3.3.1.min.js"></script>
  <script>
    //  게시판 목록으로 이동.
    const goBoardList = function() {
      location.href = "/board/list";
    }
    //  게시물 - 삭제
    const deleteBoard = function() {
      let board_seq = $('#board_seq');
      let yn = confirm("게시물을 삭제 하시겠습니까?");
      if( yn ) {
        let params = $('#boardForm').serialize();
        $.ajax({
          url: '/board/deleteBoard',
          data: params,
          dataType: 'JSON',
          cache: false,
          type: 'POST',
          beforeSend: function() {
            console.log( params );
          },
          success: function( res ) {
            if( res != null) {
              if( res.result === 'success' ) {
                alert("게시글 삭제를 성공했습니다.");
                goBoardList();
              } else {
                alert("게시글 삭제를 실패했습니다.");
                return;
              }
            }
          },
          error: function( xhr, status, err ) {
            console.log( ( xhr, status, err ) );
            alert("게시글 삭제를 실패했습니다.");
            return;
          }
        });
      }
    }
  </script>
</head>
<body>
  <h2>게시물 상세</h2>
  <form id="boardForm" name="boardForm">
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
    <input type="hidden" id="board_seq" name="board_seq" value="${board.board_seq}">
    <input type="hidden" id="search_type" name="search_type" value="S"/>
  </form>
  <div class="btn_container">
    <button type="button" onclick="goBoardList();">목록으로</button>
    <button type="button" onclick=""></button>
    <button type="button" onclick="deleteBoard();">삭제하기</button>
  </div>
</body>
</html>
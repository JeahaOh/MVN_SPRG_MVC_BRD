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
  <link rel="stylesheet" href="/resources/css/common.css">
  <title>게시판 목록</title>
  <script>
    // 게시물 tr 클릭 시 게시물 번호를 받아서 게시물 상세 페이지를 요청한다.
    const goBoardDetail = function (boardSeq) {
      location.href = "/board/boardDetail?board_seq=" + boardSeq;
    }
    const goBoardWrite = function() {
      location.href = "/board/boardWrite";
    }
    const goPage = function( pageNo ){
      location.href = location.origin + location.pathname + "?pageNo=" + pageNo;
    }
  </script>
</head>

<body>
  <div id="wrap">
    <div id="container">
      <div id="inner">
        <h2>게시들 목록</h2>
        <form id="boardForm" name="boardForm">
        <table width="100%" class="table01">
          <colgroup>
            <col width="10%"/>
            <col width="25%"/>
            <col width="10%"/>
            <col width="15%"/>
            <col width="20%"/>
          </colgroup>
          <thead>
            <tr>
              <td>글번호</td>
              <td>제목</td>
              <td>작성자</td>
              <td>조회수</td>
              <td>작성일</td>
            </tr>
          </thead>
          <tbody id="tbody">
            <c:choose>
              <c:when test="${fn:length(boardList) <= 0}">
                <tr>
                  <td colspan='5'>등록된 글이 존재하지 않습니다.</td>
                  <td>${fn:length(boardList)}</td>
                </tr>
              </c:when>
              <c:otherwise>
                <c:forEach var="brd" items="${boardList}">
                  <tr onClick="goBoardDetail(${brd.board_seq})" style='cursor:Pointer'>
                    <td>${brd.board_seq}</td>
                    <td>
                      <!-- <c:if test="${brd.board_re_lev > 0}">
                        <c:forEach var="i" begin="1" end="${brd.board_re_lev}">
                          RE:
                        </c:forEach>
                      </c:if> -->
                      ${brd.board_subject}</td>
                    <td>${brd.board_writer}</td>
                    <td>${brd.board_hits}</td>
                    <td>${brd.ins_date}</td>
                  </tr>
                </c:forEach>
              </c:otherwise>
            </c:choose>
          </tbody>
        </table>
      </form>
      <div class="btn_center mt15">
        <button onclick="goPage(${page.totalFirstPage})" class="direction_left01">&lt;&lt;</button>
        <c:forEach var="i" begin="${page.firstPage}" end="${page.lastPage}">
          <c:choose>
            <c:when test="${i eq page.curPage}">
              <button><b>${i}</b></button>
            </c:when>
            <c:otherwise>
              <button onclick="goPage(${i})">${i}</button>
            </c:otherwise>
          </c:choose>
        </c:forEach>
        <button onclick="goPage(${page.totalLastPage})" class="direction_right01">&gt;&gt;</button>
      </div>
      <div class="btn_right mt15">
        <button type="button" class="btn black mr5" onclick="goBoardWrite();">작성하기</button>
      </div>
      </div>
    </div>
  </div>
</body>

</html>
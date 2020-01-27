<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <script src="/resources/js/jquery-3.3.1.min.js"></script>
  <link rel="stylesheet" href="/resources/css/common.css">
  <title>게시물 작성</title>
  <script>
    //  게시판 목록으로 이동.
    const goBoardList = function () {
      location.href = "/board/list";
    }
    const insertBoard = function() {
      let subject = $('#board_subject').val().trim();
      let writer = $('#board_writer').val().trim(); 
      let content = $('#board_content').val().trim();
      console.log( subject.length );
      if( subject.length <= 1 || subject.length >= 50 ) {
        alert("게시물 제목은 1 ~ 50자 이내 이여야 합니다.");
        return false;
      }
      console.log( writer.length );
      if( writer.length <= 1 || writer.length >= 20 ) {
        alert("작성자는 1 ~ 20자 이내 이여야 합니다.");
        return false;
      }
      console.log( content.length );
      if( content.length <= 1 || content.length >= 2000 ) {
        alert("내용은 1 ~ 2000자 이내 이여야 합니다.");
        return false;
      }


      $('#boardForm').submit();
    }
  </script>
</head>

<body>
  <div id="wrap">
    <div id="container">
      <div id="inner">
        <h2>게시물 작성</h2>
        <form id="boardForm" name="boardForm" method="POST" action="/board/insertBoard">
          <table width="100%" class="table02">
            <caption>
              <strong>
                <span class="t_red">*</span> 표시는 필수 입력 항목입니다.
              </strong>
            </caption>
            <colgroup>
              <col width="20%">
              <col width="*">
            </colgroup>
            <tbody id="tbody">
              <tr>
                <th>제목 <span class="t_red"> *</span></th>
                <td>
                  <input type="text" name="board_subject" id="board_subject" class="tbox01">
                </td>
              </tr>
              <tr>
                <th>작성자 <span class="t_red"> *</span></th>
                <td>
                  <input type="text" name="board_writer" id="board_writer" class="tbox01">
                </td>
              </tr>
              <tr>
                <th>내용 <span class="t_red"> *</span></th>
                <td>
                  <textarea name="board_content" id="board_content" class="textarea01" cols="10" rows="5"></textarea>
                </td>
              </tr>
            </tbody>
          </table>
        </form>
        <div class="btn_right mt15">
          <button type="button" class="btn black mr5" onclick="goBoardList();">목록으로</button>
          <button type="button" class="btn black mr5" onclick="insertBoard();">등록하기</button>
        </div>
      </div>
    </div>
  </div>
</body>

</html>
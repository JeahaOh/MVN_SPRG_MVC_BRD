package com.study.brd.board.CTRL;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.study.brd.board.SRVC.BoardService;
import com.study.brd.board.VO.Board;

@Controller
@RequestMapping(value = "/board")
public class BoardController {
  
  private Logger logger = LoggerFactory.getLogger(this.getClass());
  @Autowired
  private BoardService boardService;
  
  /**
   * 게시판 목록 페이지 조회
   * @param request
   * @param response
   * @param model
   * @return
   * @throws Exception
   */
  @RequestMapping(value = "/list")
  public String getBoardList(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
    List<Board> boardList = boardService.getBoardList();
    logger.info(boardList.toString());
    model.addAttribute("boardList", boardList);
    return "board/boardList";
  }
  
  /**
   * 게시물 상세 내용 조회
   * @param request
   * @param response
   * @param model
   * @param board
   * @return
   * @throws Exception
   */
  @RequestMapping(value="/boardDetail")
  public String getBoardDetail(HttpServletRequest request, HttpServletResponse response, Model model, Board board) throws Exception {
    logger.info(board.toString());
    board = boardService.getBoardDetail(board);
    model.addAttribute("board", board);
    return "board/boardDetail";
  }
}

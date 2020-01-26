package com.study.brd.board.CTRL;

import java.util.ArrayList;
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
public class controller {
  
  private Logger logger = LoggerFactory.getLogger(this.getClass());
  @Autowired
  private BoardService boardService;
  
  @RequestMapping(value = "/list")
  public String getBoardList(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
    List<Board> boardList = boardService.getBoardList();
    logger.info(boardList.toString());
    model.addAttribute("boardList", boardList);
//    model.addAttribute("boardList", new ArrayList<Board>());
    return "board/boardList";
  }
}

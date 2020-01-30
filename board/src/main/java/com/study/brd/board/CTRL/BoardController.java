package com.study.brd.board.CTRL;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
   * 
   * @param request
   * @param response
   * @param model
   * @return
   * @throws Exception
   */
  @GetMapping(value = "/list")
  public String getBoardList(HttpServletRequest request, HttpServletResponse response, Model model,
      @RequestParam(name = "pageNo", defaultValue = "1") int currentPageNo,
      @RequestParam(name = "size", defaultValue = "10") int countPerPage) throws Exception {
    
    /**
     * pageNo         : 현재 화면에 출력 되는, 요청 된 페이지 번호.
     * countPerList   : 한 화면에 출력 될 페이지 수.
     * countPerPage   : 한 화면에 출력 될 게시물의 수.
     * totalListCount : 총 게시물의 수.
     * totalPageCount : 총 페이지의 수.
     * firstPage      : 현재 화면에서의 첫 페이지 번호.
     * lastPage       : 현재 화면에서의 마지막 페이지 번호.
     */
    
    if( currentPageNo < -1 ) currentPageNo = 1;
    if( countPerPage <= 5 || countPerPage > 10 ) countPerPage = 5;
    
    int totalListCount = boardService.getBoardCnt();

    
    HashMap<String, Object> pagination = new HashMap<>();
    pagination.put( "rowNo", (currentPageNo - 1) * countPerPage );
    pagination.put( "size", countPerPage );
    
    int countPerList = 10;
    int totalPageCount = totalListCount / countPerPage;
    if( totalListCount % countPerList > 0 ) totalPageCount = totalPageCount + 1;
    int firstPage = (((currentPageNo - 1) / countPerPage) * countPerPage ) + 1;
    int lastPage = firstPage + countPerList - 1;
    if( lastPage > totalPageCount ) lastPage = totalPageCount - 1 ;
    
    
    
    
    
    List<Board> boardList = boardService.getBoardList( pagination );
    logger.info(boardList.size() + "");
    

    
    
    model.addAttribute("boardList", boardList);
    
    logger.info("cnt : {}, size : {}, pageNo : {}", totalListCount, countPerPage, currentPageNo);
    logger.info( "totalPageCount : {}", totalPageCount );
    logger.info( "firstPage : {}, lastPage : {}", firstPage, lastPage );
    return "/board/boardList";
  }

  /**
   * 게시물 상세 내용 조회
   * 
   * @param request
   * @param response
   * @param model
   * @param board
   * @return
   * @throws Exception
   */
  @RequestMapping(value = "/boardDetail")
  public String getBoardDetail(HttpServletRequest request, HttpServletResponse response,
      Model model, Board board) throws Exception {
    logger.info(board.toString());
    board = boardService.getBoardDetail(board);
    model.addAttribute("board", board);
    return "board/boardDetail";
  }

  /**
   * 게시불 삭제
   * 
   * @param board
   * @return
   * @throws Exception
   */
  @RequestMapping(value = "/deleteBoard")
  @ResponseBody
  public Map<String, String> deleteBoard(Board board) throws Exception {
    return boardService.deleteBoard(board);
  }

  /**
   * 게시물 작성페이지 이동
   * 
   * @param request
   * @param response
   * @return
   * @throws Exception
   */
  @RequestMapping(value = "boardWrite")
  public String writeBoard(HttpServletRequest request, HttpServletResponse response, Model model)
      throws Exception {
    model.addAttribute("status", "write");
    return "board/boardWrite";
  }

  /**
   * 게시물 작성
   * 
   * @param request
   * @param response
   * @param model
   * @param board
   * @return
   * @throws Exception
   */
  @RequestMapping(value = "insertBoard", method = RequestMethod.POST)
  public String insertBoard(HttpServletRequest request, HttpServletResponse response, Model model,
      @ModelAttribute Board board) throws Exception {
    logger.info(board.toString());
    boardService.insertBoard(board);

    return "redirect:/board/boardDetail?board_seq=" + board.getBoard_seq();
  }

  @RequestMapping(value = "boardUpdate", method = RequestMethod.GET)
  public String updateBoardPage(HttpServletRequest request, HttpServletResponse response,
      Model model, Board board) throws Exception {
    logger.info(board.toString());
    board = boardService.getBoardDetail(board);
    model.addAttribute("board", board);
    model.addAttribute("status", "edit");
    return "board/boardWrite";
  }

  @RequestMapping(value = "boardUpdate", method = RequestMethod.POST)
  public String updateBoardReq(HttpServletRequest request, HttpServletResponse response,
      Model model, @ModelAttribute Board board) throws Exception {
    logger.info(board.toString());
    boardService.updateBoard(board);
    return "redirect:/board/boardDetail?board_seq=" + board.getBoard_seq();
  }
}

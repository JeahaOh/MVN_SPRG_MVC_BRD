package com.study.brd.board.SRVC;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.study.brd.board.DAO.BoardDAO;
import com.study.brd.board.VO.Board;

@Service
public class BoardServiceImpl implements BoardService {

  private Logger logger = LoggerFactory.getLogger(this.getClass());
  @Autowired
  private BoardDAO boardDao;
  
  @Override
  public List<Board> getBoardList() throws Exception {
    return boardDao.getBoardList();
  }
  
  @Override
  public Board getBoardDetail(Board board) throws Exception {
    logger.info(board.toString());
    if( board.getSearch_type() != null && !board.getSearch_type().toLowerCase().equals("s") ) {
      logger.info("board.search_type : " + boardDao.updateBoardHits(board) );
    }
    return boardDao.getBoardDetail(board);
  }

  @Override
  public Map<String, String> deleteBoard(Board board) throws Exception {
    logger.info(board.toString());
    Map<String,String> result = new HashMap<String, String>();
    if( boardDao.deleteBoard(board) > 0 ) {
      result.put("result", "success");
    } else {
      result.put("result", "fail");
    }
    
    return result;
  }

  @Override
  public Map<String, String> insertBoard(Board board) throws Exception {
    int boardNo = boardDao.insertBoard( board );
    System.out.println(boardNo);
    return null;
  }

}

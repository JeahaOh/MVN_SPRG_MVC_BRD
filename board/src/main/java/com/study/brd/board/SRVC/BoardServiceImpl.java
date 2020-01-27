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
  public void insertBoard(Board board) throws Exception {
    boardDao.insertBoard( board );
  }

  @Override
  public void updateBoard(Board board) throws Exception {
    boardDao.updateBoard(board);
  }

}

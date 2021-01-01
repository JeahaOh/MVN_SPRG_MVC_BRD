package com.study.brd.board.SRVC;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.study.brd.board.DAO.BoardDAO;
import com.study.brd.board.VO.Board;

@Service
@Transactional
public class BoardServiceImpl implements BoardService {

  private Logger logger = LoggerFactory.getLogger(this.getClass());
  @Autowired
  private BoardDAO boardDao;
  
  @Override
  public List<Board> getBoardList( HashMap<String, Object> params ) throws Exception {
    return boardDao.getBoardList( params );
  }
  
  @Override
  public int getBoardCnt() throws Exception {
    return boardDao.getBoardCnt();
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
  @Transactional
  public void insertBoard(Board board) throws Exception {
    boardDao.insertBoard( board );
//    boardDao.insertBoardFail( board );
  }

  @Override
  public void updateBoard(Board board) throws Exception {
    boardDao.updateBoard(board);
  }

  @Override
  public Board insertBoardReply(Board board) throws Exception {
    int insertCnt = 0;
    logger.info( board.toString() );
    board = boardDao.getBoardReplyInfo(board);
    logger.info( board.toString() );


    // insertCnt += boardDao.updateBoardReSeq(board);
    // insertCnt += boardDao.insertBoardReply(board);

    if( insertCnt > 0 ) {
      return board;
    } else {
      return null;
    }
  }
}

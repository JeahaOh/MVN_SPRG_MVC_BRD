package com.study.brd.board.SRVC;

import java.util.List;
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
    logger.info(boardDao.updateBoardHits(board) + "");
    return boardDao.getBoardDetail(board);
  }

}

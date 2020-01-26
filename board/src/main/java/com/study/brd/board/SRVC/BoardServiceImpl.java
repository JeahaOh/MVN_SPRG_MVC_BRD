package com.study.brd.board.SRVC;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.study.brd.board.DAO.BoardDAO;
import com.study.brd.board.VO.Board;

@Service
public class BoardServiceImpl implements BoardService {

  @Autowired
  private BoardDAO boardDao;
  @Override
  public List<Board> getBoardList() throws Exception {
    return boardDao.getBoardList();
  }

}

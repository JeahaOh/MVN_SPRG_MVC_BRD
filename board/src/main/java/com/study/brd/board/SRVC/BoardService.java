package com.study.brd.board.SRVC;

import java.util.List;
import com.study.brd.board.VO.Board;

public interface BoardService {
  public List<Board> getBoardList() throws Exception;
}

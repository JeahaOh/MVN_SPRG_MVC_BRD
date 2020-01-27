package com.study.brd.board.SRVC;

import java.util.List;
import java.util.Map;
import com.study.brd.board.VO.Board;

public interface BoardService {
  public List<Board> getBoardList() throws Exception;
  public Board getBoardDetail(Board board) throws Exception;
  public Map<String, String> deleteBoard(Board board) throws Exception;
  public void insertBoard(Board board) throws Exception;
  public void updateBoard(Board board) throws Exception;
}

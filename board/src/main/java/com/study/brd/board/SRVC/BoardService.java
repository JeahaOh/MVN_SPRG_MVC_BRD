package com.study.brd.board.SRVC;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.transaction.annotation.Transactional;
import com.study.brd.board.VO.Board;

@Transactional
public interface BoardService {
  public int getBoardCnt() throws Exception;
  public List<Board> getBoardList( HashMap<String, Object> param ) throws Exception;
  public Board getBoardDetail(Board board) throws Exception;
  public Map<String, String> deleteBoard(Board board) throws Exception;
  public void insertBoard(Board board) throws Exception;
  public void updateBoard(Board board) throws Exception;
}

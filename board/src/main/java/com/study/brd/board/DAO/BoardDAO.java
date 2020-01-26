package com.study.brd.board.DAO;

import java.util.List;
import javax.annotation.Resource;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import com.study.brd.board.VO.Board;

@Repository
public class BoardDAO {
  private Logger logger = LoggerFactory.getLogger(this.getClass());
  
  @Resource(name="sqlSession")
  private SqlSession sqlSession;
  
  private static final String NAMESPACE = "com.study.brd.board.DAO.BoardDAO";
  
  public List<Board> getBoardList() throws Exception {
    return sqlSession.selectList(NAMESPACE + ".getBoardList");
  }
  
  public Board getBoardDetail(Board board) throws Exception {
    logger.info(String.valueOf(board.getBoard_seq()));
    return sqlSession.selectOne(NAMESPACE + ".getBoardDetail", board);
  }
  
  public int updateBoardHits(Board board) throws Exception {
    return sqlSession.update(NAMESPACE + ".updateBoardHits", board);
  }
}

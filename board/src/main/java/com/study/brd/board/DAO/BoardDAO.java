package com.study.brd.board.DAO;

import java.util.List;
import javax.annotation.Resource;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import com.study.brd.board.VO.Board;

@Repository
public class BoardDAO {
  @Resource(name="sqlSession")
  private SqlSession sqlSession;
  
  private static final String NAMESPACE = "com.study.brd.board.DAO.BoardDAO";
  
  public List<Board> getBoardList() throws Exception {
    return sqlSession.selectList(NAMESPACE + ".getBoardList");
  }
}

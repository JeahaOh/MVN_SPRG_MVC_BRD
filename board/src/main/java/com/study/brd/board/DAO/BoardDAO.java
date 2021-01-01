package com.study.brd.board.DAO;

import java.util.HashMap;
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
  
  public int getBoardCnt() throws Exception {
    return sqlSession.selectOne(NAMESPACE + ".getBoardCnt");
  }
  
  public List<Board> getBoardList( HashMap<String, Object> params ) throws Exception {
    return sqlSession.selectList( NAMESPACE + ".getBoardList", params );
  }
  
  public Board getBoardDetail(Board board) throws Exception {
    logger.info(String.valueOf(board.getBoard_seq()));
    logger.info(board.getSearch_type());
    if( board.getSearch_type() == null ) {
      sqlSession.update(NAMESPACE + ".updateBoardHits", board);
    }
    return sqlSession.selectOne(NAMESPACE + ".getBoardDetail", board);
  }
  
  public int updateBoardHits(Board board) throws Exception {
    return sqlSession.update(NAMESPACE + ".updateBoardHits", board);
  }
  
  public int deleteBoard(Board board) throws Exception {
    return sqlSession.delete(NAMESPACE + ".deleteBoard", board);
  }
  
  public int insertBoard(Board board) throws Exception {
    sqlSession.insert(NAMESPACE + ".insertBoard", board);
    return board.getBoard_seq();
  }
  
  public int insertBoardFail(Board board) throws Exception {
    sqlSession.insert(NAMESPACE + ".insertBoardFail", board);
    return board.getBoard_seq();
  }
  
  public void updateBoard(Board board) throws Exception {
    sqlSession.update(NAMESPACE + ".updateBoard", board);
  }
  public void updateBoardFail(Board board) throws Exception {
    sqlSession.update(NAMESPACE + ".updateBoardFail", board);
  }

  /**
   * 게시물 답글 정보 조회
   * @param board
   * @return
   * @throws Exception
   */
  public Board getBoardReplyInfo(Board board) throws Exception {
    return sqlSession.selectOne(NAMESPACE + ".getBoardReplyInfo", board);
  }

  /**
   * 게시물 답글의 순서 수정
   * @param board
   * @return
   * @throws Exception
   */
  public int updateBoardReSeq(Board board) throws Exception {
    return sqlSession.update(NAMESPACE + ".updateBoardReSeq");
  }

  public int insertBoardReply(Board board) throws Exception {
    return sqlSession.insert(NAMESPACE + ".insertBoardRepsly", board);
  }
}

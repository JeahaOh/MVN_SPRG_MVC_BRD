package com.study.brd;

import java.sql.Connection;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/*.xml"})
public class DataSourceTest {
  protected final Logger logger = LoggerFactory.getLogger(this.getClass());

  @Inject
  private DataSource dataSource;

  @Test
  public void dataSourceConnectionTest() throws Exception {
    logger.info("========================================== DataSource Connection TEST START ==========================================");
    Connection conn = null;

    try {
      conn = dataSource.getConnection();
      logger.info("\n\t!! connection SUCCESS: [{}]!!", conn);
    } catch( Exception e ) {
      logger.error("\n\t!! connection FAIL: [{}]!!", conn);
      e.getMessage();
    }
    logger.info("========================================== DataSource Connection TEST E N D ==========================================");
  }
}

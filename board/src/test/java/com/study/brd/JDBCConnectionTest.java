package com.study.brd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JDBCConnectionTest {
  protected final Logger logger = LoggerFactory.getLogger(this.getClass());
  
//  private static final String DRIVER    = "org.mariadb.jdbc.Driver";
//  private static final String URL       = "jdbc:mariadb://localhost:3306/test";
  private static final String DRIVER    = "net.sf.log4jdbc.sql.jdbcapi.DriverSpy";
  private static final String URL       = "jdbc:log4jdbc:mariadb://localhost:3306/test";
  private static final String USERNAME  = "root";
  private static final String PASSWORD  = "1111";
  
  @Test
  public void getSQLConnectionTest() {
    System.out.println("========================================== MariaDB Connection TEST START ==========================================");

    Connection conn = null;
    Statement stmt = null;
    
    try {
      Class.forName(DRIVER);
      
      conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
      stmt = conn.createStatement();
      
      String sql = "SELECT VERSION() AS VER";
      
      ResultSet rs = stmt.executeQuery(sql);
      
      while( rs.next() ) {
        String version = rs.getString("VER");
        
        logger.info(version);
      }
      
      rs.close();
      stmt.close();
      conn.close();
      
      
    } catch(SQLException sqlErr) {
      sqlErr.printStackTrace();
    } catch(Exception e) {
      e.printStackTrace();
    } finally {
      
      try {
        if( stmt != null ) {
          stmt.close();
        }
      } catch( SQLException sqlerr) {
        sqlerr.printStackTrace();
      }
      
      try {
        if( conn != null ) {
          conn.close();
        }
      } catch( SQLException sqlerr) {
        sqlerr.printStackTrace();
      }
      
    }
    
    System.out.println("========================================== MariaDB Connection TEST END ==========================================");
  }
}

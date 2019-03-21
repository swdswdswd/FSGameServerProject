package com.fsgame.dao;

/**
 *@author sunweidong
 *@category 连接数据库工具类
 */
import java.sql.*;
public class DBUtil{
    static final String DB_URL = "jdbc:mysql://localhost:3306/fsgame?serverTimezone=GMT%2B8";
    static final String USER = "root";
    static final String PASS = "123456";
    
    Connection conn = null;
    Statement stmt = null;
    ResultSet resultSet = null;
    
    /**
     * @author sunweidong
     * @category 与数据库建立连接
     * */
    public Connection ConnectDB() {
    	try {
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	if (conn != null) {
    		return conn;
		}
		return null;
    }
    
    
    /**
     * @author sunweidong 
     * @category 操作完成 断开连接
     * */
    public void DisConnectDB() {
    	if(stmt != null)
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
    	if(conn != null)
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
    }
    
    /**
     * @author sunweidong
     * @category 建立一个sql数据连接操作对象
     * */
    public Statement createStatement() {
    	try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	if (stmt != null) {
    		return stmt;
		}
		return null;
	}
    
    /**
     * @author sunweidong
     * @category 建立一个查询连接操作对象
     * */
    public ResultSet createResultSet() {
    	
		return resultSet;
	}
}

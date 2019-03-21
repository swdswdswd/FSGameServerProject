package com.fsgame.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.fsgame.db.FSPlayerInfo;

/**
 * @author sunweidong
 * @category 所有的DB操作都在这个类中进行
 */
public class MySQLDBHelper {
	
	/**
     * @author sunweidong
	 * @throws SQLException 
     * @category 登录游戏
     * */
    public static FSPlayerInfo loginGame(String userName, String passWord) {
    	FSPlayerInfo playerInfo = null;
    	if (userName.length() == 0 || passWord.length() == 0) {
    		return null;			
		}
    	DBUtil dbUtil = new DBUtil();
    	dbUtil.ConnectDB();
        Statement stmt = dbUtil.createStatement();
    	String sql = "SELECT * FROM player WHERE username = '" + userName + "' AND password = '" + passWord + "'";
    	ResultSet rs = null;
		try {
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				playerInfo = new FSPlayerInfo();
				playerInfo.setPlayerBaseId(rs.getInt("baseid"));
				playerInfo.setPlayerName(rs.getString("username"));
				playerInfo.setHp(100.0f);
				playerInfo.setX(rs.getFloat("locationx"));
				playerInfo.setY(rs.getFloat("locationy"));
				playerInfo.setZ(rs.getFloat("locationz"));
				playerInfo.setO(rs.getFloat("locationo"));
				playerInfo.setMapId(0);
			}
			
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
    	//如果玩家信息不存在就创建一个
    	if (playerInfo == null) {
    		sql = "INSERT INTO player(username,passWord,nickname,locationx,locationy,locationz,locationo)VALUES(" 
    				+ "'" + userName + "' , '" + passWord + "','defaultName' ,'700.00','180.00','-670.00','0.00')";
    		stmt = dbUtil.createStatement();
    		try {
				stmt.executeUpdate(sql);
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
    		
    		playerInfo = loginGame(userName, passWord);
		}
    	dbUtil.DisConnectDB();
    	return playerInfo;
    }
    
    /**
     * @author sunweidong
     * @param player 
     * @category 保存玩家的离线数据
     * */
    public static void savePlayer(FSPlayerInfo player) {
		if (player != null) {
			DBUtil dbUtil = new DBUtil();
	    	dbUtil.ConnectDB();
	        Statement stmt = dbUtil.createStatement();
	    	String sql = "UPDATE player SET locationx = '" + player.getX() + "' ,locationy = '" + player.getY() + "' , locationz = '"
	    			+ player.getZ() + "' , locationo = '" + player.getO() + "' WHERE baseid = '" + player.getPlayerBaseId() + "'";
	    	stmt = dbUtil.createStatement();
	    	
	    	try {
				stmt.executeUpdate(sql);
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	    	
	    	dbUtil.DisConnectDB();
		}
	}
    
}

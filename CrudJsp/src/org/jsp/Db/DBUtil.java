package org.jsp.Db;

import java.sql.*;

public class DBUtil {
	private static Connection con;
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			try {
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jspcrut?user=root&password=root");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public PreparedStatement createPST(String sql) throws SQLException {
		PreparedStatement pst = con.prepareStatement(sql);
		return pst;
	}
	public void update(PreparedStatement pst) throws SQLException
	{
		pst.executeUpdate();
	}
}

package org.news.dao;
import org.news.util.*;
import java.sql.*;
//import javax.naming.*;
//import javax.sql.*;
//数据库连接与关闭操作工具类
public class BaseDao {
	private static final ConfigManager config = ConfigManager.getInstance();
	private static final String driver = config.getProperty("driver");
	private static final String url = config.getProperty("url");
	private static final String username = config.getProperty("username");
	private static final String password = config.getProperty("password");
	// 加载数据库驱动
	static {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	protected Connection conn = null;
	protected PreparedStatement pstmt = null;
	protected ResultSet rs = null;
	// 获取数据库连接对象
	public Connection getConnection() throws Exception {
		if (conn == null || conn.isClosed()) {
			// 获取与逻辑名相关联的数据源对象
			// Context ctx = new InitialContext();
			// DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/news");
			// conn = ds.getConnection();
			conn = DriverManager.getConnection(url, username, password);
		}
		return conn;
	}
	// 关闭数据库资源
	/*
	 * 参数: 1. Connection conn 2. Statement stmt 3. ResultSet rs 返回值:无
	 */
	public void closeAll(Connection conn, Statement stmt, ResultSet rs) throws SQLException {
		if (rs != null) {
			rs.close();
		}
		if (stmt != null) {
			stmt.close();
		}
		if (conn != null) {
			conn.close();
		}
	}
	/*
	 * 参数: 1. String preparedSql 预编译的SQL语句 2. Object... param 为sql语句提供的参数
	 * 返回值:int影响的行数
	 */
	public int executeUpdate(String preparedSql, Object... param) throws Exception {
		int n = 0;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(preparedSql);
			for (int i = 0; i < param.length; i++) {
				pstmt.setObject(i + 1, param[i]);
			}
			n = pstmt.executeUpdate();
		} finally {
			closeAll(conn, pstmt, rs);
		}
		return n;
	}
	/*
	 * 参数: 1. String preparedSql 预编译的SQL语句 2. Object... param 为sql语句提供的参数 返回值:
	 * ResultSet 查询结果集
	 */
	public ResultSet executeQuery(String preparedSql, Object... param) throws Exception {
		conn = getConnection();
		pstmt = conn.prepareStatement(preparedSql);
		for (int i = 0; i < param.length; i++) {
			pstmt.setObject(i + 1, param[i]);
		}
		rs = pstmt.executeQuery();
		return rs;
	}
}

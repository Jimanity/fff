package Jdbc;
import java.sql.*;
/**
 * sql工具包
 * @author Jimanity
 * 2019-5-5
 */
public class JdbcUtil {
	public static final String ORACLEDRIVER="oracle.jdbc.driver.OracleDriver";
	public static final String USERNAME="jimanity";
	public static final String PASSWORD="l531757933";
	public static final String URL="jdbc:oracle:thin:@127.0.0.1:1521:xe";
	//加载驱动
	static {
		try {
			Class.forName(ORACLEDRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//获取连接
	public static Connection getConnection() {
		Connection con=null;
		try {
			con=DriverManager.getConnection(URL,USERNAME,PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	//实务处理
	public static void transactionController(Connection con) {
		try {
			con.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//提交事务
	public static void comitTransaction(Connection con) {
		try {
			con.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//回滚事务
	public static void rollbackTransaction(Connection con) {
		try {
			con.rollback();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//结果集处理

	//释放资源
	public static void release(Connection con,Statement sta,ResultSet rs) {
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(sta!=null) {
			try {
				sta.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

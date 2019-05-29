package Jdbc;
import java.sql.*;
/**
 * sql���߰�
 * @author Jimanity
 * 2019-5-5
 */
public class JdbcUtil {
	public static final String ORACLEDRIVER="oracle.jdbc.driver.OracleDriver";
	public static final String USERNAME="jimanity";
	public static final String PASSWORD="l531757933";
	public static final String URL="jdbc:oracle:thin:@127.0.0.1:1521:xe";
	//��������
	static {
		try {
			Class.forName(ORACLEDRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//��ȡ����
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
	//ʵ����
	public static void transactionController(Connection con) {
		try {
			con.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//�ύ����
	public static void comitTransaction(Connection con) {
		try {
			con.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//�ع�����
	public static void rollbackTransaction(Connection con) {
		try {
			con.rollback();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//���������

	//�ͷ���Դ
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

package Jdbc;

import java.sql.*;

public class test1 {

	public static void main(String[] args) throws ClassNotFoundException {
		String sql="create table wj_user(id number(10) primary key,name varchar2(10))";
		String sql1="insert into wj_user values(3,'chenwen')";
		String sql2="select * from wj_user";
		//1.��������
		String driver="oracle.jdbc.driver.OracleDriver";
		Class.forName(driver);
		//2.����URLЭ��
		String oracleURL="jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Connection con=null;
		Statement sta=null;
		ResultSet rs=null;
		try {
			//3.��������
			con=DriverManager.getConnection(oracleURL,"jimanity","l531757933");
//			System.out.print(con);
			//4.����Statement ��������ִ��sql
			sta=con.createStatement();
			//5.ִ��sql
			rs=sta.executeQuery(sql2);
			StringBuffer sb=new StringBuffer(); 
			//6.������
			while(rs.next()) {
				sb.append("id:"+rs.getInt("id")+"");
				sb.append("name:"+rs.getString("name")+"\n");
			}
			System.out.print(sb.toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//�ر���Դ
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

}

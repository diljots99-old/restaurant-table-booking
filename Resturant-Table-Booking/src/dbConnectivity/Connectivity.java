package dbConnectivity;

import java.sql.DriverManager;

import javax.swing.JOptionPane;

import java.sql.Connection;


public class Connectivity {
	public static String HostUrl="jdbc:mysql://sql12.freesqldatabase.com:3306/sql12286322";
	public static String user="sql12286322";
	public static String pass="sukhbirsingh1234";
	public static boolean Status=false;
	public static Connection dbConnect() {
		Connection con=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			con=DriverManager.getConnection(HostUrl,user,pass);//Universal
			
			//con=DriverManager.getConnection("jdbc:mysql://sql12.freesqldatabase.com:3306/sql12278903","sql12278903","root");//freesqldatabase.com
			//con=DriverManager.getConnection("jdbc:mysql://movie.csdstgnin8g7.us-east-2.rds.amazonaws.com:3306/","root","password");//Amazon Web Services
			//con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Movie","root","root");//offline
			System.out.println(con);
			Status=true;
		}catch (Exception e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(null,"Exception Occurred \n Check Internet or Server Connection\n"
					+ "Server Might be Unable try Another\n"+e);

		}
		return con;		
	}

}

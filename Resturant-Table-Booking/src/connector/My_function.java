package connector;

import java.sql.*;

import dbConnectivity.Connectivity;

public class My_function {

	public static String empName;
	public static String panelName;

	public static boolean newemp(String employee_Name, String email_Id, String mobile_No, String address,
			String position, String marital_Status, String gender, String DOB, String state, String salary,
			String aadhar_No, String password) {
		boolean	status=false;
		try {
			int i=0;
			Connection con=Connectivity.dbConnect();
		    String qry="insert into Employee(employee_Name,email_Id,mobile_No,address,position,marital_Status,gender,password,DOB,state,salary,aadhar_No)" + 
		    		" values(?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement pst=con.prepareStatement(qry);
			pst.setString(1, employee_Name);
			pst.setString(2, email_Id);
			pst.setString(3, mobile_No);
			pst.setString(4, address);
			pst.setString(5, position);
			pst.setString(6, marital_Status);
			pst.setString(7, gender);
			pst.setString(8, password);
			pst.setString(9, DOB);
			pst.setString(10, state);
			pst.setString(11, salary);
			pst.setString(12, aadhar_No);
			System.out.println(qry);
			i=pst.executeUpdate();
			System.out.println(qry);
			if(i>0)
				 status=true;
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return status;
	}

		public static boolean verifyUser(String user, String pass, String panel) {
			boolean status=false;
			Connection con=null;
			try {
				if(panel.equals("Admin")) {
				con=dbConnectivity.Connectivity.dbConnect();
				String qry="select * from "+panel+" where User='"+user+"'  and Password='"+pass+"'";
				//String qry="select * from here where User='"+user+"'  and Password='"+pass+"'";
				empName=user;
				panelName=panel;
				Statement st=con.createStatement();
				ResultSet rst=st.executeQuery(qry);
				status=rst.next();
				System.out.println(status);
				}
				else if(panel.equals("Employee")) {
					con=dbConnectivity.Connectivity.dbConnect();
					String qry="select * from "+panel+" where Employee_name='"+user+"'  and Password='"+pass+"'";
					empName=user;
					panelName=panel;
					Statement st=con.createStatement();
					ResultSet rst=st.executeQuery(qry);
					status=rst.next();
					System.out.println(status);
					
				}
				else if(panel.equals("Customer")) {
					con=dbConnectivity.Connectivity.dbConnect();
					String qry="select * from customer where username='"+user+"'  and password='"+pass+"'";
					empName=user;
					panelName=panel;
					Statement st=con.createStatement();
					ResultSet rst=st.executeQuery(qry);
					status=rst.next();
					System.out.println(status);
					
				}
				} catch (Exception e) {
				System.out.println(e);
			}
			return status;
	}

		public static boolean newreg(String username, String password, String mobile, String email, String dOB,
				String gender) {
			boolean	status=false;
			try {
				int i=0;
				Connection con=dbConnectivity.Connectivity.dbConnect();
			    String qry="insert into customer(username,password,mobile,email,dob,gender)" + 
			    		" values(?,?,?,?,?,?)";
				PreparedStatement pst=con.prepareStatement(qry);
				pst.setString(1, username);
				pst.setString(2, password);
				pst.setString(3, mobile);
				pst.setString(4, email);
				pst.setString(5, dOB);
				pst.setString(6, gender);
				
				System.out.println(qry);
				i=pst.executeUpdate();
				System.out.println(qry);
				if(i>0)
					 status=true;
				
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			return status;
		}

}

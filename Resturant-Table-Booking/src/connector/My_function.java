package connector;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JToggleButton;

import dbConnectivity.Connectivity;
import views.NewBooking;
import views.UpdateModify;

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

		public static boolean confirmBooking(String bookingName, String bookingDate, String bookingTime,
				String selectedTable, String price, String noPeople) {
			boolean	status=false;
			try {
				int i=0;
				Connection con=dbConnectivity.Connectivity.dbConnect();
			    String qry="insert into Booking(BookingName,BookingDate,BookingTime,SelectedTable,Price,noPeople)" + 
			    		" values(?,?,?,?,?,?)";
				PreparedStatement pst=con.prepareStatement(qry);
				pst.setString(1, bookingName);
				pst.setString(2, bookingDate);
				pst.setString(3, bookingTime);
				pst.setString(4, selectedTable);
				pst.setString(5, price);
				pst.setString(6, noPeople);
				
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

		public static String getCustomerID(String bookingName, String bookingDate, String bookingTime,
				String selectedTable, String price, String noPeople) {
			String CustID="";
			try{
				Connection con=dbConnectivity.Connectivity.dbConnect();
				String qry="select CustomerID from Booking where BookingName='"+bookingName+"' and BookingDate='"+bookingDate+"' and BookingTime='"+bookingTime+"' and SelectedTable='"+selectedTable+"' and Price='"+price+"' and noPeople ='"+noPeople+"'";
				System.out.println(qry);
				Statement st=con.createStatement();
				ResultSet rst=st.executeQuery(qry);
				if(rst.next())
				CustID=rst.getString(1);
				System.out.println(CustID);
				// TODO Auto-generated method stub
				
		}catch (Exception e) {
			System.out.println(e);
		}
			return CustID;
		}

	
		public static List<String> getBookedTables(String time, String date) {
			List<String> BookedTable = new ArrayList<String>();
			String bookedtable=null;
			try {
				
				Connection con=dbConnectivity.Connectivity.dbConnect();
				String qry="select SelectedTable from Booking where BookingDate='"+date+"' and BookingTime='"+time+"'";
				System.out.println(qry);
				Statement st=con.createStatement();
				ResultSet rst=st.executeQuery(qry);
				boolean Status=true;
				while(rst.next())
				{	bookedtable=null;
					bookedtable=rst.getString("SelectedTable");
					if(bookedtable.contentEquals("Table0")){
						NewBooking.Table0.disable();
						NewBooking.Table0.setEnabled(false);;
						Status=true;
					}
					if(bookedtable.contentEquals("Table1")){
						NewBooking.Table1.disable();
						NewBooking.Table1.setEnabled(false);
						Status=true;
					}
					if(bookedtable.contentEquals("Table2")){
						NewBooking.Table2.disable();
						NewBooking.Table2.setEnabled(false);
						Status=true;
					}
					if(bookedtable.contentEquals("Table3")){
						NewBooking.Table3.disable();
						NewBooking.Table3.setEnabled(false);
						Status=true;
					}
					
					if(bookedtable.contentEquals("Table4")){
						NewBooking.Table4.disable();
						NewBooking.Table4.setEnabled(false);
						Status=true;
					}
					
					if(bookedtable.contentEquals("Table5")){
						NewBooking.Table5.disable();
						NewBooking.Table5.setEnabled(false);
						Status=true;
					}
					
					if(bookedtable.contentEquals("Table6")){
						NewBooking.Table6.disable();
						NewBooking.Table6.setEnabled(false);
						Status=true;
					}
					
					if(bookedtable.contentEquals("Table7")){
						NewBooking.Table7.disable();
						NewBooking.Table7.setEnabled(false);
						Status=true;
					}
					
					
					if(bookedtable.contentEquals("Table8")){
						NewBooking.Table8.disable();
						NewBooking.Table8.setEnabled(false);
						Status=true;
					}
					if(bookedtable.contentEquals("Table9")){
						NewBooking.Table9.disable();
						NewBooking.Table9.setEnabled(false);
						Status=true;
					}
					if(bookedtable.contentEquals("Table10")){
						NewBooking.Table10.disable();
						NewBooking.Table10.setEnabled(false);
						Status=true;
					}
					if(bookedtable.contentEquals("Table11")){
						NewBooking.Table11.disable();
						NewBooking.Table11.setEnabled(false);
						Status=true;	
					}
					if(bookedtable.contentEquals("Table12")){
						NewBooking.Table12.disable();
						NewBooking.Table12.setEnabled(false);
						Status=true;
					}
					if(bookedtable.contentEquals("Table13")){
						NewBooking.Table13.disable();
						NewBooking.Table13.setEnabled(false);
						Status=true;
					}
					if(bookedtable.contentEquals("Table14")){
						NewBooking.Table14.disable();
						NewBooking.Table14.setEnabled(false);
						Status=true;
					}
				}
					
								
			} catch (Exception e) {
				System.out.println(e);
			}
			return BookedTable;
		}

		public static boolean cancelBooking(String bookingName, String bookingID) {
			boolean	status=false;
			try {
				int i=0;
				Connection con=dbConnectivity.Connectivity.dbConnect();
			    String qry="Delete from Booking where BookingName = ? or CustomerID=?";
				PreparedStatement pst=con.prepareStatement(qry);
				pst.setString(1, bookingName);
				pst.setString(2, bookingID);
				i=pst.executeUpdate();
				if(i>0)
					 status=true;
				
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			return status;
			
		}

		public static boolean Modify(String bookingName, String bookingID) {
			boolean	status=false;
			try {
				int i=0;
				Connection con=dbConnectivity.Connectivity.dbConnect();
			    String qry="Update from Booking where BookingName = ? or CustomerID=?";
				PreparedStatement pst=con.prepareStatement(qry);
				pst.setString(1, bookingName);
				pst.setString(2, bookingID);
				i=pst.executeUpdate();
				if(i>0)
					 status=true;
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			return status;
		}

		public static void getUpdateTables(String date, String time) {
			
			String bookedtable=null;
			try {
				
				Connection con=dbConnectivity.Connectivity.dbConnect();
				String qry="select SelectedTable from Booking where BookingDate='"+date+"' and BookingTime='"+time+"'";
				System.out.println(qry);
				Statement st=con.createStatement();
				ResultSet rst=st.executeQuery(qry);
				boolean Status=true;
				while(rst.next())
				{	bookedtable=null;
					bookedtable=rst.getString("SelectedTable");
					if(bookedtable.contentEquals("Table0")){
						int i=0;
						UpdateModify.removeTables(i);						
					}
					if(bookedtable.contentEquals("Table1")){
						int i=1;
						UpdateModify.removeTables(i);
					}
					if(bookedtable.contentEquals("Table2")){
						int i=2;
						UpdateModify.removeTables(i);
					}
					if(bookedtable.contentEquals("Table3")){
						int i=3;
						UpdateModify.removeTables(i);
					}
					
					if(bookedtable.contentEquals("Table4")){
						int i=4;
						UpdateModify.removeTables(i);
					}
					
					if(bookedtable.contentEquals("Table5")){
						int i=5;
						UpdateModify.removeTables(i);
					}
					
					if(bookedtable.contentEquals("Table6")){
						UpdateModify.removeTables(6);
					}
					
					if(bookedtable.contentEquals("Table7")){
						UpdateModify.removeTables(7);
					}
					if(bookedtable.contentEquals("Table8")){
						UpdateModify.removeTables(8);
					
					}
					if(bookedtable.contentEquals("Table9")){
						UpdateModify.removeTables(9);
					}
					if(bookedtable.contentEquals("Table10")){
						UpdateModify.removeTables(10);
					}
					if(bookedtable.contentEquals("Table11")){
						UpdateModify.removeTables(11);
					}
					if(bookedtable.contentEquals("Table12")){
						UpdateModify.removeTables(12);
					}
					if(bookedtable.contentEquals("Table13")){
						UpdateModify.removeTables(13);
					}
					if(bookedtable.contentEquals("Table14")){
						UpdateModify.removeTables(14);
					}
				}
					
								
			} catch (Exception e) {
				System.out.println(e);
			}
			
		}

		public static boolean updateBooking(String bid, String bname, String btime, String bdate, String table) {
			boolean	status=false;
			try {
				int i=0;
				Connection con=dbConnectivity.Connectivity.dbConnect();
			    String qry="Update Booking "
			    		+ "set BookingName=?,BookingDate=?,BookingTime=?,SelectedTable=? where CustomerID=?";
				PreparedStatement pst=con.prepareStatement(qry);
				pst.setString(1, bname);
				pst.setString(2, bdate);
				pst.setString(3, btime);
				pst.setString(4, table);
				pst.setString(5, bid);
				i=pst.executeUpdate();
				if(i>0)
					 status=true;
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			return status;
		}
}
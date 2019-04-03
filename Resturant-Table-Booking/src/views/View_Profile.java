package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import connector.My_function;

import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class View_Profile extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View_Profile frame = new View_Profile();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public View_Profile() {
		try {
			setResizable(false);
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setBounds(100, 100, 718, 517);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			Connection con=dbConnectivity.Connectivity.dbConnect();
			Statement st=con.createStatement();
			String qry="Select * from Employee where Employee_Name='"+My_function.empName+"'";
			ResultSet rst=st.executeQuery(qry);
			if(rst.next()) {
			
					JLabel lblViewProfile = new JLabel("View Profile");
					lblViewProfile.setFont(new Font("Times New Roman", Font.BOLD, 26));
					lblViewProfile.setBounds(259, 65, 149, 28);
					contentPane.add(lblViewProfile);
					
					JLabel lblEmailId = new JLabel("Email ID = "+rst.getString(2));
					lblEmailId.setFont(new Font("Dialog", Font.BOLD, 14));
					lblEmailId.setBounds(60, 250, 240, 20);
					contentPane.add(lblEmailId);
					
					JLabel lblNewLabel = new JLabel("Employee Name = "+rst.getString(1));
					lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 14));
					lblNewLabel.setBounds(60, 150, 240, 20);
					contentPane.add(lblNewLabel);
					
					JLabel lblContactNo = new JLabel("Contact no = "+rst.getString(3));
					lblContactNo.setFont(new Font("Dialog", Font.BOLD, 14));
					lblContactNo.setBounds(60, 300, 240, 20);
					contentPane.add(lblContactNo);
					
					JLabel lblAddress = new JLabel("Address = "+rst.getString(4));
					lblAddress.setFont(new Font("Dialog", Font.BOLD, 14));
					lblAddress.setBounds(60, 200, 240, 20);
					contentPane.add(lblAddress);
					
					JLabel lblPosition = new JLabel("Position = "+rst.getString(5));
					lblPosition.setFont(new Font("Dialog", Font.BOLD, 14));
					lblPosition.setBounds(60, 350, 240, 20);
					contentPane.add(lblPosition);
					
					JLabel lblDob = new JLabel("DOB = "+rst.getString(9));
					lblDob.setFont(new Font("Dialog", Font.BOLD, 14));
					lblDob.setBounds(411, 200, 240, 20);
					contentPane.add(lblDob);
					
					JLabel lblGender = new JLabel("Gender = "+rst.getString(7));
					lblGender.setFont(new Font("Dialog", Font.BOLD, 14));
					lblGender.setBounds(411, 150, 240, 20);
					contentPane.add(lblGender);
					
					JLabel lblNewLabel_1 = new JLabel("State = "+rst.getString(10));
					lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 14));
					lblNewLabel_1.setBounds(409, 250, 240 , 20);
					contentPane.add(lblNewLabel_1);
					
					JLabel lblNewLabel_2 = new JLabel("Salary = "+rst.getString(11));
					lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD, 14));
					lblNewLabel_2.setBounds(409, 300, 240, 20);
					contentPane.add(lblNewLabel_2);
					
					JLabel lblNewLabel_3 = new JLabel("Aadhar = "+rst.getString(12));
					lblNewLabel_3.setFont(new Font("Dialog", Font.BOLD, 14));
					lblNewLabel_3.setBounds(409, 350, 240, 20);
					contentPane.add(lblNewLabel_3);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

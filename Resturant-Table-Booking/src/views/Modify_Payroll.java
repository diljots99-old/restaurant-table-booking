package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.*;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class Modify_Payroll extends JFrame {

	private JPanel contentPane;
	private JTextField Gender;
	private JTextField eid;
	private JTextField mno;
	private JTextField oldSalary;
	private JTextField newSalary;
	public String empname="";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Modify_Payroll frame = new Modify_Payroll();
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
	public Modify_Payroll() {
		try {
								setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				setBounds(100, 100, 755, 413);
				contentPane = new JPanel();
				contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
				setContentPane(contentPane);
				contentPane.setLayout(null);
				
				JLabel lblModifyPayroll = new JLabel("Modify Payroll");
				lblModifyPayroll.setFont(new Font("Tahoma", Font.BOLD, 36));
				lblModifyPayroll.setBounds(210, 13, 291, 52);
				contentPane.add(lblModifyPayroll);
				
				JLabel lblSelectEmployee = new JLabel("Select Employee");
				lblSelectEmployee.setBounds(115, 100, 180, 20);
				contentPane.add(lblSelectEmployee);
				
				JLabel lblGender = new JLabel("Gender");
				lblGender.setBounds(115, 140, 180, 20);
				contentPane.add(lblGender);
				
				JLabel lblEmailid = new JLabel("Email_ID");
				lblEmailid.setBounds(115, 180, 180, 20);
				contentPane.add(lblEmailid);
				
				JLabel lblMobileNumber = new JLabel("Mobile Number");
				lblMobileNumber.setBounds(115, 220, 180, 20);
				contentPane.add(lblMobileNumber);
				
				JLabel lblOldSalary = new JLabel("Old Salary");
				lblOldSalary.setBounds(115, 260, 180, 20);
				contentPane.add(lblOldSalary);
				
				JLabel lblEnterNewSalary = new JLabel("Enter New Salary");
				lblEnterNewSalary.setBounds(115, 300, 180, 20);
				contentPane.add(lblEnterNewSalary);
				
				
				Gender = new JTextField();
				Gender.setBounds(380, 140, 220, 20);
				contentPane.add(Gender);
				Gender.setColumns(10);
				
				eid = new JTextField();
				eid.setColumns(10);
				eid.setBounds(380, 180, 220, 20);
				contentPane.add(eid);
				
				mno = new JTextField();
				mno.setColumns(10);
				mno.setBounds(380, 220, 220, 20);
				contentPane.add(mno);
				
				oldSalary = new JTextField();
				oldSalary.setColumns(10);
				oldSalary.setBounds(380, 260, 220, 20);
				contentPane.add(oldSalary);
				
				newSalary = new JTextField();
				newSalary.setColumns(10);
				newSalary.setBounds(380, 300, 220, 20);
				contentPane.add(newSalary);
				JComboBox comboBox = new JComboBox();
				comboBox.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						empname = (String)comboBox.getSelectedItem();
						try {
						Connection con1 = dbConnectivity.Connectivity.dbConnect();
						Statement st1=con1.createStatement();
						String qry1="select * from Employee where employee_Name = '"+empname+"'";
						ResultSet rst1=st1.executeQuery(qry1);
						if(rst1.next()) {
							Gender.setText(rst1.getString(7));
							eid.setText(rst1.getString(2));
							mno.setText(rst1.getString(3));
							oldSalary.setText(rst1.getString(11));
							Gender.disable();
							eid.disable();
							mno.disable();
							oldSalary.disable();
						}
						}catch (Exception e1) {
							System.out.println(e1);
						}
					}
				});
				comboBox.setModel(new DefaultComboBoxModel(new String[] {"Please Select Employee Name"}));
				comboBox.setBounds(380, 100, 220, 20);
				contentPane.add(comboBox);
				
				JButton btnUpdate = new JButton("Update");
				btnUpdate.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					try {
						empname = (String)comboBox.getSelectedItem();
						String Salary = newSalary.getText();
						Connection con2 = dbConnectivity.Connectivity.dbConnect();
						Statement st2=con2.createStatement();
						String qry2="update Employee set salary=? where employee_Name = ?";
						PreparedStatement pst=con2.prepareStatement(qry2);
						pst.setString(1, Salary);
						pst.setString(2, empname);
						int i=pst.executeUpdate();
						if(i>0){
							JOptionPane.showMessageDialog(null, "Your Data Has been update");
						}	
						else {
							JOptionPane.showMessageDialog(null, "Your Data Has not been update");
						}
							
					}catch(Exception e2) {
						System.out.println(e2);
					}
					
					
					}
				});
				btnUpdate.setBounds(234, 333, 97, 25);
				contentPane.add(btnUpdate);
				
				JButton btnExit = new JButton("Exit");
				btnExit.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					dispose();
					}
				});
				btnExit.setBounds(390, 328, 97, 30);
				contentPane.add(btnExit);
				
				Connection con = dbConnectivity.Connectivity.dbConnect();
				Statement st=con.createStatement();
				String qry="select employee_Name from Employee";
				ResultSet rst=st.executeQuery(qry);
				while(rst.next())
				{
					comboBox.addItem(rst.getString(1));
				}
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}

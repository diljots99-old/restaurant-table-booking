package views;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import connector.My_function;

public class New_emp extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					New_emp frame = new New_emp();
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
	public New_emp() {
		setResizable(false);
		setTitle("Theatre Ticket Reservation Application : Employee Register");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 822, 453);
		contentPane = new JPanel();
		contentPane.setToolTipText("select");
		contentPane.setBackground(SystemColor.inactiveCaptionBorder);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaptionBorder);
		panel.setBounds(601, -17, 191, 433);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnBack = new JButton("Exit");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnBack.setBounds(49, 243, 89, 23);
		panel.add(btnBack);
		
		
		JLabel lblRegisterEmployee = new JLabel("Employee Registration");
		lblRegisterEmployee.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRegisterEmployee.setBounds(125, 11, 196, 28);
		contentPane.add(lblRegisterEmployee);
		
		JLabel lblEmployeeName = new JLabel("Employee Name");
		lblEmployeeName.setBounds(10, 58, 91, 20);
		contentPane.add(lblEmployeeName);
		
		final JTextField ename = new JTextField();
		ename.setBounds(102, 58, 147, 20);
		contentPane.add(ename);
		ename.setColumns(10);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(259, 58, 46, 20);
		contentPane.add(lblGender);
		
		final JRadioButton Male = new JRadioButton("Male");
		buttonGroup.add(Male);
		Male.setBackground(SystemColor.inactiveCaptionBorder);
		Male.setBounds(323, 58, 76, 20);
		contentPane.add(Male);
		
		final JRadioButton Female = new JRadioButton("Female");
		buttonGroup.add(Female);
		Female.setBackground(SystemColor.inactiveCaptionBorder);
		Female.setBounds(403, 58, 91, 20);
		contentPane.add(Female);
		
		
		JLabel lblEmailId = new JLabel("Email Id");
		lblEmailId.setBounds(10, 93, 46, 20);
		contentPane.add(lblEmailId);
		
		final JTextField eid = new JTextField();
		eid.setBounds(102, 93, 147, 20);
		contentPane.add(eid);
		eid.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(259, 93, 62, 20);
		contentPane.add(lblPassword);
		
		final JPasswordField password = new JPasswordField();
		password.setBounds(323, 93, 147, 20);
		contentPane.add(password);
		
		JLabel lblMobileNo = new JLabel("Mobile No");
		lblMobileNo.setBounds(10, 132, 62, 14);
		contentPane.add(lblMobileNo);
		
		final JTextField mno = new JTextField();
		mno.setBounds(102, 124, 147, 20);
		contentPane.add(mno);
		mno.setColumns(10);
		
		JLabel lblDob = new JLabel("DOB");
		lblDob.setBounds(259, 124, 40, 14);
		contentPane.add(lblDob);
		
				
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(10, 168, 62, 14);
		contentPane.add(lblAddress);
		
		final JTextField	 address = new JTextField();
		address.setBounds(102, 165, 149, 20);
		contentPane.add(address);
		address.setColumns(10);
		
		JLabel lblState = new JLabel("State");
		lblState.setBounds(259, 168, 46, 14);
		contentPane.add(lblState);
		
		final JComboBox state = new JComboBox();
		state.setModel(new DefaultComboBoxModel(new String[] {"Select", "Andhra Pradesh (AP)", "Arunachal Pradesh (AR)", "Assam (AS)", "Bihar (BR)", "Chhattisgarh (CG)", "Goa (GA)", "Gujarat (GJ)", "Haryana (HR)", "Himachal Pradesh (HP)", "Jammu and Kashmir (JK)", "Jharkhand (JH)", "Karnataka (KA)", "Kerala (KL)", "Madhya Pradesh (MP)", "Maharashtra (MH)", "Manipur (MN)", "Meghalaya (ML)", "Mizoram (MZ)", "Nagaland (NL)", "Odisha(OR)", "Punjab (PB)", "Rajasthan (RJ)", "Sikkim (SK)", "Tamil Nadu (TN)", "Telangana (TS)", "Tripura (TR)", "Uttar Pradesh (UP)", "Uttarakhand (UK)", "West Bengal (WB)"}));
		state.setBounds(323, 165, 147, 20);
		contentPane.add(state);
		
		JLabel lblPosition = new JLabel("Position");
		lblPosition.setBounds(10, 204, 46, 14);
		contentPane.add(lblPosition);
		
		final JComboBox position = new JComboBox();
		position.setModel(new DefaultComboBoxModel(new String[] {"select your position", "Waiter", "Manager", "Cashier", "Security Guard"}));
		position.setBounds(102, 201, 147, 20);
		contentPane.add(position);
		
		JLabel lblSalery = new JLabel("Salary");
		lblSalery.setBounds(259, 204, 46, 14);
		contentPane.add(lblSalery);
		
		final JTextField salary = new JTextField();
		salary.setBounds(323, 201, 147, 20);
		contentPane.add(salary);
		salary.setColumns(10);
		
		JLabel lblMartialStatus = new JLabel("Maritial Status");
		lblMartialStatus.setBounds(10, 240, 70, 14);
		contentPane.add(lblMartialStatus);
		
		final JComboBox mstatus = new JComboBox();
		mstatus.setModel(new DefaultComboBoxModel(new String[] {"pls select your status", "Single", "Married"}));
		mstatus.setBounds(102, 237, 147, 20);
		contentPane.add(mstatus);
		
		JLabel lblAdharNo = new JLabel("Aadhar No");
		lblAdharNo.setBounds(259, 240, 62, 14);
		contentPane.add(lblAdharNo);
		
		final JTextField adhno = new JTextField();
		adhno.setBounds(323, 232, 147, 20);
		contentPane.add(adhno);
		adhno.setColumns(10);
		
		final JDateChooser dob = new JDateChooser();
		dob.setBounds(323, 127, 147, 19);
		contentPane.add(dob);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			String Employee_Name=ename.getText();
			String Email_Id=eid.getText();
			String Mobile_No=mno.getText();
			String Address=address.getText();
			//String Position=(String) position.getItemAt(position.getSelectedIndex());
			String Position=(String) position.getSelectedItem();
			String Marital_Status=(String) mstatus.getSelectedItem();
			//String Gender="gender";
			String gender=null;
			if(Male.isSelected())
			{
				gender="Male";
				
			}
			else if(Female.isSelected())
			{
				gender="Female";
			}
			String DOB=((JTextField)dob.getDateEditor().getUiComponent()).getText();

			
			String State=(String) state.getSelectedItem();
			String Password=password.getText();
;			String Salary=salary.getText();
			String Aadhar_No=adhno.getText();
			boolean status=My_function.newemp(Employee_Name,Email_Id,Mobile_No,Address,Position,Marital_Status,gender,DOB,State,Salary,Aadhar_No,Password);
			if(status)
			{
				JOptionPane.showMessageDialog(null, "Your data is saved");			
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Your data is not saved");			
			}
		
			
			
			
		}
	});
			
			
		btnSave.setBounds(49, 67, 89, 23);
		panel.add(btnSave);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(49, 129, 89, 23);
		panel.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(49, 187, 89, 23);
		panel.add(btnDelete);
		
		
		
	}
}

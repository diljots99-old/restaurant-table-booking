package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import connector.My_function;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NewRegistration extends JFrame {

	private JPanel contentPane;
	private JTextField user;
	private JPasswordField pass;
	private JTextField mobi;
	private JTextField eid;
	private JTextField dob;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewRegistration frame = new NewRegistration();
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
	public NewRegistration() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New Registration");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel.setBounds(87, 16, 227, 32);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("User name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setBounds(77, 61, 133, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setBounds(77, 86, 133, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Gender");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3.setBounds(77, 111, 133, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Mobile no.");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_4.setBounds(77, 138, 133, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("E-mail id");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_5.setBounds(77, 165, 133, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("D.O.B");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_6.setBounds(77, 188, 133, 14);
		contentPane.add(lblNewLabel_6);
			
		JButton btncan = new JButton("Cancel");
		btncan.setBounds(213, 217, 89, 23);
		contentPane.add(btncan);
		
		user = new JTextField();
		user.setBounds(222, 61, 157, 20);
		contentPane.add(user);
		user.setColumns(10);
		
		pass = new JPasswordField();
		pass.setBounds(223, 84, 156, 20);
		contentPane.add(pass);
		
		mobi = new JTextField();
		mobi.setBounds(224, 137, 155, 20);
		contentPane.add(mobi);
		mobi.setColumns(10);
		
		eid = new JTextField();
		eid.setBounds(224, 163, 155, 20);
		contentPane.add(eid);
		eid.setColumns(10);
		
		dob = new JTextField();
		dob.setBounds(224, 186, 155, 20);
		contentPane.add(dob);
		dob.setColumns(10);
		
		JRadioButton rdbtnMale = new JRadioButton("Male");
		buttonGroup.add(rdbtnMale);
		rdbtnMale.setBounds(187, 109, 71, 25);
		contentPane.add(rdbtnMale);
		
		JRadioButton rdbtnFemlae = new JRadioButton("Female");
		buttonGroup.add(rdbtnFemlae);
		rdbtnFemlae.setBounds(278, 107, 127, 25);
		contentPane.add(rdbtnFemlae);
		JButton btnreg = new JButton("Register");
		btnreg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Username=user.getText();
				String Password=pass.getText();
				String Mobile=mobi.getText();
				String Email=eid.getText();
				String DOB=dob.getText();
				String gender=null;
				if(rdbtnMale.isSelected())
				{
					gender="Male";
					
				}
				else if(rdbtnFemlae.isSelected())
				{
					gender="Female";
				}
				boolean status=My_function.newreg(Username,Password,Mobile,Email,DOB,gender);
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
		btnreg.setBounds(104, 217, 89, 23);
		contentPane.add(btnreg);
	}
}

package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class NewRegistration extends JFrame {

	private JPanel contentPane;
	private JTextField user;
	private JPasswordField pass;
	private JTextField gen;
	private JTextField mobi;
	private JTextField eid;
	private JTextField dob;

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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New Registration");
		lblNewLabel.setBounds(122, 7, 106, 26);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("User name");
		lblNewLabel_1.setBounds(77, 61, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setBounds(77, 86, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Gender");
		lblNewLabel_3.setBounds(77, 111, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Mobile no.");
		lblNewLabel_4.setBounds(77, 136, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("E-mail id");
		lblNewLabel_5.setBounds(77, 165, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("D.O.B");
		lblNewLabel_6.setBounds(77, 188, 46, 14);
		contentPane.add(lblNewLabel_6);
		
		JButton btnreg = new JButton("Register");
		btnreg.setBounds(41, 238, 89, 23);
		contentPane.add(btnreg);
		
		JButton btncan = new JButton("Cancel");
		btncan.setBounds(150, 238, 89, 23);
		contentPane.add(btncan);
		
		user = new JTextField();
		user.setBounds(150, 60, 92, 20);
		contentPane.add(user);
		user.setColumns(10);
		
		pass = new JPasswordField();
		pass.setBounds(151, 83, 92, 20);
		contentPane.add(pass);
		
		gen = new JTextField();
		gen.setBounds(152, 108, 90, 20);
		contentPane.add(gen);
		gen.setColumns(10);
		
		mobi = new JTextField();
		mobi.setBounds(152, 136, 90, 20);
		contentPane.add(mobi);
		mobi.setColumns(10);
		
		eid = new JTextField();
		eid.setBounds(152, 162, 90, 20);
		contentPane.add(eid);
		eid.setColumns(10);
		
		dob = new JTextField();
		dob.setBounds(152, 185, 90, 20);
		contentPane.add(dob);
		dob.setColumns(10);
	}

}

package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import views.NewRegistration;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField user;
	private JPasswordField pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 510, 328);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Welcome = new JLabel("WELCOME");
		Welcome.setBounds(193, 23, 105, 14);
		contentPane.add(Welcome);
		
		JLabel lblUserName = new JLabel("User name");
		lblUserName.setBounds(80, 90, 92, 14);
		contentPane.add(lblUserName);
		
		JLabel Password = new JLabel("Password");
		Password.setBounds(80, 114, 103, 27);
		contentPane.add(Password);
		
		JLabel Panelkjkljl = new JLabel("Panel");
		Panelkjkljl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		Panelkjkljl.setBounds(80, 150, 92, 14);
		contentPane.add(Panelkjkljl);
		
		user = new JTextField();
		user.setBounds(185, 84, 176, 27);
		contentPane.add(user);
		user.setColumns(10);
		
		pass = new JPasswordField();
		pass.setBounds(185, 117, 176, 24);
		contentPane.add(pass);
		
		JComboBox Panel = new JComboBox();
		Panel.setModel(new DefaultComboBoxModel(new String[] {"Please Select Panel", "Admin", "Employee", "Customer"}));
		Panel.setBounds(185, 147, 176, 27);
		contentPane.add(Panel);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(193, 226, 105, 23);
		contentPane.add(btnLogin);
		
		JButton btnNew = new JButton("New Registration");
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new NewRegistration().setVisible(true);
			}
		});
		btnNew.setBounds(33, 226, 150, 23);
		contentPane.add(btnNew);
		
		JButton btnConn = new JButton("Connection");
		btnConn.setBounds(307, 226, 124, 23);
		contentPane.add(btnConn);
		
		JLabel lblNewLabel = new JLabel("Forget Password");
		lblNewLabel.setBounds(236, 173, 111, 27);
		contentPane.add(lblNewLabel);
	}
}

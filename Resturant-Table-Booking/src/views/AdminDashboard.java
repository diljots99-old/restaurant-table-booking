package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import connector.My_function;
import main.Login;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminDashboard extends JFrame {

	private JPanel contentPane;
	public String availTable="";
	public String adminName=My_function.empName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminDashboard frame = new AdminDashboard();
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
	public AdminDashboard() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);
		
		JMenu mnNew = new JMenu("New");
		mnNewMenu.add(mnNew);
		
		JMenuItem mntmEmpolyee = new JMenuItem("Empolyee");
		mntmEmpolyee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new New_emp().setVisible(true);
			}
		});
		mnNew.add(mntmEmpolyee);
		
		JMenuItem mntmTable = new JMenuItem("Table");
		mnNew.add(mntmTable);
		
		JMenuItem mntmLogout = new JMenuItem("Logout");
		mntmLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Login().setVisible(true);
				dispose();
			}
		});
		mnNewMenu.add(mntmLogout);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		mnNewMenu.add(mntmExit);
		
		JMenu mnAboutUs = new JMenu("About ");
		menuBar.add(mnAboutUs);
		
		JMenuItem mntmAboutUs = new JMenuItem("About Us");
		mnAboutUs.add(mntmAboutUs);
		
		JMenuItem mntmContactUs = new JMenuItem("Contact Us");
		mnAboutUs.add(mntmContactUs);
		
		JMenuItem mntmHelp = new JMenuItem("Help");
		menuBar.add(mntmHelp);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDashboard = new JLabel("Dashboard");
		lblDashboard.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblDashboard.setBounds(141, 11, 161, 29);
		contentPane.add(lblDashboard);
		
		JLabel lblWelcome = new JLabel("Welcome,"+adminName);
		lblWelcome.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setBounds(37, 50, 360, 14);
		contentPane.add(lblWelcome);
		
		JButton btnNewEmployee = new JButton("New Employee");
		btnNewEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new New_emp().setVisible(true);
			}
		});
		btnNewEmployee.setBounds(242, 98, 140, 25);
		contentPane.add(btnNewEmployee);
		
		JButton btnMangePayroll = new JButton("Mange Payroll");
		btnMangePayroll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Modify_Payroll().setVisible(true);
			}
		});
		btnMangePayroll.setBounds(242, 178, 140, 25);
		contentPane.add(btnMangePayroll);
		
		JLabel lblNewLabel = new JLabel("Available Table");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(69, 94, 124, 31);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel(availTable);
		label.setFont(new Font("Tahoma", Font.BOLD, 34));
		label.setBounds(82, 136, 46, 42);
		contentPane.add(label);
	}
}
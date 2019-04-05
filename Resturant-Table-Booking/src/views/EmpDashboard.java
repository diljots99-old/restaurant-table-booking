package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import connector.My_function;
import main.Login;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EmpDashboard extends JFrame {

	private JPanel contentPane;
	public String empName=My_function.empName;
	public String availTable="";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmpDashboard frame = new EmpDashboard();
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
	public EmpDashboard() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 876, 489);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenu mnNew = new JMenu("New");
		mnFile.add(mnNew);
		
		JMenuItem mntmBooking = new JMenuItem("Booking");
		mntmBooking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			new NewBooking().setVisible(true);
			}
		});
		mnNew.add(mntmBooking);
		
		JMenuItem mntmLogOut = new JMenuItem("Log Out");
		mntmLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			new Login().setVisible(true);
			dispose();
			}
		});
		mnFile.add(mntmLogOut);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			dispose();
			}
		});
		mnFile.add(mntmExit);
		
		JMenu mnView = new JMenu("View");
		menuBar.add(mnView);
		
		JMenuItem mntmProfile = new JMenuItem("Profile");
		mntmProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new View_Profile().setVisible(true);
			}
		});
		mnView.add(mntmProfile);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDashoard = new JLabel("Dashoard");
		lblDashoard.setFont(new Font("Tahoma", Font.BOLD, 34));
		lblDashoard.setBounds(345, 13, 183, 45);
		contentPane.add(lblDashoard);
		
		JLabel lblWelcome = new JLabel("Welcome,"+empName);
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblWelcome.setBounds(109, 71, 648, 16);
		contentPane.add(lblWelcome);
		
		JLabel lblAvailabeTable = new JLabel("Availabe Table ");
		lblAvailabeTable.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblAvailabeTable.setBounds(147, 145, 183, 34);
		contentPane.add(lblAvailabeTable);
		
		JLabel lblNewLabel = new JLabel(availTable);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(176, 188, 92, 103);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Cancel Booking");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CancelBooking().setVisible(true);
			}
		});
		btnNewButton.setBounds(525, 177, 197, 25);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Modify booking");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ModifyBooking().setVisible(true);
			}
		});
		btnNewButton_1.setBounds(525, 231, 197, 25);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Check Avaliblitiy");
		btnNewButton_2.setBounds(525, 287, 197, 25);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewBooking = new JButton("New Booking");
		btnNewBooking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new NewBooking().setVisible(true);
			}
		});
		btnNewBooking.setBounds(525, 127, 197, 25);
		contentPane.add(btnNewBooking);
	}
}

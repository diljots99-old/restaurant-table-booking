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
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class CustDashboard extends JFrame {

	private JPanel contentPane;
	public String custName=My_function.empName;
	public String availTable="";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustDashboard frame = new CustDashboard();
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
	public CustDashboard() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmLogout = new JMenuItem("Logout");
		mntmLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			new Login().setVisible(true);
			dispose();
			}
		});
		mnFile.add(mntmLogout);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		mnFile.add(mntmExit);
		
		JMenu mnAbout = new JMenu("About");
		menuBar.add(mnAbout);
		
		JMenuItem mntmAboutUs = new JMenuItem("About us");
		mnAbout.add(mntmAboutUs);
		
		JMenuItem mntmContactUs = new JMenuItem("Contact us");
		mnAbout.add(mntmContactUs);
		
		JMenuItem mnHelp = new JMenuItem("Help");
		mnHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null,"if you are facing any difficulity please contact restaurant");
			}
		});
		menuBar.add(mnHelp);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDashboard = new JLabel("Dashboard");
		lblDashboard.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblDashboard.setBounds(161, 11, 158, 34);
		contentPane.add(lblDashboard);
		
		JLabel lblWelcome = new JLabel("Welcome ,"+custName);
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblWelcome.setBounds(78, 53, 297, 14);
		contentPane.add(lblWelcome);
		
		JLabel lblAvaliableTable = new JLabel("Avaliable Table  ");
		lblAvaliableTable.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAvaliableTable.setBounds(40, 84, 116, 14);
		contentPane.add(lblAvaliableTable);
		
		JLabel lblNewLabel = new JLabel(availTable);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 34));
		lblNewLabel.setBounds(50, 109, 75, 81);
		contentPane.add(lblNewLabel);
		
		JButton btnNewBooking = new JButton("New Booking");
		btnNewBooking.setBounds(216, 84, 120, 40);
		contentPane.add(btnNewBooking);
		
		JButton btnModifyBooking = new JButton("Modify Booking");
		btnModifyBooking.setBounds(216, 132, 120, 40);
		contentPane.add(btnModifyBooking);
	}
}

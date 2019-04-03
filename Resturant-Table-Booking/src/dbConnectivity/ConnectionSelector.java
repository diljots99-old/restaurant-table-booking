package dbConnectivity;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class ConnectionSelector extends JFrame {

	private JPanel contentPane;
	private JTextField hostURL;
	private JTextField dbUser;
	private JTextField dbPass;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	public static int Select = 0;
	public static String online = null;
	Connection con=null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConnectionSelector frame = new ConnectionSelector();
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
	public ConnectionSelector() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 721, 427);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblConnectionSelector = new JLabel("Connection Selector");
		lblConnectionSelector.setBounds(276, 13, 128, 16);
		contentPane.add(lblConnectionSelector);
		
		JRadioButton rdbtnOffline = new JRadioButton("Offline(default)");
		rdbtnOffline.isSelected();
		rdbtnOffline.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(rdbtnOffline.isSelected())
				{
					Select=0;
				}
			}
		});
		buttonGroup.add(rdbtnOffline);
		rdbtnOffline.setBounds(66, 51, 127, 25);
		contentPane.add(rdbtnOffline);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"freesqldatabase.com","Amazon Web Services" }));
		comboBox.setBounds(239, 93, 165, 22);
		contentPane.add(comboBox);
		
		JRadioButton rdbtnOnline = new JRadioButton("Online");
		rdbtnOnline.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (rdbtnOnline.isSelected()) {
					Select=1;
					
				}
			}
		});
		buttonGroup.add(rdbtnOnline);
		rdbtnOnline.setBounds(66, 92, 127, 25);
		contentPane.add(rdbtnOnline);
		
		
		
		JRadioButton rdbtnMannual = new JRadioButton("Manual");
		rdbtnMannual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (rdbtnMannual.isSelected())
				{
					Select=2;
				}
			}
		});
		buttonGroup.add(rdbtnMannual);
		rdbtnMannual.setBounds(66, 140, 127, 25);
		contentPane.add(rdbtnMannual);
		
		hostURL = new JTextField();
		hostURL.setBounds(366, 141, 116, 22);
		contentPane.add(hostURL);
		hostURL.setColumns(10);
		
		JLabel lblHostUrl = new JLabel("Host URL");
		lblHostUrl.setBounds(239, 144, 56, 16);
		contentPane.add(lblHostUrl);
		
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setBounds(239, 182, 82, 16);
		contentPane.add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(239, 217, 82, 16);
		contentPane.add(lblPassword);
		
		dbUser = new JTextField();
		dbUser.setBounds(366, 176, 116, 22);
		contentPane.add(dbUser);
		dbUser.setColumns(10);
		
		dbPass = new JTextField();
		dbPass.setBounds(366, 214, 116, 22);
		contentPane.add(dbPass);
		dbPass.setColumns(10);
		
		JButton btnValidate = new JButton("Validate & Connect");
		btnValidate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Select==0)
				{
					con=dbConnectivity.Connectivity.dbConnect();
					if (Connectivity.Status)
						JOptionPane.showMessageDialog(null,"Connection Succesfull "+con);
							
				}
				if (Select==1)
				{
					online = (String) comboBox.getSelectedItem();
					System.out.println(online);
					if(online.equals("Amazon Web Services"))
					{
						Connectivity.HostUrl="jdbc:mysql://movie.cm7sjkqeomau.ap-south-1.rds.amazonaws.com:3306/";
						Connectivity.user="root";
						Connectivity.pass="password";
						con=dbConnectivity.Connectivity.dbConnect();
						if (Connectivity.Status)
							JOptionPane.showMessageDialog(null,"Amazon Web Services\nConnection Succesfull "+con);
					}
					if(online.equals("freesqldatabase.com"))
					{
						Connectivity.HostUrl="jdbc:mysql://sql12.freesqldatabase.com:3306/sql12286322";
						Connectivity.user="sql12286322";
						Connectivity.pass="sukhbirsingh1234";
						con=dbConnectivity.Connectivity.dbConnect();
						if (Connectivity.Status)
							JOptionPane.showMessageDialog(null,"freesqldatabase.com\nConnection Succesfull "+con);
					}
				}
				if(Select==2)
				{
					String url=hostURL.getText();
					String user=dbUser.getText();
					String pass=dbPass.getText();
					Connectivity.HostUrl=url;
					Connectivity.user=user;
					Connectivity.pass=pass;
					con=dbConnectivity.Connectivity.dbConnect();
					if (Connectivity.Status)
						JOptionPane.showMessageDialog(null,"Connection Succesfull with "+url+"\n"+con);

					
				}
			}
		});
		btnValidate.setBounds(224, 322, 182, 25);
		contentPane.add(btnValidate);
		
		JLabel lblUrlEgjdbcmysqllocalhostmovie = new JLabel("URL e.g. =jdbc:mysql://localhost:3306/Movie");
		lblUrlEgjdbcmysqllocalhostmovie.setBounds(239, 268, 259, 16);
		contentPane.add(lblUrlEgjdbcmysqllocalhostmovie);
	}
}

package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import connector.My_function;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;

public class ModifyBooking extends JFrame {

	private JPanel contentPane;
	private JTextField bName;
	private JTextField bID;
	public static String BookingName="";
	public static String BookingID="";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModifyBooking frame = new ModifyBooking();
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
	public ModifyBooking() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 623, 451);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCancelBooking = new JLabel("Modify Booking");
		lblCancelBooking.setBounds(216, 13, 138, 30);
		contentPane.add(lblCancelBooking);
		
		JLabel lblEnterBookingName = new JLabel("Enter Booking Name ");
		lblEnterBookingName.setBounds(79, 66, 138, 30);
		contentPane.add(lblEnterBookingName);
		
		JLabel lblEnterCustomerId = new JLabel("Enter Booking ID");
		lblEnterCustomerId.setBounds(79, 120, 123, 16);
		contentPane.add(lblEnterCustomerId);
		
		bID = new JTextField();
		bID.setBounds(268, 117, 116, 22);
		contentPane.add(bID);
		bID.setColumns(10);
		JTextPane BookingDetails = new JTextPane();
		BookingDetails.setBounds(79, 203, 334, 129);
		contentPane.add(BookingDetails);
		JLabel lblOr = new JLabel("or");
		lblOr.setBounds(216, 99, 56, 16);
		contentPane.add(lblOr);
		
		JButton btnNewButton = new JButton("Check");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookingName=bName.getText();
				BookingID=bID.getText();
				Connection con=null;
				try {
					String details="Booking Details Unavailable";
					con=dbConnectivity.Connectivity.dbConnect();
					String qry="select * from Booking where BookingName='"+BookingName+"'  or CustomerID="+BookingID;
					Statement st=con.createStatement();
					BookingDetails.setText(details);
					ResultSet rst=st.executeQuery(qry);
					boolean s=true; 
					while(s= rst.next())
					{
						if(s==false) {
							BookingDetails.setText(details);
						}
						else {
						details="CustomerID = "+rst.getString(1)+"\nBookingName ="+rst.getString(2)+"\nBookingDate = "+rst.getString(3)+
								"\nBookingTime = "+rst.getString(4)+"\nSelected Tables = "+rst.getString(5)+"\nPrice = "+rst.getString(6)+"\nNumber People Can Accomudate = "+rst.getString(7);
						BookingID =rst.getString(1);
						BookingName=rst.getString(2);
						BookingDetails.setText(details);
						}
					}
				}catch (Exception es) {
					System.out.println(es);
				}
				
			}
		});
		btnNewButton.setBounds(471, 95, 97, 25);
		contentPane.add(btnNewButton);
				
		JLabel lblBookingDetails = new JLabel("Booking Details");
		lblBookingDetails.setBounds(79, 174, 97, 22);
		contentPane.add(lblBookingDetails);
		
		JButton btnCancel = new JButton("Modify");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UpdateModify().setVisible(true);
						
			}
		});
		btnCancel.setBounds(471, 263, 97, 25);
		contentPane.add(btnCancel);
		
		bName = new JTextField();
		bName.setBounds(268, 70, 116, 22);
		contentPane.add(bName);
		bName.setColumns(10);
	
	}
}

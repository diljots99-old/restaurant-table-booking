package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import connector.My_function;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class CancelBooking extends JFrame {

	private JPanel contentPane;
	private JTextField bName;
	private JTextField bID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CancelBooking frame = new CancelBooking();
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
	public CancelBooking() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 623, 451);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCancelBooking = new JLabel("Cancel Booking");
		lblCancelBooking.setBounds(216, 13, 138, 30);
		contentPane.add(lblCancelBooking);
		
		JLabel lblEnterBookingName = new JLabel("Enter Booking Name ");
		lblEnterBookingName.setBounds(79, 66, 138, 30);
		contentPane.add(lblEnterBookingName);
		
		JLabel lblEnterCustomerId = new JLabel("Enter Booking ID");
		lblEnterCustomerId.setBounds(79, 120, 123, 16);
		contentPane.add(lblEnterCustomerId);
		
		bName = new JTextField();
		bName.setBounds(292, 70, 116, 22);
		contentPane.add(bName);
		bName.setColumns(10);
		
		bID = new JTextField();
		bID.setBounds(292, 117, 116, 22);
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
				String BookingName=bName.getText();
				String BookingID=bID.getText();
				Connection con=null;
				try {
					String details="Booking Details Unavailable";
					con=dbConnectivity.Connectivity.dbConnect();
					String qry="select * from Booking where BookingName='"+BookingName+"'  or CustomerID='"+BookingID+"'";
					Statement st=con.createStatement();
					ResultSet rst=st.executeQuery(qry);
					if(rst.next()==false) {
						BookingDetails.setText(details);
					}
					while(rst.next())
					{
						details="CustomerID = "+rst.getString(1)+"\nBookingName ="+rst.getString(2)+"\nBookingDate = "+rst.getString(3)+
								"\nBookingTime = "+rst.getString(4)+"\nSelected Tables = "+rst.getString(5)+"\nPrice = "+rst.getString(6)+"\nNumber People Can Accomudate = "+rst.getString(7);
						BookingDetails.setText(details);
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
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String BookingName=bName.getText();
				String BookingID=bID.getText();
				boolean Status=My_function.cancelBooking(BookingName,BookingID);
				if(Status) {
					JOptionPane.showMessageDialog(null, "Booking Has been Canceled Succesfully");
				}
				else {
					JOptionPane.showMessageDialog(null,"Bookin Has not Been Canceled");
				}
					
						
			}
		});
		btnCancel.setBounds(471, 263, 97, 25);
		contentPane.add(btnCancel);
	}
}

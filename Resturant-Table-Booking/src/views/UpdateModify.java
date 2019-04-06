package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.toedter.calendar.JDateChooser;

import connector.My_function;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UpdateModify extends JFrame {

	private JPanel contentPane;
	private JTextField Bname;
	private JTextField bID;
	private JComboBox bTime;
	private JDateChooser bDate ;
	private static JComboBox Table;
	public static String Date=null;
	public static String Time=null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateModify frame = new UpdateModify();
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
	public UpdateModify() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 692, 505);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		try {
			
		
		
		JLabel lblUpdateModify = new JLabel("Update Modify");
		lblUpdateModify.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpdateModify.setBounds(267, 28, 134, 27);
		contentPane.add(lblUpdateModify);
		
		JLabel lblBookingName = new JLabel("Booking  Name");
		lblBookingName.setBounds(156, 133, 113, 16);
		contentPane.add(lblBookingName);
		
		JLabel lblBookingId = new JLabel("Booking ID");
		lblBookingId.setBounds(156, 85, 113, 16);
		contentPane.add(lblBookingId);
		
		JLabel lblBooking = new JLabel("Booking  Time");
		lblBooking.setBounds(156, 176, 113, 16);
		contentPane.add(lblBooking);
		
		JLabel lblBookingDate = new JLabel("Booking Date");
		lblBookingDate.setBounds(156, 228, 113, 16);
		contentPane.add(lblBookingDate);
		
		JLabel lblTable = new JLabel("Table ");
		lblTable.setBounds(156, 280, 113, 16);
		contentPane.add(lblTable);
		
		bDate = new JDateChooser();
		bDate.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Date=((JTextField)bDate.getDateEditor().getUiComponent()).getText();
				System.out.println(Date);
				if ((Time != null)&&(Date !=null)) {
					My_function.getUpdateTables(Date,Time);	
				}
			}
		});
		bDate.setBounds(364, 228, 147, 22);
		contentPane.add(bDate);
		
		bTime = new JComboBox();
		bTime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Time=(String)bTime.getSelectedItem();
				System.out.println(Time);
				if ((Time != null)&&(Date !=null)) {
					My_function.getUpdateTables(Date,Time);
				}
			}
		});
		bTime.setModel(new DefaultComboBoxModel(new String[] {"Please Select Booking Time", "11:00 AM", "12:00 AM", "01:00 PM", "02:00 PM", "03:00 PM", "04:00 PM", "05:00 PM", "06:00 PM", "07:00 PM"}));
		bTime.setBounds(364, 173, 147, 22);
		contentPane.add(bTime);
		
		Bname = new JTextField();
		Bname.setBounds(364, 130, 147, 22);
		contentPane.add(Bname);
		Bname.setColumns(10);
		
		bID = new JTextField();
		bID.setBounds(364, 82, 147, 22);
		contentPane.add(bID);
		bID.setColumns(10);
		bID.disable();
		Table = new JComboBox();
		Table.setModel(new DefaultComboBoxModel(new String[] {"Please Select Table", "Table0", "Table1", "Table2", "Table3", "Table4", "Table5", "Table6", "Table7", "Table8", "Table9", "Table10", "Table11", "Table12", "Table13", "Table14"}));
		Table.setBounds(364, 277, 147, 22);
		contentPane.add(Table);
		
		JButton btnUpdate = new JButton("Update ");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bid=bID.getText();
				String bname=Bname.getText();
				String btime=(String) bTime.getSelectedItem();
				String bdate=((JTextField)bDate.getDateEditor().getUiComponent()).getText();
				String table=(String)Table.getSelectedItem();
				boolean Status=My_function.updateBooking(bid,bname,btime,bdate,table);
				if(Status) {
					JOptionPane.showMessageDialog(null, "Your Data Has been Updated ");
				}
				else {
					JOptionPane.showMessageDialog(null, "Your Data Has not Updated ");
				}
			}
		});
		btnUpdate.setBounds(267, 381, 97, 25);
		contentPane.add(btnUpdate);
		Connection con=dbConnectivity.Connectivity.dbConnect();
		String qry="Select * from Booking where BookingName ='"+ModifyBooking.BookingName+"' or CustomerID="+ModifyBooking.BookingID;
		System.out.println(qry);
		Statement st=con.createStatement();
		ResultSet rst=st.executeQuery(qry);
		
		while(rst.next()) {
			bID.setText(rst.getString(1));
			Bname.setText(rst.getString(2));
			bTime.setSelectedItem(rst.getObject(4));
			String dbDate=rst.getString(3);
			System.out.println(dbDate);
			Date date= new SimpleDateFormat("dd MMM, yyyy").parse(dbDate);  
			bDate.setDate(date);
			Table.setSelectedItem(rst.getObject(5));
		}
		
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void removeTables(int i) {
		String a="Table"+i;
		Table.removeItem(a);
		
	}
}

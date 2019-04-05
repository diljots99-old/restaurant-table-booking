package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import connector.My_function;

import java.awt.Window.Type;
import java.util.Arrays;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConfirmBooking extends JFrame {

	protected static final String String = null;
	private JPanel contentPane;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConfirmBooking frame = new ConfirmBooking();
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
	public ConfirmBooking() {
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblConfirmBooking = new JLabel("Confirm Booking");
		lblConfirmBooking.setBounds(160, 13, 120, 16);
		contentPane.add(lblConfirmBooking);
		
		JTextPane Confirm = new JTextPane();
		Confirm.setBounds(62, 45, 303, 164);
		contentPane.add(Confirm); 
		Confirm.setText("Total Booking Price = 100 * "+NewBooking.count+"= "+NewBooking.Price+"\nSelected Table = "+
		Arrays.asList(NewBooking.SelectedTable)+"\nBooking Date = "+NewBooking.bdate+"\nBooking Time = "+NewBooking.btime+
		"\nNumber of Peole can Acommudate = "+NewBooking.noPeople);
		
		JButton btnConfirmBooking = new JButton("Confirm Booking");
		btnConfirmBooking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println(NewBooking.SelectedTable);
				String BookingName=NewBooking.BookingName;
				String BookingDate=NewBooking.bdate;
				String BookingTime=NewBooking.btime;
				String SelectedTable=NewBooking.SelectedTable;
				String price = Integer.toString(NewBooking.Price);
				String noPeople=Integer.toString(NewBooking.noPeople);
				boolean status=My_function.confirmBooking(BookingName,BookingDate,BookingTime,SelectedTable,price,noPeople);
				if(status)
				{
					String CustID=My_function.getCustomerID(BookingName,BookingDate,BookingTime,SelectedTable,price,noPeople);
					JOptionPane.showMessageDialog(null, "Your data is saved with Booking ID = "+CustID);			
					Clear();
					dispose();
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Your data is not saved");		
					Clear();
					dispose();
				}
			
			}
		});
		
		btnConfirmBooking.setBounds(99, 222, 131, 25);
		contentPane.add(btnConfirmBooking);
	}
	public static void Clear() {
		NewBooking.Table0.setSelected(false);
		NewBooking.Table1.setSelected(false);
		NewBooking.Table2.setSelected(false);
		NewBooking.Table3.setSelected(false);
		NewBooking.Table4.setSelected(false);
		NewBooking.Table5.setSelected(false);
		NewBooking.Table6.setSelected(false);
		NewBooking.Table7.setSelected(false);
		NewBooking.Table8.setSelected(false);
		NewBooking.Table9.setSelected(false);
		NewBooking.Table10.setSelected(false);
		NewBooking.Table11.setSelected(false);
		NewBooking.Table12.setSelected(false);
		NewBooking.Table13.setSelected(false);
		NewBooking.Table14.setSelected(false);
		NewBooking.bTime.setSelectedIndex(0);
		NewBooking.bDate.setCalendar(null);
		NewBooking.bDate.setDate(null);
		NewBooking.bName.setText("");
		
	}
}

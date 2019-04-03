package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Panel;
import javax.swing.JLabel;
import java.awt.Window.Type;

public class NewBooking extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewBooking frame = new NewBooking();
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
	public NewBooking() {
		setTitle("New Booking");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1176, 528);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewBooking = new JLabel("New Booking");
		lblNewBooking.setBounds(516, 13, 56, 16);
		contentPane.add(lblNewBooking);
		
		JLabel lblBookingName = new JLabel("Booking Name");
		lblBookingName.setBounds(91, 73, 100, 20);
		contentPane.add(lblBookingName);
		
		JLabel lblBookingDate = new JLabel("Booking Date");
		lblBookingDate.setBounds(410, 73, 100, 20);
		contentPane.add(lblBookingDate);
		
		JLabel lblBookingTime = new JLabel("Booking Time");
		lblBookingTime.setBounds(761, 73, 100, 20);
		contentPane.add(lblBookingTime);
		
		JPanel panel = new JPanel();
		panel.setBounds(43, 127, 970, 341);
		contentPane.add(panel);
	}
}

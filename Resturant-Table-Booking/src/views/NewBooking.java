package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Panel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Window.Type;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JToggleButton;
import javax.swing.event.ChangeListener;

import com.toedter.calendar.JDateChooser;

import connector.My_function;

import javax.swing.event.ChangeEvent;
import java.awt.event.ItemListener;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.awt.event.ItemEvent;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class NewBooking extends JFrame {

	private JPanel contentPane;
	public static JTextField bName;
	public static JDateChooser bDate;
	public static int count=0;
	public static int i=0; 
	public static int Price=0;
	public static String SelectedTable = "";
	public static String bookedTable = "";
	//public static String SelectedTable[]=new String[15];
   	public static String bdate="";
   	public static String btime="";
   	public static int noPeople=0;		
   	public static String BookingName="";
   	public static String Time=null;
   	public static String Date=null;
   	public static JToggleButton Table0;
	public static JToggleButton Table1;
	public static JToggleButton Table2;
	public static JToggleButton Table3;
	public static JToggleButton Table4;
	public static JToggleButton Table5;
	public static JToggleButton Table6;
	public static JToggleButton Table7;
	public static JToggleButton Table8;
	public static JToggleButton Table9;
	public static JToggleButton Table10;
	public static JToggleButton Table11;
	public static JToggleButton Table12;
	public static JToggleButton Table13;
	public static JToggleButton Table14;
	public static JComboBox bTime;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JButton btnExit;
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
		setBounds(100, 100, 1317, 881);
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
		
		bName = new JTextField();
		bName.setBounds(203, 72, 195, 22);
		contentPane.add(bName);
		bName.setColumns(10);
		
		bDate = new JDateChooser();
		bDate.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent arg0) {
				Date=((JTextField)bDate.getDateEditor().getUiComponent()).getText();
				System.out.println(Date);
				if ((Time != null)&&(Date !=null)) {
						enableAll();
						My_function.getBookedTables(Time,Date);
					
				}
			}
		});
		bDate.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Date=((JTextField)bDate.getDateEditor().getUiComponent()).getText();
				System.out.println(Date);
				if ((Time != null)&&(Date !=null)) {
					enableAll();
				My_function.getBookedTables(Time,Date);
				}
			}
		});
		bDate.setBounds(522, 72, 166, 22);
		contentPane.add(bDate);
		//bDate.setColumns(10);
		
		bTime = new JComboBox();
		bTime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Time=(String)bTime.getSelectedItem();
				System.out.println(Time);
				if ((Time != null)&&(Date !=null)) {
					enableAll();
					My_function.getBookedTables(Time,Date);
									
				}
			}
		});
		bTime.setModel(new DefaultComboBoxModel(new String[] {"Please Select Booking Time", "11:00 AM", "12:00 AM", "01:00 PM", "02:00 PM", "03:00 PM", "04:00 PM", "05:00 PM", "06:00 PM", "07:00 PM"}));
		bTime.setBounds(869, 72, 189, 22);
		contentPane.add(bTime);
		
		Table0 = new JToggleButton("New toggle button");
		buttonGroup.add(Table0);
		Table0.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					count += 1;
					SelectedTable = "Table0";
					i++;
				} else if (e.getStateChange() == ItemEvent.DESELECTED) {
					count -= 1;
					i--;
					SelectedTable="";
				}
			}
		});
				Table0.setSelectedIcon(new ImageIcon(NewBooking.class.getResource("/resourses/Round Table Selected.jpg")));
		Table0.setIcon(new ImageIcon(NewBooking.class.getResource("/resourses/Round Table.jpg")));
		Table0.setBounds(280, 282, 86, 86);
		contentPane.add(Table0);
		
		Table1 = new JToggleButton("1");
		buttonGroup.add(Table1);
		Table1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					count += 1;
					SelectedTable = "Table1";
					i++;
				} else if (e.getStateChange() == ItemEvent.DESELECTED) {
					count -= 1;
					i--;
					SelectedTable="";
				}
			}
		});
		Table1.setSelectedIcon(new ImageIcon(NewBooking.class.getResource("/resourses/TAble Selected.jpg")));
		Table1.setIcon(new ImageIcon(NewBooking.class.getResource("/resourses/table.jpg")));
		Table1.setBounds(275, 170, 77, 65);
		contentPane.add(Table1);
		
		Table2 = new JToggleButton("New toggle button");
		buttonGroup.add(Table2);
		Table2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					count += 1;
					SelectedTable = "Table2";
					i++;
				} else if (e.getStateChange() == ItemEvent.DESELECTED) {
					count -= 1;
					i--;
					SelectedTable="";
				}
			}
		});
				Table2.setBounds(398, 170, 77, 65);
		contentPane.add(Table2);
		
		Table3 = new JToggleButton("New toggle button");
		buttonGroup.add(Table3);
		Table3.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					count += 1;
					SelectedTable = "Table3";
					i++;
				} else if (e.getStateChange() == ItemEvent.DESELECTED) {
					count -= 1;
					i--;
					SelectedTable="";
				}
			}
		});
		Table3.setBounds(517, 170, 77, 65);
		contentPane.add(Table3);
		
		Table4 = new JToggleButton("New toggle button");
		buttonGroup.add(Table4);
		Table4.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					count += 1;
					SelectedTable = "Table4";
					i++;
				} else if (e.getStateChange() == ItemEvent.DESELECTED) {
					count -= 1;
					i--;
					SelectedTable="";
				}
			}
		});
		Table4.setBounds(358, 636, 77, 65);
		contentPane.add(Table4);
		
		Table5 = new JToggleButton("New toggle button");
		buttonGroup.add(Table5);
		Table5.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					count += 1;
					SelectedTable = "Table5";
					i++;
				} else if (e.getStateChange() == ItemEvent.DESELECTED) {
					count -= 1;
					i--;
					SelectedTable="";
				}
			}
		});
		Table5.setBounds(478, 636, 77, 65);
		contentPane.add(Table5);
		
		Table6 = new JToggleButton("New toggle button");
		buttonGroup.add(Table6);
		Table6.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					count += 1;
					SelectedTable = "Table6";
					i++;
				} else if (e.getStateChange() == ItemEvent.DESELECTED) {
					count -= 1;
					i--;
					SelectedTable="";
				}
			}
		});
		Table6.setBounds(595, 636, 77, 65);
		contentPane.add(Table6);
		
		Table7 = new JToggleButton("New toggle button");
		buttonGroup.add(Table7);
		Table7.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					count += 1;
					SelectedTable = "Table7";
					i++;
				} else if (e.getStateChange() == ItemEvent.DESELECTED) {
					count -= 1;
					i--;
					SelectedTable="";
				}
			}
		});
		Table7.setBounds(718, 636, 77, 65);
		contentPane.add(Table7);
		
		Table14 = new JToggleButton("New toggle button");
		buttonGroup.add(Table14);
		Table14.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					count += 1;
					SelectedTable = "Table14";
					i++;
				} else if (e.getStateChange() == ItemEvent.DESELECTED) {
					count -= 1;
					i--;
					SelectedTable="";
				}
			}
		});
		Table14.setBounds(422, 282, 86, 86);
		contentPane.add(Table14);
		
		Table13 = new JToggleButton("New toggle button");
		buttonGroup.add(Table13);
		Table13.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					count += 1;
					SelectedTable = "Table13";
					i++;
				} else if (e.getStateChange() == ItemEvent.DESELECTED) {
					count -= 1;
					i--;
					SelectedTable="";
				}
			}
		});
		Table13.setBounds(280, 396, 86, 86);
		contentPane.add(Table13);
		Table12 = new JToggleButton("New toggle button");
		buttonGroup.add(Table12);
		Table12.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					count += 1;
					SelectedTable = "Table12";
					i++;
				} else if (e.getStateChange() == ItemEvent.DESELECTED) {
					count -= 1;
					i--;
					SelectedTable="";
				}
			}
		});
		Table12.setBounds(424, 396, 86, 86);
		contentPane.add(Table12);
		
		Table11 = new JToggleButton("New toggle button");
		buttonGroup.add(Table11);
		Table11.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					count += 1;
					SelectedTable = "Table11";
					i++;
				} else if (e.getStateChange() == ItemEvent.DESELECTED) {
					count -= 1;
					i--;
					SelectedTable="";
				}
			}
		});
		Table11.setBounds(565, 396, 86, 86);
		contentPane.add(Table11);
		
		Table10 = new JToggleButton("New toggle button");
		buttonGroup.add(Table10);
		Table10.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					count += 1;
					SelectedTable = "Table10";
					i++;
				} else if (e.getStateChange() == ItemEvent.DESELECTED) {
					count -= 1;
					i--;
					SelectedTable="";
				}
			}
		});
		Table10.setBounds(280, 512, 86, 86);
		contentPane.add(Table10);
		
		Table9 = new JToggleButton("New toggle button");
		buttonGroup.add(Table9);
		Table9.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					count += 1;
					SelectedTable = "Table9";
					i++;
				} else if (e.getStateChange() == ItemEvent.DESELECTED) {
					count -= 1;
					i--;
					SelectedTable="";
				}
			}
		});
		Table9.setBounds(422, 512, 86, 86);
		contentPane.add(Table9);
		
		Table8 = new JToggleButton("New toggle button");
		buttonGroup.add(Table8);
		Table8.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					count += 1;
					SelectedTable = "Table8";
					i++;
				} else if (e.getStateChange() == ItemEvent.DESELECTED) {
					count -= 1;
					i--;
					SelectedTable="";
				}
			}
		});
		Table8.setBounds(565, 512, 86, 86);
		contentPane.add(Table8);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(NewBooking.class.getResource("/resourses/word-image-899-e1517398786554.jpg")));
		label.setBounds(223, 161, 835, 548);
		contentPane.add(label);
		Table2.setSelectedIcon(new ImageIcon(NewBooking.class.getResource("/resourses/TAble Selected.jpg")));
		Table2.setIcon(new ImageIcon(NewBooking.class.getResource("/resourses/table.jpg")));
		Table3.setSelectedIcon(new ImageIcon(NewBooking.class.getResource("/resourses/TAble Selected.jpg")));
		Table3.setIcon(new ImageIcon(NewBooking.class.getResource("/resourses/table.jpg")));
		Table4.setSelectedIcon(new ImageIcon(NewBooking.class.getResource("/resourses/TAble Selected.jpg")));
		Table4.setIcon(new ImageIcon(NewBooking.class.getResource("/resourses/table.jpg")));
		Table5.setSelectedIcon(new ImageIcon(NewBooking.class.getResource("/resourses/TAble Selected.jpg")));
		Table5.setIcon(new ImageIcon(NewBooking.class.getResource("/resourses/table.jpg")));
		Table6.setSelectedIcon(new ImageIcon(NewBooking.class.getResource("/resourses/TAble Selected.jpg")));
		Table6.setIcon(new ImageIcon(NewBooking.class.getResource("/resourses/table.jpg")));
		Table7.setSelectedIcon(new ImageIcon(NewBooking.class.getResource("/resourses/TAble Selected.jpg")));
		Table7.setIcon(new ImageIcon(NewBooking.class.getResource("/resourses/table.jpg")));
		Table8.setSelectedIcon(new ImageIcon(NewBooking.class.getResource("/resourses/Round Table Selected.jpg")));
		Table8.setIcon(new ImageIcon(NewBooking.class.getResource("/resourses/Round Table.jpg")));
		Table9.setSelectedIcon(new ImageIcon(NewBooking.class.getResource("/resourses/Round Table Selected.jpg")));
		Table9.setIcon(new ImageIcon(NewBooking.class.getResource("/resourses/Round Table.jpg")));
		Table10.setSelectedIcon(new ImageIcon(NewBooking.class.getResource("/resourses/Round Table Selected.jpg")));
		Table10.setIcon(new ImageIcon(NewBooking.class.getResource("/resourses/Round Table.jpg")));
		Table11.setSelectedIcon(new ImageIcon(NewBooking.class.getResource("/resourses/Round Table Selected.jpg")));
		Table11.setIcon(new ImageIcon(NewBooking.class.getResource("/resourses/Round Table.jpg")));
		Table12.setSelectedIcon(new ImageIcon(NewBooking.class.getResource("/resourses/Round Table Selected.jpg")));
		Table12.setIcon(new ImageIcon(NewBooking.class.getResource("/resourses/Round Table.jpg")));
		Table13.setSelectedIcon(new ImageIcon(NewBooking.class.getResource("/resourses/Round Table Selected.jpg")));
		Table13.setIcon(new ImageIcon(NewBooking.class.getResource("/resourses/Round Table.jpg")));
		Table14.setSelectedIcon(new ImageIcon(NewBooking.class.getResource("/resourses/Round Table Selected.jpg")));
		Table14.setIcon(new ImageIcon(NewBooking.class.getResource("/resourses/Round Table.jpg")));
		
		JButton btnConfirm = new JButton("Proceed");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//JToggleButton table10 = (JToggleButton) getSelectedToggle();
				noPeople=count*4;
				Price=100*count;
				bdate=((JTextField)bDate.getDateEditor().getUiComponent()).getText();
				btime=(String)bTime.getSelectedItem();
				Date date;
				BookingName=bName.getText();
				date=bDate.getDate();
				if(btime=="Please Select Booking Time")
				{
					JOptionPane.showMessageDialog(null,"Please Select Booking Time");
				}
				else if(date==null)
				{
					JOptionPane.showMessageDialog(null,"Plese Select Date");
				}
				else if(SelectedTable.isEmpty())
				{
					JOptionPane.showMessageDialog(null,"Plese first select any table to proceed");
				}
				else if(bName.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null,"Plese enter Booking Name");
				}
				else {
					new ConfirmBooking().setVisible(true);
				}
			}
		});
		btnConfirm.setBounds(424, 767, 97, 25);
		contentPane.add(btnConfirm);
		
		btnExit = new JButton("Cancel");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			dispose();
			}
		});
		btnExit.setBounds(575, 767, 97, 25);
		contentPane.add(btnExit);
		
	}
	public void enableAll() {
		NewBooking.Table0.enable();
		NewBooking.Table0.setEnabled(true);
		NewBooking.Table1.enable();
		NewBooking.Table1.setEnabled(true);
		NewBooking.Table2.enable();
		NewBooking.Table2.setEnabled(true);
		NewBooking.Table3.enable();
		NewBooking.Table3.setEnabled(true);
		NewBooking.Table4.enable();
		NewBooking.Table4.setEnabled(true);
		NewBooking.Table5.enable();
		NewBooking.Table5.setEnabled(true);
		NewBooking.Table6.enable();
		NewBooking.Table6.setEnabled(true);
		NewBooking.Table7.enable();
		NewBooking.Table7.setEnabled(true);
		NewBooking.Table8.enable();
		NewBooking.Table8.setEnabled(true);
		NewBooking.Table9.enable();
		NewBooking.Table9.setEnabled(true);
		NewBooking.Table10.enable();
		NewBooking.Table10.setEnabled(true);
		NewBooking.Table11.enable();
		NewBooking.Table11.setEnabled(true);
		NewBooking.Table12.enable();
		NewBooking.Table12.setEnabled(true);
		NewBooking.Table13.enable();
		NewBooking.Table14.setEnabled(true);
	}

	
}

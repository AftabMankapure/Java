package form;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import java.sql.PreparedStatement;
import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class Rsales {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Rsales window = new Rsales();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	Connection con;
	PreparedStatement pat;
	ResultSet rs;
	private JTable table;
	
	
	public void Connect()
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost/mbs","root","");
			
		}
		catch(ClassNotFoundException ex)
		{
			
		}
		catch(SQLException ex)
		{
			
		}
	}
	
	public void table_load()
	{
		try {
			pat=(PreparedStatement) con.prepareStatement("select * from saless");
			//rs is a result set object
			rs=pat.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		}
		
		catch(SQLException e)
		{
			System.out.print(e);
		}
	}
	
	public Rsales() {
		initialize();
		Connect();
		
	}
	
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 893, 544);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(0, 0, 255), new Color(0, 0, 255), new Color(0, 0, 255), new Color(0, 0, 255)));
		panel.setBackground(Color.YELLOW);
		panel.setBounds(10, 11, 850, 78);
		frame.getContentPane().add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, Color.RED, Color.RED, Color.RED, Color.RED));
		panel_1.setBackground(new Color(127, 255, 0));
		panel_1.setBounds(10, 0, 830, 78);
		panel.add(panel_1);
		
		JLabel lblNewLabel = new JLabel("MEDICAL HOUSE");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Algerian", Font.BOLD, 45));
		panel_1.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 163, 840, 342);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(250, 240, 230));
		menuBar.setBounds(20, 100, 830, 42);
		frame.getContentPane().add(menuBar);
		
		JMenu mnNewMenu = new JMenu("HOME");
		mnNewMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Adminmain.main(null);
				frame.setVisible(false);
			}
		});
	
		mnNewMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
			}
		});
		mnNewMenu.setFont(new Font("Times New Roman", Font.BOLD, 16));
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_2 = new JMenu("MEDICINE");
		mnNewMenu_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("ADD MEDICINE");
		mntmNewMenuItem.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddMedicine obj=new AddMedicine();
				obj.main(null);
				frame.setVisible(false);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("MANAGAE MEDICINE");
		mntmNewMenuItem_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
				ManageMedicine obj=new ManageMedicine();
				obj.main(null);
				frame.setVisible(false);
				
				
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_3 = new JMenu("REPORT");
		mnNewMenu_3.setFont(new Font("Times New Roman", Font.BOLD, 16));
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("MEDICINE REPORT");
		mntmNewMenuItem_4.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Rmedicine obj=new Rmedicine();
				obj.main(null);
				frame.setVisible(false);
			
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("SALES REPORT");
		mntmNewMenuItem_2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Rsales obj=new Rsales();
				obj.main(null);
				frame.setVisible(false);
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("CUSTOMER REPORT");
		mntmNewMenuItem_3.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		mnNewMenu_3.add(mntmNewMenuItem_3);
		
		JMenu mnNewMenu_4 = new JMenu("LOGOUT");
		mnNewMenu_4.addMouseListener(new MouseAdapter() {
		
			public void mouseClicked(MouseEvent e) {
				AdminLogin.main(null);
				frame.setVisible(false);
				
			}
		});
		mnNewMenu_4.setFont(new Font("Times New Roman", Font.BOLD, 16));
		menuBar.add(mnNewMenu_4);
		
//		JDateChooser txtform = new JDateChooser();
//		txtform.getCalendarButton().addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//			}
//		});
//		txtform.setBounds(91, 16, 148, 20);
//		panel_2.add(txtform);
//		
//		JDateChooser txtto = new JDateChooser();
//		txtto.setBounds(413, 16, 134, 20);
//		panel_2.add(txtto);
//		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 52, 795, 279);
		panel_2.add(scrollPane);
		
		JPanel panel_3 = new JPanel();
		scrollPane.setViewportView(panel_3);
		panel_3.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_3.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(30, 29, 736, 214);
		panel_3.add(scrollPane_1);
		
		table = new JTable();
		scrollPane_1.setViewportView(table);
		
		JButton btnfind = new JButton("SHOW");
		btnfind.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnfind.setForeground(Color.BLUE);
		btnfind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				table_load();
					
				
//				try {
////					SimpleDateFormat date_format1=new SimpleDateFormat("yyyy,mm,dd") 	;
////					String  d1=date_format1.format(txtform.getDate());
////					
////					SimpleDateFormat date_format2=new SimpleDateFormat("yyyy,mm,dd") 	;			
////					String  d2=date_format2.format(txtto.getDate());
////					
////					txt1.setText(d1);
////					txt2.setText(d2);
////					
////					pat=(PreparedStatement) con.prepareStatement("select * from saless.order  between  "+txt1.getText()+"+ AND +"+txt2.getText()+" ");
////					
////					//JOptionPane.showMessageDialog(null,pat);
////					//pat.setString(1, d1);
////					//pat.setString(2, d2);
////					////rs is a result set object
////					rs=pat.executeQuery();
////					table.setModel(DbUtils.resultSetToTableModel(rs));
//				}
//				
//				catch(SQLException ex)
//				{
//					//System.out.print(ex);
//				}
//				
//			}

//			private Object getString() {
//				// TODO Auto-generated method stub
//				return null;
		}
		});
		btnfind.setBounds(636, 11, 89, 30);
		panel_2.add(btnfind);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_4.setBounds(93, 11, 473, 30);
		panel_2.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Sales Report");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel_1.setForeground(Color.MAGENTA);
		lblNewLabel_1.setBounds(181, 0, 148, 25);
		panel_4.add(lblNewLabel_1);
	}
}




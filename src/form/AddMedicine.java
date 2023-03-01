package form;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.sql.*;
//import com.mysql.jdbc.PreparedStatement;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.MenuKeyListener;
import javax.swing.event.MenuKeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AddMedicine {

	private JFrame frame;
	private JTextField txtcode;
	private JTextField txtname;
	private JTextField txtprice;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddMedicine window = new AddMedicine();
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
	public AddMedicine() {
		initialize();
		Connect();
		table_load();
	}

	
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
	
	// for load table


	public void table_load()
	{
		try {
			pat=(PreparedStatement) con.prepareStatement("select * from products");
			//rs is a result set object
			rs=pat.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
		}
		
		catch(SQLException e)
		{
			System.out.print(e);
		}
	}
	
		
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 228, 225));
		frame.setBounds(100, 100, 906, 497);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		
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
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Rcustomer obj=new Rcustomer();
				obj.main(null);
				frame.setVisible(false);
				
			}
		});
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
		
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(245, 255, 250));
		panel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Add Medicine Details", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panel.setBounds(20, 163, 401, 272);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lcode = new JLabel("Drug Code");
		lcode.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lcode.setForeground(new Color(0, 0, 0));
		lcode.setBounds(42, 53, 107, 30);
		panel.add(lcode);
		
		JLabel lblNewLabel_2 = new JLabel("Drug Name");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2.setBounds(42, 90, 104, 30);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Price Per Item");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_3.setForeground(new Color(0, 0, 0));
		lblNewLabel_3.setBounds(42, 139, 130, 30);
		panel.add(lblNewLabel_3);
		
		JButton btnReset = new JButton("RESET");
		btnReset.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnReset.setBounds(214, 195, 125, 30);
		panel.add(btnReset);
		
		txtcode = new JTextField();
		txtcode.setBounds(214, 50, 162, 30);
		panel.add(txtcode);
		txtcode.setColumns(10);
		
		txtname = new JTextField();
		txtname.setColumns(10);
		txtname.setBounds(214, 97, 162, 30);
		panel.add(txtname);
		
		txtprice = new JTextField();
		txtprice.setColumns(10);
		txtprice.setBounds(214, 146, 162, 30);
		panel.add(txtprice);
		
		JButton btnAddMedicine_1 = new JButton("ADD MEDICINE");
		btnAddMedicine_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnAddMedicine_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			
				String code,name,price;
				
				
				code=txtcode.getText();
				name=txtname.getText();
				price=txtprice.getText();
				
				
				//SELECT `id`, `dcode`, `dname`, `price` FROM `products` WHERE 1
				
				
				try 
				{
					pat=(PreparedStatement) con.prepareStatement("insert into products(dcode,dname,price) values(?,?,?)");
					
					pat.setString(1, code);
					pat.setString(2, name);
					pat.setString(3, price);
					
					pat.executeUpdate();
					
					JOptionPane.showMessageDialog(null,"Record Added..");
					
					table_load();
					txtname.setText("");
					txtcode.setText("");
					txtprice.setText("");
					
					//for get focus to name text field
					txtcode.requestFocus();
				}
				
				   catch(SQLException e1)
				
				    {
					   	e1.printStackTrace();
				    }
				
				
			}
		});
		btnAddMedicine_1.setBounds(58, 195, 136, 30);
		panel.add(btnAddMedicine_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(0, 0, 255), new Color(0, 0, 255), new Color(0, 0, 255), new Color(0, 0, 255)));
		panel_2.setBackground(Color.YELLOW);
		panel_2.setBounds(20, 10, 850, 78);
		frame.getContentPane().add(panel_2);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, Color.RED, Color.RED, Color.RED, Color.RED));
		panel_1_1.setBackground(new Color(127, 255, 0));
		panel_1_1.setBounds(10, 0, 830, 78);
		panel_2.add(panel_1_1);
		
		JLabel lblNewLabel = new JLabel("MEDICAL HOUSE");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Algerian", Font.BOLD, 45));
		panel_1_1.add(lblNewLabel);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBackground(new Color(240, 255, 255));
		panel_2_1.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Manage Medicine Details", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		panel_2_1.setBounds(442, 164, 422, 272);
		frame.getContentPane().add(panel_2_1);
		panel_2_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 30, 376, 234);
		panel_2_1.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}
}

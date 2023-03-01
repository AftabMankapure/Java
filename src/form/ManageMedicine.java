package form;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;


import net.proteanit.sql.DbUtils;

import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.border.SoftBevelBorder;
import java.awt.Font;
import javax.swing.border.EtchedBorder;

public class ManageMedicine {

	private JFrame frame;
	private JTextField txtcode;
	private JTextField txtname;
	private JTextField txtprice;
	private JTable table1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageMedicine window = new ManageMedicine();
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
	public ManageMedicine() {
		initialize();
		Connect();
		table_load();
	}

	
	Connection con;
	PreparedStatement pat;
	ResultSet rs;
	private JTable table;
	private JTextField txtid;
	
	
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
			table1.setModel(DbUtils.resultSetToTableModel(rs));
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
		frame.getContentPane().setForeground(new Color(255, 0, 0));
		frame.getContentPane().setBackground(new Color(224, 255, 255));
		frame.setBounds(100, 100, 894, 547);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
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
		panel.setBackground(new Color(255, 240, 245));
		panel.setBounds(10, 171, 327, 274);
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Manage Medicine Details", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		frame.getContentPane().add(panel);
		
		JLabel lcode = new JLabel("Drug Code");
		lcode.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lcode.setBounds(22, 128, 80, 20);
		panel.add(lcode);
		
		JLabel lblNewLabel_2 = new JLabel("Drug Name");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_2.setBounds(22, 177, 80, 20);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Price Per Item");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_3.setBounds(22, 222, 103, 20);
		panel.add(lblNewLabel_3);
		
		txtcode = new JTextField();
		txtcode.setColumns(10);
		txtcode.setBounds(169, 122, 130, 30);
		panel.add(txtcode);
		
		txtname = new JTextField();
		txtname.setColumns(10);
		txtname.setBounds(169, 171, 130, 30);
		panel.add(txtname);
		
		txtprice = new JTextField();
		txtprice.setColumns(10);
		txtprice.setBounds(169, 216, 130, 30);
		panel.add(txtprice);
		
		JLabel lblNewLabel_1 = new JLabel("Drug Id ");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_1.setBounds(22, 66, 80, 20);
		panel.add(lblNewLabel_1);
		
		txtid = new JTextField();
		txtid.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				//SELECT `id`, `dcode`, `dname`, `price` FROM `products` WHERE 1
				try {
					String id=txtid.getText();
					pat=(PreparedStatement) con.prepareStatement("select * from products where id=?");
					pat.setString(1, id);
					ResultSet rs=pat.executeQuery();
					
					  if(rs.next()==true)
					  {
						  String dcode=rs.getString(2);
						  String dname=rs.getString(3);
						  String price=rs.getString(4);
						  
						  txtcode.setText(dcode);
						 txtname.setText(dname);
						  txtprice.setText(price);
						  
					  }
					  else {
						  
						  txtcode.setText(" ");
						  txtname.setText("");
						  txtprice.setText("");
						 
					}
				
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
				
			}
		});
		txtid.setBounds(169, 60, 130, 30);
		panel.add(txtid);
		txtid.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, new Color(255, 0, 255), null, null, new Color(255, 200, 0)), "All Available Medicine", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(835, 373, -540, -267);
		frame.getContentPane().add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 240, 245));
		panel_2.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Manage Medicine Details", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panel_2.setBounds(365, 171, 503, 274);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		scrollPane.setBounds(33, 36, 441, 227);
		panel_2.add(scrollPane);
		
		table1 = new JTable();
		scrollPane.setViewportView(table1);
		
		JButton btnReset = new JButton("Clear");
		btnReset.setForeground(new Color(255, 0, 0));
		btnReset.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				txtcode.setText("");
				txtname.setText("");
				txtprice.setText("");
				//for get focus to name text field
				txtcode.requestFocus();
				
			
				}
		});
		btnReset.setBounds(138, 474, 125, 30);
		frame.getContentPane().add(btnReset);
		
		JButton btnNewButton = new JButton("Delete");
		btnNewButton.setForeground(new Color(255, 0, 0));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			
				
				String id;
			
				id=txtid.getText();
				
				try 
				{
					pat=(PreparedStatement) con.prepareStatement("delete  from products where id=?");
					
			
					pat.setString(1, id);
					pat.executeUpdate();
					
					JOptionPane.showMessageDialog(null,"Record Deleted..");
					
					table_load();
					txtcode.setText("");
					txtname.setText("");
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
		btnNewButton.setBounds(516, 474, 125, 30);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnAddMedicine_1 = new JButton("Update");
		btnAddMedicine_1.setForeground(new Color(255, 0, 0));
		btnAddMedicine_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnAddMedicine_1.setBounds(323, 474, 125, 30);
		frame.getContentPane().add(btnAddMedicine_1);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(0, 0, 255), new Color(0, 0, 255), new Color(0, 0, 255), new Color(0, 0, 255)));
		panel_2_1.setBackground(Color.YELLOW);
		panel_2_1.setBounds(20, 11, 850, 78);
		frame.getContentPane().add(panel_2_1);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, Color.RED, Color.RED, Color.RED, Color.RED));
		panel_1_1.setBackground(new Color(127, 255, 0));
		panel_1_1.setBounds(10, 0, 830, 78);
		panel_2_1.add(panel_1_1);
		
		JLabel lblNewLabel = new JLabel("MEDICAL HOUSE");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Algerian", Font.BOLD, 45));
		panel_1_1.add(lblNewLabel);
		btnAddMedicine_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
                 String dcode,dname,price,id;
				
				
				dcode=txtcode.getText();
				dname=txtname.getText();
				price=txtprice.getText();
				id=txtid.getText();
				
				
				//SELECT `id`, `dcode`, `dname`, `price` FROM `products` WHERE 1
				
				
				try 
				{
					pat=(PreparedStatement) con.prepareStatement("update products set dcode=?,dname=?,price=? where id=?");
					
					pat.setString(1,dcode);
					pat.setString(2, dname);
					pat.setString(3, price);
					pat.setString(4, id);
					pat.executeUpdate();
					
					JOptionPane.showMessageDialog(null,"Record Updated..");
					
					table_load();
					txtcode.setText("");
					txtname.setText("");
					txtprice.setText("");
					
					//for get focus to name text field
					txtname.requestFocus();
				}
				
				   catch(SQLException e1)
				
				    {
					   	e1.printStackTrace();
				    }
				
				
				
				
			}
		});
		
		
	}
}

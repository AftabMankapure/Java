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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.border.TitledBorder;

//import com.mysql.jdbc.PreparedStatement;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTable;

public class CreateUser {

	private JFrame frame;
	private JTextField txtuser;
	private JPasswordField txtpassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateUser window = new CreateUser();
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
	public CreateUser() {
		initialize();
		Connect();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	Connection con;
	PreparedStatement pat;
	ResultSet rs;
	//private JTable table;
	
	
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
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 905, 566);
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
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "CREATE USER ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 205)));
		panel_1_1.setBounds(224, 170, 400, 315);
		frame.getContentPane().add(panel_1_1);
		
		JLabel lblNewLabel_1 = new JLabel("USERNAME");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Arial Black", Font.BOLD, 26));
		lblNewLabel_1.setBounds(21, 39, 194, 25);
		panel_1_1.add(lblNewLabel_1);
		
		txtuser = new JTextField();
		txtuser.setFont(new Font("Arial Black", Font.BOLD, 26));
		txtuser.setColumns(10);
		txtuser.setBounds(31, 74, 291, 35);
		panel_1_1.add(txtuser);
		
		JLabel lblNewLabel_1_1 = new JLabel("PASSWORD");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Arial Black", Font.BOLD, 26));
		lblNewLabel_1_1.setBounds(21, 145, 194, 25);
		panel_1_1.add(lblNewLabel_1_1);
		
		JButton btncreate = new JButton("CREATE");
		btncreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
                   String username,password;
				
				
                   username=txtuser.getText();
                   password=txtpassword.getText();
				//price=txtprice.getText();
				
				
				//SELECT `id`, `dcode`, `dname`, `price` FROM `products` WHERE 1
				
				
				try 
				{
//					SELECT `id`, `username`, `password` FROM `user` WHERE 1
					pat=(PreparedStatement) con.prepareStatement("insert into user(username,password) values(?,?)");
					
					pat.setString(1, username);
					pat.setString(2, password);
					//pat.setString(3, price);
					
					pat.executeUpdate();
					
					JOptionPane.showMessageDialog(null,"User Created..");
					
					//table_load();
					txtuser.setText("");
					txtpassword.setText("");
					//txtprice.setText("");
					
					//for get focus to name text field
					txtuser.requestFocus();
				}
				
				   catch(SQLException e1)
				
				    {
					   	e1.printStackTrace();
				    }
				
				
			}
		});
		btncreate.setForeground(Color.WHITE);
		btncreate.setFont(new Font("Arial Black", Font.BOLD, 24));
		btncreate.setBackground(new Color(0, 204, 0));
		btncreate.setBounds(39, 240, 145, 43);
		panel_1_1.add(btncreate);
		
		txtpassword = new JPasswordField();
		txtpassword.setBounds(43, 181, 279, 35);
		panel_1_1.add(txtpassword);
		
		JButton btnclear = new JButton("CLEAR");
		btnclear.setForeground(Color.WHITE);
		btnclear.setFont(new Font("Arial Black", Font.BOLD, 24));
		btnclear.setBackground(new Color(0, 204, 0));
		btnclear.setBounds(209, 240, 129, 43);
		panel_1_1.add(btnclear);
		
		
	}

}

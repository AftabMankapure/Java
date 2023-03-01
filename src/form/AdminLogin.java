package form;
//
//import java.awt.EventQueue;
//
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JOptionPane;
//import javax.swing.JPanel;
//import javax.swing.border.BevelBorder;
//import java.awt.Color;
//import javax.swing.JTextField;
//import javax.swing.JPasswordField;
//import javax.swing.JButton;
//import java.awt.Font;
//import javax.swing.border.TitledBorder;
//
////import com.mysql.jdbc.PreparedStatement;
//
//import javax.swing.SwingConstants;
//import java.awt.event.ActionListener;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.awt.event.ActionEvent;


import java.awt.Dimension;


import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.border.TitledBorder;
import java.awt.BorderLayout;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextArea;


public class AdminLogin {

	private JFrame frame;
	private JTextField txtUsername;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLogin window = new AdminLogin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection con;
	PreparedStatement pat;
	ResultSet rs;
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
	/**
	 * Create the application.
	 */
	public AdminLogin() {
		initialize();
		Connect();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 472, 572);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(138, 43, 226));
		panel.setBounds(27, 11, 403, 82);
		frame.getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("MEDICAL HOUSE");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Algerian", Font.BOLD, 40));
		lblNewLabel.setBounds(21, 0, 372, 85);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "ADMIN LOGIN", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 205)));
		panel_1.setBounds(51, 177, 352, 315);
		frame.getContentPane().add(panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("USERNAME");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Arial Black", Font.BOLD, 26));
		lblNewLabel_1.setBounds(21, 39, 194, 25);
		panel_1.add(lblNewLabel_1);
		
		txtUsername = new JTextField();
		txtUsername.setFont(new Font("Arial Black", Font.BOLD, 26));
		txtUsername.setColumns(10);
		txtUsername.setBounds(31, 74, 291, 35);
		panel_1.add(txtUsername);
		
		JLabel lblNewLabel_1_1 = new JLabel("PASSWORD");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Arial Black", Font.BOLD, 26));
		lblNewLabel_1_1.setBounds(21, 145, 194, 25);
		panel_1.add(lblNewLabel_1_1);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
//					pat=(PreparedStatement) con.prepareStatement("select * from user where username = '\"+txtUsername.getText()+\"' and password = '\"+txtPassword.getText().toString()+\"' \"");
////	//rs is a result set object
//					rs=pat.executeQuery();
////	
	
//	Class.forName("com.mysql.jdbc.Driver");
	//Connection con = DriverManager.getConnection("jdbc:mysql://localhost:8080/mbs","root","");
//					SELECT `id`, `username`, `password` FROM `admin` WHERE 1
	Statement stmt = con.createStatement();
	String sql = "select * from admin where username = '"+txtUsername.getText()+"' and password = '"+txtPassword.getText().toString()+"' ";
	ResultSet rs = stmt.executeQuery(sql);
	if(rs.next())
	{
		JOptionPane.showMessageDialog(null, "Login Successfull..!!","Login Success..!!",JOptionPane.INFORMATION_MESSAGE);
		Adminmain.main(null);
		frame.setVisible(false);


	}
	else
	{
		JOptionPane.showMessageDialog(null, "Check The Credentials..!!");

	}
	con.close();
}catch(Exception e1)
{
	JOptionPane.showMessageDialog(null, "Database Error..!!", "Database Error", 2);
	System.out.print(e1);
}
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Arial Black", Font.BOLD, 24));
		btnNewButton.setBackground(new Color(0, 204, 0));
		btnNewButton.setBounds(39, 240, 129, 43);
		panel_1.add(btnNewButton);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(43, 181, 279, 35);
		panel_1.add(txtPassword);
		
		JButton btnclear = new JButton("CLEAR");
		btnclear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtUsername.setText(null);
				txtPassword.setText(null);
				
				
			}
		});
		btnclear.setForeground(Color.WHITE);
		btnclear.setFont(new Font("Arial Black", Font.BOLD, 24));
		btnclear.setBackground(new Color(0, 204, 0));
		btnclear.setBounds(178, 240, 129, 43);
		panel_1.add(btnclear);
	}
}

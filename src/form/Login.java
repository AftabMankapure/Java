package form;


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

public class Login {

	private JFrame frmLoginPage;
	private JTextField txtUsername;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmLoginPage.setVisible(true);
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
	public Login() {
		initialize();
		Connect();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLoginPage = new JFrame();
		frmLoginPage.getContentPane().setForeground(new Color(255, 182, 193));
		frmLoginPage.setTitle("LOGIN PAGE");
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize=kit.getScreenSize();
		int width = screenSize.width;
		int height = screenSize.height;
		
		frmLoginPage.setResizable(false);
		
		frmLoginPage.setSize(462,651);
		frmLoginPage.setLocationRelativeTo(null);
		
		//frmLoginPage.setBounds(100, 100, 462, 651);
		frmLoginPage.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frmLoginPage.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(138, 43, 226));
		panel.setBounds(24, 32, 403, 82);
		frmLoginPage.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("MEDICAL HOUSE");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setBounds(21, 0, 372, 85);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Algerian", Font.BOLD, 40));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "USER LOGIN", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 205)));
		panel_1.setBounds(48, 198, 352, 315);
		frmLoginPage.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("USERNAME");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Arial Black", Font.BOLD, 26));
		lblNewLabel_1.setBounds(21, 39, 194, 25);
		panel_1.add(lblNewLabel_1);
		
		txtUsername = new JTextField();
		txtUsername.setFont(new Font("Arial Black", Font.BOLD, 26));
		txtUsername.setBounds(31, 74, 291, 35);
		panel_1.add(txtUsername);
		txtUsername.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("PASSWORD");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Arial Black", Font.BOLD, 26));
		lblNewLabel_1_1.setBounds(21, 145, 194, 25);
		panel_1.add(lblNewLabel_1_1);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
														Statement stmt = con.createStatement();
					String sql = "select * from user where username = '"+txtUsername.getText()+"' and password = '"+txtPassword.getText().toString()+"' ";
					ResultSet rs = stmt.executeQuery(sql);
					if(rs.next())
					{
						JOptionPane.showMessageDialog(null, "Login Successfull..!!","Login Success..!!",JOptionPane.INFORMATION_MESSAGE);
						Main.main(null);
						frmLoginPage.setVisible(false);

					}
					else
					{
						JOptionPane.showMessageDialog(null, "Check The Credentials..!!");

					}
					con.close();
				}catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, "Database Error..!!", "Database Error", 2);
					//System.out.print(e1);
				}
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(0, 204, 0));
		btnNewButton.setFont(new Font("Arial Black", Font.BOLD, 24));
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

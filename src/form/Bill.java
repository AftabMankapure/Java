package form;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


//import com.mysql.jdbc.PreparedStatement;


import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.border.TitledBorder;

public class Bill extends JFrame {

	private JPanel contentPane;
	private JTextField txtdcode;
	private JTextField txtdname;
	private JTextField txtprice;
	private JTextField txtcost;
	private JTextField txtpay;
	private JTextField txtbal;
	private JTable table;
	private JTextField txtcname;
	private JTextField txtcno;

	/**
	 * Launch the application.
	 */
 	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bill frame1 = new Bill();
					frame1.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	Connection con;
	ResultSet rs;
	DefaultTableModel df;
	PreparedStatement pat;
	private JTextField txtamountt;
	
	
	
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
	 * Create the frame.
	 */
	
	public void recit()
	{
		String dcode;
		
	}

	public void Balance()
	{
		
        int total = Integer.parseInt(txtcost.getText());		
        int pay = Integer.parseInt(txtpay.getText());
        int bal = pay  - total;
        
        txtbal.setText(String.valueOf(bal));
		
	}
	
	
	public void sales()
	{
		String totalcost=txtcost.getText();
		String pay=txtpay.getText();
		String bal=txtbal.getText();
		String cname=txtcname.getText();
		String cno=txtcno.getText();
		
		int lastid=0;
//		SELECT `id`, `cname`, `cno`, `subtotal`, `pay`, `bal`, `date` FROM `saless` WHERE 1
		String query="insert into saless(cname,cno,subtotal,pay,bal)values(?,?,?,?,?)";
		try {
			pat=con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
			pat.setString(1,cname);
			pat.setString(2,cno);
			pat.setString(3,totalcost);
			pat.setString(4,pay);
			pat.setString(5,bal);
			pat.executeUpdate();
			
			rs=pat.getGeneratedKeys();
			
			if(rs.next())
			{
				lastid	=rs.getInt(1);
			}
			
			String query1="insert into sales_products(sales_id,drugname,price,qty,total)values(?,?,?,?,?)";
			PreparedStatement pat1 = con.prepareStatement(query1);
			 
			
			String drugname="";
			String price;
			
			String qty;
			String total;
			
			for(int i=0;i<table.getRowCount();i++)
			{
			  drugname=(String)table.getValueAt(i, 1);
			  price=(String)table.getValueAt(i, 2);
			  qty=(String)table.getValueAt(i, 3);
			  total=(String)table.getValueAt(i, 4);

			  
			  pat1.setInt(1,lastid);
			  pat1.setString(2,drugname);
			  pat1.setString(3,price);
			  pat1.setString(4,qty);
			  pat1.setString(5,total);
			    
			  pat1.executeUpdate();

			}
			
			JOptionPane.showMessageDialog(this,"Sales complete..");	
			
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	public Bill() {
		
				Connect();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 906, 616);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
			
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 445, 425, 121);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Times New Roman", Font.BOLD, 11));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
	     		"Drug Code", "Drug Name", "QTY", "Price", "Amount"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, Integer.class, Integer.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(table);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(547, 445, 332, 115);
		contentPane.add(scrollPane_1);
		
		JTextArea txtbill = new JTextArea();
		scrollPane_1.setViewportView(txtbill);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(0, 0, 255), new Color(0, 0, 255), new Color(0, 0, 255), new Color(0, 0, 255)));
		panel_1.setBackground(Color.YELLOW);
		panel_1.setBounds(10, 1, 869, 78);
		contentPane.add(panel_1);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, Color.RED, Color.RED, Color.RED, Color.RED));
		panel_1_1.setBackground(new Color(127, 255, 0));
		panel_1_1.setBounds(10, 0, 849, 78);
		panel_1.add(panel_1_1);
		
		JLabel lblNewLabel = new JLabel("MEDICAL HOUSE");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Algerian", Font.BOLD, 45));
		panel_1_1.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Customer Details", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 205)));
		panel_2.setBounds(10, 90, 871, 67);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lCname = new JLabel("Customer Name");
		lCname.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lCname.setBounds(36, 28, 120, 20);
		panel_2.add(lCname);
		
		txtcname = new JTextField();

		txtcname.setBounds(171, 22, 218, 34);
		panel_2.add(txtcname);  
		txtcname.setColumns(10);
		
		JLabel lnumber = new JLabel("Phone Number");
		lnumber.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lnumber.setBounds(469, 28, 110, 20);
		panel_2.add(lnumber);
		
		txtcno = new JTextField();
		txtcno.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
			}
		});
		txtcno.setBounds(619, 22, 176, 34);
		panel_2.add(txtcno);
		txtcno.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Drug Details", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panel_3.setBounds(10, 168, 870, 162);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lcode = new JLabel("Drug Code");
		lcode.setBounds(36, 28, 109, 25);
		panel_3.add(lcode);
		lcode.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		txtdcode = new JTextField();
		txtdcode.setBounds(172, 26, 216, 27);
		panel_3.add(txtdcode);
		txtdcode.addKeyListener(new KeyAdapter() {
		@Override
			public void keyReleased(KeyEvent e) {
		
			try {
				String dcode=txtdcode.getText();
				//String dname=txtdcode.getText();
				pat=(PreparedStatement) con.prepareStatement("select * from products where id=?");
				pat.setString(1,dcode );
				//pat.setString(2,dname );
				ResultSet rs=pat.executeQuery();
				
				  if(rs.next()==true)
				  {
					  String dname=rs.getString(3);
					  String price=rs.getString(4);
				  
					  txtdname.setText(dname);
					  txtprice.setText(price);
					  
				  }
				  else {
						JOptionPane.showMessageDialog(null,"Drug not found..");
					  
				}
			
			} catch (Exception e2) {
				// TODO: handle exception
			}
			
		}
		});
		txtdcode.setColumns(10);
		
		JLabel lname = new JLabel("Drug Name");
		lname.setBounds(473, 23, 109, 25);
		panel_3.add(lname);
		lname.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		txtdname = new JTextField();
		txtdname.setBounds(613, 26, 186, 27);
		panel_3.add(txtdname);
		txtdname.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Drug Price");
		lblNewLabel_3.setBounds(36, 72, 95, 20);
		panel_3.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		txtprice = new JTextField();
		txtprice.setBounds(172, 73, 216, 25);
		panel_3.add(txtprice);
		txtprice.setColumns(10);
		
		JLabel lqty = new JLabel("Quantity");
		lqty.setBounds(473, 75, 85, 23);
		panel_3.add(lqty);
		lqty.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		
		JSpinner txtqty = new JSpinner();
		txtqty.setBounds(704, 73, 95, 25);
		panel_3.add(txtqty);
		
		JLabel txtamount = new JLabel("Amount");
		txtamount.setBounds(36, 103, 99, 25);
		panel_3.add(txtamount);
		txtamount.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		txtamountt = new JTextField();
		txtamountt.setBounds(172, 109, 216, 25);
		panel_3.add(txtamountt);
		txtamountt.setColumns(10);
		
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.setBackground(new Color(175, 238, 238));
		btnAdd.setForeground(new Color(255, 0, 0));
		btnAdd.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnAdd.setBounds(539, 109, 142, 27);
		panel_3.add(btnAdd);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 255, 255));
		panel_4.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Payment Details", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panel_4.setBounds(10, 341, 869, 93);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lcost = new JLabel("Total Cost");
		lcost.setBounds(32, 22, 86, 20);
		panel_4.add(lcost);
		lcost.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		txtcost = new JTextField();
		txtcost.setBounds(169, 20, 214, 25);
		panel_4.add(txtcost);
		txtcost.setColumns(10);
		
		JLabel lpayment = new JLabel("Payment");
		lpayment.setBounds(481, 25, 72, 20);
		panel_4.add(lpayment);
		lpayment.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		txtpay = new JTextField();
		txtpay.setBounds(622, 23, 186, 25);
		panel_4.add(txtpay);
		txtpay.setColumns(10);
		
		JLabel lbalance = new JLabel("Balance");
		lbalance.setBounds(32, 53, 86, 20);
		panel_4.add(lbalance);
		lbalance.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		txtbal = new JTextField();
		txtbal.setBounds(169, 56, 214, 26);
		panel_4.add(txtbal);
		txtbal.setColumns(10);
		
		JButton btnPrint = new JButton("Sales");
		btnPrint.setBackground(new Color(175, 238, 238));
		btnPrint.setForeground(new Color(255, 0, 0));
		btnPrint.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnPrint.setBounds(540, 53, 109, 29);
		panel_4.add(btnPrint);
		
		JButton btnbill = new JButton(" Print Bill");
		btnbill.setForeground(Color.RED);
		btnbill.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnbill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String cost = txtcost.getText();
		         String pay = txtpay.getText();
		         String bal = txtbal.getText();
		         
		          DefaultTableModel model = new DefaultTableModel();
		        
		        model = (DefaultTableModel)table.getModel();
		         
		         txtbill.setText(txtbill.getText() + "******************************************************\n");
		         txtbill.setText(txtbill.getText() + "           MEDICAL HOUSE BILL                                     \n");
		         txtbill.setText(txtbill.getText() + "*******************************************************\n");
		         
		         //Heading
		          txtbill.setText(txtbill.getText() + "Product" + "\t" + "Price" +"\t" + "Qty" + "\t" + "Amount" + "\n"  );
		          
		          
		          for(int i = 0; i < model.getRowCount(); i++)
		          {
		              
		              String pname = (String)model.getValueAt(i, 1);
		              String price = (String)model.getValueAt(i, 3);
		              String amount = (String)model.getValueAt(i, 4); 
		              String qty = (String)model.getValueAt(i, 2); 
		              
		           txtbill.setText(txtbill.getText() + pname  + "\t" + price + "\t" + qty + "\t"+ amount  + "\n"  );
		    
		          }
		          
		          txtbill.setText(txtbill.getText() + "\n");     
		          
		          txtbill.setText(txtbill.getText() + "\t" + "\t" + "Subtotal :" + cost + "\n");
		          txtbill.setText(txtbill.getText() + "\t" + "\t" + "Pay :" + pay + "\n");
		          txtbill.setText(txtbill.getText() + "\t" + "\t" + "Balance :" + bal + "\n");
		          txtbill.setText(txtbill.getText() + "\n");
		          txtbill.setText(txtbill.getText() + "*******************************************************\n");
		          txtbill.setText(txtbill.getText() + "           THANK YOU COME AGIN             \n");

				
				
				
				
			}
		});
		btnbill.setBounds(688, 53, 120, 30);
		panel_4.add(btnbill);
		
		JButton btnHome = new JButton("HOME");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				setVisible(false);
				Main obj=new Main();
				obj.main(null);

			}
			
			
			
		});
		btnHome.setForeground(Color.RED);
		btnHome.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnHome.setBackground(new Color(175, 238, 238));
		btnHome.setBounds(441, 473, 96, 27);
		contentPane.add(btnHome);
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				
				Balance();
				sales();
		
				String cname=txtcname.getText();
				String cno=txtcno.getText();
				
				String query="insert into customer(cname,cno)values(?,?)";
				
			}
		});
		btnAdd.addActionListener(new ActionListener() {
			
			   public void actionPerformed(ActionEvent e) {
				
					
//				   SELECT `id`, `dcode`, `dname`, `price` FROM `products` WHERE 1
					
					DefaultTableModel model = new DefaultTableModel();
			        model = (DefaultTableModel)table.getModel();
			        model.addRow(new Object[]
			                
			        {
			            txtdcode.getText(),
			            txtdname.getText(),
			            txtqty.getValue().toString(),
			            txtprice.getText(),
			            txtamountt.getText(),           
			        });   
			                
			            int sum = 0;
			                    
			        for(int i = 0; i<table.getRowCount(); i++)
			        {
			            sum = sum + Integer.parseInt(table.getValueAt(i, 4).toString());
			        }
			        
			        txtcost.setText(Integer.toString(sum));
			           
			          txtdcode.setText("");
			           txtdname.setText("");
			           txtprice.setText("");
			           txtamountt.setText("");
			        txtdcode.requestFocus();
		
			}
		});
		
		
		txtqty.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int qty = Integer.parseInt(txtqty.getValue().toString());
		        int price = Integer.parseInt(txtprice.getText());
		        int tot = qty * price;
		        
		        txtamountt.setText(String.valueOf(tot)); 
			
			
			}
			
			
		});
	}
}

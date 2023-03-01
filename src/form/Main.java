package form;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;

public class Main {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
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
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(250, 240, 230));
		frame.getContentPane().addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				Main obj=new Main();
				obj.main(null);
			}
		});
		frame.setBounds(100, 100, 821, 493);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(175, 238, 238));
		menuBar.setForeground(new Color(0, 191, 255));
		menuBar.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		menuBar.setBounds(20, 100, 755, 42);
		frame.getContentPane().add(menuBar);
		
		JMenu mnNewMenu = new JMenu("HOME");
		mnNewMenu.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_1 = new JMenu("BILL");
		mnNewMenu_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("NEW BILL");
		mntmNewMenuItem.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		mntmNewMenuItem.addActionListener(new ActionListener() {
			
			
			
			public void actionPerformed(ActionEvent e) {
				
				Bill obj=new Bill();
				obj.main(null);
				frame.setVisible(false);

				
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem);
		
		JMenu mnNewMenu_3 = new JMenu("ADMIN  LOGIN ");
		mnNewMenu_3.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("ADMIN LOGIN");
		mntmNewMenuItem_2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				AdminLogin obj=new AdminLogin();
				obj.main(null);
				frame.setVisible(false);

				
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu_4 = new JMenu("USER LOGOUT");
		mnNewMenu_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
				
			}
		});
		mnNewMenu_4.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		menuBar.add(mnNewMenu_4);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("LOGOUT");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Login obj=new Login();
				obj.main(null);
				

				
				frame.setVisible(false);
				
			}
		});
		mnNewMenu_4.add(mntmNewMenuItem_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 0));
		panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(0, 0, 255), new Color(0, 0, 255), new Color(0, 0, 255), new Color(0, 0, 255)));
		panel.setBounds(10, 11, 785, 78);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(127, 255, 0));
		panel_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, Color.RED, Color.RED, Color.RED, Color.RED));
		panel_1.setBounds(10, 0, 765, 78);
		panel.add(panel_1);
		
		JLabel lblNewLabel = new JLabel("MEDICAL HOUSE");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("Algerian", Font.BOLD, 45));
		panel_1.add(lblNewLabel);
	}
}

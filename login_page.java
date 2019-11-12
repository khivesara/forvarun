package library;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.image.*;


public class login_page {

	public JFrame frame;
	private JTextField textField;
	private JPasswordField password;
	protected JLabel txtPassword;
	protected JLabel txtUsername;
	protected JLabel name;


	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login_page window = new login_page();
					window.frame.setVisible(true);
		 	} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
    Connection connection=null;
	/**
	 * Create the application.
	 */
	public login_page() {
		initialize();
		connection = Sqliteconnection.dbConnector();
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(200, 200, 550, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		
		
		JLabel lblNewLabel = new JLabel("login page");
		lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblNewLabel.setBounds(179, 21, 92, 13);
		frame.getContentPane().add(lblNewLabel);
		
		
		JLabel lblNewLabel_1 = new JLabel("username:");
		lblNewLabel_1.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(21, 80, 81, 13);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("password:");
		lblNewLabel_2.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(21, 146, 81, 13);
		frame.getContentPane().add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(158, 75, 113, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		password = new JPasswordField();
		password.setBounds(158, 141, 119, 19);
		frame.getContentPane().add(password);
		
		
		
		JButton btnNewButton = new JButton("login");
		btnNewButton.setVisible(true);
		btnNewButton.setBackground(Color.cyan);
		
		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				
				try {
					String query = "select * from login where username=? and password=?";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(1,textField.getText());
					pst.setString(2,password.getText());
					ResultSet rs = pst.executeQuery();
					int count=0;
					while(rs.next()) {
						count = count + 1;
					}
					if(count==1) {
						JOptionPane.showMessageDialog(null,"credentials matched");
						//creating object
						allfield all = new allfield();
						frame.setVisible(false);
					}
					else if(count>1) {
						JOptionPane.showMessageDialog(null,"Duplicate credentials");
					}
					else {
						JOptionPane.showMessageDialog(null,"invalid try again");
						rs.close();
						pst.close();
					}
				}
				catch(Exception e){
					JOptionPane.showMessageDialog(null,e);
				}
				
				
					
				
			
			}
				
		});
	
	
		btnNewButton.setFont(new Font("Calibri", Font.PLAIN, 16));
		btnNewButton.setBounds(46, 215, 113, 21);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("exit");
		btnNewButton_1.setVisible(true);
		btnNewButton_1.setBackground(Color.cyan);
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    JFrame frmLoginSystem = new JFrame("exit");
			    if(JOptionPane.showConfirmDialog(frmLoginSystem,"confirm if u want to exit","Login Systems",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION) {
			    	System.exit(0);
			    }
			}
		});
		btnNewButton_1.setFont(new Font("Calibri", Font.PLAIN, 16));
		btnNewButton_1.setBounds(196, 215, 103, 21);
		frame.getContentPane().add(btnNewButton_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(21, 192, 505, 2);
		frame.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(80, 32, -131, 36);
		frame.getContentPane().add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(324, 51, 161, -109);
		frame.getContentPane().add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(30, 51, 1, 2);
		frame.getContentPane().add(separator_3);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(21, 51, 505, 2);
		frame.getContentPane().add(separator_4);
		
		Canvas canvas = new Canvas();
		canvas.setBounds(354, 59, 113, 116);
		frame.getContentPane().add(canvas);
		
		JLabel lblNewLabe3 = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("login1.png")).getImage();
		lblNewLabe3.setIcon(new ImageIcon(img));
		lblNewLabe3.setBounds(384, 75, 101, 91);
		frame.getContentPane().add(lblNewLabe3);
		
		
	}
}
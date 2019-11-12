package library;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JProgressBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class allfield extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					final allfield frame = new allfield();
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
	public allfield() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 550, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
	
		
		JButton btnNewButton_1 = new JButton("Issue Book");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 //creating object
				issue isb = new issue();
				isb.setVisible(true);
				
			}
		});
		btnNewButton_1.setBounds(202, 143, 134, 25);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Return Book");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 //creating object
				return1 rb = new return1();
				rb.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(202, 230, 134, 25);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Subjects");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 //creating object
				subject sub = new subject();
				sub.setVisible(true);
			}
		});
		btnNewButton_3.setBounds(202, 59, 134, 25);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("logout");
		btnNewButton_4.setBounds(202, 403, 134, 25);
		contentPane.add(btnNewButton_4);


		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frmLoginSystem = new JFrame("logout");
			    if(JOptionPane.showConfirmDialog(frmLoginSystem,"confirm if u want to logout","Login Systems",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION) {
			    	
					allfield.this.setVisible(false);
					login_page login = new login_page();
//					login.setVisible(true);
			    }
			    
			}
		});
		
		JButton btnNewButton_5 = new JButton("Statistics");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 //creating object
				statistics st = new statistics();
				st.setVisible(true);
			}
		});
		btnNewButton_5.setBounds(202, 310, 134, 25);
		contentPane.add(btnNewButton_5);
		
		JLabel lblLibraryManagementSystem = new JLabel("Library Management System");
		lblLibraryManagementSystem.setBounds(192, 11, 194, 25);
		contentPane.add(lblLibraryManagementSystem);
	}
}

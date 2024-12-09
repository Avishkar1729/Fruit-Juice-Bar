package com.fruitbar;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class ClientFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUname;
	private JTextField txtEmail;
	private JPasswordField txtPass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientFrame frame = new ClientFrame();
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
	public ClientFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("User Name");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(65, 51, 129, 33);
		contentPane.add(lblNewLabel);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEmail.setBounds(65, 125, 129, 33);
		contentPane.add(lblEmail);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPassword.setBounds(65, 197, 129, 33);
		contentPane.add(lblPassword);
		
		txtUname = new JTextField();
		txtUname.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		txtUname.setBounds(219, 52, 195, 33);
		contentPane.add(txtUname);
		txtUname.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		txtEmail.setColumns(10);
		txtEmail.setBounds(219, 126, 195, 33);
		contentPane.add(txtEmail);
		
		txtPass = new JPasswordField();
		txtPass.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		txtPass.setBounds(219, 201, 195, 33);
		contentPane.add(txtPass);
		
		JButton btnSubmit = new JButton("Login");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String uname = txtUname.getText();
				String email = txtEmail.getText();
				String pass = txtPass.getText();
				
				DBfruitbar dbf = new DBfruitbar();
				ResultSet rs = dbf.readClient(email);
				
				String tempUser=null,tempPass=null;
				
				int flag = 0;
				
				try {
					while(rs.next()) {
						flag = 1;
						tempUser = rs.getString(2);
						tempPass = rs.getString(7);
					}
					
				}
				catch(Exception ex){
					ex.printStackTrace();
				}
			
				
				
				if(flag==1) {
					if(uname.equals(tempUser) && pass.equals(tempPass) ) {
						//System.out.println("Login Successful");
						JOptionPane.showMessageDialog(btnSubmit, "Login Successful");
						
		            	OrdersClient ord = new OrdersClient();
						ord.setVisible(true);
						dispose();
						
					}
					
					else {
						//System.out.println("Login UnSuccessful");
						JOptionPane.showMessageDialog(btnSubmit, "Login UnSuccessful");
					}
				}
				else {
					//System.out.println("Please enter valid email");
					JOptionPane.showMessageDialog(btnSubmit, "Please enter valid email");
				}	
				
			}
		});
		btnSubmit.setBackground(new Color(0, 255, 255));
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSubmit.setBounds(183, 276, 107, 39);
		contentPane.add(btnSubmit);
		
		JLabel lblNewLabel_2 = new JLabel("Client Login");
		lblNewLabel_2.setForeground(new Color(255, 127, 80));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(92, 10, 291, 32);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("Go To User Panel");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 12));
		lblNewLabel_1.setBounds(162, 321, 139, 13);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	
            	LoginFrame lf = new LoginFrame();
            	lf.setVisible(true);
            	dispose();
            		
            }
            
        });
		

	}

}

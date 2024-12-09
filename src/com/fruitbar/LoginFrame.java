package com.fruitbar;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//import com.stringDemoSwing.DBFrame;
//import com.stringDemoSwing.DBFunction;

public class LoginFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUname;
	private JTextField txtEmail;
	private JPasswordField txtPass;
	static String custId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
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
	public LoginFrame() {
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
				ResultSet rs = dbf.readUser(email);
				
				String tempUser=null,tempPass=null;
				String custId=null;
				
				int flag = 0;
				
				try {
					while(rs.next()) {
						flag = 1;
						tempUser = rs.getString(2);
						tempPass = rs.getString(6);
						custId = rs.getString(1);
					}
					
				}
				catch(Exception ex){
					ex.printStackTrace();
				}
				
				
				
				if(flag==1) {
					
					if(uname.equals(tempUser) && pass.equals(tempPass) ) {
						//System.out.println("Login Successful");
						JOptionPane.showMessageDialog(btnSubmit, "Login Successful");
						
						MainPage mp = new MainPage();
						mp.setVisible(true);
						dispose();
						
						BuyItem bi = new BuyItem();
						bi.txt5.setText(custId);
						
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
		btnSubmit.setBounds(92, 276, 107, 39);
		contentPane.add(btnSubmit);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setBackground(new Color(250, 128, 114));
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
				SignupFrame sf = new SignupFrame();
				sf.setVisible(true);
				dispose();
				
			}
		});
		btnRegister.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnRegister.setBounds(276, 276, 107, 39);
		contentPane.add(btnRegister);
		
		JLabel lblNewLabel_1 = new JLabel("Go To Client Panel");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 12));
		lblNewLabel_1.setBounds(160, 330, 139, 13);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	
            	ClientFrame cf = new ClientFrame();
            	cf.setVisible(true);
            	dispose();
            		
            }
            
        });
		
		JLabel lblNewLabel_2 = new JLabel("User Login");
		lblNewLabel_2.setForeground(new Color(255, 127, 80));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(92, 10, 291, 32);
		contentPane.add(lblNewLabel_2);
		
		
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	
            	ClientFrame cf = new ClientFrame();
            	cf.setVisible(true);
            	dispose();
            		
            }
            
        });
		
	}

}

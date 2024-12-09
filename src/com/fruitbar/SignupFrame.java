package com.fruitbar;

import java.awt.Color;

import java.util.*;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.fruitbar.DBfruitbar;
import com.fruitbar.LoginFrame;


public class SignupFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUname;
	private JTextField txtEmail;
	private JTextField txtMob;
	private JTextField txtAddr;
	private JPasswordField txtPass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignupFrame frame = new SignupFrame();
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
	public SignupFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 390);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lbl1 = new JLabel("User Name");
		lbl1.setBackground(Color.CYAN);
		lbl1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl1.setBounds(57, 43, 89, 27);
		contentPane.add(lbl1);

		JLabel lbl2 = new JLabel("Email");
		lbl2.setBackground(Color.CYAN);
		lbl2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl2.setHorizontalAlignment(SwingConstants.CENTER);
		lbl2.setBounds(57, 92, 89, 27);
		contentPane.add(lbl2);

		JLabel lbl3 = new JLabel("Mobile No.");
		lbl3.setBackground(Color.CYAN);
		lbl3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl3.setHorizontalAlignment(SwingConstants.CENTER);
		lbl3.setBounds(57, 142, 89, 27);
		contentPane.add(lbl3);

		JLabel lbl4 = new JLabel("Address");
		lbl4.setBackground(Color.CYAN);
		lbl4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl4.setHorizontalAlignment(SwingConstants.CENTER);
		lbl4.setBounds(57, 191, 89, 27);
		contentPane.add(lbl4);

		JLabel lbl5 = new JLabel("Password");
		lbl5.setBackground(Color.CYAN);
		lbl5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl5.setHorizontalAlignment(SwingConstants.CENTER);
		lbl5.setBounds(57, 238, 89, 27);
		contentPane.add(lbl5);

		txtUname = new JTextField();
		txtUname.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 12));
		txtUname.setBounds(215, 43, 201, 27);
		contentPane.add(txtUname);
		txtUname.setColumns(10);

		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 12));
		txtEmail.setColumns(10);
		txtEmail.setBounds(215, 94, 201, 27);
		contentPane.add(txtEmail);

		txtMob = new JTextField();
		txtMob.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 12));
		txtMob.setColumns(10);
		txtMob.setBounds(215, 142, 201, 27);
		contentPane.add(txtMob);

		txtAddr = new JTextField();
		txtAddr.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 12));
		txtAddr.setColumns(10);
		txtAddr.setBounds(215, 191, 201, 27);
		contentPane.add(txtAddr);

		JButton btnSubmit = new JButton("Register");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String uname = txtUname.getText();
				String email = txtEmail.getText();
				String mob = txtMob.getText();
				String addr = txtAddr.getText();
				String pass = txtPass.getText();
				
				Random rand = new Random();
				int ran = rand.nextInt(1000);
				String id = String.valueOf(ran);
				
				
				int eFlag = 0;
				if(email.contains("@gmail.com"))
				{
					eFlag = 1;
				}
				else
				{
					JOptionPane.showMessageDialog(btnSubmit, "Please enter valid email address");
				}
				
				int mFlag = 0;
				
				if(mob.length() == 10)
				{
					mFlag = 1;
				}
				else
				{
					JOptionPane.showMessageDialog(btnSubmit, "Please enter 10 digit mobile number");
				}
				
				int pFlag = 0;
				int uCnt = 0, lCnt = 0, dCnt = 0, sCnt = 0;
				if(pass.length() >= 6 && pass.length() <= 9)
				{
					int len = pass.length();
					for(int i = 0; i < len; i++)
					{
						if(pass.charAt(i) >= 'A' && pass.charAt(i) <= 'Z')
						{
							uCnt++;
						}
						else if(pass.charAt(i) >= 'a' && pass.charAt(i) <= 'z')
						{
							lCnt++;
						}
						else if(pass.charAt(i) >= '0' && pass.charAt(i) <= '9')
						{
							dCnt++;
						}
						else if((pass.charAt(i) >= 33 && pass.charAt(i) <= 47) || (pass.charAt(i) >= 58 && pass.charAt(i) <= 64))
						{
							sCnt++;
						}
							
					}
					
					if(uCnt >= 1)
					{
						if(lCnt >= 1)
						{
							if(dCnt >= 1)
							{
								if(sCnt >= 1)
								{
									pFlag = 1;
								}
								else
								{
									JOptionPane.showMessageDialog(btnSubmit, "Please enter atleast one special character");
								}
							}
							else
							{
								JOptionPane.showMessageDialog(btnSubmit, "Please enter atleast one number");
							}
						}
						else
						{
							JOptionPane.showMessageDialog(btnSubmit, "Please enter atleast one lowercase letter");
						}
					}
					else
					{
						JOptionPane.showMessageDialog(btnSubmit, "Please enter atleast one uppercase letter");
					}
					
				}
				else
				{
					JOptionPane.showMessageDialog(btnSubmit, "please enter password in range of 6 to 9 character");
				}
				
				/*
				System.out.println("UserName : "+uname);
				System.out.println("Email : "+email);
				System.out.println("Mobile : "+mob);
				System.out.println("Address : "+addr);
				System.out.println("Password : "+pass);
				*/
				
				if(eFlag == 1 && mFlag == 1 && pFlag == 1)
				{
					DBfruitbar obj = new DBfruitbar();
					int res = obj.insertData(id, uname, email, mob, addr, pass);
					
					if(res == 1)
					{
						JOptionPane.showMessageDialog(btnSubmit, "Registration succesfull!!!");
						LoginFrame lf = new LoginFrame();
						lf.setVisible(true);
						dispose();
					}
					else
					{
						JOptionPane.showMessageDialog(btnSubmit, "Registration unsuccesfull!!!");
					}
				}
//				else
//				{
//					SignupFrame sf = new SignupFrame();
//					sf.setVisible(true);
//					dispose();
//				}

			}
		});
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSubmit.setBackground(Color.CYAN);
		btnSubmit.setBounds(83, 293, 112, 38);
		contentPane.add(btnSubmit);

		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				LoginFrame lf = new LoginFrame();
				lf.setVisible(true);
				dispose();

			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnLogin.setBackground(new Color(255, 160, 122));
		btnLogin.setBounds(288, 293, 112, 38);
		contentPane.add(btnLogin);

		txtPass = new JPasswordField();
		txtPass.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 12));
		txtPass.setBounds(215, 240, 201, 27);
		contentPane.add(txtPass);
		
		JLabel lblNewLabel_2 = new JLabel("User Registration");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(new Color(255, 127, 80));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(83, 1, 317, 32);
		contentPane.add(lblNewLabel_2);
	}

}

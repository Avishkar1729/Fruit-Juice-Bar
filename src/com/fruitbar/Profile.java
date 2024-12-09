package com.fruitbar;

import java.awt.Color;

import java.util.*;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JSeparator;

public class Profile extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JTextField txt1;
	JTextField txt2;
	JTextField txt3;
	JTextField txt4;
	JPasswordField txt5;
	JTextField getEmail;
	JTextField txt0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Profile frame = new Profile();
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
	public Profile() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 509, 460);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lbl1 = new JLabel("User Name");
		lbl1.setBackground(Color.CYAN);
		lbl1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl1.setBounds(57, 115, 89, 27);
		contentPane.add(lbl1);

		JLabel lbl2 = new JLabel("Email");
		lbl2.setBackground(Color.CYAN);
		lbl2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl2.setHorizontalAlignment(SwingConstants.CENTER);
		lbl2.setBounds(57, 164, 89, 27);
		contentPane.add(lbl2);

		JLabel lbl3 = new JLabel("Mobile No.");
		lbl3.setBackground(Color.CYAN);
		lbl3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl3.setHorizontalAlignment(SwingConstants.CENTER);
		lbl3.setBounds(57, 214, 89, 27);
		contentPane.add(lbl3);

		JLabel lbl4 = new JLabel("Address");
		lbl4.setBackground(Color.CYAN);
		lbl4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl4.setHorizontalAlignment(SwingConstants.CENTER);
		lbl4.setBounds(57, 263, 89, 27);
		contentPane.add(lbl4);

		JLabel lbl5 = new JLabel("Password");
		lbl5.setBackground(Color.CYAN);
		lbl5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl5.setHorizontalAlignment(SwingConstants.CENTER);
		lbl5.setBounds(57, 310, 89, 27);
		contentPane.add(lbl5);

		txt1 = new JTextField();
		txt1.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 12));
		txt1.setBounds(215, 115, 201, 27);
		contentPane.add(txt1);
		txt1.setColumns(10);

		txt2 = new JTextField();
		txt2.setEditable(false);
		txt2.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 12));
		txt2.setColumns(10);
		txt2.setBounds(215, 166, 201, 27);
		contentPane.add(txt2);

		txt3 = new JTextField();
		txt3.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 12));
		txt3.setColumns(10);
		txt3.setBounds(215, 214, 201, 27);
		contentPane.add(txt3);

		txt4 = new JTextField();
		txt4.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 12));
		txt4.setColumns(10);
		txt4.setBounds(215, 263, 201, 27);
		contentPane.add(txt4);

		txt5 = new JPasswordField();
		txt5.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 12));
		txt5.setBounds(215, 312, 201, 27);
		contentPane.add(txt5);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String st1 = txt1.getText();
				String st2 = txt2.getText();
				String st3 = txt3.getText();
				String st4 = txt4.getText();
				String st5 = txt5.getText();

				DBfruitbar obj = new DBfruitbar();
				obj.updateUser(st1, st2, st3, st4, st5);
				JOptionPane.showMessageDialog(btnUpdate, "Update Successfull!");

			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnUpdate.setBackground(Color.CYAN);
		btnUpdate.setBounds(83, 361, 112, 38);
		contentPane.add(btnUpdate);

		JButton btnBack = new JButton("Home");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				MainPage obj = new MainPage();
				obj.setVisible(true);
				dispose();

			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnBack.setBackground(new Color(255, 160, 122));
		btnBack.setBounds(286, 361, 112, 38);
		contentPane.add(btnBack);

		getEmail = new JTextField();
		getEmail.setText("Enter Your Email");
		getEmail.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				getEmail.setText(null);
			}
		});
		getEmail.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 12));
		getEmail.setColumns(10);
		getEmail.setBounds(83, 12, 201, 27);
		contentPane.add(getEmail);

		JSeparator separator = new JSeparator();
		separator.setBackground(SystemColor.desktop);
		separator.setForeground(SystemColor.desktop);
		separator.setBounds(10, 51, 466, 8);
		contentPane.add(separator);

		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String email = getEmail.getText();

				if (email.contains("Enter Your Email")) {
					email = getEmail.getText();
					JOptionPane.showMessageDialog(btnNewButton, "Please Enter Email");
				}

				else if (email.contains("@gmail.com")) {
					DBfruitbar dbf = new DBfruitbar();
					dbf.readData(email);

				}

				else {
					JOptionPane.showMessageDialog(btnNewButton, "Please Enter Valid Email");
				}

			}
		});
		btnNewButton.setBackground(SystemColor.activeCaptionBorder);
		btnNewButton.setBounds(337, 12, 79, 26);
		contentPane.add(btnNewButton);

		txt0 = new JTextField();
		txt0.setEditable(false);
		txt0.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 12));
		txt0.setColumns(10);
		txt0.setBounds(215, 64, 201, 27);
		contentPane.add(txt0);

		JLabel lbl1_1 = new JLabel("Customer ID");
		lbl1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl1_1.setBackground(Color.CYAN);
		lbl1_1.setBounds(57, 63, 100, 27);
		contentPane.add(lbl1_1);

	}
}

package com.fruitbar;

import java.awt.EventQueue;


import java.util.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JSpinner;

public class BuyItem extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JTextField txt1;
	JTextField txt2;
	JTextField txt3;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JButton btnNewButton;
	JTextField txt5;
	private JButton btnNewButton_2;
	private JButton btnNewButton_1;
	private JTextField txt4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuyItem frame = new BuyItem();
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
	public BuyItem() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Product Name  :");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(205, 22, 123, 27);
		contentPane.add(lblNewLabel);

		txt1 = new JTextField();
		txt1.setEditable(false);
		txt1.setBackground(new Color(255, 250, 240));
		txt1.setFont(new Font("Tempus Sans ITC", Font.BOLD, 12));
		txt1.setBounds(349, 22, 132, 27);
		contentPane.add(txt1);
		txt1.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Product Price  :");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(205, 72, 123, 27);
		contentPane.add(lblNewLabel_1);

		txt2 = new JTextField();
		txt2.setEditable(false);
		txt2.setBackground(new Color(255, 250, 240));
		txt2.setFont(new Font("Tempus Sans ITC", Font.BOLD, 12));
		txt2.setColumns(10);
		txt2.setBounds(349, 74, 132, 27);
		contentPane.add(txt2);

		JLabel lblNewLabel_2 = new JLabel("Total Price  :");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(205, 122, 123, 27);
		contentPane.add(lblNewLabel_2);

		txt3 = new JTextField();
		txt3.setEditable(false);
		txt3.setBackground(new Color(255, 250, 240));
		txt3.setFont(new Font("Tempus Sans ITC", Font.BOLD, 12));
		txt3.setColumns(10);
		txt3.setBounds(349, 124, 132, 27);
		contentPane.add(txt3);

		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Info\\Downloads\\Untitled (1).jpeg"));
		lblNewLabel_3.setBounds(289, 174, 100, 100);
		contentPane.add(lblNewLabel_3);

		lblNewLabel_4 = new JLabel("Scan & Pay Payment");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(267, 284, 142, 32);
		contentPane.add(lblNewLabel_4);


		txt4 = new JTextField();
		txt4.setText("Enter Transaction ID here...");
		txt4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txt4.setText(null);
			}
		});
		txt4.setHorizontalAlignment(SwingConstants.CENTER);
		txt4.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 10));
		txt4.setColumns(10);
		txt4.setBounds(205, 325, 276, 27);
		contentPane.add(txt4);

		txt5 = new JTextField();
		txt5.setEditable(true);
		txt5.setHorizontalAlignment(SwingConstants.CENTER);
		txt5.setText("Enter Your Customer ID here...");
		txt5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txt5.setText(null);
			}
		});
		txt5.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 10));
		txt5.setBounds(205, 362, 276, 27);
		contentPane.add(txt5);
		txt5.setColumns(10);

		btnNewButton_1 = new JButton("ORDER");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Random rand = new Random();
				int oId = rand.nextInt(100);

				String pName = txt1.getText();
				String pPrice = txt2.getText();
				String tPrice = txt3.getText();
				String tId = txt4.getText();
				String cId = txt5.getText();

				if (tId.contains("Enter Transaction ID here...")) {
					tId = txt4.getText();
					cId = txt5.getText();
					JOptionPane.showMessageDialog(btnNewButton_1, "Please Enter the transaction Id");

				}
				else if (cId.contains("Enter Your Customer ID here...")) {
					tId = txt4.getText();
					cId = txt5.getText();
					JOptionPane.showMessageDialog(btnNewButton_1, "Please Enter the customer Id");
				}


				else {
					DBfruitbar dbf = new DBfruitbar();
					tId = txt4.getText();
					cId = txt5.getText();
					dbf.insertData(oId, pName, pPrice, tPrice, tId, cId);

					JOptionPane.showMessageDialog(btnNewButton_1, "Thank you for Order!!!");

					MainPage obj = new MainPage();
					obj.setVisible(true);
					dispose();
				}

			}
		});
		btnNewButton_1.setFont(new Font("Bell MT", Font.BOLD, 16));
		btnNewButton_1.setBackground(new Color(245, 222, 179));
		btnNewButton_1.setBounds(156, 407, 171, 46);
		contentPane.add(btnNewButton_1);

		btnNewButton_2 = new JButton("CANCEL ORDER");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				MainPage obj = new MainPage();
				obj.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setFont(new Font("Bell MT", Font.BOLD, 16));
		btnNewButton_2.setBackground(new Color(245, 222, 179));
		btnNewButton_2.setBounds(370, 407, 171, 46);
		contentPane.add(btnNewButton_2);

	}
}

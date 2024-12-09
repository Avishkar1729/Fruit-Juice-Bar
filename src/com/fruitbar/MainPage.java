package com.fruitbar;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainPage extends JFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPage frame = new MainPage();
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
	public MainPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1052, 730);
		getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Fruit Juice");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				FruitJuice fj = new FruitJuice();
				fj.setVisible(true);
				dispose();
				
			}
		});
		btnNewButton.setBackground(SystemColor.control);
		btnNewButton.setForeground(new Color(139, 0, 0));
		btnNewButton.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 20));
		btnNewButton.setBounds(206, 116, 200, 90);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Fruit Plate");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				FruitPlate pl = new FruitPlate();
				pl.setVisible(true);
				dispose();
				
			}
		});
		btnNewButton_1.setForeground(new Color(139, 0, 0));
		btnNewButton_1.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 20));
		btnNewButton_1.setBackground(SystemColor.control);
		btnNewButton_1.setBounds(634, 116, 200, 90);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("My Profile");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Profile pr = new Profile();
				pr.setVisible(true);
				dispose();
				
			}
		});
		btnNewButton_2.setBackground(SystemColor.info);
		btnNewButton_2.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 14));
		btnNewButton_2.setBounds(206, 417, 200, 43);
		getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_2_1 = new JButton("Orders");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Orders ord = new Orders();
				ord.setVisible(true);
				dispose();
				
			}
		});
		btnNewButton_2_1.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 14));
		btnNewButton_2_1.setBackground(SystemColor.info);
		btnNewButton_2_1.setBounds(634, 417, 200, 43);
		getContentPane().add(btnNewButton_2_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Info\\Downloads\\BackFruit1_1160x772 (1).jpg"));
		lblNewLabel.setBounds(0, 0, 1038, 693);
		getContentPane().add(lblNewLabel);
		

	}
}

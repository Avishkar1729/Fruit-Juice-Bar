package com.fruitbar;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class Orders extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;
	private JTextField txtEnterCustomerrId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Orders frame = new Orders();
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
	public Orders() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 650);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaptionBorder);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 38, 530, 460);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		txtEnterCustomerrId = new JTextField();
		txtEnterCustomerrId.setText("Enter Customerr ID");
		txtEnterCustomerrId.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtEnterCustomerrId.setText(null);
			}
		});
		txtEnterCustomerrId.setHorizontalAlignment(SwingConstants.CENTER);
		txtEnterCustomerrId.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		txtEnterCustomerrId.setColumns(10);
		txtEnterCustomerrId.setBounds(30, 513, 300, 40);
		contentPane.add(txtEnterCustomerrId);
		
		JButton btnDisplay = new JButton("Display Orders");
		btnDisplay.setBackground(Color.CYAN);
		btnDisplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String custId = txtEnterCustomerrId.getText();
				
				try {
					
					Class.forName("com.mysql.cj.jdbc.Driver"); // driver name/path

					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fruitbar", "root", "");
					
			        // Create statement
			        Statement st = con.createStatement();

			        String sql = "select * from payment where cId = '"+custId+"'";
			        
			        ResultSet rs = st.executeQuery(sql);

			        
			        // Get metadata
			        ResultSetMetaData rsmd = rs.getMetaData();
			        
			
			        // Create columns in the table model
			        DefaultTableModel model = (DefaultTableModel) table.getModel();
			        
			        int columnCount = rsmd.getColumnCount();
			        String[] colName = new String [columnCount];

			        for (int i = 0; i < columnCount; i++) {
			        	colName[i] = rsmd.getColumnName(i+1);
			            //model.addColumn(metaData.getColumnName(i));
			        }
			        
		        	model.setColumnIdentifiers(colName);
			
			        // Fetch rows and add them to the table model
			        String id=null,pName=null,pPrice=null,tPrice=null,tId=null,cId=null;
			        while (rs.next()) {
			        	id = rs.getString(1);
			        	pName = rs.getString(2);
			        	pPrice = rs.getString(3);
			        	tPrice = rs.getString(4);
			        	tId = rs.getString(5);
			        	cId = rs.getString(6);
			        	String [] row = {id,pName,pPrice,tPrice,tId,cId};
			            model.addRow(row);
			            }
			        	
			        }
					
					catch(Exception ae) {
						ae.printStackTrace();
					}
				
                btnDisplay.setEnabled(false);

				
			}

		});
		btnDisplay.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDisplay.setBounds(360, 513, 200, 40);
		contentPane.add(btnDisplay);
		
		JLabel lblNewLabel = new JLabel("ORDERS");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(206, 10, 172, 18);
		contentPane.add(lblNewLabel);
		
		JButton btnHome = new JButton("Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MainPage mp = new MainPage();
				mp.setVisible(true);
				dispose();
				
			}
		});
		btnHome.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnHome.setBackground(new Color(253, 245, 230));
		btnHome.setBounds(30, 563, 530, 40);
		contentPane.add(btnHome);
		
		
	}
}

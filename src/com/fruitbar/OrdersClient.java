package com.fruitbar;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;

public class OrdersClient extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;
	JTextField txtEnterOrderId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrdersClient frame = new OrdersClient();
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
	public OrdersClient() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 601, 648);
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
		
		JButton btnDisplay = new JButton("Display Data");
		btnDisplay.setBackground(new Color(253, 245, 230));
		btnDisplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					Class.forName("com.mysql.cj.jdbc.Driver"); // driver name/path

					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fruitbar", "root", "");
					
			        // Create statement
			        Statement st = con.createStatement();

			        String sql = "SELECT * FROM payment";
			        
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
		btnDisplay.setBounds(30, 508, 530, 40);
		contentPane.add(btnDisplay);
		
		JLabel lblNewLabel = new JLabel("ORDERS");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(206, 10, 172, 18);
		contentPane.add(lblNewLabel);
		
		JButton btnDelete = new JButton("Remove Data");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String oId = txtEnterOrderId.getText();
				
				if(oId.contains("Enter Order ID")) {
					JOptionPane.showMessageDialog(btnDelete, "Please Enter the order Id");

				}
				else {
					int orderId = Integer.parseInt(oId);

					DBfruitbar dbf = new DBfruitbar();
					dbf.deleteUser(orderId);
					
					OrdersClient oc = new OrdersClient();
					oc.setVisible(true);
					dispose();
				}
				
				
				
				
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDelete.setBackground(Color.CYAN);
		btnDelete.setBounds(360, 558, 200, 40);
		contentPane.add(btnDelete);
		
		txtEnterOrderId = new JTextField();
		txtEnterOrderId.setText("Enter Order ID");
		txtEnterOrderId.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtEnterOrderId.setText(null);
			}
		});
		txtEnterOrderId.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		txtEnterOrderId.setHorizontalAlignment(SwingConstants.CENTER);
		txtEnterOrderId.setBounds(30, 558, 300, 40);
		contentPane.add(txtEnterOrderId);
		txtEnterOrderId.setColumns(10);
	}

}

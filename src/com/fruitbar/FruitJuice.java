package com.fruitbar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;



public class FruitJuice extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FruitJuice frame = new FruitJuice();
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
	public FruitJuice() {
		setTitle("Product Catalog");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 500);

        // Create panel with GridLayout
        JPanel panel = new JPanel(new GridLayout(4,1));

        // Sample product data (replace with your actual data)
        String[] products = {"Mango Shake", "Orange Shake", "Watermelon Shake","Pine Apple Shake","Mosambi Shake","Strawberry Shake","Papaya Shake","Banana Shake"};
        String[] imagePaths = {"C:\\Users\\Info\\Downloads\\mango (1).jpg", "C:\\Users\\Info\\Downloads\\orange (1).jpg", "C:\\Users\\Info\\Downloads\\watermelon (1).jpg","C:\\Users\\Info\\Downloads\\pineapple (1).jpg","C:\\Users\\Info\\Downloads\\mosambi (1).jpg","C:\\Users\\Info\\Downloads\\strawberry (1).jpg","C:\\Users\\Info\\Downloads\\papaya (1).jpg","C:\\Users\\Info\\Downloads\\banana (1).jpg"};
        int[] prices = {20,30,30,30,30,20,30,20};

        // Add products to the panel
        for (int i = 0; i < products.length; i++) {
            panel.add(createProductPanel(products[i], imagePaths[i], prices[i]));
        }

        // Add panel to the frame
        getContentPane().add(new JScrollPane(panel));

        setVisible(true);
    }

    private JPanel createProductPanel(String productName, String imagePath, int price) {
        JPanel productPanel = new JPanel(new BorderLayout());
        JLabel nameLabel = new JLabel("    " + productName);
        JLabel priceLabel = new JLabel("    RS. " + price);
        JButton buyButton = new JButton("Buy Now");

        
        // Load and scale image
        ImageIcon icon = new ImageIcon(imagePath);
        Image image = icon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        JLabel imageLabel = new JLabel(new ImageIcon(image));

        // Add components to the product panel
        productPanel.add(imageLabel, BorderLayout.WEST);
        JPanel infoPanel = new JPanel(new GridLayout(0, 1));
        infoPanel.add(nameLabel);
        infoPanel.add(priceLabel);
        productPanel.add(infoPanel, BorderLayout.CENTER);
        productPanel.add(buyButton, BorderLayout.SOUTH);

        // Action listener for the Buy Now button
        buyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Show product details
                //JOptionPane.showMessageDialog(null,"Product: " + productName + "\nPrice: $" + price);
            	String st1 = productName;
            	String st2 = String.valueOf(price);
            	//double st2 = price;
            	
            	BuyItem bi = new BuyItem();
				bi.setVisible(true);
				dispose();
				
				bi.txt1.setText(st1);
				bi.txt2.setText("RS. "+st2);
				bi.txt3.setText(st2);

            	
            }
        });

        return productPanel;
	
	}

}

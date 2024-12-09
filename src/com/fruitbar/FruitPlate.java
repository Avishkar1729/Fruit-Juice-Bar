package com.fruitbar;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

public class FruitPlate extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FruitPlate frame = new FruitPlate();
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
	public FruitPlate() {
		setTitle("Product Catalog");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 500);

        // Create panel with GridLayout
        JPanel panel = new JPanel(new GridLayout(3,1));

        // Sample product data (replace with your actual data)
        String[] products = {"Mix Fruits Plate", "Three Fruits Plate", "Two Fruits Plate","Mango Fruit Plate","Watermelon Fruit Plate","Papaya Fruit Plate"};
        String[] imagePaths = {"C:\\Users\\Info\\Downloads\\fruitplate (1).jpg", "C:\\Users\\Info\\Downloads\\three fruits (1).jpg", "C:\\Users\\Info\\Downloads\\two fruits (1).jpg","C:\\Users\\Info\\Downloads\\mago plate (1).jpg","C:\\Users\\Info\\Downloads\\watermelon plate (1).jpg","C:\\Users\\Info\\Downloads\\papaya plate (1).jpg"};
        int[] prices = {50,40,40,30,30,30};

        // Add products to the panel
        for (int i = 0; i < products.length; i++) {
            panel.add(createProductPanel(products[i], imagePaths[i], prices[i]));
        }

        // Add panel to the frame
        add(new JScrollPane(panel));

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

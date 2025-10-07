// This window emulates the scanning of an item. Every time the buttom is pressed
// it will send a notification of a UPC code

import java.awt.BorderLayout;

//adding libriaries to read the file
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;

import javax.swing.JPanel;


public class Scanner {
	// Scanner uses Swing framework to create a UPC code
	 private JFrame frame;
	 private JPanel scannerPanel;
	 private JButton scanButton;

	 //create list to store product data
	 ArrayList<String[]> productData = new ArrayList<>();
	 
	 //create random number generator
	 Random rand = new Random();
	 
	 public Scanner() {

		 //load data from text file
		  loadData("productData.txt");

		  frame = new JFrame("Scanner");
		  frame.getContentPane().setLayout(new BorderLayout());
		  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  frame.setSize(100, 100);
		  frame.setLocation(300,50);
		  frame.setVisible(true);
		  
		  
		  // Create UI elements
		  scanButton = new JButton("Scan");
		  scannerPanel = new JPanel();
		  
		  // Add UI element to frame
		  scannerPanel.add(scanButton);
		  frame.getContentPane().add(scannerPanel);
		  
		  scanButton.addActionListener(e -> generateUPC());
	 }
	
	 private void loadData(String filename) {
		//read data from text file and store in array list
		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
		    String line;

			boolean firstLine = true; // Flag to skip the first line
		    while ((line = br.readLine()) != null) {
		        if (firstLine) {
		            firstLine = false; // Skip the first line
		            continue;
		        }

				// split by white space
		        String[] parts = line.trim().split("\\s+");
		        if (parts.length == 3) {
		            productData.add(parts);
		        }
		    }
		} catch (IOException e) {
		    System.err.println("Error reading file: " + e.getMessage());
		}
	} 
	
	private void generateUPC() { //changed to void
			//changed to see if product data is being read
		if (productData.isEmpty()) {
			System.out.println("No product data available.");
			return; // Return an invalid UPC code
		}

		//generate random index to select product from list
		int index = rand.nextInt(productData.size());
		String[] productInfo = productData.get(index);
		String upc = productInfo[0];
        String name = productInfo[1];
        String price = productInfo[2];

        System.out.println("Scanned UPC: " + upc);
        System.out.println("Product: " + name);
        System.out.println("Price: $" + price);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JPanel getScannerPanel() {
		return scannerPanel;
	}

	public void setScannerPanel(JPanel scannerPanel) {
		this.scannerPanel = scannerPanel;
	}

	public JButton getScanButton() {
		return scanButton;
	}

	public void setScanButton(JButton scanButton) {
		this.scanButton = scanButton;
	}	 
	 

}

import java.awt.BorderLayout;
 
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class View {
	// View uses Swing framework to display UI to user
	 private JFrame frame;
	 private JLabel firstnameLabel;
	 private JLabel lastnameLabel;
	 private JTextField firstnameTextfield;
	 private JTextField lastnameTextfield;
	 private JButton firstnameSaveButton;
	 private JButton lastnameSaveButton;
	 private JButton hello;
	 private JButton bye;

	// Cash Register fields
    private JTextArea itemsArea;
    private JLabel subtotalLabel;
    private JButton scanButton;
	
	 public View(String title) {
	  frame = new JFrame(title);
	  frame.getContentPane().setLayout(new BorderLayout());
	  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  frame.setSize(500, 120);
	  frame.setLocationRelativeTo(null);
	  frame.setVisible(true);
	 
	  // Create UI elements
	  firstnameLabel = new JLabel("Firstname :");
	  lastnameLabel = new JLabel("Lastname :");
	  firstnameTextfield = new JTextField();
	  lastnameTextfield = new JTextField();
	  firstnameSaveButton = new JButton("Save firstname");
	  lastnameSaveButton = new JButton("Save lastname");
	  hello = new JButton("Hello!");
	  bye = new JButton("Bye!");
	 
        JPanel namePanel = new JPanel();
        namePanel.setLayout(new GridLayout(2,1));

        JPanel firstPanel = new JPanel();
        firstPanel.add(firstnameLabel);
        firstPanel.add(firstnameTextfield);
        firstPanel.add(firstnameSaveButton);
        firstPanel.add(hello);

        JPanel lastPanel = new JPanel();
        lastPanel.add(lastnameLabel);
        lastPanel.add(lastnameTextfield);
        lastPanel.add(lastnameSaveButton);
        lastPanel.add(bye);

        namePanel.add(firstPanel);
        namePanel.add(lastPanel);

        // ----- Cash Register UI -----
        JPanel registerPanel = new JPanel();
        registerPanel.setLayout(new BorderLayout());

        itemsArea = new JTextArea(10, 30);
        itemsArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(itemsArea);

        subtotalLabel = new JLabel("Subtotal: $0.00");
        subtotalLabel.setHorizontalAlignment(SwingConstants.CENTER);

        scanButton = new JButton("Scan");

        registerPanel.add(scanButton, BorderLayout.NORTH);
        registerPanel.add(scrollPane, BorderLayout.CENTER);
        registerPanel.add(subtotalLabel, BorderLayout.SOUTH);

        // ----- Combine Panels -----
        frame.setLayout(new BorderLayout());
        frame.add(namePanel, BorderLayout.NORTH);
        frame.add(registerPanel, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    // Original getters
    public JTextField getFirstnameTextfield() { return firstnameTextfield; }
    public JTextField getLastnameTextfield() { return lastnameTextfield; }
    public JButton getFirstnameSaveButton() { return firstnameSaveButton; }
    public JButton getLastnameSaveButton() { return lastnameSaveButton; }
    public JButton getHello() { return hello; }
    public JButton getBye() { return bye; }

    // Cash Register getter
    public JButton getScanButton() { return scanButton; }

    // Update display using String[] (name and price)
    public void updateDisplay(List<String[]> items, double subtotal) {
        itemsArea.setText("");
        for (String[] p : items) {
            itemsArea.append(p[1] + " - $" + p[2] + "\n"); // Name - Price
        }
        subtotalLabel.setText(String.format("Subtotal: $%.2f", subtotal));
    }
	 
	 public void setBye(JButton bye) {
	  this.bye = bye;
	 }
}
	 
}

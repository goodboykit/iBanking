package iBanking;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import queuemanagement.CustomizedPanels.RoundPanels;
import queuemanagement.CustomizedPanels.RoundedButton;
import queuemanagement.CustomizedPanels.RoundedCornerTextField;

public class Depositt extends JFrame {

    private JPanel contentPane;
    private Interface IF;
    private JTextField textField;

    public Depositt(String accountNumber) {
    	
        IF = new Interface(accountNumber);


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1250, 800);
        setLocationRelativeTo(null);
	    setUndecorated(true); // Remove default frame decorations


        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(0,72,134));

        contentPane.setLayout(null);
        setContentPane(contentPane);
        
                RoundedButton depositBtn = new RoundedButton("DEPOSIT");
                depositBtn.setBounds(394, 680, 440, 86);
                contentPane.add(depositBtn);
                depositBtn.setBackground(new Color(53, 76, 124));
                
                        depositBtn.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseEntered(MouseEvent e) {
                                depositBtn.setBackground(new Color(112, 128, 144)); // Change background color on hover
                            }
                
                            @Override
                            public void mouseExited(MouseEvent e) {
                                depositBtn.setBackground(new Color(53, 76, 124));
                            }
                
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                double depositAmount = Double.parseDouble(textField.getText().trim());
                                updateAccountFile(accountNumber, depositAmount);
                                
                                Transaction trans = new Transaction(accountNumber);
                	            trans.setVisible(true);
                	            
                                dispose();
                            }
                        });
        
                textField = new RoundedCornerTextField();
                textField.setBounds(369, 573, 526, 75);
                contentPane.add(textField);
                textField.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
                textField.setColumns(10);
                textField.setHorizontalAlignment(SwingConstants.CENTER);
                textField.setMargin(new Insets(5, 10, 5, 10));
                textField.setBorder(null);
        
                JLabel lblNewLabel_2 = new JLabel("Enter the Deposit Amount:");
                lblNewLabel_2.setForeground(new Color(255, 251, 248));
                lblNewLabel_2.setBounds(394, 537, 374, 31);
                contentPane.add(lblNewLabel_2);
                lblNewLabel_2.setFont(new Font("FONTSPRING DEMO - Organetto UltraCnd Light", Font.PLAIN, 28));
                
                JLabel lblNewLabel = new JLabel("New label");
                lblNewLabel.setIcon(new ImageIcon(Depositt.class.getResource("/iBanking/Untitled (2048 × 2048 px) (100 × 100 px)-4.png")));
                lblNewLabel.setBounds(480, 136, 275, 263);
                contentPane.add(lblNewLabel);
                
                JLabel lblNewLabel_1_1 = new JLabel("");
                lblNewLabel_1_1.setIcon(new ImageIcon(Depositt.class.getResource("/iBanking/Untitled (2048 × 2048 px) (100 × 100 px)-3.png")));
                lblNewLabel_1_1.setBounds(131, 37, 500, 62);
                contentPane.add(lblNewLabel_1_1);
                
                JLabel lblNewLabel_2_1 = new JLabel("");
                lblNewLabel_2_1.setIcon(new ImageIcon(Depositt.class.getResource("/iBanking/Untitled (2048 × 2048 px) (100 × 100 px).png")));
                lblNewLabel_2_1.setBounds(23, -17, 134, 172);
                contentPane.add(lblNewLabel_2_1);
                
                JPanel panel_1 = new JPanel();
                panel_1.setBounds(-6, 136, 1250, 4);
                contentPane.add(panel_1);
                
                JLabel close = new JLabel("");
                close.addMouseListener(new MouseAdapter() {
                	@Override
                	public void mouseClicked(MouseEvent e) {
                		dispose();
                	}
                });
                close.setIcon(new ImageIcon(Depositt.class.getResource("/iBanking/Close(3).png")));
                close.setBounds(1183, 27, 61, 39);
                contentPane.add(close);
                
                JLabel lblNewLabel_5 = new JLabel("RETURN TO MAIN MENU");
                lblNewLabel_5.setForeground(new Color(255, 251, 248));
                lblNewLabel_5.setFont(new Font("FONTSPRING DEMO - Organetto Cnd Light", Font.PLAIN, 31));
                lblNewLabel_5.setBounds(891, 78, 308, 39);
                contentPane.add(lblNewLabel_5);
                
                // Mouse hover effect for btn_signIn
                lblNewLabel_5.addMouseListener(new MouseAdapter() {
     					    @Override
     					    public void mouseEntered(MouseEvent e) {
     					    	lblNewLabel_5.setForeground(new Color (232, 175, 48));// Change background color on hover
     					    }

     					    @Override
     					    public void mouseExited(MouseEvent e) {
     					    	lblNewLabel_5.setForeground(new Color(255, 251, 248));
     					    }
     					    
     					    @Override
     					    public void mouseClicked (MouseEvent e) {
   					    	Interface IF = new Interface(accountNumber);
   					    	IF.setVisible(true);
   					    	dispose();
   					    }
     					
     				});	
                
                
                
                JLabel lblNewLabel_1 = new JLabel("New label");
                lblNewLabel_1.setIcon(new ImageIcon(Depositt.class.getResource("/iBanking/Deposit Header.png")));
                lblNewLabel_1.setBounds(384, 411, 500, 87);
                contentPane.add(lblNewLabel_1);
    }

    
    private void updateAccountFile(String accountNumber, double depositAmount) {
        if (depositAmount <= 0) {
            JOptionPane.showMessageDialog(contentPane, "Invalid deposit amount.");
            return;
        }

        Path accountFilePath = Paths.get("NewAccount.txt");

        try {
            // Read all lines from the account file
            List<String> lines = Files.readAllLines(accountFilePath);

            boolean accountFound = false;
            List<String> updatedLines = new ArrayList<>();
            for (String line : lines) {
                String[] fields = line.split(",");

                if (fields.length >= 12 && fields[0].equals(accountNumber)) {
                    double currentBalance = Double.parseDouble(fields[9]);
                    currentBalance += depositAmount;
                    fields[9] = String.format("%.2f", currentBalance);
                    accountFound = true;

                    // Append transaction details to the transaction file
                    appendDepositTransaction(accountNumber, "Deposit", depositAmount);
                }
                updatedLines.add(String.join(",", fields));
            }

            if (!accountFound) {
                JOptionPane.showMessageDialog(contentPane, "Account not found.");
                return;
            }

            // Write the updated account details back to the account file
            Files.write(accountFilePath, updatedLines);

            // Handle deposit success here, e.g., display a success message on the UI
            textField.setText(""); // Clear the text field
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    
    private void appendDepositTransaction(String accountNumber, String type, double amount) {
        try {
            // Get the current timestamp
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String timestamp = dateFormat.format(new Date());

            // Append the deposit transaction details to the transaction file
            String transactionDetails = timestamp + ",Deposit," + amount + "\n";
            Files.write(Paths.get(accountNumber + "_transactions.txt"), transactionDetails.getBytes(),
                    StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println("Error appending deposit transaction: " + e.getMessage());
        }
    }

 }


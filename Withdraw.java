package iBanking;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

import javax.swing.text.AttributeSet;
import javax.swing.text.PlainDocument;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedWriter;

import java.text.SimpleDateFormat;

import queuemanagement.CustomizedPanels.RoundedButton;
import queuemanagement.CustomizedPanels.RoundedCornerTextField;
import queuemanagement.CustomizedPanels.RoundPanels;
import javax.swing.JLabel;
import javax.swing.JDialog;

import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.InputVerifier;

import java.awt.Font;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.InputMismatchException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Withdraw extends JFrame {

    private JPanel contentPane;
    private Transaction trans;
    
    private Interface IF;
    private JTextField textField;
    private String accountNumber;

    public Withdraw(String accountNumber) {
        this.accountNumber = accountNumber;
        
        IF = new Interface(accountNumber);
        trans = new Transaction(accountNumber);
        

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1250, 800);
        setLocationRelativeTo(null);
         setUndecorated(true); // Remove default frame decorations

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(0,72,134));


        setContentPane(contentPane);
        contentPane.setLayout(null);
        
                RoundedButton withdrawbtn = new RoundedButton("WITHDRAW");
                withdrawbtn.setFont(new Font("FONTSPRING DEMO - Organetto Cnd Bold", Font.PLAIN, 19));
                withdrawbtn.setBounds(371, 680, 453, 86);
                contentPane.add(withdrawbtn);
                withdrawbtn.setBackground(new Color(53, 76, 124));
                
                        withdrawbtn.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseEntered(MouseEvent e) {
                                withdrawbtn.setBackground(new Color(112, 128, 144)); // Change background color on hover
                            }
                
                            @Override
                            public void mouseExited(MouseEvent e) {
                                withdrawbtn.setBackground(new Color(53, 76, 124));
                            }
                
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                double withdrawalAmount = Double.parseDouble(textField.getText().trim());
                                if (withdrawalAmount <= 0) {
                                    JDialog dialog = new JDialog(Withdraw.this, "Invalid Amount", true);
                                    JOptionPane.showMessageDialog(dialog, "Please enter a valid withdrawal amount.");
                                    
                                    
                                } else {
                                    updateAccountFile(accountNumber, withdrawalAmount);
                                    trans.setVisible(true);
                                    dispose();
                                }
                            }
                        });

    
        
                textField = new RoundedCornerTextField();
                textField.setBounds(350, 559, 500, 75);
                contentPane.add(textField);
                textField.setFont(new Font("FONTSPRING DEMO - Organetto Cnd Light", Font.PLAIN, 24));
                textField.setColumns(10);
                textField.setHorizontalAlignment(SwingConstants.CENTER);
                textField.setMargin(new Insets(5, 10, 5, 10));
                textField.setBorder(null);
                
                        PlainDocument doc = (PlainDocument) textField.getDocument();
        
                JLabel lblNewLabel_2 = new JLabel("Withdraw Amount:");
                lblNewLabel_2.setForeground(new Color(255, 251, 248));
                lblNewLabel_2.setBounds(356, 516, 190, 31);
                contentPane.add(lblNewLabel_2);
                lblNewLabel_2.setFont(new Font("FONTSPRING DEMO - Organetto UltraCnd Light", Font.PLAIN, 28));
                
                JLabel lblNewLabel = new JLabel("");
                lblNewLabel.setIcon(new ImageIcon(Withdraw.class.getResource("/iBanking/Untitled (2048 × 2048 px) (100 × 100 px)-4.png")));
                lblNewLabel.setBounds(463, 69, 246, 373);
                contentPane.add(lblNewLabel);
                
                JLabel lblNewLabel_2_1 = new JLabel("");
                lblNewLabel_2_1.setIcon(new ImageIcon(Withdraw.class.getResource("/iBanking/Untitled (2048 × 2048 px) (100 × 100 px).png")));
                lblNewLabel_2_1.setBounds(17, -32, 134, 172);
                contentPane.add(lblNewLabel_2_1);
                
                JLabel lblNewLabel_1_1 = new JLabel("");
                lblNewLabel_1_1.setIcon(new ImageIcon(Withdraw.class.getResource("/iBanking/Untitled (2048 × 2048 px) (100 × 100 px)-3.png")));
                lblNewLabel_1_1.setBounds(125, 22, 500, 62);
                contentPane.add(lblNewLabel_1_1);
                
                JPanel panel_1 = new JPanel();
                panel_1.setBounds(0, 115, 1250, 4);
                contentPane.add(panel_1);
                
                JLabel lblNewLabel_1 = new JLabel("");
                lblNewLabel_1.setIcon(new ImageIcon(Withdraw.class.getResource("/iBanking/Withdraw Header.png")));
                lblNewLabel_1.setBounds(340, 251, 525, 373);
                contentPane.add(lblNewLabel_1);
                
                
                
                
                JLabel close = new JLabel("");
                close.addMouseListener(new MouseAdapter() {
                	@Override
                	public void mouseClicked(MouseEvent e) {
                		dispose();
                	}
                });
                close.setIcon(new ImageIcon(Withdraw.class.getResource("/iBanking/Close(3).png")));
                close.setBounds(1189, 6, 61, 39);
                contentPane.add(close);
                
                JLabel returnMain = new JLabel("RETURN TO MAIN MENU");
			    returnMain.setForeground(new Color(255, 251, 248));
                returnMain.setFont(new Font("FONTSPRING DEMO - Organetto Cnd Light", Font.PLAIN, 31));
                returnMain.setBounds(897, 57, 308, 39);
                contentPane.add(returnMain);
                
                
                // Mouse hover effect for btn_signIn
                returnMain.addMouseListener(new MouseAdapter() {
     					    @Override
     					    public void mouseEntered(MouseEvent e) {
     					    	returnMain.setForeground(new Color (232, 175, 48));// Change background color on hover
     					    }

     					    @Override
     					    public void mouseExited(MouseEvent e) {
     					    	returnMain.setForeground(new Color(255, 251, 248));
     					    }
     					    
     					    @Override
     					    public void mouseClicked (MouseEvent e) {
   					    	IF.setVisible(true);
   					    	dispose();
   					    }
     					
     				});	
                
    
                
        doc.setDocumentFilter(new NumberDocumentFilter());
    }

    public class NumberDocumentFilter extends DocumentFilter {
        @Override
        public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr)
                throws BadLocationException {
            StringBuilder builder = new StringBuilder(string);
            for (int i = builder.length() - 1; i >= 0; i--) {
                int cp = builder.codePointAt(i);
                if (!Character.isDigit(cp)) {
                    builder.deleteCharAt(i);
                    if (Character.isSupplementaryCodePoint(cp)) {
                        i--;
                        builder.deleteCharAt(i);
                    }
                }
            }
            super.insertString(fb, offset, builder.toString(), attr);
        }

        @Override
        public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
                throws BadLocationException {
            if (text != null) {
                StringBuilder builder = new StringBuilder(text);
                for (int i = builder.length() - 1; i >= 0; i--) {
                    int cp = builder.codePointAt(i);
                    if (!Character.isDigit(cp)) {
                        builder.deleteCharAt(i);
                        if (Character.isSupplementaryCodePoint(cp)) {
                            i--;
                            builder.deleteCharAt(i);
                        }
                    }
                }
                text = builder.toString();
            }
            super.replace(fb, offset, length, text, attrs);
        }
    }

    private void updateAccountFile(String accountNumber, double withdrawalAmount) {
        Path accountFilePath = Paths.get("NewAccount.txt");
        Path transactionFilePath = Paths.get(accountNumber + "_transactions.txt");

        try {
            // Read all lines from the account file
            List<String> lines = Files.readAllLines(accountFilePath);

            boolean accountFound = false;
            List<String> updatedLines = new ArrayList<>();
            for (String line : lines) {
                String[] fields = line.split(",");

                if (fields.length >= 12 && fields[0].equals(accountNumber)) {
                    double currentBalance = Double.parseDouble(fields[9]);
                    if (currentBalance < withdrawalAmount) {
                        JDialog dialog = new JDialog(this, "Insufficient funds", true);
                        JOptionPane.showMessageDialog(dialog, "Insufficient funds in the account.");
                        IF.setVisible(true);
                        dispose();
                        return; // Add this line to exit the method and prevent further execution
                    }
                   

                    currentBalance -= withdrawalAmount;
                    fields[9] = String.format("%.2f", currentBalance);
                    accountFound = true;

                    // Append transaction details to the transaction file
                    appendTransaction(accountNumber, "Withdrawal", withdrawalAmount);
                }
                updatedLines.add(String.join(",", fields));
            }

            if (!accountFound) {
                JOptionPane.showMessageDialog(contentPane, "Account not found.");
                return ;
            }

            // Write the updated account details back to the account file
            Files.write(accountFilePath, updatedLines);

            // Handle withdrawal success here, e.g., display a success message on the UI
            textField.setText(""); // Clear the text field
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    

    private void appendTransaction(String accountNumber, String type, double amount) {
        try {
            // Get the current timestamp
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String timestamp = dateFormat.format(new Date());

            // Append the transaction details to the transaction file
            String transactionDetails = timestamp + "," + type + "," + amount + "\n";
            Files.write(Paths.get(accountNumber + "_transactions.txt"), transactionDetails.getBytes(),
                    StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println("Error appending transaction: " + e.getMessage());
        }
    }
}

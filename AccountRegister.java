package iBanking;

import java.awt.Color;


import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import java.nio.file.Files;
import java.nio.file.Paths;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPasswordField;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.BorderFactory;
import java.awt.Font;
import queuemanagement.CustomizedPanels.RoundedCornerTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import queuemanagement.CustomizedPanels.RoundedButton;
import queuemanagement.CustomizedPanels.RoundedCornerTextArea;
import queuemanagement.CustomizedPanels.RoundedCornerTextField;
import queuemanagement.CustomizedPanels.ImgRoundedPanel;
import queuemanagement.CustomizedPanels.RoundPanels;

public class AccountRegister extends JFrame {

	private JPanel contentPane;
	private JPasswordField PINpassfield;
	private JPasswordField confirmField;
	private JCheckBox chckbxNewCheckBox;
	//--------------------------------------------------------------------------
    private static final String  ACCOUNT_DETAILS_FILE = "NewAccount.txt";
	boolean clicked = false, clicked2 = false, clicked3 = false, clicked4 = false;


	public AccountRegister() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1215, 800);
		setLocationRelativeTo(null);
	    setUndecorated(true); // Remove default frame decorations

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(0,72,134));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(6, 105, 1215, 2);
		panel.setBackground(new Color(215, 203, 196));
		contentPane.add(panel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(141, 19, 500, 62);
		lblNewLabel_1.setIcon(new ImageIcon(AccountRegister.class.getResource("/iBanking/Untitled (2048 × 2048 px) (100 × 100 px)-3.png")));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(33, -35, 134, 172);
		lblNewLabel_2.setIcon(new ImageIcon(AccountRegister.class.getResource("/iBanking/Untitled (2048 × 2048 px) (100 × 100 px).png")));
		contentPane.add(lblNewLabel_2);
		
		JLabel close = new JLabel("");
		close.setBounds(1166, 6, 61, 39);
		close.setIcon(new ImageIcon(AccountRegister.class.getResource("/iBanking/Close(3).png")));
		
		close.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose(); // Dispose the frame when the label is clicked
            }
        });
		
		RoundedCornerTextField accountNo = new RoundedCornerTextField();
		accountNo.setEnabled(false);
		accountNo.setFont(new Font("FONTSPRING DEMO - Organetto UltraCnd Light", Font.PLAIN, 20));
		accountNo.setMargin(new Insets(5, 10, 5, 10));
		accountNo.setHorizontalAlignment(SwingConstants.CENTER);
		accountNo.setForeground(new Color(49, 62, 138));
		accountNo.setColumns(9);
		accountNo.setBorder(null);
		accountNo.setBounds(366, 465, 454, 57);
		
		String filePath = "NewAccount.txt";
        String accountNumber = getLatestAccountNumberFromFile(filePath);
        accountNo.setText(accountNumber);
        accountNo.setText(accountNumber);
		
		contentPane.add(accountNo);
		contentPane.add(close);
		
		
		PINpassfield = new JPasswordField(8) { // CreateAcc password field "Password"
			@Override
		    protected void paintComponent(Graphics g) {
		        int w = getWidth();
		        int h = getHeight();
		        Graphics2D g2 = (Graphics2D) g.create();
		        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		        g2.setColor(Color.WHITE);
		        g2.fillRoundRect(1, 1, w - 3, h - 3, h, h);

		        // Get the text in the password field
		        char[] password = getPassword();
		        String text = new String(password);

		        // Set the border color based on the conditions
		        if (!clicked || !text.equals(new String(confirmField.getPassword()))) {
		            g2.setColor(Color.RED);
		            
		        } else {
		            g2.setColor(Color.GREEN);

		        }

		        // Draw only the border
		        g2.drawRoundRect(0, 0, w - 1, h - 1, h, h);

		        g.setColor(getBackground());
		        super.paintComponent(g);
		    }
		    
		    @Override
		    protected void processFocusEvent(FocusEvent e) {
		        super.processFocusEvent(e);
		        clicked = true;
		        repaint();
		    }
		};
		
		
		PINpassfield.setDocument(new PlainDocument() {
			
            public void insertString(int offset, String text, AttributeSet attr) throws BadLocationException {
                // Check if the text contains only numeric characters
                if (text.matches("\\d+")) {
                    super.insertString(offset, text, attr);
                }
            }

            public void replace(int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                // Check if the text contains only numeric characters
                if (text.matches("\\d+")) {
                    super.replace(offset, length, text, attrs);
                }
            }
        });
		PINpassfield.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		
		PINpassfield.setOpaque(false);
		PINpassfield.setBounds(680, 594, 245, 57);
		PINpassfield.setBorder(BorderFactory.createEmptyBorder(14, 16, 14, 32));
		
		contentPane.add(PINpassfield);
		
		

		ImageIcon hideIcon = new ImageIcon(Register.class.getResource("/iBanking/hide.png"));
		ImageIcon showIcon = new ImageIcon(Register.class.getResource("/iBanking/Secure.png"));
						
		JButton hide = new JButton(hideIcon);
		hide.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		}
		});
		
		hide.setBounds(937, 594, 50, 57);
		hide.setBorderPainted(false);
		hide.setContentAreaFilled(false);
		hide.setOpaque(false);
		hide.setVisible(false);
		contentPane.add(hide);
		
		JLabel PINIcon = new JLabel(showIcon); // Set the initial icon to showIcon
		PINIcon.setBounds(937, 594, 50, 57);
		contentPane.add(PINIcon);
								
		hide.addMouseListener(new MouseAdapter() {
		 @Override
		public void mousePressed(MouseEvent e) {
			if (clicked3) {
			hide.setIcon(hideIcon);
			clicked3 = false;
			PINpassfield.setEchoChar('•');
			//confirmPInField.setEchoChar('•');
			PINIcon.setIcon(showIcon); // Update PINIcon to showIcon
		} else {
			hide.setIcon(showIcon);
			clicked3 = true;
			PINpassfield.setEchoChar((char) 0);
			//confirmPInField.setEchoChar((char) 0);
			PINIcon.setIcon(showIcon); // Update PINIcon to showIcon
		}
	 }
	});


		// Add a FocusListener to the JTextField
		PINpassfield.addFocusListener(new FocusListener() {
		    @Override
		    public void focusGained(FocusEvent e) {
		        hide.setVisible(true);
		    }

		    @Override
		    public void focusLost(FocusEvent e) {
		        hide.setVisible(false);
		    }
		});
		
		//--------------------------------------------------------------------------

		confirmField = new JPasswordField(6) { // CreateAcc password field "Password"
			private static final long serialVersionUID = 1L;

			@Override
		    protected void paintComponent(Graphics g) {
		        int w = getWidth();
		        int h = getHeight();
		        Graphics2D g2 = (Graphics2D) g.create();
		        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		        g2.setColor(Color.WHITE);
		        g2.fillRoundRect(1, 1, w - 2, h - 2, h, h);
		        // Get the text in the password field
		        char[] password = getPassword();
		        String text = new String(password);

		        // Set the border color based on the conditions
		        if (text.length() != 6) {
		            g2.setColor(Color.RED);
		        } else if (text.length() == 6 && getCaretPosition() < 6) {
		            g2.setColor(Color.YELLOW);
		        } else {
		            g2.setColor(Color.GREEN);
		        }

		        // Draw only the border
		        g2.drawRoundRect(0, 0, w - 1, h - 1, h, h);
		  
				g.setColor(getBackground());
		        super.paintComponent(g);
		    }
		};
		
		confirmField.setDocument(new PlainDocument() {
			
            public void insertString(int offset, String text, AttributeSet attr) throws BadLocationException {
                // Check if the text contains only numeric characters
                if (text.matches("\\d+")) {
                    super.insertString(offset, text, attr);
                }
            }

            public void replace(int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                // Check if the text contains only numeric characters
                if (text.matches("\\d+")) {
                    super.replace(offset, length, text, attrs);
                }
            }
        });
		confirmField.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		
		confirmField.setOpaque(false);
		confirmField.setBounds(282, 594, 261, 57);
		confirmField.setBorder(BorderFactory.createEmptyBorder(14, 16, 14, 32));
		
		contentPane.add(confirmField);
		
		//--------------------------------------------------------------------------


		ImageIcon hideIcon1 = new ImageIcon((Register.class.getResource("/iBanking/Show Password.png")));
		ImageIcon showIcon1 = new ImageIcon(Register.class.getResource("/iBanking/Password.png"));
		
		JButton hide1 = new JButton(hideIcon1);
		hide1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		hide1.setBounds(555, 594, 50, 57);
		hide1.setBorderPainted(false);
		hide1.setContentAreaFilled(false);
		hide1.setOpaque(false);
		hide1.setVisible(false);
		contentPane.add(hide1);
		
		JLabel PINIcon1 = new JLabel(showIcon1); // Set the initial icon to showIcon
		PINIcon1.setBounds(555, 594, 50, 57);
		contentPane.add(PINIcon1);
		
				hide1.addMouseListener(new MouseAdapter() {
				    @Override
				    public void mousePressed(MouseEvent e) {
				        if (clicked2) {
				            hide1.setIcon(hideIcon1);
				            clicked2 = false;
				            confirmField.setEchoChar('•');
				            //confirmPInField.setEchoChar('•');
				            PINIcon1.setIcon(showIcon1); // Update PINIcon to showIcon
				        } else {
				            hide1.setIcon(showIcon1);
				            clicked2 = true;
				            confirmField.setEchoChar((char) 0);
				            //confirmPInField.setEchoChar((char) 0);
				            PINIcon1.setIcon(showIcon1); // Update PINIcon to showIcon
				        }
				    }
				});
		

		// Add a FocusListener to the JTextField
		confirmField.addFocusListener(new FocusListener() {
		    @Override
		    public void focusGained(FocusEvent e) {
		        hide1.setVisible(true);
		    }

		    @Override
		    public void focusLost(FocusEvent e) {
		        hide1.setVisible(false);
		    }
		});
		
				
		//--------------------------------------------------------------------------

		chckbxNewCheckBox = new JCheckBox("Agree with");
		chckbxNewCheckBox.setForeground(new Color(249, 253, 236));
		chckbxNewCheckBox.setFont(new Font("FONTSPRING DEMO - Organetto Cnd Light", Font.PLAIN, 22));
		chckbxNewCheckBox.setBounds(451, 679, 139, 23);
		contentPane.add(chckbxNewCheckBox);
		
		JLabel lblTermsAndConditions = new JLabel("Terms and Conditions");
		lblTermsAndConditions.setFont(new Font("FONTSPRING DEMO - Organetto Cnd Bold", Font.PLAIN, 22));
		lblTermsAndConditions.setForeground(new Color(248, 254, 246));
		lblTermsAndConditions.setBounds(590, 680, 237, 23);
		contentPane.add(lblTermsAndConditions);
		
		UIManager.put("OptionPane.messageFont", new Font("Open Sans Bold", Font.TRUETYPE_FONT, 15));

		lblTermsAndConditions.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String message = "By creating a user account, you agree to the following terms and conditions:\n\n"
						+ "1. You must provide accurate and complete information during the registration process,\nincluding your full name, username, and any other information that may be required.\n\n"
						+ "2. You must choose a strong and secure password and keep it confidential. You are\nsolely responsible for maintaining the confidentiality of your password and\naccount information.\n\n"
						+ "3. You are solely responsible for all activities that occur under your account.\nYou agree to notify us immediately of any unauthorized use of your account\nor any other breach of security.\n\n"
						+ "4. You may not use the user account to engage in any illegal or unauthorized activity,\nincluding but not limited to violating any applicable laws or regulations, infringing\non any intellectual property rights, or accessing any restricted areas\nor confidential information.\n\n"
						+ "5. You may not share your user account or password with anyone else,\nor allow anyone else to access your account.\n\n"
						+ "6. We reserve the right to suspend or terminate your user account at any time,\nfor any reason, without notice or liability to you.\n\n"
						+ "7. You agree to indemnify and hold us harmless from any claims, damages,\nor losses arising from your use of the user account or any breach of\nthese terms and conditions.\n\n"
						+ "Do you agree to these terms and conditions?";

				int choice = JOptionPane.showOptionDialog(null, message, "Terms and Conditions",
						JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);
				
				if (choice == JOptionPane.YES_OPTION) {
					// User agreed to the terms and conditions
		            chckbxNewCheckBox.setSelected(true); // Set the checkbox as checked
					System.out.println("Agree");
				} else {
					
					// User did not agree to the terms and conditions
		            chckbxNewCheckBox.setSelected(false); // Set the checkbox as checked
					System.out.println("Do not Agree");
				}
			}
		});
		
		
		
		//--------------------------------------------------------------------------

		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setBounds(372, 105, 500, 313);
		lblNewLabel_1_1.setIcon(new ImageIcon(AccountRegister.class.getResource("/iBanking/Registration Pin Icon.png")));
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblEnterYourDesired = new JLabel("Enter your 6 desired PIN:");
		lblEnterYourDesired.setFont(new Font("FONTSPRING DEMO - Organetto Cnd Bold", Font.BOLD, 21));
		lblEnterYourDesired.setForeground(new Color(250, 255, 231));
		lblEnterYourDesired.setBounds(282, 544, 237, 50);
		contentPane.add(lblEnterYourDesired);
		
		JLabel lblYourAccountNumber = new JLabel("Your Account Number:");
		lblYourAccountNumber.setForeground(new Color(250, 255, 231));
		lblYourAccountNumber.setFont(new Font("FONTSPRING DEMO - Organetto Cnd Bold", Font.BOLD, 21));
		lblYourAccountNumber.setBounds(366, 430, 218, 23);
		contentPane.add(lblYourAccountNumber);
		
	
		JLabel lblEnterYourDesired_1 = new JLabel("Confirm your PIN Password");
		lblEnterYourDesired_1.setForeground(new Color(250, 255, 231));
		lblEnterYourDesired_1.setFont(new Font("FONTSPRING DEMO - Organetto Cnd Bold", Font.BOLD, 21));
		lblEnterYourDesired_1.setBounds(670, 544, 255, 50);
		contentPane.add(lblEnterYourDesired_1);
		
		RoundedButton register = new RoundedButton("Register your Account");
		register.setFont(new Font("FONTSPRING DEMO - Organetto Cnd Light", Font.PLAIN, 19));
		register.setBorder(null);
		register.setBackground(new Color(70, 130, 180));
		register.setBounds(466, 724, 331, 70);
		contentPane.add(register);
		
		
		// Mouse hover effect for btn_signIn
				register.addMouseListener(new MouseAdapter() {
						    @Override
						    public void mouseEntered(MouseEvent e) {
						    	register.setBackground(new Color(112,128,144)); // Change background color on hover
						    }

						    @Override
						    public void mouseExited(MouseEvent e) {
								register.setBackground(new Color(70,130,180));
						    }
							@Override
							public void mouseClicked(MouseEvent e) {
								
								if (!chckbxNewCheckBox.isSelected()) {
						            JOptionPane.showMessageDialog(null, "Please accept the terms and conditions.");
						            return;
						            
								}
								 
								if (isFieldsFilled()) {
							        saveData();
							        isFieldsFilled();
							  
							        String filePath = "NewAccount.txt"; // Replace with the actual path to your text file
							        String accountNumber = getAccountNumberFromFile(filePath); // Get the current account number
							        accountNo.setText(accountNumber); // Update the accountNo TextField with the current account number
						            
							        RegSuccessful reg = new RegSuccessful();
							        reg.setVisible(true);
							        dispose();
							 }

							 
								
							}
						});	
						
		}
	
	
	private String getAccountNumberFromFile(String filePath) {
	    try {
	        String content = new String(Files.readAllBytes(Paths.get(filePath)));
	        String[] parts = content.split(",");
	        return parts[0].trim();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    return ""; // Return an empty string if an error occurs
	}
	
	private static String getLatestAccountNumberFromFile(String filePath) {
	    String accountNumber = "";
	    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
	        String line;
	        while ((line = reader.readLine()) != null) {
	            String[] parts = line.split(",");
	            if (parts.length > 0) {
	                accountNumber = parts[0];
	            }
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    return accountNumber;
	}

	
	private void saveData () {
	    try {
	       
	        int pin = Integer.parseInt(confirmField.getText());
	        setData(pin);
	        
	    } catch (IOException e) {
	        e.printStackTrace();
	    } catch (NumberFormatException e) {
	        JOptionPane.showMessageDialog(null, "Please enter a valid PIN.");
	    }
	}
	
	
	private void setData(int pin) throws IOException {
	    File f = new File(ACCOUNT_DETAILS_FILE);

	    if (!f.exists()) {
	        f.createNewFile();
	    }

	    try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(f, true)))) {
	        pw.println("," + pin);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}


	
	
	private boolean isFieldsFilled() {
	    // Check if all fields are completed
	    if (PINpassfield.getPassword().length == 0 || confirmField.getPassword().length == 0 ) {
	        JOptionPane.showMessageDialog(null, "Please fill in all fields.");
	        clearFields();
	        return false;
	    }

	    // Check if PIN has six numbers
	    String pin = new String(PINpassfield.getPassword());
	    if (pin.length() != 6 || !pin.matches("\\d{6}")) {
	        JOptionPane.showMessageDialog(null, "PIN must have 6 numbers.");
	        return false;
	    }

	    // Check if confirm PIN matches PIN
	    String confirmPin = new String(confirmField.getPassword());
	    if (!pin.equals(confirmPin)) {
	        JOptionPane.showMessageDialog(null, "PIN and Confirm PIN do not match.");
	        return false;
	    }

	    return true;
	}
	
	
	private void clearFields() {

		PINpassfield.setText("");
		confirmField.setText("");

	}
}

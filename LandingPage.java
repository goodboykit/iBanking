package iBanking;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

import queuemanagement.CustomizedPanels.RoundedButton;
import queuemanagement.CustomizedPanels.RoundedCornerTextField;
import queuemanagement.CustomizedPanels.ImgRoundedPanel;
import queuemanagement.CustomizedPanels.RoundPanels;
import queuemanagement.CustomizedPanels.RoundedCornerLabel;



import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class LandingPage extends JFrame {

	private JPanel contentPane;
	private Register register;
	private Interface Account;
	
	private ImageIcon[] imageIcons;
	private int currentImageIndex;
	private JLabel array;
	private Timer slideTimer;

	
	private JTextField accountNo;
	private JTextField PIN;
	private boolean clicked = false;

	
    private static final String FILE_PATH = "NewAccount.txt";

	/**
	 * Create the frame.	
	 */
	public LandingPage() {

		
		register = new Register();
		
	    setUndecorated(true); // Remove default frame decorations

		setTitle("Landing Page");
		setBounds(new Rectangle(0, 0, 1215, 800));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);

	        imageIcons = new ImageIcon[4]; // Array to hold the images

	        imageIcons[0] = new ImageIcon(getClass().getResource("/iBanking/1.jpg"));
	        Image image1 = imageIcons[0].getImage().getScaledInstance(380, 400, Image.SCALE_DEFAULT);
	          

	        imageIcons[0] = new ImageIcon(image1);

	        imageIcons[1] = new ImageIcon(LandingPage.class.getResource("/iBanking/2.jpg"));
	        Image image2 = imageIcons[1].getImage().getScaledInstance(380, 400, Image.SCALE_DEFAULT);
	        imageIcons[1] = new ImageIcon(image2);
	        
	        
	        imageIcons[2] = new ImageIcon(LandingPage.class.getResource("/iBanking/Bark-Bank (Logo).png"));
	        Image image3 = imageIcons[2].getImage().getScaledInstance(380, 400, Image.SCALE_DEFAULT);
	        imageIcons[2] = new ImageIcon(image3);
	        
	        imageIcons[3] = new ImageIcon(LandingPage.class.getResource("/iBanking/Untitled (2048 × 2048 px) (100 × 100 px)-3.png"));
	        Image image4 = imageIcons[3].getImage().getScaledInstance(380, 400, Image.SCALE_DEFAULT);
	        imageIcons[3] = new ImageIcon(image4);
	        

	        currentImageIndex = 0;

	        // Timer to change the image every 2 seconds
	        slideTimer = new Timer(3000, new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                currentImageIndex = (currentImageIndex + 1) % imageIcons.length;
	                array.setIcon(imageIcons[currentImageIndex]);
	            }
	        });
	        slideTimer.start();
		contentPane.setLayout(null);
	        

		JPanel bgPanel = new JPanel();
		bgPanel.setBounds(0, 0, 1215, 800
				);
		bgPanel.setBackground(new Color(0,72,134));
		contentPane.add(bgPanel);
		 bgPanel.setLayout(null);
		
		 array = new JLabel();
		 array.setBounds(91, 190, 474, 553);
		 array.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		 bgPanel.add(array);
		 array.setIcon(imageIcons[currentImageIndex]);
		
		accountNo = new RoundedCornerTextField();
		accountNo.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		accountNo.setBounds(875, 325, 232, 57);
		accountNo.setHorizontalAlignment(SwingConstants.CENTER);
		accountNo.setForeground(new Color(49, 62, 138));
		accountNo.setMargin(new Insets(5, 10, 5, 10)); // Adjust the values to add desired padding

		accountNo.setBorder(null);
		accountNo.setColumns(9);

		
		bgPanel.add(accountNo);

		
		
		PIN = new JPasswordField(6) { // CreateAcc password field "Password"
			private static final long serialVersionUID = 1L;

			@Override
		    protected void paintComponent(Graphics g) {
		        int w = getWidth();
		        int h = getHeight();
		        Graphics2D g2 = (Graphics2D) g.create();
		        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		        g2.setColor(Color.WHITE);
		        g2.fillRoundRect(1, 1, w - 2, h - 2, h, h);

		        // Draw only the border
		        
		        g2.setColor(new Color(0, 0, 0, 100)); // Light black color
		        g2.setStroke(new BasicStroke(2));
		        g2.drawRoundRect(1, 1, w - 3, h - 3, h, h);

		  
				g.setColor(getBackground());
		        super.paintComponent(g);
		    }
		};
		PIN.setForeground(new Color(19, 31, 127));
		PIN.setBounds(875, 467, 206, 62);
		//
		PIN.setDocument(new PlainDocument() {
			
            private static final long serialVersionUID = 1L;

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
		

		
		PIN.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		
		PIN.setOpaque(false);
		PIN.setBorder(BorderFactory.createEmptyBorder(14, 16, 14, 32));
		
		bgPanel.add(PIN);
		

		
		ImageIcon hideIcon1 = new ImageIcon((Register.class.getResource("/iBanking/hide.png")));
		ImageIcon showIcon1 = new ImageIcon(Register.class.getResource("/iBanking/Secure.png"));

		JButton hideConfirm = new JButton(hideIcon1);

		hideConfirm.setBounds(1086, 472, 55, 57);
		bgPanel.add(hideConfirm);
		
		JLabel close = new JLabel("");
		close.setBounds(1148, 19, 61, 39);
		bgPanel.add(close);
		close.setIcon(new ImageIcon(LandingPage.class.getResource("/iBanking/Close(3).png")));
		
		close.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose(); // Dispose the frame when the label is clicked
            }
        });

		
		JLabel confirmm = new JLabel();
		confirmm.setBounds(1086, 472, 61, 57);
		bgPanel.add(confirmm);

		hideConfirm.addFocusListener(new FocusListener() {
		    @Override
		    public void focusGained(FocusEvent e) {
		        hideConfirm.setVisible(true);
		    }

		    @Override
		    public void focusLost(FocusEvent e) {
		        hideConfirm.setVisible(false);
		    }
		});

		PIN.addFocusListener(new FocusListener() {
		    @Override
		    public void focusGained(FocusEvent e) {
		        hideConfirm.setVisible(true);
		    }

		    @Override
		    public void focusLost(FocusEvent e) {
		        hideConfirm.setVisible(false);
		    }
		});

		hideConfirm.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mousePressed(MouseEvent e) {
		        if (clicked) {
		            hideConfirm.setIcon(hideIcon1);
		            clicked = false;
		            ((JPasswordField) PIN).setEchoChar('\u2022');
		            confirmm.setIcon(showIcon1);
		        } else {
		            hideConfirm.setIcon(showIcon1);
		            clicked = true;
		            ((JPasswordField) PIN).setEchoChar((char) 0);
		            confirmm.setIcon(hideIcon1);
		        }
		    }
		});

		
		
		JLabel lblNewLabel_1 = new JLabel("Account No:");
		lblNewLabel_1.setBounds(875, 285, 95, 16);
		lblNewLabel_1.setFont(new Font("DIN Alternate", Font.PLAIN, 17));
		lblNewLabel_1.setForeground(new Color(254, 255, 243));
		bgPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("PIN No:");
		lblNewLabel_1_1.setBounds(874, 425, 219, 32);
		lblNewLabel_1_1.setForeground(new Color(254, 255, 243));
		lblNewLabel_1_1.setFont(new Font("DIN Alternate", Font.PLAIN, 17));
		bgPanel.add(lblNewLabel_1_1);

		bgPanel.add(PIN);
		

		RoundedButton LogIn = new RoundedButton("REGISTER");
		LogIn.setBounds(875, 623, 254, 57);
		LogIn.setText("LOG IN");
		LogIn.setBorder(null);
		LogIn.setBackground(new Color(70,130,180));
		bgPanel.add(LogIn);
		
		LogIn.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseEntered(MouseEvent e) {
		    	LogIn.setBackground(new Color(3, 37, 76)); // Change background color on hover
		    }

		    @Override
		    public void mouseExited(MouseEvent e) {
				LogIn.setBackground(new Color(70,130,180));
		    }
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        String accountNumber = accountNo.getText().trim();
		        String pin = PIN.getText().trim();
		        
		        if (verifyAccount(accountNumber, pin)) {
		            JOptionPane.showMessageDialog(null, "LOGIN SUCCESSFULLY!", "Welcome!", JOptionPane.INFORMATION_MESSAGE);
		            Interface account = new Interface(accountNumber);
		            account.setVisible(true);
		            dispose();
		        } else {
		            JOptionPane.showMessageDialog(null, "Invalid account number or PIN", "Login Error", JOptionPane.ERROR_MESSAGE);
		        }
		    }

		});	
		
		JLabel lblNewLabel_1_2 = new JLabel("Forgot your Password?");
		lblNewLabel_1_2.setBounds(918, 595, 169, 16);
		lblNewLabel_1_2.setForeground(new Color(254, 255, 243));
		lblNewLabel_1_2.setFont(new Font("DIN Alternate", Font.PLAIN, 17));
		bgPanel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_4 = new JLabel("RETURN TO NAVIGATION");
		lblNewLabel_1_4.setForeground(new Color(254, 255, 243));
		lblNewLabel_1_4.setFont(new Font("FONTSPRING DEMO - Organetto Cnd", Font.PLAIN, 23));
		lblNewLabel_1_4.setBounds(808, 62, 254, 16);
		bgPanel.add(lblNewLabel_1_4);
		
		 // Mouse hover effect
		lblNewLabel_1_4.addMouseListener(new MouseAdapter() {
					    @Override
					    public void mouseEntered(MouseEvent e) {
					    	lblNewLabel_1_4.setForeground(new Color (232, 175, 48));// Change background color on hover
					    }

					    @Override
					    public void mouseExited(MouseEvent e) {
					    	lblNewLabel_1_4.setForeground(new Color(255, 251, 248));
					    }
					    
					    @Override
			            public void mouseClicked(MouseEvent e) {
			                Navigation nv = new Navigation();
			                nv.setVisible(true);// Dispose the frame when the label is clicked
			                dispose();
			            }
					    
					   
					
				});	
	
	
		JPanel panel = new JPanel();
		panel.setBackground(new Color(215, 203, 196));
		panel.setBounds(-47, 123, 1256, 4);
		bgPanel.add(panel);
		
		JLabel lblNewLabel_1_3 = new JLabel("");
		lblNewLabel_1_3.setIcon(new ImageIcon(LandingPage.class.getResource("/iBanking/Untitled (2048 × 2048 px) (100 × 100 px)-3.png")));
		lblNewLabel_1_3.setBounds(136, 26, 500, 62);
		bgPanel.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(LandingPage.class.getResource("/iBanking/Untitled (2048 × 2048 px) (100 × 100 px).png")));
		lblNewLabel_2.setBounds(35, -31, 134, 172);
		bgPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(6, -35, 1215, 800);
		lblNewLabel_3.setIcon(new ImageIcon(LandingPage.class.getResource("/iBanking/Piggy Bank Saving Money YouTube Thumbnail (500 × 720 px) (500 × 600 px) (800 × 400 px) (670 × 400 px) (1215 × 800 px).png")));
		bgPanel.add(lblNewLabel_3);
		
	
		
		
	}
	
	
	private boolean verifyAccount(String accountNumber, String pin) {
        try {
            File file = new File("NewAccount.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] accountInfo = line.split(",");

                if (accountInfo.length >= 11 && accountInfo[0].equals(accountNumber) && accountInfo[11].equals(pin)) {
                    scanner.close();
                    return true;
                }
                
            }
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }
}

	

	
	
	
	
	


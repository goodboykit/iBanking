package iBanking;

import java.awt.*;
import java.awt.event.*;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;


import javax.swing.*;
import javax.swing.border.EmptyBorder;

import queuemanagement.CustomizedPanels.RoundedButton;
import queuemanagement.CustomizedPanels.RoundedCornerTextArea;
import queuemanagement.CustomizedPanels.RoundedCornerTextField;
import queuemanagement.CustomizedPanels.ImgRoundedPanel;
import queuemanagement.CustomizedPanels.RoundPanels;

public class Interface extends JFrame {
	
    private static final long serialVersionUID = 1L;
    
	private static final Color INITIAL_COLOR = new Color(51, 97, 172);
	

    private static final Color HOVER_COLOR = new Color(231, 230, 221);

    private static final int ANIMATION_DURATION = 500; // Animation duration in milliseconds
    private static final int ANIMATION_STEPS = 50; // Number of animation steps
    
    private JLabel lblNewLabel_1; // Declare the variable here

    
    public Interface(String accountNumber) {
    	getContentPane().setBackground(new Color(0,72,134));

    	
        // Create and configure the main frame
    	  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   		  setBounds(new Rectangle(0, 0, 1215, 800));
          getContentPane().setLayout(null);
   		  setLocationRelativeTo(null);
  	    setUndecorated(true); // Remove default frame decorations



           RoundPanels bgPanel = new RoundPanels(90);
           bgPanel.setBounds(82, 278, 318, 474);
           bgPanel.setBackground(INITIAL_COLOR);        


           ImageIcon icon = new ImageIcon(getClass().getResource("/iBanking/3.png"));
           ImgRoundedPanel roundedPanel = new ImgRoundedPanel(icon);
           roundedPanel.addMouseListener(new MouseAdapter() {
           	@Override
           	public void mouseClicked(MouseEvent e) {
                Withdraw withdraw = new Withdraw(accountNumber);
                withdraw.setAlwaysOnTop(true); // Make the frame always on top

                withdraw.setVisible(true);

           	}
           });

           JLabel iconLabel = new JLabel();
           iconLabel.setBounds(5, 7, 305, 460);
           iconLabel.setOpaque(false);
           iconLabel.setVisible(false);
           iconLabel.setLayout(new BorderLayout());
           iconLabel.add(roundedPanel, BorderLayout.CENTER);
           roundedPanel.setLayout(null);


           bgPanel.addMouseListener(new java.awt.event.MouseAdapter() {
               public void mouseEntered(java.awt.event.MouseEvent evt) {
                   animateIconTransition(iconLabel, true);
                   animateColorChange(bgPanel, INITIAL_COLOR, HOVER_COLOR);
               }

               public void mouseExited(java.awt.event.MouseEvent evt) {
                   animateIconTransition(iconLabel, false);
                   animateColorChange(bgPanel, HOVER_COLOR, INITIAL_COLOR);
               }
               
            	@Override
               	public void mouseClicked(MouseEvent e) {
                    Withdraw withdraw = new Withdraw(accountNumber);
                    withdraw.setAlwaysOnTop(true); // Make the frame always on top

                    withdraw.setVisible(true);

               	}
           });
           bgPanel.setLayout(null);
           bgPanel.add(iconLabel);
           getContentPane().add(bgPanel);
           bgPanel.setLayout(null);
           
           JLabel withdrawtxt_1 = new JLabel("");
           withdrawtxt_1.setIcon(new ImageIcon(Interface.class.getResource("/iBanking/10.png")));
           withdrawtxt_1.setForeground(new Color(119, 88, 171));
           withdrawtxt_1.setFont(new Font("FONTSPRING DEMO - Organetto Cnd Bold", Font.PLAIN, 43));
           withdrawtxt_1.setBounds(49, 56, 221, 230);
           bgPanel.add(withdrawtxt_1);
           
           JLabel lblNewLabel = new JLabel("New label");
           lblNewLabel.setIcon(new ImageIcon(Interface.class.getResource("/iBanking/6.png")));
           lblNewLabel.setBounds(26, 227, 267, 208);
           bgPanel.add(lblNewLabel);
           
           //----------------------------------------------------------------
           RoundPanels bgPanel1 = new RoundPanels(90);
           bgPanel1.setBounds(465, 278, 318, 474);
           bgPanel1.setBackground(INITIAL_COLOR);
           
           ImageIcon icon1 = new ImageIcon(getClass().getResource("/iBanking/4.png"));
           ImgRoundedPanel roundedPanel1 = new ImgRoundedPanel(icon1);


           JLabel iconLabel1 = new JLabel();
           iconLabel1.setBounds(7, 8, 305, 460);
           iconLabel1.setOpaque(false);
           iconLabel1.setVisible(false);
           iconLabel1.setLayout(new BorderLayout());
           iconLabel1.add(roundedPanel1, BorderLayout.CENTER);
           roundedPanel1.setLayout(null);


           bgPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
               public void mouseEntered(java.awt.event.MouseEvent evt) {
                   animateIconTransition(iconLabel1, true);
                   animateColorChange(bgPanel1, INITIAL_COLOR, HOVER_COLOR);
               }

               public void mouseExited(java.awt.event.MouseEvent evt) {
                   animateIconTransition(iconLabel1, false);
                   animateColorChange(bgPanel1, HOVER_COLOR, INITIAL_COLOR);
               }
               
               @Override
              	public void mouseClicked(MouseEvent e) {
                   Depositt deposit = new Depositt(accountNumber);
                   deposit.setAlwaysOnTop(true); // Make the frame always on top

                   deposit.setVisible(true);

              	}
               
               
           });
           
             
           bgPanel1.setLayout(null);
           bgPanel1.add(iconLabel1);
           getContentPane().add(bgPanel1);
           bgPanel1.setLayout(null);

//------------------------------------------------------
           RoundPanels bgPanel2 = new RoundPanels(90);
           bgPanel2.setBounds(842, 278, 318, 474);
           bgPanel2.setBackground(INITIAL_COLOR);
           
           JLabel withdrawtxt_1_1 = new JLabel("");
           withdrawtxt_1_1.setIcon(new ImageIcon(Interface.class.getResource("/iBanking/9.png")));
           withdrawtxt_1_1.setForeground(new Color(119, 88, 171));
           withdrawtxt_1_1.setFont(new Font("FONTSPRING DEMO - Organetto Cnd Bold", Font.PLAIN, 43));
           withdrawtxt_1_1.setBounds(60, 59, 195, 218);
           bgPanel1.add(withdrawtxt_1_1);
           
           JLabel lblNewLabel_3 = new JLabel("New label");
           lblNewLabel_3.setIcon(new ImageIcon(Interface.class.getResource("/iBanking/7.png")));
           lblNewLabel_3.setBounds(25, 270, 265, 104);
           bgPanel1.add(lblNewLabel_3);

           //----------------------------------------------------------------

           ImageIcon icon2 = new ImageIcon(getClass().getResource("/iBanking/5.png"));
           ImgRoundedPanel roundedPanel2 = new ImgRoundedPanel(icon2);
           
           JLabel iconLabel2 = new JLabel();
           iconLabel2.setBounds(5, 7, 305, 460);
           iconLabel2.setOpaque(false);
           iconLabel2.setVisible(false);
           iconLabel2.setLayout(new BorderLayout());
           iconLabel2.add(roundedPanel2, BorderLayout.CENTER);
           roundedPanel2.setLayout(null);


           bgPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
               public void mouseEntered(java.awt.event.MouseEvent evt) {
                   animateIconTransition(iconLabel2, true);
                   animateColorChange(bgPanel2, INITIAL_COLOR, HOVER_COLOR);
               }

               public void mouseExited(java.awt.event.MouseEvent evt) {
                   animateIconTransition(iconLabel2, false);
                   animateColorChange(bgPanel2, HOVER_COLOR, INITIAL_COLOR);
               }
               
               @Override
             	public void mouseClicked(MouseEvent e) {
            	   BalanceInquiry BI = new BalanceInquiry(accountNumber);
                  BI.setAlwaysOnTop(true); // Make the frame always on top

                  BI.setVisible(true);
                  dispose(); // Dispose the current BalanceInquiry frame

             	}
           });
           
           bgPanel2.setLayout(null);
           bgPanel2.add(iconLabel2);
           getContentPane().add(bgPanel2);
           bgPanel2.setLayout(null);
           
           JLabel withdrawtxt_1_1_1 = new JLabel("");
           withdrawtxt_1_1_1.setIcon(new ImageIcon(Interface.class.getResource("/iBanking/11.png")));
           withdrawtxt_1_1_1.setForeground(new Color(119, 88, 171));
           withdrawtxt_1_1_1.setFont(new Font("FONTSPRING DEMO - Organetto Cnd Bold", Font.PLAIN, 43));
           withdrawtxt_1_1_1.setBounds(52, 66, 221, 170);
           bgPanel2.add(withdrawtxt_1_1_1);
           
           JLabel lblNewLabel_4 = new JLabel("New label");
           lblNewLabel_4.setIcon(new ImageIcon(Interface.class.getResource("/iBanking/8.png")));
           lblNewLabel_4.setBounds(30, 300, 271, 92);
           bgPanel2.add(lblNewLabel_4);
           
           RoundPanels panel = new RoundPanels(90);
           panel.setBackground(new Color (232, 175, 48));
           panel.setBounds(100, 171, 1042, 91);
           getContentPane().add(panel);
           panel.setLayout(null);
           
           
           
           lblNewLabel_1 = new JLabel("Welcome to your Account: ");
           lblNewLabel_1.setBounds(42, 22, 967, 51);
           panel.add(lblNewLabel_1);
           lblNewLabel_1.setFont(new Font("Bebas", Font.PLAIN, 38));
           
           JLabel lblNewLabel_2 = new JLabel("");
           lblNewLabel_2.setIcon(new ImageIcon(Interface.class.getResource("/iBanking/Untitled (2048 × 2048 px) (100 × 100 px).png")));
           lblNewLabel_2.setBounds(17, -26, 134, 172);
           getContentPane().add(lblNewLabel_2);
           
           JLabel lblNewLabel_1_1 = new JLabel("");
           lblNewLabel_1_1.setIcon(new ImageIcon(Interface.class.getResource("/iBanking/Untitled (2048 × 2048 px) (100 × 100 px)-3.png")));
           lblNewLabel_1_1.setBounds(125, 28, 500, 62);
           getContentPane().add(lblNewLabel_1_1);
           
           JPanel panel_1 = new JPanel();
           panel_1.setBounds(0, 116, 1215, 10);
           getContentPane().add(panel_1);
           
           JLabel lblNewLabel_5 = new JLabel("SIGN OUT");
           lblNewLabel_5.setFont(new Font("FONTSPRING DEMO - Organetto Cnd Light", Font.PLAIN, 31));
           lblNewLabel_5.setForeground(new Color(255, 251, 248));
           lblNewLabel_5.setBounds(961, 52, 158, 39);
           getContentPane().add(lblNewLabel_5);
           
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
					    	LandingPage LP = new LandingPage();
					    	LP.setVisible(true);
					    	dispose();
					    }
					
				});	
					
	
           
           
           JLabel close = new JLabel("");
           close.addMouseListener(new MouseAdapter() {
           	@Override
           	public void mouseClicked(MouseEvent e) {
           		dispose();
           	}
           });
           close.setIcon(new ImageIcon(Interface.class.getResource("/iBanking/Close(3).png")));
           close.setBounds(1156, 7, 61, 39);
           getContentPane().add(close);
           setLoggedInUserDetails(accountNumber);
           setVisible(true);
           setVisible(true);
       }

    

    private void animateIconTransition(JLabel label, boolean show) {
        final int targetAlpha = show ? 255 : 0;
        int startAlpha = show ? 0 : 255;

        long startTime = System.currentTimeMillis();

        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                long elapsedTime = System.currentTimeMillis() - startTime;
                float progress = (float) elapsedTime / ANIMATION_DURATION;
                int currentAlpha = (int) (startAlpha + (targetAlpha - startAlpha) * progress);

                if (currentAlpha < 0) currentAlpha = 0;
                if (currentAlpha > 255) currentAlpha = 255;

                label.setForeground(new Color(255, 255, 255, currentAlpha)); // Set label's text color with alpha value

                if (progress >= 1.0f) {
                    label.setVisible(show); // Show or hide the label after animation is finished
                    ((Timer) e.getSource()).stop();
                }

            }
        };

        Timer timer = new Timer(ANIMATION_DURATION / ANIMATION_STEPS, actionListener);
        timer.setRepeats(true);
        timer.start();

    }

    private void animateColorChange(JPanel panel, Color startColor, Color endColor) {
        long startTime = System.currentTimeMillis();

        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                long elapsedTime = System.currentTimeMillis() - startTime;
                float progress = (float) elapsedTime / ANIMATION_DURATION;

                if (progress >= 1.0f) {
                    panel.setBackground(endColor); // Set the final background color
                    ((Timer) e.getSource()).stop();
                } else {
                    int red = (int) (startColor.getRed() + (endColor.getRed() - startColor.getRed()) * progress);
                    int green = (int) (startColor.getGreen() + (endColor.getGreen() - startColor.getGreen()) * progress);
                    int blue = (int) (startColor.getBlue() + (endColor.getBlue() - startColor.getBlue()) * progress);

                    panel.setBackground(new Color(red, green, blue)); // Set the intermediate background color
                }
            }
        };

        Timer timer = new Timer(ANIMATION_DURATION / ANIMATION_STEPS, actionListener);
        timer.setRepeats(true);
        timer.start();
    }
    
    
    
    private void setLoggedInUserDetails(String accountNumber) {
        
    	
        // Read the "NewAccount.txt" file
        try (BufferedReader reader = new BufferedReader(new FileReader("NewAccount.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] accountData = line.split(",");
                String currentAccountNumber = accountData[0];
                String firstName = accountData[1];
                String lastName = accountData[3];

                if (currentAccountNumber.equals(accountNumber)) {
                    lblNewLabel_1.setText("Welcome to your Account: " + firstName + " " + lastName);
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



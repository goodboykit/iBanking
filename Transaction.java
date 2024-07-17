package iBanking;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import queuemanagement.CustomizedPanels.RoundedButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Transaction extends JFrame {

	private JPanel contentPane;


	public Transaction(String accountNumber) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1250, 800);
		setLocationRelativeTo(null);
	    setUndecorated(true); // Remove default frame decorations

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(0,72,134));


		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon(Transaction.class.getResource("/iBanking/Untitled (2048 × 2048 px) (100 × 100 px)-3.png")));
		lblNewLabel_1_1.setBounds(137, 29, 500, 62);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setIcon(new ImageIcon(Transaction.class.getResource("/iBanking/Untitled (2048 × 2048 px) (100 × 100 px).png")));
		lblNewLabel_2_1.setBounds(29, -25, 134, 172);
		contentPane.add(lblNewLabel_2_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 128, 1250, 4);
		contentPane.add(panel_1);
		
		JLabel close = new JLabel("");
		close.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		close.setIcon(new ImageIcon(Transaction.class.getResource("/iBanking/Close(3).png")));
		close.setBounds(1189, 19, 61, 39);
		contentPane.add(close);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Transaction.class.getResource("/iBanking/bgreg (400 × 450 px)-3.png")));
		lblNewLabel.setBounds(450, 103, 396, 433);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Transaction.class.getResource("/iBanking/Transaction Verification.png")));
		lblNewLabel_1.setBounds(352, 440, 524, 235);
		contentPane.add(lblNewLabel_1);
		
		RoundedButton returnbtn = new RoundedButton("Register your Account");
		returnbtn.setText("Return to Transaction Menu");
		returnbtn.setFont(new Font("FONTSPRING DEMO - Organetto Cnd Light", Font.PLAIN, 20));
		returnbtn.setBorder(null);
		returnbtn.setBackground(new Color(70, 130, 180));
		returnbtn.setBounds(399, 644, 426, 70);
		contentPane.add(returnbtn);
		
		
		returnbtn.addMouseListener(new MouseAdapter() {
              @Override
              public void mouseEntered(MouseEvent e) {
            	  returnbtn.setBackground(new Color(112, 128, 144)); // Change background color on hover
              }
  
              @Override
              public void mouseExited(MouseEvent e) {
            	  returnbtn.setBackground(new Color(53, 76, 124));
              }
  
              @Override
              public void mouseClicked(MouseEvent e) {
            	  Interface IF = new Interface(accountNumber);
            	  IF.setVisible(true);
            	  dispose();
            	  
              
              }
          });

	}
}

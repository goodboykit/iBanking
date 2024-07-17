package iBanking;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import queuemanagement.CustomizedPanels.RoundedButton;
import java.awt.Font;

public class RegSuccessful extends JFrame {

	private JPanel contentPane;

	public RegSuccessful() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1250, 800);
		setLocationRelativeTo(null);
	    setUndecorated(true); // Remove default frame decorations

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(0,72,134));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(378, 450, 528, 217);
		lblNewLabel.setIcon(new ImageIcon(RegSuccessful.class.getResource("/iBanking/Registered Verification.png")));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(48, -13, 134, 172);
		lblNewLabel_2.setIcon(new ImageIcon(RegSuccessful.class.getResource("/iBanking/Untitled (2048 × 2048 px) (100 × 100 px).png")));
		contentPane.add(lblNewLabel_2);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 146, 1250, 2);
		panel.setBackground(new Color(215, 203, 196));
		contentPane.add(panel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(153, 35, 500, 62);
		lblNewLabel_1.setIcon(new ImageIcon(RegSuccessful.class.getResource("/iBanking/Untitled (2048 × 2048 px) (100 × 100 px)-3.png")));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(469, 134, 405, 381);
		lblNewLabel_3.setIcon(new ImageIcon(RegSuccessful.class.getResource("/iBanking/bgreg (400 × 450 px)-3.png")));
		contentPane.add(lblNewLabel_3);
		
		RoundedButton register = new RoundedButton("Register your Account");
		register.setFont(new Font("FONTSPRING DEMO - Organetto Cnd Light", Font.PLAIN, 20));
		register.setText("Return to Main Menu");
		register.setBounds(411, 661, 415, 70);
		register.setBorder(null);
		register.setBackground(new Color(70, 130, 180));
		contentPane.add(register);
		
		JLabel close = new JLabel("");
		close.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		close.setIcon(new ImageIcon(RegSuccessful.class.getResource("/iBanking/Close(3).png")));
		close.setBounds(1189, 6, 61, 39);
		contentPane.add(close);
		
		// Mouse hover effect for btn_signIn
				register.addMouseListener(new MouseAdapter() {
					    @Override
					    public void mouseEntered(MouseEvent e) {
					    	register.setBackground(new Color(3, 37, 76)); // Change background color on hover
					    }

					    @Override
					    public void mouseExited(MouseEvent e) {
							register.setBackground(new Color(70,130,180));
					    }
						@Override
						public void mouseClicked(MouseEvent e) {
							LandingPage LP = new LandingPage();
							LP.setVisible(true);
							dispose();

						}
					});	
				
			}
		
		
	}


package iBanking;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import queuemanagement.CustomizedPanels.RoundedButton;

import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Navigation extends JFrame {

	private JPanel contentPane;
	
	private LandingPage LP;
	private Register RG;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Navigation frame = new Navigation();
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
	public Navigation() {
		
		LP = new LandingPage();
		RG = new Register();
		
		setTitle("Navigation Page");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1215, 800);
		setLocationRelativeTo(null);
	    setUndecorated(true); // Remove default frame decorations

		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 72, 134));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(6, 118, 1209, 3);
		panel.setBackground(new Color(215, 203, 196));
		contentPane.add(panel);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Navigation.class.getResource("/iBanking/Untitled (2048 × 2048 px) (100 × 100 px).png")));
		lblNewLabel_2.setBounds(44, -29, 134, 172);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Navigation.class.getResource("/iBanking/Untitled (2048 × 2048 px) (100 × 100 px)-3.png")));
		lblNewLabel_1.setBounds(149, 26, 500, 62);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon(Navigation.class.getResource("/iBanking/Close(3).png")));
		lblNewLabel_3.setBounds(1148, 20, 61, 39);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose(); // Dispose the frame when the label is clicked
            }
        });
    
		
		JLabel lblNewLabel_1_1 = new JLabel("New label");
		lblNewLabel_1_1.setIcon(new ImageIcon(Navigation.class.getResource("/iBanking/Bark-Bank (Header - Light).png")));
		lblNewLabel_1_1.setBounds(393, 396, 500, 62);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_4 = new JLabel("Welcome to the bank of tomorrow, today ! At Bark-Bank, you'll experience");
		lblNewLabel_4.setForeground(new Color(247, 255, 247));
		lblNewLabel_4.setFont(new Font("Nadeem", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(302, 482, 695, 22);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("seamless transactions, top notch security and impeccable customer");
		lblNewLabel_4_1.setForeground(new Color(247, 255, 247));
		lblNewLabel_4_1.setFont(new Font("Nadeem", Font.PLAIN, 20));
		lblNewLabel_4_1.setBounds(340, 516, 615, 22);
		contentPane.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("service- because your money matters");
		lblNewLabel_4_1_1.setForeground(new Color(247, 255, 247));
		lblNewLabel_4_1_1.setFont(new Font("Nadeem", Font.PLAIN, 20));
		lblNewLabel_4_1_1.setBounds(483, 550, 354, 22);
		contentPane.add(lblNewLabel_4_1_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setIcon(new ImageIcon(Navigation.class.getResource("/iBanking/Untitled (2048 × 2048 px) (100 × 100 px)-4.png")));
		lblNewLabel_2_1.setBounds(508, 121, 263, 263);
		contentPane.add(lblNewLabel_2_1);
		
		
		//------------------------------------
		RoundedButton register = new RoundedButton("Register your Account");
		register.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		
		register.setBounds(340, 609, 615, 57);
		contentPane.add(register);
		register.setBorder(null);
		register.setBackground(new Color(70,130,180));
		
		contentPane.add(register);
		
		
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
						RG.setVisible(true);
						dispose();
						
					}
					
				});	
		
		RoundedButton login = new RoundedButton("Login your Account");
		login.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		login.setBorder(null);
		login.setBackground(new Color(70, 130, 180));
		login.setBounds(340, 695, 615, 57);
		contentPane.add(login);
		
		// Mouse hover effect for btn_signIn
		login.addMouseListener(new MouseAdapter() {
				    @Override
				    public void mouseEntered(MouseEvent e) {
				    	login.setBackground(new Color(3, 37, 76)); // Change background color on hover
				    }

				    @Override
				    public void mouseExited(MouseEvent e) {
				    	login.setBackground(new Color(70,130,180));
				    }
				    
				    @Override
					public void mouseClicked(MouseEvent e) {
						LP.setVisible(true);
						dispose();
						
					}
					
				});	
	   
	}
}

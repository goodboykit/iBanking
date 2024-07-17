package iBanking;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.PrintWriter;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;


import java.io.File;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import queuemanagement.CustomizedPanels.RoundedButton;
import queuemanagement.CustomizedPanels.RoundedCornerTextArea;
import queuemanagement.CustomizedPanels.RoundedCornerTextField;
import queuemanagement.CustomizedPanels.ImgRoundedPanel;
import queuemanagement.CustomizedPanels.RoundPanels;


import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Insets;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JCheckBox;


public class Register extends JFrame {

	private JPanel contentPane;
	private AccountRegister AR;

	private RoundedCornerTextField  FName_txtfield;
	private RoundedCornerTextField FName_txtfield_1;
	private  RoundedCornerTextField middlename_txtfield;
	private RoundedCornerTextField middlename_txtfield_1;
	private  RoundedCornerTextField lastname_txtfield;
	private RoundedCornerTextField lastname_txtfield_1;
	private  RoundedCornerTextField gender_txtfield;
	private  RoundedCornerTextField add_txtfield;
	private RoundedCornerTextField add_txtfield_1;
	private  RoundedCornerTextField father_txtfield;
	private RoundedCornerTextField father_txtfield_1;
	private  RoundedCornerTextField mother_txtfield;
	private RoundedCornerTextField mother_txtfield_1;
	private  RoundedCornerTextField contact_txtfield;
	private RoundedCornerTextField contact_txtfield_1;
	private  RoundedCornerTextField PIN_txtfield;

	private JComboBox genderComboBox;
	private JCheckBox chckbxNewCheckBox;
	private BirthdayInputField birthdayInputField;

	
    private static final String  ACCOUNT_DETAILS_FILE = "NewAccount.txt";
    private static int initialAccountNumber = 2023100000;
    private static  double initialDeposit = 500.0;
    
    
	boolean clicked = false, clicked2 = false, clicked3 = false, clicked4 = false;
	private final JLabel lblNewLabel = new JLabel("New label");

	
	public Register() {
		
		
        FName_txtfield = new RoundedCornerTextField();
        middlename_txtfield = new RoundedCornerTextField();
        lastname_txtfield = new RoundedCornerTextField();
        gender_txtfield = new RoundedCornerTextField();
        add_txtfield = new RoundedCornerTextField();
        father_txtfield = new RoundedCornerTextField();
        mother_txtfield = new RoundedCornerTextField();
        contact_txtfield = new RoundedCornerTextField();
        PIN_txtfield = new RoundedCornerTextField();
				

		setBounds(new Rectangle(0, 0, 1215, 640));
		setLocationRelativeTo(null);
	    setUndecorated(true); // Remove default frame decorations

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		//--------------------------------------------------------------------------
		
		RoundedButton register_1 = new RoundedButton("Register your Account");
		register_1.setFont(new Font("FONTSPRING DEMO - Organetto Cnd", Font.PLAIN, 17));
		register_1.setBounds(1061, 6, 119, 59);
		contentPane.add(register_1);
		register_1.setText("GO BACK");
		register_1.setBorder(null);
		register_1.setBackground(new Color(70, 130, 180));
		
		
		// Mouse hover effect for btn_signIn
		register_1.addMouseListener(new MouseAdapter() {
			    @Override
			    public void mouseEntered(MouseEvent e) {
			    	register_1.setBackground(new Color(3, 37, 76)); // Change background color on hover
			    }

			    @Override
			    public void mouseExited(MouseEvent e) {
			    	register_1.setBackground(new Color(70,130,180));
			    }
				@Override
				public void mouseClicked(MouseEvent e) {
					Navigation nav = new Navigation();
					nav.setVisible(true);
					dispose();

				}
			});	
		
		//--------------------------------------------------------------------------

		RoundPanels BgPanel = new RoundPanels(90);
		BgPanel.setBounds(144, 66, 905, 543);
		BgPanel.setBackground(new Color(20, 40, 119));
		
		contentPane.add(BgPanel);
		
		birthdayInputField = new BirthdayInputField();
        birthdayInputField.setBounds(430, 72, 283, 70);
        birthdayInputField.setBackground(new Color(255,255,255));
 
        BgPanel.add(birthdayInputField);

        
		BgPanel.add(birthdayInputField);
		 BgPanel.setLayout(null);
		
		
		 FName_txtfield_1 = new RoundedCornerTextField();
		 FName_txtfield_1.setFont(new Font("FONTSPRING DEMO - Organetto Cnd Light", Font.PLAIN, 16));
		 FName_txtfield_1.setBounds(81, 76, 280, 49);
		FName_txtfield_1.setMargin(new Insets(5, 10, 5, 10));
		FName_txtfield_1.setHorizontalAlignment(SwingConstants.CENTER);
		FName_txtfield_1.setForeground(new Color(49, 62, 138));
		FName_txtfield_1.setColumns(9);
		FName_txtfield_1.setBorder(null);
		BgPanel.add(FName_txtfield_1);
		
		JLabel firstName = new JLabel("First Name:");
		firstName.setFont(new Font("FONTSPRING DEMO - Organetto UltraCnd Light", Font.PLAIN, 16));
		firstName.setBackground(new Color(246, 252, 255));
		firstName.setBounds(103, 48, 82, 16);
		BgPanel.add(firstName);
		firstName.setForeground(new Color(254, 254, 254));
		
		 middlename_txtfield_1 = new RoundedCornerTextField();
		 middlename_txtfield_1.setFont(new Font("FONTSPRING DEMO - Organetto Cnd Light", Font.PLAIN, 16));
		 middlename_txtfield_1.setBounds(81, 165, 280, 48);
		middlename_txtfield_1.setMargin(new Insets(5, 10, 5, 10));
		middlename_txtfield_1.setHorizontalAlignment(SwingConstants.CENTER);
		middlename_txtfield_1.setForeground(new Color(49, 62, 138));
		middlename_txtfield_1.setColumns(9);
		middlename_txtfield_1.setBorder(null);
		BgPanel.add(middlename_txtfield_1);
		
		JLabel lastName = new JLabel("Last Name:");
		lastName.setFont(new Font("FONTSPRING DEMO - Organetto UltraCnd Light", Font.PLAIN, 16));
		lastName.setBackground(new Color(246, 252, 255));
		lastName.setBounds(102, 213, 98, 54);
		lastName.setForeground(new Color(254, 254, 254));
		BgPanel.add(lastName);
		
		 lastname_txtfield_1 = new RoundedCornerTextField();
		 lastname_txtfield_1.setFont(new Font("FONTSPRING DEMO - Organetto Cnd Light", Font.PLAIN, 16));
		 lastname_txtfield_1.setBounds(81, 257, 280, 49);
		lastname_txtfield_1.setMargin(new Insets(5, 10, 5, 10));
		lastname_txtfield_1.setHorizontalAlignment(SwingConstants.CENTER);
		lastname_txtfield_1.setForeground(new Color(49, 62, 138));
		lastname_txtfield_1.setColumns(9);
		lastname_txtfield_1.setBorder(null);
		BgPanel.add(lastname_txtfield_1);
		
		// Initialize the genderComboBox object
		genderComboBox = new JComboBox<>(new String[]{"Male", "Female", "Other"});
		genderComboBox.setBackground(new Color(246, 252, 255));
		genderComboBox.setBounds(427, 464, 232, 54);
		genderComboBox.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		genderComboBox.setForeground(new Color(0, 0, 0));
		genderComboBox.setBorder(null);
		BgPanel.add(genderComboBox);

		
		JLabel fathername = new JLabel("Fathers Name:");
		fathername.setFont(new Font("FONTSPRING DEMO - Organetto UltraCnd Light", Font.PLAIN, 18));
		fathername.setBackground(new Color(246, 252, 255));
		fathername.setBounds(427, 159, 98, 16);
		fathername.setForeground(new Color(254, 254, 254));
		BgPanel.add(fathername);
		
		father_txtfield_1 = new RoundedCornerTextField();
		father_txtfield_1.setFont(new Font("FONTSPRING DEMO - Organetto Cnd Light", Font.PLAIN, 16));
		father_txtfield_1.setBounds(418, 187, 359, 49);
		father_txtfield_1.setMargin(new Insets(5, 10, 5, 10));
		father_txtfield_1.setHorizontalAlignment(SwingConstants.CENTER);
		father_txtfield_1.setForeground(new Color(49, 62, 138));
		father_txtfield_1.setColumns(9);
		father_txtfield_1.setBorder(null);
		BgPanel.add(father_txtfield_1);
		
		 mother_txtfield_1 = new RoundedCornerTextField();
		 mother_txtfield_1.setFont(new Font("FONTSPRING DEMO - Organetto Cnd Light", Font.PLAIN, 16));
		 mother_txtfield_1.setBounds(418, 284, 359, 50);
		mother_txtfield_1.setMargin(new Insets(5, 10, 5, 10));
		mother_txtfield_1.setHorizontalAlignment(SwingConstants.CENTER);
		mother_txtfield_1.setForeground(new Color(49, 62, 138));
		mother_txtfield_1.setColumns(9);
		mother_txtfield_1.setBorder(null);
		BgPanel.add(mother_txtfield_1);
		
		JLabel mothersname = new JLabel("Mothers Name:");
		mothersname.setFont(new Font("FONTSPRING DEMO - Organetto UltraCnd Light", Font.PLAIN, 18));
		mothersname.setBackground(new Color(246, 252, 255));
		mothersname.setBounds(428, 255, 98, 16);
		mothersname.setForeground(new Color(254, 254, 254));
		BgPanel.add(mothersname);
		
		JLabel gender = new JLabel("Gender:");
		gender.setFont(new Font("FONTSPRING DEMO - Organetto UltraCnd Light", Font.PLAIN, 18));
		gender.setBounds(439, 435, 82, 33);
		gender.setForeground(new Color(253, 248, 255));
		BgPanel.add(gender);
		
	
		
		JLabel middlename = new JLabel("Middle Name:");
		middlename.setFont(new Font("FONTSPRING DEMO - Organetto UltraCnd Light", Font.PLAIN, 16));
		middlename.setBackground(new Color(246, 252, 255));
		middlename.setBounds(103, 137, 98, 16);
		middlename.setForeground(new Color(254, 254, 254));
		BgPanel.add(middlename);
		
		JLabel birthday = new JLabel("Birthday:");
		birthday.setFont(new Font("FONTSPRING DEMO - Organetto UltraCnd Light", Font.PLAIN, 18));
		birthday.setBackground(new Color(246, 252, 255));
		birthday.setBounds(428, 38, 82, 16);
		birthday.setForeground(new Color(254, 254, 254));
		BgPanel.add(birthday);
		
		JLabel contactNo = new JLabel("Contact No:");
		contactNo.setFont(new Font("FONTSPRING DEMO - Organetto UltraCnd Light", Font.PLAIN, 16));
		contactNo.setBackground(new Color(246, 252, 255));
		contactNo.setBounds(103, 318, 267, 16);
		contactNo.setForeground(new Color(254, 254, 254));
		BgPanel.add(contactNo);
		
		JLabel Address = new JLabel("Address: ");
		Address.setFont(new Font("FONTSPRING DEMO - Organetto UltraCnd Light", Font.PLAIN, 18));
		Address.setBackground(new Color(246, 252, 255));
		Address.setBounds(428, 346, 98, 16);
		Address.setForeground(new Color(254, 254, 254));
		BgPanel.add(Address);
		
		 add_txtfield_1 = new RoundedCornerTextField();
		 add_txtfield_1.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		 add_txtfield_1.setBounds(417, 374, 397, 49);
		add_txtfield_1.setMargin(new Insets(5, 10, 5, 10));
		add_txtfield_1.setHorizontalAlignment(SwingConstants.CENTER);
		add_txtfield_1.setForeground(new Color(49, 62, 138));
		add_txtfield_1.setColumns(9);
		add_txtfield_1.setBorder(null);
		BgPanel.add(add_txtfield_1);
		
		 contact_txtfield_1 = new RoundedCornerTextField();
		 contact_txtfield_1.setFont(new Font("FONTSPRING DEMO - Organetto Cnd Light", Font.PLAIN, 16));
		 contact_txtfield_1.setBounds(81, 343, 280, 49);
		contact_txtfield_1.setMargin(new Insets(5, 10, 5, 10));
		contact_txtfield_1.setHorizontalAlignment(SwingConstants.CENTER);
		contact_txtfield_1.setForeground(new Color(49, 62, 138));
		contact_txtfield_1.setColumns(9);
		contact_txtfield_1.setBorder(null);
		BgPanel.add(contact_txtfield_1);
				
		//--------------------------------------------------------------------------


	
		RoundedButton register = new RoundedButton("Register your Account");
		register.setText("SUBMIT");
		register.setBounds(706, 453, 178, 77);
		BgPanel.add(register);
		register.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {

		        if (isFieldsFilled()) {
		            saveData();
		            AR = new AccountRegister();

		            AR.setVisible(true);
		            dispose();
		        }

		        
		    }
		});
		register.setBorder(null);
		register.setBackground(new Color(70,130,180));
		
		JLabel lblInitialDeposit = new JLabel("Initial Deposit:");
		lblInitialDeposit.setForeground(new Color(254, 254, 254));
		lblInitialDeposit.setFont(new Font("FONTSPRING DEMO - Organetto UltraCnd Light", Font.PLAIN, 18));
		lblInitialDeposit.setBackground(new Color(246, 252, 255));
		lblInitialDeposit.setBounds(92, 417, 269, 16);
		BgPanel.add(lblInitialDeposit);
		
		RoundedCornerTextField add_txtfield_1_1 = new RoundedCornerTextField();
		add_txtfield_1_1.setEditable(false);
		add_txtfield_1_1.setText("PHP 500");
		add_txtfield_1_1.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		add_txtfield_1_1.setMargin(new Insets(5, 10, 5, 10));
		add_txtfield_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		add_txtfield_1_1.setForeground(new Color(49, 62, 138));
		add_txtfield_1_1.setColumns(9);
		add_txtfield_1_1.setBorder(null);
		add_txtfield_1_1.setBounds(81, 445, 280, 49);
		BgPanel.add(add_txtfield_1_1);
		lblNewLabel.setIcon(new ImageIcon(Register.class.getResource("/iBanking/225063457_4342896162435004_4896660625765975181_n.jpg")));
		lblNewLabel.setBounds(0, 0, 1222, 649);
		contentPane.add(lblNewLabel);
		
	
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

				}
			});	
		

	}
	
	
	
	//--------------------------------------------------------------------------

	private void saveData() {
	    try {
	        String accountNumber = generateAccountNumber();
	        LocalDate selectedDate = birthdayInputField.getSelectedDate();
	        String gender = (String) genderComboBox.getSelectedItem();
	        setData(accountNumber, FName_txtfield_1.getText(), middlename_txtfield_1.getText(), lastname_txtfield_1.getText(),
	                gender, add_txtfield_1.getText(), father_txtfield_1.getText(),
	                mother_txtfield_1.getText(), contact_txtfield_1.getText(), selectedDate, initialDeposit
	                );
	    } catch (IOException e) {
	        e.printStackTrace();
	    } 
	}
	

	private void setData(String accountNumber, String fName, String middleName, String lastName, String gender,
	        String address, String fatherName, String motherName, String contact,
	        LocalDate selectedDate, double initialDeposit) throws IOException {

	    File f = new File(ACCOUNT_DETAILS_FILE);

	    if (!f.exists()) {
	        f.createNewFile();
	    }

	    try (BufferedWriter writer = new BufferedWriter(new FileWriter(f, true))) {
	        writer.write(accountNumber + "," + fName + "," + middleName + "," + lastName + "," + gender + "," + address + "," +
	                fatherName + "," + motherName + "," + contact + "," + initialDeposit + "," + selectedDate);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}


	private String generateAccountNumber() {
	    int accountNumber = 2023100000;
	    try (BufferedReader reader = new BufferedReader(new FileReader(ACCOUNT_DETAILS_FILE))) {
	        String line;
	        while ((line = reader.readLine()) != null) {
	            if (!line.isEmpty()) {
	                String[] data = line.split(",");
	                int currentAccountNumber = Integer.parseInt(data[0].trim());
	                if (currentAccountNumber >= accountNumber) {
	                    accountNumber = currentAccountNumber + 1;
	                }
	            }
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    return String.valueOf(accountNumber);
	}

	private boolean isFieldsFilled() {
	    // Check if all fields are completed
	    if (FName_txtfield_1.getText().isEmpty() || middlename_txtfield_1.getText().isEmpty()
	            || lastname_txtfield_1.getText().isEmpty() || father_txtfield_1.getText().isEmpty()
	            || mother_txtfield_1.getText().isEmpty() || add_txtfield_1.getText().isEmpty()
	            || contact_txtfield_1.getText().isEmpty() || genderComboBox.getSelectedIndex()< 0
	            || birthdayInputField.getSelectedDate() == null) {
	        JOptionPane.showMessageDialog(null, "Please fill in all fields.");
	        clearFields();
	        return false;
	    }

	    return true;
	}
	
	private void clearFields() {
		
		FName_txtfield_1.setText("");
		middlename_txtfield_1.setText("");
		lastname_txtfield_1.setText("");
		gender_txtfield.setText("");
		add_txtfield_1.setText("");
		father_txtfield_1.setText("");
		mother_txtfield_1.setText("");
		contact_txtfield_1.setText("");
	}
	
	
	
	//--------------------------------------------------------------------------

	
	   private class BirthdayInputField extends JPanel {
		   
	        public JComboBox<Integer> dayComboBox;
	        public JComboBox<String> monthComboBox;
	        public JComboBox<Integer> yearComboBox;
	        
	        

	        public BirthdayInputField() {
	            setLayout(new FlowLayout(FlowLayout.LEFT));

	            // Day
	            dayComboBox = new JComboBox<>();
	            for (int i = 1; i <= 31; i++) {
	                dayComboBox.addItem(i);
	            }
	            add(dayComboBox);

	            // Month
	            String[] months = new String[]{
	                    "January","February", "March", "April", "May", "June",
	                    "July", "August", "September", "October", "November", "December"
	            };
	            monthComboBox = new JComboBox<>(months);
	            add(monthComboBox);

	            // Year
	            int currentYear = LocalDate.now().getYear();
	            yearComboBox = new JComboBox<>();
	            for (int i = currentYear - 100; i <= currentYear; i++) {
	                yearComboBox.addItem(i);
	            }
	            add(yearComboBox);
	            
	            
	        }

	        public LocalDate getSelectedDate() {
	            int day = (int) dayComboBox.getSelectedItem();
	            int month = monthComboBox.getSelectedIndex() + 1; // Month index starts from 0
	            int year = (int) yearComboBox.getSelectedItem();

	            return LocalDate.of(year, month, day);
	        }


	        
	    }
}

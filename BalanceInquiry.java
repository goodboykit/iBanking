package iBanking;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.TextAttribute;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class BalanceInquiry extends JFrame {

    private JPanel contentPane;
    private JTable accountInfoTable;
    private JLabel lblNewLabel;
    


    public BalanceInquiry(String accountNumber) {
    	
   
   
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Balance Inquiry");
        setSize(900, 900);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new FlowLayout());
        setLocationRelativeTo(null);
	    setUndecorated(true); // Remove default frame decorations


        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		contentPane.setBackground(new Color(0,72,134));

        setContentPane(contentPane);

        DefaultTableModel tableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Make the table cells non-editable
            }
        };
        
        
        accountInfoTable = new JTable(tableModel);
        accountInfoTable.setFont(new Font("Tahoma", Font.PLAIN, 15));
        accountInfoTable.getTableHeader().setReorderingAllowed(false);
        JScrollPane scrollPane = new JScrollPane(accountInfoTable);
        scrollPane.setBounds(73, 280, 766, 562);

        tableModel.addColumn("Account Number");
        tableModel.addColumn("Full Name");
        tableModel.addColumn("Balance");

        displayAccountInformation(tableModel, accountNumber);
        displayTransactionHistory(tableModel, accountNumber);

        accountInfoTable.getTableHeader().setFont(accountInfoTable.getTableHeader().getFont().deriveFont(Font.BOLD));
        accountInfoTable.getTableHeader().setForeground(Color.black);
        accountInfoTable.getTableHeader().setBackground(Color.white);
        accountInfoTable.getTableHeader().setOpaque(true);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        accountInfoTable.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);

        Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
        
        DefaultTableCellRenderer headerRenderer = new CustomHeaderRenderer(border, Color.BLACK);
        accountInfoTable.getColumnModel().getColumn(0).setHeaderRenderer(headerRenderer);
        accountInfoTable.getColumnModel().getColumn(1).setHeaderRenderer(headerRenderer);
        accountInfoTable.getColumnModel().getColumn(2).setHeaderRenderer(headerRenderer);
        contentPane.setLayout(null);

        getContentPane().add(scrollPane);
        
        lblNewLabel = new JLabel("RETURN TO MAIN MENU");
        lblNewLabel.setForeground(new Color(255, 251, 248));
        lblNewLabel.setFont(new Font("FONTSPRING DEMO - Organetto Cnd Light", Font.PLAIN, 52));
        lblNewLabel.setBounds(238, 200, 500, 39);
        contentPane.add(lblNewLabel);
        
        JLabel lblNewLabel_2_1 = new JLabel("");
        lblNewLabel_2_1.setIcon(new ImageIcon(BalanceInquiry.class.getResource("/iBanking/Untitled (2048 × 2048 px) (100 × 100 px).png")));
        lblNewLabel_2_1.setBounds(23, -18, 134, 172);
        contentPane.add(lblNewLabel_2_1);
        
        JLabel lblNewLabel_1_1 = new JLabel("");
        lblNewLabel_1_1.setIcon(new ImageIcon(BalanceInquiry.class.getResource("/iBanking/Untitled (2048 × 2048 px) (100 × 100 px)-3.png")));
        lblNewLabel_1_1.setBounds(131, 36, 500, 62);
        contentPane.add(lblNewLabel_1_1);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBounds(6, 129, 888, 4);
        contentPane.add(panel_1);
        
        JLabel close = new JLabel("");
        close.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		dispose();
        	}
        });
        close.setIcon(new ImageIcon(BalanceInquiry.class.getResource("/iBanking/Close(3).png")));
        close.setBounds(839, 18, 61, 39);
        contentPane.add(close);
        
        
        // Mouse hover effect for btn_signIn
        lblNewLabel.addMouseListener(new MouseAdapter() {
					    @Override
					    public void mouseEntered(MouseEvent e) {
					    	lblNewLabel.setForeground(new Color (232, 175, 48));// Change background color on hover
					    }

					    @Override
					    public void mouseExited(MouseEvent e) {
					    	lblNewLabel.setForeground(new Color(255, 251, 248));
					    }
					    
					    @Override
					    public void mouseClicked (MouseEvent e) {
				    	Interface IF = new Interface(accountNumber);
				    	IF.setVisible(true);
				    	dispose();
				    }
					
				});	
        
    }

    private void displayAccountInformation(DefaultTableModel tableModel, String accountNumber) {
        try {
            File file = new File("NewAccount.txt");
            if (!file.exists()) {
                tableModel.addRow(new Object[]{"No account information found.", "", ""});
                return;
            }

            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] details = line.split(",");
                if (details.length >= 11 && details[0].equals(accountNumber)) {
                    String accNum = details[0];
                    String name = details[1] + " " + details[3]; // Combine the first and last name
                    double balance = Double.parseDouble(details[9]);
                    tableModel.addRow(new Object[]{accNum, name, balance});
                    break;
                }
            }

            reader.close();
        } catch (IOException e) {
            tableModel.addRow(new Object[]{"Error displaying account information: " + e.getMessage(), "", ""});
        }
    }

    private void displayTransactionHistory(DefaultTableModel tableModel, String accountNumber) {
        try {
            String transactionFileName = accountNumber + "_transactions.txt";
            File file = new File(transactionFileName);

            if (!file.exists()) {
                tableModel.addRow(new Object[]{"", "No transactions found for the account.", ""});
                return;
            }

            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;

            tableModel.addRow(new Object[]{});
            // Merge the cells and display the account number
            tableModel.addRow(new Object[]{"Transactions made for Account:", accountNumber, ""});
            // Merge the cells in the first row
            accountInfoTable.setRowHeight(tableModel.getRowCount() - 1, accountInfoTable.getRowHeight() * 2);
            // Set custom cell renderer for the first column
            accountInfoTable.getColumnModel().getColumn(0).setCellRenderer(new CustomCellRenderer());


            tableModel.addRow(new Object[]{});
            tableModel.addRow(new Object[]{"Date and Time", "Type", "Amount"});

            while ((line = reader.readLine()) != null) {
                String[] details = line.split(",");
                if (details.length >= 3) {
                    String timestamp = details[0];
                    String type = details[1];
                    String amount = details[2];
                    tableModel.addRow(new Object[]{timestamp, type, amount});
                }
            }

            reader.close();
        } catch (IOException e) {
            tableModel.addRow(new Object[]{"", "Error displaying transaction history: " + e.getMessage(), ""});
        }
    }

    class CustomCellRenderer extends DefaultTableCellRenderer {
        private static final long serialVersionUID = 1L;
        private static final Color LABEL_COLOR = new Color(139, 69, 19); // Brown color

        public CustomCellRenderer() {
            setHorizontalAlignment(CENTER);
            setForeground(LABEL_COLOR);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                boolean hasFocus, int row, int column) {
            super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (row == 1 && column == 0) {
                // Apply custom font to the label
                setFont(getFont().deriveFont(Font.BOLD));
            }
            return this;
        }
    }


    class CustomHeaderRenderer extends DefaultTableCellRenderer {
        private static final long serialVersionUID = 1L;
        Border border;
        Color backgroundColor;

        public CustomHeaderRenderer(Border border, Color backgroundColor) {
            this.border = border;
            this.backgroundColor = backgroundColor;
            setHorizontalAlignment(CENTER);
            setForeground(Color.WHITE);

            Font font = getFont();
            Map<TextAttribute, Object> attributes = new HashMap<>();
            attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
            setFont(font.deriveFont(attributes));
        }

        public void setBorder(Color color) {
            this.border = (Border) color;
        }

        @Override
        public void updateUI() {
            super.updateUI();
            setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
            setBackground(Color.BLACK);
            setOpaque(true);
        }
    }
    }


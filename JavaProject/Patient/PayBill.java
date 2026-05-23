package Patient;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class PayBill extends JFrame implements ActionListener {
    private JLabel totalBillLabel;
    private JButton paymentButton;
    private JButton backButton;
    private JLabel balanceLabel;
    private double balance = 10000.0;

    public PayBill(double totalBill) {
        setTitle("Pay Bill");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

    
        ImageIcon backgroundImage = new ImageIcon("images/new2.jpg"); 
        JLabel backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setLayout(new BorderLayout());
        setContentPane(backgroundLabel);

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setOpaque(false); 

        // Balance label
        balanceLabel = new JLabel("Balance: $" + balance);
        balanceLabel.setFont(balanceLabel.getFont().deriveFont(20f)); 

        // Back button
        backButton = new JButton("Back");
        backButton.setFont(backButton.getFont().deriveFont(16f)); 
        backButton.setPreferredSize(new Dimension(150, 50)); 
        backButton.setBackground(new Color(0, 0, 100)); 
        backButton.setForeground(Color.WHITE); 

        topPanel.add(backButton, BorderLayout.WEST);
        topPanel.add(balanceLabel, BorderLayout.EAST);
        add(topPanel, BorderLayout.NORTH);

    
        JPanel centerPanel = new JPanel();
        centerPanel.setOpaque(false); 
        totalBillLabel = new JLabel("Your Total Bill is: $" + totalBill);
        totalBillLabel.setForeground(new Color(0, 0, 100)); 
        totalBillLabel.setFont(totalBillLabel.getFont().deriveFont(20f)); 
        centerPanel.add(totalBillLabel);
        add(centerPanel, BorderLayout.CENTER);

        
        JPanel bottomPanel = new JPanel();
        bottomPanel.setOpaque(false); 
        paymentButton = new JButton("Payment");
        paymentButton.setFont(paymentButton.getFont().deriveFont(16f)); 
        paymentButton.setPreferredSize(new Dimension(200, 50)); 
        paymentButton.setBackground(new Color(0, 0, 100)); 
        paymentButton.setForeground(Color.WHITE); 
        bottomPanel.add(paymentButton);
        add(bottomPanel, BorderLayout.SOUTH);

        
        backButton.addActionListener(this);
        paymentButton.addActionListener(this);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {
            PatientDashboard patientDashboard = new PatientDashboard();
            patientDashboard.setVisible(true);
            setVisible(false);
        } else if (e.getSource() == paymentButton) {
            double totalBill = Double.parseDouble(totalBillLabel.getText().split("\\$")[1]);
            if (totalBill <= balance) {
                balance -= totalBill;
                balanceLabel.setText("Balance: $" + balance);
                JOptionPane.showMessageDialog(null, "Payment successful! Remaining Balance: $" + balance);
            } else {
                JOptionPane.showMessageDialog(null, "Insufficient balance! Payment unsuccessful.");
            }
        }
    }

    public static void main(String[] args) {
        try {
        
            BufferedReader reader = new BufferedReader(new FileReader("total_bill.txt"));
            String totalBillStr = reader.readLine();
            double totalBill = Double.parseDouble(totalBillStr);
            reader.close();

            new PayBill(totalBill);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

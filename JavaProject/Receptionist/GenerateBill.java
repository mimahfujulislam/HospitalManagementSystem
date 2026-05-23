package Receptionist;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class GenerateBill extends JFrame implements ActionListener {

    private Container c;

    private JPanel leftPanel, rightPanel;

    private JTextField appointmentFeeField;
    private JTextField medicineCostField;
    private JTextField medicalTestFeeField;
    private JTextField otherFeesField;

    private JButton calculateButton;
    private JButton backButton;

    private Font titleFont, labelFont, buttonFont;

    public GenerateBill() {

        setTitle("Generate Bill");
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        c = getContentPane();
        c.setLayout(null);
        c.setBackground(Color.WHITE);

        titleFont = new Font("Segoe UI", Font.BOLD, 36);
        labelFont = new Font("Segoe UI", Font.PLAIN, 16);
        buttonFont = new Font("Segoe UI", Font.BOLD, 18);

        // LEFT PANEL
        leftPanel = new JPanel();
        leftPanel.setBounds(0, 0, 400, 600);
        leftPanel.setLayout(null);
        leftPanel.setBackground(new Color(46, 125, 50));
        c.add(leftPanel);

        JLabel title = new JLabel("Generate");
        title.setBounds(110, 200, 250, 50);
        title.setFont(new Font("Segoe UI", Font.BOLD, 38));
        title.setForeground(Color.WHITE);
        leftPanel.add(title);

        JLabel title2 = new JLabel("Bill");
        title2.setBounds(160, 250, 200, 50);
        title2.setFont(new Font("Segoe UI", Font.BOLD, 38));
        title2.setForeground(Color.WHITE);
        leftPanel.add(title2);

        JLabel sub = new JLabel("Calculate patient billing easily");
        sub.setBounds(70, 320, 300, 30);
        sub.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        sub.setForeground(new Color(220, 220, 220));
        leftPanel.add(sub);

        // RIGHT PANEL
        rightPanel = new JPanel();
        rightPanel.setBounds(400, 0, 600, 600);
        rightPanel.setLayout(null);
        rightPanel.setBackground(Color.WHITE);
        c.add(rightPanel);

        JLabel header = new JLabel("Billing Details");
        header.setBounds(180, 40, 300, 50);
        header.setFont(titleFont);
        header.setForeground(new Color(46, 125, 50));
        rightPanel.add(header);

        addLabel("Appointment Fee", 120, 120);
        appointmentFeeField = addField(300, 120);

        addLabel("Medicine Cost", 120, 180);
        medicineCostField = addField(300, 180);

        addLabel("Medical Test Fee", 120, 240);
        medicalTestFeeField = addField(300, 240);

        addLabel("Other Fees", 120, 300);
        otherFeesField = addField(300, 300);

        calculateButton = new JButton("CALCULATE TOTAL");
        calculateButton.setBounds(160, 380, 280, 50);
        calculateButton.setFont(buttonFont);
        calculateButton.setForeground(Color.WHITE);
        calculateButton.setBackground(new Color(33, 150, 243));
        calculateButton.setFocusPainted(false);
        calculateButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        calculateButton.addActionListener(this);
        rightPanel.add(calculateButton);

        backButton = new JButton("BACK");
        backButton.setBounds(160, 450, 280, 45);
        backButton.setFont(buttonFont);
        backButton.setForeground(Color.WHITE);
        backButton.setBackground(new Color(255, 87, 34));
        backButton.setFocusPainted(false);
        backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        backButton.addActionListener(e -> {
            new ReceptionistDashboard();
            dispose();
        });

        rightPanel.add(backButton);

        setVisible(true);
    }

    private void addLabel(String text, int x, int y) {
        JLabel label = new JLabel(text);
        label.setBounds(x, y, 200, 30);
        label.setFont(labelFont);
        label.setForeground(Color.DARK_GRAY);
        rightPanel.add(label);
    }

    private JTextField addField(int x, int y) {
        JTextField field = new JTextField();
        field.setBounds(x, y, 200, 35);
        field.setFont(labelFont);
        rightPanel.add(field);
        return field;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            double appointmentFee = Double.parseDouble(appointmentFeeField.getText());
            double medicineCost = Double.parseDouble(medicineCostField.getText());
            double medicalTestFee = Double.parseDouble(medicalTestFeeField.getText());
            double otherFees = Double.parseDouble(otherFeesField.getText());

            double totalBill = appointmentFee + medicineCost + medicalTestFee + otherFees;

            FileWriter writer = new FileWriter("total_bill.txt");
            writer.write(String.valueOf(totalBill));
            writer.close();

            JOptionPane.showMessageDialog(
                    this,
                    "Total Bill: $" + totalBill
            );

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(
                    this,
                    "Please enter valid numbers!"
            );
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GenerateBill::new);
    }
}
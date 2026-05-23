package Receptionist;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ReceptionistDashboard extends JFrame implements ActionListener {

    private JButton medicalRecordButton;
    private JButton generateBillButton;
    private JButton showNotificationsButton;

    public ReceptionistDashboard() {

        setTitle("Receptionist Dashboard");
        setSize(900, 600);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane();
        c.setLayout(null);
        c.setBackground(new Color(245, 247, 250));

        JPanel header = new JPanel();
        header.setBounds(0, 0, 900, 100);
        header.setBackground(new Color(17, 66, 50));
        header.setLayout(null);
        c.add(header);

        JLabel title = new JLabel("Receptionist Dashboard");
        title.setBounds(30, 25, 400, 40);
        title.setFont(new Font("Segoe UI", Font.BOLD, 28));
        title.setForeground(Color.WHITE);
        header.add(title);

        medicalRecordButton = createButton("Medical Records", 150);
        generateBillButton = createButton("Generate Bill", 250);
        showNotificationsButton = createButton("Notifications", 350);

        c.add(medicalRecordButton);
        c.add(generateBillButton);
        c.add(showNotificationsButton);

        setVisible(true);
    }

    private JButton createButton(String text, int y) {
        JButton btn = new JButton(text);
        btn.setBounds(300, y, 300, 50);
        btn.setFont(new Font("Segoe UI", Font.BOLD, 18));
        btn.setBackground(new Color(17, 66, 50));
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.addActionListener(this);
        return btn;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == medicalRecordButton) {
            dispose();
            new MedicalView().setVisible(true);
        } else if (e.getSource() == generateBillButton) {
            dispose();
            new GenerateBill().setVisible(true);
        } else if (e.getSource() == showNotificationsButton) {
            dispose();
            new ReceptionistNotifications().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new ReceptionistDashboard();
    }
}
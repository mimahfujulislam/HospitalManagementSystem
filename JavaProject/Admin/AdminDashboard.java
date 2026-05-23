package Admin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AdminDashboard extends JFrame implements ActionListener {

    private JButton userManagementButton;
    private JButton sendNotificationsButton;

    private JLabel titleLabel;
    private JLabel subtitleLabel;

    private JPanel topPanel;
    private JPanel centerPanel;

    private Font titleFont;
    private Font subTitleFont;
    private Font buttonFont;

    public AdminDashboard() {

        setTitle("Admin Dashboard");
        setSize(700, 550);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        getContentPane().setBackground(new Color(240, 244, 248));
        setLayout(null);

        titleFont = new Font("Segoe UI", Font.BOLD, 34);
        subTitleFont = new Font("Segoe UI", Font.PLAIN, 18);
        buttonFont = new Font("Segoe UI", Font.BOLD, 20);

        topPanel = new JPanel();
        topPanel.setBounds(0, 0, 700, 140);
        topPanel.setLayout(null);
        topPanel.setBackground(new Color(25, 118, 210));
        add(topPanel);

        titleLabel = new JLabel("Admin Dashboard");
        titleLabel.setBounds(190, 25, 350, 40);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(titleFont);
        topPanel.add(titleLabel);

        subtitleLabel = new JLabel("Hospital Management System");
        subtitleLabel.setBounds(220, 75, 300, 25);
        subtitleLabel.setForeground(new Color(230, 230, 230));
        subtitleLabel.setFont(subTitleFont);
        topPanel.add(subtitleLabel);

        centerPanel = new JPanel();
        centerPanel.setBounds(120, 180, 450, 220);
        centerPanel.setLayout(new GridLayout(2, 1, 20, 20));
        centerPanel.setBackground(Color.WHITE);
        centerPanel.setBorder(BorderFactory.createLineBorder(
                new Color(220, 220, 220), 2));

        add(centerPanel);

        userManagementButton = createButton(
                "User Management",
                new Color(76, 175, 80)
        );

        sendNotificationsButton = createButton(
                "Send Notifications",
                new Color(255, 152, 0)
        );

        centerPanel.add(userManagementButton);
        centerPanel.add(sendNotificationsButton);
    }

    private JButton createButton(String text, Color color) {

        JButton button = new JButton(text);

        button.setFont(buttonFont);
        button.setForeground(Color.WHITE);
        button.setBackground(color);
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setBorder(BorderFactory.createEmptyBorder());

        button.addMouseListener(new MouseAdapter() {

            public void mouseEntered(MouseEvent e) {
                button.setBackground(color.darker());
            }

            public void mouseExited(MouseEvent e) {
                button.setBackground(color);
            }
        });

        button.addActionListener(this);

        return button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == userManagementButton) {

            UserManagement userManagement = new UserManagement();
            userManagement.setVisible(true);

            setVisible(false);

        } else if (e.getSource() == sendNotificationsButton) {

            Notification notification = new Notification();
            notification.setVisible(true);

            setVisible(false);
        }
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {

            public void run() {

                AdminDashboard dashboard = new AdminDashboard();
                dashboard.setVisible(true);
            }
        });
    }
}
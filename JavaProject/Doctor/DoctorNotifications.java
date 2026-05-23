package Doctor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DoctorNotifications extends JFrame implements ActionListener {

    private Container c;

    private JPanel leftPanel;
    private JPanel rightPanel;

    private JLabel titleLabel;
    private JLabel subTitleLabel;

    private JLabel notificationTitle;

    private JTextArea notificationsArea;

    private JScrollPane scrollPane;

    private JButton backButton;

    private Font titleFont;
    private Font subTitleFont;
    private Font buttonFont;

    public DoctorNotifications() {

        setTitle("Doctor Notifications");

        setSize(1000, 600);

        setResizable(false);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

        c = getContentPane();

        c.setLayout(null);

        c.setBackground(Color.WHITE);

        titleFont = new Font("Segoe UI", Font.BOLD, 36);

        subTitleFont = new Font("Segoe UI", Font.PLAIN, 18);

        buttonFont = new Font("Segoe UI", Font.BOLD, 17);

        leftPanel = new JPanel();

        leftPanel.setBounds(0, 0, 430, 600);

        leftPanel.setLayout(null);

        leftPanel.setBackground(new Color(15, 76, 129));

        c.add(leftPanel);

        titleLabel = new JLabel("Doctor");

        titleLabel.setBounds(120, 140, 250, 50);

        titleLabel.setFont(new Font(
                "Segoe UI",
                Font.BOLD,
                44
        ));

        titleLabel.setForeground(Color.WHITE);

        leftPanel.add(titleLabel);

        JLabel title2Label = new JLabel("Notifications");

        title2Label.setBounds(70, 195, 320, 50);

        title2Label.setFont(new Font(
                "Segoe UI",
                Font.BOLD,
                36
        ));

        title2Label.setForeground(Color.WHITE);

        leftPanel.add(title2Label);

        subTitleLabel = new JLabel(
                "View important hospital updates"
        );

        subTitleLabel.setBounds(80, 270, 300, 30);

        subTitleLabel.setFont(subTitleFont);

        subTitleLabel.setForeground(
                new Color(220, 220, 220)
        );

        leftPanel.add(subTitleLabel);

        rightPanel = new JPanel();

        rightPanel.setBounds(430, 0, 570, 600);

        rightPanel.setLayout(null);

        rightPanel.setBackground(Color.WHITE);

        c.add(rightPanel);

        notificationTitle = new JLabel("Notifications");

        notificationTitle.setBounds(150, 50, 300, 45);

        notificationTitle.setFont(titleFont);

        notificationTitle.setForeground(
                new Color(15, 76, 129)
        );

        rightPanel.add(notificationTitle);

        JLabel descriptionLabel = new JLabel(
                "Latest notifications and announcements"
        );

        descriptionLabel.setBounds(120, 100, 350, 30);

        descriptionLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        16
                )
        );

        descriptionLabel.setForeground(
                new Color(120, 120, 120)
        );

        rightPanel.add(descriptionLabel);

        notificationsArea = new JTextArea();

        notificationsArea.setEditable(false);

        notificationsArea.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        16
                )
        );

        notificationsArea.setLineWrap(true);

        notificationsArea.setWrapStyleWord(true);

        notificationsArea.setBackground(
                new Color(245, 247, 250)
        );

        notificationsArea.setBorder(
                BorderFactory.createEmptyBorder(
                        15,
                        15,
                        15,
                        15
                )
        );

        scrollPane = new JScrollPane(notificationsArea);

        scrollPane.setBounds(50, 160, 470, 300);

        scrollPane.setBorder(
                BorderFactory.createLineBorder(
                        new Color(220, 220, 220),
                        2
                )
        );

        rightPanel.add(scrollPane);

        loadNotifications();

        backButton = new JButton("BACK TO DASHBOARD");

        backButton.setBounds(120, 500, 320, 50);

        backButton.setFont(buttonFont);

        backButton.setForeground(Color.WHITE);

        backButton.setBackground(
                new Color(15, 76, 129)
        );

        backButton.setFocusPainted(false);

        backButton.setBorder(
                BorderFactory.createEmptyBorder()
        );

        backButton.setCursor(
                new Cursor(Cursor.HAND_CURSOR)
        );

        backButton.addActionListener(this);

        backButton.addMouseListener(
                new java.awt.event.MouseAdapter() {

                    public void mouseEntered(
                            java.awt.event.MouseEvent evt
                    ) {

                        backButton.setBackground(
                                new Color(8, 45, 78)
                        );
                    }

                    public void mouseExited(
                            java.awt.event.MouseEvent evt
                    ) {

                        backButton.setBackground(
                                new Color(15, 76, 129)
                        );
                    }
                }
        );

        rightPanel.add(backButton);

        setVisible(true);
    }

    private void loadNotifications() {

        try {

            BufferedReader reader =
                    new BufferedReader(
                            new FileReader(
                                    "notification.txt"
                            )
                    );

            StringBuilder sb =
                    new StringBuilder();

            String line;

            while ((line = reader.readLine()) != null) {

                sb.append("• ")
                        .append(line)
                        .append("\n\n");
            }

            notificationsArea.setText(
                    sb.toString()
            );

            reader.close();

        } catch (IOException e) {

            notificationsArea.setText(
                    "No notifications available."
            );
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == backButton) {

            new DoctorDashboard();

            dispose();
        }
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(
                new Runnable() {

                    public void run() {

                        new DoctorNotifications();
                    }
                }
        );
    }
}
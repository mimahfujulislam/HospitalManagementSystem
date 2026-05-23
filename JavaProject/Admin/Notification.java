package Admin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Notification extends JFrame implements ActionListener {

    private Container c;

    private JPanel leftPanel;
    private JPanel rightPanel;

    private JLabel titleLabel;
    private JLabel title2Label;
    private JLabel subTitleLabel;

    private JLabel notificationTitle;
    private JLabel descriptionLabel;

    private JLabel notificationLabel;
    private JLabel dateTimeLabel;
    private JLabel imageLabel;

    private JTextArea notificationArea;
    private JTextField dateTimeField;

    private JButton sendButton;
    private JButton backButton;

    private ImageIcon imageIcon;

    private Font titleFont;
    private Font subTitleFont;
    private Font labelFont;
    private Font buttonFont;

    public Notification() {

        super("Send Notification");

        setSize(950, 580);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        c = getContentPane();
        c.setLayout(null);
        c.setBackground(Color.WHITE);

        titleFont = new Font("Segoe UI", Font.BOLD, 36);
        subTitleFont = new Font("Segoe UI", Font.PLAIN, 18);
        labelFont = new Font("Segoe UI", Font.PLAIN, 17);
        buttonFont = new Font("Segoe UI", Font.BOLD, 17);

        leftPanel = new JPanel();
        leftPanel.setBounds(0, 0, 430, 580);
        leftPanel.setLayout(null);
        leftPanel.setBackground(new Color(15, 76, 129));
        c.add(leftPanel);

        titleLabel = new JLabel("Hospital");
        titleLabel.setBounds(100, 120, 250, 50);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 44));
        titleLabel.setForeground(Color.WHITE);
        leftPanel.add(titleLabel);

        title2Label = new JLabel("Management System");
        title2Label.setBounds(35, 175, 360, 50);
        title2Label.setFont(new Font("Segoe UI", Font.BOLD, 36));
        title2Label.setForeground(Color.WHITE);
        leftPanel.add(title2Label);

        subTitleLabel = new JLabel("Notification Management");
        subTitleLabel.setBounds(90, 240, 260, 30);
        subTitleLabel.setFont(subTitleFont);
        subTitleLabel.setForeground(new Color(220, 220, 220));
        leftPanel.add(subTitleLabel);

        imageIcon = new ImageIcon(
                getClass().getResource("/images/hospital-png-4.png")
        );

        Image scaledImage = imageIcon.getImage().getScaledInstance(
                170,
                170,
                Image.SCALE_SMOOTH
        );

        imageLabel = new JLabel(new ImageIcon(scaledImage));
        imageLabel.setBounds(125, 320, 170, 170);
        leftPanel.add(imageLabel);

        rightPanel = new JPanel();
        rightPanel.setBounds(430, 0, 520, 580);
        rightPanel.setLayout(null);
        rightPanel.setBackground(Color.WHITE);
        c.add(rightPanel);

        notificationTitle = new JLabel("Send Notification");
        notificationTitle.setBounds(100, 40, 350, 50);
        notificationTitle.setFont(titleFont);
        notificationTitle.setForeground(new Color(15, 76, 129));
        rightPanel.add(notificationTitle);

        descriptionLabel = new JLabel(
                "Send important updates to system users"
        );

        descriptionLabel.setBounds(100, 90, 320, 30);
        descriptionLabel.setFont(new Font(
                "Segoe UI",
                Font.PLAIN,
                16
        ));

        descriptionLabel.setForeground(
                new Color(120, 120, 120)
        );

        rightPanel.add(descriptionLabel);

        notificationLabel = new JLabel("Notification Message");
        notificationLabel.setBounds(70, 150, 200, 30);
        notificationLabel.setFont(labelFont);
        rightPanel.add(notificationLabel);

        notificationArea = new JTextArea();

        notificationArea.setFont(labelFont);
        notificationArea.setLineWrap(true);
        notificationArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(notificationArea);

        scrollPane.setBounds(70, 185, 350, 140);

        scrollPane.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(
                        new Color(210, 210, 210), 2),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)
        ));

        rightPanel.add(scrollPane);

        dateTimeLabel = new JLabel("Date & Time");
        dateTimeLabel.setBounds(70, 350, 150, 30);
        dateTimeLabel.setFont(labelFont);
        rightPanel.add(dateTimeLabel);

        dateTimeField = new JTextField();

        dateTimeField.setBounds(70, 385, 350, 48);

        dateTimeField.setFont(labelFont);

        dateTimeField.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                new Color(210, 210, 210), 2),
                        BorderFactory.createEmptyBorder(
                                5, 10, 5, 10
                        )
                )
        );

        rightPanel.add(dateTimeField);

        backButton = new JButton("BACK");

        backButton.setBounds(70, 470, 160, 50);

        backButton.setFont(buttonFont);
        backButton.setForeground(Color.WHITE);
        backButton.setBackground(new Color(120, 120, 120));

        backButton.setFocusPainted(false);
        backButton.setBorder(BorderFactory.createEmptyBorder());

        backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        backButton.addMouseListener(new MouseAdapter() {

            public void mouseEntered(MouseEvent e) {

                backButton.setBackground(
                        new Color(90, 90, 90)
                );
            }

            public void mouseExited(MouseEvent e) {

                backButton.setBackground(
                        new Color(120, 120, 120)
                );
            }
        });

        backButton.addActionListener(this);

        rightPanel.add(backButton);

        sendButton = new JButton("SEND");

        sendButton.setBounds(260, 470, 160, 50);

        sendButton.setFont(buttonFont);
        sendButton.setForeground(Color.WHITE);
        sendButton.setBackground(new Color(15, 76, 129));

        sendButton.setFocusPainted(false);
        sendButton.setBorder(BorderFactory.createEmptyBorder());

        sendButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        sendButton.addMouseListener(new MouseAdapter() {

            public void mouseEntered(MouseEvent e) {

                sendButton.setBackground(
                        new Color(8, 45, 78)
                );
            }

            public void mouseExited(MouseEvent e) {

                sendButton.setBackground(
                        new Color(15, 76, 129)
                );
            }
        });

        sendButton.addActionListener(this);

        rightPanel.add(sendButton);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == backButton) {

            AdminDashboard adminDashboard =
                    new AdminDashboard();

            adminDashboard.setVisible(true);

            this.setVisible(false);

        } else if (e.getSource() == sendButton) {

            String notificationText =
                    notificationArea.getText();

            String dateTimeText =
                    dateTimeField.getText();

            if (!notificationText.isEmpty()
                    && !dateTimeText.isEmpty()) {

                try (

                        BufferedWriter writer =
                                new BufferedWriter(
                                        new FileWriter(
                                                "notification.txt",
                                                true
                                        )
                                )
                ) {

                    writer.write(
                            "Notification: "
                                    + notificationText
                                    + ", Date & Time: "
                                    + dateTimeText
                    );

                    writer.newLine();

                    writer.flush();

                    JOptionPane.showMessageDialog(
                            this,
                            "Notification Successfully Sent!"
                    );

                    notificationArea.setText("");
                    dateTimeField.setText("");

                } catch (IOException ex) {

                    ex.printStackTrace();

                    JOptionPane.showMessageDialog(
                            this,
                            "Failed to send notification."
                    );
                }

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "Please fill all fields."
                );
            }
        }
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {

            public void run() {

                Notification notification =
                        new Notification();

                notification.setVisible(true);
            }
        });
    }
}
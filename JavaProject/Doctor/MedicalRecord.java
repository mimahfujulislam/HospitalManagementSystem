package Doctor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class MedicalRecord extends JFrame {

    private Container c;

    private JPanel leftPanel;
    private JPanel rightPanel;

    private JLabel titleLabel;
    private JLabel subTitleLabel;
    private JLabel quoteLabel;

    private JLabel recordTitle;
    private JLabel descriptionLabel;

    private JLabel medicineLabel;
    private JLabel testsLabel;

    private JLabel imageLabel;

    private JTextField medicineNameField;
    private JTextArea medicalTestsArea;

    private JButton backButton;
    private JButton sendButton;

    private Font titleFont;
    private Font subTitleFont;
    private Font labelFont;
    private Font buttonFont;

    private ImageIcon imageIcon;

    public MedicalRecord() {

        setTitle("Medical Record");

        setSize(1000, 600);

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

        leftPanel.setBounds(0, 0, 430, 600);

        leftPanel.setLayout(null);

        leftPanel.setBackground(new Color(15, 76, 129));

        c.add(leftPanel);

        titleLabel = new JLabel("Medical");
        titleLabel.setBounds(110, 90, 250, 50);

        titleLabel.setFont(new Font(
                "Segoe UI",
                Font.BOLD,
                42
        ));

        titleLabel.setForeground(Color.WHITE);

        leftPanel.add(titleLabel);

        JLabel title2 = new JLabel("Record System");

        title2.setBounds(60, 145, 320, 50);

        title2.setFont(new Font(
                "Segoe UI",
                Font.BOLD,
                36
        ));

        title2.setForeground(Color.WHITE);

        leftPanel.add(title2);

        subTitleLabel = new JLabel(
                "Doctor Patient Record Management"
        );

        subTitleLabel.setBounds(70, 210, 320, 30);

        subTitleLabel.setFont(subTitleFont);

        subTitleLabel.setForeground(
                new Color(220, 220, 220)
        );

        leftPanel.add(subTitleLabel);

        quoteLabel = new JLabel(
                "<html><center>"
                        + "\"Good medical care begins with<br>"
                        + "accurate patient records.\""
                        + "</center></html>"
        );

        quoteLabel.setBounds(60, 260, 300, 60);

        quoteLabel.setFont(new Font(
                "Segoe UI",
                Font.ITALIC,
                15
        ));

        quoteLabel.setForeground(Color.WHITE);

        leftPanel.add(quoteLabel);

        imageIcon = new ImageIcon(
                getClass().getResource("/images/doctor.png")
        );

        Image scaledImage = imageIcon.getImage().getScaledInstance(
                220,
                220,
                Image.SCALE_SMOOTH
        );

        imageLabel = new JLabel(
                new ImageIcon(scaledImage)
        );

        imageLabel.setBounds(100, 330, 220, 220);

        leftPanel.add(imageLabel);

        rightPanel = new JPanel();

        rightPanel.setBounds(430, 0, 570, 600);

        rightPanel.setLayout(null);

        rightPanel.setBackground(Color.WHITE);

        c.add(rightPanel);

        recordTitle = new JLabel("Patient Medical Record");

        recordTitle.setBounds(90, 40, 380, 50);

        recordTitle.setFont(titleFont);

        recordTitle.setForeground(
                new Color(15, 76, 129)
        );

        rightPanel.add(recordTitle);

        descriptionLabel = new JLabel(
                "Add medicine and medical test information"
        );

        descriptionLabel.setBounds(90, 90, 350, 30);

        descriptionLabel.setFont(
                new Font("Segoe UI", Font.PLAIN, 16)
        );

        descriptionLabel.setForeground(
                new Color(120, 120, 120)
        );

        rightPanel.add(descriptionLabel);

        medicineLabel = new JLabel("Medicine Name");

        medicineLabel.setBounds(70, 160, 150, 30);

        medicineLabel.setFont(labelFont);

        rightPanel.add(medicineLabel);

        medicineNameField = new JTextField();

        medicineNameField.setBounds(70, 195, 360, 48);

        medicineNameField.setFont(labelFont);

        medicineNameField.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                new Color(210, 210, 210),
                                2
                        ),
                        BorderFactory.createEmptyBorder(
                                5,
                                10,
                                5,
                                10
                        )
                )
        );

        rightPanel.add(medicineNameField);

        testsLabel = new JLabel("Medical Tests");

        testsLabel.setBounds(70, 270, 150, 30);

        testsLabel.setFont(labelFont);

        rightPanel.add(testsLabel);

        medicalTestsArea = new JTextArea();

        medicalTestsArea.setFont(labelFont);

        medicalTestsArea.setLineWrap(true);

        medicalTestsArea.setWrapStyleWord(true);

        JScrollPane scrollPane =
                new JScrollPane(medicalTestsArea);

        scrollPane.setBounds(70, 305, 360, 120);

        scrollPane.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                new Color(210, 210, 210),
                                2
                        ),
                        BorderFactory.createEmptyBorder(
                                5,
                                5,
                                5,
                                5
                        )
                )
        );

        rightPanel.add(scrollPane);

        backButton = new JButton("BACK");

        backButton.setBounds(70, 470, 160, 50);

        backButton.setFont(buttonFont);

        backButton.setForeground(Color.WHITE);

        backButton.setBackground(
                new Color(120, 120, 120)
        );

        backButton.setFocusPainted(false);

        backButton.setBorder(
                BorderFactory.createEmptyBorder()
        );

        backButton.setCursor(
                new Cursor(Cursor.HAND_CURSOR)
        );

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

        rightPanel.add(backButton);

        sendButton = new JButton("SEND RECORD");

        sendButton.setBounds(270, 470, 160, 50);

        sendButton.setFont(buttonFont);

        sendButton.setForeground(Color.WHITE);

        sendButton.setBackground(
                new Color(15, 76, 129)
        );

        sendButton.setFocusPainted(false);

        sendButton.setBorder(
                BorderFactory.createEmptyBorder()
        );

        sendButton.setCursor(
                new Cursor(Cursor.HAND_CURSOR)
        );

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

        rightPanel.add(sendButton);

        backButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                DoctorDashboard doctorDashboard =
                        new DoctorDashboard();

                doctorDashboard.setVisible(true);

                setVisible(false);
            }
        });

        sendButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                writeToMedicalRecord();
            }
        });

        setVisible(true);
    }

    private void writeToMedicalRecord() {

        String medicineName =
                medicineNameField.getText();

        String medicalTests =
                medicalTestsArea.getText();

        if (medicineName.isEmpty()
                || medicalTests.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please fill all fields."
            );

            return;
        }

        try {

            FileWriter writer =
                    new FileWriter(
                            "medical_record.txt",
                            true
                    );

            writer.write(
                    "Medicine Name: "
                            + medicineName
                            + ", Medical Tests: "
                            + medicalTests
                            + "\n"
            );

            writer.close();

            JOptionPane.showMessageDialog(
                    this,
                    "Medical Record Saved Successfully."
            );

            medicineNameField.setText("");

            medicalTestsArea.setText("");

        } catch (IOException e) {

            JOptionPane.showMessageDialog(
                    this,
                    "An error occurred while saving data."
            );

            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {

            public void run() {

                new MedicalRecord();
            }
        });
    }
}
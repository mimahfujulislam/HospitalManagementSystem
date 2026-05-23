package Doctor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DoctorDashboard extends JFrame implements ActionListener {

    private Container c;

    private JPanel leftPanel;
    private JPanel rightPanel;

    private JLabel titleLabel;
    private JLabel subTitleLabel;

    private JButton viewAppointmentsBtn;
    private JButton prescribeBtn;
    private JButton sendRecordsBtn;
    private JButton showNotificationBtn;
    private JButton logoutBtn;

    private Font titleFont;
    private Font subTitleFont;
    private Font buttonFont;

    public DoctorDashboard() {

        setTitle("Doctor Dashboard");

        setSize(1000, 600);

        setResizable(false);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

        c = getContentPane();

        c.setLayout(null);

        c.setBackground(Color.WHITE);

        titleFont = new Font("Segoe UI", Font.BOLD, 36);

        subTitleFont = new Font("Segoe UI", Font.PLAIN, 18);

        buttonFont = new Font("Segoe UI", Font.BOLD, 18);

        leftPanel = new JPanel();

        leftPanel.setBounds(0, 0, 430, 600);

        leftPanel.setLayout(null);

        leftPanel.setBackground(new Color(15, 76, 129));

        c.add(leftPanel);

        titleLabel = new JLabel("Doctor Portal");

        titleLabel.setBounds(85, 220, 320, 55);

        titleLabel.setFont(new Font(
                "Segoe UI",
                Font.BOLD,
                42
        ));

        titleLabel.setForeground(Color.WHITE);

        leftPanel.add(titleLabel);

        subTitleLabel = new JLabel(
                "Hospital Management System"
        );

        subTitleLabel.setBounds(70, 285, 320, 30);

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

        JLabel dashboardLabel = new JLabel(
                "Dashboard"
        );

        dashboardLabel.setBounds(175, 45, 250, 45);

        dashboardLabel.setFont(titleFont);

        dashboardLabel.setForeground(
                new Color(15, 76, 129)
        );

        rightPanel.add(dashboardLabel);

        JLabel descriptionLabel = new JLabel(
                "<html>Manage appointments, prescriptions, "
                        + "medical records and notifications efficiently.</html>"
        );

        descriptionLabel.setBounds(85, 100, 410, 50);

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

        viewAppointmentsBtn = createButton(
                "View Patient Appointments",
                new Color(33, 150, 243)
        );

        viewAppointmentsBtn.setBounds(
                110,
                180,
                340,
                55
        );

        rightPanel.add(viewAppointmentsBtn);

        prescribeBtn = createButton(
                "Write Prescription",
                new Color(76, 175, 80)
        );

        prescribeBtn.setBounds(
                110,
                260,
                340,
                55
        );

        rightPanel.add(prescribeBtn);

        sendRecordsBtn = createButton(
                "Send Records to Receptionist",
                new Color(255, 152, 0)
        );

        sendRecordsBtn.setBounds(
                110,
                340,
                340,
                55
        );

        rightPanel.add(sendRecordsBtn);

        showNotificationBtn = createButton(
                "Show Notifications",
                new Color(156, 39, 176)
        );

        showNotificationBtn.setBounds(
                110,
                420,
                340,
                55
        );

        rightPanel.add(showNotificationBtn);

        logoutBtn = new JButton("Logout");

        logoutBtn.setBounds(
                420,
                20,
                110,
                38
        );

        logoutBtn.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        14
                )
        );

        logoutBtn.setBackground(
                new Color(220, 53, 69)
        );

        logoutBtn.setForeground(Color.WHITE);

        logoutBtn.setFocusPainted(false);

        logoutBtn.setCursor(
                new Cursor(Cursor.HAND_CURSOR)
        );

        logoutBtn.addActionListener(this);

        rightPanel.add(logoutBtn);

        setVisible(true);
    }

    private JButton createButton(
            String text,
            Color color
    ) {

        JButton button = new JButton(text);

        button.setFont(buttonFont);

        button.setForeground(Color.WHITE);

        button.setBackground(color);

        button.setFocusPainted(false);

        button.setBorder(
                BorderFactory.createEmptyBorder()
        );

        button.setCursor(
                new Cursor(Cursor.HAND_CURSOR)
        );

        button.addMouseListener(
                new MouseAdapter() {

                    public void mouseEntered(
                            MouseEvent e
                    ) {

                        button.setBackground(
                                color.darker()
                        );
                    }

                    public void mouseExited(
                            MouseEvent e
                    ) {

                        button.setBackground(color);
                    }
                }
        );

        button.addActionListener(this);

        return button;
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == viewAppointmentsBtn) {

            ViewAppointment viewAppointment =
                    new ViewAppointment();

            viewAppointment.setVisible(true);

            dispose();

        } else if (e.getSource() == prescribeBtn) {

            Prescription prescription =
                    new Prescription();

            prescription.setVisible(true);

            dispose();

        } else if (e.getSource() == sendRecordsBtn) {

            MedicalRecord medicalRecord =
                    new MedicalRecord();

            medicalRecord.setVisible(true);

            dispose();

        } else if (e.getSource() == showNotificationBtn) {

            DoctorNotifications doctorNotifications =
                    new DoctorNotifications();

            doctorNotifications.setVisible(true);

            dispose();

        } else if (e.getSource() == logoutBtn) {

            new SignIn().setVisible(true);

            dispose();
        }
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(
                new Runnable() {

                    public void run() {

                        new DoctorDashboard();
                    }
                }
        );
    }
}

class SignIn extends JFrame {

        public SignIn() {
                setTitle("Sign In");
                setSize(400, 250);
                setResizable(false);
                setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                setLocationRelativeTo(null);

                Container c = getContentPane();
                c.setLayout(new BorderLayout());

                JLabel lbl = new JLabel("Sign In screen not implemented.", SwingConstants.CENTER);
                c.add(lbl, BorderLayout.CENTER);
        }
}
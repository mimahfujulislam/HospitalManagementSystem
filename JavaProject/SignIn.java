import Admin.AdminDashboard;
import Doctor.DoctorDashboard;
import Patient.PatientDashboard;
import Receptionist.ReceptionistDashboard;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SignIn extends JFrame implements ActionListener, MouseListener {

    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton signInButton;
    private JLabel signUpLabel;

    public SignIn() {

        setTitle("Hospital Management System");
        setSize(900, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);

        getContentPane().setBackground(new Color(240, 244, 248));

        JPanel leftPanel = new JPanel();
        leftPanel.setBounds(0, 0, 420, 550);
        leftPanel.setBackground(new Color(25, 118, 210));
        leftPanel.setLayout(null);
        add(leftPanel);

        JLabel title = new JLabel("Hospital");
        title.setBounds(110, 170, 250, 50);
        title.setFont(new Font("Segoe UI", Font.BOLD, 40));
        title.setForeground(Color.WHITE);
        leftPanel.add(title);

        JLabel title2 = new JLabel("Management System");
        title2.setBounds(40, 220, 350, 50);
        title2.setFont(new Font("Segoe UI", Font.BOLD, 26));
        title2.setForeground(Color.WHITE);
        leftPanel.add(title2);

        JLabel subtitle = new JLabel("Safe • Fast • Reliable");
        subtitle.setBounds(110, 290, 250, 30);
        subtitle.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        subtitle.setForeground(new Color(220, 220, 220));
        leftPanel.add(subtitle);

        JPanel rightPanel = new JPanel();
        rightPanel.setBounds(420, 0, 480, 550);
        rightPanel.setLayout(null);
        rightPanel.setBackground(Color.WHITE);
        add(rightPanel);

        JLabel loginLabel = new JLabel("SIGN IN");
        loginLabel.setBounds(170, 70, 200, 50);
        loginLabel.setFont(new Font("Segoe UI", Font.BOLD, 32));
        loginLabel.setForeground(new Color(25, 118, 210));
        rightPanel.add(loginLabel);

        JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setBounds(70, 150, 120, 25);
        usernameLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        rightPanel.add(usernameLabel);

        usernameField = new JTextField();
        usernameField.setBounds(70, 175, 320, 45);
        usernameField.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        usernameField.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));
        rightPanel.add(usernameField);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(70, 245, 120, 25);
        passwordLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        rightPanel.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(70, 270, 320, 45);
        passwordField.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        passwordField.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));
        rightPanel.add(passwordField);

        signInButton = new JButton("SIGN IN");
        signInButton.setBounds(70, 350, 320, 50);
        signInButton.setFont(new Font("Segoe UI", Font.BOLD, 16));
        signInButton.setForeground(Color.WHITE);
        signInButton.setBackground(new Color(25, 118, 210));
        signInButton.setFocusPainted(false);
        signInButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        signInButton.addActionListener(this);
        rightPanel.add(signInButton);

        signUpLabel = new JLabel("Don't have an account? Sign Up");
        signUpLabel.setBounds(120, 420, 250, 30);
        signUpLabel.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        signUpLabel.setForeground(new Color(80, 80, 80));
        signUpLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        signUpLabel.addMouseListener(this);
        rightPanel.add(signUpLabel);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == signInButton) {

            String name = usernameField.getText().trim();
            String password = new String(passwordField.getPassword()).trim();

            Account acc = new Account();

            if (acc.validAccount(name, password)) {

                String role = acc.getRole(name).trim().toLowerCase();

                JOptionPane.showMessageDialog(this, "Login Successful");

                dispose();

                switch (role) {

                    case "doctor":
                        new DoctorDashboard().setVisible(true);
                        break;

                    case "patient":
                        new PatientDashboard().setVisible(true);
                        break;

                    case "receptionist":
                        new ReceptionistDashboard().setVisible(true);
                        break;

                    case "admin":
                        new AdminDashboard().setVisible(true);
                        break;

                    default:
                        JOptionPane.showMessageDialog(null, "Invalid role: " + role);
                        new SignIn().setVisible(true);
                        break;
                }

            } else {
                JOptionPane.showMessageDialog(this, "Invalid username or password");
            }
        }
    }

    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == signUpLabel) {
            new SignUp().setVisible(true);
            dispose();
        }
    }

    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SignIn().setVisible(true));
    }
}
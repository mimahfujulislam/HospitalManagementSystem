import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignUp extends JFrame implements ActionListener, MouseListener {

    private Container c;

    private JPanel leftPanel;
    private JPanel rightPanel;

    private JLabel titleLabel;
    private JLabel title2Label;
    private JLabel subTitleLabel;

    private JLabel registerLabel;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JLabel roleLabel;
    private JLabel imageLabel;

    private JLabel alreadyAccountLabel;
    private JLabel signInLabel;

    private JTextField usernameField;
    private JPasswordField passwordField;

    private JButton signUpButton;

    private JComboBox<String> roleComboBox;

    private ImageIcon imageIcon;

    private Font titleFont;
    private Font subTitleFont;
    private Font labelFont;
    private Font buttonFont;

    public SignUp() {

        super("Hospital Management System");

        setSize(900, 580);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

        setResizable(false);

        c = getContentPane();

        c.setLayout(null);

        c.setBackground(Color.WHITE);

        titleFont = new Font("Segoe UI", Font.BOLD, 34);
        subTitleFont = new Font("Segoe UI", Font.PLAIN, 18);
        labelFont = new Font("Segoe UI", Font.PLAIN, 18);
        buttonFont = new Font("Segoe UI", Font.BOLD, 16);

        leftPanel = new JPanel();

        leftPanel.setBounds(0, 0, 420, 580);

        leftPanel.setLayout(null);

        leftPanel.setBackground(new Color(25, 118, 210));

        c.add(leftPanel);

        titleLabel = new JLabel("Hospital");

        titleLabel.setBounds(105, 150, 250, 50);

        titleLabel.setFont(new Font(
                "Segoe UI",
                Font.BOLD,
                42
        ));

        titleLabel.setForeground(Color.WHITE);

        leftPanel.add(titleLabel);

        title2Label = new JLabel("Management System");

        title2Label.setBounds(35, 200, 350, 50);

        title2Label.setFont(new Font(
                "Segoe UI",
                Font.BOLD,
                34
        ));

        title2Label.setForeground(Color.WHITE);

        leftPanel.add(title2Label);

        subTitleLabel = new JLabel("Create Your Account");

        subTitleLabel.setBounds(110, 260, 220, 30);

        subTitleLabel.setFont(subTitleFont);

        subTitleLabel.setForeground(
                new Color(230, 230, 230)
        );

        leftPanel.add(subTitleLabel);

        imageIcon = new ImageIcon(
                getClass().getResource(
                        "/images/hospital-png-4.png"
                )
        );

        Image scaledImage =
                imageIcon.getImage().getScaledInstance(
                        120,
                        120,
                        Image.SCALE_SMOOTH
                );

        imageLabel = new JLabel(
                new ImageIcon(scaledImage)
        );

        imageLabel.setBounds(145, 320, 120, 120);

        leftPanel.add(imageLabel);

        rightPanel = new JPanel();

        rightPanel.setBounds(420, 0, 480, 580);

        rightPanel.setLayout(null);

        rightPanel.setBackground(Color.WHITE);

        c.add(rightPanel);

        registerLabel = new JLabel("Sign Up");

        registerLabel.setBounds(170, 50, 200, 50);

        registerLabel.setFont(titleFont);

        registerLabel.setForeground(
                new Color(25, 118, 210)
        );

        rightPanel.add(registerLabel);

        usernameLabel = new JLabel("Username");

        usernameLabel.setBounds(70, 130, 120, 30);

        usernameLabel.setFont(labelFont);

        rightPanel.add(usernameLabel);

        usernameField = new JTextField();

        usernameField.setBounds(70, 165, 320, 45);

        usernameField.setFont(labelFont);

        usernameField.setBorder(
                BorderFactory.createLineBorder(
                        new Color(200, 200, 200),
                        2
                )
        );

        rightPanel.add(usernameField);

        passwordLabel = new JLabel("Password");

        passwordLabel.setBounds(70, 230, 120, 30);

        passwordLabel.setFont(labelFont);

        rightPanel.add(passwordLabel);

        passwordField = new JPasswordField();

        passwordField.setBounds(70, 265, 320, 45);

        passwordField.setFont(labelFont);

        passwordField.setBorder(
                BorderFactory.createLineBorder(
                        new Color(200, 200, 200),
                        2
                )
        );

        rightPanel.add(passwordField);

        roleLabel = new JLabel("Select Role");

        roleLabel.setBounds(70, 330, 120, 30);

        roleLabel.setFont(labelFont);

        rightPanel.add(roleLabel);

        String[] roles = {
                "Doctor",
                "Patient",
                "Receptionist",
                "Admin"
        };

        roleComboBox = new JComboBox<>(roles);

        roleComboBox.setBounds(70, 365, 320, 45);

        roleComboBox.setFont(labelFont);

        roleComboBox.setBackground(Color.WHITE);

        roleComboBox.setBorder(
                BorderFactory.createLineBorder(
                        new Color(200, 200, 200),
                        2
                )
        );

        rightPanel.add(roleComboBox);

        signUpButton = new JButton("SIGN UP");

        signUpButton.setBounds(70, 440, 320, 50);

        signUpButton.setFont(buttonFont);

        signUpButton.setForeground(Color.WHITE);

        signUpButton.setBackground(
                new Color(25, 118, 210)
        );

        signUpButton.setFocusPainted(false);

        signUpButton.setBorder(
                BorderFactory.createEmptyBorder()
        );

        signUpButton.setCursor(
                new Cursor(Cursor.HAND_CURSOR)
        );

        signUpButton.addMouseListener(
                new MouseAdapter() {

                    public void mouseEntered(
                            MouseEvent evt
                    ) {

                        signUpButton.setBackground(
                                new Color(13, 71, 161)
                        );
                    }

                    public void mouseExited(
                            MouseEvent evt
                    ) {

                        signUpButton.setBackground(
                                new Color(25, 118, 210)
                        );
                    }
                }
        );

        signUpButton.addActionListener(this);

        rightPanel.add(signUpButton);

        alreadyAccountLabel = new JLabel(
                "Already have an account?"
        );

        alreadyAccountLabel.setBounds(
                125,
                505,
                170,
                25
        );

        alreadyAccountLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        14
                )
        );

        alreadyAccountLabel.setForeground(
                Color.GRAY
        );

        rightPanel.add(alreadyAccountLabel);

        signInLabel = new JLabel("Sign In");

        signInLabel.setBounds(295, 505, 60, 25);

        signInLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        14
                )
        );

        signInLabel.setForeground(
                new Color(25, 118, 210)
        );

        signInLabel.setCursor(
                new Cursor(Cursor.HAND_CURSOR)
        );

        signInLabel.addMouseListener(this);

        rightPanel.add(signInLabel);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == signUpButton) {

            String username =
                    usernameField.getText();

            String password =
                    new String(
                            passwordField.getPassword()
                    );

            String role =
                    (String) roleComboBox
                            .getSelectedItem();

            if (username.equals("")
                    || password.equals("")) {

                JOptionPane.showMessageDialog(
                        null,
                        "Please fill in all fields!"
                );

            } else {

                Account acc = new Account(
                        username,
                        password,
                        role
                );

                if (acc.checkAccount(username)) {

                    JOptionPane.showMessageDialog(
                            this,
                            "Username Already Exists"
                    );

                } else {

                    acc.addAccount();

                    JOptionPane.showMessageDialog(
                            this,
                            "Registration Successful"
                    );

                    SignIn signIn =
                            new SignIn();

                    signIn.setVisible(true);

                    this.setVisible(false);
                }
            }
        }
    }

    public void mouseClicked(MouseEvent e) {

        if (e.getSource() == signInLabel) {

            SignIn signIn = new SignIn();

            signIn.setVisible(true);

            this.setVisible(false);
        }
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(
                new Runnable() {

                    public void run() {

                        SignUp signUp =
                                new SignUp();

                        signUp.setVisible(true);
                    }
                }
        );
    }
}
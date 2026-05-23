package Patient;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AppointmentForm extends JFrame implements ActionListener {

    private PatientDashboard parent;

    private JButton submitButton, backButton;
    private JTextField nameField, ageField;

    public AppointmentForm(PatientDashboard parent) {

        this.parent = parent;

        setTitle("Appointment Form");
        setSize(800, 500);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel title = new JLabel("Book Appointment");
        title.setBounds(250, 30, 300, 40);
        title.setFont(new Font("Segoe UI", Font.BOLD, 24));
        add(title);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(150, 120, 100, 30);
        add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(250, 120, 300, 30);
        add(nameField);

        JLabel ageLabel = new JLabel("Age:");
        ageLabel.setBounds(150, 170, 100, 30);
        add(ageLabel);

        ageField = new JTextField();
        ageField.setBounds(250, 170, 300, 30);
        add(ageField);

        submitButton = new JButton("SUBMIT");
        submitButton.setBounds(250, 250, 140, 40);
        submitButton.addActionListener(this);
        add(submitButton);

        backButton = new JButton("BACK");
        backButton.setBounds(410, 250, 140, 40);

        backButton.addActionListener(e -> {
            parent.setVisible(true);
            dispose();
        });

        add(backButton);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == submitButton) {

            JOptionPane.showMessageDialog(this, "Appointment Saved!");

            nameField.setText("");
            ageField.setText("");
        }
    }
}
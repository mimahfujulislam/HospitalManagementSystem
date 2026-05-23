package Doctor;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Prescription extends JFrame implements ActionListener {
    private JLabel nameLabel, ageLabel, prescriptionLabel;
    private JTextField nameField, ageField;
    private JTextArea prescriptionField;
    private JButton backButton, sendButton;

    public Prescription() {
        setTitle("Prescription");
        setSize(900, 700);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setContentPane(new JLabel(new ImageIcon("images/prescription.png")));
        setLayout(null);

        Font labelFont = new Font("Arial", Font.BOLD, 16);

        nameLabel = new JLabel("Patient's Name:");
        nameLabel.setBounds(50, 50, 200, 30);
        nameLabel.setFont(labelFont);
        add(nameLabel);

        ageLabel = new JLabel("Patient's Age:");
        ageLabel.setBounds(50, 100, 200, 30);
        ageLabel.setFont(labelFont);
        add(ageLabel);

        prescriptionLabel = new JLabel("Prescription for Patient:");
        prescriptionLabel.setBounds(50, 150, 250, 30);
        prescriptionLabel.setFont(labelFont);
        add(prescriptionLabel);

        nameField = new JTextField();
        nameField.setBounds(250, 50, 200, 30);
        add(nameField);

        ageField = new JTextField();
        ageField.setBounds(250, 100, 200, 30);
        add(ageField);

        prescriptionField = new JTextArea();
        prescriptionField.setBounds(50, 200, 400, 400);
        prescriptionField.setLineWrap(true);
        add(prescriptionField);

    
        backButton = new JButton("Back");
        backButton.setBounds(600, 50, 150, 45); 
        backButton.addActionListener(this);
        add(backButton);

        sendButton = new JButton("Send to Patient");
        sendButton.setBounds(600, 100, 150, 45); 
        sendButton.addActionListener(this);
        add(sendButton);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {
            DoctorDashboard doctorDashboard = new DoctorDashboard();
            doctorDashboard.setVisible(true);
            setVisible(false);
        } else if (e.getSource() == sendButton) {
            
            if (nameField.getText().isEmpty() || ageField.getText().isEmpty() || prescriptionField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill all fields before sending.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    FileWriter writer = new FileWriter("prescription.txt");
                    writer.write("Patient's Name: " + nameField.getText() + "\n");
                    writer.write("Patient's Age: " + ageField.getText() + "\n");
                    writer.write("Prescription: " + prescriptionField.getText() + "\n");
                    writer.close();
                    JOptionPane.showMessageDialog(null, "Prescription successfully sent!", "Success", JOptionPane.INFORMATION_MESSAGE);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        new Prescription();
    }
}

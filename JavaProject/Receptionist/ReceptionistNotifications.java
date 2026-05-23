package Receptionist;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReceptionistNotifications extends JFrame {

    public ReceptionistNotifications() {
        super("Receptionist Notifications");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(750, 550);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setBackground(new Color(230, 255, 148));

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(230, 255, 148)); 

        JLabel titleLabel = new JLabel("Notifications");
        titleLabel.setBounds(10, 10, 300, 30);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setForeground(new Color(17, 66, 50)); 
        panel.add(titleLabel);

        JTextArea notificationArea = new JTextArea();
        notificationArea.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        notificationArea.setBounds(10, 50, 730, 400);
        notificationArea.setEditable(false);
        panel.add(notificationArea);

        try {
            BufferedReader reader = new BufferedReader(new FileReader("notification.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                notificationArea.append(line + "\n");
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        JButton backButton = new JButton("Back");
        backButton.setBounds(10, 470, 100, 30);
        backButton.setBackground(new Color(17, 66, 50)); 
        backButton.setForeground(Color.WHITE);
        backButton.setFocusPainted(false);
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ReceptionistDashboard receptionistDashboard = new ReceptionistDashboard();
                receptionistDashboard.setVisible(true);
                setVisible(false);
            }
        });
        panel.add(backButton);
        add(panel);
    }

    public static void main(String[] args) {
        ReceptionistNotifications rn = new ReceptionistNotifications();
        rn.setVisible(true);
    }

}

package Patient;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.*;

public class PrescriptionViewer extends JFrame {

    public PrescriptionViewer(JFrame parent) {

        setTitle("Prescription Viewer");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JPanel background = new JPanel();
        background.setLayout(null);
        background.setBounds(0, 0, 800, 600);
        background.setBackground(new Color(245, 247, 250));
        setContentPane(background);

        JTextArea prescriptionArea = new JTextArea();
        prescriptionArea.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        prescriptionArea.setLineWrap(true);
        prescriptionArea.setWrapStyleWord(true);
        prescriptionArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(prescriptionArea);
        scrollPane.setBounds(50, 80, 700, 400);
        background.add(scrollPane);

        try (BufferedReader br = new BufferedReader(new FileReader("prescription.txt"))) {

            StringBuilder sb = new StringBuilder();
            String line;

            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }

            prescriptionArea.setText(sb.toString());

        } catch (IOException e) {
            prescriptionArea.setText("No prescription found.");
        }

        JButton backButton = new JButton("Back");
        backButton.setBounds(50, 20, 100, 40);
        backButton.setBackground(new Color(33, 150, 243));
        backButton.setForeground(Color.WHITE);
        backButton.setFocusPainted(false);
        backButton.setBorder(BorderFactory.createEmptyBorder());

        backButton.addActionListener(e -> {
            dispose();
            if (parent != null) parent.setVisible(true);
        });

        background.add(backButton);

        setVisible(true);
    }
}
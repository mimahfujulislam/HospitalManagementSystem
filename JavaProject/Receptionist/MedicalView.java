package Receptionist;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class MedicalView extends JFrame {

    private Container c;

    private JPanel leftPanel, rightPanel;

    private JTextArea textArea;

    private JButton backButton;

    private Font titleFont, buttonFont;

    public MedicalView() {

        setTitle("Medical Record View");
        setSize(1000, 600);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        c = getContentPane();
        c.setLayout(null);
        c.setBackground(Color.WHITE);

        titleFont = new Font("Segoe UI", Font.BOLD, 34);
        buttonFont = new Font("Segoe UI", Font.BOLD, 18);

        leftPanel = new JPanel();
        leftPanel.setBounds(0, 0, 400, 600);
        leftPanel.setLayout(null);
        leftPanel.setBackground(new Color(46, 125, 50));
        c.add(leftPanel);

        JLabel title = new JLabel("Medical");
        title.setBounds(110, 200, 250, 50);
        title.setFont(new Font("Segoe UI", Font.BOLD, 38));
        title.setForeground(Color.WHITE);
        leftPanel.add(title);

        JLabel title2 = new JLabel("Records");
        title2.setBounds(120, 250, 250, 50);
        title2.setFont(new Font("Segoe UI", Font.BOLD, 38));
        title2.setForeground(Color.WHITE);
        leftPanel.add(title2);

        JLabel sub = new JLabel("View patient history & reports");
        sub.setBounds(60, 320, 300, 30);
        sub.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        sub.setForeground(new Color(220, 220, 220));
        leftPanel.add(sub);

        rightPanel = new JPanel();
        rightPanel.setBounds(400, 0, 600, 600);
        rightPanel.setLayout(null);
        rightPanel.setBackground(Color.WHITE);
        c.add(rightPanel);

        JLabel header = new JLabel("Medical Records");
        header.setBounds(150, 40, 300, 50);
        header.setFont(titleFont);
        header.setForeground(new Color(46, 125, 50));
        rightPanel.add(header);

        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setBackground(new Color(245, 247, 250));
        textArea.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(50, 120, 500, 350);
        rightPanel.add(scrollPane);

        loadData();

        backButton = new JButton("BACK");
        backButton.setBounds(180, 500, 220, 45);
        backButton.setFont(buttonFont);
        backButton.setForeground(Color.WHITE);
        backButton.setBackground(new Color(33, 150, 243));
        backButton.setFocusPainted(false);
        backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        backButton.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                backButton.setBackground(new Color(25, 118, 210));
            }

            public void mouseExited(MouseEvent e) {
                backButton.setBackground(new Color(33, 150, 243));
            }
        });

        backButton.addActionListener(e -> {
            new ReceptionistDashboard();
            dispose();
        });

        rightPanel.add(backButton);

        setVisible(true);
    }

    private void loadData() {

        try {

            BufferedReader reader =
                    new BufferedReader(
                            new FileReader("medical_record.txt")
                    );

            StringBuilder sb = new StringBuilder();

            String line;

            while ((line = reader.readLine()) != null) {

                sb.append("• ").append(line).append("\n\n");
            }

            textArea.setText(sb.toString());

            reader.close();

        } catch (IOException e) {

            textArea.setText("No medical records found.");
        }
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(MedicalView::new);
    }
}
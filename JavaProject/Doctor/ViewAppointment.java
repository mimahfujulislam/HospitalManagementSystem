package Doctor;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ViewAppointment extends JFrame implements ActionListener {
    private JTextArea textArea;
    private JButton backButton;

    public ViewAppointment() {
        setTitle("View Patient Appointment");
        setSize(800, 600); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(173, 216, 230)); 
        setLayout(new BorderLayout());

        add(new JSeparator(), BorderLayout.NORTH);

        JPanel textPanel = new JPanel(new BorderLayout());
        textPanel.setBackground(new Color(173, 216, 230)); 
        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setFont(new Font("Arial", Font.PLAIN, 16));
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        textPanel.add(scrollPane, BorderLayout.CENTER);
        add(textPanel, BorderLayout.CENTER);

        backButton = new JButton("Back");
        backButton.setPreferredSize(new Dimension(100, 40)); 
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        backButton.setFont(backButton.getFont().deriveFont(Font.BOLD));
        backButton.addActionListener(this);
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonPanel.setBackground(new Color(173, 216, 230)); 
        buttonPanel.add(backButton);
        add(buttonPanel, BorderLayout.NORTH);

        StringBuilder patientData = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader("appointment_info.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                patientData.append(line).append("\n");
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        textArea.setText(patientData.toString());
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {
            DoctorDashboard doctorDashboard = new DoctorDashboard();
            doctorDashboard.setVisible(true);
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ViewAppointment page = new ViewAppointment();
            page.setVisible(true);
        });
    }
}

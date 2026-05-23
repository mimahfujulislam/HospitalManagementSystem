package Patient;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PatientDashboard extends JFrame implements ActionListener {

    private JButton bookBtn, prescriptionBtn, billBtn;

    public PatientDashboard() {

        setTitle("Patient Portal");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        Container c = getContentPane();
        c.setLayout(null);

        JPanel sidebar = new JPanel();
        sidebar.setBounds(0, 0, 280, 600);
        sidebar.setBackground(new Color(20, 33, 61));
        sidebar.setLayout(null);
        c.add(sidebar);

        JLabel logo = new JLabel("Patient Portal");
        logo.setBounds(60, 60, 200, 40);
        logo.setForeground(Color.WHITE);
        logo.setFont(new Font("Segoe UI", Font.BOLD, 20));
        sidebar.add(logo);

        JPanel main = new JPanel();
        main.setBounds(280, 0, 720, 600);
        main.setBackground(new Color(245, 247, 250));
        main.setLayout(null);
        c.add(main);

        JLabel title = new JLabel("Dashboard");
        title.setBounds(40, 40, 300, 40);
        title.setFont(new Font("Segoe UI", Font.BOLD, 28));
        main.add(title);

        bookBtn = createButton("Book Appointment", new Color(33, 150, 243), 40, 140);
        prescriptionBtn = createButton("View Prescription", new Color(76, 175, 80), 40, 240);
        billBtn = createButton("Pay Bill", new Color(255, 152, 0), 40, 340);

        main.add(bookBtn);
        main.add(prescriptionBtn);
        main.add(billBtn);

        bookBtn.setActionCommand("book");
        prescriptionBtn.setActionCommand("prescription");
        billBtn.setActionCommand("bill");

        setVisible(true);
    }

    private JButton createButton(String text, Color color, int x, int y) {

        JButton btn = new JButton(text);
        btn.setBounds(x, y, 350, 70);
        btn.setFont(new Font("Segoe UI", Font.BOLD, 16));
        btn.setForeground(Color.WHITE);
        btn.setBackground(color);
        btn.setFocusPainted(false);
        btn.setBorder(BorderFactory.createEmptyBorder());
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));

        btn.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                btn.setBackground(color.darker());
            }

            public void mouseExited(MouseEvent e) {
                btn.setBackground(color);
            }
        });

        btn.addActionListener(this);

        return btn;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String cmd = e.getActionCommand();

        if (cmd.equals("book")) {

            new AppointmentForm(this);
            setVisible(false);

        } else if (cmd.equals("prescription")) {

            new PrescriptionViewer(this);
            setVisible(false);

        } else if (cmd.equals("bill")) {

            try {
                BufferedReader br = new BufferedReader(new FileReader("total_bill.txt"));
                double bill = Double.parseDouble(br.readLine());
                br.close();

                new PayBill(bill);
                setVisible(false);

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Bill file not found");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(PatientDashboard::new);
    }
}
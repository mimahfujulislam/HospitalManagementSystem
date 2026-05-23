package Admin;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.io.*;
import java.nio.file.*;

public class UserManagement extends JFrame {

    private Container c;
    private JLabel titleLabel;
    private Font titleFont, buttonFont, tableFont;
    private JScrollPane scroll;
    private JTable table;
    private DefaultTableModel model;
    private JButton btnRefresh, btnDelete, btnAdd, btnUpdate, btnBack;
    private Cursor cursor;

    private JPanel topPanel, tablePanel, buttonPanel;

    private String[] column = {"User Name", "Password", "Role"};

    private final String userDataFile =
            "C:\\Users\\kkaif\\Downloads\\JavaProject_Group3\\JavaProject_Group3\\data\\data.txt";

    public UserManagement() {

        setTitle("User Management");
        setSize(900, 650);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        c = getContentPane();
        c.setLayout(null);
        c.setBackground(new Color(240, 244, 248));

        titleFont = new Font("Segoe UI", Font.BOLD, 34);
        buttonFont = new Font("Segoe UI", Font.BOLD, 18);
        tableFont = new Font("Segoe UI", Font.PLAIN, 16);

        cursor = new Cursor(Cursor.HAND_CURSOR);

        topPanel = new JPanel();
        topPanel.setLayout(null);
        topPanel.setBounds(0, 0, 900, 100);
        topPanel.setBackground(new Color(25, 118, 210));
        c.add(topPanel);

        titleLabel = new JLabel("User Management");
        titleLabel.setBounds(270, 20, 400, 50);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(titleFont);
        topPanel.add(titleLabel);

        tablePanel = new JPanel();
        tablePanel.setBounds(70, 120, 740, 320);
        tablePanel.setLayout(new BorderLayout());
        tablePanel.setBackground(Color.WHITE);
        tablePanel.setBorder(BorderFactory.createLineBorder(new Color(220, 220, 220), 2));
        c.add(tablePanel);

        model = new DefaultTableModel();
        model.setColumnIdentifiers(column);

        table = new JTable(model);

        table.setFont(tableFont);
        table.setRowHeight(35);
        table.setSelectionBackground(new Color(144, 202, 249));
        table.setGridColor(new Color(230, 230, 230));
        table.setShowGrid(true);

        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("Segoe UI", Font.BOLD, 17));
        header.setBackground(new Color(33, 150, 243));
        header.setForeground(Color.WHITE);
        header.setPreferredSize(new Dimension(100, 40));

        table.getColumnModel().getColumn(0).setPreferredWidth(200);
        table.getColumnModel().getColumn(1).setPreferredWidth(220);
        table.getColumnModel().getColumn(2).setPreferredWidth(200);

        scroll = new JScrollPane(table);
        scroll.getViewport().setBackground(Color.WHITE);

        tablePanel.add(scroll, BorderLayout.CENTER);

        buttonPanel = new JPanel();
        buttonPanel.setBounds(70, 470, 740, 120);
        buttonPanel.setLayout(new GridLayout(2, 3, 15, 15));
        buttonPanel.setBackground(new Color(240, 244, 248));
        c.add(buttonPanel);

        btnRefresh = createButton("Refresh", new Color(0, 150, 136));
        btnDelete = createButton("Delete", new Color(244, 67, 54));
        btnAdd = createButton("Add User", new Color(76, 175, 80));
        btnUpdate = createButton("Update", new Color(255, 152, 0));
        btnBack = createButton("Back", new Color(63, 81, 181));

        buttonPanel.add(btnRefresh);
        buttonPanel.add(btnDelete);
        buttonPanel.add(btnAdd);
        buttonPanel.add(btnUpdate);
        buttonPanel.add(btnBack);

        buttonPanel.add(new JLabel());

        loadUserData();

        btnRefresh.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                model.setRowCount(0);
                loadUserData();
            }
        });

        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                int selectedRow = table.getSelectedRow();

                if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(null,
                            "Please select a user to delete.");
                    return;
                }

                int confirm = JOptionPane.showConfirmDialog(
                        null,
                        "Are you sure you want to delete this user?",
                        "Confirm Delete",
                        JOptionPane.YES_NO_OPTION
                );

                if (confirm == JOptionPane.YES_OPTION) {

                    model.removeRow(selectedRow);

                    saveAllData();

                    JOptionPane.showMessageDialog(null,
                            "User deleted successfully.");
                }
            }
        });

        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                JTextField usernameField = new JTextField();
                JTextField passwordField = new JTextField();
                JTextField roleField = new JTextField();

                JPanel panel = new JPanel(new GridLayout(0, 1, 10, 10));

                panel.add(new JLabel("Username"));
                panel.add(usernameField);

                panel.add(new JLabel("Password"));
                panel.add(passwordField);

                panel.add(new JLabel("Role"));
                panel.add(roleField);

                int result = JOptionPane.showConfirmDialog(
                        null,
                        panel,
                        "Add New User",
                        JOptionPane.OK_CANCEL_OPTION,
                        JOptionPane.PLAIN_MESSAGE
                );

                if (result == JOptionPane.OK_OPTION) {

                    String username = usernameField.getText();
                    String password = passwordField.getText();
                    String role = roleField.getText();

                    if (username.isEmpty() || password.isEmpty() || role.isEmpty()) {

                        JOptionPane.showMessageDialog(null,
                                "Please fill all fields.");
                        return;
                    }

                    String[] data = {username, password, role};

                    model.addRow(data);

                    saveAllData();

                    JOptionPane.showMessageDialog(null,
                            "New user added successfully.");
                }
            }
        });

        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                int selectedRow = table.getSelectedRow();

                if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(null,
                            "Please select a row to update.");
                    return;
                }

                JTextField usernameField =
                        new JTextField(model.getValueAt(selectedRow, 0).toString());

                JTextField passwordField =
                        new JTextField(model.getValueAt(selectedRow, 1).toString());

                JTextField roleField =
                        new JTextField(model.getValueAt(selectedRow, 2).toString());

                JPanel panel = new JPanel(new GridLayout(0, 1, 10, 10));

                panel.add(new JLabel("Username"));
                panel.add(usernameField);

                panel.add(new JLabel("Password"));
                panel.add(passwordField);

                panel.add(new JLabel("Role"));
                panel.add(roleField);

                int result = JOptionPane.showConfirmDialog(
                        null,
                        panel,
                        "Update User",
                        JOptionPane.OK_CANCEL_OPTION,
                        JOptionPane.PLAIN_MESSAGE
                );

                if (result == JOptionPane.OK_OPTION) {

                    model.setValueAt(usernameField.getText(), selectedRow, 0);
                    model.setValueAt(passwordField.getText(), selectedRow, 1);
                    model.setValueAt(roleField.getText(), selectedRow, 2);

                    saveAllData();

                    JOptionPane.showMessageDialog(null,
                            "User updated successfully.");
                }
            }
        });

        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                AdminDashboard dashboard = new AdminDashboard();
                dashboard.setVisible(true);

                dispose();
            }
        });
    }

    private JButton createButton(String text, Color color) {

        JButton button = new JButton(text);

        button.setFont(buttonFont);
        button.setForeground(Color.WHITE);
        button.setBackground(color);
        button.setFocusPainted(false);
        button.setCursor(cursor);
        button.setBorder(BorderFactory.createEmptyBorder());

        button.addMouseListener(new MouseAdapter() {

            public void mouseEntered(MouseEvent e) {
                button.setBackground(color.darker());
            }

            public void mouseExited(MouseEvent e) {
                button.setBackground(color);
            }
        });

        return button;
    }

    private void loadUserData() {

        try {

            BufferedReader reader =
                    new BufferedReader(new FileReader(userDataFile));

            String line;

            while ((line = reader.readLine()) != null) {

                String[] userData = line.split("\\s+");

                if (userData.length >= 3) {
                    model.addRow(new Object[]{
                            userData[0],
                            userData[1],
                            userData[2]
                    });
                }
            }

            reader.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void saveAllData() {

        try {

            BufferedWriter writer =
                    new BufferedWriter(new FileWriter(userDataFile));

            for (int i = 0; i < model.getRowCount(); i++) {

                writer.write(
                        model.getValueAt(i, 0).toString() + "\t" +
                        model.getValueAt(i, 1).toString() + "\t" +
                        model.getValueAt(i, 2).toString()
                );

                writer.newLine();
            }

            writer.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                new UserManagement().setVisible(true);
            }
        });
    }
}
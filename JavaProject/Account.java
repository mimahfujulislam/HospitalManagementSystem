import java.io.*;
import java.util.*;

public class Account {

    private String user;
    private String pass;
    private String role;

    private File file;
    private FileWriter fwriter;
    private Scanner sc;

    public Account() {

    }

    public Account(String user, String pass, String role) {

        this.user = user;
        this.pass = pass;
        this.role = role;
    }

    public void setUser(String user) {

        this.user = user;
    }

    public void setPass(String pass) {

        this.pass = pass;
    }

    public void setRole(String role) {

        this.role = role;
    }

    public String getUser() {

        return this.user;
    }

    public String getPass() {

        return this.pass;
    }

    public String getRole() {

        return this.role;
    }

    public void addAccount() {

        try {

            file = new File(
                "C:\\Users\\88017\\Downloads\\HospitalMS_Group3\\JavaProject_Group3\\JavaProject_Group3\\data\\data.txt"
            );

            file.createNewFile();

            fwriter = new FileWriter(file, true);

            fwriter.write(getUser() + "\t");

            fwriter.write(getPass() + "\t");

            fwriter.write(getRole() + "\n");

            fwriter.flush();

            fwriter.close();

        } catch (IOException ioe) {

            ioe.printStackTrace();
        }
    }

    public boolean checkAccount(String user) {

        boolean flag = false;

        file = new File(
            "C:\\Users\\88017\\Downloads\\HospitalMS_Group3\\JavaProject_Group3\\JavaProject_Group3\\data\\data.txt"
        );

        try {

            sc = new Scanner(file);

            while (sc.hasNextLine()) {

                String line = sc.nextLine();

                String[] value = line.split("\\s+");

                if (value[0].trim().equals(user.trim())) {

                    flag = true;

                    break;
                }
            }

            sc.close();

        } catch (IOException ioe) {

            ioe.printStackTrace();
        }

        return flag;
    }

    public boolean validAccount(String user, String pass) {

        boolean flag = false;

        file = new File(
            "C:\\Users\\88017\\Downloads\\HospitalMS_Group3\\JavaProject_Group3\\JavaProject_Group3\\data\\data.txt"
        );

        try {

            sc = new Scanner(file);

            while (sc.hasNextLine()) {

                String line = sc.nextLine();

                String[] value = line.split("\\s+");

                if (
                    value[0].trim().equals(user.trim())
                    &&
                    value[1].trim().equals(pass.trim())
                ) {

                    flag = true;

                    break;
                }
            }

            sc.close();

        } catch (IOException ioe) {

            ioe.printStackTrace();
        }

        return flag;
    }

    public String getRole(String name) {

        String role = "";

        file = new File(
            "C:\\Users\\88017\\Downloads\\HospitalMS_Group3\\JavaProject_Group3\\JavaProject_Group3\\data\\data.txt"
        );

        try {

            sc = new Scanner(file);

            while (sc.hasNextLine()) {

                String line = sc.nextLine();

                String[] values = line.split("\\s+");

                if (values[0].trim().equals(name.trim())) {

                    role = values[2].trim();

                    break;
                }
            }

            sc.close();

        } catch (IOException ioe) {

            ioe.printStackTrace();
        }

        return role;
    }
}
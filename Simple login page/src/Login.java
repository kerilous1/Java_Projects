import java.awt.*;
import javax.swing.*;
import java.awt.event.*; 

public class Login {
    public static void main(String[] args) {
        //framecreate
        JFrame frame = new JFrame("Login page");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        
        //Panelcreate
        JPanel panel = new JPanel();
        panel.setLayout(null);
        frame.add(panel);
        
        //userName
        JLabel userName = new JLabel("User Name :");
        userName.setBounds(80, 80, 80, 25);
        panel.add(userName);
        
        JTextField userField = new JTextField();
        userField.setBounds(165, 80, 200, 25);
        panel.add(userField);
        
        //Password
        JLabel password = new JLabel("PassWord :");
        password.setBounds(80, 120, 80, 25);
        panel.add(password);
        
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(165, 120, 200, 25);
        panel.add(passwordField);
        //genderbutton
        JLabel genderLabel = new JLabel("Gender :");
        genderLabel.setBounds(80, 160, 80, 25);
        panel.add(genderLabel);
        
        JRadioButton maleRadio = new JRadioButton("Male");
        maleRadio.setBounds(165, 160, 70, 25);
        
        JRadioButton femaleRadio = new JRadioButton("Female");
        femaleRadio.setBounds(240, 160, 80, 25);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleRadio);
        genderGroup.add(femaleRadio);
        maleRadio.setSelected(true);
        panel.add(maleRadio);
        panel.add(femaleRadio);
        //countrybutton
        JLabel countryLabel = new JLabel("Country :");
        countryLabel.setBounds(80, 200, 80, 25);
        panel.add(countryLabel);

        String[] countries = {"Egypt","UK","USA", "Other"};
        JComboBox<String> countryBox = new JComboBox<>(countries);
        countryBox.setBounds(165, 200, 200, 25);
        panel.add(countryBox);
        //Login Button 
        JButton login = new JButton("Login");
        login.setBounds(200, 260, 100, 40);
        panel.add(login);
        //Message Label
        JLabel messageLogin = new JLabel("");
        messageLogin.setBounds(100, 320, 350, 40);
        messageLogin.setFont(new Font("Arial", Font.BOLD, 14));
        panel.add(messageLogin);
        
        //Login check
        login.addActionListener(new ActionListener() {
            @Override 
            public void actionPerformed(ActionEvent e) {
                String userenter = userField.getText();
                String userPass = new String(passwordField.getPassword());
                String selectedCountry = (String) countryBox.getSelectedItem();
                String selectedGender = maleRadio.isSelected() ? "Male" : "Female";

                if (userenter.equals("mmm") && userPass.equals("111")) 
                {
                    panel.setBackground(Color.GREEN);
                    messageLogin.setText("Success! Welcome " + userenter + " (" + selectedGender + " from " + selectedCountry + ")");
                } 
                else 
                {
                    panel.setBackground(Color.RED);
                    messageLogin.setText("Wrong user name or password ! ");
                }
            }
        });
        
        frame.setVisible(true);
    }
}
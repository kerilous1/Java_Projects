import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PracticalExame extends JFrame implements ActionListener {
	
	JPanel panal;
	JLabel titleLabel, nameLabel, emailLabel, ageLabel, genderLabel, passwordLabel, confirmPasswordLabel;
	JTextField nameField, emailField, ageField;
	JPasswordField passField, confirmPassField;
	JButton registerButton;
	JRadioButton male, female;
	ButtonGroup genderGroup;
	
	public PracticalExame() {
		
		//frame seting
		this.setTitle("Registration Form");
		this.setSize(500, 600);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//set color
		Color bgColor = new Color(240, 248, 255);
		Color primaryColor = new Color(0, 102, 204);
		Font titleFont = new Font("Segoe UI", Font.BOLD, 22);
		Font labelFont = new Font("Segoe UI", Font.BOLD, 14);
		Font inputFont = new Font("Segoe UI", Font.PLAIN, 14);
		
		// Panel
		panal = new JPanel();
		this.add(panal);
		panal.setBackground(bgColor);
		panal.setLayout(null);
		
		// Title Label
		titleLabel = new JLabel("Create New Account");
		titleLabel.setFont(titleFont);
		titleLabel.setForeground(primaryColor);
		titleLabel.setBounds(140, 25, 250, 40);
		panal.add(titleLabel);
		
		// Labels
		//user name
		nameLabel = new JLabel("Username:");
		nameLabel.setFont(labelFont);
		nameLabel.setBounds(40, 90, 80, 30);
		panal.add(nameLabel);
		
		nameField = new JTextField();
		nameField.setFont(inputFont);
		nameField.setBounds(180, 90, 250, 35);
		panal.add(nameField);
		
		//email
		emailLabel = new JLabel("Email:");
		emailLabel.setFont(labelFont);
		emailLabel.setBounds(40, 140, 80, 30);
		panal.add(emailLabel);
		
		emailField = new JTextField();
		emailField.setFont(inputFont);
		emailField.setBounds(180, 140, 250, 35);
		panal.add(emailField);

		//age
		ageLabel = new JLabel("Age:");
		ageLabel.setFont(labelFont);
		panal.add(ageLabel);
		ageLabel.setBounds(40, 190, 80, 30);
		
		ageField = new JTextField();
		ageField.setFont(inputFont);
		panal.add(ageField);
		ageField.setBounds(180, 190, 250, 35);
		
		//gender
		genderLabel = new JLabel("Gender :");
		genderLabel.setBounds(40, 240, 80, 30);
		genderLabel.setFont(labelFont);
		panal.add(genderLabel);
		
		//male radio
		male = new JRadioButton("Male");
		male.setBounds(180, 240, 100, 30);
		male.setFont(labelFont);
		male.setBackground(bgColor);
		panal.add(male);
		
		//female radio
		female = new JRadioButton("Female");
		female.setBounds(280, 240, 130, 30);
		female.setFont(labelFont);
		female.setBackground(bgColor);
		panal.add(female);
		
		//gender group
		genderGroup = new ButtonGroup();
		genderGroup.add(male);
		genderGroup.add(female);
		male.setSelected(true);
		
		//password
		passwordLabel = new JLabel("Password :");
		passwordLabel.setBounds(40, 290, 130, 30);
		passwordLabel.setFont(labelFont);
		panal.add(passwordLabel);
		
		passField = new JPasswordField();
		passField.setBounds(180, 290, 250, 35);
		passField.setFont(inputFont);
		panal.add(passField);
		
		//password confirm
		confirmPasswordLabel = new JLabel("Confirm Password :");
		confirmPasswordLabel.setBounds(40, 340, 140, 30);
		confirmPasswordLabel.setFont(labelFont);
		panal.add(confirmPasswordLabel);
		
		confirmPassField = new JPasswordField();
		confirmPassField.setBounds(180, 340, 250, 35);
		confirmPassField.setFont(inputFont);
		panal.add(confirmPassField);
		
		// Buttons
		registerButton = new JButton("Register");
		registerButton.setBounds(175, 420, 150, 40);
		registerButton.setFont(labelFont);
		registerButton.setBackground(primaryColor);
		registerButton.setForeground(Color.WHITE);
		registerButton.addActionListener(this);
		panal.add(registerButton);
		
		// frame seting
		this.getRootPane().setDefaultButton(registerButton);
		this.setVisible(true);
	}

	public static void main(String[] args) 
	{
		new PracticalExame();
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == registerButton) 
		{
			String name = nameField.getText();
			String email = emailField.getText();
			String age = ageField.getText();
			String password = new String(passField.getPassword());
			String conPassword = new String(confirmPassField.getPassword());
			
     //check inputs
			//check if all field are filled
			if(name.isEmpty()||email.isEmpty()||age.isEmpty()||password.isEmpty()||conPassword.isEmpty()) 
			{
				JOptionPane.showMessageDialog(this,"Please fill all the information!!","Error",JOptionPane.ERROR_MESSAGE);
				return;
			}
			
		//check if username contains numbers
			// (.*\\d.*) this check the user name are include a numper or no
			if(name.matches(".*\\d.*")) {
				JOptionPane.showMessageDialog(this,"Username must not contain numbers!","Invalid Input",JOptionPane.WARNING_MESSAGE);
				return;
			}
			
		// check email format
			if(!email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$")) 
			{
				JOptionPane.showMessageDialog(this, "Please enter a valid email address (e.g., name@domain.com)!", "Invalid Email", JOptionPane.WARNING_MESSAGE);
				return;
			}
			
		//if user didnt enter age in numbers
			try 
			{
				Integer.parseInt(age);
			} 
			catch (NumberFormatException ex) 
			{
				JOptionPane.showMessageDialog(this,"Age must be a valid number !!","Invalid Input", JOptionPane.WARNING_MESSAGE);
				return;
			}
			
		//check password & confirme
			if(!password.equals(conPassword)) {
				JOptionPane.showMessageDialog(this,"Passwords do not match !!","Error",JOptionPane.ERROR_MESSAGE);
				return;
			}
			
		//all thing is well
			String gender=male.isSelected()?"Male":"Female";
			JOptionPane.showMessageDialog(this,"Welcome "+name+"\nYour Registration has been confirmed.\nEmail: "+email+"\nGender: "+gender,"Success",JOptionPane.INFORMATION_MESSAGE);
			
		}
	}
}
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Quize 
{
	public static void main(String[] args) 
	{
		//Creat Frame
		JFrame frame=new JFrame("Log in pag ");
		frame.setSize(500,400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//creatPanal
		JPanel panal=new JPanel();
		panal.setLayout(null);
		frame.add(panal);
		//creatusername
		JLabel username=new JLabel("UserName :");
		username.setBounds(80,100,80,30);
		panal.add(username);
		JTextField userfield=new JTextField();
		userfield.setBounds(160,100,200,30);
		panal.add(userfield);
		//creatuserpassword
		JLabel password=new JLabel("Password :");
		password.setBounds(80,150,80,30);
		panal.add(password);
		JPasswordField passwordfield=new JPasswordField();
		passwordfield.setBounds(160,150,200,30);
		panal.add(passwordfield);
		//massege login
		JLabel massage=new JLabel("");
		massage.setBounds(150,250,250,40);
		panal.add(massage);
		//Login button
		JButton login=new JButton("Login");
		login.setBounds(200,200,100,40);
		panal.add(login);
		login.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				String userinfo=userfield.getText();
				String userpass=new String(passwordfield.getPassword());
				if(userinfo.equals("mmm")&&userpass.equals("11"))
				{
					panal.setBackground(Color.GREEN);
					massage.setText("Login sucsessful welcom");
				}
				else
				{
					panal.setBackground(Color.RED);
					massage.setText("WRong password or username!.");
				}
			}
		});
	frame.setVisible(true);
	}
}

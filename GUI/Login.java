package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.ImageIcon;
import java.io.*;
import java.util.*;

public class Login extends JFrame implements ActionListener{
	
	Font titleFont = new Font("Tahoma",Font.PLAIN,25);
	Font labelFont = new Font("Tahoma",Font.BOLD,16);
	Font textFieldFont = new Font("Tahoma",Font.BOLD,12);
	
	JLabel usernameLabel,passwordLabel,loggininasLabel;
	JTextField usernameTextField,passwordTextField;
	JButton loginButton,cancelButton,signupButton;
	Choice loggininasChoice;
	
	public Login(){
		super("Login Page");
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);
		super.setSize(1100,600);
		super.setLocation(110,130);
		super.getContentPane().setBackground(Color.WHITE);
		super.setLayout(null);
		
		JLabel title = new JLabel("Login to Your Electricity Dashboard!");
		title.setBounds(20,70,600,30);
		title.setFont(titleFont);
		this.add(title);
		//
		usernameLabel = new JLabel("Username");
		usernameLabel.setBounds(50, 150, 100, 20);
		usernameLabel.setFont(labelFont);
		this.add(usernameLabel);
		
		usernameTextField	= new JTextField();
		usernameTextField.setBounds(180, 150, 150, 20);
		usernameTextField.setFont(textFieldFont);
		this.add(usernameTextField);
		//
		passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(50, 210, 100, 20);
		passwordLabel.setFont(labelFont);
		this.add(passwordLabel);
		
		passwordTextField	= new JTextField();
		passwordTextField.setBounds(180, 210, 150, 20);
		passwordTextField.setFont(textFieldFont);
		this.add(passwordTextField);
		//
		loggininasLabel = new JLabel("Loggin in as");
		loggininasLabel.setBounds(50, 270, 100, 20);
		loggininasLabel.setFont(labelFont);
		this.add(loggininasLabel);
		
		loggininasChoice = new Choice();
		loggininasChoice.add("Admin");
        loggininasChoice.add("Customer");
		loggininasChoice.setBounds(180, 270, 150, 20);
		loggininasChoice.setFont(textFieldFont);
		this.add(loggininasChoice);
		//
		ImageIcon loginIcon = new ImageIcon(ClassLoader.getSystemResource("icon/login.png"));
		Image resizelogin = loginIcon.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
		loginButton = new JButton("Login",new ImageIcon(resizelogin));
		loginButton.setBounds(80, 330, 100, 20);
		loginButton.setFont(labelFont);
		loginButton.addActionListener(this);
		this.add(loginButton);
		//
		ImageIcon cancelIcon = new ImageIcon(ClassLoader.getSystemResource("icon/cancel.jpg"));
		Image resizecancel = cancelIcon.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
		cancelButton = new JButton("Cancel",new ImageIcon(resizecancel));
		cancelButton.setBounds(200, 330, 112, 20);
		cancelButton.setFont(labelFont);
		cancelButton.addActionListener(this);
		this.add(cancelButton);
		//
		ImageIcon signupIcon = new ImageIcon(ClassLoader.getSystemResource("icon/signup.png"));
		Image resizesignup = signupIcon.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
		signupButton = new JButton("Signup",new ImageIcon(resizesignup));
		signupButton.setBounds(130, 370, 112, 20);
		signupButton.setFont(labelFont);
		signupButton.addActionListener(this);
		this.add(signupButton);

		ImageIcon sideImage = new ImageIcon(ClassLoader.getSystemResource("icon/ezgif-1-fb9eadea8d.gif"));
		Image resizesideImage = sideImage.getImage().getScaledInstance(550, 550, Image.SCALE_DEFAULT);
		ImageIcon i = new ImageIcon(resizesideImage);
        JLabel image = new JLabel(i);
        image.setBounds(150, -5, 1280, 550);
        this.add(image);

		this.setVisible(true);
	}
	public void actionPerformed(ActionEvent ae){
		
		if(loginButton == ae.getSource()){
			System.out.println("Login Button Clicked");
			String acctype = loggininasChoice.getSelectedItem();
			String username = usernameTextField.getText();
			String password = passwordTextField.getText();
			
			if(username.isEmpty() || password.isEmpty()){
				ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/alert.gif"));
				Image i2 = i1.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
				ImageIcon i3 = new ImageIcon(i2);
				JOptionPane.showMessageDialog(null, "Please fill all of the fields.", "Warning!",JOptionPane.WARNING_MESSAGE,i3);
			}
			else{
				if (username.equals("admin") && password.equals("admin") && acctype.equals("Admin")) {
					ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icon/password.gif"));
					Image i5 = i4.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
					ImageIcon i6 = new ImageIcon(i5);
					JOptionPane.showMessageDialog(null, "Login Successful", "Notification", JOptionPane.INFORMATION_MESSAGE,i6);
					this.setVisible(false);
					new Homepage(acctype);
					return;
				}
				else if (username.equals("nishy") && password.equals("1234") && acctype.equals("Admin")) {
					ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icon/password.gif"));
					Image i5 = i4.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
					ImageIcon i6 = new ImageIcon(i5);
					JOptionPane.showMessageDialog(null, "Login Successful", "Notification", JOptionPane.INFORMATION_MESSAGE,i6);
					this.setVisible(false);
					new Homepage(acctype);
					return;
				}

				try {
					FileReader fileReader = new FileReader("signup page info.txt");
					BufferedReader bufferedReader = new BufferedReader(fileReader);
					String line;
					boolean isValidUser = false;

					while((line=bufferedReader.readLine()) != null){
						String[] userDetails = line.trim().split(",");
						if (userDetails.length > 4 && userDetails[0].equals(acctype) && userDetails[2].equals(username) && userDetails[4].equals(password)) {
							isValidUser = true;
							break;
						}
					}
					fileReader.close();
					bufferedReader.close();

					if (isValidUser){
						ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icon/password.gif"));
						Image i5 = i4.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
						ImageIcon i6 = new ImageIcon(i5);
						JOptionPane.showMessageDialog(null, "Login Successful", "Notification", JOptionPane.INFORMATION_MESSAGE,i6);
						this.setVisible(false);
						new Homepage(acctype);
					}
					else {
						ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icon/alert.gif"));
						Image i5 = i4.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
						ImageIcon i6 = new ImageIcon(i5);
						JOptionPane.showMessageDialog(null, "Invalid Username or Password", "Error", JOptionPane.ERROR_MESSAGE,i6);
						usernameTextField.setText("");
						passwordTextField.setText("");
					}

				} catch (Exception e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "An error occurred while reading the file.", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		else if(cancelButton == ae.getSource()){
			System.out.println("Cancel Button Clicked");
			this.setVisible(false);
			System.exit(0);
		}
		else if(signupButton == ae.getSource()){
			System.out.println("Signup Button Clicked");
			this.setVisible(false);
			new Signup();
		}
	}
}
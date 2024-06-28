package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.util.*;
import java.io.FileWriter;

public class Signup extends JFrame implements ActionListener{
	
	Font titleFont = new Font("Tahoma",Font.PLAIN,25);
	Font labelFont = new Font("Tahoma",Font.BOLD,15);
	Font textFieldFont = new Font("Tahoma",Font.BOLD,12);
	
	JLabel title,createaccountasLabel,meternumLabel,usernameLabel,nameLabel,passwordLabel,meterNumber;
	JTextField usernameTextField,nameTextField,passwordTextField;
	JButton createButton,backButton;
	Choice createaccountasChoice;
	
	public Signup(){
		super("Signup Page");
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);
		super.setSize(1100,600);
		super.setLocation(110,130);
		super.getContentPane().setBackground(Color.WHITE);
		super.setLayout(null);
		
		title = new JLabel("Illuminate Your Billing Experience: Sign Up Today!");
		title.setBounds(27,55,600,30);
		title.setFont(titleFont);
		this.add(title);
		
		createaccountasLabel = new JLabel("Create Account As");
		createaccountasLabel.setBounds(100, 150, 165, 20);
		createaccountasLabel.setFont(labelFont);
		this.add(createaccountasLabel);
		
		createaccountasChoice = new Choice();
		createaccountasChoice.add("Admin");
        createaccountasChoice.add("Customer");
		createaccountasChoice.setBounds(270, 150, 150, 20);
		createaccountasChoice.setFont(textFieldFont);
		this.add(createaccountasChoice);
		
		meternumLabel = new JLabel("Meter Number");
		meternumLabel.setBounds(100, 210, 140, 20);
		meternumLabel.setFont(labelFont);
		this.add(meternumLabel);
		
		meterNumber = new JLabel();
		meterNumber.setBounds(270, 210, 150, 20);
		meterNumber.setFont(textFieldFont);
		this.add(meterNumber);
		Random random = new Random();
        long num = random.nextLong() % 100000;
        meterNumber.setText("" + Math.abs(num));
		
		usernameLabel = new JLabel("Username");
		usernameLabel.setBounds(100, 270, 140, 20);
		usernameLabel.setFont(labelFont);
		this.add(usernameLabel);
		
		usernameTextField = new JTextField();
		usernameTextField.setBounds(270, 270, 150, 20);
		usernameTextField.setFont(textFieldFont);
		this.add(usernameTextField);
		
		nameLabel = new JLabel("Name");
		nameLabel.setBounds(100, 330, 140, 20);
		nameLabel.setFont(labelFont);
		this.add(nameLabel);
		
		nameTextField = new JTextField();
		nameTextField.setBounds(270, 330, 150, 20);
		nameTextField.setFont(textFieldFont);
		this.add(nameTextField);
		
		passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(100, 390, 140, 20);
		passwordLabel.setFont(labelFont);
		this.add(passwordLabel);
		
		passwordTextField	= new JTextField();
		passwordTextField.setBounds(270, 390, 150, 20);
		passwordTextField.setFont(textFieldFont);
		this.add(passwordTextField);
		
		createButton = new JButton("Create");
		createButton.setBounds(120, 480, 120, 25);
		createButton.setBackground(Color.BLACK);
		createButton.setForeground(Color.WHITE);
		createButton.setFont(textFieldFont);
		createButton.addActionListener(this);
		this.add(createButton);
		
		backButton = new JButton("Back");
		backButton.setBounds(280, 480, 120, 25);
		backButton.setBackground(Color.BLACK);
		backButton.setForeground(Color.WHITE);
		backButton.setFont(textFieldFont);
		backButton.addActionListener(this);
		this.add(backButton);
		
		ImageIcon sideImage = new ImageIcon("icon/ezgif-1-1eeb6d8b41.gif");
		Image resizesideImage = sideImage.getImage().getScaledInstance(550, 550, Image.SCALE_DEFAULT);
		ImageIcon i = new ImageIcon(resizesideImage);
        JLabel image = new JLabel(i);
        image.setBounds(150, -5, 1280, 550);
        this.add(image);
		
		this.setVisible(true);

	}
	public void actionPerformed(ActionEvent ae){
		
		if(createButton == ae.getSource()){
			System.out.println("Create Button Clicked");
			String n1 = createaccountasChoice.getSelectedItem();
            String n2 = meterNumber.getText();
			String n3 = usernameTextField.getText();
			String n4 = nameTextField.getText();
			String n5 = passwordTextField.getText();
			
			if(n1.isEmpty() || n2.isEmpty() || n3.isEmpty() || n4.isEmpty() || n5.isEmpty()){
				ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icon/alert.gif"));
				Image i5 = i4.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
				ImageIcon i6 = new ImageIcon(i5);
				JOptionPane.showMessageDialog(null, "Please fill all of the fields.", "Warning!", JOptionPane.ERROR_MESSAGE,i6);	
			}
			else{
				String accounttype = createaccountasChoice.getSelectedItem();
				String meternum = meterNumber.getText();
				String username = usernameTextField.getText();
				String name = nameTextField.getText();
				String password = passwordTextField.getText();
			
				try{
					FileWriter writer = new FileWriter("signup page info.txt",true);
					writer.write(accounttype+","+meternum+","+username+","+name+","+password);
					writer.write(System.getProperty("line.separator"));
					writer.close();
					ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icon/verified.gif"));
					Image i5 = i4.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
					ImageIcon i6 = new ImageIcon(i5);
					JOptionPane.showMessageDialog(null, "Account Created Successfully","Notification", JOptionPane.INFORMATION_MESSAGE,i6);
					this.setVisible(false);
					new Login();
				}catch(Exception e){
					JOptionPane.showMessageDialog(null,"Invalid User Name or Password","Warning!",JOptionPane.ERROR_MESSAGE);
				}
				this.setVisible(false);
				//new Login();
			}
		}
		else if(backButton == ae.getSource()){
			System.out.println("Back Button Clicked");
			this.setVisible(false);
			new Login();
		}
	}
}
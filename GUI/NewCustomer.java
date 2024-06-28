package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.util.*;
import java.io.FileWriter;

public class NewCustomer extends JFrame implements ActionListener{
	
	Font titleFont = new Font("Tahoma",Font.PLAIN,24);
	Font labelFont = new Font("Tahoma",Font.BOLD,14);
	Font textFildFont = new Font("Tahoma",Font.BOLD,12);
	
	JLabel title,customerNameLabel,meterNumberLabel,meterNumber,addressLabel,cityLabel,stateLabel,emailLabel,phoneNumberLabel;
	JTextField customerNameTextField,addressTextField,cityTextField,stateTextField,emailTextField,phoneNumberTextField;
	JButton nextButton,cancelButton;
	
	public NewCustomer(){
		super("Please Fill-up Customer Details");
		super.setSize(1100,500);
		super.setLocation(200,100);
		super.getContentPane().setBackground(new Color(173,216,230));
		super.setLayout(null);
		
		title = new JLabel("Add New Customer");
		title.setBounds(180,15,220,25);
		title.setFont(titleFont);
		this.add(title);
		
		ImageIcon sideImage = new ImageIcon(ClassLoader.getSystemResource("icon/ezgif-5-99d32b508e.gif"));
		Image resizesideImage = sideImage.getImage().getScaledInstance(500, 500, Image.SCALE_DEFAULT);
		ImageIcon i = new ImageIcon(resizesideImage);
        JLabel image = new JLabel(i);
        image.setBounds(200, -5, 1280, 500);
        this.add(image);
		
		JPanel panel = new JPanel();
		panel.setBounds(0,0,1100,500);
		panel.setBackground(new Color(102, 153, 153));
		this.add(panel);
		panel.setLayout(null);
		//
		customerNameLabel = new JLabel("Customer Name");
		customerNameLabel.setBounds(100, 80, 120, 20);
		customerNameLabel.setFont(labelFont);
		panel.add(customerNameLabel);
		
		meterNumberLabel = new JLabel("Meter Number");
		meterNumberLabel.setBounds(100, 120, 100, 20);
		meterNumberLabel.setFont(labelFont);
		panel.add(meterNumberLabel);
		
		meterNumber = new JLabel();
		meterNumber.setBounds(260, 120, 100, 20);
		meterNumber.setFont(textFildFont);
		panel.add(meterNumber);
		Random random = new Random();
        long num = random.nextLong() % 100000;
        meterNumber.setText("" + Math.abs(num));
		
		
		addressLabel = new JLabel("Address");
		addressLabel.setBounds(100, 160, 100, 20);
		addressLabel.setFont(labelFont);
		panel.add(addressLabel);
		
		cityLabel = new JLabel("City");
		cityLabel.setBounds(100, 200, 100, 20);
		cityLabel.setFont(labelFont);
		panel.add(cityLabel);
		
		stateLabel = new JLabel("State");
		stateLabel.setBounds(100, 240, 100, 20);
		stateLabel.setFont(labelFont);
		panel.add(stateLabel);
		
		emailLabel = new JLabel("Email");
		emailLabel.setBounds(100, 280, 100, 20);
		emailLabel.setFont(labelFont);
		panel.add(emailLabel);
		
		phoneNumberLabel = new JLabel("Phone Number");
		phoneNumberLabel.setBounds(100, 320, 110, 30);
		phoneNumberLabel.setFont(labelFont);
		panel.add(phoneNumberLabel);
		//
		customerNameTextField = new JTextField();
		customerNameTextField.setBounds(260, 80, 200, 20);
		customerNameTextField.setFont(textFildFont);
		panel.add(customerNameTextField);
		
		addressTextField = new JTextField();
		addressTextField.setBounds(260, 160, 200, 20);
		addressTextField.setFont(textFildFont);
		panel.add(addressTextField);
		
		cityTextField = new JTextField();
		cityTextField.setBounds(260, 200, 200, 20);
		cityTextField.setFont(textFildFont);
		panel.add(cityTextField);
		
		stateTextField = new JTextField();
		stateTextField.setBounds(260, 240, 200, 20);
		stateTextField.setFont(textFildFont);
		panel.add(stateTextField);
		
		emailTextField = new JTextField();
		emailTextField.setBounds(260, 280, 200, 20);
		emailTextField.setFont(textFildFont);
		panel.add(emailTextField);
		
		phoneNumberTextField = new JTextField();
		phoneNumberTextField.setBounds(260, 320, 200, 20);
		phoneNumberTextField.setFont(textFildFont);
		panel.add(phoneNumberTextField);
		//
		nextButton = new JButton("Next");
        nextButton.setBounds(160, 380, 85,25);
		nextButton.setFont(labelFont);
        nextButton.setBackground(Color.BLACK);
        nextButton.setForeground(Color.WHITE);
        nextButton.addActionListener(this);
        panel.add(nextButton);
		
		cancelButton = new JButton("Cancel");
        cancelButton.setBounds(270, 380, 85,25);
		cancelButton.setFont(labelFont);
        cancelButton.setBackground(Color.BLACK);
        cancelButton.setForeground(Color.WHITE);
        cancelButton.addActionListener(this);
        panel.add(cancelButton);
		
		//ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/hicon1.jpg"));
		//Image resizeImage = i1.getImage().getScaledInstance(150, 300, Image.SCALE_DEFAULT);
		//ImageIcon i2 = new ImageIcon(resizeImage);
        //JLabel image = new JLabel(i2);
        //image.setBounds(1, 1, 700, 500);
        //this.add(image);
		
		
		this.setVisible(true);
	}
	public void actionPerformed(ActionEvent ae){
		if(nextButton == ae.getSource()){
			String customerName = customerNameTextField.getText();
            String meterNum = meterNumber.getText();
            String address = addressTextField.getText();
            String city = cityTextField.getText();
            String state = stateTextField.getText();
            String email = emailTextField.getText();
            String phoneNumber = phoneNumberTextField.getText();
			
			if(customerName.isEmpty() || address.isEmpty() || city.isEmpty() || state.isEmpty() || email.isEmpty() || phoneNumber.isEmpty()){
				ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icon/alert.gif"));
				Image i5 = i4.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
				ImageIcon i6 = new ImageIcon(i5);
				JOptionPane.showMessageDialog(null, "Please fill all of the fields.", "Warning!", JOptionPane.ERROR_MESSAGE,i6);			
			}
			else{

				try{
					FileWriter writer = new FileWriter("New Customer Info.txt",true);
					writer.write(customerName+","+meterNum+","+address+","+city+","+state+","+email+","+phoneNumber);
					writer.write(System.getProperty("line.separator"));
					writer.close();
					ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icon/verified.gif"));
					Image i5 = i4.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
					ImageIcon i6 = new ImageIcon(i5);
					JOptionPane.showMessageDialog(null, "Customer Details Add Successfully","Notification", JOptionPane.INFORMATION_MESSAGE,i6);
					this.setVisible(false);
					new MeterInfo(meterNum);
					//new ViewInfo(meterNum);
				}catch(Exception e){
					JOptionPane.showMessageDialog(null,"Invalid User Name or Password","Warning!",JOptionPane.ERROR_MESSAGE);
				}
				this.setVisible(false);
				//new Login();
			}
		}
		else if(cancelButton == ae.getSource()){
			this.setVisible(false);
			//new Homepage("Admin");
		}
	}
	
}
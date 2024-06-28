package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.ImageIcon;
import java.sql.*;
import java.io.*;
import java.util.*;
public class UpdateInfo extends JFrame implements ActionListener{
	
	Font titleFont = new Font("Tahoma",Font.PLAIN,24);
	Font labelFont = new Font("Tahoma",Font.BOLD,14);
	Font textFildFont = new Font("Tahoma",Font.BOLD,12);
	
	JLabel title,nameLabel,ansNameLabel,meternumberLabel,addressLabel,cityLabel,stateLabel,emailLabel,phoneNumberLabel;
	JTextField addressTextField,cityTextField,stateTextField,emailTextField,phoneNumberTextField; 
	Choice nameChoice,meternumberChoice;
	JButton updateButton,cancelButton,searchButton; 
	
	public UpdateInfo(){
		super("Update Your Information");
		super.setBounds(300,150,1050,450);
		super.getContentPane().setBackground(Color.WHITE);
		super.setLayout(null);
		//
		title = new JLabel("UPDATE CUSTOMER INFORMATION");
		title.setBounds(110,10,400,30);
		title.setFont(titleFont);
		this.add(title);
		//
		nameLabel = new JLabel("Name");
        nameLabel.setBounds(30, 70, 100, 20);
		nameLabel.setFont(labelFont);
        this.add(nameLabel);
		
		ansNameLabel = new JLabel("");
        ansNameLabel.setBounds(230, 70, 150, 20);
		ansNameLabel.setFont(textFildFont);
		ansNameLabel.setEnabled(false);
        this.add(ansNameLabel);
        //
        JLabel lblmeternumber = new JLabel("Meter Number");
        lblmeternumber.setBounds(30, 110, 100, 20);
		lblmeternumber.setFont(labelFont);
        this.add(lblmeternumber);
        
        meternumberChoice = new Choice();
		try{
			BufferedReader reader = new BufferedReader(new FileReader("New Customer Info.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.trim().split(",");
                if (parts.length >= 2) {
                    String meterNumber = parts[1];
                    meternumberChoice.add(meterNumber);
                }
            }
            reader.close();
		}catch(Exception e){
			e.printStackTrace();
		}
        meternumberChoice.setBounds(230, 110, 200, 20);
		meternumberChoice.setFont(textFildFont);
        this.add(meternumberChoice);
		//
		addressLabel = new JLabel("Address");
		addressLabel.setBounds(30, 150, 100, 20);
		addressLabel.setFont(labelFont);
		this.add(addressLabel);
		
		addressTextField = new JTextField();
		addressTextField.setBounds(230, 150, 200, 20);
		addressTextField.setFont(textFildFont);
		this.add(addressTextField);
		//
		cityLabel = new JLabel("City");
		cityLabel.setBounds(30, 190, 100, 20);
		cityLabel.setFont(labelFont);
		this.add(cityLabel);

		cityTextField = new JTextField();
		cityTextField.setBounds(230, 190, 200, 20);
		cityTextField.setFont(textFildFont);
		this.add(cityTextField);
		//
		stateLabel = new JLabel("State");
		stateLabel.setBounds(30, 230, 100, 20);
		stateLabel.setFont(labelFont);
		this.add(stateLabel);
		
		stateTextField = new JTextField();
		stateTextField.setBounds(230, 230, 200, 20);
		stateTextField.setFont(textFildFont);
		this.add(stateTextField);
		//
		emailLabel = new JLabel("Email");
		emailLabel.setBounds(30, 270, 100, 20);
		emailLabel.setFont(labelFont);
		this.add(emailLabel);
		
		emailTextField = new JTextField();
		emailTextField.setBounds(230, 270, 200, 20);
		emailTextField.setFont(textFildFont);
		this.add(emailTextField);
		//
		phoneNumberLabel = new JLabel("Phone Number");
		phoneNumberLabel.setBounds(30, 310, 130, 20);
		phoneNumberLabel.setFont(labelFont);
		this.add(phoneNumberLabel);
		
		phoneNumberTextField = new JTextField();
		phoneNumberTextField.setBounds(230, 310, 200, 20);
		phoneNumberTextField.setFont(textFildFont);
		this.add(phoneNumberTextField);
		//
		updateButton = new JButton("Update");
        updateButton.setBackground(Color.BLACK);
        updateButton.setForeground(Color.WHITE);
        updateButton.setBounds(80, 360, 100, 25);
		updateButton.setFont(labelFont);
        updateButton.addActionListener(this);
        this.add(updateButton);
		
		cancelButton = new JButton("Cancel");
        cancelButton.setBackground(Color.BLACK);
        cancelButton.setForeground(Color.WHITE);
        cancelButton.setBounds(240, 360, 100, 25);
		cancelButton.setFont(labelFont);
        cancelButton.addActionListener(this);
        this.add(cancelButton);
		
		ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icon/search.gif"));
		Image i5 = i4.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
		ImageIcon i6 = new ImageIcon(i5);
		searchButton = new JButton(i6);
		searchButton.setContentAreaFilled(false);
		//searchButton = new JButton("Search");
        //searchButton.setBackground(Color.GREEN);
        //searchButton.setForeground(Color.WHITE);
        searchButton.setBounds(440, 100, 40, 50);
		//searchButton.setFont(labelFont);
        searchButton.addActionListener(this);
        this.add(searchButton);
		//
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/information.png"));
        Image i2 = i1.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(550, 50, 400, 300);
        add(image);

		this.setVisible(true);
	}
	private void loadCustomerInfo(String meterNum){
		try{
			FileReader fileReader = new FileReader("New Customer Info.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] userDetails = line.trim().split(",");
                if (userDetails[1].equals(meterNum)) {
                    ansNameLabel.setText(userDetails[0]);
					addressTextField.setText(userDetails[2]);
					cityTextField.setText(userDetails[3]);
					stateTextField.setText(userDetails[4]);
					emailTextField.setText(userDetails[5]);
					phoneNumberTextField.setText(userDetails[6]);
                    break;
                }
            }
            bufferedReader.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void actionPerformed(ActionEvent ae){
		
		if(searchButton == ae.getSource()){
			String n = meternumberChoice.getSelectedItem();
			this.loadCustomerInfo(n);
			meternumberChoice.setEnabled(false);
		}
		else if(cancelButton == ae.getSource()){
			this.dispose();
			//new Homepage("Customer");
		}
		else if(updateButton == ae.getSource()){
			//this.updateCustomerInfo();
			String customerName = ansNameLabel.getText();
            String meterNum = meternumberChoice.getSelectedItem();
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
					java.util.List<String> fileContent = new ArrayList<>();
					BufferedReader br = new BufferedReader(new FileReader("New Customer Info.txt"));
					String line;
					while ((line = br.readLine()) != null) {
						if (line.contains(meterNum)) {
							line = customerName + "," + meterNum + "," + address + "," + city + "," + state + "," + email + "," + phoneNumber;
						}
						fileContent.add(line);
					}
					br.close();
					FileWriter fw = new FileWriter("New Customer Info.txt");
					for (String str : fileContent) {
						fw.write(str + System.lineSeparator());
					}
					fw.close();
					ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icon/verified.gif"));
					Image i5 = i4.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
					ImageIcon i6 = new ImageIcon(i5);
					JOptionPane.showMessageDialog(null, "Your information update Successfully","Notification", JOptionPane.INFORMATION_MESSAGE,i6);
					this.setVisible(false);
					//new ViewInfo(meterNum);
				}catch(Exception e){
					JOptionPane.showMessageDialog(null,"Please,Try again..!","Warning!",JOptionPane.ERROR_MESSAGE);
				}
				this.setVisible(false);
				//new Login();
			}
		}
	}
}
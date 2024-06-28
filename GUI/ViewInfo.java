package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.ImageIcon;
import java.io.*;
import java.util.*;

public class ViewInfo extends JFrame implements ActionListener{
	
	Font titleFont = new Font("Tahoma",Font.PLAIN,24);
	Font labelFont = new Font("Tahoma",Font.BOLD,14);
	Font textFildFont = new Font("Tahoma",Font.BOLD,12);
	
	JButton backButton,searchButton;
	JTextField meternumberTextField;
	JLabel meternumber,phone,email,state,city,address,name;
	//String meterNum;
	
	public ViewInfo(){
		super("Your Profile");
		super.setBounds(350, 150, 850, 650);
        super.getContentPane().setBackground(Color.WHITE);
        super.setLayout(null);
		//this.meterNum=meterNum;
		
		JLabel heading = new JLabel("VIEW CUSTOMER INFORMATION");
        heading.setBounds(250, 0, 500, 40);
        heading.setFont(titleFont);
        this.add(heading);
		
		JLabel lblname = new JLabel("Name");
        lblname.setBounds(70, 80, 100, 20);
		lblname.setFont(labelFont);
        this.add(lblname);
		
		name = new JLabel("");
        name.setBounds(250, 80, 150, 20);
		name.setFont(textFildFont);
        this.add(name);
        
        JLabel lblmeternumber = new JLabel("Meter Number");
        lblmeternumber.setBounds(70, 140, 120, 20);
		lblmeternumber.setFont(labelFont);
        this.add(lblmeternumber);
        
        meternumberTextField = new JTextField("");
        meternumberTextField.setBounds(250, 140, 100, 20);
		meternumberTextField.setFont(textFildFont);
        this.add(meternumberTextField);
		//this.meternumber.setText(meterNum);
        //loadCustomerInfo(meternumberTextField.getText());
		
		JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(70, 200, 100, 20);
		lbladdress.setFont(labelFont);
        this.add(lbladdress);
        
        address = new JLabel("");
        address.setBounds(250, 200, 150, 20);
		address.setFont(textFildFont);
        this.add(address);
        
        JLabel lblcity = new JLabel("City");
        lblcity.setBounds(70, 260, 100, 20);
		lblcity.setFont(labelFont);
        this.add(lblcity);
        
        city = new JLabel("");
        city.setBounds(250, 260, 100, 20);
		city.setFont(textFildFont);
        this.add(city);
        
        JLabel lblstate = new JLabel("State");
        lblstate.setBounds(500, 80, 100, 20);
		lblstate.setFont(labelFont);
        this.add(lblstate);
        
        state = new JLabel("");
        state.setBounds(650, 80, 100, 20);
		state.setFont(textFildFont);
        this.add(state);
        
        JLabel lblemail = new JLabel("Email");
        lblemail.setBounds(500, 140, 100, 20);
		lblemail.setFont(labelFont);
        this.add(lblemail);
        
        email = new JLabel("");
        email.setBounds(650, 140, 180, 20);
		//email.setFont(textFildFont);
        this.add(email);
        
        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(500, 200, 100, 20);
		lblphone.setFont(labelFont);
        this.add(lblphone);
        
         phone = new JLabel("");
        phone.setBounds(650, 200, 100, 20);
		phone.setFont(textFildFont);
        this.add(phone);
		
		backButton = new JButton("Back");
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        backButton.setBounds(420, 340, 100, 25);
		backButton.setFont(labelFont);
        backButton.addActionListener(this);
        this.add(backButton);
		
		searchButton = new JButton("Search");
        searchButton.setBackground(Color.BLACK);
        searchButton.setForeground(Color.WHITE);
        searchButton.setBounds(300, 340, 100, 25);
		searchButton.setFont(labelFont);
        searchButton.addActionListener(this);
        this.add(searchButton);

        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/viewcustomer.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(20, 350, 600, 300);
        this.add(image);
		
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
                    name.setText(userDetails[0]);
					address.setText(userDetails[2]);
					city.setText(userDetails[3]);
					state.setText(userDetails[4]);
					email.setText(userDetails[5]);
					phone.setText(userDetails[6]);
                    break;
                }
            }
            bufferedReader.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void actionPerformed(ActionEvent ae){
		
		if(backButton == ae.getSource()){
			this.setVisible(false);
			//new Homepage("Customer");
		}
		else if(searchButton == ae.getSource()){
			String n = meternumberTextField.getText();
			loadCustomerInfo(n);
		}
		
	}
	
}
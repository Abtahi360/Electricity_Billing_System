package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.ImageIcon;
import java.sql.*;
import java.io.*;
import java.util.*;

public class BillDetails extends JFrame implements ActionListener{
	
	Font titleFont = new Font("Tahoma",Font.PLAIN,24);
	Font labelFont = new Font("Tahoma",Font.BOLD,14);
	Font textFildFont = new Font("Tahoma",Font.BOLD,12);
	
	JLabel MeterNnumberLabel,nameLabel,ansNameLabel,addressLabel,ansAddressLabel,numberOfUnitsLabel,ansNumberOfUnitsLabel,monthLabel,ansMonthLabel,totallBillLabel,ansTotallBillLabel,costPerUnitsLabel,ansCostPerUnitsLabel,statusLabel,ansStatusLabel;
	JButton backButton,searchButton;
	JTextField meternumberTextField;
	//String meterNum;
	
	public BillDetails(){
		super("Your Bill Details");
		super.setBounds(350, 150, 850, 650);
        super.getContentPane().setBackground(Color.WHITE);
        super.setLayout(null);
		//this.meterNum=meterNum;
		
		JLabel heading = new JLabel("VIEW BILL INFORMATION");
        heading.setBounds(250, 0, 500, 40);
        heading.setFont(titleFont);
        this.add(heading);
		//
		nameLabel = new JLabel("Name");
        nameLabel.setBounds(70, 80, 100, 20);
		nameLabel.setFont(labelFont);
        this.add(nameLabel);
		
		ansNameLabel = new JLabel("");
        ansNameLabel.setBounds(250, 80, 180, 20);
		ansNameLabel.setFont(textFildFont);
        this.add(ansNameLabel);
        //
        MeterNnumberLabel = new JLabel("Meter Number");
        MeterNnumberLabel.setBounds(70, 140, 120, 20);
		MeterNnumberLabel.setFont(labelFont);
        this.add(MeterNnumberLabel);
        
        meternumberTextField = new JTextField("");
        meternumberTextField.setBounds(250, 140, 100, 20);
		meternumberTextField.setFont(textFildFont);
        this.add(meternumberTextField);
		//this.meternumber.setText(meterNum);
        //loadCustomerInfo(meternumberTextField.getText());
		
		addressLabel = new JLabel("Address");
        addressLabel.setBounds(70, 200, 100, 20);
		addressLabel.setFont(labelFont);
        this.add(addressLabel);
        
        ansAddressLabel = new JLabel("");
        ansAddressLabel.setBounds(250, 200, 180, 20);
		ansAddressLabel.setFont(textFildFont);
        this.add(ansAddressLabel);
        
        numberOfUnitsLabel = new JLabel("Number of Units");
        numberOfUnitsLabel.setBounds(70, 260, 180, 20);
		numberOfUnitsLabel.setFont(labelFont);
        this.add(numberOfUnitsLabel);
        
        ansNumberOfUnitsLabel = new JLabel("");
        ansNumberOfUnitsLabel.setBounds(250, 260, 100, 20);
		ansNumberOfUnitsLabel.setFont(textFildFont);
        this.add(ansNumberOfUnitsLabel);
        
        monthLabel = new JLabel("Month");
        monthLabel.setBounds(500, 80, 100, 20);
		monthLabel.setFont(labelFont);
        this.add(monthLabel);
        
        ansMonthLabel = new JLabel("");
        ansMonthLabel.setBounds(650, 80, 100, 20);
		ansMonthLabel.setFont(textFildFont);
        this.add(ansMonthLabel);
        
        totallBillLabel = new JLabel("Totall Bill");
        totallBillLabel.setBounds(500, 140, 100, 20);
		totallBillLabel.setFont(labelFont);
        this.add(totallBillLabel);
        
        ansTotallBillLabel = new JLabel("");
        ansTotallBillLabel.setBounds(650, 140, 150, 20);
		ansTotallBillLabel.setFont(textFildFont);
        this.add(ansTotallBillLabel);
        
        costPerUnitsLabel = new JLabel("Cost Per Units");
        costPerUnitsLabel.setBounds(500, 200, 150, 20);
		costPerUnitsLabel.setFont(labelFont);
        this.add(costPerUnitsLabel);
        
        ansCostPerUnitsLabel = new JLabel("");
        ansCostPerUnitsLabel.setBounds(650, 200, 100, 20);
		ansCostPerUnitsLabel.setFont(textFildFont);
        this.add(ansCostPerUnitsLabel);
		
		statusLabel = new JLabel("Status");
        statusLabel.setBounds(500, 260, 150, 20);
		statusLabel.setFont(labelFont);
        this.add(statusLabel);
        
        ansStatusLabel = new JLabel("");
        ansStatusLabel.setBounds(650, 260, 100, 20);
		ansStatusLabel.setFont(textFildFont);
        this.add(ansStatusLabel);
		
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
        searchButton.setBounds(280, 340, 100, 25);
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
			FileReader fileReader = new FileReader("Calculate Bill Info.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null){
                String[] userDetails = line.trim().split(",");
                if (userDetails[0].equals(meterNum)) {
                    ansNameLabel.setText(userDetails[1]);
					ansAddressLabel.setText(userDetails[2]);
					ansNumberOfUnitsLabel.setText(userDetails[3]);
					ansMonthLabel.setText(userDetails[4]);
					ansTotallBillLabel.setText(userDetails[5]+" taka");
					ansCostPerUnitsLabel.setText(userDetails[6]);
					ansStatusLabel.setText(userDetails[7]);
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
			meternumberTextField.setEnabled(false);
		}
		
	}
	
}
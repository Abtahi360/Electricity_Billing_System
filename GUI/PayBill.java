package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.ImageIcon;
import java.sql.*;
import java.io.*;
import java.util.*;

public class PayBill extends JFrame implements ActionListener{
	
	Font titleFont = new Font("Tahoma",Font.BOLD,24);
	Font labelFont = new Font("Tahoma",Font.BOLD,14);
	Font textFildFont = new Font("Tahoma",Font.BOLD,12);
	
	JLabel MeterNnumberLabel,nameLabel,ansNameLabel,numberOfUnitsLabel,ansNumberOfUnitsLabel,monthLabel,totallBillLabel,ansTotallBillLabel,statusLabel,ansStatusLabel;
	JButton backButton,payButton,searchButton;
	JTextField meternumberTextField;
	Choice monthChoice;
	
	
	public PayBill(){
		super("Bill Payment");
		//super.setDefaultCloseOperation(EXIT_ON_CLOSE);
		super.setBounds(300, 150, 900, 600);
        super.getContentPane().setBackground(Color.WHITE);
        super.setLayout(null);
		
		JLabel heading = new JLabel("ELECTICITY BILL");
        heading.setBounds(115, 5, 400, 30);
        heading.setFont(titleFont);
        this.add(heading);
		//
		nameLabel = new JLabel("Name");
        nameLabel.setBounds(35, 140, 200, 20);
		nameLabel.setFont(labelFont);
        this.add(nameLabel);
		
		ansNameLabel = new JLabel("");
        ansNameLabel.setBounds(250, 140, 200, 20);
		ansNameLabel.setFont(textFildFont);
        this.add(ansNameLabel);
        //
        MeterNnumberLabel = new JLabel("Meter Number");
        MeterNnumberLabel.setBounds(35, 80, 200, 20);
		MeterNnumberLabel.setFont(labelFont);
        this.add(MeterNnumberLabel);
        
        meternumberTextField = new JTextField("");
        meternumberTextField.setBounds(250, 80, 200, 20);
		meternumberTextField.setFont(textFildFont);
        this.add(meternumberTextField);
		//
		monthLabel = new JLabel("Month");
        monthLabel.setBounds(35, 200, 200, 20);
		monthLabel.setFont(labelFont);
        this.add(monthLabel);
        
        monthChoice = new Choice();
        monthChoice.setBounds(250, 200, 200, 20);
        monthChoice.add("January");
        monthChoice.add("February");
        monthChoice.add("March");
        monthChoice.add("April");
        monthChoice.add("May");
        monthChoice.add("June");
        monthChoice.add("July");
        monthChoice.add("August");
        monthChoice.add("September");
        monthChoice.add("October");
        monthChoice.add("November");
        monthChoice.add("December");
		monthChoice.setFont(textFildFont);
        this.add(monthChoice);
		//
		numberOfUnitsLabel = new JLabel("Number of Units");
        numberOfUnitsLabel.setBounds(35, 260, 200, 20);
		numberOfUnitsLabel.setFont(labelFont);
        this.add(numberOfUnitsLabel);
        
        ansNumberOfUnitsLabel = new JLabel("");
        ansNumberOfUnitsLabel.setBounds(250, 260, 200, 20);
		ansNumberOfUnitsLabel.setFont(textFildFont);
        this.add(ansNumberOfUnitsLabel);
		//
		totallBillLabel = new JLabel("Totall Bill");
        totallBillLabel.setBounds(35, 320, 200, 20);
		totallBillLabel.setFont(labelFont);
        this.add(totallBillLabel);
        
        ansTotallBillLabel = new JLabel("");
        ansTotallBillLabel.setBounds(250, 320, 200, 20);
		ansTotallBillLabel.setFont(textFildFont);
        this.add(ansTotallBillLabel);
		//
		statusLabel = new JLabel("Status");
        statusLabel.setBounds(35, 380, 200, 20);
		statusLabel.setFont(labelFont);
        this.add(statusLabel);
        
        ansStatusLabel = new JLabel("");
        ansStatusLabel.setBounds(250, 380, 200, 20);
		ansStatusLabel.setForeground(Color.RED);
		ansStatusLabel.setFont(textFildFont);
        this.add(ansStatusLabel);
		
		ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icon/search.gif"));
		Image i5 = i4.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
		ImageIcon i6 = new ImageIcon(i5);
		searchButton = new JButton(i6);
		searchButton.setContentAreaFilled(false);
		//searchButton = new JButton("Search");
        //searchButton.setBackground(Color.GREEN);
        //searchButton.setForeground(Color.WHITE);
        searchButton.setBounds(460, 65, 40, 50);
        searchButton.addActionListener(this);
        this.add(searchButton);
		
		payButton = new JButton("Pay Now");
        payButton.setBackground(Color.GREEN);
        payButton.setForeground(Color.WHITE);
        payButton.setBounds(100, 460, 100, 25);
		payButton.setFont(labelFont);
        payButton.addActionListener(this);
        this.add(payButton);
		
		backButton = new JButton("Back");
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        backButton.setBounds(230, 460, 100, 25);
		backButton.setFont(labelFont);
        backButton.addActionListener(this);
        this.add(backButton);
		
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/pay-per-click.gif"));
        Image i2 = i1.getImage().getScaledInstance(500, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 150, 500, 200);
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
					ansNumberOfUnitsLabel.setText(userDetails[3]);
					//monthChoice.setText(userDetails[4]);
					ansTotallBillLabel.setText(userDetails[5]+" taka");
					ansStatusLabel.setText(userDetails[7]);
                    break;
                }
            }
            bufferedReader.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	private void loadCustomerInfo(String meterNum, String month){
		try {
			File inputFile = new File("Calculate Bill Info.txt");
			BufferedReader reader = new BufferedReader(new FileReader(inputFile));

			String currentLine;
			boolean isUpdated = false;
			java.util.List<String> fileContent = new ArrayList<>();

			while ((currentLine = reader.readLine()) != null) {
				String[] details = currentLine.split(",");
				if (details[0].equals(meterNum) && details[4].equals(month)) {
					details[7] = "Paid"; 
					currentLine = String.join(",", details);
					isUpdated = true;
				}
				fileContent.add(currentLine);
			}
			reader.close();

			// Rewrite the file
			FileWriter writer = new FileWriter(inputFile);
			for (String line : fileContent) {
				writer.write(line + System.lineSeparator());
			}

			if (!isUpdated) {
				writer.write(meterNum + "," + ansNameLabel.getText() + "," + ansNumberOfUnitsLabel.getText() + "," + month + "," + ansTotallBillLabel.getText() + "," + "Paid");
			}

			writer.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void actionPerformed(ActionEvent ae){
		
		
		if(searchButton == ae.getSource()){
			String n = meternumberTextField.getText();
			loadCustomerInfo(n);
			meternumberTextField.setEnabled(false);
		}
		
		else if(payButton == ae.getSource()){
			this.setVisible(false);
			new PayPage();
			
			
			String meterNum = meternumberTextField.getText();
			String month = monthChoice.getSelectedItem();
			loadCustomerInfo(meterNum, month);
			

						
		}
		else if(backButton == ae.getSource()){
			this.setVisible(false);
			//new Homepage("Customer");
		}
		
	}
	
	
	
}
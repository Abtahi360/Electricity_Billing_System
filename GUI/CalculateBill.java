package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.util.*;
import java.io.*;
public class CalculateBill extends JFrame implements ActionListener{
	
	Font titleFont = new Font("Tahoma",Font.PLAIN,24);
	Font labelFont = new Font("Tahoma",Font.BOLD,14);
	Font textFildFont = new Font("Tahoma",Font.BOLD,12);
	
	JLabel ansNameLabel,ansAddressLabel,meterNumberLabel,nameLabel,addressLabel,unitsLabel,monthLabel,costPerUnitsLabel,costPerUnitsAnsLabel,numOfUnitsLabel;
	JTextField meterNumberTextField,addressTextField,numOfUnitsTextField;
	JButton nextButton,cancelButton,CalculateBillButton,searchButton;
	Choice nameChoice,addressChoice,monthChoice,meternumberChoice;
	int totalBill;
	public CalculateBill(){
		
		super("Fill-up Bill Information");
		super.setSize(700,500);
		super.setLocation(400,200);
		super.setLayout(new BorderLayout());
		
		JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(173, 216, 230));
        this.add(panel);
		
		JLabel title = new JLabel("Calculate Electricity Bill");
        title.setBounds(115, 10, 600, 25);
        title.setFont(titleFont);
        panel.add(title);
		//
		meterNumberLabel = new JLabel("Meter Number");
		meterNumberLabel.setBounds(100, 80, 100, 20);
		meterNumberLabel.setFont(labelFont);
		panel.add(meterNumberLabel);
		
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
        meternumberChoice.setBounds(240, 80, 170, 20);
		meternumberChoice.setFont(textFildFont);
        panel.add(meternumberChoice);
		//
		nameLabel = new JLabel("Name");
        nameLabel.setBounds(100, 120, 100, 20);
		nameLabel.setFont(labelFont);
        panel.add(nameLabel);
        
        ansNameLabel = new JLabel("");
        ansNameLabel.setBounds(240, 120, 200, 20);
		ansNameLabel.setFont(labelFont);
        panel.add(ansNameLabel);
		//
		addressLabel = new JLabel("Address");
        addressLabel.setBounds(100, 160, 100, 20);
		addressLabel.setFont(labelFont);
        panel.add(addressLabel);
		
		ansAddressLabel = new JLabel("");
        ansAddressLabel.setBounds(240, 160, 200, 20);
		ansAddressLabel.setFont(labelFont);
        panel.add(ansAddressLabel);
		//
		costPerUnitsLabel = new JLabel("Cost Per Units");
        costPerUnitsLabel.setBounds(100, 200, 140, 20);
		costPerUnitsLabel.setFont(labelFont);
        panel.add(costPerUnitsLabel);
		
		costPerUnitsAnsLabel = new JLabel("6 taka");
        costPerUnitsAnsLabel.setBounds(240, 200, 170, 20);
		costPerUnitsAnsLabel.setFont(textFildFont);
        panel.add(costPerUnitsAnsLabel);
        //
        monthLabel = new JLabel("Month");
        monthLabel.setBounds(100, 240, 100, 20);
		monthLabel.setFont(labelFont);
        panel.add(monthLabel);
        
        monthChoice = new Choice();
        monthChoice.setBounds(240, 240, 170, 20);
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
        panel.add(monthChoice);
        //
		numOfUnitsLabel = new JLabel("Number of Units");
        numOfUnitsLabel.setBounds(100, 280, 140, 20);
		numOfUnitsLabel.setFont(labelFont);
        panel.add(numOfUnitsLabel);
		
		numOfUnitsTextField = new JTextField();
        numOfUnitsTextField.setBounds(240, 280, 170, 20);
		numOfUnitsTextField.setFont(textFildFont);
        panel.add(numOfUnitsTextField);
		//
		CalculateBillButton = new JButton("Calculate Bill");
        CalculateBillButton.setBounds(165, 340, 130,25);
		CalculateBillButton.setFont(labelFont);
        CalculateBillButton.setBackground(Color.GREEN);
        CalculateBillButton.setForeground(Color.WHITE);
        CalculateBillButton.addActionListener(this);
        panel.add(CalculateBillButton);
		
		ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icon/search.gif"));
		Image i5 = i4.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
		ImageIcon i6 = new ImageIcon(i5);
		searchButton = new JButton(i6);
		searchButton.setContentAreaFilled(false);
		//searchButton = new JButton("Search");
        //searchButton.setBackground(Color.GREEN);
        //searchButton.setForeground(Color.WHITE);
        searchButton.setBounds(570, 70, 40, 50);
        searchButton.addActionListener(this);
        this.add(searchButton);
		
        nextButton = new JButton("Submit");
        nextButton.setBounds(120, 390, 100,25);
		nextButton.setFont(labelFont);
        nextButton.setBackground(Color.BLACK);
        nextButton.setForeground(Color.WHITE);
        nextButton.addActionListener(this);
        panel.add(nextButton);
        
        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(250, 390, 100,25);
		cancelButton.setFont(labelFont);
        cancelButton.setBackground(Color.BLACK);
        cancelButton.setForeground(Color.WHITE);
        cancelButton.addActionListener(this);
        panel.add(cancelButton);
        //
        add(panel, "Center");
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/hicon2.jpg"));
        Image i2 = i1.getImage().getScaledInstance(150, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image, "West");
        getContentPane().setBackground(Color.WHITE);
        
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
					ansAddressLabel.setText(userDetails[2]);
                    break;
                }
            }
            bufferedReader.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void actionPerformed(ActionEvent ae){
		
		if(CalculateBillButton == ae.getSource()){
			int costPerUnit = 6;
			String units = numOfUnitsTextField.getText();
			String name = ansNameLabel.getText();

			try {
				int numOfUnits = Integer.parseInt(units);
				totalBill = costPerUnit * numOfUnits;
				ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icon/calculator.gif"));
				Image i5 = i4.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
				ImageIcon i6 = new ImageIcon(i5);
				JOptionPane.showMessageDialog(this, name+"'s Total Bill is: " + totalBill + " Taka", "Bill Calculation", JOptionPane.INFORMATION_MESSAGE,i6);
			} catch(NumberFormatException e) {
				ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("icon/alert.gif"));
				Image i8 = i7.getImage().getScaledInstance(47, 47, Image.SCALE_DEFAULT);
				ImageIcon i9 = new ImageIcon(i8);
				JOptionPane.showMessageDialog(this, "Please enter a valid number in 'Number of Units'", "Input Error", JOptionPane.ERROR_MESSAGE,i9);
			}
		}
		else if(searchButton == ae.getSource()){
			String n = meternumberChoice.getSelectedItem();
			loadCustomerInfo(n);
		}
		else if(nextButton == ae.getSource()){
			String units = numOfUnitsTextField.getText();
			String name = ansNameLabel.getText();
			String meterNumber = meternumberChoice.getSelectedItem();
            //String name = nameTextField.getText();
            String address = ansAddressLabel.getText();
            String month = monthChoice.getSelectedItem();
            String costPerUnits = costPerUnitsAnsLabel.getText();
			
			if(meterNumber.isEmpty() || name.isEmpty() || address.isEmpty() || units.isEmpty() || month.isEmpty()){
				ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icon/calculator.gif"));
				Image i5 = i4.getImage().getScaledInstance(47, 47, Image.SCALE_DEFAULT);
				ImageIcon i6 = new ImageIcon(i5);
				JOptionPane.showMessageDialog(null, "Please fill all of the fields.", "Warning!",JOptionPane.WARNING_MESSAGE,i6);
			}
			else{

				try{
					FileWriter writer = new FileWriter("Calculate Bill Info.txt",true);
					writer.write(meterNumber+","+name+","+address+","+units+","+month+","+totalBill+","+costPerUnits+","+"Not paid");
					writer.write(System.getProperty("line.separator"));
					writer.close();
					
					ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/calculator.gif"));
					Image i2 = i1.getImage().getScaledInstance(47, 47, Image.SCALE_DEFAULT);
					ImageIcon i3 = new ImageIcon(i2);
					JOptionPane.showMessageDialog(null,"Customer Details Add Successfully","Notification!",JOptionPane.INFORMATION_MESSAGE,i3);
					this.setVisible(false);
				}catch(Exception e){
					ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icon/alert.gif"));
					Image i5 = i4.getImage().getScaledInstance(47, 47, Image.SCALE_DEFAULT);
					ImageIcon i6 = new ImageIcon(i5);
					JOptionPane.showMessageDialog(null,"Please try again..!","Warning!",JOptionPane.ERROR_MESSAGE,i6);
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
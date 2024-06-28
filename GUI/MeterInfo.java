package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.util.*;
import java.io.FileWriter;

public class MeterInfo extends JFrame implements ActionListener{
	Font titleFont = new Font("Tahoma",Font.PLAIN,24);
	Font labelFont = new Font("Tahoma",Font.BOLD,14);
	Font textFildFont = new Font("Tahoma",Font.BOLD,12);
	
	JLabel title,meterNumberLabel,meterNumber,meterLocationLabel,metertypeLabel,phasecodeLabel,billTypeLabel,daysLabel,daysAnsLabel,noteLabel;
	JButton submitButton;
	Choice meterLocationChoice,metertypeChoice,phasecodeChoice,billTypeChoice;
	String meterNum;
	public MeterInfo(String meterNum){
		super("Please Fill-up Meter Information");
		super.setSize(700,500);
		super.setLocation(400,200);
		super.getContentPane().setBackground(new Color(173,216,230));
		super.setLayout(null);
		this.meterNum = meterNum;
		
		title = new JLabel("Meter Information");
		title.setBounds(315,15,200,25);
		title.setFont(titleFont);
		this.add(title);
		//
		meterNumberLabel = new JLabel("Meter Number");
		meterNumberLabel.setBounds(200, 80, 120, 20);
		meterNumberLabel.setFont(labelFont);
		this.add(meterNumberLabel);
		
		meterNumber = new JLabel(meterNum);
		meterNumber.setBounds(360, 80, 200, 20);
		meterNumber.setFont(textFildFont);
		this.add(meterNumber);
		//
		meterLocationLabel = new JLabel("Meter Location");
		meterLocationLabel.setBounds(200, 120, 120, 20);
		meterLocationLabel.setFont(labelFont);
		this.add(meterLocationLabel);
		
		meterLocationChoice = new Choice();
		meterLocationChoice.add("Outside");
        meterLocationChoice.add("Inside");
		meterLocationChoice.setBounds(360, 120, 200, 20);
		meterLocationChoice.setFont(textFildFont);
		this.add(meterLocationChoice);
		//
		metertypeLabel = new JLabel("Meter Type");
		metertypeLabel.setBounds(200, 160, 120, 20);
		metertypeLabel.setFont(labelFont);
		this.add(metertypeLabel);
		
		metertypeChoice = new Choice();
		metertypeChoice.add("Electric Meter");
        metertypeChoice.add("Solar Meter");
        metertypeChoice.add("Smart Meter");
		metertypeChoice.setBounds(360, 160, 200, 20);
		metertypeChoice.setFont(textFildFont);
		this.add(metertypeChoice);
		//
		phasecodeLabel = new JLabel("Phase Code");
		phasecodeLabel.setBounds(200, 200, 120, 20);
		phasecodeLabel.setFont(labelFont);
		this.add(phasecodeLabel);
		
		phasecodeChoice = new Choice();
		phasecodeChoice.add("011");
        phasecodeChoice.add("022");
        phasecodeChoice.add("033");
        phasecodeChoice.add("044");
        phasecodeChoice.add("055");
        phasecodeChoice.add("066");
        phasecodeChoice.add("077");
        phasecodeChoice.add("088");
        phasecodeChoice.add("099");
		phasecodeChoice.setBounds(360, 200, 200, 20);
		phasecodeChoice.setFont(textFildFont);
		this.add(phasecodeChoice);
		//
		billTypeLabel = new JLabel("Bill Type");
		billTypeLabel.setBounds(200, 240, 120, 20);
		billTypeLabel.setFont(labelFont);
		this.add(billTypeLabel);
		
		billTypeChoice = new Choice();
		billTypeChoice.add("Normal");
        billTypeChoice.add("Industial");
		billTypeChoice.setBounds(360, 240, 200, 20);
		billTypeChoice.setFont(textFildFont);
		this.add(billTypeChoice);
		//
		daysLabel = new JLabel("Days");
		daysLabel.setBounds(200, 280, 120, 20);
		daysLabel.setFont(labelFont);
		this.add(daysLabel);
		
		daysAnsLabel = new JLabel("30");
		daysAnsLabel.setBounds(360, 280, 200, 20);
		daysAnsLabel.setFont(labelFont);
		this.add(daysAnsLabel);
		
		noteLabel = new JLabel("Note");
		noteLabel.setBounds(200, 320, 120, 20);
		noteLabel.setFont(labelFont);
		this.add(noteLabel);
		
		JLabel noteAnsLabel = new JLabel("By Default Bill is calculated for 30 days only");
		noteAnsLabel.setBounds(360, 320, 300, 20);
		noteAnsLabel.setFont(new Font("Tahoma",Font.BOLD,12));
		this.add(noteAnsLabel);
		//
		submitButton = new JButton("Submit");
        submitButton.setBounds(360, 380, 85,25);
		submitButton.setFont(labelFont);
        submitButton.setBackground(Color.BLACK);
        submitButton.setForeground(Color.WHITE);
        submitButton.addActionListener(this);
        this.add(submitButton);
		
		//ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/hicon1.jpg"));
		//Image resizeImage = i1.getImage().getScaledInstance(150, 300, Image.SCALE_DEFAULT);
		//ImageIcon i2 = new ImageIcon(resizeImage);
        //JLabel image = new JLabel(i2);
        //image.setBounds(1, 1, 700, 500);
        //this.add(image);
		
		
		this.setVisible(true);
	}
	public void actionPerformed(ActionEvent ae){
		if(submitButton == ae.getSource()){
			String meterNum = meterNumber.getText();
            String meterLocation = meterLocationChoice.getSelectedItem();
            String metertype = metertypeChoice.getSelectedItem();
            String code = phasecodeChoice.getSelectedItem();
            String billType = billTypeChoice.getSelectedItem();
            String days = "30";
			
			if(meterNum.isEmpty() || meterLocation.isEmpty() || metertype.isEmpty() || code.isEmpty() || billType.isEmpty()){
				ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icon/alert.gif"));
				Image i5 = i4.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
				ImageIcon i6 = new ImageIcon(i5);
				JOptionPane.showMessageDialog(null, "Please fill all of the fields.", "Warning!", JOptionPane.ERROR_MESSAGE,i6);
			}
			else{

				try{
					FileWriter writer = new FileWriter("MeterInfo.txt",true);
					writer.write(meterNum+","+meterLocation+","+metertype+","+code+","+billType+","+days);
					writer.write(System.getProperty("line.separator"));
					writer.close();
					ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icon/verified.gif"));
					Image i5 = i4.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
					ImageIcon i6 = new ImageIcon(i5);
					JOptionPane.showMessageDialog(null, "Meter Information Add Successfully","Notification", JOptionPane.INFORMATION_MESSAGE,i6);
					this.setVisible(false);
				}catch(Exception e){
					ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icon/alert.gif"));
					Image i5 = i4.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
					ImageIcon i6 = new ImageIcon(i5);
					JOptionPane.showMessageDialog(null, "Try again..!", "Sorry...", JOptionPane.ERROR_MESSAGE,i6);
				}
				this.setVisible(false);
				//new Homepage("Admin");
			}
		}
	}
	
}
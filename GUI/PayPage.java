package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.ImageIcon;
import java.sql.*;
import java.io.*;
import java.util.*;

public class PayPage extends JFrame implements ActionListener{
	
	Font titleFont = new Font("Tahoma",Font.BOLD,24);
	Font labelFont = new Font("Tahoma",Font.BOLD,14);
	Font textFildFont = new Font("Tahoma",Font.BOLD,12);
	
	JButton back,bankButton,bkashButton;
	
	public PayPage(){
		super("Bill Payment");
		//super.setDefaultCloseOperation(EXIT_ON_CLOSE);
		super.setBounds(190, 70, 1100, 685);
        super.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 153, 153));
		this.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel pay= new JLabel(new ImageIcon("icon/payOnline1.png"));
		pay.setBounds(0,0,546,685);
		panel.add(pay);
		
		back = new JButton(new ImageIcon("icon/back.png"));
		back.setBounds(1000,10,35,35);
		back.addActionListener(this);
		back.setContentAreaFilled(false);
		panel.add(back);
		
		bankButton = new JButton(new ImageIcon("icon/card1.png"));
		bankButton.setBounds(640,250,150,150);
		bankButton.addActionListener(this);
		panel.add(bankButton);
		
		bkashButton = new JButton(new ImageIcon("icon/bkash1.png"));
		bkashButton.setBounds(850,250,150,150);
		bkashButton.addActionListener(this);
		panel.add(bkashButton);
		
		this.setVisible(true);
	}
	public void actionPerformed(ActionEvent ae){
		
		if(bankButton == ae.getSource()){
			this.setVisible(false);
			new Bank();
		}
		else if(bkashButton == ae.getSource()){
			this.setVisible(false);
		    new Bkash();
		}
		else if(back == ae.getSource()){
			this.setVisible(false);
			//new Homepage("Customer");
		}
		
	}
	
	
	
	
}
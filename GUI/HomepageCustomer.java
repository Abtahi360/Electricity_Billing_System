package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

public class HomepageCustomer extends JFrame implements ActionListener{
	
	JMenuBar menuBar;
	JMenu administratorMenu,informationMenu,userMenu,reportMenu,utilityMenu,existMenu;
	JMenuItem addCustomerItem,detailsItem,paydetailsItem,calculateBillItem,deleteCustomerItem,updateinfoItem,viewinfoItem,payBillItem,billDetailsItem,generateBillItem,notepadItem,calculatorItem,webBrowserItem,logoutItem;
	
	public HomepageCustomer(){
		super("Electricity Billing System");
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);
		super.setSize(1366,768);
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/cover photo.png"));
		Image resizeImage = i1.getImage().getScaledInstance(1366, 768, Image.SCALE_DEFAULT);
		ImageIcon i2 = new ImageIcon(resizeImage);
        JLabel image = new JLabel(i2);
        image.setBounds(0, 0, 1366, 768);
        this.add(image);
		super.setLayout(null);
		
		JLabel title = new JLabel("Electricity Billing System");
		title.setBounds(340, 80, -1, -1);
		title.setFont(new Font("Algerian",Font.BOLD,48));
		title.setForeground(new Color(0,0,139));
		title.setBounds(340, 80, title.getPreferredSize().width, title.getPreferredSize().height);
		image.add(title);
		
		JLabel subtitle = new JLabel("Customer Panel");
		subtitle.setBounds(630, 140, -1, -1);
		subtitle.setFont(new Font("Algerian",Font.BOLD,24));
		subtitle.setForeground(new Color(0,0,51));
		subtitle.setBounds(630, 140, title.getPreferredSize().width, title.getPreferredSize().height);
		image.add(subtitle);
		
		JLabel subtitle2 = new JLabel("BuildersSquad");
		subtitle2.setBounds(680, 600, -1, -1);
		subtitle2.setFont(new Font("Times New Roman",3,22));
		subtitle2.setForeground(Color.WHITE);
		subtitle2.setBounds(680, 600, title.getPreferredSize().width, title.getPreferredSize().height);
		image.add(subtitle2);
		
		menuBar = new JMenuBar();
		
		administratorMenu = new JMenu("Administrator");
		administratorMenu.setFont(new Font("Tahoma", Font.BOLD, 14));
		administratorMenu.setForeground(Color.BLUE);
		
		addCustomerItem = new JMenuItem("Add New Customer");
		addCustomerItem.setFont(new Font("sans-serif", Font.PLAIN, 12));
        addCustomerItem.setBackground(Color.WHITE);
        ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("icon/customer.png"));
        Image image1 = icon1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        addCustomerItem.setIcon(new ImageIcon(image1));
        addCustomerItem.addActionListener(this);
		
		detailsItem = new JMenuItem("Customer Details");
		detailsItem.setFont(new Font("sans-serif", Font.PLAIN, 12));
        detailsItem.setBackground(Color.WHITE);
        ImageIcon icon2 = new ImageIcon(ClassLoader.getSystemResource("icon/identification.png"));
        Image image2 = icon2.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        detailsItem.setIcon(new ImageIcon(image2));
        detailsItem.addActionListener(this);
		
		paydetailsItem = new JMenuItem("Pay Details");
		paydetailsItem.setFont(new Font("sans-serif", Font.PLAIN, 12));
        paydetailsItem.setBackground(Color.WHITE);
        ImageIcon icon3 = new ImageIcon(ClassLoader.getSystemResource("icon/online.png"));
        Image image3 = icon3.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        paydetailsItem.setIcon(new ImageIcon(image3));
        paydetailsItem.addActionListener(this);
		
		calculateBillItem = new JMenuItem("Calculate Bill");
		calculateBillItem.setFont(new Font("sans-serif", Font.PLAIN, 12));
        calculateBillItem.setBackground(Color.WHITE);
        ImageIcon icon4 = new ImageIcon(ClassLoader.getSystemResource("icon/accounting.png"));
        Image image4 = icon4.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        calculateBillItem.setIcon(new ImageIcon(image4));
        calculateBillItem.addActionListener(this);
		
		deleteCustomerItem = new JMenuItem("Delete Customer");
		deleteCustomerItem.setFont(new Font("sans-serif", Font.PLAIN, 12));
        deleteCustomerItem.setBackground(Color.WHITE);
        ImageIcon icon5 = new ImageIcon(ClassLoader.getSystemResource("icon/unhappy.png"));
        Image image5 = icon5.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        deleteCustomerItem.setIcon(new ImageIcon(image5));
        deleteCustomerItem.addActionListener(this);
		
		administratorMenu.add(addCustomerItem);
		administratorMenu.add(detailsItem);
		administratorMenu.add(paydetailsItem);
		administratorMenu.add(calculateBillItem);
		administratorMenu.add(deleteCustomerItem);
		menuBar.add(administratorMenu);
		
		informationMenu = new JMenu("Information");
		informationMenu.setFont(new Font("Tahoma", Font.BOLD, 14));
		informationMenu.setForeground(Color.BLUE);
		
		updateinfoItem = new JMenuItem("Update Information");
		updateinfoItem.setFont(new Font("sans-serif", Font.PLAIN, 12));
        updateinfoItem.setBackground(Color.WHITE);
        ImageIcon icon6 = new ImageIcon(ClassLoader.getSystemResource("icon/icon4.png"));
        Image image6 = icon6.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        updateinfoItem.setIcon(new ImageIcon(image6));
        updateinfoItem.addActionListener(this);
        informationMenu.add(updateinfoItem);
		
		viewinfoItem = new JMenuItem("View Information");
		viewinfoItem.setFont(new Font("sans-serif", Font.PLAIN, 12));
        viewinfoItem.setBackground(Color.WHITE);
        ImageIcon icon7 = new ImageIcon(ClassLoader.getSystemResource("icon/icon6.png"));
        Image image7 = icon7.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        viewinfoItem.setIcon(new ImageIcon(image7));
        viewinfoItem.addActionListener(this);
        informationMenu.add(viewinfoItem);
		
		userMenu = new JMenu("User");
		userMenu.setFont(new Font("Tahoma", Font.BOLD, 14));
		userMenu.setForeground(Color.BLUE);
		
		payBillItem = new JMenuItem("Pay Bill");
		payBillItem.setFont(new Font("sans-serif", Font.PLAIN, 12));
        payBillItem.setBackground(Color.WHITE);
        ImageIcon icon9 = new ImageIcon(ClassLoader.getSystemResource("icon/icon6.png"));
        Image image9 = icon9.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        payBillItem.setIcon(new ImageIcon(image9));
        payBillItem.addActionListener(this);
        userMenu.add(payBillItem);
		
		billDetailsItem = new JMenuItem("Bill Details");
		billDetailsItem.setFont(new Font("sans-serif", Font.PLAIN, 12));
        billDetailsItem.setBackground(Color.WHITE);
        ImageIcon icon10 = new ImageIcon(ClassLoader.getSystemResource("icon/icon6.png"));
        Image image10 = icon10.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        billDetailsItem.setIcon(new ImageIcon(image10));
        billDetailsItem.addActionListener(this);
        userMenu.add(billDetailsItem);
		
		reportMenu = new JMenu("Report");
		reportMenu.setFont(new Font("Tahoma", Font.BOLD, 14));
		reportMenu.setForeground(Color.RED);
		
		generateBillItem = new JMenuItem("Generate Bill");
        generateBillItem.setFont(new Font("sans-serif", Font.PLAIN, 12));
        generateBillItem.setBackground(Color.WHITE);
        ImageIcon icon13 = new ImageIcon(ClassLoader.getSystemResource("icon/icon7.png"));
        Image image13 = icon13.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        generateBillItem.setIcon(new ImageIcon(image13));
        generateBillItem.addActionListener(this);
        reportMenu.add(generateBillItem);
		
		utilityMenu = new JMenu("Utility");
		utilityMenu.setFont(new Font("Tahoma", Font.BOLD, 14));
		utilityMenu.setForeground(Color.BLUE);
		
		notepadItem = new JMenuItem("Notepad");
		notepadItem.setFont(new Font("sans-serif", Font.PLAIN, 12));
        notepadItem.setBackground(Color.WHITE);
        ImageIcon icon11 = new ImageIcon(ClassLoader.getSystemResource("icon/notepad.png"));
        Image image11 = icon11.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        notepadItem.setIcon(new ImageIcon(image11));
        notepadItem.addActionListener(this);
		
		calculatorItem = new JMenuItem("Calculator");
		calculatorItem.setFont(new Font("sans-serif", Font.PLAIN, 12));
        calculatorItem.setBackground(Color.WHITE);
        ImageIcon icon12 = new ImageIcon(ClassLoader.getSystemResource("icon/calculator.png"));
        Image image12 = icon12.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        calculatorItem.setIcon(new ImageIcon(image12));
        calculatorItem.addActionListener(this);
		
		webBrowserItem = new JMenuItem("Web Browser");
		webBrowserItem.setFont(new Font("sans-serif", Font.PLAIN, 12));
        webBrowserItem.setBackground(Color.WHITE);
        ImageIcon icon8 = new ImageIcon(ClassLoader.getSystemResource("icon/chrome.png"));
        Image image8 = icon8.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        webBrowserItem.setIcon(new ImageIcon(image8));
        webBrowserItem.addActionListener(this);
		
		
		utilityMenu.add(notepadItem);
		utilityMenu.add(calculatorItem);
		utilityMenu.add(webBrowserItem);
		menuBar.add(utilityMenu);
		
		existMenu = new JMenu("Exist");
		existMenu.setFont(new Font("Tahoma", Font.BOLD, 14));
		existMenu.setForeground(Color.RED);
		
		logoutItem = new JMenuItem("Logout");
		logoutItem.setFont(new Font("monospaced", Font.PLAIN, 12));
        logoutItem.setBackground(Color.WHITE);
        ImageIcon icon14 = new ImageIcon(ClassLoader.getSystemResource("icon/icon11.png"));
        Image image14 = icon14.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        logoutItem.setIcon(new ImageIcon(image14));
        logoutItem.addActionListener(this);
        existMenu.add(logoutItem);
		
		
		
		
		menuBar.add(informationMenu);
		menuBar.add(userMenu);
		menuBar.add(reportMenu);
		menuBar.add(utilityMenu);
		menuBar.add(existMenu);
		this.setJMenuBar(menuBar);
		this.setVisible(true);
	}
	public void actionPerformed(ActionEvent ae){
		if(addCustomerItem == ae.getSource()){
			new NewCustomer();
			
		}
		else if(detailsItem == ae.getSource()){
			new CustomerDetails();
		}
		else if(paydetailsItem == ae.getSource()){
			
		}
		else if(calculateBillItem == ae.getSource()){
			new CalculateBill();
		}
		else if(deleteCustomerItem == ae.getSource()){
			
		}
		else if(updateinfoItem == ae.getSource()){
			
		}
		else if(viewinfoItem == ae.getSource()){
			
		}
		else if(payBillItem == ae.getSource()){
			new PayDetails();
		}
		else if(billDetailsItem == ae.getSource()){
			
		}
		else if(generateBillItem == ae.getSource()){
			
		}
		else if(notepadItem == ae.getSource()){
			
		}
		else if(calculatorItem == ae.getSource()){
			
		}
		else if(webBrowserItem == ae.getSource()){
			
		}
		else if(logoutItem == ae.getSource()){
			ImageIcon addIcon = new ImageIcon("tick.png");
			JOptionPane.showMessageDialog(null,"Logout Successfully","Notification!",JOptionPane.INFORMATION_MESSAGE,addIcon);
			this.setVisible(false);
			new Login();
		}
	}
}
	
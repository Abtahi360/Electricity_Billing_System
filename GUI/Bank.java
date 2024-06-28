package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.ImageIcon;
import java.sql.*;
import javax.swing.JOptionPane.*;


public class Bank extends JFrame implements ActionListener{
	
	JTextField crdNum,ex,cvc,chn;
	JButton back,b1,b2;
	
	public Bank(){
		super("Bank");
		//super.setDefaultCloseOperation(EXIT_ON_CLOSE);
		super.setBounds(190, 70, 1100, 685);
        super.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 153, 153));
		this.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel pay= new JLabel(new ImageIcon("icon/bank1.png"));
		pay.setBounds(0,0,546,685);
		panel.add(pay);
		
		JLabel l1 = new JLabel(new ImageIcon("icon/vissa.png"));
		l1.setBounds(750,235,70,50);
		panel.add(l1);

		JLabel l2 = new JLabel(new ImageIcon("icon/master.png"));
		l2.setBounds(820,235,70,50);
		panel.add(l2);
		
		 crdNum = new JTextField("Enter Card Number");
		crdNum.setFont(new Font("Tahoma", Font.PLAIN, 16));
		crdNum.setBounds(690, 280, 280, 40);
		panel.add(crdNum);
		
		 ex = new JTextField("MM/YY");
		ex.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ex.setBounds(690, 330, 130, 40);
		panel.add(ex);

		 cvc = new JTextField("CVC/CVV");
		cvc.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cvc.setBounds(840, 330, 130, 40);
		panel.add(cvc);

		 chn = new JTextField("Card Holder Name");
		chn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		chn.setBounds(690, 380, 280, 40);
		panel.add(chn);
		
		b1 = new JButton("Procced");
		b1.setBounds(690, 430,130,40);
		b1.setBorder(null);
		b1.setFont(new Font("Algreya", Font.BOLD, 18));
		b1.setForeground(new Color(25, 118, 211));
		b1.setBackground(new Color(255, 255, 255));
		b1.addActionListener(this);
		panel.add(b1);

		b2 = new JButton("Cancel");
		b2.setBounds(840, 430,130,40);
		b2.setBorder(null);
		b2.setFont(new Font("Algreya", Font.BOLD, 18));
		b2.setForeground(new Color(255,0,0 ));
		b2.setBackground(new Color(255, 255, 255));
		b2.addActionListener(this);
		panel.add(b2);
		
		
		this.setVisible(true);
	}
	public void actionPerformed(ActionEvent ae){
		
		if(b1 == ae.getSource()){
		
			try{
			if (crdNum.getText().equals("") || ex.getText().equals("") || cvc.getText().equals("") || chn.getText().equals("") || crdNum.getText().equals("Enter Card Number") || ex.getText().equals("MM/YY") || cvc.getText().equals("CVC/CVV") || chn.getText().equals("Card Holder Name")){
				ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/alert.gif"));
				Image i2 = i1.getImage().getScaledInstance(47, 47, Image.SCALE_DEFAULT);
				ImageIcon i3 = new ImageIcon(i2);
				JOptionPane.showMessageDialog(null, "Please fill all of the fields.", "Warning!",JOptionPane.WARNING_MESSAGE,i3);
			}
			else{
				ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/verified.gif"));
				Image i2 = i1.getImage().getScaledInstance(47, 47, Image.SCALE_DEFAULT);
				ImageIcon i3 = new ImageIcon(i2);
				JOptionPane.showMessageDialog(null, "Payment Complete", "Thank You..!", JOptionPane.INFORMATION_MESSAGE,i3);
				this.setVisible(false);
				new PayBill();
			}
			}catch(Exception e){
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "An error occurred while reading the file.", "Error", JOptionPane.ERROR_MESSAGE);
			}
			
		}
		else if(b2 == ae.getSource()){
			this.setVisible(false);
			new PayPage();
		}
	}
}
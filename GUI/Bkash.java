package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.ImageIcon;
import java.sql.*;

public class Bkash extends JFrame implements ActionListener{
	
	Font textFildFont = new Font("Tahoma",Font.BOLD,18);
	JTextField t;
	JButton b1,b2;
	
	public Bkash(){
		super("Bkash");
		//super.setDefaultCloseOperation(EXIT_ON_CLOSE);
		super.setBounds(190, 70, 1100, 685);
        super.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 153, 153));
		this.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel pay= new JLabel(new ImageIcon("icon/bkash.png"));
		pay.setBounds(0,0,1100,685);
		panel.add(pay);
		
		t = new JTextField();
        t.setBounds(673, 411, 325, 52);
		t.setFont(textFildFont);
        panel.add(t);
		
		b1 = new JButton();
		b1.setText("Confirm");
		b1.setBounds(838,540,199,45);
		b1.setFont(new Font("Algreya", Font.BOLD, 18));
		b1.setForeground(new Color(25, 118, 211));
		b1.setBackground(new Color(255, 255, 255));
		b1.addActionListener(this);
		panel.add(b1);
   
		b2 = new JButton();
		b2.setText("Close");
		b2.setBounds(635,540,200,45);
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
			if (t.getText().equals("")){
				ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/alert.gif"));
				Image i2 = i1.getImage().getScaledInstance(47, 47, Image.SCALE_DEFAULT);
				ImageIcon i3 = new ImageIcon(i2);
				JOptionPane.showMessageDialog(null, "Please fill all of the fields.", "Warning!",JOptionPane.WARNING_MESSAGE,i3);
			}
			else if(t.getText().length() == 11 || t.getText().length() == 13){
				ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/verified.gif"));
				Image i2 = i1.getImage().getScaledInstance(47, 47, Image.SCALE_DEFAULT);
				ImageIcon i3 = new ImageIcon(i2);
				JOptionPane.showMessageDialog(null, "Payment Complete", "Thank You..!", JOptionPane.INFORMATION_MESSAGE,i3);
				this.setVisible(false);
				new PayBill();
			}
			else{
				ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/alert.gif"));
				Image i2 = i1.getImage().getScaledInstance(47, 47, Image.SCALE_DEFAULT);
				ImageIcon i3 = new ImageIcon(i2);
				JOptionPane.showMessageDialog(null, "Please enter valied number", "Warning!",JOptionPane.WARNING_MESSAGE,i3);
			}
			}catch(Exception e){
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "An error occurred while reading the file.", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		else{
			this.setVisible(false);
			new PayPage();
		}
		
		
	}
	
	
	
	
	
	
	
}
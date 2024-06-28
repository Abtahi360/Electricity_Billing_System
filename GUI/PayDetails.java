package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.ImageIcon;
import java.sql.*;
import java.io.*;
import java.util.*;
import javax.swing.table.DefaultTableModel;

public class PayDetails extends JFrame implements ActionListener{
	
	Font titleFont = new Font("Tahoma",Font.PLAIN,24);
	Font labelFont = new Font("Tahoma",Font.BOLD,14);
	Font textFildFont = new Font("Tahoma",Font.BOLD,12);
	
	JTable table;
	JButton backButton;
	DefaultTableModel tableModel;
	
	public PayDetails(){
		super("Pay Details");
		super.setSize(1200,650);
		super.setLocation(110,100);
		super.getContentPane().setBackground(Color.WHITE);
		super.setLayout(new BorderLayout());
		
		String[] columnNames = {"Meter Number", "Customer Name", "Address", "Number of Units", "Month", "Total Bill", "Cost Per Unit", "Paid Status"};
		tableModel = new DefaultTableModel(columnNames, 0);
		table = new JTable(tableModel);
		table.setModel(tableModel);
		table.setEnabled(false);
		loadTableData();
		
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(0, 100, 700, 600);
        this.add(sp,BorderLayout.CENTER);
        
        backButton = new JButton("Back");
        backButton.setBounds(20, 70, 80, 20);
		backButton.setFont(labelFont);
        backButton.addActionListener(this);
        this.add(backButton, "South");
			
		this.setVisible(true);
	}
	private void loadTableData() {
        try {
            FileReader fileReader = new FileReader("Calculate Bill Info.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                tableModel.addRow(data);
            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	public void actionPerformed(ActionEvent ae){
		
		if(backButton == ae.getSource()){
			this.setVisible(false);
			//new Homepage("Admin");
		}
	}
}
package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.ImageIcon;
import java.sql.*;
import java.io.*;
import java.util.*;
import javax.swing.table.DefaultTableModel;

public class DeleteCustomer extends JFrame implements ActionListener{
	
	Font titleFont = new Font("Tahoma",Font.PLAIN,24);
	Font labelFont = new Font("Tahoma",Font.BOLD,14);
	Font textFildFont = new Font("Tahoma",Font.BOLD,12);
	
	JTable table;
	JButton deleteButton,backButton;
	DefaultTableModel tableModel;
	
	public DeleteCustomer(){
		super("Delete a Customer");
		super.setSize(1200,650);
		super.setLocation(110,100);
		super.getContentPane().setBackground(Color.WHITE);
		super.setLayout(new BorderLayout());
		
		String[] columnNames = {"Customer Name", "Meter Number", "Address", "City", "State", "Email", "Phone Number"};
		tableModel = new DefaultTableModel(columnNames, 0);
		table = new JTable(tableModel);
		table.setModel(tableModel);
		//table.setEnabled(false);
		loadTableData();
		
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(0, 100, 700, 600);
        this.add(sp,BorderLayout.CENTER);
		
		deleteButton = new JButton("Delete");
        deleteButton.setBounds(20, 60, 80, 20);
		deleteButton.setBackground(Color.RED);
        deleteButton.setForeground(Color.WHITE);
		deleteButton.setFont(labelFont);
        deleteButton.addActionListener(this);
        this.add(deleteButton, "South");
        
        backButton = new JButton("Back");
        backButton.setBounds(20, 90, 80, 20);
		backButton.setFont(labelFont);
        backButton.addActionListener(this);
        this.add(backButton, "East");
		
		this.setVisible(true);
	}
	private void loadTableData() {
        try {
            FileReader fileReader = new FileReader("New Customer Info.txt");
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
	private void deleteSelectedRow() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            String[] rowData = new String[table.getColumnCount()];
            for (int i = 0; i < table.getColumnCount(); i++) {
                rowData[i] = (String) table.getValueAt(selectedRow, i);
            }
            tableModel.removeRow(selectedRow);
			
			ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bin-file.gif"));
			Image i2 = i1.getImage().getScaledInstance(47, 47, Image.SCALE_DEFAULT);
			ImageIcon i3 = new ImageIcon(i2);
			JOptionPane.showMessageDialog(null,"Customer Deleted Successfully","Notification!",JOptionPane.INFORMATION_MESSAGE,i3);
        } else {
            JOptionPane.showMessageDialog(this, "Please select a row to delete.", "No Row Selected",JOptionPane.WARNING_MESSAGE);
        }
    }
	public void actionPerformed(ActionEvent ae){
		
		if(backButton == ae.getSource()){
			this.setVisible(false);
			//new Homepage("Admin");
		}
		else{
			deleteSelectedRow();
			this.setVisible(false);
		}
	}
}
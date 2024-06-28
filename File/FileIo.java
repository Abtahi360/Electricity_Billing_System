package File;
import Entity.*;
import EntityList.*;
import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;

public class FileIo{
	ElectricityBill eb = new ElectricityBill(data[0],data[1],data[2],data[3],data[4]);
	public static void readBillFromFile(ElectricityBillList electricityBillList){
		try{
			Scanner sc = new Scanner (new File("./File/Data.txt"));
			while(sc.hasNextLine()){
				String data[] = sc.nextLine().split(",");
				electricityBillList.insert(eb);
			}
			sc.close();
		}catch(Exception e){
			JOptionPane.showMessageDialog(null,"Invalid User Name or Password","Warning!",JOptionPane.ERROR_MESSAGE);
		}
	}
	public static void writeBillFromFile(){
		try{
			FileWriter writer = new FileWriter(new File("./File/Data.txt"));
			String line = eb.getAccountType()+","+eb.getMeterNum()+","+eb.getUsername()+","+eb.getName()+","+eb.getPassword()+"\n";
			writer.write(line);
			writer.close();
		}catch(Exception e){
			JOptionPane.showMessageDialog(null,"Invalid User Name or Password","Warning!",JOptionPane.ERROR_MESSAGE);
		}
	}
}
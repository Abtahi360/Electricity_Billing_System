package EntityList;
import Entity.*;

public class ElectricityBillList extends ElectricityBill{
	private ElectricityBill bills[];
	
	public ElectricityBillList(){
		bills = new ElectricityBill[5];
	}
	public ElectricityBillList(int size){
		bills = new ElectricityBill[size];
	}
	
	public void insert(ElectricityBill eb){
		boolean flag = false;
		for(int i=0;i<bills.length;i++){
			if(bills[i] == null){
				bills[i] = eb;
				flag = true;
				break;
			}
		}
	}
	public String getAll(){
		String allBills = "";
		
		for(int i=0;i<bills.length;i++){
			if(bills[i] != null){
				allBills += "------------------------------------------------\n";
				allBills += bills[i].getBookInfoAsString();
			}
		}
		allBills += "------------------------------------------------\n";
		return allBills;
	}
	public String getAllBookAsString(){
		String allBills = "";
		for(int i=0;i<bills.length;i++){
			if(bills[i] != null){
				allBills += "---------------------\n";
				allBills += bills[i].getAccountType()+"\n";	
				allBills += bills[i].getMeterNum()+"\n";	
				allBills += bills[i].getUsername()+"\n";	
				allBills += bills[i].getName()+"\n";	
				allBills += bills[i].getPassword()+"\n";	
			}
		}
		allBills += "---------------------\n";
		return allBills;
	}
	
	
}
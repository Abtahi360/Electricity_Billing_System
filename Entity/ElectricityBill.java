package Entity;
import java.io.*;
public class ElectricityBill {
    private String accountType;
    private String meterNum;
    private String username;
    private String name;
    private String password;
    private double unitConsumed;
    private double ratePerUnit;
	
	public ElectricityBill(String accountType, String meterNum, String username, String name, String password) {
        this.accountType = accountType;
        this.meterNum = meterNum;
        this.username = username;
        this.name = name;
        this.password = password;
    }
	public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getMeterNum() {
        return meterNum;
    }

    public void setMeterNum(String meterNum) {
        this.meterNum = meterNum;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public void showInfo() {
        System.out.println("Account Type: " + accountType);
        System.out.println("Meter Number: " + meterNum);
        System.out.println("Username: " + username);
        System.out.println("Name: " + name);
        System.out.println("Password: " + password);
    }
	
	public void addBill()
	{
		try
		{
			File file= new File("./data.txt");
			file.createNewFile();
			FileWriter fwriter=new FileWriter(file,true);
			fwriter.write(getAccountType()+"\t");
			fwriter.write(getMeterNum()+"\t");
			fwriter.write(getName()+"\t");
			fwriter.write(getPassword()+"\t");
			fwriter.flush();
			fwriter.close();
		}
		catch(IOException ioe)
		{
			ioe.printStackTrace();
		}
	}
}

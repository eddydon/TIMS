package pkgTIMS;

import java.io.*;
import java.text.*;

public class TIMS {
	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException
	{
		GEBank geSystem = new GEBank();
		int customerindex = 0;

		try{
			geSystem.loadCustomers();
			geSystem.loadAccounts();
			geSystem.loadMortgage();
			geSystem.loadCC();
			customerindex = geSystem.login();
			geSystem.displayMainMenu(customerindex);
			geSystem.displayBalance(customerindex);
			geSystem.displayPayment(customerindex);
			geSystem.depositFunds(customerindex);
			geSystem.transferFunds(customerindex);
			//geSystem.displayPayment(customerindex);
			geSystem.updateProfile(customerindex);
			customerindex = geSystem.lostCard();
			geSystem.displayLostCardMenu(customerindex);
			geSystem.withdrawFunds(customerindex);
		}catch (NumberFormatException e) {	
			System.out.println ("\nERROR: Numbers Only! Please Follow Menu Options! Try Again!\n");
					geSystem.login();
				}
	}
}
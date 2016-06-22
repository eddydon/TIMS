package pkgTIMS;

import java.io.*;
import java.text.*;
import java.util.*;

public class GEBank {
		char morebalances, moretransfers, moredeposits = 'x';
		double TSoA, FCA, TCA, FSA, TSA, MFC, CFC, DTSoar, DTChecking, DTSavings, WFChecking, WFSavings, newCB, newSB, newSoB;
		double transferAmount, checkAmount, withdrawAmount = 0.00f;
		String newPassword = "";
		String newUsername = "";
		
		int menuchoice = -1;
		int attempts = 0;
		
		String startTime;
		String endTime;
		int numPayments;
		double withdrawals;
		
		Customer people[];
		Account accounts[];
		Mortgage mortgage[];
		CreditCard creditCard[];
		
		//DEFAULT CONSTRUCTOR
		public GEBank() {
			people = new Customer[4];
			accounts = new Account[4];
			mortgage = new Mortgage[4];
			creditCard = new CreditCard[4];
			}
		
		//LOAD CUSTOMERS FILE
	    void loadCustomers() throws IOException, FileNotFoundException, ParseException{
	        BufferedReader inputFile = new BufferedReader(new FileReader("Customers.txt"));
	        //String that holds current file line.
	        String custID = "", title = "", fName = "", lName = "", username = "", password = "", SSN = "", uniqueID = "", sightkey = "", 
	                houseNum = "", streetName = "", city = "", state = "", zipcode = "", phoneNum = "", email = "", line = "";
	
	        //Line number of count
	        int i = 0;
	
	        //Read the first customer
	        line = inputFile.readLine();

	        //load the array
	        while (line != null)
	        {   //Get each item from the line, stopping at the comma separator
	            StringTokenizer st = new StringTokenizer(line,",");

	            //Get each token and store it in the array
	            custID = st.nextToken();
	            title = st.nextToken();
	            fName = st.nextToken();
	            lName = st.nextToken();
	            username = st.nextToken();
	            password = st.nextToken();
	            SSN = st.nextToken();
	            uniqueID = st.nextToken();
	            sightkey = st.nextToken();
	            houseNum = st.nextToken();
	            streetName = st.nextToken();
	            city = st.nextToken();
	            state = st.nextToken();
	            zipcode = st.nextToken();
	            phoneNum = st.nextToken();
	            email = st.nextToken();

	            //Instantiate each customer
	            people[i] = new Customer(Integer.parseInt(custID), title, fName, lName, username, password, 
	                    Integer.parseInt(SSN), uniqueID, sightkey, Integer.parseInt(houseNum), streetName, 
	                    city, state, Integer.parseInt(zipcode), phoneNum, email);

	            //Get the next customer
	            i++;
	      
	            //Read the next customer
	            line = inputFile.readLine();
		    }
	            inputFile.close();
	    }
		
		//LOAD ACCOUNTS FILES
		void loadAccounts() throws IOException, FileNotFoundException, ParseException {
			BufferedReader inputFile = new BufferedReader(new FileReader("Accounts.txt"));
			//String that holds current file line.
			String custID = "", checkingAcctNum = "", savingsAcctNum = "", soarAcctNum = "", 
					creditCardAcctNum ="", mortgageAcctNum = "", carLoanAcctNum = "", 
					checkingAcctBal = "", savingsAcctBal = "", soarAcctBal = "",line = "";
			 
		 	//Line number of count
			int i = 0;
			
			//Read the first account
			line = inputFile.readLine();
				
			//load the array
			while (line != null)
			{	//Get each item from the line, stopping at the comma separator
				StringTokenizer st = new StringTokenizer(line,",");
				
				//Get each token and store it in the array
				custID = st.nextToken();
				checkingAcctNum = st.nextToken();
				savingsAcctNum = st.nextToken();
				soarAcctNum = st.nextToken();
				creditCardAcctNum = st.nextToken();
				mortgageAcctNum = st.nextToken();
				carLoanAcctNum = st.nextToken();
				checkingAcctBal = st.nextToken();
				savingsAcctBal = st.nextToken();
				soarAcctBal = st.nextToken();
	
				//Instantiate each customer account
				accounts[i] = new Account(Integer.parseInt(custID), Integer.parseInt(checkingAcctNum), Integer.parseInt(savingsAcctNum), 
								Integer.parseInt(soarAcctNum), creditCardAcctNum, Integer.parseInt(mortgageAcctNum), Integer.parseInt(carLoanAcctNum),
								Double.parseDouble(checkingAcctBal), Double.parseDouble(savingsAcctBal), Double.parseDouble(soarAcctBal));
		 
				//Get the next customer account
				i++;
				
				//Read the next customer account
				line = inputFile.readLine();
			}
				inputFile.close();
		}
		
		//LOAD MORTGAGE TEXT FILE
		void loadMortgage() throws IOException, FileNotFoundException, ParseException{
			BufferedReader inputFile = new BufferedReader(new FileReader("Mortgage.txt"));
			//String that holds current file line.
			String custID = "", mloanDate = "", homeValue = "", mortLoanAmount = "", mortAnnualInterestRate = "", mortLoanTerm = "", 
							mortMonthlyPayment = "", totalPayments = "", line = "";
				 
			 //Line number of count
			int i = 0;
			
			//Read the first customer
			line = inputFile.readLine();
					
			//load the array
			while (line != null){	
				//Get each item from the line, stopping at the comma separator
				StringTokenizer st = new StringTokenizer(line,",");
					
				//Get each token and store it in the array
				custID = st.nextToken();
				mloanDate = st.nextToken();
				homeValue = st.nextToken();
				mortLoanAmount = st.nextToken();
				mortAnnualInterestRate = st.nextToken();
				mortLoanTerm = st.nextToken();
				mortMonthlyPayment = st.nextToken();
				totalPayments = st.nextToken();
						
				//Instantiate each customer
				mortgage[i] = new Mortgage(Integer.parseInt(custID), mloanDate, Double.parseDouble(homeValue), Double.parseDouble(mortLoanAmount), 
				Double.parseDouble(mortAnnualInterestRate), Integer.parseInt(mortLoanTerm), Double.parseDouble(mortMonthlyPayment), Double.parseDouble(totalPayments));
				
				//Get the next customer
				i++;
				
				//Read the next customer
				line = inputFile.readLine();
			}
				inputFile.close();
				//System.out.println("The Customer Info file is loaded.");
		}
			
		//LOAD Credit Card Balance Information FILE
			void loadCC() throws IOException, FileNotFoundException, ParseException{
				BufferedReader inputFile = new BufferedReader(new FileReader("CreditCard.txt"));
				//String that holds current file line.
				String custID = "", loanDate = "", annualInterestRate = "", loanAmount = "", balance = "", loanTerm = "", ccMonthlyPayment = "", line = "";
				
			 	//Line number of count
				int i = 0;
				
				//Read the first customer
				line = inputFile.readLine();
					
				//load the array
				while (line != null)
				{	//Get each item from the line, stopping at the comma separator
					StringTokenizer st = new StringTokenizer(line,",");
					
					//Get each token and store it in the array
					custID = st.nextToken();
					loanDate = st.nextToken();
					annualInterestRate = st.nextToken();
					loanAmount = st.nextToken();
					balance = st.nextToken();
					loanTerm = st.nextToken();
					ccMonthlyPayment = st.nextToken();
						
					creditCard[i] = new CreditCard(Integer.parseInt(custID), loanDate, Float.parseFloat(annualInterestRate), Double.parseDouble(loanAmount), Double.parseDouble(balance), Integer.parseInt(loanTerm), Double.parseDouble(ccMonthlyPayment));
			 
					//Get the next customer
					i++;
					
					//System.out.println(username);
					//Read the next customer
					line = inputFile.readLine();
				}
					inputFile.close();
					//System.out.println("The Customer Info file is loaded.");
			}
		
		//DISPLAY LOGIN METHOD
		int login() throws IOException {	
			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
			DateFormat dateFormat = new SimpleDateFormat("E MM/dd/yyyy hh:mm:ss a");
			Date date = new Date();
			
			//int attempts = 0;
			String username = "", password = "";
			int customerindex = -1;	//-1 not found
			boolean match = false; //no match

			//Welcome the user to the system using the company name
			System.out.print("WELCOME TO GOLDEN EAGLE BANK.\n");
			
			//Display the current date and time
			System.out.println("\nToday's date and time is " + dateFormat.format(date));
			
			//Welcome the user to the system using the company name
			System.out.println("\n-- GOLDEN EAGLE BANK LOGIN MENU --\n");
			System.out.println("1: Login");
			System.out.println("2: Lost Bank Card");
			System.out.println("3: Exit");
			
			System.out.print("\nMake a selection from the above menu options: ");
			menuchoice = Integer.parseInt(input.readLine());
			 
			//Validate choice
			if (menuchoice < 0 || menuchoice > 3)
			{	System.out.println("\nERROR: Invalid Choice! Try Again!\n");
				login();
				}
			else
				{
				
				if (menuchoice == 1)
				{	
					//Display Customer Login Menu
					System.out.println("\n-- CUSTOMER LOGIN MENU --\n");
					
					//Get the customer's username and password
					System.out.print("Please enter your username: ");
					username = input.readLine();
		
					System.out.print("Please enter your password: ");
					password = input.readLine();
					
					//Loop through the Customer array to find a match
					for(int i = 0; i < people.length; i++)
					{ 	
						if (username.equals(people[i].getUsername()) && password.equals(people[i].getPassword()))
				
						//If a match is found, remember the index and welcome the customer by name
						{match = true;
						
						//Return the index number of the matched customer
						customerindex = i;
						
						//Welcome customer by name
						System.out.println("\nHello " + people[i].getTitle() + ". "+ people[i].getfName() + " " + people[i].getlName()+".");
						break; 
						}
					}
						if (!match){
				System.out.println("\nERROR: Invalid Username or Password! Please Try Again.");
				}
			} 
				//If menuchoice is 2, then show the lostCard method
				else if (menuchoice == 2){	
					lostCard();
				}
				//If menuchoice is 3, then exit program
				else if (menuchoice == 3){
					System.out.println("Goodbye! Thank you for using Golden Eagle Bank!");
					System.exit(0);
				}while (!match);
		}
			return customerindex;
			}

		
		//DISPLAY LOGIN MENU METHOD
		public void displayMainMenu(int customerindex) throws IOException {
			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
			/* Display a menu with the following choices: 
			 * 1) View account balance 
			 * 2) Make a payment
			 * 3) Deposit Check 
			 * 4) Transfer Funds 
			 * 5) Update profile information 
			 * 6) Exit the program
			 */
			System.out.println("\n-- GOLDEN EAGLE BANK MAIN MENU --\n");
			System.out.println("1: View Account Balances");
			System.out.println("2: Make a Payment");
			System.out.println("3: Deposit Check");
			System.out.println("4: Transfer Funds");
			System.out.println("5: Update Profile Information");
			System.out.println("6: Logout");
			
			//Get the user choice
			System.out.print("\nMake a selection from the above menu options: ");
			menuchoice = Integer.parseInt(input.readLine());
					
				//Validate choice
				if (menuchoice < 0 || menuchoice > 6)
				{	System.out.println("\nERROR: Invalid Choice! Try Again!\n");
					displayMainMenu(customerindex);
					}
				else
					{
					//If the menu choice is 1, call the displayBalance() method
					if (menuchoice == 1){
						displayBalance(customerindex);
						}
					//If the menu choice is 2, call the displayPayment() method, 
					else if	(menuchoice == 2){	
						displayPayment(customerindex);
						}
					//If the menu choice is 3, call depositFunds() method, 
					else if	(menuchoice == 3){	
						depositFunds(customerindex);
						}
					//If the menu choice is 4, call the transferFunds() method, 
					else if	(menuchoice == 4){	
						transferFunds(customerindex);
						}
					//If the menu choice is 5, call the updateProfile() method, 
					else if	(menuchoice == 5){	
						updateProfile(customerindex);
						}
					//If the menu choice is 6, system exit
			        else if (menuchoice == 6){
			        	System.out.println("\nThank you for banking with Golden Eagle Bank. Have a nice day!");
						System.exit(0);}	
			}
		}
		
		//UPDATE PROFILE INFORMATION
		void updateProfile(int customerindex) throws IOException {
			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
			DateFormat dateFormat = new SimpleDateFormat("E MM/dd/yyyy hh:mm:ss a");
			Date date = new Date();
			
			//Display the Account Balance Menu and ask user to make a selection
			System.out.println("\n-- UPDATE PROFILE MENU --\n");
			System.out.println("1: Update Username");
			System.out.println("2: Update Password");
			System.out.println("3: Terminate Action");
			
			System.out.print("\nMake a selection from the above menu options: ");
			menuchoice = Integer.parseInt(input.readLine());
			
			//Validate choice
			if (menuchoice < 0 || menuchoice > 3){	
				System.out.println("\nERROR: Invalid Choice! Try Again!\n");
				updateProfile(customerindex);
				}
			else
				{
				//Display the current date and time
				System.out.println("\nBusiness Date & Time: " + dateFormat.format(date));
						
				//If the menu choice is 1, update the customer's username
				if(menuchoice == 1){
				
					boolean match = false; //no match
					
					System.out.print("Enter old username: ");
					String username = input.readLine();
					System.out.print("Enter new username: ");
					newUsername = input.readLine();
					System.out.print("Confirm new username: ");
					String conUsername = input.readLine();
			
				//Loop through the Customer array to find a match
				for(int i = 0; i < people.length; i++)
					{ 	
					if (username.equals(people[i].getUsername()) && newUsername.equals(conUsername))
						{	
						//If a match is found, remember the index
						match = true;
			
						//Tell customer that their change has been successful
						updateUsername(customerindex);
						System.out.println("\n"+people[i].getTitle() + ". "+people[i].getlName()+", your username has been successfully changed.");
						break; 
						}
					}
					if(!match){
						//If a match is not found, exit the program
						System.out.println("Sorry, your name is not in the system.");
						System.exit(0);}
						
						//If match is found and change has been made, log customer out to re-login
						System.out.println("\nYou are being securely logged out. Please sign back in with your new username!\n");
						//Show login menu
						login();
				}
		
				//If the menu choice is 2, update customer's password
				else if	(menuchoice == 2){	
					boolean match = false; //no match
						
					System.out.print("Enter old password: ");
					String password = input.readLine();
					System.out.print("Enter new password: ");
					newPassword = input.readLine();
					System.out.print("Confirm new password: ");
					String conPassword = input.readLine();
					
				//Loop through the Customer array to find a match
				for(int i = 0; i < people.length; i++)
					{ 	
						if (password.equals(people[i].getPassword()) && newPassword.equals(conPassword)){	
							//If a match is found, remember the index
							match = true;
													
							//Tell customer that their change has been successful
							System.out.println(people[i].getTitle() + ". "+people[i].getlName()+", your password has been successfully changed.");
							updatePassword(customerindex);
							break;}
					}
						//If a match is not found, exit the program
						if(!match){	System.out.println("Sorry, your name is not in the system.");
								System.exit(0);}
						
						//If match is found and change has been made, log customer out to re-login
						System.out.println("You are being securely logged out. Please sign back in with your new password!\n");
						//Show login menu
						login();
				}
				
				//If the menu choice is 3, show Main Menu
				else if (menuchoice == 3){
					displayMainMenu(customerindex);}
			}
		}

		//DISPLAY BALANCE METHOD
		void displayBalance(int index) throws IOException {
			DateFormat dateFormat = new SimpleDateFormat("E MM/dd/yyyy hh:mm:ss a");
			Date date = new Date();
			
			//Display the current date and time
			System.out.println("\nBusiness Date & Time: " + dateFormat.format(date));
			
			//Show customer balance
			System.out.println("\n" + people[index].getTitle() + ". " + people[index].getlName() + ", please review your balance below.");
			System.out.println("Checking Account#: " + accounts[index].getCheckingAcctNum()+"| Checking Account Balance: $"+accounts[index].getCheckingAcctBal()+".");	
			System.out.println("Savings Account#: " + accounts[index].getSavingsAcctNum()+"| Savings Account Balance: $"+accounts[index].getSavingsAcctBal()+".");	
			System.out.println("Soar Account#: " + accounts[index].getSoarAcctNum()+"| SOAR Account Balance: $"+accounts[index].getSoarAcctBal()+".");
					
			displayMainMenu(index);
		}
		
		//DEPOSIT FUNDS
		void depositFunds(int index) throws NumberFormatException, IOException {
			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
			DateFormat dateFormat = new SimpleDateFormat("E MM/dd/yyyy hh:mm:ss a");
			Date date = new Date();

			int accountChoice = -1;
			
		do
			{
			//Display the Account Balance Menu and ask user to make a selection
			System.out.println("\n-- CHECK DEPOSIT MENU --\n");
			System.out.println("1: Upload Check Image");
			System.out.println("2: Terminate Transaction");
			
			System.out.print("\nMake a selection from the above menu options: ");
			menuchoice = Integer.parseInt(input.readLine());
			
			//Validate choice
			if (menuchoice < 0 || menuchoice > 2) //|| accountChoice < 0 || accountChoice > 3)
			{	System.out.println("\nERROR: Invalid Choice! Try Again!\n");
				depositFunds(index);
				}
			else
				{
				//Display the current date and time
				System.out.println("\nBusiness Date & Time: " + dateFormat.format(date));
				
				//If the menu choice is 1, show checking account balance
			if(menuchoice == 1) {
			
				System.out.print("\nInput the amount of your check: ");	
				checkAmount = Double.parseDouble(input.readLine());
				
				System.out.println("\n1: Checking Account");
				System.out.println("2: Savings Account");
				System.out.println("3: Soar Account");
				
				System.out.print("\nDeposit to which account?: ");
				accountChoice = Integer.parseInt(input.readLine());
				//Validate choice
				if (accountChoice < 0 || accountChoice > 3) {	
					System.out.println("\nERROR: Invalid Choice! Try Again!\n");
					depositFunds(index);
					}
				else
					{
					
			if (accountChoice == 1){
				System.out.println("\nYou have successfully deposited " + checkAmount+" to your Checking Account.");
				//DEPOSIT TO CHECKING ACCOUNT
				DTChecking += checkAmount;}
			else if (accountChoice == 2){
				System.out.println("\nYou have successfully deposited $" + checkAmount+" to your Savings Account.");
				//DEPOSIT TO SAVINGS ACCOUNT
				DTSavings += checkAmount;}
			else if (accountChoice == 2){
				System.out.println("\nYou have successfully deposited $" + checkAmount+" to your Soar Account.");
				//DEPOSIT TO SOAR ACCOUNT
				DTSoar += checkAmount;}
			}
			}
			//If menu choice is 2, displayMainMenu method,
			else if(menuchoice == 2){
				displayMainMenu(index);
			}
				calculateBalances(index);
		}
				//Ask customer if they would like to deposit another check
				System.out.print("\nWould you like to make another check deposit? [Enter Y/y, N/n]: ");
				moredeposits = input.readLine().charAt(0);
				
			}while (moredeposits == 'Y' || moredeposits == 'y');
		
				//If more deposits is no, then show displayLoginMenu method
			if (moredeposits == 'N' || moredeposits == 'n')
				
				//Show the Main Menu
				{ displayMainMenu(index);}
			else{
				System.out.println("\nERROR: Invalid Input! Try Again!");
				
				//Show the Main Menu
				displayMainMenu(index);
			}
		}
		
		//TRANSFER FUNDS METHOD
		void transferFunds(int index) throws IOException {
			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
			DateFormat dateFormat = new SimpleDateFormat("E MM/dd/yyyy hh:mm:ss a");
			Date date = new Date();
			
			int transferchoice = -1;
			
		do {
			System.out.println("\n-- TRANSFER FUNDS MENU --\n");
			System.out.println("1: Checking Account to Savings Account");
			System.out.println("2: Savings Account to Checking Account");
			System.out.println("3: Checking Account to Soar Account");
			System.out.println("4: Savings Account to Soar Account");
			System.out.println("5: Terminate Transaction");		
				
			System.out.print("\nMake a selection from the above menu options: ");
			transferchoice = Integer.parseInt(input.readLine());
			
			//Validate choice
			if (transferchoice < 0 || transferchoice > 5) {	
				System.out.println("\nERROR: Invalid Choice! Try Again!\n");
				transferFunds(index);
				}
			else
				{
				
			//Show account accounts and balances of customer
			System.out.println("\n-- ACCOUNT BALANCES --\n");
			System.out.println("Checking Account No.: " + accounts[index].getCheckingAcctNum() + " | Checking Account Balance: $" + accounts[index].getCheckingAcctBal());	
			System.out.println("Savings Account No.: " + accounts[index].getSavingsAcctNum() + " | Savings Account Balance: $" + accounts[index].getSavingsAcctBal());	
			System.out.println("Soar Account No.: " + accounts[index].getSoarAcctNum() + " | Soar Account Balance: $" + accounts[index].getSoarAcctBal());	
				
			System.out.println("\nHow much would you like to transfer?");
			transferAmount = Double.parseDouble(input.readLine());
				
			System.out.println("\nBusiness Date & Time: " + dateFormat.format(date));
			
			//If transfer choice is 1, calculate new checking account balance
			if(transferchoice == 1){
				System.out.println("\nYou've chosen to transfer $" + transferAmount + " from your Checking Account to your Savings Account.");
				FCA -= transferAmount;
				TSA += transferAmount;
				}
				
			//If transfer choice is 2, calculate new savings account balance
			else if(transferchoice == 2){	
				System.out.println("\nYou've chosen to transfer $" + transferAmount + " from your Savings Account to your Checking Account.");
				FSA =- transferAmount;
				TCA =+ transferAmount;
				}
				
				//If transfer choice is 3, calculate new soar account balance
			else if(transferchoice == 3){	
				System.out.println("\nYou've chosen to transfer $" + transferAmount + " from your Checking Account to your Soar Account.");
				FCA =- transferAmount;
				TSoA =+ transferAmount;
				}
				
				//If transfer choice is 4, calculate new soar account balance
			else if(transferchoice == 4){	
				System.out.println("\nYou've chosen to transfer $" + transferAmount + " from your Savings Account to your Soar Account.");
				FSA =- transferAmount;
				TSoA =+ transferAmount;
				}
				
			else if (transferchoice == 5){
				System.out.println("\nYou are now being returned to the Main Menu.\n");
				displayMainMenu(index);	
				}
			
				calculateBalances(index);
		}
		calculateBalances(index);
		
			//If transfer amount is more than balance amount, 
			if(accounts[index].getCheckingAcctBal() < transferAmount && accounts[index].getSavingsAcctBal() < transferAmount){
				System.out.println("We're sorry, you do not have sufficient funds to complete this transaction.  Transaction Cancelled.\n\n");
				return;
				}
			
				//Ask customer if they would like to make another transfer
				System.out.print("\nDo you want to make another transfer? [Enter y/n]: ");
				moretransfers = input.readLine().charAt(0);
			} while (moretransfers == 'Y' || moretransfers == 'y');
		
			//If moretransfers is no, then show displayLoginMenu method
			if (moretransfers == 'N' || moretransfers == 'n'){
				//Show the Main Menu
				displayMainMenu(index);
				}
		else {
			System.out.println("\nERROR: Invalid Input! Try Again!");
			//Show the Main Menu
			System.out.println("\nYou are now being returned to the Main Menu.\n");
			displayMainMenu(index);
			}
				
		}
		
		
		//DISPLAY PAYMENT METHOD
		void displayPayment(int index) throws NumberFormatException, IOException{
			
			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
			
			DateFormat dateFormat = new SimpleDateFormat("E MM/dd/yyyy hh:mm:ss a");
			Date date = new Date();
			
			//CHOICE
			int paymentChoice = 0;
			
			//double d = 1.234567;
	        DecimalFormat df = new DecimalFormat("#.##");
	         
			//LOAN AMOUNTS
			//double principal = mortgage[index].getMortLoanAmount();//MORTGAGE LOAN AMOUNT
			double principal = mortgage[index].getTotalPayments() + mortgage[index].getMortLoanAmount();
			double principal2 = creditCard[index].getBalance();//CREDIT CARD LOAN AMOUNT
			
			//MORTGAGE INFORMATION
			//double monthlyInterestRate = mortgage[index].getMortAnnualInterestRate() / 1200;//MONTHLY INTEREST RATE
			//int termInMonths = mortgage[index].getMortLoanTerm(); //Loan Term
			
			//DISPLAY PAYMENT MENU
			System.out.println("\n-- VIEW PAYMENT MENU --\n");
			System.out.println("1: Mortgage Payment");
			System.out.println("2: Credit Card Payment");
			System.out.println("3: Terminate Transaction");
			//System.out.println("4: Exit");
			
			System.out.print("\nMake a selection from the above menu options: ");
			paymentChoice = Integer.parseInt(input.readLine());
			
			switch(paymentChoice) {
				case 1:
					System.out.println("\n" + people[index].getTitle() + ". " + people[index].getlName() + ", please review your mortgage information below.");
					
					//Display the current date and time
					//System.out.println("\nBusiness Date & Time: " + dateFormat.format(date));
					
					//CALCULATE PAYMENT
					/*double monthlyPayment = principal * (monthlyInterestRate * Math.pow((1 + monthlyInterestRate), termInMonths) / 
							(Math.pow((1 + monthlyInterestRate), termInMonths) - 1));*/
					
					System.out.println("Your monthly payment is $" + /*df.format(monthlyPayment)*/ mortgage[index].getMortMonthlyPayment() + "\nTotal principal with interest paid will be: $" + df.format(mortgage[index].getTotalPayments() + mortgage[index].getMortLoanAmount()));
				
					//Prompt user to enter information
					System.out.print("Please enter payment amount: ");
					double mortPayment = Double.parseDouble(input.readLine());
					MFC -= mortPayment;
					calculateBalances(index);
					
					System.out.println("You have entered $ " + mortPayment);
					
					//The rest of the payment goes to principal
					String loanBalance = df.format(principal - mortPayment);
					System.out.println("Your new balance is $" + loanBalance);
					displayPayment(index);
					break;//??? Something going on with the break. Keeps displaying the display balance method.
					
				case 2:
					System.out.println("\n" + people[index].getTitle() + ". " + people[index].getlName() + ", please review your credit card information below:");
					
					//Display the current date and time
					System.out.println("\nBusiness Date & Time: " + dateFormat.format(date));
					
					//Display Credit Card Account Information
					System.out.println("\nCredit Card Account#: " + accounts[index].getCreditCardAcctNum() + "\nYour monthly payment is $" + creditCard[index].getCcMonthlyPayment() + ".");
					
					System.out.print("Please enter payment amount: ");
					double ccPayment = Double.parseDouble(input.readLine());
					CFC -= ccPayment;
					calculateBalances(index);
					
					//Prompt user to enter information
					System.out.println("You have entered $" + ccPayment);
					
					//The rest of the payment goes to principal
					double ccBalance = principal2 - ccPayment;
					System.out.println("Your new balance is $" + ccBalance);
					displayPayment(index);
					break; //??? Something going on with the break. Keeps displaying the display balance method.
				case 3:
					displayMainMenu(index);
				/*case 4:
					System.out.println("\nThank you for using the program. Have a nice day!");
					System.exit(0);*/
				default:
					System.out.println("ERROR: Invalid Choice! Try Again!");
				}
			}
	
		//LOST CARD LOGIN METHOD
		int lostCard() throws IOException {
			BufferedReader inputScreen = new BufferedReader(new InputStreamReader(System.in));
			
			int customerindex = -1;
			boolean match = false; //no match
			
			String SSN = "", uniqueID = "", sightkey = "";
			
			System.out.println("\n-- LOST CARD LOGIN MENU --\n");
			//Get the user's SSN#, uniqueID and sightkey
			System.out.print("Please enter the last four digits of your SSN#: ");
			SSN = inputScreen.readLine();
			System.out.print("Please enter your unique ID: ");
			uniqueID = inputScreen.readLine();
			System.out.print("Please enter your Sight Key: ");
			sightkey = inputScreen.readLine();
			
				for(int i = 0; i < people.length; i++)
					{	
				if ((Integer.parseInt(SSN) == people[i].getSSN()) && uniqueID.equals(people[i].getUniqueID()) && sightkey.equals(people[i].getSightkey())){
					
					//If a match is found, remember the index and welcome the customer by name
					match = true;
					
					//Return the index number of the matched customer
					{customerindex = i;}
					System.out.println("\nWelcome " + people[i].getTitle() + ". "+ people[i].getfName() + " " + people[i].getlName()+".");
					displayLostCardMenu(customerindex);
					break; 
				}
					}
				if(!match){
					//If a match is not found, exit the program
					System.out.println("Sorry, your name is not in the system.");
					System.exit(0);}
		return customerindex;
		}
		
		//DISPLAY LOST CARD MENU
		public void displayLostCardMenu(int customerindex) throws IOException {
			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

			//Display a menu with the following choices: 1) View account balance, 2) Withdraw Funds
			// 3) Contact Bank and 4) Exit the program
			System.out.println("\n-- GOLDEN EAGLE BANK LOST CARD MENU --\n");
			System.out.println("1: View Account Balance");
			System.out.println("2: Withdraw Funds");
			System.out.println("3: Contact Bank");
			
			//Get the user choice
			{	System.out.print("\nMake a selection from the above menu options: ");
				menuchoice = Integer.parseInt(input.readLine());
					
				//Validate choice
				if (menuchoice < 0 || menuchoice > 3)
				{	System.out.println("\nERROR: Invalid Choice! Try Again!\n");
					displayLostCardMenu(customerindex);
					}
				else
					{
					//If the menu choice is 1, call the displayBalance() method,
					if (menuchoice == 1){
						displayBalance(customerindex);
					}
					//If the menu choice is 2, call the withdrawFunds() method, 
					else if	(menuchoice == 2){	
						withdrawFunds(customerindex);
					}
					//If menu choice is 3, send message
					else if (menuchoice == 3){
						System.out.println("\nGolden Eagle Bank has been informed that your card is lost. A Bank Supervisor will contact you"
								+ " when the bank opens in the morning.");
					}
				}
		    }
		}

		//DISPLAY WITHDRAW FUNDS FOR LOST CARD METHOD
		public void withdrawFunds(int index) throws NumberFormatException, IOException {
			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
			DateFormat dateFormat = new SimpleDateFormat("E MM/dd/yyyy hh:mm:ss a");
			Date date = new Date();
			
			int accountChoice = -1;
		
			System.out.print("\nEnter Withdraw Amount: ");	
			withdrawAmount = Double.parseDouble(input.readLine());
			
			System.out.println("\n1: Checking Account");
			System.out.println("2: Savings Account");
			
			System.out.print("\nWithdraw from which account?: ");
			accountChoice = Integer.parseInt(input.readLine());
			
			{
				
			//Validate choice
			if (accountChoice < 0 || accountChoice > 2)
			{	System.out.println("\nERROR: Invalid Choice! Try Again!\n");
				withdrawFunds(index);
				}
			else
				{
				//Display the current date and time
				System.out.println("\nBusiness Date & Time: " + dateFormat.format(date));
			
			if 	(accountChoice == 1){
				System.out.println("\nYou have successfully withdrawn $"+withdrawAmount+" from your Checking Account.");
				//WITHDRAW FROM CHECKING ACCOUNT
				WFChecking -= withdrawAmount;
				calculateBalances(index);
			}
				
				else if (accountChoice == 2){
				System.out.println("\nYou have successfully withdrawn $"+withdrawAmount+" from your Savings Account.");
				//WITHDRAW FROM SAVINGS ACCOUNT
				WFSavings -= withdrawAmount;
				calculateBalances(index);
				}
			
			if	(withdrawAmount < 0  &&  withdrawAmount > 300){
				System.out.println("We're sorry, you are only authorized to withdraw a maximum amount of $300.00. Transaction Cancelled.\n\n");
				return;
				}

				//If transfer amount is more than balance amount, 
			if	(accounts[index].getCheckingAcctBal() < withdrawAmount && accounts[index].getSavingsAcctBal() < withdrawAmount){
					System.out.println("We're sorry, you do not have sufficient funds to complete this transaction. Transaction Cancelled.\n\n");
					return;
					//displayMainMenu(index);
					 
					}	
				}
			}
			//displayMainMenu(index);
		}
		
		//CALCULATE NEW BALANCES
		void calculateBalances(int index) throws IOException
		{ 
			//CALCULATE ACCOUNT BALANCES
			//Calculate newCB - new Checking Account Balance
		 	newCB = accounts[index].getCheckingAcctBal() + FCA + TCA + MFC + CFC +  DTChecking + WFChecking;
		 	
		 	//Calculate newSB - new Savings Account Balance
		 	newSB = accounts[index].getSavingsAcctBal() + FSA + TSA + DTSavings + WFSavings;
		 	
		 	//Calculate new SoB - new Soar Account Balance
		 	newSoB = accounts[index].getSoarAcctBal() + TSoA;
			saveFiles(index);
		}
		
		//SAVE NEW BALANCES IN ACCOUNTS FILE AND WRITE TO TRANSACTION FILE
		void saveFiles(int index) throws IOException {
			
			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a");
			Date date = new Date();
			
			//Write to transaction file
			BufferedWriter tw = new BufferedWriter(new FileWriter("Transactions.txt", true));
			
			//Update accounts file
			BufferedReader br = new BufferedReader(new FileReader(new File("Accounts.txt")));     
	        
	        String ccd = accounts[index].getCreditCardAcctNum();
	        String line = null;
	        StringBuilder sb =new StringBuilder();
	        while ((line = br.readLine())!=null) 
	        {
	            if(line.indexOf(ccd)!=-1)
	            {
	            	//update Accounts File           	
	            	sb.append(accounts[index].getCustID() + "," +accounts[index].getCheckingAcctNum() + "," +accounts[index].getSavingsAcctNum() + ","
	            	+accounts[index].getSoarAcctNum()+ "," +accounts[index].getCreditCardAcctNum() + "," +accounts[index].getMortgageAcctNum() + ","
	            	+accounts[index].getCarLoanAcctNum() + ","+  newCB + "," + newSB + "," + newSoB +"\r\n");
	         }else{
	                sb.append(line+"\r\n");
	            }
	        } 
	        br.close();
	        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("Accounts.txt")));
	        PrintWriter out = new PrintWriter(bw);
	        out.print(sb.toString());
	        out.flush();
	        out.close();
	        
	        //Write to transaction File
	        PrintWriter output = new PrintWriter(tw);
			
	        output.write((people[index].getCustID() + "," + dateFormat.format(date) + "," + accounts[index].getSavingsAcctNum() + "," + TSA + "," +"Transfer To Savings\r\n"));
			output.write((people[index].getCustID() + "," + dateFormat.format(date) + "," + accounts[index].getCheckingAcctNum() + "," + TCA + "," + "Transfer To Checking\r\n"));
			output.write((people[index].getCustID() + "," + dateFormat.format(date) + "," + accounts[index].getSavingsAcctNum() + "," + checkAmount + "," + "Deposit\r\n"));
			output.write((people[index].getCustID() + "," + dateFormat.format(date) + "," + accounts[index].getSavingsAcctNum() + "," + withdrawAmount+ "," + "Withdraw\r\n"));
			output.write((people[index].getCustID() + "," + dateFormat.format(date) + "," + accounts[index].getCheckingAcctNum() + "," + MFC + "," + "Mortgage Payment\r\n"));
			output.write((people[index].getCustID() + "," + dateFormat.format(date) + "," + accounts[index].getCheckingAcctNum() + "," + CFC + "," + "Credit Card Payment\r\n"));
			output.flush();
			output.close();
	        }
		
		//UPDATE USERNAME
        void updateUsername (int index) throws IOException{
        	BufferedReader br = new BufferedReader(new FileReader(new File("Customers.txt")));     
	        
	        String uname = people[index].getUsername();
	        String line = null;
	        StringBuilder sb =new StringBuilder();
	        while ((line = br.readLine())!=null) 
	        {
	            if(line.indexOf(uname)!=-1)
	            {
	            	//update people[index] with new username
		               sb.append(people[index].getCustID() + "," +people[index].getTitle() + "," +people[index].getfName() + "," + people[index].getlName()+ ","
		                        + newUsername + "," + people[index].getPassword() + "," + people[index].getSSN() + "," + people[index].getUniqueID() + ","
		                        + people[index].getSightkey() + ","+  people[index].getHouseNum() + "," + people[index].getStreetName() + "," 
		                        + people[index].getCity()+"," + people[index].getState() + "," + people[index].getZipcode() + "," + people[index].getPhoneNum() + ","
		                        + people[index].getEmail()+"\r\n"); 
	            }else{
	                sb.append(line+"\r\n");
	            }
	        } 
	        br.close();
	        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("Customers.txt")));
	        PrintWriter out = new PrintWriter(bw);
	        out.print(sb.toString());
	        out.flush();
	        out.close();
        }
        
        //UPDATE PASSWORD
        void updatePassword (int index) throws IOException{
        	BufferedReader br = new BufferedReader(new FileReader(new File("Customers.txt")));     
	        
	        String uname = people[index].getUsername();
	        String line = null;
	        StringBuilder sb =new StringBuilder();
	        while ((line = br.readLine())!=null) 
	        {
	            if(line.indexOf(uname)!=-1)
	            {
	            	//update people[index] with new password
		               sb.append(people[index].getCustID() + "," +people[index].getTitle() + "," +people[index].getfName() + ","+people[index].getlName()+ ","
		                        + people[index].getUsername()+ "," + newPassword + ","+people[index].getSSN() + ","+people[index].getUniqueID() + ","
		                        + people[index].getSightkey() + ","+  people[index].getHouseNum() + "," + people[index].getStreetName() + "," 
		                        + people[index].getCity()+"," + people[index].getState() + "," + people[index].getZipcode() + "," + people[index].getPhoneNum() + ","
		                        + people[index].getEmail()+"\r\n"); 
	            }else{
	                sb.append(line+"\r\n");
	            }
	        } 
	        br.close();
	        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("Customers.txt")));
	        PrintWriter out = new PrintWriter(bw);
	        out.print(sb.toString());
	        out.flush();
	        out.close();
        }
}
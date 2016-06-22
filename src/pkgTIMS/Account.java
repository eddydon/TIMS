package pkgTIMS;

public class Account {
	private int custID;
	//Account Numbers
	private int checkingAcctNum;
	private int savingsAcctNum;
	private int soarAcctNum;
	private String creditCardAcctNum;
	private int mortgageAcctNum;
	private int carLoanAcctNum;
	//Balances
	private double checkingAcctBal;
	private double savingsAcctBal;
	private double soarAcctBal;

	//DEFAULT CONSTRUCTORS
	public Account() {
		custID = 0;
		checkingAcctNum = 0;
		savingsAcctNum = 0;
		soarAcctNum = 0;
		creditCardAcctNum = "";
		mortgageAcctNum = 0;
		carLoanAcctNum = 0;
		checkingAcctBal = 0;
		savingsAcctBal = 0;
		soarAcctBal = 0;
	}
	
	//OVERLOADED CONSTRUCTOR
	public Account(int custID, int checkingAcctNum, int savingsAcctNum,
			int soarAcctNum, String creditCardAcctNum, int mortgageAcctNum,
			int carLoanAcctNum, double checkingAcctBal, double savingsAcctBal,
			double soarAcctBal) {
		super();
		this.custID = custID;
		this.checkingAcctNum = checkingAcctNum;
		this.savingsAcctNum = savingsAcctNum;
		this.soarAcctNum = soarAcctNum;
		this.creditCardAcctNum = creditCardAcctNum;
		this.mortgageAcctNum = mortgageAcctNum;
		this.carLoanAcctNum = carLoanAcctNum;
		this.checkingAcctBal = checkingAcctBal;
		this.savingsAcctBal = savingsAcctBal;
		this.soarAcctBal = soarAcctBal;
	}
	
	//GETTERS AND SETTERS
	public int getCustID() {
		return custID;
	}
	public void setCustID(int custID) {
		this.custID = custID;
	}
	public int getCheckingAcctNum() {
		return checkingAcctNum;
	}
	public void setCheckingAcctNum(int checkingAcctNum) {
		this.checkingAcctNum = checkingAcctNum;
	}
	public int getSavingsAcctNum() {
		return savingsAcctNum;
	}
	public void setSavingsAcctNum(int savingsAcctNum) {
		this.savingsAcctNum = savingsAcctNum;
	}
	public int getSoarAcctNum() {
		return soarAcctNum;
	}
	public void setSoarAcctNum(int soarAcctNum) {
		this.soarAcctNum = soarAcctNum;
	}
	public String getCreditCardAcctNum() {
		return creditCardAcctNum;
	}
	public void setCreditCardAcctNum(String creditCardAcctNum) {
		this.creditCardAcctNum = creditCardAcctNum;
	}
	public int getMortgageAcctNum() {
		return mortgageAcctNum;
	}
	public void setMortgageAcctNum(int mortgageAcctNum) {
		this.mortgageAcctNum = mortgageAcctNum;
	}
	public int getCarLoanAcctNum() {
		return carLoanAcctNum;
	}
	public void setCarLoanAcctNum(int carLoanAcctNum) {
		this.carLoanAcctNum = carLoanAcctNum;
	}
	public double getCheckingAcctBal() {
		return checkingAcctBal;
	}
	public void setCheckingAcctBal(double checkingAcctBal) {
		this.checkingAcctBal = checkingAcctBal;
	}
	public double getSavingsAcctBal() {
		return savingsAcctBal;
	}
	public void setSavingsAcctBal(double savingsAcctBal) {
		this.savingsAcctBal = savingsAcctBal;
	}
	public double getSoarAcctBal() {
		return soarAcctBal;
	}
	public void setSoarAcctBal(double soarAcctBal) {
		this.soarAcctBal = soarAcctBal;
	}	
}
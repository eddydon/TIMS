package pkgTIMS;

public class CreditCard {
	private int custID;
	private String loanDate;
	private float annualInterestRate;
	private double loanAmount;
	private double balance;
	private int loanTerm;
	private double ccMonthlyPayment;
	
	/** Default Constructor */
	public CreditCard(){
		custID = 0;
		loanDate = "";
		annualInterestRate = 0.00f;
		loanAmount = 0;
		balance = 0;
		loanTerm = 0;
		ccMonthlyPayment = 0;
	}
	
	/**Overloaded Constructor */
	public CreditCard(int custID,String loanDate, float annualInterestRate, double loanAmount, double balance, int loanTerm, double ccMonthlyPayment){
		this.custID = custID;
		this.loanDate = loanDate;
		this.annualInterestRate = annualInterestRate;
		this.loanAmount = loanAmount;
		this.balance = balance;
		this.loanTerm = loanTerm;
		this.ccMonthlyPayment = ccMonthlyPayment;
	}

	/**
	 * @return the custID
	 */
	public int getCustID() {
		return custID;
	}

	/**
	 * @param custID the custID to set
	 */
	public void setCustID(int custID) {
		this.custID = custID;
	}

	/**
	 * @return the loanDate
	 */
	public String getLoanDate() {
		return loanDate;
	}

	/**
	 * @param loanDate the loanDate to set
	 */
	public void setLoanDate(String loanDate) {
		this.loanDate = loanDate;
	}

	/**
	 * @return the annualInterestRate
	 */
	public float getAnnualInterestRate() {
		return annualInterestRate;
	}

	/**
	 * @param annualInterestRate the annualInterestRate to set
	 */
	public void setAnnualInterestRate(float annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}

	/**
	 * @return the loanAmount
	 */
	public double getLoanAmount() {
		return loanAmount;
	}

	/**
	 * @param loanAmount the loanAmount to set
	 */
	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}

	/**
	 * @return the balance
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * @param balance the balance to set
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}

	/**
	 * @return the loanTerm
	 */
	public int getLoanTerm() {
		return loanTerm;
	}

	/**
	 * @param loanTerm the loanTerm to set
	 */
	public void setLoanTerm(int loanTerm) {
		this.loanTerm = loanTerm;
	}
	
	/**
	 * @return the ccMonthlyPayment
	 */
	public double getCcMonthlyPayment() {
		return ccMonthlyPayment;
	}

	/**
	 * @param ccMonthlyPayment the ccMonthlyPayment to set
	 */
	public void setCcMonthlyPayment(double ccMonthlyPayment) {
		this.ccMonthlyPayment = ccMonthlyPayment;
	}
}

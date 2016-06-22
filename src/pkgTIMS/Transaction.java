package pkgTIMS;

public class Transaction {
	
	private int transNum;
	private String transType;
	private String transDate;
		
	//DEFAULT CONSTRUCTORS
	public Transaction() {
		transNum = 0;
		transType = "";
		transDate = "";
	}
	
	//OVERLOADED CONSTRUCTORS
	public Transaction(int transNum, String transType, String transDate) {
		super();
		this.transNum = transNum;
		this.transType = transType;
		this.transDate = transDate;
	}
	//GETTERS AND SETTERS
	public int getTransNum() {
		return transNum;
	}
	public void setTransNum(int transNum) {
		this.transNum = transNum;
	}
	public String getTransType() {
		return transType;
	}
	public void setTransType(String transType) {
		this.transType = transType;
	}
	public String getTransDate() {
		return transDate;
	}
	public void setTransDate(String transDate) {
		this.transDate = transDate;
	}	
}
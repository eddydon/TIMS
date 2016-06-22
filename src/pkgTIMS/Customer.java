package pkgTIMS;

public class Customer {
		private int custID;
		//Variables WITH card
		private String title;
		private String fName;
		private String lName;
		private String username;
		private String password;
		//Variables WITHOUT card
		private int SSN;
		private String uniqueID;
		private String sightkey;
		//Address
		private int houseNum;
		private String streetName;
		private String city;
		private String state;
		private int zipcode;
		private String phoneNum;
		private String email;
		
		//DEFAULT CONSTRUCTORS
		public Customer() {
			custID = 0;
			title = "";
			fName = "";
			lName = "";
			username = "";
			password = "";
			SSN = 0;
			uniqueID = "";
			sightkey = "";
			houseNum = 0;
			streetName = "";
			city = "";
			state = "";
			zipcode = 0;
			phoneNum = "";
			email = "";
		}

		//OVERLOADED CONSTRUCTORS
		public Customer(int custID, String title, String fName, String lName,
				String username, String password, int sSN, String uniqueID,
				String sightkey, int houseNum, String streetName, String city,
				String state, int zipcode, String phoneNum, String email) {
			super();
			this.custID = custID;
			this.title = title;
			this.fName = fName;
			this.lName = lName;
			this.username = username;
			this.password = password;
			SSN = sSN;
			this.uniqueID = uniqueID;
			this.sightkey = sightkey;
			this.houseNum = houseNum;
			this.streetName = streetName;
			this.city = city;
			this.state = state;
			this.zipcode = zipcode;
			this.phoneNum = phoneNum;
			this.email = email;
		}
		
		//GETTERS AND SETTERS
		public int getCustID() {
			return custID;
		}
		public void setCustID(int custID) {
			this.custID = custID;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getfName() {
			return fName;
		}
		public void setfName(String fName) {
			this.fName = fName;
		}
		public String getlName() {
			return lName;
		}
		public void setlName(String lName) {
			this.lName = lName;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public int getSSN() {
			return SSN;
		}
		public void setSSN(int sSN) {
			SSN = sSN;
		}
		public String getUniqueID() {
			return uniqueID;
		}
		public void setUniqueID(String uniqueID) {
			this.uniqueID = uniqueID;
		}
		public String getSightkey() {
			return sightkey;
		}
		public void setSightkey(String sightkey) {
			this.sightkey = sightkey;
		}
		public int getHouseNum() {
			return houseNum;
		}
		public void setHouseNum(int houseNum) {
			this.houseNum = houseNum;
		}
		public String getStreetName() {
			return streetName;
		}
		public void setStreetName(String streetName) {
			this.streetName = streetName;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getState() {
			return state;
		}
		public void setState(String state) {
			this.state = state;
		}
		public int getZipcode() {
			return zipcode;
		}
		public void setZipcode(int zipcode) {
			this.zipcode = zipcode;
		}
		public String getPhoneNum() {
			return phoneNum;
		}
		public void setPhoneNum(String phoneNum) {
			this.phoneNum = phoneNum;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}	
}
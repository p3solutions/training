package Prgm;

public class PojoClass {
			private String userName;
		private double bankBal;
		
		PojoClass(String userName,double bankBal){
			this.userName=userName;
			this.bankBal=bankBal;
		}
		
		
		


		public double getBankBal() {
			return bankBal;
		}
		public void setBankBal(double bankBal) {
			this.bankBal = bankBal;
		}
	    

		public String getUserName() {
			return userName;
		}


		public void setUserName(String userName) {
			this.userName = userName;
		}


		
	}




package ex1;

public class Account {
	String accountNumber;
	int balance;
	
	@Override
	public boolean equals(Object o) {
		if (this == o) { return true; }
		if (o instanceof Account a) {
			String num = a.accountNumber.trim();
			if (this.accountNumber.equals(num)) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "¥" + this.balance + "(口座番号:" +
	            this.accountNumber + ")";
	}
}	

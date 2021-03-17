package in.zubairshaikh.model;

public class BankCardData {

	private String bankDetails;

	public String getBankDetails() {
		return bankDetails;
	}

	public void setBankDetails(String bankDetails) {
		this.bankDetails = bankDetails;
	}

	@Override
	public String toString() {
		return "BankCard [bankDetails=" + bankDetails + "]";
	}

}

package in.zubairshaikh.model;

public class BankCard {
	
	private String bank;
	private String cardNumber;
	private String expiryDate;
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}
	public BankCard(String bank, String cardNumber, String expiryDate) {
		super();
		this.bank = bank;
		this.cardNumber = cardNumber;
		this.expiryDate = expiryDate;
	}
	
	

}

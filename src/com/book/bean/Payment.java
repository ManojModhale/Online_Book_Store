package com.book.bean;

public class Payment 
{
	private String username;
	private String cardNumber;
	private String expiryDate;
	private String cvv;
	private String address;
	private String city;
	private String pinCode;
	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Payment(String username, String cardNumber, String expiryDate, String cvv, String address, String city,
			String pinCode) {
		super();
		this.username = username;
		this.cardNumber = cardNumber;
		this.expiryDate = expiryDate;
		this.cvv = cvv;
		this.address = address;
		this.city = city;
		this.pinCode = pinCode;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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
	public String getCvv() {
		return cvv;
	}
	public void setCvv(String cvv) {
		this.cvv = cvv;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPinCode() {
		return pinCode;
	}
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	@Override
	public String toString() {
		return "Payment [username=" + username + ", cardNumber=" + cardNumber + ", expiryDate=" + expiryDate + ", cvv="
				+ cvv + ", address=" + address + ", city=" + city + ", pinCode=" + pinCode + "]";
	}

	
}

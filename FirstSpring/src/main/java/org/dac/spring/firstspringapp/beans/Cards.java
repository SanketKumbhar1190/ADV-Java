package org.dac.spring.firstspringapp.beans;

public class Cards {
	
	int cardNo;
	String expiry;
	float balance;
	
	public Cards() {
		System.out.println("default ctor of cards");
	}

	public int getCardNo() {
		return cardNo;
	}

	public void setCardNo(int cardNo) {
		this.cardNo = cardNo;
	}

	public String getExpiry() {
		return expiry;
	}

	public void setExpiry(String expiry) {
		this.expiry = expiry;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Cards [cardNo=" + cardNo + ", expiry=" + expiry + ", balance=" + balance + "]";
	}
	
}

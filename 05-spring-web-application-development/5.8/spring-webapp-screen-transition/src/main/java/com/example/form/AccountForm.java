package com.example.form;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class AccountForm implements Serializable {

	private static final long serialVersionUID = 1L;
	private String name;
	private String streetAddress;
	private String couponCode;
	private int quantity;
	private BigDecimal rate;
	private Date dateOfBirth;
	private boolean agreeToTerms;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getCouponCode() {
		return couponCode;
	}

	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getRate() {
		return rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public boolean isAgreeToTerms() {
		return agreeToTerms;
	}

	public void setAgreeToTerms(boolean isAgreedTermsOfUse) {
		this.agreeToTerms = isAgreedTermsOfUse;
	}

}
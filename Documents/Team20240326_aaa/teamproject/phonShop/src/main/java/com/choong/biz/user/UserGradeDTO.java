package com.choong.biz.user;

import java.util.Objects;

public class UserGradeDTO {
	
	  private int userGradeNumber;  
	  private String userGradeName;   
	  private int userGradeTotalPurchaseAmount;
	  private int userGradeDiscountRate;
	  private int userGradeCount;
	  
	  
	  public UserGradeDTO(){
		  
	  }
	  
	  
	public UserGradeDTO(int userGradeNumber, String userGradeName, int userGradeTotalPurchaseAmount,
			int userGradeDiscountRate, int userGradeCount) {
		super();
		this.userGradeNumber = userGradeNumber;
		this.userGradeName = userGradeName;
		this.userGradeTotalPurchaseAmount = userGradeTotalPurchaseAmount;
		this.userGradeDiscountRate = userGradeDiscountRate;
		this.userGradeCount = userGradeCount;
	}


	public int getUserGradeNumber() {
		return userGradeNumber;
	}


	public void setUserGradeNumber(int userGradeNumber) {
		this.userGradeNumber = userGradeNumber;
	}


	public String getUserGradeName() {
		return userGradeName;
	}


	public void setUserGradeName(String userGradeName) {
		this.userGradeName = userGradeName;
	}


	public int getUserGradeTotalPurchaseAmount() {
		return userGradeTotalPurchaseAmount;
	}


	public void setUserGradeTotalPurchaseAmount(int userGradeTotalPurchaseAmount) {
		this.userGradeTotalPurchaseAmount = userGradeTotalPurchaseAmount;
	}


	public int getUserGradeDiscountRate() {
		return userGradeDiscountRate;
	}


	public void setUserGradeDiscountRate(int userGradeDiscountRate) {
		this.userGradeDiscountRate = userGradeDiscountRate;
	}


	public int getUserGradeCount() {
		return userGradeCount;
	}


	public void setUserGradeCount(int userGradeCount) {
		this.userGradeCount = userGradeCount;
	}


	@Override
	public String toString() {
		return "UserGradeDTO [userGradeNumber=" + userGradeNumber + ", userGradeName=" + userGradeName
				+ ", userGradeTotalPurchaseAmount=" + userGradeTotalPurchaseAmount + ", userGradeDiscountRate="
				+ userGradeDiscountRate + ", userGradeCount=" + userGradeCount + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(userGradeCount, userGradeDiscountRate, userGradeName, userGradeNumber,
				userGradeTotalPurchaseAmount);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserGradeDTO other = (UserGradeDTO) obj;
		return userGradeCount == other.userGradeCount && userGradeDiscountRate == other.userGradeDiscountRate
				&& Objects.equals(userGradeName, other.userGradeName) && userGradeNumber == other.userGradeNumber
				&& userGradeTotalPurchaseAmount == other.userGradeTotalPurchaseAmount;
	}
	
	
	
	  
	  
	  
	  

}

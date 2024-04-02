package com.choong.biz.user;

import java.util.Objects;

public class UserDTO {
	private String userId;
	private String userName;
	private String userGrade;
	private String userJoinDate;
	private String userLastLoginDate;
	private int userTotalPurchaseCount;
	private int userAccessBlocked;
	private String userPassword;
	private String userEmail;
	private String userAddress;
	private String userBirthday;
	private int userTotalPurchaseAmount;
	private String userPhoneNumber;
	private int userNumber;
	
	public UserDTO(){
		
	}
	
	
	
	public UserDTO(String userId, String userName, String userGrade, String userJoinDate, String userLastLoginDate,
			int userTotalPurchaseCount, int userAccessBlocked, String userPassword, String userEmail,
			String userAddress, String userBirthday, int userTotalPurchaseAmount, String userPhoneNumber,
			int userNumber) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userGrade = userGrade;
		this.userJoinDate = userJoinDate;
		this.userLastLoginDate = userLastLoginDate;
		this.userTotalPurchaseCount = userTotalPurchaseCount;
		this.userAccessBlocked = userAccessBlocked;
		this.userPassword = userPassword;
		this.userEmail = userEmail;
		this.userAddress = userAddress;
		this.userBirthday = userBirthday;
		this.userTotalPurchaseAmount = userTotalPurchaseAmount;
		this.userPhoneNumber = userPhoneNumber;
		this.userNumber = userNumber;
	}



	public String getUserId() {
		return userId;
	}



	public void setUserId(String userId) {
		this.userId = userId;
	}



	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}



	public String getUserGrade() {
		return userGrade;
	}



	public void setUserGrade(String userGrade) {
		this.userGrade = userGrade;
	}



	public String getUserJoinDate() {
		return userJoinDate;
	}



	public void setUserJoinDate(String userJoinDate) {
		this.userJoinDate = userJoinDate;
	}



	public String getUserLastLoginDate() {
		return userLastLoginDate;
	}



	public void setUserLastLoginDate(String userLastLoginDate) {
		this.userLastLoginDate = userLastLoginDate;
	}



	public int getUserTotalPurchaseCount() {
		return userTotalPurchaseCount;
	}



	public void setUserTotalPurchaseCount(int userTotalPurchaseCount) {
		this.userTotalPurchaseCount = userTotalPurchaseCount;
	}



	public int getUserAccessBlocked() {
		return userAccessBlocked;
	}



	public void setUserAccessBlocked(int userAccessBlocked) {
		this.userAccessBlocked = userAccessBlocked;
	}



	public String getUserPassword() {
		return userPassword;
	}



	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}



	public String getUserEmail() {
		return userEmail;
	}



	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}



	public String getUserAddress() {
		return userAddress;
	}



	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}



	public String getUserBirthday() {
		return userBirthday;
	}



	public void setUserBirthday(String userBirthday) {
		this.userBirthday = userBirthday;
	}



	public int getUserTotalPurchaseAmount() {
		return userTotalPurchaseAmount;
	}



	public void setUserTotalPurchaseAmount(int userTotalPurchaseAmount) {
		this.userTotalPurchaseAmount = userTotalPurchaseAmount;
	}



	public String getUserPhoneNumber() {
		return userPhoneNumber;
	}



	public void setUserPhoneNumber(String userPhoneNumber) {
		this.userPhoneNumber = userPhoneNumber;
	}



	public int getUserNumber() {
		return userNumber;
	}



	public void setUserNumber(int userNumber) {
		this.userNumber = userNumber;
	}



	@Override
	public String toString() {
		return "UserDTO [userId=" + userId + ", userName=" + userName + ", userGrade=" + userGrade + ", userJoinDate="
				+ userJoinDate + ", userLastLoginDate=" + userLastLoginDate + ", userTotalPurchaseCount="
				+ userTotalPurchaseCount + ", userAccessBlocked=" + userAccessBlocked + ", userPassword=" + userPassword
				+ ", userEmail=" + userEmail + ", userAddress=" + userAddress + ", userBirthday=" + userBirthday
				+ ", userTotalPurchaseAmount=" + userTotalPurchaseAmount + ", userPhoneNumber=" + userPhoneNumber
				+ ", userNumber=" + userNumber + "]";
	}



	@Override
	public int hashCode() {
		return Objects.hash(userAccessBlocked, userAddress, userBirthday, userEmail, userGrade, userId, userJoinDate,
				userLastLoginDate, userName, userNumber, userPassword, userPhoneNumber, userTotalPurchaseAmount,
				userTotalPurchaseCount);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserDTO other = (UserDTO) obj;
		return userAccessBlocked == other.userAccessBlocked && Objects.equals(userAddress, other.userAddress)
				&& Objects.equals(userBirthday, other.userBirthday) && Objects.equals(userEmail, other.userEmail)
				&& Objects.equals(userGrade, other.userGrade) && Objects.equals(userId, other.userId)
				&& Objects.equals(userJoinDate, other.userJoinDate)
				&& Objects.equals(userLastLoginDate, other.userLastLoginDate)
				&& Objects.equals(userName, other.userName) && userNumber == other.userNumber
				&& Objects.equals(userPassword, other.userPassword)
				&& Objects.equals(userPhoneNumber, other.userPhoneNumber)
				&& userTotalPurchaseAmount == other.userTotalPurchaseAmount
				&& userTotalPurchaseCount == other.userTotalPurchaseCount;
	}
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	

}

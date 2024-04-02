package com.choong.biz.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.xdevapi.Result;

import dbconnection.MyDBConnection;

public class UserDAO {
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	//userDTO sql문
	private String USER_GET = "select * from userManagement where userId=?"; //상세
	private String USER_DELETE = "delete from userManagement where userId=?"; //삭제
	private String USER_LIST = "select * from userManagement";		//목록
	private String USER_INSERT = "insert into userManagement values(?,?,?,?)";
	private String USER_UPDATE = "update userManagement set userName=?, userGrade=? where userId=?";
	
	
	//회원 관련 CRUD(create, read, update, delete)
	
	
	//1. 회원 상세조회
	public UserDTO getUser(String id) { //DispacherServlet 수정
		UserDTO user = null;
		
		
		//private String USER_GET = "select * from users where id=?"; //상세
		
		try {
			con = MyDBConnection.getConnection();
			pstmt = con.prepareStatement(USER_GET);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
		
			
			if(rs.next()) { //DB의 이름이랑 같아야 하고, 
				
			
				user = new UserDTO(); 
				user.setUserId(rs.getString("userId")); //rs.
				user.setUserName(rs.getString("userName")); //rs.
				user.setUserGrade(rs.getString("userGrade")); //rs.
				user.setUserJoinDate(rs.getString("userJoinDate")); //rs.
				user.setUserLastLoginDate(rs.getString("userLastLoginDate")); //rs.
				user.setUserTotalPurchaseCount(1); //rs.
				user.setUserAccessBlocked(1); //rs.
				user.setUserPassword(rs.getString("userPassword")); //rs.
				user.setUserEmail(rs.getString("userEmail")); //rs.
				user.setUserAddress(rs.getString("userAddress")); //rs.
				user.setUserBirthday(rs.getString("userBirthday")); //rs.
				user.setUserTotalPurchaseAmount(1); //rs.
				user.setUserPhoneNumber(rs.getString("userPhoneNumber")); //rs.
				user.setUserNumber(1); //rs.
				
		
				
				
			}
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		return user;
		
		
	}
	
	
	//private String USER_DELETE = "delete users where id=?";
	//2. 회원 삭제
	public void deleteUser(String id) {
		
		try {
			con = MyDBConnection.getConnection();
			pstmt = con.prepareStatement(USER_DELETE);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			MyDBConnection.close(rs, pstmt, con);
		}
		
		
	}
	
	//private String USER_UPDATE = "update users set name=?, role=? where id=?";
	//3. 회원 수정
	public void updateUser(UserDTO dto) {
		
		try {
			con = MyDBConnection.getConnection();
			pstmt = con.prepareStatement(USER_UPDATE);
			pstmt.setString(1, dto.getUserName());
			pstmt.setString(2, dto.getUserGrade());
			pstmt.setString(3, dto.getUserId());
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			MyDBConnection.close(rs, pstmt, con);
		}
		
		
	}
	
	
	//private String USER_INSERT = "insert into users values(?,?,?,?)";
	//4. 회원 등록
	public void insertUser(UserDTO dto) {
		
		try {
			con = MyDBConnection.getConnection();
			pstmt = con.prepareStatement(USER_INSERT);
			pstmt.setString(1, dto.getUserId());
			pstmt.setString(2, dto.getUserPassword());
			pstmt.setString(3, dto.getUserName());
			pstmt.setString(4, dto.getUserGrade());
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			MyDBConnection.close(rs, pstmt, con);
		}
		
		
	}
	
	/*
	
	//내가 짠 코드
	//private String USER_LIST = "select * from users";
	//5. 회원 목록 조회
	public UserDTO getUserList(UserDTO dto) {
		
		try {
			con = MyDBConnection.getConnection();
			pstmt = con.prepareStatement(USER_LIST);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPassword());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getRole());
			
			pstmt.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			MyDBConnection.close(rs, pstmt, con);
		}
		
		return 
		
		
		
	}
	
	*/
	
	
	
	
	//private String USER_LIST = "select * from users";
		//5. 회원 목록 조회
		public List<UserDTO> getUserList() {
			
			 List<UserDTO>  userList = new ArrayList<UserDTO>();
			
			
			try {
				con = MyDBConnection.getConnection();
				pstmt = con.prepareStatement(USER_LIST);
				rs=pstmt.executeQuery();
				
				while(rs.next()) {
					UserDTO user = new UserDTO();
					
					user.setUserId(rs.getString("userId")); //rs.
					user.setUserName(rs.getString("userName")); //rs.
					user.setUserGrade(rs.getString("userGrade")); //rs.
					user.setUserJoinDate(rs.getString("userJoinDate")); //rs.
					user.setUserLastLoginDate(rs.getString("userLastLoginDate")); //rs.
					user.setUserTotalPurchaseCount(1); //rs.
					user.setUserAccessBlocked(1); //rs.
					user.setUserPassword(rs.getString("userPassword")); //rs.
					user.setUserEmail(rs.getString("userEmail")); //rs.
					user.setUserAddress(rs.getString("userAddress")); //rs.
					user.setUserBirthday(rs.getString("userBirthday")); //rs.
					user.setUserTotalPurchaseAmount(1); //rs.
					user.setUserPhoneNumber(rs.getString("userPhoneNumber")); //rs.
					user.setUserNumber(1); //rs.
					
					
					
					
				
					userList.add(user);
				}
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				MyDBConnection.close(rs, pstmt, con);
			}
			
			return userList;
			
			
			
		}
	
	
	
	
	
	
	

}

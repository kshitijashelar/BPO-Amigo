package com.service.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.constant.Constant;
import com.database.Database;
import com.model.User;
import com.service.UserService;

public class UserServiceImpl implements UserService, Constant {

	@Override
	public boolean isUser(User user) {
		boolean isValid = false;
		String sql;
		PreparedStatement statement;
		try {
			sql = "SELECT * FROM " + TABLE_NAME_USER + " WHERE " + EMAIL_ID + "=? AND " + PASSWORD + "=? ";
			statement = Database.getConnection().prepareStatement(sql);
			statement.setString(1, user.getEmailId());
			statement.setString(2, user.getPassword());
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				User userDb = new User();
				userDb.setEmailId(result.getString(EMAIL_ID));
				userDb.setPassword(result.getString(PASSWORD));
				if (user.getEmailId().equals(userDb.getEmailId()) && user.getPassword().equals(userDb.getPassword())) {
					isValid = true;
					break;
				}
			}
		} catch (Exception ex) {
			System.out.println("Exception : isUser() : User.java :" + ex.getMessage());
		}
		return isValid;
	}

	@Override
	public List<String> getUserDetails(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCurrentDateAndTime() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isRegisterUser(User user) {
		boolean isRegisterUser = false;
		try {
			String sql = "SELECT * FROM " + TABLE_NAME_USER + " WHERE " + EMAIL_ID + "=? ";
			PreparedStatement statement = Database.getConnection().prepareStatement(sql);
			statement.setString(1, user.getEmailId());
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				isRegisterUser = true;
			}
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
		return isRegisterUser;
	}

	@Override
	public boolean isRegister(User user) {
		boolean isRegister = false;
		try {
			String sql = "INSERT INTO " + TABLE_NAME_USER + " (" + FULL_NAME + "," + MOBILE_NUMBER + "," + EMAIL_ID
					+ "," + PASSWORD  + "," + REGISTER_DATE +","+USER_TYPE+","+PRODUCT_NAME+") VALUES (?,?,?,?,?,?,?)";
			PreparedStatement statement = Database.getConnection().prepareStatement(sql);
			statement.setString(1, user.getFullName());
			statement.setString(2, user.getMobileNumber());
			statement.setString(3, user.getEmailId());
			statement.setString(4, user.getPassword());
			statement.setString(5, user.getRegDate());
			statement.setString(6, user.getUserType());
			statement.setString(7, user.getProductName());
			int result = statement.executeUpdate();
			if (1 == result) {
				isRegister = true;
			}
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
		return isRegister;
	}

	@Override
	public User findByUserId(int userId) {
		User user = new User();
		try {
			String sql = "SELECT * FROM " + TABLE_NAME_USER + " WHERE " + USER_ID + "=?";
			PreparedStatement statement = Database.getConnection().prepareStatement(sql);
			statement.setInt(1, userId);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				user.setUserId(result.getInt(USER_ID));
				user.setEmailId(result.getString(EMAIL_ID));
				user.setFullName(result.getString(FULL_NAME));
				user.setMobileNumber(result.getString(MOBILE_NUMBER));
				user.setPassword(result.getString(PASSWORD));
				user.setRegDate(result.getString(REGISTER_DATE));
				user.setStatus(result.getInt(STATUS));
				user.setUserType(result.getString(USER_TYPE));
				user.setProductName(result.getString(PRODUCT_NAME));

			}

		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
		return user;
	}

	@Override
	public User findByEmailIdAndUserType(String emailId, String userType) {
		User user = new User();
		try {
			String sql = "SELECT * FROM " + TABLE_NAME_USER + "  WHERE " + EMAIL_ID + "=?  AND  "+USER_TYPE+"=?";
			PreparedStatement statement = Database.getConnection().prepareStatement(sql);
			statement.setString(1, emailId);
			statement.setString(2, userType);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				user.setUserId(result.getInt(USER_ID));
				user.setEmailId(result.getString(EMAIL_ID));
				user.setFullName(result.getString(FULL_NAME));
				user.setMobileNumber(result.getString(MOBILE_NUMBER));
				user.setPassword(result.getString(PASSWORD));
				user.setRegDate(result.getString(REGISTER_DATE));
				user.setStatus(result.getInt(STATUS));
				user.setUserType(result.getString(USER_TYPE));
				user.setProductName(result.getString(PRODUCT_NAME));

			}

		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
		return user;
	}

	@Override
	public User findByEmailId(String emailId) {
		User user = new User();
		try {
			String sql = "SELECT * FROM " + TABLE_NAME_USER + "  WHERE " + EMAIL_ID + "=? ";
			PreparedStatement statement = Database.getConnection().prepareStatement(sql);
			statement.setString(1, emailId);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				user.setUserId(result.getInt(USER_ID));
				user.setEmailId(result.getString(EMAIL_ID));
				user.setFullName(result.getString(FULL_NAME));
				user.setMobileNumber(result.getString(MOBILE_NUMBER));
				user.setPassword(result.getString(PASSWORD));
				user.setRegDate(result.getString(REGISTER_DATE));
				user.setStatus(result.getInt(STATUS));
				user.setUserType(result.getString(USER_TYPE));
				user.setProductName(result.getString(PRODUCT_NAME));

			}

		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
		return user;
	}

	

}

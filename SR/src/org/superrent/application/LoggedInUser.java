package org.superrent.application;

public class LoggedInUser {
	private static String userId;
	private static int privilege;

	/**
	 * @return the privilege
	 */
	public static int getPrivilege() {
		return privilege;
	}

	/**
	 * @param privilege the privilege to set
	 */
	public static void setPrivilege(int privilege) {
		LoggedInUser.privilege = privilege;
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
}

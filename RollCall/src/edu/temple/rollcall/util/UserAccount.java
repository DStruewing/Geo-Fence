package edu.temple.rollcall.util;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;

public class UserAccount {
	
	private static String studentId = null;
	private static String email;
	private static String firstName;
	private static String lastName;
	
	public static String studentId() {
		return UserAccount.studentId;
	}
	
	public static boolean login(Context context, String email, String password) {
		JSONObject result = API.login(context, email, password);
		try {
			studentId = result.getString("id");
			return true;
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static void update(JSONObject account) {
		try {
			studentId = account.getString("id");
			email = account.getString("email");
			firstName = account.getString("first_name");
			lastName = account.getString("last_name");
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

}
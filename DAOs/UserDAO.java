package car_rental_app.data;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import car_rental_app.model.User;
import car_rental_app.util.SQLConnection;

public class UserDAO {

	static SQLConnection DBMgr = SQLConnection.getInstance();
	
	public static void registerUser(User user) {
		Statement stmt = null;   
		Connection conn = SQLConnection.getDBConnection();  
		String registerUser = "INSERT INTO USER (utaid,username,first_name,last_name,password,email,aacmembership,role,isrevoked,age) ";					
		registerUser += " VALUES ('"  
				+ user.getUtaId() + "','"
				+ user.getUsername() + "','"		
				+ user.getFirstName() + "','"
				+ user.getLastName() + "','" 
				+ user.getPassword()  + "','"
				+ user.getEmail() + "',"
				+ user.getAacMembership() + ",'"		
				+ user.getRole() + "',"
				+ user.getIsRevoked() + "," 
				+ user.getAge() + ")" ;
		try {   
		conn = SQLConnection.getDBConnection();  
		conn.setAutoCommit(false);   
		stmt = conn.createStatement();
		stmt.executeUpdate(registerUser);
		conn.commit();					 
	} catch (SQLException sqle) { 
		sqle.printStackTrace();
	} finally {
		try {
			conn.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		};
	}
	}
	
	//get a user based on username
	public static User getUser(String username) {
		Statement stmt = null;   
		Connection conn = null;  
		User user = new User();
		try {   
			conn = SQLConnection.getDBConnection();  
			stmt = conn.createStatement();
			String searchUsername = " SELECT * from USER WHERE USERNAME = '"+username+"'";
			ResultSet userList = stmt.executeQuery(searchUsername);
			while(userList.next()) {
				String utaId = userList.getString("utaid");
				String firstName  = userList.getString("first_name");
				String lastName  = userList.getString("last_name");
				String password = userList.getString("password");
				String email  = userList.getString("email");
				int aacMembership  = userList.getInt("aacmembership");
				String role  = userList.getString("role");
				int isRevoked = userList.getInt("isrevoked");
				int age  = userList.getInt("age");
				
				user.setUser(firstName, lastName, username, password, email, utaId, age, aacMembership, role, isRevoked);				  	
			}
			
			} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}};
		return user;
	}
	
	
	//check if a username already exists in DB or not
	public static boolean uniqueUsername(String username) {  
		Statement stmt = null;   
		Connection conn = null;  
		try {   
			conn = SQLConnection.getDBConnection();  
			stmt = conn.createStatement();
			String searchUsername = " SELECT * from USER WHERE USERNAME = '"+username+"'";
			ResultSet userList = stmt.executeQuery(searchUsername);
			ArrayList<User> userListInDB = new ArrayList<User>();
			while (userList.next()) {
				User user = new User(); 
				userListInDB.add(user);	 
			} 
			return (userListInDB.isEmpty());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}};
		return false;
	}

}

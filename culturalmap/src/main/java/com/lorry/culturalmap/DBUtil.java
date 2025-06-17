package com.lorry.culturalmap;

import java.sql.*;
import com.google.gson.JsonObject;

public class DBUtil {
	public static void main(String[] args) {
	    String url = "jdbc:mysql://localhost:3306/culturalmap";
	    String username = "lorry";
	    String password = "Lorry@123";

	    try (Connection conn = DriverManager.getConnection(url, username, password)) {
	        System.out.println("✅ Connection successful!");
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
    public static String getCultureInfo(String state) {
        String url = "jdbc:mysql://localhost:3306/culturalmap";
        String username = "lorry";
        String password = "Lorry@123";

        String query = "SELECT * FROM state_culture WHERE state_name = ?";
        JsonObject json = new JsonObject();

        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, state);
            ResultSet rs = stmt.executeQuery();
            System.out.println("Trying to connect DB...");
            System.out.println("Querying for state: " + state);
            System.out.println("Results found: " + rs.next()); // temporarily log this

            if (rs.next()) {
                json.addProperty("state", state);
                json.addProperty("art_form", rs.getString("art_form"));
                json.addProperty("festival", rs.getString("festival"));
                json.addProperty("famous_food", rs.getString("famous_food"));
                json.addProperty("artist_name", rs.getString("artist_name"));
            }
 else {
                json.addProperty("error", "No data found");
            }

        } catch (Exception e) {
            e.printStackTrace();
            json.addProperty("error", "Database error");
        }
        
        
        System.out.println(json);
        return json.toString(); // This is what Spark sends to frontend
    }
}

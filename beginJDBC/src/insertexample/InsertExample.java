package insertexample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertExample {

	public static void main(String[] args) {

		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/first_example","root","123456");
			
			String insertSQL = "INSERT INTO person (name,surname) VALUES (?,?)";
			PreparedStatement state = connection.prepareStatement(insertSQL);
			state.setString(1, "Berkay");
			state.setString(2, "DEMİREL");
			int result = state.executeUpdate();

			if (result > 0) {

				System.out.println("Successful");

			} else {

				System.out.println("Failed");
			}

			state.setString(1, "Insert");
			state.setString(2, "Example");
			result = state.executeUpdate();

			if (result > 0) {

				System.out.println("Successful");

			} else {

				System.out.println("Failed");
			}

			state.close();
			connection.close();

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}

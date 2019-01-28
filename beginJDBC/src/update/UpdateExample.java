package update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UpdateExample {

	public static void main(String[] args) {

		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/first_example","root","123456");
			
			String updateSQL = "UPDATE person SET name = ? ,surname = ? WHERE id = ?";
			PreparedStatement state = connection.prepareStatement(updateSQL);
			state.setString(1, "Update");
			state.setString(2, "Example");
			state.setInt(3, 5);
			int result = state.executeUpdate();

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

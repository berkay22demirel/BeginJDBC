package deleteexample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DeleteExample {

	public static void main(String[] args) {

		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/first_example","root","123456");
			
			String deleteSQL = "DELETE FROM person WHERE id = ?";
			PreparedStatement state = connection.prepareStatement(deleteSQL);
			state.setInt(1, 1);
			int result = state.executeUpdate();

			if (result > 0) {

				System.out.println("Successful");

			} else {

				System.out.println("Failed");
			}

			state.setInt(1, 2);
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

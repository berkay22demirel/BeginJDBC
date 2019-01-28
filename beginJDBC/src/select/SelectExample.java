package select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class SelectExample {
	
	public static void main(String[] args) {

		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/first_example","root","123456");
			
			ResultSet result;
			
			// SELECT With Dynamic Parameters
			String selectSQL = "SELECT * FROM person WHERE id = ?";
			PreparedStatement preparedState = connection.prepareStatement(selectSQL);
			preparedState.setInt(1, 1);
			result = preparedState.executeQuery();
			
			if (result.next()) {

				System.out.println(result.getInt("id") + " - "
						+ result.getString("name") + " - "
						+ result.getString("surname"));
			}
			
			System.out.println("-----------------------------------------------");

			// SELECT With Static Parameters
			Statement state = connection.createStatement();
			result = state.executeQuery("SELECT * FROM person WHERE id = 1");
			
			if (result.next()) {

				System.out.println(result.getInt("id") + " - "
						+ result.getString("name") + " - "
						+ result.getString("surname"));
			}
			
			System.out.println("-----------------------------------------------");

			// SELECT All Records
			Statement stateAllRecords = connection.createStatement();
			result = stateAllRecords.executeQuery("SELECT * FROM person");

			while (result.next()) {

				System.out.println(result.getInt("id") + " - "
						+ result.getString("name") + " - "
						+ result.getString("surname"));

			}

			preparedState.close();
			connection.close();

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

}

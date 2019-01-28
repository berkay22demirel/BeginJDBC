package firstexample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class FirstExample {

	public static void main(String[] args) {
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/first_example","root","123456");
			
			// INSERT
			String insertSql = "INSERT INTO person (name, surname) VALUES (?, ?);";
			PreparedStatement preparedState = connection.prepareStatement(insertSql);
			preparedState.setString(1, "Berkay");
			preparedState.setString(2, "DEMİREL");
			int result = preparedState.executeUpdate();

			// SELECT
			Statement state = connection.createStatement();
			ResultSet resultSelect = state.executeQuery("SELECT * FROM person");
			while (resultSelect.next()) {
				
				System.out.println(resultSelect.getInt("id") + " - "
						+ resultSelect.getString("name") + " - "
						+ resultSelect.getString("surname"));
				
			}

			preparedState.close();
			connection.close();

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

}

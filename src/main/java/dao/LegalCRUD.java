package dao;

import java.lang.reflect.InvocationTargetException;
import java.math.BigInteger;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

public class LegalCRUD {
	private static final String CONN_STR = "jdbc:mysql://localhost:3306/accounts?useUnicode=true&characterEncoding=UTF-8";
	private static final String USER = "root";
	private static final String PASSWORD = "root";

	public static String insert(Legal legal) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection(CONN_STR, USER, PASSWORD);
		Statement st = connection.createStatement();
		CustomerCRUD.insert(legal);
		st.executeUpdate("INSERT INTO accounts.legal (eCode, name, registrationDate, id) VALUES ("
				+ legal.geteCode() + ", " + "'" + legal.getName() + "', '" + legal.getRegistrationDate() + "', " + legal.getId() + ")");
		connection.close();
		return legal.getId();
	}

	public static String findIdByCode(BigInteger eCode) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection(CONN_STR, USER, PASSWORD);
		Statement st = connection.createStatement();
		ResultSet result = st.executeQuery("SELECT * FROM accounts.legal WHERE eCode ='" + eCode + "'");
		if (result.next()) {
			String id = result.getString("id");
			connection.close();
			return id;
		}
		connection.close();
		return null;
	}

	public static void remove(String id) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection(CONN_STR, USER, PASSWORD);
		Statement st = connection.createStatement();
		st.executeUpdate("DELETE FROM accounts.legal WHERE id='" + id + "'");
		connection.close();
		CustomerCRUD.remove(id);
	}

	public static ArrayList<HashMap<String, String>> search(String field, String value) throws SQLException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
		ArrayList<HashMap<String, String>> legalCustomers = new ArrayList<HashMap<String, String>>();
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection(CONN_STR, USER, PASSWORD);
		Statement st = connection.createStatement();
		ResultSet results = st.executeQuery("SELECT * FROM accounts.legal WHERE " + field + "='" + value + "'");
		while (results.next()) {
			HashMap<String, String> fields = new HashMap<String, String>();
			fields.put("id", results.getString("id"));
			fields.put("eCode", results.getString("eCode"));
			fields.put("name", results.getString("name"));
			fields.put("registrationDate", results.getString("registrationDate"));

			legalCustomers.add(fields);
		}
		connection.close();
		return legalCustomers;
	}

	public static HashMap<String, String> findById(String id) throws ClassNotFoundException, SQLException {
		HashMap<String, String> legalCustomer = new HashMap<String, String>();
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection(CONN_STR, USER, PASSWORD);
		Statement st = connection.createStatement();
		ResultSet results = st.executeQuery("SELECT * FROM accounts.legal WHERE id='" + id + "'");
		results.next();
		legalCustomer.put("id", results.getString("id"));
		legalCustomer.put("eCode", results.getString("eCode"));
		legalCustomer.put("name", results.getString("name"));
		legalCustomer.put("registrationDate", results.getString("registrationDate"));
		connection.close();
		return legalCustomer;
	}

	public static void update(Legal legal) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection(CONN_STR, USER, PASSWORD);
		Statement st = connection.createStatement();
		st.executeUpdate("UPDATE accounts.legal SET eCode='" + legal.geteCode() + "', name='" +
				legal.getName() + "', registrationDate='" + legal.getRegistrationDate() + "'" + " WHERE id=" + legal.getId());
		connection.close();
	}
}

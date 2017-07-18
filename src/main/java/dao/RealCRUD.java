package dao;

import java.lang.reflect.InvocationTargetException;
import java.math.BigInteger;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class RealCRUD {
	private static final String CONN_STR = "jdbc:mysql://localhost:3306/accounts?useUnicode=true&characterEncoding=UTF-8";
	private static final String USER = "root";
	private static final String PASSWORD = "root";

	public static String insert(Real real) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection(CONN_STR, USER, PASSWORD);
		Statement st = connection.createStatement();
		CustomerCRUD.insert(real);
		st.executeUpdate("INSERT INTO accounts.real (idCode, firstName, lastName, fatherName, birthDate, id) VALUES ("
				+ real.getIdCode() + ", " + "'" + real.getFirstName() + "', '" + real.getLastName() + "', '"
				+ real.fatherName + "', '" + real.getBirthDate() + "', " + real.getId() + ")");
		connection.close();
		return real.getId();
	}

	public static String findIdByCode(BigInteger idCode) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection(CONN_STR, USER, PASSWORD);
		Statement st = connection.createStatement();
		ResultSet result = st.executeQuery("SELECT * FROM accounts.real WHERE idCode='" + idCode + "'");
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
		st.executeUpdate("DELETE FROM accounts.real WHERE id='" + id + "'");
		connection.close();
		CustomerCRUD.remove(id);
	}

	public static ArrayList<HashMap<String, String>> search(String field, String value) throws SQLException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
		ArrayList<HashMap<String, String>> realCustomers = new ArrayList<HashMap<String, String>>();
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection(CONN_STR, USER, PASSWORD);
		Statement st = connection.createStatement();
		ResultSet results = st.executeQuery("SELECT * FROM accounts.real WHERE " + field + "='" + value + "'");
		while (results.next()) {
			HashMap<String, String> fields = new HashMap<String, String>();
			fields.put("id", results.getString("id"));
			fields.put("idCode", results.getString("idCode"));
			fields.put("firstName", results.getString("firstName"));
			fields.put("lastName", results.getString("lastName"));
			fields.put("fatherName", results.getString("fatherName"));
			fields.put("birthDate", results.getString("birthDate"));

			realCustomers.add(fields);
		}
		connection.close();
		return realCustomers;
	}

	public static HashMap<String, String> findById(String id) throws SQLException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
		HashMap<String, String> realCustomer = new HashMap<String, String>();
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection(CONN_STR, USER, PASSWORD);
		Statement st = connection.createStatement();
		ResultSet results = st.executeQuery("SELECT * FROM accounts.real WHERE id='" + id + "'");
		results.next();
		realCustomer.put("id", results.getString("id"));
		realCustomer.put("idCode", results.getString("idCode"));
		realCustomer.put("firstName", results.getString("firstName"));
		realCustomer.put("lastName", results.getString("lastName"));
		realCustomer.put("fatherName", results.getString("fatherName"));
		realCustomer.put("birthDate", results.getString("birthDate"));
		connection.close();
		return realCustomer;
	}

	public static void update(Real real) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection(CONN_STR, USER, PASSWORD);
		Statement st = connection.createStatement();
		st.executeUpdate("UPDATE accounts.real SET idCode='" + real.getIdCode() + "', firstName='" +
				real.getFirstName() + "', lastName='" + real.getLastName() + "', fatherName='" +
				real.getFatherName() + "', birthDate='" + real.getBirthDate() + "'" + " WHERE id=" + real.getId());
		connection.close();
	}
}

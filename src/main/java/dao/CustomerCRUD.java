package dao;

import java.sql.*;

public class CustomerCRUD {
	private static final String CONN_STR = "jdbc:mysql://localhost:3306/accounts?useUnicode=true&characterEncoding=UTF-8";
	private static final String USER = "root";
	private static final String PASSWORD = "root";

	public static String insert(Customer customer) throws ClassNotFoundException, SQLException {
		customer.setId(String.valueOf(nextId()));
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(CONN_STR, USER, PASSWORD);
		Statement st = con.createStatement();
		st.executeUpdate("INSERT INTO accounts.customer (id) VALUES (" + customer.getId() + ")");
		con.close();
		return customer.getId();
	}

	private static int nextId() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(CONN_STR, USER, PASSWORD);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("SELECT max(intID) as maxID from (SELECT CAST(id AS UNSIGNED) as intID FROM accounts.customer) as intIDs");
		int maxId = 0;
		if (rs.next()) {
			maxId = Integer.parseInt(rs.getString("maxID"));
		}
		con.close();
		return maxId + 1;
	}

	public static void remove(String id) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(CONN_STR, USER, PASSWORD);
		Statement st = con.createStatement();
		st.executeUpdate("DELETE FROM accounts.customer WHERE id='" + id + "'");
		con.close();
	}
}

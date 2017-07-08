package domain;

import java.sql.*;

public class CustomerRepository {
	private static CustomerRepository theRepository = new CustomerRepository();
	public static final String CONN_STR = "jdbc:mysql://localhost:3306/accounts?useUnicode=true&characterEncoding=UTF-8";
	public static final String USER = "root";
	public static final String PASSWORD = "root";
	
	public static CustomerRepository getInstance() {
		return theRepository;
	}
	
	private CustomerRepository() {
	}

	public int insert(Customer customer) throws SQLException, ClassNotFoundException {
		customer.setId(nextId());
		Connection con = DriverManager.getConnection(CONN_STR, USER, PASSWORD);
		Statement st = con.createStatement();
		st.executeUpdate("INSERT INTO accounts.customer (id) VALUES (" + customer.getId() + ")");
		if (customer.getClass() == Natural.class){
			Natural natural = (Natural) customer;
			System.out.println("INSERT INTO accounts.natural (idCode, firstName, lastName, fatherName, birthDate, id) VALUES ("
					+ natural.getCode() + ", " + "'" + natural.getFirstName() + "', '" + natural.getLastName() + "', '"
					+ natural.fatherName + "', '" + natural.getBirthDate() + "', " + natural.getId() + ")");
			st.executeUpdate("INSERT INTO accounts.natural (idCode, firstName, lastName, fatherName, birthDate, id) VALUES ("
					+ natural.getCode() + ", " + "'" + natural.getFirstName() + "', '" + natural.getLastName() + "', '"
					+ natural.fatherName + "', '" + natural.getBirthDate() + "', " + natural.getId() + ")");
		}
		else if (customer.getClass() == Legal.class){
			Legal legal = (Legal) customer;
			st.executeUpdate("INSERT INTO accounts.legal (eCode, name, regDate, id) VALUES ("
					+ legal.getCode() + ", " + "'" + legal.getName() + "', '" + legal.getRegDate() + "', " + legal.getId() + ")");
		}
		con.close();
		return customer.getId();
	}

	public int nextId() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(CONN_STR, USER, PASSWORD);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("SELECT max(id) as max_id from accounts.customer");
		int maxId = 0;
		if (rs.next()) {
			maxId = rs.getInt("max_id");
		}
		con.close();
		return maxId + 1;
	}
}

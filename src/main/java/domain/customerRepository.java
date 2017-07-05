package domain;

import java.sql.*;

public class CustomerRepository {
	private static CustomerRepository theRepository = new CustomerRepository();
	public static final String CONN_STR = "jdbc:mysql://localhost:3306/accounts";
	public static final String USER = "root";
	public static final String PASSWORD = "root";
	
	public static CustomerRepository getInstance() {
		return theRepository;
	}
	
	private CustomerRepository() {
	}

	public void insert(Customer customer) throws SQLException {
		customer.setId(nextId());
		Connection con = DriverManager.getConnection(CONN_STR);
		Statement st = con.createStatement();
		System.out.println("here");
		if (customer.getClass() == Natural.class){
			Natural natural = (Natural) customer;
			System.out.println("there");
			st.executeUpdate("insert into customer(id, firstName, lastName, fatherName, birthDate, nationalCode) values("
					+ natural.getId() + ", " + "'" + natural.getFirstName() + "', '" + natural.getLastName() + "', '"
					+ natural.fatherName + "', '" + natural.getBirthDate() + ", " + natural.getNationalCode() + ")");
			System.out.println("end");
		}
	}

	public int nextId() throws SQLException {
		Connection con = DriverManager.getConnection(CONN_STR, USER, PASSWORD);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select max(id) as max_id from accounts.customer");
		int maxId = 0;
		if (rs.next()) {
			maxId = rs.getInt("max_id");
		}
		con.close();
		return maxId + 1;
	}
}

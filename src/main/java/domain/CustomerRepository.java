package domain;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

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

	public int insert(Customer customer) throws ClassNotFoundException, SQLException {
		customer.setId(nextId());
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(CONN_STR, USER, PASSWORD);
		Statement st = con.createStatement();
		st.executeUpdate("INSERT INTO accounts.customer (id) VALUES (" + customer.getId() + ")");
		if (customer.getClass() == Natural.class) {
			Natural natural = (Natural) customer;
			System.out.println(natural.getCode());
			if (getID("natural", natural.getCode()) != 0) {
				return 0;
			}
			st.executeUpdate("INSERT INTO accounts.natural (idCode, firstName, lastName, fatherName, birthDate, id) VALUES ("
					+ natural.getCode() + ", " + "'" + natural.getFirstName() + "', '" + natural.getLastName() + "', '"
					+ natural.fatherName + "', '" + natural.getBirthDate() + "', " + natural.getId() + ")");
		} else if (customer.getClass() == Legal.class) {
			Legal legal = (Legal) customer;
			if (getID("legal", legal.getCode()) != 0) {
				return 0;
			}
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

	public ArrayList<Customer> search(String type, String field, String value) throws SQLException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
		ArrayList<Customer> results = new ArrayList<Customer>();
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(CONN_STR, USER, PASSWORD);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM accounts." + type + " WHERE " + field + "='" + value + "'");
		while (rs.next()) {
			type = type.replaceFirst(type.substring(0, 1), type.toUpperCase().substring(0, 1));
			Customer cust = (Customer) Class.forName("domain." + type).getConstructor(ResultSet.class).newInstance(rs);
			int id = rs.getInt("id");
			cust.setId(id);
			results.add(cust);
		}
		con.close();
		return results;
	}

	public void remove(String customerType, int id) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(CONN_STR, USER, PASSWORD);
		Statement st = con.createStatement();
		st.executeUpdate("DELETE FROM accounts." + customerType + " WHERE id=" + id);
		st.executeUpdate("DELETE FROM accounts.customer" + " WHERE id=" + id);
		con.close();
	}

	public int update(Map<String, String[]> mapParam) throws ClassNotFoundException, SQLException {
		Set<String> keys = mapParam.keySet();
		String set = "";
		BigDecimal code = null;
		for (String key : keys) {
			if (!key.equals("customerType") && !key.equals("id")) {
				set = set + key + "='" + mapParam.get(key)[0] + "', ";
				if (key.contains("Code")){
					code = new BigDecimal(mapParam.get(key)[0]);
				}
			}
		}
		set = set.substring(0, set.length() - 2);

		int findId = getID(mapParam.get("customerType")[0], code);
		if (findId>0 && findId!=Integer.parseInt(mapParam.get("id")[0])){
			return 0;
		}

		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(CONN_STR, USER, PASSWORD);
		Statement st = con.createStatement();
		st.executeUpdate("UPDATE accounts." + mapParam.get("customerType")[0] + " SET " + set + " WHERE id=" + mapParam.get("id")[0]);
		con.close();
		return 1;
	}
	
	public Customer findById(String type, int id) throws ClassNotFoundException, SQLException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(CONN_STR, USER, PASSWORD);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM accounts." + type + " WHERE id=" + id);
		if (rs.next()) {
			type = type.replaceFirst(type.substring(0, 1), type.toUpperCase().substring(0, 1));
			Customer cust = (Customer) Class.forName("domain." + type).getConstructor(ResultSet.class).newInstance(rs);
			cust.setId(id);
			return cust;
		}
		return null;
	}

	public int getID(String type, BigDecimal code) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(CONN_STR, USER, PASSWORD);
		Statement st = con.createStatement();
		ResultSet rs = null;
		if (type.equals("natural")) {
			rs = st.executeQuery("select id from accounts.natural where idCode=" + code);
		} else if (type.equals("legal")) {
			rs = st.executeQuery("select id from accounts.legal where eCode=" + code);
		}
		int id = 0;
		if (rs.next()) {
			id = rs.getInt("id");
		}
		con.close();
		return id;
	}
}

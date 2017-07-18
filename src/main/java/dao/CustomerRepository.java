package dao;

import java.lang.reflect.InvocationTargetException;
import java.math.BigInteger;
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

	public ArrayList<Customer> search(String type, String field, String value) throws SQLException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
		ArrayList<Customer> results = new ArrayList<Customer>();
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(CONN_STR, USER, PASSWORD);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM accounts." + type + " WHERE " + field + "='" + value + "'");
		while (rs.next()) {
			type = type.replaceFirst(type.substring(0, 1), type.toUpperCase().substring(0, 1));
			Customer cust = (Customer) Class.forName("dao." + type).getConstructor(ResultSet.class).newInstance(rs);
			int id = rs.getInt("id");
			cust.setId(String.valueOf(id));
			results.add(cust);
		}
		con.close();
		return results;
	}

//	public void remove(String customerType, int id) throws ClassNotFoundException, SQLException {
//		Class.forName("com.mysql.jdbc.Driver");
//		Connection con = DriverManager.getConnection(CONN_STR, USER, PASSWORD);
//		Statement st = con.createStatement();
//		st.executeUpdate("DELETE FROM accounts." + customerType + " WHERE id=" + id);
//		st.executeUpdate("DELETE FROM accounts.customer" + " WHERE id=" + id);
//		con.close();
//	}

	public int update(Map<String, String[]> mapParam) throws ClassNotFoundException, SQLException {
		Set<String> keys = mapParam.keySet();
		String set = "";
		BigInteger code = null;
		for (String key : keys) {
			if (!key.equals("customerType") && !key.equals("id")) {
				set = set + key + "='" + mapParam.get(key)[0] + "', ";
				if (key.contains("Code")){
					code = new BigInteger(mapParam.get(key)[0]);
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
			Customer cust = (Customer) Class.forName("dao." + type).getConstructor(ResultSet.class).newInstance(rs);
			cust.setId(String.valueOf(id));
			return cust;
		}
		return null;
	}

	public int getID(String type, BigInteger code) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(CONN_STR, USER, PASSWORD);
		Statement st = con.createStatement();
		ResultSet rs = null;
		if (type.equals("real")) {
			rs = st.executeQuery("select id from accounts.real where idCode=" + code);
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

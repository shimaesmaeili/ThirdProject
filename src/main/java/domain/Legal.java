package domain;

import java.math.BigInteger;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Map;

public class Legal extends Customer {
	BigInteger eCode;
	String name;
	Date regDate;

	public Legal(BigInteger code, String name, Date date) {
		this.eCode = code;
		this.name = name;
		this.regDate = date;
	}

	public Legal(Map<String, String[]> values) {
		this.name = values.get("name")[0];
		this.regDate = Date.valueOf(values.get("regDate")[0]);
		this.eCode = new BigInteger(values.get("code")[0]);
	}

	public Legal(ResultSet rs) throws SQLException {
		this.eCode = new BigInteger(rs.getString("eCode"));
		this.name = rs.getString("name");
		this.regDate = Date.valueOf(rs.getString("regDate").substring(0, 10));
	}

	public BigInteger getCode() {
		return eCode;
	}

	public void setCode(BigInteger code) {
		this.eCode = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
}

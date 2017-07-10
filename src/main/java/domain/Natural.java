package domain;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Map;

public class Natural extends Customer{
	BigDecimal idCode;
	String firstName;
	String lastName;
	String fatherName;
	Date birthDate;

	public Natural(BigDecimal idCode, String first, String last, String father, Date birth){
		this.idCode = idCode;
		this.firstName = first;
		this.lastName = last;
		this.fatherName = father;
		this.birthDate = birth;
	}

	public Natural(Map<String, String[]> values) {
		this.idCode = new BigDecimal(values.get("code")[0]);
		this.firstName = values.get("firstName")[0];
		this.lastName = values.get("lastName")[0];
		this.fatherName = values.get("fatherName")[0];
		this.birthDate = Date.valueOf(values.get("birthDate")[0]);
	}

	public Natural(ResultSet rs) throws SQLException {
		this.idCode = new BigDecimal(rs.getString("idCode"));
		this.firstName = rs.getString("firstName");
		this.lastName = rs.getString("lastName");
		this.fatherName = rs.getString("fatherName");
		this.birthDate = Date.valueOf(rs.getString("birthDate").substring(0, 10));
	}

	public BigDecimal getCode() {
		return idCode;
	}

	public void setCode(BigDecimal naturalId) {
		this.idCode = naturalId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
}

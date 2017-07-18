package dao;

import java.math.BigInteger;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class Legal extends Customer {
	BigInteger eCode;
	String name;
	Date registrationDate;

	public Legal() {
	}

	public BigInteger geteCode() {
		return eCode;
	}

	public void seteCode(BigInteger eCode) {
		this.eCode = eCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}
}

package domain;

import java.math.BigDecimal;
import java.sql.Date;

public class Natural extends Customer{
	BigDecimal idCode;
	String firstName;
	String lastName;
	String fatherName;
	Date birthDate;

	public Natural(BigDecimal naturalId, String first, String last, String father, Date birth){
		this.idCode = naturalId;
		this.firstName = first;
		this.lastName = last;
		this.fatherName = father;
		this.birthDate = birth;
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

package domain;

import java.math.BigDecimal;
import java.sql.Date;

public class Natural extends Customer{
	BigDecimal nCode;
	String firstName;
	String lastName;
	String fatherName;
	Date birthDate;

	public Natural(BigDecimal naturalId, String first, String last, String father, Date birth){
		this.nCode = naturalId;
		this.firstName = first;
		this.lastName = last;
		this.fatherName = father;
		this.birthDate = birth;
	}

	public BigDecimal getNationalCode() {
		return nCode;
	}

	public void setNationalCode(BigDecimal naturalId) {
		this.nCode = naturalId;
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

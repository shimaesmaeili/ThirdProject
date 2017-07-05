package db;

import java.sql.Date;

public class Natural extends Customer{
	int naturalId;
	String firstName;
	String lastName;
	String fatherName;
	Date birthDate;

	Natural(int id, int naturalId, String first, String last, String father, Date birth){
		super(id);
		this.naturalId = naturalId;
		this.firstName = first;
		this.lastName = last;
		this.fatherName = father;
		this.birthDate = birth;
	}

	public int getNaturalId() {
		return naturalId;
	}

	public void setNaturalId(int naturalId) {
		this.naturalId = naturalId;
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

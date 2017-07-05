package db;

import java.sql.Date;

public class Legal extends Customer{
	int legalId;
	String legalName;
	Date legalDate;

	Legal (int id, int legalId, String name, Date date){
		super(id);
		this.legalId = legalId;
		this.legalName = name;
		this.legalDate = date;
	}

	public int getLegalId() {
		return legalId;
	}

	public void setLegalId(int legalId) {
		this.legalId = legalId;
	}

	public String getLegalName() {
		return legalName;
	}

	public void setLegalName(String legalName) {
		this.legalName = legalName;
	}

	public Date getLegalDate() {
		return legalDate;
	}

	public void setLegalDate(Date legalDate) {
		this.legalDate = legalDate;
	}
}

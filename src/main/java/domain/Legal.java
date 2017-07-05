package domain;

import java.sql.Date;

public class Legal extends Customer{
	int eCode;
	String legalName;
	Date legalDate;

	Legal (int legalId, String name, Date date){
		this.eCode = legalId;
		this.legalName = name;
		this.legalDate = date;
	}

	public int getCode() {
		return eCode;
	}

	public void setCode(int legalId) {
		this.eCode = legalId;
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

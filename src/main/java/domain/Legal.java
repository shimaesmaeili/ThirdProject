package domain;

import java.math.BigDecimal;
import java.sql.Date;

public class Legal extends Customer{
	BigDecimal eCode;
	String name;
	Date regDate;

	public Legal (BigDecimal code, String name, Date date){
		this.eCode = code;
		this.name = name;
		this.regDate = date;
	}

	public BigDecimal getCode() {
		return eCode;
	}

	public void setCode(BigDecimal code) {
		this.eCode = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String legalName) {
		this.name = legalName;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date legalDate) {
		this.regDate = legalDate;
	}
}

package logic;

import dao.Legal;
import dao.LegalCRUD;
import dao.Real;
import dao.RealCRUD;

import java.math.BigInteger;
import java.sql.Date;
import java.sql.SQLException;

public class Insert {
	public static String insertRealCustomer(BigInteger idCode, String firstName, String lastName, String fatherName, Date birthDate) throws SQLException, ClassNotFoundException {
		if (Verify.getRealId(idCode) == null) {
			Real real = new Real();
			real.setIdCode(idCode);
			real.setFirstName(firstName);
			real.setLastName(lastName);
			real.setFatherName(fatherName);
			real.setBirthDate(birthDate);

			return RealCRUD.insert(real);
		} else {
			return null;
		}
	}

	public static String insertLegalCustomer(BigInteger eCode, String name, Date registrationDate) throws SQLException, ClassNotFoundException {
		if (Verify.getLegalId(eCode) == null) {
			Legal legal = new Legal();
			legal.seteCode(eCode);
			legal.setName(name);
			legal.setRegistrationDate(registrationDate);

			return LegalCRUD.insert(legal);
		} else {
			return null;
		}
	}
}

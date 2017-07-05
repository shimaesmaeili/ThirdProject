package controller;

import domain.CustomerRepository;
import domain.Natural;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.SQLException;

public class newCustomerServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		String fatherName = req.getParameter("fatherName");
		Date birthDate = Date.valueOf(req.getParameter("birthDate"));
		System.out.println(req.getParameter("code"));
		BigDecimal code = new BigDecimal(req.getParameter("code"));

		CustomerRepository rep = CustomerRepository.getInstance();
		try {
			rep.insert(new Natural(code, firstName, lastName, fatherName, birthDate));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

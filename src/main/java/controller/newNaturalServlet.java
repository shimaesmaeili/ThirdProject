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

public class newNaturalServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		String fatherName = req.getParameter("fatherName");
		Date birthDate = Date.valueOf(req.getParameter("birthDate"));
		BigDecimal code = new BigDecimal(req.getParameter("code"));

		CustomerRepository rep = CustomerRepository.getInstance();
		try {
			int id = rep.insert(new Natural(code, firstName, lastName, fatherName, birthDate));
			req.setAttribute("id", id);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		req.getRequestDispatcher("/viewId.jsp").forward(req, resp);
	}
}

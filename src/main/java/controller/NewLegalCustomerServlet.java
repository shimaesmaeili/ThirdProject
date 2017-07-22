package controller;

import logic.Insert;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigInteger;
import java.sql.Date;
import java.sql.SQLException;

public class NewLegalCustomerServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BigInteger eCode = new BigInteger(request.getParameter("eCode"));
		String name = request.getParameter("name");
		Date registrationDate = Date.valueOf(request.getParameter("registrationDate"));
		try {
			String id = Insert.insertLegalCustomer(eCode, name, registrationDate);
			if (id != null) {
				request.setAttribute("id", id);
				request.getRequestDispatcher("/show-new-customer-id.jsp").forward(request, response);
			} else {
				request.setAttribute("message", "مشتری با این کد اقتصادی قبلا ثبت شده است.");
				request.getRequestDispatcher("/error.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}

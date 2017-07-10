package controller;

import domain.Customer;
import domain.CustomerRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

public class showServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CustomerRepository rep = CustomerRepository.getInstance();
		Customer finded = null;
		try {
			finded = rep.findById(req.getParameter("customerType"), Integer.parseInt(req.getParameter("id")));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		req.setAttribute("customerType", req.getParameter("customerType"));
		req.setAttribute("customer", finded);
		req.getRequestDispatcher("/edit.jsp").forward(req, resp);
	}
}

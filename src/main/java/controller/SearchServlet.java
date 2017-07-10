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
import java.util.ArrayList;

public class SearchServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
		CustomerRepository rep = CustomerRepository.getInstance();
		ArrayList<Customer> searchResults = null;
		try {
			searchResults = rep.search(req.getParameter("customerType"), req.getParameter("customerField"), req.getParameter("field"));
			req.setAttribute("customers", searchResults);
			req.setAttribute("customerType", req.getParameter("customerType"));
			req.getRequestDispatcher("/viewResult.jsp").forward(req, resp);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
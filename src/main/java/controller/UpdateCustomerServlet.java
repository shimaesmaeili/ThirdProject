package controller;

import logic.Update;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

public class UpdateCustomerServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		if (request.getParameter("customerType").equals("real")) {
			HashMap<String, String> newValues = new HashMap<String, String>();
			newValues.put("id", request.getParameter("id"));
			newValues.put("idCode", request.getParameter("idCode"));
			newValues.put("firstName", request.getParameter("firstName"));
			newValues.put("lastName", request.getParameter("lastName"));
			newValues.put("fatherName", request.getParameter("fatherName"));
			newValues.put("birthDate", request.getParameter("birthDate"));
			try {
				if (Update.updateRealCustomer(newValues)) {
					request.getRequestDispatcher("/index.html").forward(request, response);
				} else {
					request.setAttribute("message", "امکان تغییر کد ملی مشتری به کد ملی جدید وجود ندارد!");
					request.getRequestDispatcher("/error.jsp").forward(request, response);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (request.getParameter("customerType").equals("legal")) {
			HashMap<String, String> newValues = new HashMap<String, String>();
			newValues.put("id", request.getParameter("id"));
			newValues.put("eCode", request.getParameter("eCode"));
			newValues.put("name", request.getParameter("name"));
			newValues.put("registrationDate", request.getParameter("registrationDate"));
			try {
				if (Update.updateLegalCustomer(newValues)) {
					request.getRequestDispatcher("/index.html").forward(request, response);
				} else {
					request.setAttribute("message", "امکان تغییر کد اقتصادی مشتری به کد اقتصادی جدید وجود ندارد!");
					request.getRequestDispatcher("/error.jsp").forward(request, response);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

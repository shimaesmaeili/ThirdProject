package controller;

import domain.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Map;

public class NewCustomerServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
		CustomerRepository rep = CustomerRepository.getInstance();
		Map<String, String[]> mapParam = req.getParameterMap();

		String type = req.getParameter("customerType");
		type = type.replaceFirst(type.substring(0,1), type.toUpperCase().substring(0,1));

		try {
			int id = rep.insert((Customer) Class.forName("domain."+type).getConstructor(Map.class).newInstance(mapParam));
			if (id > 1){
				req.setAttribute("id", id);
				req.getRequestDispatcher("/viewId.jsp").forward(req, resp);
			} else {
				req.setAttribute("message", "مشتری با این کد قبلا ثبت شده است.");
				req.getRequestDispatcher("/error.jsp").forward(req, resp);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

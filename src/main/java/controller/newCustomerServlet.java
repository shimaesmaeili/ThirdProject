package controller;

import domain.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class newCustomerServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CustomerRepository rep = CustomerRepository.getInstance();
		Map<String, String[]> mapParam = req.getParameterMap();

		String type = req.getParameter("customerType");
		type = type.replaceFirst(type.substring(0,1), type.toUpperCase().substring(0,1));

		try {
			int id = rep.insert((Customer) Class.forName("domain."+type).getConstructor(Map.class).newInstance(mapParam));
			req.setAttribute("id", id);
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
		}
		req.getRequestDispatcher("/viewId.jsp").forward(req, resp);
	}
}

package controller;

import domain.CustomerRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

public class UpdateServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
		CustomerRepository rep = CustomerRepository.getInstance();
		Map<String, String[]> mapParam = req.getParameterMap();

		try {
			int result = rep.update(mapParam);
			if (result > 0) {
				req.getRequestDispatcher("/index.jsp").forward(req, resp);
			} else {
				req.setAttribute("message", "امکان تغییر کد مشتری به کد جدید وجود ندارد!");
				req.getRequestDispatcher("/error.jsp").forward(req, resp);
			}
		} catch (ClassNotFoundException e) {
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

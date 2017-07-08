package controller;

import domain.CustomerRepository;
import domain.Legal;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.SQLException;

public class newLegalServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		Date regDate = Date.valueOf(req.getParameter("regDate"));
		BigDecimal code = new BigDecimal(req.getParameter("code"));

		CustomerRepository rep = CustomerRepository.getInstance();
		try {
			int id = rep.insert(new Legal(code, name, regDate));
			req.setAttribute("id", id);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		req.getRequestDispatcher("/viewId.jsp").forward(req, resp);
	}
}

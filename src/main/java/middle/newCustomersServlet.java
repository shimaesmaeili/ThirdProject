package middle;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class newCustomersServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String type = (String) req.getAttribute("type");
		if (type.equals("Legal")) {

		} else if (type.equals("Natural")) {

		} else {

		}
	}
}

package controller;

import logic.Insert;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.sql.Date;
import java.sql.SQLException;

public class NewRealCustomerServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BigInteger idCode = new BigInteger(request.getParameter("idCode"));
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String fatherName = request.getParameter("fatherName");
		Date birthDate = Date.valueOf(request.getParameter("birthDate"));
		try {
			String id = Insert.insertRealCustomer(idCode, firstName, lastName, fatherName, birthDate);
			if (id != null) {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = new PrintWriter(
						new OutputStreamWriter(response.getOutputStream(), "UTF-8"), true);
				String docType = "<!DOCTYPE html>\n" +
						"<html lang=\"fa\">\n" +
						"<head>\n" +
						"<meta charset=\"UTF-8\">\n" +
						"    <link rel=\"stylesheet\" type=\"text/css\" href=\"css/style.css\">\n" +
						"    <title>شماره مشتری</title>\n" +
						"</head>\n";

				out.println(docType +
						"<body>\n" +
						"<p id=\"generatedID\" class=\"big\">شماره مشتری:\n" +
						"\t" + id + "\n" +
						"</p>\n" +
						"<a href=\"/index.html\" class=\"link\">صفحه اصلی</a>\n" +
						"</body>\n" +
						"</html>"
				);
			} else {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = new PrintWriter(
						new OutputStreamWriter(response.getOutputStream(), "UTF-8"), true);
				String docType = "<!DOCTYPE html>\n" +
						"<html lang=\"fa\">\n" +
						"<head>\n" +
						"<meta charset=\"UTF-8\">\n" +
						"    <link rel=\"stylesheet\" type=\"text/css\" href=\"css/style.css\">\n" +
						"    <title>شماره مشتری</title>\n" +
						"</head>";

				out.println(docType +
						"<body>\n" +
						"<br><br><br><br><br><br>\n" +
						"<h3 class=\"center\">مشتری با این کد ملی قبلا ثبت شده است	</h3>\n" +
						"<br><br><br><br><br><br>\n" +
						"<a href=\"index.html\" class=\"link\">صفحه اصلی</a>\n" +
						"</body>\n" +
						"</html>"
				);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}

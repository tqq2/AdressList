package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.addresslistImpl;
import entity.Address;
import util.DbConnect;

/**
 * Servlet implementation class updateServlet
 */
@WebServlet(urlPatterns="/updateServlet")
public class updateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public updateServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String id = request.getParameter("updateid");
		String updatename = request.getParameter("updatename");
		String updatephone1 = request.getParameter("updatephone1");
		String updatephone2 = request.getParameter("updatephone2");

		addresslistImpl ui = new addresslistImpl();
		List addressbook = ui.update(updatename, updatephone1, updatephone2, id);

		HttpSession httpSession = request.getSession();
		httpSession.setAttribute("updatename", updatename);

		if (addressbook != null) {

			httpSession.setAttribute("addressbook", addressbook);
			response.sendRedirect("addresslist.jsp");
		} else {
			httpSession.setAttribute("message", "添加信息失败");
			response.sendRedirect("error.jsp");
		}

	}

}




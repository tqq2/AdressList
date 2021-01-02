package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.List;

import dao.addresslistImpl;
import entity.Address;
import util.DbConnect;

/**
 * Servlet implementation class deleteServlet
 */
@WebServlet(urlPatterns="/deleteServlet")
public class deleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public deleteServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");

		addresslistImpl ui = new addresslistImpl();
		HttpSession httpSession = request.getSession();
		List addressbook =ui.delete(id);

		if(addressbook!=null){

			httpSession.setAttribute("addressbook", addressbook);
			response.sendRedirect("addresslist.jsp");
		}else {
			httpSession.setAttribute("message", "添加信息失败");
			response.sendRedirect("error.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}

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

/**
 * Servlet implementation class selectServlet
 */
@WebServlet(urlPatterns="/selectServlet")
public class selectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public selectServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String selectbox = request.getParameter("selectbox");
		String search = request.getParameter("search");

		HttpSession httpSession = request.getSession();
		addresslistImpl ui = new addresslistImpl();
		List<Address> addressbook=new ArrayList<>();

		if (selectbox.equals("姓名")) {
			addressbook=ui.select(1,search);
		} else if (selectbox.equals("电话号码")) {
			addressbook=ui.select(2,search);
		} else {
			addressbook=ui.select(3,search);
		}

		if(addressbook!=null){

			httpSession.setAttribute("addressbook", addressbook);
			response.sendRedirect("addresslist.jsp");
		}else {
			httpSession.setAttribute("message", "添加信息失败");
			response.sendRedirect("error.jsp");
		}

	}

}

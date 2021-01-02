package servlet;

import java.io.IOException;
import java.io.PrintWriter;
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
 * Servlet implementation class addServlet
 */
@WebServlet("/addServlet")
public class addServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public addServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String addname = request.getParameter("addname");
		String addphone1 = request.getParameter("addphone1");
		String addphone2 = request.getParameter("addphone2");

		addresslistImpl ui = new addresslistImpl();
		List addressbook=ui.InsetInto(addname,addphone1,addphone2);
		HttpSession httpSession = request.getSession();

		if (addname.equals("")){
			out.println("<script>alert('无法保存空联系人，按确定键为您重新选择添加！');window.location.href='addresslist.jsp'</script>");
		}

		else if (!(addphone2.equals(""))|| !(addphone1.equals("")))
		{

			if(addressbook!=null){

				httpSession.setAttribute("addressbook", addressbook);
				response.sendRedirect("addresslist.jsp");
			}else {
				httpSession.setAttribute("message", "添加信息失败");
				response.sendRedirect("error.jsp");
			}


		}else
		out.println("<script>alert('电话至少填写一项，按确定键为您重新选择添加！');window.location.href='addresslist.jsp'</script>");


	}

}

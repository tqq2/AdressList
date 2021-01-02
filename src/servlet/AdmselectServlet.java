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

import dao.userslistImpl;
import entity.Address;
import entity.user;
import util.DbConnect;

/**
 * Servlet implementation class selectServlet
 */
@WebServlet(urlPatterns="/AdmselectServlet")
public class AdmselectServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdmselectServlet() {
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
        userslistImpl ui = new userslistImpl();
        List<user> users=new ArrayList<>();

        if (selectbox.equals("用户名")) {
            users=ui.select(1,search);
        } else if (selectbox.equals("电话号码")) {
            users=ui.select(2,search);
        } else {
            users=ui.select(3,search);
        }

        if (users!=null)  {
                httpSession.setAttribute("users", users);
                response.sendRedirect("userslist.jsp");

            } else {
                httpSession.setAttribute("message", "查询失败");
                response.sendRedirect("error.jsp");
            }

        }


}

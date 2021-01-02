package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.List;

import entity.user;
import util.DbConnect;

/**
 * Servlet implementation class loginServer
 */
@WebServlet(urlPatterns="/AdmloginServer")
public class AdmloginServer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdmloginServer() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String user = request.getParameter("user");
		String pwd = request.getParameter("pwd");

//		 默认登录帐号是a,密码是1，登录帐号没有使用到数据库。
		if (user.equals("a") && pwd.equals("1")) {
			Connection connection = DbConnect.getConnection();
			String sql = "select * from users";
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			List users = null;
			try {
				preparedStatement = connection.prepareStatement(sql);
                resultSet = preparedStatement.executeQuery();
                if (resultSet!=null) {
					users = new ArrayList();
    				try {
    					while (resultSet.next()) {
    						user u = new user();
    						u.setUser_id(resultSet.getInt(1));
    						u.setUser_account(resultSet.getString(2));
    						u.setUser_password(resultSet.getString(3));
    						u.setPhone1(resultSet.getString(4));
							users.add(u);
    					}
    				} catch (Exception e) {
    					System.out.println("封装数据集失败");
    					e.printStackTrace();
    				}
				}
                HttpSession httpSession = request.getSession();
              httpSession.setMaxInactiveInterval(7200);
              httpSession.setAttribute("users", users);
              System.out.println("++++000000000");
              response.sendRedirect("userslist.jsp");
			}catch (SQLException e) {
				e.printStackTrace();
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
		}else {
//			response.sendRedirect("Admlogin.jsp");
			out.println("<script>alert('用户名或密码有误！');window.location.href='Admlogin.jsp'</script>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

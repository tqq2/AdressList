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

import entity.Address;
import util.DbConnect;

/**
 * Servlet implementation class loginServer
 */
@WebServlet(urlPatterns="/loginServer")
public class loginServer extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public loginServer() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String search = request.getParameter("search");
		String user = request.getParameter("user");
		String pwd = request.getParameter("pwd");

		int flag=0;//是否能登录标志
		Connection connection = DbConnect.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List addressbook = null;

			try {
				System.out.println("0");
				String sql="select * from users where user_account='"
						+ user + "' and user_password='" + pwd + "'";

				preparedStatement = connection.prepareStatement(sql);
				resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				flag=resultSet.getInt("user_id");

			}
			} catch (SQLException e) {
				e.printStackTrace();
			}


		if(flag!=0){
			System.out.println("1");
			String sql = "select * from addressbook";

			try {
				preparedStatement = connection.prepareStatement(sql);
                resultSet = preparedStatement.executeQuery();
                if (resultSet!=null) {

                	request.getSession().setAttribute("user",user);

                	addressbook = new ArrayList();
    				try {
    					while (resultSet.next()) {
    						Address address = new Address();
    						address.setId(resultSet.getInt(1));
    						address.setName(resultSet.getString(2));
    						address.setPhone1(resultSet.getString(3));
    						address.setPhone2(resultSet.getString(4));
    						addressbook.add(address);
    					}
    				} catch (Exception e) {
    					System.out.println("封装数据集失败");
    					e.printStackTrace();
    				}
				}
                HttpSession httpSession = request.getSession();
              httpSession.setMaxInactiveInterval(7200);
              httpSession.setAttribute("addressbook", addressbook);
              response.sendRedirect("addresslist.jsp");
			}catch (SQLException e) {
				e.printStackTrace();
			}

				try {
					if (preparedStatement != null)
						preparedStatement.close();
					if (connection != null)
						connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			
		}else {

				out.println("<script>alert('用户名或密码有误！');window.location.href='login.jsp'</script>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

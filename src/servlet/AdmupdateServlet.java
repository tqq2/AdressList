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
import entity.user;
import util.DbConnect;

/**
 * Servlet implementation class updateServlet
 */
@WebServlet(urlPatterns="/AdmupdateServlet")
public class AdmupdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public AdmupdateServlet() {
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
        String updatepwd = request.getParameter("updatepwd");
        String updatephone = request.getParameter("updatephone");

        userslistImpl ui = new userslistImpl();
        List users=ui.update(updatename,updatepwd,updatephone,id);
        HttpSession httpSession = request.getSession();

        httpSession.setAttribute("updatename", updatename);

       if(users!=null){
        httpSession.setAttribute("users", users);
        response.sendRedirect("userslist.jsp");
            }else {
                httpSession.setAttribute("message", "更新操作失败");
                response.sendRedirect("error.jsp");
            }

    }

}

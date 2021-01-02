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

import dao.userslistImpl;
import entity.Address;
import entity.user;
import util.DbConnect;

/**
 * Servlet implementation class addServlet
 */
@WebServlet("/AdmaddServlet")
public class AdmaddServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public AdmaddServlet() {
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
        String addpwd= request.getParameter("addpwd");
        String addphone = request.getParameter("addphone");

        userslistImpl ui = new userslistImpl();
        List users=ui.InsetInto(addname,addpwd,addphone);
        HttpSession httpSession = request.getSession();

        if (addname.equals("")||addpwd.equals("")){
            out.println("<script>alert('用户必须要有名字和密码，按确定键为您重新选择添加！');window.location.href='userslist.jsp'</script>");
        }

        else{
            if(users!=null){

                httpSession.setAttribute("users", users);
                    response.sendRedirect("userslist.jsp");
            }else {
                    httpSession.setAttribute("message", "添加信息失败");
                    response.sendRedirect("error.jsp");
                }
        }

    }

}

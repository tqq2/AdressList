package servlet;

import dao.userslistImpl;
import entity.user;
import util.DbConnect;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/registerServlet")
public class registerServlet extends HttpServlet {


    public registerServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        String username = request.getParameter("username");
        String userpwd = request.getParameter("userpwd");
        String userphone = request.getParameter("userphone");

//        //用户注册
        userslistImpl ui = new userslistImpl();
        int x = ui.register(username,userpwd,userphone);
        HttpSession httpSession = request.getSession();

        if(username.equals("")||userpwd.equals("")||userphone.equals(""))
        {
            out.println("<script>alert('姓名/密码/电话都必须填写，按确定键为您重新注册！');window.location.href='index.jsp'</script>");
        }else {
                     if(x==1){
                         List users=ui.register2(username,userpwd,userphone);
                         if(users!=null){
                             httpSession.setAttribute("users", users);
                             out.println("<script>alert('恭喜完成注册，按确定键为您跳转至登录界面！');window.location.href='login.jsp'</script>");
                         }else{
                             httpSession.setAttribute("message", "添加信息失败");
                             response.sendRedirect("error.jsp");
                         }

                } else if(x==2){
                    out.println("<script>alert('手机号被注册过，按确定键重新注册哦！');window.location.href='index.jsp'</script>");

            } else {
                out.println("<script>alert('用户名被注册过，按确定键重新注册哦！');window.location.href='index.jsp'</script>");
            }


//
//            String sql = "select * from users where user_account='"
//                    + username + "'";
//            try {
//                preparedStatement = connection.prepareStatement(sql);
//                resultSet = preparedStatement.executeQuery();
//
//                if (resultSet.next()) {
//                    flag = resultSet.getInt("user_id");
//                }
//
//            } catch (SQLException e) {
//                System.out.println("封装数据集失败");
//                e.printStackTrace();
//            }
//
//            if (flag == 0) {
//
//
//                sql = "select * from users where phone1='"
//                        + userphone + "'";
//                try {
//                    preparedStatement = connection.prepareStatement(sql);
//                    resultSet = preparedStatement.executeQuery();
//
//                    if (resultSet.next()) {
//                        flag2 = resultSet.getInt("user_id");
//                    }
//
//                } catch (SQLException e) {
//                    System.out.println("封装数据集失败");
//                    e.printStackTrace();
//                }
//
//
//                if (flag2 == 0) {
//
//
//                    sql = "insert into users (user_account,user_password,phone1) values(?,?,?)";
//                    try {
//                        preparedStatement = connection.prepareStatement(sql);
//                        preparedStatement.setString(1, username);
//                        preparedStatement.setString(2, userpwd);
//                        preparedStatement.setString(3, userphone);
//                        int i = preparedStatement.executeUpdate();
//                        HttpSession httpSession = request.getSession();
//
//                        if (i == 1) {
//                            String selectsql = "select * from users";
//                            preparedStatement = connection.prepareStatement(selectsql);
//                            resultSet = preparedStatement.executeQuery();
//
//                            httpSession.setMaxInactiveInterval(7200);
//                            if (resultSet != null) {
//                                users = new ArrayList();
//
//                                try {
//                                    while (resultSet.next()) {
//                                        user u = new user();
//                                        u.setUser_account(resultSet.getString(1));
//                                        u.setUser_password(resultSet.getString(2));
//                                        u.setPhone1(resultSet.getString(3));
//
//                                        users.add(u);
//                                    }
//                                } catch (Exception e) {
//                                    System.out.println("封装数据集失败");
//                                    e.printStackTrace();
//                                }
//                            }
//                        }
//
//                        httpSession.setAttribute("users", users);
//                        out.println("<script>alert('恭喜完成注册，按确定键为您跳转至登录界面！');window.location.href='login.jsp'</script>");
//
//
//                } else {
//                    out.println("<script>alert('手机号被注册过，按确定键重新注册哦！');window.location.href='index.jsp'</script>");
//                }
//
//
//            } else {
//                out.println("<script>alert('用户名被注册过，按确定键重新注册哦！');window.location.href='index.jsp'</script>");
//            }


        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   doGet(request,response);
    }
}

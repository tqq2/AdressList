package dao;

import entity.user;
import util.DbConnect;

import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class userslistImpl {

//    用到的JDBC
    Connection connection = DbConnect.getConnection();
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    public userslistImpl() {
    }


    public  List  register2( String username,String addpwd,String userphone){
        List<user> users = new ArrayList();
        String sql = "insert into users (user_account,user_password,phone1) values(?,?,?)";

        try {
            preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, username);
        preparedStatement.setString(2, addpwd);
        preparedStatement.setString(3, userphone);
        int i = preparedStatement.executeUpdate();

        if (i == 1) {
            String selectsql = "select * from users";
            preparedStatement = connection.prepareStatement(selectsql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                user u = new user();
                u.setUser_id(resultSet.getInt(1));
                u.setUser_account(resultSet.getString(2));
                u.setUser_password(resultSet.getString(3));
                u.setPhone1(resultSet.getString(4));
                users.add(u);
            }
        }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }


    //注册一个用户信息
    public  int register( String username,String addpwd,String userphone) {
        //用户注册
        int flag = 0;//用户名查重注册标志
        int flag2 = 0;//电话号码查重注册标志

        String sql = "select * from users where user_account='"
                + username + "'";

        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                flag = resultSet.getInt("user_id");
            }

            if (flag == 0) {
                sql = "select * from users where phone1='"
                        + userphone + "'";
                preparedStatement = connection.prepareStatement(sql);
                resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    flag2 = resultSet.getInt("user_id");
                }
                  if (flag2 == 0) {
                    return 1;//都没有被注册
                   }else{
                      return 2; //手机号被注册
                  }

             }

        } catch (SQLException e) {
            e.printStackTrace();
        }
//            else {
//                return 3;
//            }
        return 3;//ID被注册

    }


//增加一个用户信息
public  List InsetInto( String addname,String addpwd,String addphone){

    String sql = "insert into users (user_account,user_password,phone1) values(?,?,?)";
    List<user> users = new ArrayList();


    try {
        preparedStatement = connection.prepareStatement(sql);

    preparedStatement.setString(1, addname);
    preparedStatement.setString(2, addpwd);
    preparedStatement.setString(3, addphone);
    int i = preparedStatement.executeUpdate();

    if (i == 1)

    {
        String selectsql = "select * from users";
        preparedStatement = connection.prepareStatement(selectsql);
        resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                user u = new user();
                u.setUser_id(resultSet.getInt(1));
                u.setUser_account(resultSet.getString(2));
                u.setUser_password(resultSet.getString(3));
                u.setPhone1(resultSet.getString(4));
                users.add(u);
            }


    }

    return users;
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return users;
}

//删除一个用户信息
public  List delete(String id) {

    String sql = "delete from users where user_id = ?";
    List<user> users = new ArrayList();

    try {
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, id);
        int i = preparedStatement.executeUpdate();
            if (i == 1) {
            String selectsql = "select * from users";
            preparedStatement = connection.prepareStatement(selectsql);
            resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    user u = new user();
                    u.setUser_id(resultSet.getInt(1));
                    u.setUser_account(resultSet.getString(2));
                    u.setUser_password(resultSet.getString(3));
                    u.setPhone1(resultSet.getString(4));
                    users.add(u);
            }
        }
        return users;
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return users;
}

//模糊查询用户表
public  List<user> select(int x,String search){

    List<user> users = new ArrayList();
     String  sql =null;
     if(x==1){
         sql= "select * from users where user_account like '%" + search + "%'";
     }else if (x==2){
         sql = "select * from users where phone1 like '%"+search+"%'";
     }else{
        sql = "select * from users";
    }

    try {
        preparedStatement = connection.prepareStatement(sql);
        resultSet = preparedStatement.executeQuery();

               while (resultSet.next()) {
                    user u = new user();
                    u.setUser_id(resultSet.getInt(1));
                    u.setUser_account(resultSet.getString(2));
                    u.setUser_password(resultSet.getString(3));
                    u.setPhone1(resultSet.getString(4));
                    users.add(u);
                }

        return users;
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return users;
}


//修改用户表
    public  List update( String addname,String addpwd,String addphone,String id){

        String sql = "update users set user_account=?,user_password=?,phone1=? where user_id ="+id;
        List<user> users = new ArrayList();

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, addname);
            preparedStatement.setString(2, addpwd);
            preparedStatement.setString(3, addphone);
            int i = preparedStatement.executeUpdate();
            if (i == 1)

            {
                String selectsql = "select * from users";
                preparedStatement = connection.prepareStatement(selectsql);
                resultSet = preparedStatement.executeQuery();

                    while (resultSet.next()) {
                        user u = new user();
                        u.setUser_id(resultSet.getInt(1));
                        u.setUser_account(resultSet.getString(2));
                        u.setUser_password(resultSet.getString(3));
                        u.setPhone1(resultSet.getString(4));
                        users.add(u);
                    }

            }

            return users;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

}
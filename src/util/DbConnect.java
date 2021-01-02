package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnect {
    public static Connection connection;
    public static String url = "jdbc:mysql://localhost:3306/address?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=UTF-8";
    private static String username = "root";
	private static String password ="123456";
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");// 加载数据库驱动程序
            connection = DriverManager.getConnection(url,username, password);//取得数据库连接对象
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }catch (Exception e) {
        	System.out.println("数据库连接失败");
        	e.printStackTrace();
		}
        return connection;
    }

//    进行数据库的关闭操作

    public void close() {
        if (this.connection != null) {
            try {
                this.connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

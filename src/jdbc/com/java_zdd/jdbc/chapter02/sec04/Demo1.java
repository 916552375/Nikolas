package jdbc.com.java_zdd.jdbc.chapter02.sec04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Demo1 {
    //数据连接地址
    private static String dbUrl = "jdbc:mysql://192.168.1.152:3306/db_book?useSSL=true";
    //数据库用户名称
    private static String dbUser = "root";
    //数据库用户密码
    private static String dbPassword = "123456";
    //需要加载的驱动名称
    private static String dbDriver = "com.mysql.jdbc.Driver";
    //数据库连接
    private static Connection conn = null;

    public static void main(String[] args) {

        try {
            //加载驱动
            Class.forName(dbDriver);
            //获取连接
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("数据库驱动加载失败！");
        }
        try {
            conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
            System.out.println("数据库连接成功！");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("数据库连接失败！");
        } finally {
            if (null != conn) {

                try {
                    conn.close();
                    System.out.println("数据库连接断开！");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }else{
                System.out.println("数据并未连接，不需要断开操作！");
            }
        }
    }
}

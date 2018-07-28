package jdbc.com.java_zdd.jdbc.chapter02.sec03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * Author：zdd
 * 测试jdbc连接mysql数据库
 */
public class Demo1 {
    static String url="jdbc:mysql://192.168.1.152:3306/db_book?useSSL=false";
    static String user="root";
    static String pass="123456";
    static String driver="com.mysql.jdbc.Driver";
    static Connection conn = null;
    public static void main(String[] args) {
        try{
        Class.forName(driver);
            System.out.println("加载驱动程序成功！");
            System.out.println("驱动程序："+driver);
        conn = DriverManager.getConnection(url,user,pass);
            System.out.println("数据库连接成功！");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
            System.out.println("加载驱动失败！");
        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("连接数据库失败！");
        }finally{
            try {
            conn.close();
                System.out.println("数据库连接已经关闭！");
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}

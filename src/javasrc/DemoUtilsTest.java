package javasrc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
public class DemoUtilsTest {
    public static void main(String args[]){
        Connection conn =null ;
        conn= DemoUtilsTest.getConn();
        DemoUtilsTest.disConn(conn);

    }
    private static String userName="root";
    private static String password="123456";
    private static String url="jdbc:mysql://192.168.1.152:3306/db_book?useSSL=false";
    private static String driver="com.mysql.jdbc.Driver";
    private static Connection conn = null ;

    private static Connection getConn(){
        try{

        Class.forName(driver);
        conn=DriverManager.getConnection(url,userName,password);
        System.out.println("数据库连接成功！");
        }catch(ClassNotFoundException cs){
            cs.printStackTrace();
        }catch(SQLException sqle){
            sqle.printStackTrace();
        }

        return conn ;
    }
    private static void disConn(Connection conn){
        if(null ==conn){
            System.out.println("数据库未连接，不需要断开操作！");
        }else{
            try{
            conn.close();
                System.out.println("数据库连接已经断开！");
            }catch(SQLException e){
                e.printStackTrace();
            }finally{
                return ;
            }
        }
    }
}

package javasrc; /**
 * @Author:zdd
 * @Despcription: db connection test
 * @Date: Created in 2018/7/10 14:48
 * @Modified by:zdd
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DbUtils {

    private  String url = "jdbc:mysql://localhost:3306/test?useSSL=false";
    private  String user = "zdd";
    private  String pwd = "admin123.";
    private  Connection conn = null;

    /**
     *
     * @return 返回数据库连接
     */
    private  Connection getConn() {


        try {

            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null ;
        }
        try {
            conn = DriverManager.getConnection(url, user, pwd);
        } catch (SQLException s) {
            s.printStackTrace();
            System.out.println("连接数据库失败，请仔细检查程序。");
            return null;

        }finally{
            System.out.println("不管程序是否出现异常,finally内的语句都会执行的。");
        }

        System.out.println("zdd用户连接test数据库成功。");

        return conn;
    }
    private static void disConnection(Connection conn){
        if(null == conn){
            System.out.println("并未连接数据库,不需要断开数据库操作。");
            return ;
        }else{
            try{

            conn.close();
            }catch(SQLException e){
                e.printStackTrace();
                return ;
            }
        }
        System.out.println("成功关闭了数据库连接。");
    }

    public static void main(String args[]) {
        String sql = "select * from courses where name = 'bat'";
        String name = null;
        String cls = null;
        PreparedStatement stmt = null;
        Connection conn = null;
        conn = new DbUtils().getConn();
        try{

        stmt = conn.prepareStatement(sql);
        }catch(SQLException e){
            e.printStackTrace();
        }
        try{

        ResultSet rs =stmt.executeQuery(sql);
            System.out.println("查询结果如下:");
            System.out.println("name------class------descrption");
            while(rs.next()){
                System.out.println(rs.getString("name")+"\t\t"+rs.getString("class")+"\t"+rs.getString("description"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        DbUtils.disConnection(conn);
    }
}
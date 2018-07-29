package jdbc.com.java_zdd.jdbc.util;

import java.sql.*;

public class DbUtil {
    //数据连接地址
//    private static String dbUrl = "jdbc:mysql://192.168.1.152:3306/db_book?useSSL=true&characterEncoding=utf-8";
    private static String dbUrl = "jdbc:mysql://192.168.1.152:3306/db_bank?useSSL=true&characterEncoding=utf-8";
    //数据库用户名称
    private static String dbUser = "root";
    //数据库用户密码
    private static String dbPassword = "123456";
    //需要加载的驱动名称
    private static String dbDriver = "com.mysql.jdbc.Driver";
    //数据库连接
    private static Connection conn = null;

    /**
     * 获取数据库连接
     *
     * @return 返回连接
     * @throws Exception
     */
    public Connection getConn() throws Exception {
        Class.forName(dbDriver);
        conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
        return conn;
    }

    /**
     * 关闭数据库连接
     *
     * @param conn 连接
     * @throws Exception
     */
    public void DisConn(Connection conn) throws Exception {
        if (null != conn) {
            conn.close();
        } else {
            return;
        }
    }

    public void close(Statement stmt, Connection conn) throws Exception {
        if (null != stmt) {
            stmt.close();
            if (null != conn) {
                conn.close();
            }
        }
    }
    public void close(PreparedStatement pstmt, Connection conn) throws Exception {
        if (null != pstmt) {
            pstmt.close();
            if (null != conn) {
                conn.close();
            }
        }
    }
    public void close(CallableStatement cstmt, Connection conn)throws Exception{
        if(null != cstmt){
            cstmt.close();
            if(null != conn){
                conn.close();
            }
        }
    }
}
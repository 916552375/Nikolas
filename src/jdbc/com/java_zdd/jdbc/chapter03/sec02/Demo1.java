package jdbc.com.java_zdd.jdbc.chapter03.sec02;

import jdbc.com.java_zdd.jdbc.util.DbUtil;

import java.sql.Connection;
import java.sql.Statement;

/**
 * 往t_book表插入数据记录
 */
public class Demo1 {
    public static void main(String[] args) throws Exception{
        DbUtil dbUtil = new DbUtil();
        String sql = "insert into t_book values(null,'Java编程指北针','B哥','男',88.0,'屌丝程序猿必读',16)";
        Connection conn = null ;
        conn = dbUtil.getConn();//获取数据库连接
        Statement stmt =  conn.createStatement();//获取Statement
        int result = stmt.executeUpdate(sql);
        System.out.println("增加了"+result+"条记录。");
        stmt.close();//关闭Statement
        conn.close();//关闭连接
    }
}

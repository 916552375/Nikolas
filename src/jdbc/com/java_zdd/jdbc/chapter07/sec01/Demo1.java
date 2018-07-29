package jdbc.com.java_zdd.jdbc.chapter07.sec01;

import jdbc.com.java_zdd.jdbc.util.DbUtil;

import java.lang.reflect.Type;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;

public class Demo1 {
    private static DbUtil dbUtil = new DbUtil();

    /**
     * 调用存储过程，通过id查询bookName
     * @param  id 图书id
     * @return
     * @throws Exception
     */
    private static String getBookNameById(int id)throws  Exception{
        Connection conn = dbUtil.getConn();//获取数据库连接
        String sql = "{call pro_getBookNameById(?,?) }";
        CallableStatement cstmt = conn.prepareCall(sql);
        cstmt.setInt(1,id);//设值第一个参数
        cstmt.registerOutParameter(2, Types.VARCHAR);//设值返回类型为varchar类型
       cstmt.execute();
       String bookName = cstmt.getString("bN");//获取返回值
        cstmt.close();
        dbUtil.close(cstmt,conn);
        return bookName;
    }

    public static void main(String[] args)throws Exception {
        System.out.println("图书名称是："+getBookNameById(Integer.valueOf(args[0])));
    }
}

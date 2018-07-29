package jdbc.com.java_zdd.jdbc.chapter03.sec04;

import jdbc.com.java_zdd.jdbc.util.DbUtil;

import java.sql.Connection;
import java.sql.Statement;

public class Demo1 {
    private static DbUtil dbUtil = new DbUtil();

    private static int deleteBook(int id) throws Exception{
        Connection conn = dbUtil.getConn();
        String sql = "delete from t_book where id ="+id+";";
        Statement stmt = conn.createStatement();
        System.out.println("使用的sql脚本如下：");
        System.out.println(sql);
        int result = stmt.executeUpdate(sql);
        dbUtil.close(stmt, conn);
        return result;
    }

    public static void main(String[] args)throws Exception {
        int result = deleteBook(28);
        if(1 ==result){
            System.out.println("删除图书成功！");
        }else{
            System.out.println("删除图书失败！");
        }
    }


}

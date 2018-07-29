package jdbc.com.java_zdd.jdbc.chapter04.sec04;

import jdbc.com.java_zdd.jdbc.util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Demo1 {
    private static DbUtil dbUtil = new DbUtil();
    private static int deleteBook(int id)throws Exception{
        Connection conn = dbUtil.getConn();
        String sql ="delete from t_book where id=?";
        PreparedStatement pstmt =conn.prepareStatement(sql);
        pstmt.setInt(1,id);
        int result = pstmt.executeUpdate();
        dbUtil.close(pstmt,conn);
        return result;
    }
    public static void main(String[] args) throws Exception{
        int result = deleteBook(20);
        if(1==result){
            System.out.println("删除图书成功！");
        }else{
            System.out.println("删除图书失败！");
        }
    }
}

package jdbc.com.java_zdd.jdbc.chapter09.sec03;

import jdbc.com.java_zdd.jdbc.util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Demo1 {
    private static DbUtil dbUtil = new DbUtil();

    /**
     * 转出操作
     * @param conn
     * @param accountName   帐户名
     * @param account 转账金额
     * @throws Exception
     */
    private static void outCount(Connection conn,String accountName,int account)throws Exception{
        String sql = "update t_account set accountBalance=accountBalance-? where accountName=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1,account);
        pstmt.setString(2,accountName);
        pstmt.executeUpdate();
    }

    private static void inCount(Connection conn,String accountName,int account)throws Exception{
        String sql = "update t_account set accounBalance=accountBalance+? where accountName=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1,account);
        pstmt.setString(2,accountName);
        pstmt.executeUpdate();
    }
    public static void main(String[] args){
        Connection conn = null;

        try {
            conn = dbUtil.getConn();
            conn.setAutoCommit(false);//取消自动提交，这是事务的关键！
            System.out.println("李四开始张三向转账100元。");
            int account = 100;
            outCount(conn,"李四",100);
            inCount(conn,"张三",100);
            System.out.println("转账成功！");
        } catch (Exception e) {
            try {
                conn.rollback();//发生异常，回滚事务
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }finally{
            try {
                conn.commit();//提交事务
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
//每个Connection是独立的事务
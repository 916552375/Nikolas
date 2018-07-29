package jdbc.com.java_zdd.jdbc.chapter08.sec02;

import jdbc.com.java_zdd.jdbc.util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;

public class Demo1 {
    public static void main(String[] args) throws Exception{
        DbUtil dbUtil = new DbUtil();
        Connection conn  = dbUtil.getConn();
        String sql = "select * from t_book";
        PreparedStatement pstmt = conn.prepareStatement(sql);
       ResultSetMetaData resultSetMetaData = pstmt.getMetaData();//获得是结果集数据
       int count =  resultSetMetaData.getColumnCount();//获取元数据类的总数
        System.out.println("t_book表的列数="+count);
        for(int i = 1;i< count;i++){//遍历列名称，从1开始的
            System.out.println("第"+i+"列名称："+resultSetMetaData.getColumnName(i)+"\t列数据类型："+resultSetMetaData.getColumnTypeName(i));
        }
    }
}

package jdbc.com.java_zdd.jdbc.chapter08.sec01;

import jdbc.com.java_zdd.jdbc.util.DbUtil;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSetMetaData;

public class Demo1 {
    public static void main(String[] args) throws Exception{
        DbUtil dbUtil = new DbUtil();
        Connection conn = dbUtil.getConn();
        DatabaseMetaData databaseMetaData = conn.getMetaData();//获取元数据
        System.out.println("数据库名称："+databaseMetaData.getDatabaseProductName());
        System.out.println("驱动程序版本："+databaseMetaData.getDriverVersion());
        System.out.println("数据库驱动程序主版本号："+databaseMetaData.getDriverMajorVersion());
        System.out.println("数据库驱动程序次版本号："+databaseMetaData.getDriverMinorVersion());
        System.out.println("数据库驱动程序版本号："+databaseMetaData.getDriverMajorVersion()+"."+databaseMetaData.getDriverMinorVersion());

    }
}

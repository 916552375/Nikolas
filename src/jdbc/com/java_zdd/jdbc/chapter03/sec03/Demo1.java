package jdbc.com.java_zdd.jdbc.chapter03.sec03;

import jdbc.model.Book;
import jdbc.com.java_zdd.jdbc.util.DbUtil;

import java.sql.Connection;
import java.sql.Statement;

public class Demo1 {
    private static DbUtil dbUtil = new DbUtil();

    private static int updateBook(Book book) throws Exception {
        Connection conn = dbUtil.getConn();
        String sql = "update t_book set bookName= " + "'" + book.getBookName() + "',price=" + book.getPrice()
                +",bookTypeId=" + book.getBookTypeId() + " where id=" + book.getId() + ";";


        Statement stmt = conn.createStatement();
        System.out.println("使用的sql脚本如下：");
        System.out.println(sql);
        int result = stmt.executeUpdate(sql);
        dbUtil.close(stmt, conn);
        return result;
    }

    public static void main(String[] args) throws Exception{
        Book book = new Book(26,"神话程序猿大牛蛋","牛蛋哥","男",1024.6f,"男",16);
   int result = updateBook(book);
        System.out.println(result);
    }
}

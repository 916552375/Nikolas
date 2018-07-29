package jdbc.com.java_zdd.jdbc.chapter05.sec02;

import jdbc.com.java_zdd.jdbc.util.DbUtil;
import jdbc.model.Book;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Demo1 {
    private static DbUtil dbUtil = new DbUtil();

    /**
     * 遍历查询结果
     * @throws Exception
     */
    private static void listBook() throws Exception {
        Connection conn = dbUtil.getConn();
        String sql = "select * from t_book";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            int id = rs.getInt(1);//获取第一个列的值 编号id
            String bookName = rs.getString(2);//获取第二个列的值  图书名称
            String author = rs.getString(3);//获取第三列的值   图书作者
            float price = rs.getFloat(5);//获取第四列的值    图书价格
            System.out.println("图书编号:" + id + "图书名称：" + bookName + "图书作者：" + author + "图书价格：" + price);
            System.out.println("==+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++==");
        }
    }
    private static void listBook2() throws Exception {
        Connection conn = dbUtil.getConn();
        String sql = "select * from t_book";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            String bookName = rs.getString("bookName");//获取第二个列的值  图书名称
            String author = rs.getString("author");//获取第三列的值   图书作者
            float price = rs.getFloat(5);//获取第四列的值    图书价格
            System.out.println("图书名称：" + bookName + "图书作者：" + author + "图书价格：" + price+"元");
            System.out.println("==+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++==");
        }
    }
    private static List<Book> listBook3()throws Exception{
        List<Book> bookList=new ArrayList<Book>();
        Connection conn = dbUtil.getConn();
        String sql = "select * from t_book";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            int id = rs.getInt(1);//获取第一个列的值 编号id
            String bookName = rs.getString("bookName");//获取第二个列的值  图书名称
            String author = rs.getString("author");//获取第三列的值   图书作者
            float price = rs.getFloat("price");//获取第四列的值    图书价格
            Book book = new Book(id,bookName,price, author);
            bookList.add(book);
        }
        return bookList ;
    }
    public static void main(String[] args) throws Exception {
//        listBook();
//        listBook2();
        List<Book> bookList = listBook3();
        for(Book book : bookList){
//            System.out.println("图书id："+book.getId()+"图书名称："+book.getBookName()+"图书作者："+"图书价格："+book.getPrice()+"元");
            System.out.println(book);
        }
    }
}
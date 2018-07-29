package jdbc.com.java_zdd.jdbc.chapter04.sec02;

import jdbc.com.java_zdd.jdbc.util.DbUtil;
import jdbc.model.Book;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class Demo1 {
    private static DbUtil dbUtil=new DbUtil();
    private static int addBook(Book book)throws Exception{
        Connection conn=dbUtil.getConn();//获取连接
//        String sql= "insert into t_book values(null,bookName,author,sex,price,bookDesc,bookTypeId)";
        String sql= "insert into t_book values(null,?,?,?,?,?,?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,book.getBookName());//给第一个坑设值
        pstmt.setString(2,book.getAuthor());//给第二个坑设值
        pstmt.setString(3,book.getSex());//给第三个坑设值
        pstmt.setFloat(4,book.getPrice());//给第四个坑设值
        pstmt.setString(5,book.getBookDesc());//给第五个坑设值
        pstmt.setInt(6,book.getBookTypeId());//给第六个坑设值
        int result = pstmt.executeUpdate();
        dbUtil.close(pstmt,conn);
        return result;
    }
    public static void main(String[] args) throws Exception{
        Book book = new Book("三国演义","罗贯中","男",44.3f,"经典的古典小说，三国故事，十分精彩",22);
        int result = addBook(book);
        if(1==result){
            System.out.println("添加图书成功！");
        }else{
            System.out.println("添加图书失败！");
        }
    }
}

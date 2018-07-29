package jdbc.com.java_zdd.jdbc.chapter04.sec03;

import jdbc.com.java_zdd.jdbc.util.DbUtil;
import jdbc.model.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;


public class Demo1 {
    /**
     * 更新图书
     * @param book
     * @return
     * @throws Exception
     */
    private  static int updateBook(Book book)throws Exception{

        Connection conn = dbUtil.getConn();
        String sql =" update t_book set bookName=?,author=?,sex=?,price=?,bookDesc=?,bookTypeId=? where id=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,book.getBookName());
        pstmt.setString(2,book.getAuthor());
        pstmt.setString(3,book.getSex());
        pstmt.setFloat(4,book.getPrice());
        pstmt.setString(5,book.getBookDesc());
        pstmt.setInt(6,book.getBookTypeId());
        pstmt.setInt(7,book.getId());
        int result = pstmt.executeUpdate();
        dbUtil.close(pstmt,conn);
        return result;
    }

    private static DbUtil dbUtil =new DbUtil() ;

    public static void main(String[] args) throws Exception{
        Book book = new Book(29,"三国演义","罗贯中","男",55.8f,"经典的古典小说，三国故事，十分精彩。值得一读",22);
        int result = updateBook(book);
        if(1==result){
            System.out.println("图书修改成功！");
        }else {
            System.out.println("图书修改失败！");
        }
    }

}

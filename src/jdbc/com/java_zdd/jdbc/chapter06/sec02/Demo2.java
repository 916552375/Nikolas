package jdbc.com.java_zdd.jdbc.chapter06.sec02;

import jdbc.com.java_zdd.jdbc.util.DbUtil;
import jdbc.model.Book;

import java.io.FileOutputStream;
import java.sql.Blob;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Demo2 {
    private static DbUtil dbUtil=new DbUtil();

    /**
     * 添加图书
     * @param book
     * @return
     * @throws Exception
     */
    private static int addBook(Book book)throws Exception{
        Connection conn=dbUtil.getConn();//获取连接
        String sql= "insert into t_book values(null,?,?,?,?,?,?,?,?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,book.getBookName());//给第一个坑设值
        pstmt.setString(2,book.getAuthor());//给第二个坑设值
        pstmt.setString(3,book.getSex());//给第三个坑设值
        pstmt.setFloat(4,book.getPrice());//给第四个坑设值
        pstmt.setString(5,book.getBookDesc());//给第五个坑设值
        pstmt.setInt(6,book.getBookTypeId());//给第六个坑设值
        File content = book.getContext();//获取文件
        InputStream inputStream = new FileInputStream(content);


        pstmt.setAsciiStream(7,inputStream,content.length());
        File picture = book.getPic();//获取文件

        InputStream inputStream2 = new FileInputStream(picture);
        pstmt.setBinaryStream(8,inputStream2,picture.length());
        int result = pstmt.executeUpdate();
        dbUtil.close(pstmt,conn);
        return result;

    }
    public static void getBook(int id) throws Exception{
        Connection conn = dbUtil.getConn();
        String sql = "select * from t_book where id =?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1,id);
        ResultSet rs = pstmt.executeQuery();
        if(rs.next()){
            String bookName =rs.getString("bookName");
            String author = rs.getString("author");
            float price = rs.getFloat("price");
            int bookTypeId = rs.getInt("bookTypeId");
            Blob b =rs.getBlob("picture");
            FileOutputStream out= new FileOutputStream(new File("c:/datatest/bondman.jpg"));
            out.write(b.getBytes(1,(int)b.length()));
            out.close();
            System.out.println("图书名称："+bookName);
            System.out.println("图书作者："+author);
            System.out.println("图书价格："+price);
            System.out.println("图书类别id："+bookTypeId);
            System.out.println("图书内容：");
        }
        dbUtil.close(pstmt,conn);
    }
    public static void main(String[] args) throws Exception{
        File context = new File("d:"+File.separator+"data"+File.separator+"bondman.txt");
        File pic = new File("d:"+File.separator+"data"+File.separator+"lxl.jpg");
        Book book = new Book("房奴向钱冲","克拉使者","女",22.0f,"买房一切都为了结婚和以后孩子的良好教育，父母为了自己孩子什么都能苦，都能累。",9,context,pic);
        int result = addBook(book);
        if(1==result){
            System.out.println("添加图书成功！");
        }else{
            System.out.println("添加图书失败！");
        }
   // getBook(105);
    }
}
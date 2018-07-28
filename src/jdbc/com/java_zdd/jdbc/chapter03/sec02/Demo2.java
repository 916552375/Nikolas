package jdbc.com.java_zdd.jdbc.chapter03.sec02;
import jdbc.model.Book;
import jdbc.com.java_zdd.jdbc.util.DbUtil;

import java.sql.Connection;
import java.sql.Statement;

public class Demo2 {
    private static DbUtil dbUtil = new DbUtil();

    /**添加图书2
     *
     * @param book
     * @return
     * @throws Exception
     */
    private static int addBook2(Book book)throws Exception{
        Connection conn = dbUtil.getConn();//获取连接
        Statement stmt = conn.createStatement();//创建Statement
        String sql2 = "insert into t_book values(null,'"+book.getBookName()+"','"+book.getAuthor()+"','"+book.getSex()+"',"+book.getPrice()+",'"+book.getBookDesc()+"',"+book.getBookTypeId()+");";
        System.out.println("使用的sql脚本如下：");
        System.out.println(sql2);
        int result = stmt.executeUpdate(sql2);
        dbUtil.close(stmt,conn);//关闭Statement，关闭连接
        return result;
    }



    /**
     * 添加图书
     * @param bookName  图书名称
     * @param author    图书作者
     * @param sex   作者性别
     * @param price 图书价格
     * @param bookDesc  图书描述
     * @param bookTypeId    图书类别id
     * @return
     */
    private static int addBook(String bookName,String author,String sex,float price,String bookDesc,int bookTypeId)throws Exception{
        Connection conn = dbUtil.getConn();//获取连接
        Statement stmt = conn.createStatement();//创建Statement
        String sql = "insert into t_book values(null,'"+bookName+"','"+author+"','"+sex+"',"+price+",'"+bookDesc+"',"+bookTypeId+");";
        System.out.println("使用的sql脚本如下：");
        System.out.println(sql);
        int result = stmt.executeUpdate(sql);
        dbUtil.close(stmt,conn);//关闭Statement，关闭连接
        return result;
    }
    public static void main(String[] args) throws Exception {
/*       int result= addBook("炸窝编程","不知名程序猿","女",15.8f,"好像很好看的一本书，大概作者是双鱼座的",16);
       if(1 == result){
           System.out.println("添加图书成功！");
       }else {
           System.out.println("添加图书失败！");
       }*/
//idea多行注释Ctrl+Shift+/
        Book book = new Book("大话程序猿2",1024.0f,"牛皮哥2","据说写得很叼炸天2！","男",16);
        int result2 =addBook2(book);
        if(1 == result2){
            System.out.println("添加图书成功！");
        }else {
            System.out.println("添加图书失败！");
        }
    }
}

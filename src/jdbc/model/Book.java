package jdbc.model;

import java.io.File;

public class Book {
    private int id;
    private String bookName;
    private String author;
    private String sex;
    private float price;
    private String bookDesc;
    private int bookTypeId;
    private File context;
    private File pic ;
    public Book() {
    }

    public Book(int id, String bookName, float price, String author) {
        this.id = id;
        this.bookName = bookName;
        this.price = price;
        this.author = author;
    }
    public Book(String bookName, String author, String sex, float price, File context) {
        this.bookName = bookName;
        this.price = price;
        this.author = author;
        this.sex = sex;
        this.context = context;
    }
    public Book(String bookName, String author, String sex, float price, String bookDesc, int bookTypeId) {
        this.bookName = bookName;
        this.price = price;
        this.author = author;
        this.bookDesc = bookDesc;
        this.sex = sex;
        this.bookTypeId = bookTypeId;
    }
    public Book(int id, String bookName, String author,String sex, float price, String bookDesc, int bookTypeId) {
        this.id = id;
        this.bookName = bookName;
        this.author = author;
        this.sex = sex;
        this.price = price;
        this.bookDesc = bookDesc;
        this.bookTypeId = bookTypeId;
    }
    public Book(String bookName, String author, String sex, float price, String bookDesc, int bookTypeId,File context) {
        this.bookName = bookName;
        this.author = author;
        this.price = price;
        this.sex = sex;
        this.bookDesc = bookDesc;
        this.bookTypeId = bookTypeId;
        this.context = context;
    }


    public Book(String bookName, String author, String sex, float price, String bookDesc, int bookTypeId,File context,File pic) {
        this.bookName = bookName;
        this.author = author;
        this.price = price;
        this.sex = sex;
        this.bookDesc = bookDesc;
        this.bookTypeId = bookTypeId;
        this.context = context;
        this.pic = pic;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBookDesc() {
        return bookDesc;
    }

    public void setBookDesc(String bookDesc) {
        this.bookDesc = bookDesc;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getBookTypeId() {
        return bookTypeId;
    }

    public void setBookTypeId(int bookTypeId) {
        this.bookTypeId = bookTypeId;
    }

    public File getContext() {
        return context;
    }

    public void setContext(File context) {
        this.context = context;
    }

    public File getPic() {
        return pic;
    }

    public void setPic(File pic) {
        this.pic = pic;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + this.id +
                ", bookName='" + this.bookName + '\'' +
                ", author=" + this.author +
                ", price='" + this.price + '\'' +"元"+
                '}';
    }
}

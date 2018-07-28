package jdbc.model;

public class Book {
    private int id;
    private String bookName;
    private float price;
    private String author;
    private String bookDesc;
    private String sex;
    private int bookTypeId;

    public Book() {
    }

    public Book(String bookName, float price, String author, String bookDesc, String sex, int bookTypeId) {
        this.bookName = bookName;
        this.price = price;
        this.author = author;
        this.bookDesc = bookDesc;
        this.sex = sex;
        this.bookTypeId = bookTypeId;
    }

    public Book(int id, String bookName, float price, String author, String bookDesc, String sex, int bookTypeId) {
        this.id = id;
        this.bookName = bookName;
        this.price = price;
        this.author = author;
        this.bookDesc = bookDesc;
        this.sex = sex;
        this.bookTypeId = bookTypeId;
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
}

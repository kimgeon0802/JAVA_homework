package mylab.library.entity;

public class Book {

    private String title;
    private String author;
    private String isbn;
    private int publishYear;
    private boolean available;

    public Book(String title, String author, String isbn, int publishYear) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publishYear = publishYear;
        this.available = true;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public boolean isAvailable() {
        return available;
    }

    public void checkOut() {
        available = false;
    }

    public void returnBook() {
        available = true;
    }

    @Override
    public String toString() {
        return "책 제목: " + title +
                "\t저자: " + author +
                "\tISBN: " + isbn +
                "\t출판년도: " + publishYear +
                "\t대출 가능 여부: " + (available ? "가능" : "대출 중");
    }
}
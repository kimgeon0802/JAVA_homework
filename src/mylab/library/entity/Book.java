package mylab.library.entity;

public class Book {
	private String title;//제목
	private String author;//저자
	private String isbn; //도서번호
	private String publishYear;//출판년도
	private boolean isAvailable;//대출상태
	
    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isAvailable = true;   // 기본은 대출 가능
    }
    
    public boolean isAvailable() {
        return isAvailable;
    }

    public void checkOut() {
        if (isAvailable) {
        	isAvailable = false;
        }
    }

    public void returnBook() {
    	isAvailable = true;
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
    
    public String publishYear() {
        return publishYear;
    }
}

package mylab.library.entity;

import java.util.ArrayList;
import java.util.List;

import mylab.library.entity.Book;

public class Library {

    private List<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    // 도서 추가
    public void addBook(Book book) {
        if (book != null) {
            books.add(book);
        }
    }

    // 제목으로 검색
    public Book findByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    // 저자로 검색 (동일 저자의 여러 권 반환)
    public List<Book> findByAuthor(String author) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                result.add(book);
            }
        }
        return result;
    }

    // ISBN으로 검색
    public Book findByISBN(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }

    // 도서 대출
    public boolean checkOutBook(String isbn) {
        Book book = findByISBN(isbn);
        if (book != null && book.isAvailable()) {
            book.checkOut();
            return true;
        }
        return false;
    }

    // 도서 반납
    public boolean returnBook(String isbn) {
        Book book = findByISBN(isbn);
        if (book != null && !book.isAvailable()) {
            book.returnBook();
            return true;
        }
        return false;
    }

    // 대출 가능한 도서 목록
    public List<Book> getAvailableBooks() {
        List<Book> availableBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.isAvailable()) {
                availableBooks.add(book);
            }
        }
        return availableBooks;
    }

    // 모든 도서 목록
    public List<Book> getAllBooks() {
        return new ArrayList<>(books);
    }

    // 전체 도서 수
    public int getTotalBooks() {
        return books.size();
    }

    // 대출 가능한 도서 수
    public int getAvailableBookCount() {
        int count = 0;
        for (Book book : books) {
            if (book.isAvailable()) {
                count++;
            }
        }
        return count;
    }
    
    public int getBorrowedBookCount() {
        return getTotalBooks() - getAvailableBookCount();
    }
}
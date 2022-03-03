package com.example.app;

public class BookDto {
    private String authorFirstName;
    private String authorLastName;
    private String name;
    private String isbn;
    private int BookCount;


    public void setAuthorFirstName(String authorFirstName) {
        this.authorFirstName = authorFirstName;
    }

    public void setAuthorLastName(String authorLastName) {
        this.authorLastName = authorLastName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setBookCount(int bookCount) {
        BookCount = bookCount;
    }

    public String getAuthorFirstName() {
        return authorFirstName;
    }

    public String getAuthorLastName() {
        return authorLastName;
    }

    public String getName() {
        return name;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getBookCount() {
        return BookCount;
    }
}

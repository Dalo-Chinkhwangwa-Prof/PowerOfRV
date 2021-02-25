package com.britishbroadcast.powerofrv;

public class Book {
    private String title;
    private String isbn;
    private int pages;
    private String author;
    private String cover;

    public Book(String title, String isbn, int pages, String author, String cover) {
        this.title = title;
        this.isbn = isbn;
        this.pages = pages;
        this.author = author;
        this.cover = cover;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }
}

package com.example.streamsandspring.Comparator;

public class Books implements Comparable<Books> {

    private String bookName;
    private Integer year;

    public Books(String bookName, Integer year) {
        this.bookName = bookName;
        this.year = year;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    @Override
    public int compareTo(Books book) {
        return this.year - book.getYear();
    }
}

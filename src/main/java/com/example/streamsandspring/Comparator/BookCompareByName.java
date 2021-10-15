package com.example.streamsandspring.Comparator;

import java.util.Comparator;

public class BookCompareByName implements Comparator<Books> {
    @Override
    public int compare(Books o1, Books o2) {
        return o1.getBookName().compareTo(o2.getBookName());
    }
}

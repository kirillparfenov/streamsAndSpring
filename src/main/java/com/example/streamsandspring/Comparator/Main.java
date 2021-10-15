package com.example.streamsandspring.Comparator;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Books> booksList = new ArrayList<>();

        int count = 0;
        do {
            booksList.add(new Books("Имя книги " + (count + 1), count % 2 == 0 ? 1905 + count : 1905 + count + 1));
            count++;
        } while (count < 1000);


        booksList.stream().sorted(new BookCompareByName()).count();
    }
}

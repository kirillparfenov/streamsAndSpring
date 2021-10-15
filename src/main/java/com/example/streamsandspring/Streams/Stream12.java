package com.example.streamsandspring.Streams;

//Вывести текст после знака "-"
public class Stream12 {

    public static void main(String[] args) {
        String bebra = "bebra-121212";

        StringBuilder sb = new StringBuilder();

        bebra.chars()
                .mapToObj(e -> (char) e)
                .skip(bebra.indexOf("-") + 1)
                .forEach(sb::append);
//                 .map(e -> Character.toString(e))
//                 .collect(Collectors.joining());

        System.out.println(sb + "!!!");
    }
}

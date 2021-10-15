package com.example.streamsandspring.Streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//Есть список List<Stream11> list; с 20 объектами с разными статусами. Как удалить из списка все, кроме 3 - "ENABLED", "DISABLED", "ACTIVE"?
public class Stream11 {

    public static void main(String[] args) {
        List<Stream11> list = Arrays.asList(new Stream11("one", Arrays.asList( "MODERATION", "MODERATION_FAILED", "ARCHIVE")),
                new Stream11("two",Arrays.asList("ENABLED", "DISABLED", "ACTIVE")));

        List<Stream11> result = list.stream()
                .filter(e -> e.getStatus().contains("ENABLED")
                        || e.getStatus().contains("DISABLED")
                        || e.getStatus().contains("ACTIVE"))
                .collect(Collectors.toList());

        for(Stream11 str : result) {
            System.out.println(str.getName());
            str.getStatus().forEach(System.out::println);
        }
    }

    private String name;
    private List<String> status = Arrays.asList("ENABLED", "DISABLED", "ACTIVE", "CREATED", "MODERATION", "MODERATION_FAILED", "ARCHIVE");

    public Stream11() {
    }

    public Stream11(String name, List<String> status) {
        this.name = name;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getStatus() {
        return status;
    }

    public void setStatus(List<String> status) {
        this.status = status;
    }
}

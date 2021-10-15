package com.example.streamsandspring.Serialization.Jackson;


import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

public class Jackson {
    public static void main(String[] args) throws IOException {

        Person personWrite = new Person("Masha", "Balashova", 50);

        File file = new File("jackson.txt");
        FileOutputStream fout = new FileOutputStream(file);

        // записываем JSON в файл
        ObjectMapper om = new ObjectMapper();
        om.writeValue(fout, personWrite);

        // читаем JSON из файла в Map<String, Object>
        Map<String, Object> personReadMap = om.readValue(file, Map.class);

        // читаем JSON в объект Person
        Person personRead = om.readValue(file, Person.class);
        System.out.println(personRead);
    }
}

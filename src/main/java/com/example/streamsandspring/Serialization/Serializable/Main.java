package com.example.streamsandspring.Serialization.Serializable;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        // пишем объект в файл
        File file = new File("person.serializable.txt");

        FileOutputStream fou = new FileOutputStream(file);
        ObjectOutputStream out = new ObjectOutputStream(fou);

        Person personWrite = new Person("Petr", "Petrov", 25);
        out.writeObject(personWrite);
        out.close();


        // читаем объект из файла
        FileInputStream fin = new FileInputStream(file);

        ObjectInputStream oin = new ObjectInputStream(fin);
        Person personRead = (Person) oin.readObject();
        System.out.println(personRead);
        oin.close();
    }
}

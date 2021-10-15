package com.example.streamsandspring.Serialization.Externalizable;

import java.io.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {

        // записываем объект в файл
        FileOutputStream fout = new FileOutputStream("person.externalizable.txt");
        ObjectOutputStream out = new ObjectOutputStream(fout);
        Person personWrite = new Person("Kirill", "Parfenov", 30);
        out.writeObject(personWrite);
        out.close();

        // считываем объект из файла
        FileInputStream fin = new FileInputStream(new File("person.externalizable.txt"));
        ObjectInputStream oin = new ObjectInputStream(fin);
        Person personRead = (Person) oin.readObject();
        System.out.println(personRead);
        oin.close();
    }
}

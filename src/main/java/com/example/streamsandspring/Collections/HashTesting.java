package com.example.streamsandspring.Collections;

import java.util.HashMap;
import java.util.Map;

/*
Если в классе Cat не переопределить метод hashCode(), то мы при использовании объекта Cat() в качестве ключа
в HashMap - мы потом не сможешь его найти.
 */
public class HashTesting {
    public static void main(String[] args) {
        Map<Cat, String> catMap = new HashMap<>();
        catMap.put(new Cat(1), "Вася");
        catMap.put(new Cat(2), "Рома");
        catMap.put(new Cat(3), "Том");
        catMap.put(new Cat(2), "Гриша");
        
        System.out.println(catMap.get(new Cat(2)));
        System.out.println();
    }

    private static class Cat {
        private int id;

        public Cat(int id) {
            this.id = id;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Cat cat = (Cat) o;
            return id == cat.id;
        }

        @Override
        public int hashCode() {
            return System.identityHashCode(id);
        }
    }
}

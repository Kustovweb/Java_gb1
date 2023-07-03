import java.util.*;

public class Seminar5 {
    public static void main(String[] args) {
        HashMap<String, ArrayList> phone_book = new HashMap<>();
        phone_book.computeIfAbsent("Евгений", key -> new ArrayList<>()).add("11-22-33");
        phone_book.computeIfAbsent("Евгений", key -> new ArrayList<>()).add("22-33-44");
        phone_book.computeIfAbsent("Василий", key -> new ArrayList<>()).add("11-22-55");
        phone_book.computeIfAbsent("Василий", key -> new ArrayList<>()).add("33-44-55");
        phone_book.computeIfAbsent("Василий", key -> new ArrayList<>()).add("44-66-77");
        phone_book.computeIfAbsent("Алиса", key -> new ArrayList<>()).add("55-66-77");
        phone_book.computeIfAbsent("Ильдар", key -> new ArrayList<>()).add("99-88-77");
        phone_book.computeIfAbsent("Мария", key -> new ArrayList<>()).add("10-11-22");
        phone_book.computeIfAbsent("Анатолий", key -> new ArrayList<>()).add("21-22-23");
        phone_book.computeIfAbsent("Олег", key -> new ArrayList<>()).add("31-32-33");
        phone_book.computeIfAbsent("Татьяна", key -> new ArrayList<>()).add("11-22-33");
        phone_book.computeIfAbsent("Анастасия", key -> new ArrayList<>()).add("11-22-33");
        phone_book.computeIfAbsent("Айгуль", key -> new ArrayList<>()).add("32-23-23");
        phone_book.computeIfAbsent("Добрыня", key -> new ArrayList<>()).add("77-33-22");
        phone_book.computeIfAbsent("Анастасия", key -> new ArrayList<>()).add("22-11-22");
        phone_book.computeIfAbsent("Олег", key -> new ArrayList<>()).add("44-33-22");
        phone_book.computeIfAbsent("Евгений", key -> new ArrayList<>()).add("22-33-22");
        phone_book.computeIfAbsent("Евгений", key -> new ArrayList<>()).add("11-66-7");

        ArrayList<String> list_for_sort = new ArrayList<>();
        for (String el: phone_book.keySet()) {
            list_for_sort.add(el);
        }

        Collections.sort(list_for_sort, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
               return phone_book.get(o2).size() - phone_book.get(o1).size();
            }
        });
        System.out.println(list_for_sort);
        System.out.println(phone_book.entrySet().toString());


    }
}

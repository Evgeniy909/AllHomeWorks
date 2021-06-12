package Lesson10;

import java.util.HashMap;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) {

        String[] words = new String[]
                {"Слово", "Мир", "Дом", "Кот", "Дерево",
                        "Слон", "Телефон", "Птица", "Собака",
                        "Асфальт", "Слово", "Крокодил", "Алфавит"
                        , "Радуга", "Трава", "Кисть", "Мяч","Дом",
                        "Телефон", "Клумба", "Остров", "Слон"};

        HashSet<String> wordsHashSet = new HashSet<>();
        HashMap<String, Integer> wordsHashMap = new HashMap<>();

        int i = 0;

        for (String word:words) {
            if (wordsHashSet.contains(word)) {
                wordsHashMap.put(word,wordsHashMap.get(word) + 1);
            } else {
                wordsHashSet.add(word);
                wordsHashMap.put(word,1);
            }
        }

        for (String unWord:wordsHashSet) {
            System.out.println(unWord + " " + wordsHashMap.get(unWord));
        }

        PhoneDirectory phoneDirectory = new PhoneDirectory();
        //Тут конечно должен быть массив, но думаю от этого суть не изменится
        phoneDirectory.addRecord("Иван","12345");
        phoneDirectory.addRecord("Иван","12345");
        phoneDirectory.addRecord("Иван","1234522");
        phoneDirectory.addRecord("Костя","54321443");
        phoneDirectory.addRecord("Михаил","5432133");
        phoneDirectory.addRecord("Михаил","12345");

        for (String number:phoneDirectory.getNumbers("Иван")) {
            System.out.println("Иван " + number);
        }

        for (String number:phoneDirectory.getNumbers("Костя")) {
            System.out.println("Костя " + number);
        }

        for (String number:phoneDirectory.getNumbers("Михаил")) {
            System.out.println("Михаил " + number);
        }
    }
}

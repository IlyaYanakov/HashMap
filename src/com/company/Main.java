package com.company;

import java.util.HashMap;
import java.util.Scanner;
import java.lang.*;

/**
 * Класс мейн, содержит в себе начальное меню
 */
public class Main {
    static Animal animal;
    static AnimalRepository repository = new AnimalRepository();

    public static void main(String[] args) {

        menu();
        boolean a = true;
        Boolean a1 = a;
    }

    /**
     * Метод menu, начальное меню
     */
    private static void menu() {
        try {
            Scanner input = new Scanner(System.in);
            System.out.println("Выберите действие");
            System.out.println("""
                    1 - Добавить животное в список
                    2 - Удалить животное из списка
                    3 - Показать элемент списка
                    4 - Узнать длинну списка
                    5 - Проверить лист пустой или нет
                    6 - Проверить содержит ключ
                    7 - Проверить содержит значение
                    8 - Очистить весь лист
                    9 - Перенести из одного списка в другой 
                    """);
            int choice = input.nextInt();
            if (choice == 1) {
                System.out.println("Вы выбрали добавить");
                addToHashMap();
            } else if (choice == 2) {
                System.out.println("Вы выбрали удалить");
                deleteHashMap();
            } else if (choice == 3) {
                System.out.println("Вы выбрали показать все элементы");
                getAnimal();
            } else if (choice == 4) {
                System.out.println("Вы выбрали показать длинну листа");
                getSize();
            } else if (choice == 5) {
                System.out.println("Вы выбрали проверить пустой лист или нет");
                isEntry();
            } else if (choice == 6) {
                System.out.println("Вы выбрали содержит ключ илди нет");
                containsKey();
            } else if (choice == 7) {
                System.out.println("Вы выбрали содержит значение или нет");
                containsValue();
            } else if (choice == 8) {
                System.out.println("Вы выбрали очистить весь лист");
                clearHashMap();
            } else if (choice == 9) {
                System.out.println("Вы выбрали перенести из одного листа в другой ");
                putAll();
            }

        } finally {
            menu();
        }
    }

    /**
     * Метод добавить в хешМеп, вызывает метод добавления из хранилища животных
     */
    private static void addToHashMap() {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите уникальный ключ");
        String key = input.nextLine();
        System.out.println("Введите имя животного");
        String name = input.next();
        System.out.println("Введите Возраст животного");
        int age = input.nextInt();
        System.out.println("Введите вес");
        double weight = input.nextDouble();
        animal = new Animal(name, age, weight);
        var hash = repository.hash(key);
        var verification = repository.put(key, animal);
        if (verification != null) {
            System.out.println("Животное успешно добавлено");
        }

    }

    /**
     * Метод удалить из ХешМап, вызывает метод удаления из хранилища животных
     */
    private static void deleteHashMap() {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите ключ животного которго хотите удалить");
        int key = input.nextInt();
        var remove = repository.remove(key);

    }

    /**
     * Метод getAnimal, вызывает метод показа животного из хранилища животных
     */
    private static void getAnimal() {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите уникальный номер животного");
        int key = input.nextInt();
        System.out.println(repository.get(key));
    }

    /**
     * Метод getSize, вызывает метод показа длины листа
     */
    private static void getSize() {
        System.out.println(repository.size());
    }

    /**
     * Метод isEntry, вызывает метод проверки есть ли значение в листе из хранилища животных
     */
    private static void isEntry() {
        var isEntry = repository.isEmpty();
        if (isEntry) {
            System.out.println("Лист содержит какие то значения");
        } else {
            System.out.println("Лист пустой");
        }
    }

    /**
     * Метод containsKey, вызывает метод проверки есть ли значение ключа в паре ключ-значение
     */
    private static void containsKey() {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите уникальный ключ");
        int key = input.nextInt();
        var containsKey = repository.containsKey(key);
        if (containsKey) {
            System.out.println("Содержит");
        } else {
            System.out.println("Не содержит ключ");
        }
    }

    /**
     * Метод containsValue, вызывает метод проверки есть ли значение в паре ключ-значение
     */
    private static void containsValue() {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите имя животного");
        String name = input.nextLine();
        System.out.println("Введите возраст животного");
        int age = input.nextInt();
        System.out.println("Введите вес животного");
        double weight = input.nextDouble();
        animal = new Animal(name, age, weight);
        var containsKey = repository.containsValue(animal);
        if (containsKey) {
            System.out.println("Содержит");
        } else {
            System.out.println("Не содержит значение");
        }

    }

    /**
     * Метод clearHashMap, вызывает метод очистки листа из репозитория животных
     */
    private static void clearHashMap() {
        repository.clear();
    }

    private static void putAll() {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите длинну листа ");
        int length = input.nextInt();
        System.out.println("Введите имя листа");

        Node[] newNode = new Node[length];

    }
}


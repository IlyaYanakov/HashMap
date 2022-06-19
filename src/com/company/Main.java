package com.company;

import java.util.HashMap;
import java.util.Scanner;
import java.lang.*;

/**
 * ����� ����, �������� � ���� ��������� ����
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
     * ����� menu, ��������� ����
     */
    private static void menu() {
        try {
            Scanner input = new Scanner(System.in);
            System.out.println("�������� ��������");
            System.out.println("""
                    1 - �������� �������� � ������
                    2 - ������� �������� �� ������
                    3 - �������� ������� ������
                    4 - ������ ������ ������
                    5 - ��������� ���� ������ ��� ���
                    6 - ��������� �������� ����
                    7 - ��������� �������� ��������
                    8 - �������� ���� ����
                    9 - ��������� �� ������ ������ � ������ 
                    """);
            int choice = input.nextInt();
            if (choice == 1) {
                System.out.println("�� ������� ��������");
                addToHashMap();
            } else if (choice == 2) {
                System.out.println("�� ������� �������");
                deleteHashMap();
            } else if (choice == 3) {
                System.out.println("�� ������� �������� ��� ��������");
                getAnimal();
            } else if (choice == 4) {
                System.out.println("�� ������� �������� ������ �����");
                getSize();
            } else if (choice == 5) {
                System.out.println("�� ������� ��������� ������ ���� ��� ���");
                isEntry();
            } else if (choice == 6) {
                System.out.println("�� ������� �������� ���� ���� ���");
                containsKey();
            } else if (choice == 7) {
                System.out.println("�� ������� �������� �������� ��� ���");
                containsValue();
            } else if (choice == 8) {
                System.out.println("�� ������� �������� ���� ����");
                clearHashMap();
            } else if (choice == 9) {
                System.out.println("�� ������� ��������� �� ������ ����� � ������ ");
                putAll();
            }

        } finally {
            menu();
        }
    }

    /**
     * ����� �������� � ������, �������� ����� ���������� �� ��������� ��������
     */
    private static void addToHashMap() {
        Scanner input = new Scanner(System.in);
        System.out.println("������� ���������� ����");
        String key = input.nextLine();
        System.out.println("������� ��� ���������");
        String name = input.next();
        System.out.println("������� ������� ���������");
        int age = input.nextInt();
        System.out.println("������� ���");
        double weight = input.nextDouble();
        animal = new Animal(name, age, weight);
        var hash = repository.hash(key);
        var verification = repository.put(key, animal);
        if (verification != null) {
            System.out.println("�������� ������� ���������");
        }

    }

    /**
     * ����� ������� �� ������, �������� ����� �������� �� ��������� ��������
     */
    private static void deleteHashMap() {
        Scanner input = new Scanner(System.in);
        System.out.println("������� ���� ��������� ������� ������ �������");
        int key = input.nextInt();
        var remove = repository.remove(key);

    }

    /**
     * ����� getAnimal, �������� ����� ������ ��������� �� ��������� ��������
     */
    private static void getAnimal() {
        Scanner input = new Scanner(System.in);
        System.out.println("������� ���������� ����� ���������");
        int key = input.nextInt();
        System.out.println(repository.get(key));
    }

    /**
     * ����� getSize, �������� ����� ������ ����� �����
     */
    private static void getSize() {
        System.out.println(repository.size());
    }

    /**
     * ����� isEntry, �������� ����� �������� ���� �� �������� � ����� �� ��������� ��������
     */
    private static void isEntry() {
        var isEntry = repository.isEmpty();
        if (isEntry) {
            System.out.println("���� �������� ����� �� ��������");
        } else {
            System.out.println("���� ������");
        }
    }

    /**
     * ����� containsKey, �������� ����� �������� ���� �� �������� ����� � ���� ����-��������
     */
    private static void containsKey() {
        Scanner input = new Scanner(System.in);
        System.out.println("������� ���������� ����");
        int key = input.nextInt();
        var containsKey = repository.containsKey(key);
        if (containsKey) {
            System.out.println("��������");
        } else {
            System.out.println("�� �������� ����");
        }
    }

    /**
     * ����� containsValue, �������� ����� �������� ���� �� �������� � ���� ����-��������
     */
    private static void containsValue() {
        Scanner input = new Scanner(System.in);
        System.out.println("������� ��� ���������");
        String name = input.nextLine();
        System.out.println("������� ������� ���������");
        int age = input.nextInt();
        System.out.println("������� ��� ���������");
        double weight = input.nextDouble();
        animal = new Animal(name, age, weight);
        var containsKey = repository.containsValue(animal);
        if (containsKey) {
            System.out.println("��������");
        } else {
            System.out.println("�� �������� ��������");
        }

    }

    /**
     * ����� clearHashMap, �������� ����� ������� ����� �� ����������� ��������
     */
    private static void clearHashMap() {
        repository.clear();
    }

    private static void putAll() {
        Scanner input = new Scanner(System.in);
        System.out.println("������� ������ ����� ");
        int length = input.nextInt();
        System.out.println("������� ��� �����");

        Node[] newNode = new Node[length];

    }
}


package com.company;

/**
 * Класс node, представляет из себя HashMap,содержит данные для создания ноды
 */
public class Node {
    private final int hash;
    private final String key;
    Animal value;
    public Node next;

    /**
     * Конструкторы в Java представляют собой специальный блок кода, похожий на метод,
     * предназначенный для инициализации полей объекта при его создании. Он вызывается всегда,
     * когда создается новый экземпляр класса
     *
     * @param hash  - хешкод
     * @param key   - ключ
     * @param value - значение
     * @param next  - следующий элемент
     */
    public Node(int hash, String key, Animal value, Node next) {
        this.hash = hash;
        this.key = key;
        this.value = value;
    }

    /**
     * Конструкторы в Java представляют собой специальный блок кода, похожий на метод,
     * предназначенный для инициализации полей объекта при его создании. Он вызывается всегда,
     * когда создается новый экземпляр класса
     *
     * @param hash  - хешкод
     * @param key   - ключ
     * @param value - значение
     */
    public Node(int hash, String key, Animal value) {
        this.hash = hash;
        this.key = key;
        this.value = value;
    }

    /**
     * toString метод в Java используется для предоставления ясной и достаточной информации об объекте ( Object ) в
     * удобном для человека виде.Правильное переопределение метода toString может помочь в ведении журнала работы и
     * в отладке Java программы предоставляя ценную и важную информацию
     *
     * @return
     */
    @Override
    public String toString() {
        return "Node{" +
                "Животное = " + value +
                "}";

    }

    /**
     * Выдает хешкод
     *
     * @return hash - хешкод
     */
    public int getHash() {
        return hash;
    }

    /**
     * Выдает ключ
     *
     * @return key - ключ
     */
    public String getKey() {
        return key;
    }

    /**
     * Выдает значение
     *
     * @return value - значение
     */
    public Animal getValue() {
        return value;
    }

    /**
     * Задает значение
     *
     * @param value - значение
     */
    public void setValue(Animal value) {
        this.value = value;
    }

    /**
     * Содержит ссылку на следующего животного
     *
     * @return next - следующий
     */
    public Node getNext() {
        return next;
    }

    /**
     * Задает следующий элемент
     *
     * @param next - следующий элемент
     */
    public void setNext(Node next) {
        this.next = next;
    }

    /**
     * Выдает животное
     *
     * @return animal - животное
     */
    public Animal getAnimal() {
        return value;
    }

    /**
     * Задает животное
     *
     * @param animal - животное
     */
    public void setAnimal(Animal animal) {
        this.value = animal;
    }

    /**
     * Класс мой ключ, содержит в себе ключ
     */
    class MyKey {
        private String key;

        public MyKey(String key) {
            this.key = key;
        }

        public String getKey() {
            return key;
        }

        @Override
        public boolean equals(Object obj) {
            return this.getKey().equals(((MyKey) obj).getKey());
        }
    }
}

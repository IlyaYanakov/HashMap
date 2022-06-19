package com.company;

/**
 * Класс Animal, содержит основные данные животных
 */
public class Animal {
    private String name;
    private int age;
    private double weight;

    /**
     * Конструкторы в Java представляют собой специальный блок кода, похожий на метод,
     * предназначенный для инициализации полей объекта при его создании. Он вызывается всегда,
     * когда создается новый экземпляр класса
     *
     * @param name   - имя животного
     * @param age    - возраст животного
     * @param weight - вес животного
     */
    public Animal(String name, int age, double weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
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
        return "Животное{" +
                "Имя = '" + name + '\'' +
                ", Возраст = " + age +
                ", Вес = " + weight +
                '}';
    }

    /**
     * Конструкторы в Java представляют собой специальный блок кода, похожий на метод,
     * предназначенный для инициализации полей объекта при его создании. Он вызывается всегда,
     * когда создается новый экземпляр класса
     */
    public Animal() {
    }

    /**
     * Выдает имя животного
     *
     * @return name - имя
     */
    public String getName() {
        return name;
    }

    /**
     * Задает имя животного
     *
     * @param name - Имя
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Выдает возраст животного
     *
     * @return age - возраст
     */
    public int getAge() {
        return age;
    }

    /**
     * Задает возраст животного
     *
     * @param age - возраст
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Выдвет вес животного
     *
     * @return weight - вес
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Задает вес животного
     *
     * @param weight - вес
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object obj) {
        Animal animal = (Animal) obj;

        return this.getAge() == animal.getAge() &&
                this.getWeight() == animal.getWeight() &&
                this.getName().equals(animal.getName());
    }
}

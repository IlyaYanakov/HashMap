package com.company;

/**
 * ����� Animal, �������� �������� ������ ��������
 */
public class Animal {
    private String name;
    private int age;
    private double weight;

    /**
     * ������������ � Java ������������ ����� ����������� ���� ����, ������� �� �����,
     * ��������������� ��� ������������� ����� ������� ��� ��� ��������. �� ���������� ������,
     * ����� ��������� ����� ��������� ������
     *
     * @param name   - ��� ���������
     * @param age    - ������� ���������
     * @param weight - ��� ���������
     */
    public Animal(String name, int age, double weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    /**
     * toString ����� � Java ������������ ��� �������������� ����� � ����������� ���������� �� ������� ( Object ) �
     * ������� ��� �������� ����.���������� ��������������� ������ toString ����� ������ � ������� ������� ������ �
     * � ������� Java ��������� ������������ ������ � ������ ����������
     *
     * @return
     */
    @Override
    public String toString() {
        return "��������{" +
                "��� = '" + name + '\'' +
                ", ������� = " + age +
                ", ��� = " + weight +
                '}';
    }

    /**
     * ������������ � Java ������������ ����� ����������� ���� ����, ������� �� �����,
     * ��������������� ��� ������������� ����� ������� ��� ��� ��������. �� ���������� ������,
     * ����� ��������� ����� ��������� ������
     */
    public Animal() {
    }

    /**
     * ������ ��� ���������
     *
     * @return name - ���
     */
    public String getName() {
        return name;
    }

    /**
     * ������ ��� ���������
     *
     * @param name - ���
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * ������ ������� ���������
     *
     * @return age - �������
     */
    public int getAge() {
        return age;
    }

    /**
     * ������ ������� ���������
     *
     * @param age - �������
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * ������ ��� ���������
     *
     * @return weight - ���
     */
    public double getWeight() {
        return weight;
    }

    /**
     * ������ ��� ���������
     *
     * @param weight - ���
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

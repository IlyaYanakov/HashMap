package com.company;

/**
 * ����� node, ������������ �� ���� HashMap,�������� ������ ��� �������� ����
 */
public class Node {
    private final int hash;
    private final String key;
    Animal value;
    public Node next;

    /**
     * ������������ � Java ������������ ����� ����������� ���� ����, ������� �� �����,
     * ��������������� ��� ������������� ����� ������� ��� ��� ��������. �� ���������� ������,
     * ����� ��������� ����� ��������� ������
     *
     * @param hash  - ������
     * @param key   - ����
     * @param value - ��������
     * @param next  - ��������� �������
     */
    public Node(int hash, String key, Animal value, Node next) {
        this.hash = hash;
        this.key = key;
        this.value = value;
    }

    /**
     * ������������ � Java ������������ ����� ����������� ���� ����, ������� �� �����,
     * ��������������� ��� ������������� ����� ������� ��� ��� ��������. �� ���������� ������,
     * ����� ��������� ����� ��������� ������
     *
     * @param hash  - ������
     * @param key   - ����
     * @param value - ��������
     */
    public Node(int hash, String key, Animal value) {
        this.hash = hash;
        this.key = key;
        this.value = value;
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
        return "Node{" +
                "�������� = " + value +
                "}";

    }

    /**
     * ������ ������
     *
     * @return hash - ������
     */
    public int getHash() {
        return hash;
    }

    /**
     * ������ ����
     *
     * @return key - ����
     */
    public String getKey() {
        return key;
    }

    /**
     * ������ ��������
     *
     * @return value - ��������
     */
    public Animal getValue() {
        return value;
    }

    /**
     * ������ ��������
     *
     * @param value - ��������
     */
    public void setValue(Animal value) {
        this.value = value;
    }

    /**
     * �������� ������ �� ���������� ���������
     *
     * @return next - ���������
     */
    public Node getNext() {
        return next;
    }

    /**
     * ������ ��������� �������
     *
     * @param next - ��������� �������
     */
    public void setNext(Node next) {
        this.next = next;
    }

    /**
     * ������ ��������
     *
     * @return animal - ��������
     */
    public Animal getAnimal() {
        return value;
    }

    /**
     * ������ ��������
     *
     * @param animal - ��������
     */
    public void setAnimal(Animal animal) {
        this.value = animal;
    }

    /**
     * ����� ��� ����, �������� � ���� ����
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

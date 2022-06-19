package com.company;

import javax.swing.*;
import java.util.*;


/**
 * ����� ��������� ��������, �������� � ���� ������������� ������ �� ���������� Map
 */
public class AnimalRepository implements Map<String, Animal> {
    private static int changing = 16;
    private int size = 0;
    private Node[] storage = new Node[changing];

    /**
     * ����� hash, ��������� ������ �����
     *
     * @param key - ����
     * @return hashcode - ������
     */
    static int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    /**
     * ��������� ������ �� ������� ������ ���������� �������
     *
     * @param hash - ������
     * @return index - ������
     */
    private int getIndex(int hash) {
        return (storage.length - 1) & hash;
    }

    /**
     * ����� size, ������� ������ �����
     *
     * @return size - ����� �����
     */
    @Override
    public int size() {
        return storage.length;
    }

    /**
     * ����� isEmpty - ��������� ������ �� ����� ��� ���
     *
     * @return boolean
     */
    @Override
    public boolean isEmpty() {
        for (Node node : storage) {
            if (node != null) {
                return true;
            }
        }
        return false;
    }

    /**
     * ����� containsKey, ��������� �������� �� ���� ����-�������� ����
     *
     * @param key key whose presence in this map is to be tested
     * @return boolean - ���� true ��������, ���� false �� ��������
     */
    @Override
    public boolean containsKey(Object key) {
        return (get(key) != null);
    }

    /**
     * ����� containsValue, ��������� �������� �� ���� ����-�������� ��������
     *
     * @param value value whose presence in this map is to be tested
     * @return boolean - ���� true ��������, ���� false - �� ��������
     */
    @Override
    public boolean containsValue(Object value) {
        Animal animal = (Animal) value;
        if (storage != null && size > 0)
            for (Node item : storage)
                for (Node node = item; node != null; node = node.getNext())
                    if (animal.equals(node.getAnimal()))
                        return true;

        return false;
    }
    //|| (value != null && value.equals(value))

    /**
     * ����� get, ������ �������� �� ����� ����������� � ����������
     *
     * @param key the key whose associated value is to be returned
     * @return animal - ��������� ��������
     */
    @Override
    public Animal get(Object key) {
        int index = getIndex(key.hashCode());
        System.out.println(storage[index].getAnimal());
        return null;
    }

    /**
     * ����� put, ��������� � ����� ����� �������
     *
     * @param key   key with which the specified value is to be associated
     * @param value value to be associated with the specified key
     * @return animal - ��������� ��������
     */
    @Override
    public Animal put(String key, Animal value) {
        Node node;
        int index = getIndex(hash(key));
        var hash = hash(key);
        node = new Node(hash, key, value);
        if (storage[index] == null) {
            storage[index] = node;
            size++;
        } else if (storage[index] != null) {
            if (storage[index].getKey().equals(key)) {
                storage[index] = node;
            }
        } else {
            while (storage[index].getNext() != null) {
                if (storage[index].getNext() == null) {
                    storage[index].setNext(node);
                } else if (storage[index].getNext() != null) {
                    if (storage[index].getNext().getKey().equals(key)) {
                        storage[index].setNext(node);
                    }
                }
            }
        }
        return storage[index].getAnimal();
    }

    /**
     * ����� remove, ������� ������� �� ����� �� �����
     *
     * @param key key whose mapping is to be removed from the map
     * @return null
     */
    @Override
    public Animal remove(Object key) {
        var hash = hash(key);
        int index = getIndex(hash(key));
        Node currentNode = storage[index];
        if (currentNode == null)
            return null;
        if (currentNode.getKey().equals(key)) {
            storage[index] = currentNode.getNext();
            size--;
        } else {
            Node previous = currentNode;
            while (currentNode.getNext() != null) {
                if (currentNode.getKey().equals(key)) {
                    previous.setNext(currentNode.getNext());
                    size--;
                    break;
                }
                previous = currentNode;
                currentNode = currentNode.getNext();
            }
        }
        return null;
    }

    /**
     * ����� putAll, ������� ������������ ��� �������� �����������. ����� �������� ��� ��������,
     * �. �. �������������, � ����� ����� �� ������.
     *
     * @param m mappings to be stored in this map
     */
    @Override
    public void putAll(Map<? extends String, ? extends Animal> m) {

    }

    /**
     * ����� clear, ������� ��� �����
     */
    @Override
    public void clear() {
        Arrays.fill(storage, null);
    }

    @Override
    public Set<String> keySet() {
        return null;
    }

    @Override
    public Collection<Animal> values() {
        return null;
    }

    @Override
    public Set<Entry<String, Animal>> entrySet() {
        return null;
    }

}

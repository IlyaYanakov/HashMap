package com.company;

import javax.swing.*;
import java.util.*;


/**
 * Класс хранилище животных, содержит в себе реализованные методы из интерфейса Map
 */
public class AnimalRepository implements Map<String, Animal> {
    private static int changing = 16;
    private int size = 0;
    private Node[] storage = new Node[changing];

    /**
     * Метод hash, вычисляет хешкод ключа
     *
     * @param key - ключ
     * @return hashcode - хешкод
     */
    static int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    /**
     * Вычисляет индекс на который должен становится элемент
     *
     * @param hash - хешкод
     * @return index - индекс
     */
    private int getIndex(int hash) {
        return (storage.length - 1) & hash;
    }

    /**
     * Метол size, находит длинну листа
     *
     * @return size - длина листа
     */
    @Override
    public int size() {
        return storage.length;
    }

    /**
     * Метод isEmpty - проверяет пустая ли карта или нет
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
     * Метод containsKey, проверяет содержит ли пара ключ-значение ключ
     *
     * @param key key whose presence in this map is to be tested
     * @return boolean - если true содержит, если false не содержит
     */
    @Override
    public boolean containsKey(Object key) {
        return (get(key) != null);
    }

    /**
     * Метод containsValue, проверяет содержит ли пара ключ-значение значение
     *
     * @param value value whose presence in this map is to be tested
     * @return boolean - если true содержит, если false - не содержит
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
     * Метод get, выдает значение по ключу переданному в параметрах
     *
     * @param key the key whose associated value is to be returned
     * @return animal - найденное животное
     */
    @Override
    public Animal get(Object key) {
        int index = getIndex(key.hashCode());
        System.out.println(storage[index].getAnimal());
        return null;
    }

    /**
     * Метод put, добавляет в карту новый элемент
     *
     * @param key   key with which the specified value is to be associated
     * @param value value to be associated with the specified key
     * @return animal - созданное животное
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
     * Метод remove, удаляет элемент по ключу из карты
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
     * метод putAll, который используется для операции копирования. Метод копирует все элементы,
     * т. е. сопоставления, с одной карты на другую.
     *
     * @param m mappings to be stored in this map
     */
    @Override
    public void putAll(Map<? extends String, ? extends Animal> m) {

    }

    /**
     * Метод clear, очищает всю карту
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

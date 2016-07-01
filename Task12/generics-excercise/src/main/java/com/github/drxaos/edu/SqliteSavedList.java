package com.github.drxaos.edu;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

class SqliteSavedList<E extends Serializable> extends AbstractList<E> {

    public class Sqlite implements SavedList {
        public void createTable() {
        }

        public void deleteFromTable() {
        }

        public void saveToTable() {
        }

        public void updateTable(){
        }

        @Override
        public String getResult() {
            return null;
        }

        public void loadFromTable() {
        }
    }

    SavedList obj;

    SqliteSavedList(SavedList intObj) {
        obj = intObj;
        obj.createTable();
    }

    String getResult() {
        return obj.getResult();
    }

    private List<E> savedList = new ArrayList<E>();



    public E get(int index) {
        return savedList.get(index);
    }

    public E set(int index, E element) {
        if (index <= savedList.size() - 1) {
            savedList.set(index, element);
            obj.updateTable();
            return element;
        }
        return null;
    }

    public int size() {
        return savedList.size();
    }

    public void add(int index, E element) {
        savedList.add(index, element);
        obj.saveToTable();
    }

    public boolean add(E elem) {
        savedList.add(elem);
        obj.saveToTable();
        return true;
    }

    public E remove(int index) {
        if (index <= savedList.size() - 1) {
            E elem = savedList.get(index);
            savedList.remove(index);
            obj.deleteFromTable();
            return elem;
        }
        return null;
    }

}

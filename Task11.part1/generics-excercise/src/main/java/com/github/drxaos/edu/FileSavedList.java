package com.github.drxaos.edu;

import java.io.*;
import java.util.AbstractList;
import java.util.ArrayList;

public class FileSavedList<String> extends AbstractList<String> implements Reloadable {

    private ArrayList<String> savedList = new ArrayList<String>();
    private File _file;

    public FileSavedList(File file) {

        if (file.exists()) {
            _file = file;
            reload();
        } else {
            _file = new File(file.toString());

        }
    }

    public void reload() throws FileOperationException {
        if (!_file.exists()) savedList.clear();

        try {
            FileInputStream fis = new FileInputStream(_file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            savedList = (ArrayList<String>) ois.readObject();
            ois.close();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public String get(int index) {
        return savedList.get(index);
    }

    @Override
    public String set(int index, String element) {
        savedList.set(index, element);
        save();
        return element;
    }

    @Override
    public int size() {
        return savedList.size();
    }

    @Override
    public void add(int index, String element) {
        savedList.add(index, element);
        save();
    }

    @Override
    public String remove(int index) {
        String elem = savedList.get(index);
        savedList.remove(index);
        save();
        return elem;
    }

    private void save() {
        try {
            FileOutputStream fos = new FileOutputStream(_file);
            ObjectOutputStream out = new ObjectOutputStream(fos);
            out.writeObject(savedList);
            fos.close();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

}

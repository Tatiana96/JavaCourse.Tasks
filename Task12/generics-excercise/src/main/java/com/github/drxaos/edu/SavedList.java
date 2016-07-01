package com.github.drxaos.edu;

interface SavedList {
    void loadFromTable();

    void createTable();

    void deleteFromTable();

    void saveToTable();

    void updateTable();

    String getResult();

}

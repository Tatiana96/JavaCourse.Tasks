package com.github.drxaos.edu;

public class SqliteAlternate implements SavedList {

    private String result = "";

    SqliteAlternate() {
    }

    public void createTable() {
        result += "createTable ";
    }

    public void deleteFromTable() {
        result += "deleteFromTable ";
    }

    public void saveToTable() {
        result += "saveToTable ";
    }

    public void updateTable(){
        result += "updateTable ";
    }

    public void loadFromTable() {
        result += "loadFromTable ";
    }

    public String getResult(){
        return result;
    }

}

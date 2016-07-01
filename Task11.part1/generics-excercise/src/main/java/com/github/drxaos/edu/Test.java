package com.github.drxaos.edu;


import java.io.Serializable;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class Test<E extends Serializable> extends SqliteSavedList<E> implements SavedList  {
    private List<E> savedList = new ArrayList<E>();
    public String test = "";

    protected void deleteFromTable(int id) throws SQLException {
        test += "delete\n";
        System.out.println("delete");
    }

    protected void saveToTable() throws SQLException {
        test += "insert\n";
        System.out.println("insert");
    }

    protected void updateTable(int id, E elem) throws SQLException {
        test += "update\n";
        System.out.println("update");
    }

}

package com.github.drxaos.edu;

import java.io.Serializable;
import java.sql.*;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;


class SqliteSavedList<E extends Serializable> extends AbstractList<E> implements SavedList {

    private String tableName;
    private Connection conn = null;
    private Statement stmt;
    private List<E> savedList = new ArrayList<E>();

    SqliteSavedList(){

    }
    SqliteSavedList(String filename) throws ClassNotFoundException, SQLException {
        this.tableName = filename;
        createTable();
    }

    private void createTable() {
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:test.db");
            stmt = conn.createStatement();
            int count = 0;

            ResultSet res = stmt.executeQuery("SELECT count(*) FROM sqlite_master WHERE type ='table' and name='" + tableName + "';");

            while (res.next()) {
                count = res.getInt(1);
            }

            if (count == 0) {

                String sql = "CREATE TABLE " + this.tableName +
                        "(ID INT NOT NULL," +
                        " DATA BLOB NOT NULL );";

                stmt.executeUpdate(sql);

                stmt.close();
                conn.close();
            } else {
                loadFromTable();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected void deleteFromTable(int id) throws SQLException {
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:test.db");

            PreparedStatement ps1 = conn.prepareStatement("DELETE FROM " + tableName + " WHERE ID = ?");
            ps1.setInt(1, id);
            ps1.executeUpdate();

            int oldId = id;
            for (int i = oldId; i < savedList.size(); i++) {
                id++;
                int oldDataId = id;
                oldDataId--;

                PreparedStatement ps2 = conn.prepareStatement("UPDATE " + tableName + " set ID = ? where ID = ?");
                ps2.setInt(1, oldDataId);
                ps2.setInt(2, id);
                ps2.executeUpdate();

            }
            conn.close();

            saveToTable();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void saveToTable() throws SQLException {
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:test.db");
            stmt = conn.createStatement();
            String sql;

            ResultSet res = stmt.executeQuery("SELECT COUNT(*) AS rowcount FROM " + tableName);
            res.next();
            int count = res.getInt("rowcount");
            res.close();

            for (int i = count; i < savedList.size(); i++) {
                PreparedStatement ps1 = conn.prepareStatement("INSERT INTO " + tableName + " VALUES (?,?)");
                ps1.setInt(1, i);
                ps1.setObject(2, savedList.get(i));
                ps1.executeUpdate();
            }
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void updateTable(int id, E elem) throws SQLException {

        try {
            conn = DriverManager.getConnection("jdbc:sqlite:test.db");

            PreparedStatement ps1 = conn.prepareStatement("UPDATE " + tableName + " set DATA = ? where ID = ?");
            ps1.setObject(1, elem);
            ps1.setInt(2, id);
            ps1.executeUpdate();

            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void loadFromTable() {
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:test.db");
            stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM " + tableName + ";");

            while (rs.next()) {
                Object obj = rs.getObject(2);

                E data = (E) obj;

                savedList.add((E)data);
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public E get(int index) {
        return savedList.get(index);
    }

    public E set(int index, E element) {
        if (index <= savedList.size() - 1) {
            savedList.set(index, element);
            try {
                updateTable(index, element);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return element;
        }
        return null;
    }

    @Override
    public int size() {
        return savedList.size();
    }

    @Override
    public void add(int index, E element) {
        savedList.add(index, element);
        try {
            saveToTable();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean add(E elem) {
        savedList.add(elem);
        try {
            saveToTable();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public E remove(int index) {
        if (index <= savedList.size() - 1) {
            E elem = savedList.get(index);
            savedList.remove(index);
            try {
                deleteFromTable(index);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return elem;
        }
        return null;
    }

    List<E> getSavedList() {
        return savedList;
    }

}

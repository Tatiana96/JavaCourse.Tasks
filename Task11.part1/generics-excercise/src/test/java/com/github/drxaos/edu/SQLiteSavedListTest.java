package com.github.drxaos.edu;

import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class SQLiteSavedListTest {
    @Test
    public void test1() throws SQLException, ClassNotFoundException {
        //SqliteSavedList<String> obj = new SqliteSavedList<String>("test1");
        Test<String> obj = new Test<String>();

//        obj.remove(0);
        obj.add("test1.0");
        obj.add("test1.1");

        obj.remove(0);

        obj.add("test1.2");

        String str = "insert\ninsert\ndelete\ninsert\n";
        Assert.assertTrue(str.equals(obj.test));
    }

    @Test
    public void test2() throws SQLException, ClassNotFoundException {
        SqliteSavedList<String> obj = new SqliteSavedList<String>("test2");

        obj.add("test2.0");
        obj.add("test2.1");

        obj.set(0, "test2.2");
        obj.set(1, "test2.3");

        List<String> list = obj.getSavedList();

        Assert.assertTrue(list.get(1).equals("test2.3"));

    }

    @Test
    public void test3() throws SQLException, ClassNotFoundException {
        SqliteSavedList<Integer> obj = new SqliteSavedList<Integer>("test3");

        obj.add(31);
        obj.add(58);

        for(Integer obg1: obj)
        System.out.println(obg1);

        Assert.assertTrue(obj.get(1) == 58); }

    @Test
    public void test4() throws SQLException, ClassNotFoundException {
        SqliteSavedList<Integer> obj = new SqliteSavedList<Integer>("test4");
        obj.add(31);
        obj.add(58);
        int size = obj.size();
        obj.remove(1);

        for(Integer obg1: obj)
            System.out.println(obg1);

        Assert.assertTrue(obj.size()==size-1); }

    @Test
    public void test5() throws SQLException, ClassNotFoundException {
        SqliteSavedList<Integer> obj = new SqliteSavedList<Integer>("test5");

        obj.add(0,44);
        obj.set(0,58);

        for(Integer obg1: obj)
            System.out.println(obg1);

        Assert.assertTrue(obj.get(0)==58); }
}

package com.github.drxaos.edu;

import org.junit.Assert;
import org.junit.Test;

public class SQLiteSavedListTest {

    @Test
    public void test2() {

        SavedList obj = new SqliteAlternate();
        // create list
        SqliteSavedList<String> list = new SqliteSavedList<String>(obj);
        list.add("One");
        list.add("Two");
        list.add("Three");

        list.remove("Two");

        list.set(0, "Four");
        list.remove(2);

        String result = "createTable saveToTable saveToTable saveToTable deleteFromTable updateTable ";

        Assert.assertEquals(list.getResult(), result);

    }

}



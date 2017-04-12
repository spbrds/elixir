package com.zeptsoft.myshopping.core.listmanager;

import com.zeptsoft.myshopping.core.listplayer.IListNavigator;
import com.zeptsoft.myshopping.core.listplayer.SimpleListNavigator;
import com.zeptsoft.myshopping.datatypes.Item;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ManagerTests {

    IListManager listManager;

    @Before
    public void prepareTestManager(){
        listManager = new ListManager("mocked id");

        Item it = new Item ();
        it.setName("Test 1");
        it.setCategory("Test");
        listManager.addItem(it);

        it = new Item ();
        it.setName("Test 2");
        it.setCategory("Test");
        listManager.addItem(it);

        it = new Item ();
        it.setName("Test 3");
        it.setCategory("Test");
        listManager.addItem(it);

    }

    @Test
    public void testGetItem(){
        assertEquals("Item not found", "Test 2", listManager.getItem("Test 2"));
    }

    @Test
    public void testAddOperation(){
        Item it = new Item();
        it.setName("Test 4");
        it.setCategory("Test");

        listManager.addItem(it);

        assertEquals("Element no added to mlist",4,listManager.getList().size());
        assertEquals("Element Test 4 not found", "Test 4", listManager.getItem("Test 4").getName());

    }

    @Test
    public void testDeleteOperation(){
        listManager.deleteItem("Test 2");
        assertEquals("Wrong list size, after delete", 2, listManager.getList().size());
        assertNull("Element Test 2 found after deletion", listManager.getItem("Test 2"));
    }

    @Test
    public void checkSeveralItems(){

    }

    @Test
    public void deleteSeveralItems(){

    }

    @Test
    public void checkItem(){
        listManager.checkItem("Test 3");
        assertTrue("Item was not properly checked", listManager.getItem("Test 3").isChecked());
    }

}
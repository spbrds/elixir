package com.zeptsoft.myshopping.core.listmanager;

import com.zeptsoft.myshopping.core.adapters.SelectableItem;
import com.zeptsoft.myshopping.core.listplayer.IListNavigator;
import com.zeptsoft.myshopping.core.listplayer.SimpleListNavigator;
import com.zeptsoft.myshopping.datatypes.Item;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ManagerTests {

    private static final String FIRST_DELETED_ITEM = "Test 1";
    private static final String THIRD_DELETED_ITEM = "Test 2";

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

        it = new Item ();
        it.setName("Test 4");
        it.setCategory("Test");
        listManager.addItem(it);

        it = new Item ();
        it.setName("Test 5");
        it.setCategory("Test");
        listManager.addItem(it);

    }

    @Test
    public void testGetItem(){
        assertEquals("Item not found", "Test 2", listManager.getItem("Test 2").getName());
    }

    @Test
    public void testAddOperation(){
        Item it = new Item();
        it.setName("Test 14");
        it.setCategory("Test");

        listManager.addItem(it);

        assertEquals("Element no added to mlist",6,listManager.getList().size());
        assertEquals("Element Test 14 not found", "Test 14", listManager.getItem("Test 14").getName());

    }

    @Test
    public void testDeleteOperation(){
        listManager.deleteItem("Test 2");
        assertEquals("Wrong list size, after delete", 4, listManager.getList().size());
        assertNull("Element Test 2 found after deletion", listManager.getItem("Test 2"));
    }

    @Test
    public void checkSeveralItems(){
        int checkedItems = 0;
        List<SelectableItem> selectableItems = listManager.getList();

        selectableItems.get(0).setSelected(true);
        selectableItems.get(1).setSelected(true);
        selectableItems.get(4).setSelected(true);

        listManager.checkSelectedItems();

        for(SelectableItem si : listManager.getList()){
            if(si.getItem().isChecked()){
                checkedItems++;
            }
        }

        assertEquals("Number of checked items didn't match", 3, checkedItems);


    }

    @Test
    public void deleteSeveralItems(){
        List<SelectableItem> selectableItems = listManager.getList();
        boolean foundItem = false;

        selectableItems.get(0).setSelected(true);
        selectableItems.get(1).setSelected(true);

        listManager.deleteSelectedItems();

        for(SelectableItem si : selectableItems){
            if(FIRST_DELETED_ITEM.equals(si.getItem().getName()) || THIRD_DELETED_ITEM.equals(si.getItem().getName())){
                foundItem=true;
                break;
            }
        }

        assertFalse("One of the two deleted items was found",foundItem);
        assertEquals("List size not expected",3,listManager.getList().size());
    }

    @Test
    public void checkItem(){
        listManager.checkItem("Test 3");
        assertTrue("Item was not properly checked", listManager.getItem("Test 3").isChecked());
    }

}
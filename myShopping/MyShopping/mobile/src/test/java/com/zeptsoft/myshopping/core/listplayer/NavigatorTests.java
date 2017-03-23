package com.zeptsoft.myshopping.core.listplayer;

import com.zeptsoft.myshopping.core.listmanager.MockListManager;
import com.zeptsoft.myshopping.core.listplayer.IListNavigator;
import com.zeptsoft.myshopping.core.listplayer.SimpleListNavigator;
import com.zeptsoft.myshopping.datatypes.Item;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class NavigatorTests {

    IListNavigator navigator = null;

    @Before
    public void prepareTest(){
        navigator = buildTestNavigator();
    }

    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void testNavigationSimpleNext(){
        Item item = navigator.next();
        assertEquals("Wrong Item fetched","Fiambre",item.getName());

    }

    @Test
    public void testNavigationSimplePrevious(){
        navigator.next();
        navigator.next();
        navigator.next();
        Item item = navigator.previous();

        assertEquals("Wrong Item fetched","Pão",item.getName());
    }

    @Test
    public void testNavigationFullAroundPrevious(){
        Item item = navigator.previous();
        assertEquals("Wrong Item fetched","Peixe",item.getName());
    }

    @Test
    public void testNavigatorFullAroundNext(){
        Item item = null;
        for(int i = 0; i < 6; i++){
            item = navigator.next();
        }

        assertEquals("Wrong Item fetched","Queijo",item.getName());
    }

    @Test
    public void testNavigatorFirstItem(){
        Item item = navigator.getFirst();
        assertEquals("Wrong first item","Queijo",item.getName());
    }

    @Test
    public void testCheckItemRemoval(){
        Item item = null;
        //getting the first and checking
        String firstItemName = navigator.getFirst().getName();
        navigator.check();

        //getting the second item
        String secondItemName = navigator.next().getName();

        //looping until getting the second item again
        do{
            item = navigator.next();
            assertNotEquals("Item should have been checked",firstItemName,item.getName());
        }while (secondItemName.equals(item.getName()));

    }

    @Test
    public void testFullCheckedList(){
        for(int i = 0; i < 6; i++){
            navigator.check();
            navigator.next();
        }

        assertNull("Null object expected, after empty list", navigator.next());
    }

    private IListNavigator buildTestNavigator(){
        MockListManager manager = new MockListManager();
        SimpleListNavigator navigator = new SimpleListNavigator();
        navigator.startNavigation(manager, "mocked");

        return navigator;
    }




}
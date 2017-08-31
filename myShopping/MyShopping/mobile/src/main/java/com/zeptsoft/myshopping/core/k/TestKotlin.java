package com.zeptsoft.myshopping.core.k;


import java.util.ArrayList;
import java.util.Date;

/**
 * Created by SSBook on 20/06/17.
 */

public class TestKotlin {

    //UserK userK = new UserK();

    public static void  main(String[] args){
        UserK userK = new UserK("Id", "Simão Silva","simao.silva@mail.com", new Date(), new ArrayList<String>(), new ArrayList<String>());


        System.out.println("User:" + userK);
        System.out.println("User:" + userK.getEmail());
    }
}

package com.stage1.part3.hw3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Q3main {

    public static void main(String[] args) {

        //set up
        HashMap hm = new HashMap();
        Object put;
        put = hm.put(1, "123");
        put = hm.put(2, "456");
        put = hm.put(3, "789");
        put = hm.put(4, "123");
        put = hm.put(5, "456");

        //do calculation
        HashMap output = new HashMap();
        Set<Integer> s1 = hm.keySet();

        for(int ts:s1){
            put = output.put(hm.get(ts),1);
            if(put != null){
                output.replace(hm.get(ts), (int)put+1);
            }
        }

        Set<String> s2 = output.keySet();

        for(String tt:s2){
            System.out.println(tt + " appears " + output.get(tt) + ((int)output.get(tt) == 1 ? " time." : " times."));
        }


    }
}

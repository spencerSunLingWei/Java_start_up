package com.stage1.part3.task5;

import java.util.*;

public class CollectionsTest {

    public static void main(String[] args) {

        List<Integer> lt1 = Arrays.asList(10, 20, 30, 40, 50);
        System.out.println("min: " + Collections.max(lt1));
        System.out.println("max:" + Collections.min(lt1));

        System.out.println("----------------------------------");

        Collections.reverse(lt1);
        System.out.println("lt1 = " + lt1);

        Collections.swap(lt1, 0, 1);
        System.out.println("lt1 = " + lt1);

        Collections.sort(lt1);
        System.out.println("lt1 = " + lt1);

        Collections.shuffle(lt1);
        System.out.println("lt1 = " + lt1);

        System.out.println("----------------------------------");

        //capacity not length
        //List<Integer> lt2 = new ArrayList<>(lt1.size()+1);

        List<Integer> lt2 = Arrays.asList(new Integer[lt1.size()]);
        Collections.copy(lt2, lt1);
        System.out.println("lt2 = " + lt2);
    }
}

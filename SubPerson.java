package com.stage1.part3.task5;

/*
public class SubPerson extends Person{ //不保留泛型，并没有指定类型，T默认为Object，擦除

    public static void main(String[] args) {
        SubPerson sp1 = new SubPerson(); //不支持SubPerson<>
        sp1.setGender("女");
        System.out.println(sp1);
        sp1.setGender(2);
        System.out.println(sp1);
    }
}
*/

/*
public class SubPerson extends Person<String>{ //不保留泛型，但指定类型，T为String类型

    public static void main(String[] args) {
        SubPerson sp1 = new SubPerson(); //不支持SubPerson<>
        sp1.setGender("女");
        System.out.println(sp1);

    }
}
*/

/*
public class SubPerson<T> extends Person<T>{ //支持泛型，也叫做T
    public static void main(String[] args) {
        SubPerson<String> sp1 = new SubPerson<>();
        sp1.setGender("女");
        System.out.println(sp1);

    }
}
*/


public class SubPerson<T, T1> extends Person<T>{ //支持泛型，增加了另一个泛型T1

    public static void main(String[] args) {
        SubPerson<String, Boolean> sp1 = new SubPerson<>();
        sp1.setGender("女");
        System.out.println(sp1);

    }
}
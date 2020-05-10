package com.stage1.part2.task5;

public class AnonyousInterfaceTest {

    //接口类型的饮用指向实现类型的对象，形成了多态
    public static void test(AnonyousInterface ai){
        ai.show();
    }

    public static void main(String[] args) {
        AnonyousInterfaceTest.test(new AnonyousInterfaceImpl());

        //匿名内部类
        AnonyousInterface at = new AnonyousInterface() {
            @Override
            public void show() {
                System.out.println("anonymous inner class");
            }
        };

        AnonyousInterfaceTest.test(at);

        //lamda notation
        AnonyousInterface at_new = () -> System.out.println("lamda");
        AnonyousInterfaceTest.test(at_new);


    }
}

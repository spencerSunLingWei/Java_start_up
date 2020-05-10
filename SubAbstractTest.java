package com.stage1.part2.task4;

public class SubAbstractTest extends AbstractTest {

    @Override
    public void show() {
        System.out.println("override");
    }

    public static void main(String[] args) {
        SubAbstractTest sb = new SubAbstractTest();
        sb.show();

        AbstractTest sa = new SubAbstractTest();
        sa.show();
    }
}

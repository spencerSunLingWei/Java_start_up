package com.stage1.part5.task1;

public class SourceAbleTest {

    public static void main(String[] args) {

        SourceAble sourceAble = new Source();
        sourceAble.method();

        SourceAble sourceAble1 = new Decorator(sourceAble);
        sourceAble1.method();

        SourceAble sourceAble2 = new Proxy();
        sourceAble2.method();
    }
}

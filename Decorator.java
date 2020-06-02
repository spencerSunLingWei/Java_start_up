package com.stage1.part5.task1;

public class Decorator implements SourceAble{
    private SourceAble source;

    public Decorator(SourceAble source) {
        this.source = source;
    }

    @Override
    public void method() {
        source.method();
        System.out.println("Decorator implements sourceAble");
    }
}
